package com.huyan.lucenedemo;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pfliu on 2019/08/07.
 */
public class EnglishAnalyzerTest {


    public static List<String> seg(Analyzer an, String text, String field) {
        if (text == null || text.isEmpty()) return new ArrayList<>();
        List<String> ret = new ArrayList<>(4);

        try (TokenStream ts = an.tokenStream(field, text)) {
            ts.reset();
            CharTermAttribute c = ts.getAttribute(CharTermAttribute.class);
            while (ts.incrementToken()) {
                if (c.length() > 0) {
                    String term = new String(c.buffer(), 0, c.length());
                    ret.add(term);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }


    @Test
    public void  t() {
        System.out.println(seg(new StandardAnalyzer(),"i found a  the students",""));
    }
}
