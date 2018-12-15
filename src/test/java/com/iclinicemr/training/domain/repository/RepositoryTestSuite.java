package com.iclinicemr.training.domain.repository;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)

//@SpringBootTest
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Suite.class)
@Suite.SuiteClasses({RoleRepositoryTest.class,
        UserRepositoryTest.class,
        UserRoleRepositoryTest.class,
        MenuRepositoryTest.class,
        OrderRepositoryTest.class})
public class RepositoryTestSuite {
//    @Test
//    public void runTestSuite() {
//        JUnitCore.runClasses(RoleRepositoryTest.class,
//            UserRepositoryTest.class,
//            UserRoleRepositoryTest.class,
//            MenuRepositoryTest.class,
//            OrderRepositoryTest.class);
//    }
}
