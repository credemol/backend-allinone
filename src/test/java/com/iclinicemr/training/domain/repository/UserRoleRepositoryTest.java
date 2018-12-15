package com.iclinicemr.training.domain.repository;

import com.iclinicemr.training.domain.entity.Role;
import com.iclinicemr.training.domain.entity.User;
import com.iclinicemr.training.domain.entity.UserRole;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRoleRepositoryTest {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;
    @Test
    @DisplayName("Insert UserRoles")
    public void test_01_UserRoles() {
        User nick = userRepository.findOne(Example.of(new User("nick"))).get();
        User amy = userRepository.findOne(Example.of(new User("amy"))).get();
        User alex = userRepository.findOne(Example.of(new User("alex"))).get();
        User sarah = userRepository.findOne(Example.of(new User("sarah"))).get();

        Role customer = roleRepository.findOne(Example.of(new Role("Customer"))).get();
        Role staff = roleRepository.findOne(Example.of(new Role("Staff"))).get();
        Role manager = roleRepository.findOne(Example.of(new Role("Manager"))).get();
        Role systemAdmin = roleRepository.findOne(Example.of(new Role("SystemAdmin"))).get();

        userRoleRepository.save(new UserRole(nick, systemAdmin));
        userRoleRepository.save(new UserRole(nick, customer));

        userRoleRepository.save(new UserRole(sarah, customer));

        userRoleRepository.save(new UserRole(amy, manager));
        userRoleRepository.save(new UserRole(amy, staff));

        userRoleRepository.save(new UserRole(alex, staff));



    }
}
