package com.huyan.lucenedemo;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queries.function.FunctionScoreQuery;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.similarities.ClassicSimilarity;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by pfliu on 2019/07/09.
 */
public class FuncTest {

    Directory ramDirectory;

    @Before
    public void pre() throws IOException {
        ramDirectory = new RAMDirectory();

        IndexWriterConfig conf = new IndexWriterConfig(new StandardAnalyzer());
        conf.setSimilarity(new ClassicSimilarity());

        FieldType fieldType = new FieldType();


        IndexWriter iw = new IndexWriter(ramDirectory, conf);

        fieldType.setTokenized(true);
        fieldType.setStored(true);
        fieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
        fieldType.freeze();

        Document d = new Document();
        d.add(new NumericDocValuesField("id", 1));
        d.add(new Field("name", "huyan", fieldType));

        iw.addDocument(d);

        d = new Document();
        d.add(new NumericDocValuesField("id", 2));
        d.add(new Field("name", "huihui", fieldType));
        iw.addDocument(d);

        d = new Document();
        d.add(new NumericDocValuesField("id", 3));
        d.add(new Field("name", "huy shi", fieldType));
        iw.addDocument(d);


        iw.commit();
        iw.close();

    }


    @Test
    public void h() throws IOException {
        IndexSearcher is = new IndexSearcher(DirectoryReader.open(ramDirectory));

        Query q = new BooleanQuery.Builder().add(new TermQuery(new Term("name", "huyan")), BooleanClause.Occur.SHOULD)
                .add(new TermQuery(new Term("name", "shi")), BooleanClause.Occur.SHOULD).build();
        q = new RecencyBoostQuery(q);

        TopDocs d = is.search(q, 100);
        for (ScoreDoc scoreDoc : d.scoreDocs) {
            System.out.println(scoreDoc.score + ":" + is.doc(scoreDoc.doc));
        }


//        System.out.println("=====");
//        Query q1 = new TermQuery(new Term("name", "huyan"));
//        q1 = new FunctionScoreQuery(q1, new Testdoublesource());
//        TopDocs dd = is.search(q1, 100);
//        for (ScoreDoc scoreDoc : dd.scoreDocs) {
//            System.out.println(scoreDoc.score + ":" + is.doc(scoreDoc.doc));
//        }
    }
}
