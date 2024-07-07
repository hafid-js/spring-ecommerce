package com.hafidtech.spring_ecommerce.service.impl;

import com.hafidtech.spring_ecommerce.exception.CartItemException;
import com.hafidtech.spring_ecommerce.exception.UserException;
import com.hafidtech.spring_ecommerce.model.Cart;
import com.hafidtech.spring_ecommerce.model.CartItem;
import com.hafidtech.spring_ecommerce.model.Product;
import com.hafidtech.spring_ecommerce.repository.CartItemRepository;
import com.hafidtech.spring_ecommerce.repository.CartRepository;
import com.hafidtech.spring_ecommerce.service.CartItemService;
import com.hafidtech.spring_ecommerce.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class CartItemImpl implements CartItemService {

    private CartItemRepository cartItemRepository;

    private UserService userService;

    private CartRepository cartRepository;

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        return null;
    }

    @Override
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {
        return null;
    }

    @Override
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
        return null;
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {

    }

    @Override
    public CartItem findCartItemById(Long cartItemId) throws CartItemException {
        return null;
    }
}
