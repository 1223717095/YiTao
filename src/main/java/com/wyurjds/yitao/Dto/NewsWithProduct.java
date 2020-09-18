package com.wyurjds.yitao.Dto;

import com.wyurjds.yitao.Entity.News;
import com.wyurjds.yitao.Entity.Products;
import com.wyurjds.yitao.Entity.Users;
import com.wyurjds.yitao.Utils.ProductImgBuild;
import lombok.Value;

import java.sql.Timestamp;
import java.util.ArrayList;



public class NewsWithProduct {
    private String newsSenderId;
    private String newsReceiverId;
    private String newsContents;
    private java.sql.Timestamp newsSendOutDate;
    private long newsId;
    private long productId;
    private ArrayList<String> productUrl;
    private String productTitle;
    private String otherUserPic;
    private String otherUserName;
    private String sellerId;



    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public NewsWithProduct(News news) {
        this.newsSenderId = news.getNewsSenderId();
        this.newsReceiverId = news.getNewsReceiverId();
        this.newsContents = news.getNewsContents();
        this.newsSendOutDate = news.getNewsSendOutDate();
        this.newsId = news.getNewsId();

        this.productId = 0;
        this.productUrl = null;
        this.productTitle = null;
        this.otherUserPic=null;
        this.otherUserName=null;
    }

    public void setProduct(Products products){
        this.productId = products.getProductId();
        this.productTitle = products.getProductTitle();

        ProductIncludeImg productIncludeImg= ProductImgBuild.getOneProduct(products);
        this.productUrl = productIncludeImg.getProductUrl();
        this.sellerId=products.getSellerId();
    }

    public void setUser(Users user){
        this.otherUserPic= user.getUserPic();
        this.otherUserName=user.getWechatUserName();
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

    public Timestamp getNewsSendOutDate() {
        return newsSendOutDate;
    }

    public void setNewsSendOutDate(Timestamp newsSendOutDate) {
        this.newsSendOutDate = newsSendOutDate;
    }

    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public ArrayList<String> getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(ArrayList<String> productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getOtherUserPic() {
        return otherUserPic;
    }

    public void setOtherUserPic(String otherUserPic) {
        this.otherUserPic = otherUserPic;
    }

    public String getOtherUserName() {
        return otherUserName;
    }

    public void setOtherUserName(String otherUserName) {
        this.otherUserName = otherUserName;
    }
}
