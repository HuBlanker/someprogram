// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo.controller;

import com.huyan.demo.protocol.BaseError;
import com.huyan.demo.protocol.BaseResponse;
import com.huyan.demo.service.AnalyticsService;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by pfliu on 2018/9/9
 */
@RestController
public class AnalyticsController {

  private Logger logger = LoggerFactory.getLogger(this.getClass());


  private final AnalyticsService analyticsService;

  @Autowired
  public AnalyticsController(AnalyticsService analyticsService) {
    this.analyticsService = analyticsService;
  }


  @GetMapping(value = "string-analytics")
  public String stringAnalytics() {

    Map<String, Map<String, String>> result = analyticsService.stringAnalytics();
    return "index";
  }


//  @GetMapping(value = "kmp")
//  public BaseResponse kmp(@RequestParam("big") String big, @RequestParam("small") String small) {
//    logger.info("kmp request,big=%s,small=%s", big, small);
//    BaseResponse baseResponse = new BaseResponse();
//    try {
//      baseResponse.money = analyticsService.stringIndex(big, small);
//    } catch (Exception e) {
//      logger.info("kmp error,error=%s", e);
//      return new BaseResponse(BaseError.FAIL);
//    }
//    logger.info("kmp response,money=%s", baseResponse);
//    return baseResponse;
//  }

  @GetMapping(value = "kmp")
  public Object kmp(@RequestParam("big") String big, @RequestParam("small") String small) {
    throw new NullPointerException();
  }

  @GetMapping(value = "rotateString")
  public String rotateString(@RequestParam String string, @RequestParam int offset) {
    String s = analyticsService.stringRotate(string, offset);
    return "index";
  }

  @GetMapping(value = "rotateInt")
  public String rotateInt(@RequestParam int n) {
    int s = analyticsService.rotateInt(n);
    return "index";
  }

  @GetMapping(value = "singleNumber")
  public String singleNumber(@RequestParam int[] A) {
    int s = analyticsService.singleNumber(A);
    return "index";
  }
}
