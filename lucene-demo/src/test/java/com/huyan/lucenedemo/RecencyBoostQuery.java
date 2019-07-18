package com.huyan.lucenedemo;


import org.apache.lucene.index.DocValues;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.NumericDocValues;
import org.apache.lucene.queries.CustomScoreProvider;
import org.apache.lucene.queries.CustomScoreQuery;
import org.apache.lucene.search.Query;

import java.io.IOException;


/**
 * Created by feng on 3/8/14.
 */
public class RecencyBoostQuery extends CustomScoreQuery {


    public RecencyBoostQuery(Query subQuery) {
        super(subQuery);
    }

    @Override
    protected CustomScoreProvider getCustomScoreProvider(LeafReaderContext context) throws IOException {
        return new RecencyBooster(context, DocValues.getNumeric(context.reader(), "id"));
    }

}


class RecencyBooster extends CustomScoreProvider {
    protected NumericDocValues idDv;

    public RecencyBooster(LeafReaderContext context, NumericDocValues idDv) {
        super(context);
        this.idDv = idDv;
    }

    @Override
    public float customScore(int doc, float subQueryScore, float valSrcScore)
            throws IOException {
        idDv.advanceExact(doc);
        int jid = (int) idDv.longValue();

        System.out.println(subQueryScore);

        System.out.println(jid);
        return subQueryScore * 10.2342f;
    }
}
