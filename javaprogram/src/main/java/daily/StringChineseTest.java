package daily;

import com.huyan.StringUtils;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.huyan.StringUtils.containChinese;

/**
 * Created by pfliu on 2019/09/09.
 */
public class StringChineseTest {
    public static void main(String[] args) throws InterruptedException, BadHanyuPinyinOutputFormatCombination {
        Arrays.asList("Huyan", "Hello", "Coder", "Hi", "Hell", "Intellij")
                .stream()
                .filter(s -> s.startsWith("H"))
                .map(s -> s.substring(2))
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("the hook is done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        System.out.println(containChinese("wodaodafdaf"));
        System.out.println(containChinese("我的世界"));
        System.out.println(containChinese("我的adfafadf"));



        String 城市之光 = StringUtils.getPinyin("城市之光");
        System.out.println(城市之光);

    }

}
