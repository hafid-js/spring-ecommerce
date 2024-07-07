package com.hafidtech.spring_ecommerce.repository;

import com.hafidtech.spring_ecommerce.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, Long> {
}
