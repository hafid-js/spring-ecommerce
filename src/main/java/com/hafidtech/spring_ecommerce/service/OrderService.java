package com.hafidtech.spring_ecommerce.service;

import com.hafidtech.spring_ecommerce.exception.OrderException;
import com.hafidtech.spring_ecommerce.model.Address;
import com.hafidtech.spring_ecommerce.model.Order;
import com.hafidtech.spring_ecommerce.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public OrderService createOrder(User user, Address shippingAddress);

    public Order findOrderById(Long orderId) throws OrderException;

    public List<Order> usersOrderHistory(Long userId);

    public Order placedOrder(Long orderId) throws OrderException;

    public Order confirmedOrder(Long orderId) throws OrderException;

    public Order shippedOrder(Long orderId) throws OrderException;

    public Order deliveredOrder(Long orderId) throws OrderException;

    public Order canceledOrder(Long orderId) throws OrderException;
}
