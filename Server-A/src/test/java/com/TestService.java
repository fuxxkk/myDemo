package com;


import com.entity.User;
import com.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerAApplication.class)
public class TestService {

    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        User user = userService.findById(1l);
        System.out.println(user);
    }
}
