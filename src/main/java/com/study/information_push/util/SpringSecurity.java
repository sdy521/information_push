package com.study.information_push.util;

import com.study.information_push.security.UserDetail;
import org.springframework.security.core.context.SecurityContextHolder;

public class SpringSecurity {
    public static UserDetail getUserDetail(){
        UserDetail userDetail = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetail;
    }
}
