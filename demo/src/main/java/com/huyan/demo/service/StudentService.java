// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.huyan.demo.dao.StudentDao;
import com.huyan.demo.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by huyanshi on 2018/12/21
 */
@Service
public class StudentService {

  @Resource
  private StudentDao studentDao;

  public List<Student> findAll() {
    return studentDao.findAll();
  }

  public String test() {
    JSONObject result = new JSONObject();

    //插入一条数据
    result.put("create a student",
        studentDao.save(Student.builder().name("test1").age(19).classNum(10).build()));

    //根据主键查找
    result.put("select by one param", studentDao.findById(1));

    //根据一个条件查询,且查询条件为大于
    result.put("select by a param after", studentDao.findByAgeAfter(10));

    //根据两个相等条件查询
    result.put("select by two param", studentDao.findByAgeAndClassNum(18, 5));

    //根据一个条件查询,另一个条件排序
    result.put("select by a param order ", studentDao.findByAgeOrderByCreatedAt(18));

    List<Student> ha = studentDao.findByAgeOrderByCreatedAt(18);
    //删除
//    studentDao.deleteById(4);

    result.put("update by id", studentDao.updateNameAndAgeAndClassNumById("ttt", 21, 1, 2));

    return result.toJSONString();


  }
}
