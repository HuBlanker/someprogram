// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo.aspect;

import com.huyan.demo.protocol.BaseError;
import com.huyan.demo.protocol.BaseResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * created by pfliu on 2018/11/12
 */
@Aspect
@Component
public class ExceptionAspect {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * 在方法调用之前，打印入参
   */
  @Before(value = "execution(public * com.huyan.demo.controller.*.*(..))")
  public void before(JoinPoint joinPoint) {
    String className = joinPoint.getTarget().getClass().getName();
    String methodName = joinPoint.getSignature().getName();
    Object[] args = joinPoint.getArgs();
    StringBuilder params = new StringBuilder();
    for (Object arg : args) {
      params.append(arg).append(" ");
    }
    logger.info(className + "的" + methodName + "入参为：" + params.toString());
  }

  /**
   * 过程中监测，catch到异常之后返回包装后的错误信息，并打印日志
   */
  @Around(value = "execution(public * com.huyan.demo.controller.*.*(..))")
  public BaseResponse catchException(ProceedingJoinPoint joinPoint) {
    try {
      BaseResponse baseResponse = new BaseResponse(BaseError.SUCCESS);
      baseResponse.result = joinPoint.proceed();
      return baseResponse;
    } catch (Throwable e) {
      String className = joinPoint.getTarget().getClass().getName();
      String methodName = joinPoint.getSignature().getName();
      logger.warn("在" + className + "的" + methodName + "中，发生了异常：" + e);
      return new BaseResponse(BaseError.FAIL);
    }
  }

  /**
   * 返回之后，打印出参
   */
  @AfterReturning(value = "execution(public * com.huyan.demo.controller.*.*(..))", returning = "returnVal")
  public void afterReturin(JoinPoint joinPoint, Object returnVal) {
    String className = joinPoint.getTarget().getClass().getName();
    String methodName = joinPoint.getSignature().getName();
    logger.info(className + "的" + methodName + "结果为：" + returnVal.toString());
  }

}
