// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo.dao;

import com.huyan.demo.model.TTT;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * created by huyanshi on 2018/12/27
 */
@Repository
public interface TTTDao extends JpaRepository<TTT, Integer> {

  @Query(value = "insert into ttt(`key`,`value`,`button`,`page`,`category`,`wwid`,`event`) values(?1,?2,?3,?4,?5,?6,?7)", nativeQuery = true)
  @Modifying(clearAutomatically = true)
  @Transactional
  void save1(String key, String value, String button, String page, String category, String wwid,
      String event);
}
