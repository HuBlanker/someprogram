// Copyright 2017 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo.protocol;

/**
 * Created by pfliu on 17-6-21.
 */
public enum BaseError {
  SUCCESS(0, "success"),
  FAIL(1, "fail"),
  UNKOWN(1, "unknow error");
  public int code;
  public String enMsg;

  BaseError(int code, String enMsg) {
    this.code = code;
    this.enMsg = enMsg;
  }

  public int getCode() {
    return this.code;
  }

  public String getEnMsg() {
    return this.enMsg;
  }
}
