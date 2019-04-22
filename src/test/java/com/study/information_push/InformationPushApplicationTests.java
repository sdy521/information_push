package com.study.information_push;

import com.study.information_push.dao.first.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InformationPushApplicationTests {

	@Resource
	private UserDao userDao;
	@Test
	public void contextLoads() {
		System.out.println(BCrypt.hashpw("sdy",BCrypt.gensalt()));
	}

}
