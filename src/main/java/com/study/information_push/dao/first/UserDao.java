package com.study.information_push.dao.first;


import com.study.information_push.entity.first.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author sdy
 * @date 2019/4/17 9:55
 */
@Component
public interface UserDao{

    @Select("select * from user where id =${id}")
    User selectOneById(@Param("id")Integer id);

    @Select("select * from user where name =#{name}")
    User selectOneByName(@Param("name")String name);
}
