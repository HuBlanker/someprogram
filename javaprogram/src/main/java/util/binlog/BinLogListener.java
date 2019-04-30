package util.binlog;

@FunctionalInterface
public interface BinLogListener {

    void onEvent(LogItem item);
}
