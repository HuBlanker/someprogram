// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo.dao;

import com.huyan.demo.model.Student;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * created by huyanshi on 2018/12/21
 */
@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

    //查询所有
    List<Student> findAll();

    //查询年龄大于传入值得
    List<Student> findByAgeAfter(int age);

    //查询年龄和班级等于入参的
    List<Student> findByAgeAndClassNum(int age, int classNum);

    //查询年龄为入参的学生,且结果按照创建时间排序
    List<Student> findByAgeOrderByCreatedAt(int age);

    //根据主键更新实体的名字年龄及班级
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE Student SET name = :name, classNum = :classNum, "
            + "age = :age WHERE id = :id ")
    int updateNameAndAgeAndClassNumById(@Param("name") String name, @Param("age") int age,
                                        @Param("classNum") int classNum, @Param("id") int id);

}
