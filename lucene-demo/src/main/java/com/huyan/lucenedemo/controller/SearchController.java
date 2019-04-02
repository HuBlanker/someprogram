package com.huyan.lucenedemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huyan.lucenedemo.Model.SearchArticleVO;
import com.huyan.lucenedemo.index.Index;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;
import java.util.List;

/**
 * Created by pfliu on 2019/03/31.
 */
@RestController
@RequestMapping("/blog/search")
public class SearchController {

    @Resource
    private Index index;

    @GetMapping()
    public String search(@RequestParam String target, @RequestParam("callback") String callback) throws IOException {
        List<SearchArticleVO> vos = index.search(target);
        return callback + "(" + JSONObject.toJSONString(vos) + ")";
    }
}
