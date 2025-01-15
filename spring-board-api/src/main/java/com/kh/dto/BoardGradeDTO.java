package com.kh.dto;

import org.apache.ibatis.type.Alias;

@Alias("grade")
public class BoardGradeDTO {
  private int no;
  private String name;

  public BoardGradeDTO() {
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}