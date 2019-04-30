package util;

import java.util.ArrayList;
import java.util.List;

public class Ticker {

    private final List<T> tags = new ArrayList<>(2);

    private final long start;
    private long last;
    private long end;

    public Ticker() {
        start = System.currentTimeMillis();
        last = start;
    }

    public void tack() {
        last = System.currentTimeMillis();
    }

    public void tick(String tag) {
        long now = System.currentTimeMillis();
        tags.add(new T(tag, (int) (now - last)));
        last = now;
    }

    public int total() {
        if (end == 0)
            end = System.currentTimeMillis();
        return (int) (end - start);
    }

    public long getBegin() {
        return start;
    }

    @Override
    public String toString() {
        return summary();
    }

    private String summary() {
        end = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(32);
        for (T tag : tags) {
            sb.append(tag.tag).append(" ").append(tag.since).append("ms, ");
        }

        sb.append("total ");
        if ((end - start) < 10000) {
            sb.append(end - start).append("ms");
        } else {
            sb.append((end - start) / 1000).append("s");
        }
        return sb.toString();
    }

    static class T {
        final String tag;
        final int since;

        T(String tag, int since) {
            this.tag = tag;
            this.since = since;
        }
    }

    private static void db() throws InterruptedException {
        Thread.sleep(1000);
    }

    private static void col() {
        for (int i = 0; i < 10000; ++i) {
            int j = i;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Ticker ticker = new Ticker();
        db();
        ticker.tick("db");
        col();
        ticker.tick("col");
        System.out.println(ticker.toString());
    }
}

