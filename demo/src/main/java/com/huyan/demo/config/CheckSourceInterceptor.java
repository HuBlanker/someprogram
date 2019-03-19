package com.huyan.demo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * created by huyanshi on 2019/1/20
 */
public class CheckSourceInterceptor extends HandlerInterceptorAdapter {

  private static Logger LOG = LoggerFactory.getLogger(CheckSourceInterceptor.class);


  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    if (!(handler instanceof HandlerMethod)) {
      LOG.warn("UnSupport handler");
      throw new IllegalArgumentException("Interceptor only supports HandlerMethod handler");
    }
    //拿到请求参数里面的source参数
    String source = request.getParameter("source");
    String errorMsg = null;
    //如果source为空,返回错误
    if (null == source || "".equals(source)) {
      errorMsg = "No source in params";
    }
    if (errorMsg != null) {
      response.setStatus(500);
      LOG.info(errorMsg);
      response.getWriter().write(errorMsg);
      return false;
    }
    //拿到该方法上的注解对象
    CheckSource checkSource = getCheckSource((HandlerMethod) handler);
    //如果拿到的对象为空,说明没有此注解,直接放行
    if (checkSource != null) {
      //拿到注解对象的属性,即允许通行的source列表
      String[] sources = checkSource.sources();
      if (sources.length == 0 || sources[0].equals("all")) {
        //列表为空或者为默认值,放行
        return true;
      }
      //遍历列表,如果传入的参数在其中,则放行
      for (String s : sources) {
        if (s.equals(source)) {
          return true;
        }
      }
      //如果传入的source参数不在允许的参数列表中,则拦截请求,并返回错误信息
      errorMsg = "source is not support";
      response.getWriter().write(errorMsg);
      return false;
    }
    return true;
  }

  /**
   * 拿到该方法上的checksource注解对象
   */
  private CheckSource getCheckSource(HandlerMethod handlerMethod) {
    if (handlerMethod.getBeanType().isAnnotationPresent(CheckSource.class)) {
      return handlerMethod.getBeanType().getAnnotation(CheckSource.class);
    } else if (handlerMethod.getMethod().isAnnotationPresent(CheckSource.class)) {
      return handlerMethod.getMethod().getAnnotation(CheckSource.class);
    }
    return null;
  }
}
