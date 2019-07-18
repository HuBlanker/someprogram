package com.huyan.lucenedemo;

import org.apache.lucene.index.*;
import org.apache.lucene.search.DoubleValues;
import org.apache.lucene.search.DoubleValuesSource;

import java.io.IOException;

/**
 * Created by pfliu on 2019/07/09.
 */
public class Testdoublesource extends DoubleValuesSource {

    @Override
    public DoubleValues getValues(LeafReaderContext leafReaderContext, DoubleValues doubleValues) throws IOException {
        final NumericDocValues idDv = DocValues.getNumeric(leafReaderContext.reader(), "id");

        return new DoubleValues() {
            @Override
            public double doubleValue() throws IOException {
                System.out.println((float) doubleValues.doubleValue());
                return doubleValues.doubleValue() * 10.2342f;
            }

            @Override
            public boolean advanceExact(int i) throws IOException {
                return idDv.advanceExact(i);
            }
        };
    }

    @Override
    public boolean needsScores() {
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public String toString() {
        return "source";
    }
}
