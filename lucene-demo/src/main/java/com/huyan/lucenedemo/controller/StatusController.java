package com.huyan.lucenedemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pfliu on 2019/03/30.
 */
@RestController
public class StatusController {


    @GetMapping("/status")
    public String mm() {
        return "string";
    }
}
