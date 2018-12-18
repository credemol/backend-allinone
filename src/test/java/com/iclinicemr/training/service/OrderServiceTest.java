package com.iclinicemr.training.service;

import com.iclinicemr.training.message.OrderVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderServiceTest {
    private static Logger logger = LogManager.getLogger(OrderServiceTest.class);

    @Autowired
    private OrderService orderService;

    @DisplayName("Get Orders")
    @Test
    public void test_1_GetOrders() {
//        Page<OrderVO> page = orderService.getOrders(PageRequest.of(0, 10));
//        logger.info("page: {}", page);
//
//        List<OrderVO> orders = page.getContent();
//        logger.info("orders: {}", orders);
        orderService.getOrders(PageRequest.of(0, 10)).stream().forEach(order -> {
            logger.info("order description: {}", order.getDescription());
            logger.info("customer: {}", order.getCustomer());
//            logger.info("order items: {}", order.getItems() );

        });
    }

    @DisplayName("Get OrderById")
    @Test
    public void test_2_GetById() {
        UUID id = UUID.fromString("5a8282a8-616f-4861-8613-60be91fe15c7");

        OrderVO order = orderService.get(id);
        Assert.assertNotNull(order);
        logger.info("customer: {}", order.getCustomer());
        logger.info("items: {}", order.getItems());
    }
}
