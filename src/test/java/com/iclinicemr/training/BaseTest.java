package com.iclinicemr.training;

import com.iclinicemr.training.domain.entity.*;
import com.iclinicemr.training.domain.repository.MenuRepository;
import com.iclinicemr.training.domain.repository.RoleRepository;
import com.iclinicemr.training.domain.repository.UserRepository;
import com.iclinicemr.training.domain.repository.OrderRepository;
import com.iclinicemr.training.domain.repository.UserRoleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.data.domain.Example;

import java.math.BigDecimal;
import java.util.*;

@Disabled
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BaseTest {

    private static Logger logger = LogManager.getLogger(BaseTest.class);

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRoleRepository userRoleRepository;


    @BeforeAll
    public static void init() {

    }

    @Test
    @DisplayName("Insert roles")
    public void test_01_InsertRoles() {
        Role customerRole = new Role("Customer");
        Role staffRole = new Role("Staff");
        Role managerRole = new Role("Manager");
        Role systemAdminRole = new Role("SystemAdmin");

        roleRepository.save(customerRole);
        roleRepository.save(staffRole);
        roleRepository.save(managerRole);
        roleRepository.save(systemAdminRole);
    }

    @Test
    @DisplayName("Insert users")
    public void test_02_InsertUsers() {

        Role customerRole = roleRepository.findOneByRole("Customer").get();
        logger.info("customerRole: {}", customerRole);

        User nick = createUser("nick", "passwd", "Nick", "Brown");
        User amy = createUser("amy", "passwd", "Amy", "Lovely");
        User sarah = createUser("sarah", "passwd", "Sarah", "Whitmen");
        User alex = createUser("alex", "passwd", "Alex", "Bulling");

        userRepository.save(nick);
        userRepository.save(amy);
        userRepository.save(sarah);
        userRepository.save(alex);

    }

    @Test
    @DisplayName("Insert UserRoles")
    public void test_03_UserRoles() {
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

//        userRoleRepository.save(new UserRole(new UserRoleId(nick.getId(), systemAdmin.getId())));
//        userRoleRepository.save(new UserRole(new UserRoleId(nick.getId(), customer.getId())));
//
//        userRoleRepository.save(new UserRole(new UserRoleId(sarah.getId(), customer.getId())));
//
//        userRoleRepository.save(new UserRole(new UserRoleId(amy.getId(), manager.getId())));
//        userRoleRepository.save(new UserRole(new UserRoleId(amy.getId(), staff.getId())));
//
//        userRoleRepository.save(new UserRole(new UserRoleId(alex.getId(), staff.getId())));


    }

    @Test
    @DisplayName("Insert menus")
    public void test_04_InsertMenus() {
        Menu juniperLatte = new Menu("Juniper Latte", new BigDecimal(3.5));
        Menu icedJuniperLatte = new Menu("Iced Juniper Latte", new BigDecimal(4.0));
        Menu caffeLatte = new Menu("Caffe Latte", new BigDecimal(5.0));

        menuRepository.save(juniperLatte);
        menuRepository.save(icedJuniperLatte);
        menuRepository.save(caffeLatte);
    }

    @Test
    @DisplayName("Insert orders")
    public void test_05_InsertOrders() {
        Menu juniperLatte = menuRepository.findOneByName("Juniper Latte").get();
        Menu icedJuniperLatte = menuRepository.findOneByName("Iced Juniper Latte").get();
        Menu caffeLatte = menuRepository.findOneByName("Caffe Latte").get();



        User sarah = userRepository.findOne(Example.of(new User("sarah"))).get();
        User alex = userRepository.findOne(Example.of(new User("alex"))).get();

        Order order = new Order();
        order.setCustomer(sarah);


        Collection<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem(order, juniperLatte, 2));
        orderItems.add(new OrderItem(order, caffeLatte, 1));
        order.getItems().addAll(orderItems);
        orderRepository.save(order);

        order = new Order();
        order.setCustomer(alex);

        orderItems = new ArrayList<>();
        orderItems.add(new OrderItem(order, icedJuniperLatte, 1));
        orderItems.add(new OrderItem(order, juniperLatte, 1));
        orderItems.add(new OrderItem(order, caffeLatte, 1));
        order.getItems().addAll(orderItems);
        orderRepository.save(order);
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
