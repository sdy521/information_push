package com.study.information_push.security;

import com.study.information_push.dao.RolesDao;
import com.study.information_push.dao.UserDao;
import com.study.information_push.entity.Role;
import com.study.information_push.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    private UserDao userDao;
    @Resource
    private RolesDao rolesDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User select = new User();
        select.setName(username);
        User user = userDao.selectOne(select);
        if (user == null) {
            throw new UsernameNotFoundException("用户名：" + username + "不存在");
        }
        List<Role> roleList = rolesDao.getRoles(user.getId());
        //获取权限
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        if (roleList.size() != 0){
            for (Role role: roleList){
                authorities.add(new SimpleGrantedAuthority(role.getName()));
                System.out.println(role.getName());
            }
        }
        // 封装成spring security的user
        UserDetail userDetail = new UserDetail(user.getName(), user.getPassword(),
                true, true, true, true, authorities);
        return userDetail;
    }
}
