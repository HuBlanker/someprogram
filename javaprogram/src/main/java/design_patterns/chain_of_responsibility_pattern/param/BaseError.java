package design_patterns.chain_of_responsibility_pattern.param;

/**
 * created by huyanshi on 2019/3/19
 */
public enum BaseError {
  SUCCESS(10000, "成功啦"),
  NAME_TOO_LONG(10001, "你的名字太长了8,不允许."),
  NAME_TOO_SHORT(10002, "你的名字不可以这么短"),
  AGE_TOO_BIG(10003, "千年老妖怪吗?"),
  AGE_TOO_SMALL(10004, "不支持-0.9以下的年龄哦"),
  HIGH_TOO_HIGH(10005, "我不管,姚明最高,再高不行"),
  HIGH_TOO_LOW(10006, "你个lowB,不准用.");

  int errCode;
  String errMsg;

  BaseError(int errCode, String errMsg) {
    this.errCode = errCode;
    this.errMsg = errMsg;
  }

}
