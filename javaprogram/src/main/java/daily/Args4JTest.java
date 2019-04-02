package daily;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.util.ArrayList;
import java.util.List;

import static org.kohsuke.args4j.OptionHandlerFilter.ALL;

/**
 * Created by pfliu on 2019/04/01.
 */
public class Args4JTest {

    @Option(name = "-bool", usage = "test a bool")
    private boolean testBool;

    @Option(name = "-string", usage = "test a string")
    private String testString;

    @Argument
    private List<String> arguments = new ArrayList<String>();

    public static void main(String[] args) {
        new Args4JTest().doMain(args);
    }

    private void doMain(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        parser.setUsageWidth(80);

        try {
            parser.parseArgument(args);
            if (arguments.isEmpty())
                throw new CmdLineException(parser, "No argument is given");
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java SampleMain [options...] arguments...");
            parser.printUsage(System.err);
            System.err.println();
            System.err.println("  Example: java SampleMain" + parser.printExample(ALL));
            return;
        }
        System.out.println(testBool);
        System.out.println(testString);
    }
}
