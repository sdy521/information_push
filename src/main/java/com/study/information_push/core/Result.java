package com.study.information_push.core;

/**
 * @Author: Sdy
 * @Date:Created in 21:26 2019/4/18
 */
public class Result {
    private Integer code;
    private String msg;

    public Result() {
        this.code = 0;
        this.msg = "操作成功";
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
