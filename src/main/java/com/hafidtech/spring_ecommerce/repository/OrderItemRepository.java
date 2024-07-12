package com.hafidtech.spring_ecommerce.repository;

import com.hafidtech.spring_ecommerce.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
