package com.study.information_push.core;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author sdy
 * @date 2019/4/17 10:00
 */
public interface BaseDao<T> extends Mapper<T>, MySqlMapper<T> {
}
