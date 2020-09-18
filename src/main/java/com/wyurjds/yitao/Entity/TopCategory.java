package com.wyurjds.yitao.Entity;


public class TopCategory {

  private long topCategoryId;
  private String topCategoryName;
  private String categoryPicUrl;

  public String getCategoryPicUrl() {
    return categoryPicUrl;
  }

  public void setCategoryPicUrl(String categoryPicUrl) {
    this.categoryPicUrl = categoryPicUrl;
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

}
