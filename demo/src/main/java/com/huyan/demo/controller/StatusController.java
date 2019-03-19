package com.huyan.demo.controller;

import com.huyan.demo.config.CheckSource;
import com.huyan.demo.service.AnalyticsService;
import java.util.Random;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by pfliu on 2018/9/2
 */
@RestController
public class StatusController {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Resource
  private AnalyticsService analyticsService;

  @CheckSource(sources = {"huyan", "huihui"})
  @GetMapping(value = "/status")
  public Object status(@RequestParam("source") String source) {
    return "哈哈哈";
  }

  public static Random random = new Random();

  @Async
  public void doTaskOne() throws Exception {
    Thread t = Thread.currentThread();
    String name = t.getName();
    System.out.println("开始做任务一");
    long start = System.currentTimeMillis();
    Thread.sleep(random.nextInt(10000));
    long end = System.currentTimeMillis();
    System.out.println("完成任务一，耗时：" + (end - start) + "毫秒" + "使用线程：" + name);
  }

  public void doTaskTwo() throws Exception {
    Thread t = Thread.currentThread();
    String name = t.getName();
    System.out.println("开始做任务二");
    long start = System.currentTimeMillis();
    Thread.sleep(random.nextInt(10000));
    long end = System.currentTimeMillis();
    System.out.println("完成任务二，耗时：" + (end - start) + "毫秒" + "使用线程：" + name);
  }

  public void doTaskThree() throws Exception {
    Thread t = Thread.currentThread();
    String name = t.getName();
    System.out.println("开始做任务三");
    long start = System.currentTimeMillis();
    Thread.sleep(random.nextInt(10000));
    long end = System.currentTimeMillis();
    System.out.println("完成任务三，耗时：" + (end - start) + "毫秒" + "使用线程：" + name);
  }


}
