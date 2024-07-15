package com.hafidtech.spring_ecommerce.repository;

import com.hafidtech.spring_ecommerce.model.Cart;
import com.hafidtech.spring_ecommerce.model.CartItem;
import com.hafidtech.spring_ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    @Query("SELECT ci FROM CartItem ci WHERE ci.cart=:cart AND ci.product=:product AND ci.size=:size AND ci.userId=:userId")
    public CartItem isCartItemExist(@Param("cart")Cart cart,
                                    @Param("product")Product product,
                                    @Param("size") String size,
                                    @Param("userId") Long userId);


//    @Query("DELETE From CartItem c Where c.cart.id=:cartId")
    @Transactional
    Long deleteByCartId(Long cartId);
}
