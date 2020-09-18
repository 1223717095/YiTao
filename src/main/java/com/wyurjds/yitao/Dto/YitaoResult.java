package com.wyurjds.yitao.Dto;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 淘淘商城自定义响应结构
 */
public class YitaoResult {

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static YitaoResult build(Integer status, String msg, Object data) {
        return new YitaoResult(status, msg, data);
    }

    public static YitaoResult ok(Object data) {
        return new YitaoResult(data);
    }

    public static YitaoResult ok() {
        return new YitaoResult(null);
    }

    public YitaoResult() {

    }

    public static YitaoResult build(Integer status, String msg) {
        return new YitaoResult(status, msg, null);
    }

    public YitaoResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public YitaoResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

//    public Boolean isOK() {
//        return this.status == 200;
//    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
