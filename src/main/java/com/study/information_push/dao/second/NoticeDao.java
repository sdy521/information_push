package com.study.information_push.dao.second;

import com.study.information_push.entity.second.Notice;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sdy
 * @date 2019/4/24 14:36
 */
@Component
public interface NoticeDao {

    @Select("select * from notice where deleted=0 order by update_time desc")
    List<Notice> selectAll();

    @Select("select * from notice where id = ${id}")
    Notice selectOne(@Param("id")Integer id);
}
