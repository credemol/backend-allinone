package com.iclinicemr.training.controller;

import com.iclinicemr.training.message.OrderListVO;
import com.iclinicemr.training.message.UserListVO;
import com.iclinicemr.training.message.UserVO;
import com.iclinicemr.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/user")
@RestController("userController")
public class UserController {
    
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<UserListVO>> getOrders(
            @RequestParam(name="page", defaultValue = "0")int page,
            @RequestParam(name="size", defaultValue = "100") int size) {

        return ResponseEntity.ok(userService.getUsers(PageRequest.of(page, size)));
    }

    @PostMapping
    public ResponseEntity<UserVO> createOrder(
            @Valid @RequestBody UserVO vo) {

        return new ResponseEntity<UserVO>(userService.create(vo), HttpStatus.CREATED);
        //return new ResponseEntity<UserVO>(userService.)
    }

    @GetMapping("/{id}")
    public  ResponseEntity<UserVO> getOrder(@PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<UserVO>(userService.get(id), HttpStatus.OK);
        } catch(EntityNotFoundException ex) {
            return new ResponseEntity<UserVO>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserVO> updateOrder(
            @PathVariable("id") UUID id,
            @Valid @RequestBody UserVO order) {

        try {
            UserVO updated = userService.update(id, order);
            return new ResponseEntity<UserVO>(updated, HttpStatus.OK);

        } catch(EntityNotFoundException ex) {
            return new ResponseEntity<UserVO>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") UUID id) {
        try {
            userService.delete(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(EntityNotFoundException ex) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }    
}
