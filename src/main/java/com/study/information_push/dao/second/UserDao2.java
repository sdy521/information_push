package com.study.information_push.dao.second;

import com.study.information_push.core.BaseDao;
import com.study.information_push.entity.second.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @author sdy
 * @date 2019/4/22 15:37
 */
@Component
public interface UserDao2{

    @Select("select * from user where id in (${ids}) AND deleted=0")
    List<User> selectByIds(@Param("ids")String ids);
}
