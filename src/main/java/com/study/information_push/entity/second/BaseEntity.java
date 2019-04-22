package com.study.information_push.entity.second;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class BaseEntity {
    @Id
    //tk.mybatis只能用这一种主键生成策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //字段不能更新
    @Column(updatable = false)
    private Date createTime;
    @Column
    private Date updateTime;
    @Column
    private Boolean deleted=false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
