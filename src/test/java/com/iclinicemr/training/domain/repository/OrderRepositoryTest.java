package com.iclinicemr.training.domain.repository;

import com.iclinicemr.training.domain.entity.Menu;
import com.iclinicemr.training.domain.entity.Order;
import com.iclinicemr.training.domain.entity.OrderItem;
import com.iclinicemr.training.domain.entity.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    OrderRepository orderRepository;


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
}
