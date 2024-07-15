package com.hafidtech.spring_ecommerce.repository;

import com.hafidtech.spring_ecommerce.model.Cart;
import com.hafidtech.spring_ecommerce.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c From Cart c Where c.user.id=:userId")
    public Cart findByUserId(@Param("userId") Long userId);

    void deleteByUserId(Long userId);



}
