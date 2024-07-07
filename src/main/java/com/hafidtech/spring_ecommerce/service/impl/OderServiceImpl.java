package com.hafidtech.spring_ecommerce.service.impl;

import com.hafidtech.spring_ecommerce.exception.OrderException;
import com.hafidtech.spring_ecommerce.model.Address;
import com.hafidtech.spring_ecommerce.model.Order;
import com.hafidtech.spring_ecommerce.model.User;
import com.hafidtech.spring_ecommerce.repository.CartRepository;
import com.hafidtech.spring_ecommerce.service.CartService;
import com.hafidtech.spring_ecommerce.service.OrderService;
import com.hafidtech.spring_ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderServiceImpl implements OrderService {

    private CartRepository cartRepository;
    private CartService cartItemService;
    private ProductService productService;

    @Override
    public OrderService createOrder(User user, Address shippingAddress) {
        return null;
    }

    @Override
    public Order findOrderById(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public List<Order> usersOrderHistory(Long userId) {
        return null;
    }

    @Override
    public Order placedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order confirmedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order shippedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order deliveredOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order canceledOrder(Long orderId) throws OrderException {
        return null;
    }
}
