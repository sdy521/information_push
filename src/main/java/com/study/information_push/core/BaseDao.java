package com.study.information_push.core;

import com.study.information_push.entity.BaseEntity;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author sdy
 * @date 2019/4/17 10:00
 */
@Component
public interface BaseDao<T extends BaseEntity> extends Mapper<T>, MySqlMapper<T> {
}
