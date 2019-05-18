package com.huyan.lucenedemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.huyan.lucenedemo.Model.SearchArticleVO;
import com.huyan.lucenedemo.index.Index;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    public String search(@RequestParam String target, @RequestParam("callback") String callback) throws IOException, InvalidTokenOffsetsException {
        List<SearchArticleVO> vos = index.search(target);
        return callback + "(" + JSONObject.toJSONString(vos) + ")";
//        return JSONObject.toJSONString(vos);
    }
}
