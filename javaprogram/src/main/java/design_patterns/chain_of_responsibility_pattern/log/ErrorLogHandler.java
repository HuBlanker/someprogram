package design_patterns.chain_of_responsibility_pattern.log;

/**
 * created by huyanshi on 2019/3/19
 */
public class ErrorLogHandler extends AbstractLogHandler{

  public ErrorLogHandler() {
    this.levelEnum = LevelEnum.ERROR;
  }

  @Override
  void consumeLog(String content) {
    System.out.println(content);
    System.out.println("我是ERROR,不仅打印了还写入文件了还发了个邮件.");

  }
}
