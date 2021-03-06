package com.study.information_push.service;

import com.study.information_push.core.BaseDao;
import com.study.information_push.entity.BaseEntity;
import com.study.information_push.security.UserDetail;
import com.study.information_push.util.SpringSecurity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sdy
 * @date 2019/4/19 9:50
 */
@Service
public abstract class BaseService<T extends BaseEntity> {
    protected abstract BaseDao<T> getDao();

    /***
     * null的属性也会保存，不会使用数据库默认值
     * @param entity
     */
    public void insert(T entity){
        saveBaseInfo(entity);
        getDao().insert(entity);
    }

    /***
     * 查看所有
     * @return
     */
    public List<T> selectAll(){
        return getDao().selectAll();
    }

    /***
     * 查询一个
     * @param recoad
     * @return
     */
    public T selectOne(T recoad){
        return getDao().selectOne(recoad);
    }

    /***
     * 根据主键更新属性不为null的值
     * @param recoad
     */
    public Integer updateByPrimaryKeySelective(T recoad){
        saveBaseInfo(recoad);
        getDao().updateByPrimaryKeySelective(recoad);
        return recoad.getId();
    }

    /***
     * 删除  实际是更新
     * @param recoad
     */
    public void delete(T recoad){
        saveBaseInfo(recoad);
        recoad.setDeleted(true);
        getDao().updateByPrimaryKeySelective(recoad);
    }
    /***
     * 根据条件查询
     * @param recoad
     * @return
     */
    public List<T> select(T recoad){
        return getDao().select(recoad);
    }
    protected void saveBaseInfo(T entity){
        UserDetail userDetail = SpringSecurity.getUserDetail();
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        entity.setCreateBy(userDetail.getId());
        entity.setUpdateBy(userDetail.getId());
    }
}
