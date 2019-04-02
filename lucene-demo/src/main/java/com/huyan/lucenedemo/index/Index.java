package com.huyan.lucenedemo.index;

import com.huyan.lucenedemo.Model.SearchArticleVO;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.lionsoul.jcseg.analyzer.JcsegAnalyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Index {

    private static final String TAGS_KEY = "tags";
    private static final String CATEGORIES_KEY = "categories";
    private static AtomicInteger FILE_NUM = new AtomicInteger(0);

    @Value("${blog.path}")
    private String blogPath;
    @Value("${index.path}")
    private String indexPath;

    private static final Logger logger = LoggerFactory.getLogger(Index.class);

    /**
     * 使用IndexWriter对数据创建索引
     *
     * @throws IOException
     */
    public void create() throws IOException {

        if (deleteAllIndex()) {
            logger.info("clear the index.");
        } else {
            logger.info("cleat the index error, stop create index.");
            return;
        }

        // 索引存放的位置...
        Directory d = FSDirectory.open(FileSystems.getDefault().getPath(indexPath));

        logger.info("start create index for blog.");
        // 索引写入的配置
        Analyzer analyzer = new JcsegAnalyzer(1);// 分词器
        IndexWriterConfig conf = new IndexWriterConfig(analyzer);
        // 构建用于操作索引的类
        IndexWriter indexWriter = new IndexWriter(d, conf);
        int curFileNum = FILE_NUM.get();
        findFile(blogPath, indexWriter);
        logger.info("add {} file into index.", FILE_NUM.get() - curFileNum);

        indexWriter.close();
    }

    private boolean deleteAllIndex() {
        File indexDir = new File(indexPath);
        if (indexDir.isDirectory()) {
            File[] files = indexDir.listFiles();
            if (files == null || files.length == 0) {
                logger.info("index dir is em[ty.");
                return true;
            }
            for (File file : files) {
                if (!file.delete()) {
                    logger.info("delete some index error, file = {}", file.getAbsolutePath());
                    return false;
                }
            }
            return true;
        }
        logger.info("delete index error, because the file is not a dir.");
        return false;
    }

    private void findFile(String blogPath, IndexWriter indexWriter) throws IOException {
        File file = new File(blogPath);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files == null || files.length == 0) {
                logger.info("this file is empty, path = {}", file.getAbsolutePath());
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        logger.info(" {} is a directory, find in it.", file2.getAbsolutePath());
                        findFile(file2.getAbsolutePath(), indexWriter);
                    } else {
                        if (file2.getName().endsWith(".md")) {
                            logger.info("find a md file = {} , make index", file2.getAbsolutePath());
                            FILE_NUM.incrementAndGet();
                            addFile(indexWriter, file2);
                        }
                    }
                }
            }
        } else {
            logger.warn("file is not exist");
        }
    }

    private void addFile(IndexWriter indexWriter, File file) throws IOException {
        // 通过IndexWriter来创建索引
        // 索引库里面的数据 要遵守一定的结构（索引结构，document）
        Document doc = new Document();
        /**
         * 1.字段的名称 2.该字段的值 3.字段在数据库中是否存储
         * StringField是一体的
         * TextField是可分的
         */
        String titleValue = file.getName().replace(".md", "");
        IndexableField title = new TextField("title", titleValue, Field.Store.YES);

        String contentValue = readToString(file);
        IndexableField content = new TextField(
                "content", contentValue, Field.Store.YES);

        Map<String, List<String>> profiles = getTagsAndCategoriesFromContent(file, contentValue);

        List<String> tagList = profiles.get(TAGS_KEY);
        String tagStr = String.join(",", tagList);
        IndexableField tags = new TextField("tags", tagStr, Field.Store.YES);

        List<String> categoriesList = profiles.get(CATEGORIES_KEY);
        String categoriesStr = String.join(",", categoriesList);
        IndexableField categories = new TextField("categories", categoriesStr, Field.Store.YES);


        doc.add(title);
        doc.add(content);
        doc.add(tags);
        doc.add(categories);
        // document里面也有很多字段
        indexWriter.addDocument(doc);
    }


    public List<SearchArticleVO> search(String target) throws IOException {

        List<SearchArticleVO> result = new ArrayList<>();
        String[] fields = {"title", "tags", "content"};
        for (String field : fields) {
            paddingResultByField(target, result, field);
            if (result.size() >= 10) {
                break;
            }
        }

        return result;
    }

    private void paddingResultByField(String target, List<SearchArticleVO> result, String field) throws IOException {
        // 索引存放的位置...
        Directory d = FSDirectory.open(FileSystems.getDefault().getPath(indexPath));

        // 通过indexSearcher去检索索引目录
        IndexReader indexReader = DirectoryReader.open(d);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        // 这是一个搜索条件，根据这个搜索条件我们来进行查找
        // term是根据哪个字段进行检索，以及字段对应值
        //================================================
        Query query = new TermQuery(new Term(field, target));

        // 搜索先搜索索引目录
        // 找到符合条件的前100条数据
        TopDocs topDocs = indexSearcher.search(query, 100);
        logger.info("search keyword = {}, getNum = {}", target, topDocs.totalHits);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            //得分采用的是VSM算法
            logger.info("score = {}", scoreDoc.score);
            //获取查询结果的文档的惟一编号，只有获取惟一编号，才能获取该编号对应的数据
            int doc = scoreDoc.doc;
            //使用编号，获取真正的数据
            Document document = indexSearcher.doc(doc);

            String title = document.get("title").substring(11);
            logger.info("get article name = {}", title);

            String tagStr = document.get("tags");
            String content = document.get("content");
            String categoriesStr = document.get("categories");

            List<String> tagList = Stream.of(tagStr.split(",")).collect(Collectors.toList());
            List<String> caList = Stream.of(categoriesStr.split(",")).collect(Collectors.toList());


            String cateUrl = String.join("/", caList) + "/";


            String dateUrl = document.get("title").substring(0, 11).replace("-", "/");


            String url = "http://huyan.couplecoders.tech/" + cateUrl.toLowerCase() + dateUrl + title;

            int firstIndex = content.indexOf(target);

            String targetStr = content.substring(firstIndex - 15 < 0 ? 0 : firstIndex - 15, firstIndex + 15 > content.length() ? content.length() - 1 : firstIndex + 15).replaceAll("\n", "");

            result.add(SearchArticleVO.builder()
                    .title(title).content(content)
                    .tags(tagList)
                    .url(url)
                    .categories(caList)
                    .targetStr(targetStr)
                    .build());

        }
    }

    private Map<String, List<String>> getTagsAndCategoriesFromContent(File file, String content) {
        Map<String, List<String>> map = new HashMap<>();

        Pattern r = Pattern.compile("---\n.*---\n", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = r.matcher(content);
        if (m.find()) {
            String s = m.group();

            //tag
            List<String> tags = new ArrayList<>();
            Pattern p1 = Pattern.compile("- .*\n");
            Matcher m1 = p1.matcher(s);
            while (m1.find()) {
                tags.add(m1.group(0).replace("\n", "").replace("- ", ""));
            }
            map.put(TAGS_KEY, tags);
            logger.info("load {} tags from {} done.", tags.size(), file.getAbsolutePath() + file.getName());

            //category
            List<String> categories = new ArrayList<>();
            Pattern p2 = Pattern.compile("category:.*\n");
            Matcher m2 = p2.matcher(s);
            while (m2.find()) {
                List<String> tmp = Stream.of(m2.group()
                        .replace("category: ", "")
                        .replace("]", "")
                        .replace("\n", "")
                        .replace("[", "")
                        .split(",")).collect(Collectors.toList());
                categories.addAll(tmp);
            }
            map.put(CATEGORIES_KEY, categories);
            logger.info("load {} categories from {} done.", categories.size(), file.getAbsolutePath() + file.getName());

        } else {
            logger.warn("not match tags or categories from {}, warning.", file.getAbsolutePath() + file.getName());
        }


        return map;
    }


    private static String readToString(File file) {
        Long fileLength = file.length();     //获取文件长度
        byte[] fileContent = new byte[fileLength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(fileContent);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(fileContent);//返回文件内容,默认编码
    }

}
