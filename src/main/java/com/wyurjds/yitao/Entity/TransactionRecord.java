package com.wyurjds.yitao.Entity;


public class TransactionRecord {

  private long productId;
  private String sellerId;
  private String buyerId;
  private long transactionStatus;
  private java.sql.Timestamp transactionDate;
  private long transactionRecordId;


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public String getSellerId() {
    return sellerId;
  }

  public void setSellerId(String sellerId) {
    this.sellerId = sellerId;
  }


  public String getBuyerId() {
    return buyerId;
  }

  public void setBuyerId(String buyerId) {
    this.buyerId = buyerId;
  }


  public long getTransactionStatus() {
    return transactionStatus;
  }

  public void setTransactionStatus(long transactionStatus) {
    this.transactionStatus = transactionStatus;
  }


  public java.sql.Timestamp getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(java.sql.Timestamp transactionDate) {
    this.transactionDate = transactionDate;
  }


  public long getTransactionRecordId() {
    return transactionRecordId;
  }

  public void setTransactionRecordId(long transactionRecordId) {
    this.transactionRecordId = transactionRecordId;
  }

}
