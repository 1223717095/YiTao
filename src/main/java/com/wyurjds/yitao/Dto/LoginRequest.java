package com.wyurjds.yitao.Dto;

public class LoginRequest {
    private String wechatUserName;
    private String code;
    private String userPic;

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getWechatUserName() {
        return wechatUserName;
    }

    public void setWechatUserName(String wechatUserName) {
        this.wechatUserName = wechatUserName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
