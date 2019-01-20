// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo.controller;

import com.huyan.demo.model.Student;
import com.huyan.demo.service.StudentService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by huyanshi on 2018/12/21
 */
@RestController
@RequestMapping("/students")
public class StudentController {

  @Resource
  private StudentService studentService;

  @GetMapping()
  public List<Student> all(){
    return studentService.findAll();
  }

  @GetMapping(value = "test")
  public String test(){
    return studentService.test();
  }

}
