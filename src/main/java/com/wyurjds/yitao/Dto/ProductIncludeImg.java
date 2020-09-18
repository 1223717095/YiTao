package com.wyurjds.yitao.Dto;

import com.wyurjds.yitao.Entity.Products;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;



public class ProductIncludeImg {
//    @Value("GET_PIC_URL")
//    private String picUrl;


    private long productId;
    private long secondCategoryId;
    private String sellerId;
    private String productTitle;
    private double productPrice;
    private String productIntroduce;
    private ArrayList<String> productUrl;
    private long productStatus;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;

    public ProductIncludeImg() {
    }

    public ProductIncludeImg(Products products) {
        this.productId = products.getProductId();
        this.secondCategoryId = products.getSecondCategoryId();
        this.sellerId = products.getSellerId();
        this.productTitle = products.getProductTitle();
        this.productPrice = products.getProductPrice();
        this.productIntroduce = products.getProductIntroduce();

        if (products.getProductUrl() != null) {
            this.productUrl = new ArrayList<String>(Arrays.asList(products.getProductUrl().split(",")));
            for (int i = 0; i < productUrl.size(); i++) {
                productUrl.set(i, "https://cps.cccccp.cn/file/yitao/img/product/" + productUrl.get(i));
            }
        } else{
            this.productUrl=null;
        }


        this.productStatus = products.getProductStatus();
        this.createTime = products.getCreateTime();
        this.updateTime = products.getUpdateTime();
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
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

    public ArrayList<String> getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(ArrayList<String> productUrl) {
        this.productUrl = productUrl;
    }

    public long getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(long productStatus) {
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
