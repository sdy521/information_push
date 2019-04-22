package com.study.information_push.dao.first;

import com.study.information_push.core.BaseDao;
import com.study.information_push.entity.first.PushConfig;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sdy
 * @date 2019/4/19 9:48
 */
@Component
public interface PushConfigDao extends BaseDao<PushConfig> {

    @Select("select * from push_config where deleted=0")
    List<PushConfig> selectAll();
}
