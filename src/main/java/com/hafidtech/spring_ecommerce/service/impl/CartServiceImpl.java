package com.hafidtech.spring_ecommerce.service.impl;

import com.hafidtech.spring_ecommerce.exception.ProductException;
import com.hafidtech.spring_ecommerce.model.Cart;
import com.hafidtech.spring_ecommerce.model.User;
import com.hafidtech.spring_ecommerce.repository.CartRepository;
import com.hafidtech.spring_ecommerce.request.AddItemRequest;
import com.hafidtech.spring_ecommerce.service.CartItemService;
import com.hafidtech.spring_ecommerce.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;
    private CartItemService cartItemService;

    @Override
    public Cart createCart(User user) {
        return null;
    }

    @Override
    public String addCartItem(Long userId, AddItemRequest request) throws ProductException {
        return null;
    }

    @Override
    public Cart findUserCart(Long userId) {
        return null;
    }
}
