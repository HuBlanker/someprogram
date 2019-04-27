package mian;

import org.kohsuke.args4j.Option;

/**
 * Created by pfliu on 2019/04/07.
 */
public class TestAbstractMain extends AbstractMain {

    @Option(name = "-test", usage = "test")
    private String help;

    @Override
    public void run() {
        logger.info(help);
    }

    public static void main(String[] args) {
        new TestAbstractMain().parseArgsAndRun(args);
    }
}
