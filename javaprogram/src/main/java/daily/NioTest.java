package daily;

import mian.AbstractMain;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

/**
 * Created by pfliu on 2019/04/28.
 */
public class NioTest extends AbstractMain {

    public static void main(String[] args) {
        new NioTest().parseArgsAndRun(args);
    }

    @Override
    public void run()  {
        Path source = FileSystems.getDefault().getPath("/Users/pfliu/study/test/source");
        Path target = FileSystems.getDefault().getPath("/Users/pfliu/study/test/target");

        try {
            Files.lines(source).forEach(per -> {
                logger.info("line: {}", per);
                try {
                    Files.write(target, Collections.singleton(per), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
