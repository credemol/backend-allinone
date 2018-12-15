package com.iclinicemr.training.domain.repository;

import com.iclinicemr.training.domain.entity.Role;
import com.iclinicemr.training.domain.entity.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Insert users")
    public void test_01_InsertUsers() {

        User nick = createUser("nick", "passwd", "Nick", "Brown");
        User amy = createUser("amy", "passwd", "Amy", "Lovely");
        User sarah = createUser("sarah", "passwd", "Sarah", "Whitmen");
        User alex = createUser("alex", "passwd", "Alex", "Bulling");

        userRepository.save(nick);
        userRepository.save(amy);
        userRepository.save(sarah);
        userRepository.save(alex);

    }
    private User createUser(String username, String password, String firstName, String lastName) {
        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        //user.setRoles(new HashSet<>(Arrays.asList(roles)));



        return user;
    }
}
