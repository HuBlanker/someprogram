package com.huyan.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.nio.file.FileSystems;

public class Index {

    public static void main(String[] args) {

        try {
            long pre = System.currentTimeMillis();
            new Index().testCreateIndex();
            new Index().testSearcher();
            System.out.println(System.currentTimeMillis() - pre);
        } catch (Exception e) {
            System.exit(2);
        }
    }


    /**
     * 使用IndexWriter对数据创建索引
     *
     * @throws IOException
     */
    public void testCreateIndex() throws IOException {
        // 索引存放的位置...
        Directory d = FSDirectory.open(FileSystems.getDefault().getPath("/Users/pfliu/study/someprogram/lucene-demo/indexDir"));

        // 索引写入的配置
        Version matchVersion = Version.LUCENE_8_0_0;// lucene当前匹配的版本
        Analyzer analyzer = new StandardAnalyzer();// 分词器
        IndexWriterConfig conf = new IndexWriterConfig(analyzer);
        // 构建用于操作索引的类
        IndexWriter indexWriter = new IndexWriter(d, conf);

        // 通过IndexWriter来创建索引
        // 索引库里面的数据 要遵守一定的结构（索引结构，document）
        Document doc = new Document();
        /**
         * 1.字段的名称 2.该字段的值 3.字段在数据库中是否存储
         * StringField是一体的
         * TextField是可分的
         */
        IndexableField title = new StringField("title", "java培训零基础开始 从入门到精通",
                Field.Store.YES);
        IndexableField content = new TextField(
                "content",
                "java培训，中软国际独创实训模式，三免一终身，学java多项保障让您无后顾之忧。中软国际java培训，全日制教学，真实项目实战，名企定制培训，四个月速成java工程师!",
                Field.Store.YES);

        doc.add(title);
        doc.add(content);
        // document里面也有很多字段
        indexWriter.addDocument(doc);

        indexWriter.close();
    }


    public void testSearcher() throws IOException {
        // 索引存放的位置...
        Directory d = FSDirectory.open(FileSystems.getDefault().getPath("/Users/pfliu/study/someprogram/lucene-demo/indexDir"));

        // 通过indexSearcher去检索索引目录
        IndexReader indexReader = DirectoryReader.open(d);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        // 这是一个搜索条件，根据这个搜索条件我们来进行查找
        // term是根据哪个字段进行检索，以及字段对应值
        //================================================
        //注意：这样是查询不出，只有单字才能查询出来
        Query query = new TermQuery(new Term("title", "培训"));

        // 搜索先搜索索引目录
        // 找到符合条件的前100条数据
        TopDocs topDocs = indexSearcher.search(query, 100);
        System.out.println("总记录数：" + topDocs.totalHits);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            //得分采用的是VSM算法
            System.out.println("相关度得分：" + scoreDoc.score);
            //获取查询结果的文档的惟一编号，只有获取惟一编号，才能获取该编号对应的数据
            int doc = scoreDoc.doc;
            //使用编号，获取真正的数据
            Document document = indexSearcher.doc(doc);
            System.out.println(document.get("id"));
            System.out.println(document.get("title"));
            System.out.println(document.get("content"));
        }
    }

    public void modifyha() {

        return;
    }

    public int tetha() {
        return 1;

    }

}
