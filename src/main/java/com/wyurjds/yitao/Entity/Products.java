package com.wyurjds.yitao.Entity;


import java.sql.Timestamp;

public class Products {

  private Long productId;
  private long secondCategoryId;
  private String sellerId;
  private String productTitle;
  private double productPrice;
  private String productIntroduce;
  private String productUrl;
  private Long productStatus;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private String placeOfTransaction;

  public String getPlaceOfTransaction() {
    return placeOfTransaction;
  }

  public void setPlaceOfTransaction(String placeOfTransaction) {
    this.placeOfTransaction = placeOfTransaction;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public long getSecondCategoryId() {
    return secondCategoryId;
  }

  public void setSecondCategoryId(long secondCategoryId) {
    this.secondCategoryId = secondCategoryId;
  }

  public String getSellerId() {
    return sellerId;
  }

  public void setSellerId(String sellerId) {
    this.sellerId = sellerId;
  }

  public String getProductTitle() {
    return productTitle;
  }

  public void setProductTitle(String productTitle) {
    this.productTitle = productTitle;
  }

  public double getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(double productPrice) {
    this.productPrice = productPrice;
  }

  public String getProductIntroduce() {
    return productIntroduce;
  }

  public void setProductIntroduce(String productIntroduce) {
    this.productIntroduce = productIntroduce;
  }

  public String getProductUrl() {
    return productUrl;
  }

  public void setProductUrl(String productUrl) {
    this.productUrl = productUrl;
  }

  public Long getProductStatus() {
    return productStatus;
  }

  public void setProductStatus(Long productStatus) {
    this.productStatus = productStatus;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime = updateTime;
  }
}
