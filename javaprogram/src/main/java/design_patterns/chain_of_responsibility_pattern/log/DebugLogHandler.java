package design_patterns.chain_of_responsibility_pattern.log;

/**
 * created by huyanshi on 2019/3/19
 */
public class DebugLogHandler extends AbstractLogHandler {

  public DebugLogHandler() {
    this.levelEnum = LevelEnum.DEBUG;
  }

  @Override
  void consumeLog(String content) {
    //不做处理
    System.out.println("我是DEBUG,没有做处理");
  }
}
