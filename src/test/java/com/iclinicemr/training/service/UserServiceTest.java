package com.iclinicemr.training.service;

import com.iclinicemr.training.domain.entity.User;
import com.iclinicemr.training.message.UserVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {
    private static Logger logger = LogManager.getLogger(UserServiceTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void test_1_getUsers() {
        userService.getUsers(PageRequest.of(0, 100)).stream().forEach(user-> {
            logger.info("user: {}", user);
        });

    }

    @Test
    public void test_2_getUser() {
        final UUID id = UUID.fromString("1de948e7-7c0e-4496-8c78-7c260b3f95cf");

        UserVO user = userService.get(id);

        logger.info("user: {}", user);
    }
}
