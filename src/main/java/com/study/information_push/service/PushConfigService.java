package com.study.information_push.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.information_push.core.LayuiPageParam;
import com.study.information_push.dao.second.UserDao2;
import com.study.information_push.entity.second.User;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author sdy
 * @date 2019/4/19 9:49
 */
@Service
public class PushConfigService{

    @Resource
    private UserDao2 userDao2;


    public PageInfo<User> seletAll(LayuiPageParam pageParam){
        PageHelper.startPage(pageParam.getPage(),pageParam.getLimit());
        List<User> list = userDao2.selectAll();
        return new PageInfo<User>(list);
    }
}
