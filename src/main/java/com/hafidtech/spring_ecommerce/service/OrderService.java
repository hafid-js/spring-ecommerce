package com.hafidtech.spring_ecommerce.service;

import com.hafidtech.spring_ecommerce.exception.CartException;
import com.hafidtech.spring_ecommerce.exception.OrderException;
import com.hafidtech.spring_ecommerce.model.Address;
import com.hafidtech.spring_ecommerce.model.Order;
import com.hafidtech.spring_ecommerce.model.User;

import java.util.List;

public interface OrderService {

    public Order createOrder(User user, Address shippingAddress) throws CartException;

    public Order findOrderById(Long orderId) throws OrderException;

    public List<Order> getAllOrders();

    public void deleteOrder(Long orderId) throws OrderException;

    public List<Order> usersOrderHistory(Long userId);

    public Order placedOrder(Long orderId) throws OrderException;

    public Order confirmedOrder(Long orderId) throws OrderException;

    public Order shippedOrder(Long orderId) throws OrderException;

    public Order deliveredOrder(Long orderId) throws OrderException;

    public Order canceledOrder(Long orderId) throws OrderException;
}
