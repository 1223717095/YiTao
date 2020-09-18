package com.wyurjds.yitao.Entity;


import java.sql.Timestamp;

public class Users {

  private String wechatUserId;
  private String wechatUserName;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private String userPic;

  public Users(String wechatUserId, String wechatUserName, Timestamp createTime, Timestamp updateTime, String userPic) {
    this.wechatUserId = wechatUserId;
    this.wechatUserName = wechatUserName;
    this.createTime = createTime;
    this.updateTime = updateTime;
    this.userPic = userPic;
  }

  public Users(String wechatUserId, String wechatUserName, String userPic) {
    this.wechatUserId = wechatUserId;
    this.wechatUserName = wechatUserName;
    this.userPic = userPic;
  }

  public String getWechatUserId() {
    return wechatUserId;
  }

  public void setWechatUserId(String wechatUserId) {
    this.wechatUserId = wechatUserId;
  }

  public String getWechatUserName() {
    return wechatUserName;
  }

  public void setWechatUserName(String wechatUserName) {
    this.wechatUserName = wechatUserName;
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

  public String getUserPic() {
    return userPic;
  }

  public void setUserPic(String userPic) {
    this.userPic = userPic;
  }


}
