package com.study.information_push.core;

/**
 * @Author: Sdy
 * @Date:Created in 21:27 2019/4/18
 */
public class JSONResult extends Result {
    private Object data;
    private Integer count;

    public JSONResult(Object data,Integer count) {
        super(0,"操作成功");
        this.data = data;
        this.count = count;
    }

    public JSONResult() {

    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
