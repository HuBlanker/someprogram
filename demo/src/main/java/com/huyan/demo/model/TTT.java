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
 * created by huyanshi on 2018/12/27
 */
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Entity
@Table(name = "ttt")
public class TTT {

  @Id
  private int id;

  private String wwid;
  private String category;
  private String key;
  private String value;
  private String page;
  private String button;
  private String event;


  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

}
