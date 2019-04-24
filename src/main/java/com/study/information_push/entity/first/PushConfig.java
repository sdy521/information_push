package com.study.information_push.entity.first;

import com.study.information_push.entity.BaseEntity;

import javax.persistence.Column;

/**
 * @author sdy
 * @date 2019/4/19 9:44
 */
public class PushConfig extends BaseEntity {
    @Column
    private String url;
    @Column
    private String method;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
