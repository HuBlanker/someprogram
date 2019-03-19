package design_patterns.chain_of_responsibility_pattern.log;

/**
 * created by huyanshi on 2019/3/19
 */
public abstract class AbstractLogHandler {

  public LevelEnum levelEnum;

  private AbstractLogHandler nextHandler;

  public void setNextHandler(
      AbstractLogHandler nextHandler) {
    this.nextHandler = nextHandler;
  }

  public void handlerRequest(LogInfo info) {
    if (null == info) {
      return;
    }
    if (this.levelEnum.equals(info.levelEnum)) {
      this.consumeLog(info.content);
    } else {
      if (this.nextHandler != null) {
        this.nextHandler.handlerRequest(info);
      } else {
        return;
      }
    }
  }

  abstract void consumeLog(String content);

}
