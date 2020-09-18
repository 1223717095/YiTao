package com.wyurjds.yitao.Entity;


public class Collection {

  private long productId;
  private String collectorId;
  private java.sql.Timestamp collectionDate;
  private long collectionId;


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public String getCollectorId() {
    return collectorId;
  }

  public void setCollectorId(String collectorId) {
    this.collectorId = collectorId;
  }


  public java.sql.Timestamp getCollectionDate() {
    return collectionDate;
  }

  public void setCollectionDate(java.sql.Timestamp collectionDate) {
    this.collectionDate = collectionDate;
  }


  public long getCollectionId() {
    return collectionId;
  }

  public void setCollectionId(long collectionId) {
    this.collectionId = collectionId;
  }

}
