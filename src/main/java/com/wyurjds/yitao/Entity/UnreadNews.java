package com.wyurjds.yitao.Entity;


public class UnreadNews {

  private long unreadNewsId;
  private String newsSenderId;
  private String newsReceiverId;
  private String newsContents;
  private java.sql.Timestamp newsSendOutDate;
  private long productId;


  public long getUnreadNewsId() {
    return unreadNewsId;
  }

  public void setUnreadNewsId(long unreadNewsId) {
    this.unreadNewsId = unreadNewsId;
  }


  public String getNewsSenderId() {
    return newsSenderId;
  }

  public void setNewsSenderId(String newsSenderId) {
    this.newsSenderId = newsSenderId;
  }


  public String getNewsReceiverId() {
    return newsReceiverId;
  }

  public void setNewsReceiverId(String newsReceiverId) {
    this.newsReceiverId = newsReceiverId;
  }


  public String getNewsContents() {
    return newsContents;
  }

  public void setNewsContents(String newsContents) {
    this.newsContents = newsContents;
  }


  public java.sql.Timestamp getNewsSendOutDate() {
    return newsSendOutDate;
  }

  public void setNewsSendOutDate(java.sql.Timestamp newsSendOutDate) {
    this.newsSendOutDate = newsSendOutDate;
  }


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

}
