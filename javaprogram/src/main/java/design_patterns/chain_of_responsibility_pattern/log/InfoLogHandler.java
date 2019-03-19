package design_patterns.chain_of_responsibility_pattern.log;

/**
 * created by huyanshi on 2019/3/19
 */
public class InfoLogHandler extends AbstractLogHandler {

  public InfoLogHandler( ) {
    this.levelEnum = LevelEnum.INFO;
  }

  @Override
  void consumeLog(String content) {
    System.out.println(content);
    System.out.println("我是INFO,直接打印完事了");

  }
}
