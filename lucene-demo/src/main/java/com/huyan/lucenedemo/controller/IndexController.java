package com.huyan.lucenedemo.controller;

import com.huyan.lucenedemo.access.NginxLogListener;
import com.huyan.lucenedemo.index.Index;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by pfliu on 2019/03/31.
 */
@RestController
@RequestMapping("/blog/index")
public class IndexController {

    @Resource
    private Index index;

    @GetMapping("/rebuild")
    public String indexRebuild() throws IOException {
        index.create();
        return "done";
    }

}
