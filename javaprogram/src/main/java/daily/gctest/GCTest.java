package daily.gctest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by pfliu on 2019/04/27.
 */
public class GCTest {
    private static final Logger logger = LoggerFactory.getLogger(GCTest.class);

    public static void main(String[] args) throws InterruptedException {
        //2小时的秒数
//        System.out.println(TimeUnit.HOURS.toSeconds(2));
//        // 25小时的天数
//        System.out.println(TimeUnit.HOURS.toDays(25));
//        // 2秒的毫秒数
//        System.out.println(TimeUnit.SECONDS.toMillis(2));
        testPeriod();
        testDuration();
    }

    public static void testPeriod() {
//
//        LocalDate now = LocalDate.now();
//        LocalDate birthday = LocalDate.of(1990, 2, 2);
//        Period p = Period.between(birthday, now);
//        long x = ChronoUnit.DAYS.between(birthday, now);
//        System.out.println(String.format("%d years %d months %d days. total %d day.", p.getYears(), p.getMonths(), p.getDays(), x));
//
//        // 检查两个日期的大小,如果前面的大于后面的,返回值为true.
//        System.out.println(p.isNegative());
    }

    public static void testDuration() {
        Duration d = Duration.between(LocalDateTime.of(2019, 7, 21, 1, 1, 1), LocalDateTime.now());
        // 总小时数量
        System.out.println(d.toHours());
        // 总毫秒数
        System.out.println(d.toMillis());
        // 是否前面的时间大于后面的时间
        System.out.println(d.isNegative());
    }
}
