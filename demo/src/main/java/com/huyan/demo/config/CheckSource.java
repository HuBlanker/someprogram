package com.huyan.demo.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * created by huyanshi on 2019/1/20
 */
@Target(ElementType.METHOD) // 该注解使用在方法上
@Retention(RetentionPolicy.RUNTIME) //运行时注解
@Documented
public @interface CheckSource {
  //该注解的参数,是一个string数组
  String[] sources() default {"all"};

}
