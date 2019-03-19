package design_patterns.chain_of_responsibility_pattern.log;

/**
 * created by huyanshi on 2019/3/19
 */
public class WarnLogHandler extends AbstractLogHandler {

  public WarnLogHandler( ) {
    this.levelEnum = LevelEnum.WARN;
  }

  @Override
  void consumeLog(String content) {
    System.out.println(content);
    //写入文件
    System.out.println("我是WARN,不仅打印了还写入文件了.");
  }
}
