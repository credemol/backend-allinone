package com.iclinicemr.training.controller;

import com.iclinicemr.training.message.OrderListVO;
import com.iclinicemr.training.message.OrderVO;
import com.iclinicemr.training.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/order")
@RestController("orderController")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<Page<OrderListVO>> getOrders(
            @RequestParam(name="page", defaultValue = "0")int page,
            @RequestParam(name="size", defaultValue = "100") int size) {

        return ResponseEntity.ok(orderService.getOrders(PageRequest.of(page, size)));
    }

    @PostMapping
    public ResponseEntity<OrderVO> createOrder(
            @Valid @RequestBody OrderVO vo) {

        return new ResponseEntity<OrderVO>(orderService.create(vo), HttpStatus.CREATED);
        //return new ResponseEntity<OrderVO>(orderService.)
    }

    @GetMapping("/{id}")
    public  ResponseEntity<OrderVO> getOrder(@PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<OrderVO>(orderService.get(id), HttpStatus.OK);
        } catch(EntityNotFoundException ex) {
            return new ResponseEntity<OrderVO>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderVO> updateOrder(
            @PathVariable("id") UUID id,
            @Valid @RequestBody OrderVO order) {

        try {
            OrderVO updated = orderService.update(id, order);
            return new ResponseEntity<OrderVO>(updated, HttpStatus.OK);

        } catch(EntityNotFoundException ex) {
            return new ResponseEntity<OrderVO>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") UUID id) {
        try {
            orderService.delete(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(EntityNotFoundException ex) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
