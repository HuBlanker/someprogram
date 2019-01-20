// Copyright 2018 Mobvoi Inc. All Rights Reserved.

package com.huyan.demo.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by huyanshi on 2018/12/21
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

  @Id
  private int id;

  private String name;

  private int classNum;

  private  int age;

  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;
}
