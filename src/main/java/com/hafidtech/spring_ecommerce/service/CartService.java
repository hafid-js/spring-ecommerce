package com.hafidtech.spring_ecommerce.service;

import com.hafidtech.spring_ecommerce.exception.CartException;
import com.hafidtech.spring_ecommerce.exception.ProductException;
import com.hafidtech.spring_ecommerce.model.Cart;
import com.hafidtech.spring_ecommerce.model.User;
import com.hafidtech.spring_ecommerce.request.AddItemRequest;
import org.springframework.data.jpa.repository.Query;

public interface CartService {

    public Cart createCart(User user);

    public String addCartItem(Long userId, AddItemRequest request) throws ProductException;

    public Cart findUserCart(Long userId) throws CartException;
}
