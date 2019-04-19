package com.study.information_push.core;

/**
 * @Author: Sdy
 * @Date:Created in 21:27 2019/4/18
 */
public class PageResult extends Result {
    private Object data;
    private Long count;

    public PageResult(Object data, Long count) {
        super(0,"操作成功");
        this.data = data;
        this.count = count;
    }

    public PageResult() {

    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
