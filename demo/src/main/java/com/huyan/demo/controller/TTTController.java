// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huyan.demo.dao.TTTDao;
import com.huyan.demo.model.TTT;
import java.util.List;
import java.util.stream.Stream;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by huyanshi on 2018/12/27
 */
@RestController
@Component
public class TTTController {

  @Resource
  private TTTDao tttDao;


  @PostMapping("/test")
  public boolean t(@RequestBody String json) {
    String[] ss = json.split("---");
    Stream.of(ss).forEach(this::insert);
    return true;
  }

  private void insert(String s) {
    JSONObject obj = JSON.parseObject(s);

    String wwid = castString(obj.getJSONObject("other_id").getString("wwid"));
    JSONObject properties = obj.getJSONObject("properties");

    String category = castString(properties.getString("_ta_category"));
    String page = castString(properties.getString("_ta_page"));
    String button = castString(properties.getString("_ta_button"));
    String key = castString(properties.getString("_ta_key"));
    String value = castString(properties.getString("_ta_value"));

    String event = castString(obj.getString("event"));

    List<TTT> haha = tttDao.findAll();

    tttDao.save1(key, value, button, page, category, wwid, event);
  }


  private String castString(String s) {
    if (s == null) {
      return "hhh";
    }
    return s;
  }

}
