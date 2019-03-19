package com.huyan.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * created by huyanshi on 2019/1/20
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  CheckSourceInterceptor checkSourceInterceptor = new CheckSourceInterceptor();

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(checkSourceInterceptor).addPathPatterns("/status");
  }

}
