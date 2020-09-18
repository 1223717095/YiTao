package com.wyurjds.yitao.Dto;

public class SendMessageRequest {
    private String newsSenderId;
    private String newsReceiverId;
    private String newsContents;
    private long productId;

    public SendMessageRequest() {
    }

    public SendMessageRequest(String newsSenderId, String newsReceiverId, String newsContents, long productId) {
        this.newsSenderId = newsSenderId;
        this.newsReceiverId = newsReceiverId;
        this.newsContents = newsContents;
        this.productId = productId;
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

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
