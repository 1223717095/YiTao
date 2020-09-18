package com.wyurjds.yitao.Entity;


public class SecondCategory {

  private long secondCategoryId;
  private long topCategoryId;
  private String topCategoryName;
  private String secondCategoryName;


  public long getSecondCategoryId() {
    return secondCategoryId;
  }

  public void setSecondCategoryId(long secondCategoryId) {
    this.secondCategoryId = secondCategoryId;
  }


  public long getTopCategoryId() {
    return topCategoryId;
  }

  public void setTopCategoryId(long topCategoryId) {
    this.topCategoryId = topCategoryId;
  }


  public String getTopCategoryName() {
    return topCategoryName;
  }

  public void setTopCategoryName(String topCategoryName) {
    this.topCategoryName = topCategoryName;
  }


  public String getSecondCategoryName() {
    return secondCategoryName;
  }

  public void setSecondCategoryName(String secondCategoryName) {
    this.secondCategoryName = secondCategoryName;
  }

}
