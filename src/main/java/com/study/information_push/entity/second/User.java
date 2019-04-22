package com.study.information_push.entity.second;

import javax.persistence.Column;

public class User extends BaseEntity {

    @Column
    private String name;
    @Column
    private String password;
    /***
     * 0:超级管理员1:老师2:学生
     */
    @Column
    private Integer type;

    /***
     * true:security可验证,false 不可验证身份
     */
    @Column
    private Boolean enable;

    @Column
    private String img;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
