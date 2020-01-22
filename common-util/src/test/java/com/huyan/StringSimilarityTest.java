package com.huyan;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StringSimilarityTest {

    @Test
    public void jaccard() {

        Assert.assertEquals(1.0f, StringSimilarity.jaccard(null, null), 0f);
        Assert.assertEquals(0.3333333432674408f, StringSimilarity.jaccard("AB", "AC"), 0f);
        Assert.assertEquals(0.75f, StringSimilarity.jaccard("呼延十", "呼延十二"), 0f);
        Assert.assertEquals(0.6666666f, StringSimilarity.Levenshtein("呼延十", "呼延二"), 0f);

        Assert.assertEquals(0.70710677f, StringSimilarity.cos("apple", "app"), 0f);
        Assert.assertEquals(0.8944272f, StringSimilarity.cos("呼延十二", "呼延二十三"), 0f);
        Assert.assertEquals(0.0f, StringSimilarity.cos("数据工程", "日本旅游"), 0f);

        Assert.assertEquals(0.0f, StringSimilarity.hamming("java开发", "大过年的干啥"), 0f);
        Assert.assertEquals(0.6666667f, StringSimilarity.hamming("大过年的吃肉", "大过年的干啥"), 0f);

        List<Integer> aa = new ArrayList<>();
        aa.add(1);
        aa.add(2);
        remo(aa);
        System.out.println(aa.size());
    }

    private void remo(List<Integer> aa) {
        aa.remove(1);
    }
}