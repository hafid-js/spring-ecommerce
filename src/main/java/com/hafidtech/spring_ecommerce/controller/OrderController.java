package com.hafidtech.spring_ecommerce.controller;

import com.hafidtech.spring_ecommerce.exception.OrderException;
import com.hafidtech.spring_ecommerce.exception.UserException;
import com.hafidtech.spring_ecommerce.model.Address;
import com.hafidtech.spring_ecommerce.model.Order;
import com.hafidtech.spring_ecommerce.model.User;
import com.hafidtech.spring_ecommerce.service.OrderService;
import com.hafidtech.spring_ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Order> createOrder(@RequestBody Address shippingAddress,
                                             @RequestHeader("Authorization") String jwt) throws UserException {

        User user = userService.findUserProfileByJwt(jwt);

        Order order = orderService.createOrder(user, shippingAddress);

        System.out.println("order"+ order);
        return new ResponseEntity<Order>(order, HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Order>> usersOrderHistory(@RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);

        List<Order> orders = orderService.usersOrderHistory(user.getId());

        return new ResponseEntity<>(orders, HttpStatus.CREATED);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Order> findOrderById(@PathVariable("Id") Long orderId, @RequestHeader("Authorization") String jwt) throws UserException, OrderException {
        User user = userService.findUserProfileByJwt(jwt);

        Order order = orderService.findOrderById(orderId);

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
