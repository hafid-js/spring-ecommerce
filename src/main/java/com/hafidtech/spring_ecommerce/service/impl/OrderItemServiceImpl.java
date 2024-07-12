package com.hafidtech.spring_ecommerce.service.impl;

import com.hafidtech.spring_ecommerce.model.OrderItem;
import com.hafidtech.spring_ecommerce.repository.OrderItemRepository;
import com.hafidtech.spring_ecommerce.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
