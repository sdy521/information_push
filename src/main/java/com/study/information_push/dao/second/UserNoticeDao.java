package com.study.information_push.dao.second;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author sdy
 * @date 2019/4/26 15:12
 */
@Component
public interface UserNoticeDao {

    @Insert("insert into user_notice(user_id,notice_id) values(${userId},${noticeId})")
    void insertOne(@Param("userId")Integer userId,@Param("noticeId")Integer noticeId);
}
