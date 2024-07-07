package com.hafidtech.spring_ecommerce.service.impl;

import com.hafidtech.spring_ecommerce.exception.CartItemException;
import com.hafidtech.spring_ecommerce.exception.UserException;
import com.hafidtech.spring_ecommerce.model.Cart;
import com.hafidtech.spring_ecommerce.model.CartItem;
import com.hafidtech.spring_ecommerce.model.Product;
import com.hafidtech.spring_ecommerce.model.User;
import com.hafidtech.spring_ecommerce.repository.CartItemRepository;
import com.hafidtech.spring_ecommerce.repository.CartRepository;
import com.hafidtech.spring_ecommerce.service.CartItemService;
import com.hafidtech.spring_ecommerce.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemImpl implements CartItemService {

    private CartItemRepository cartItemRepository;

    private UserService userService;

    private CartRepository cartRepository;

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        cartItem.setQuantity(1);
        cartItem.setPrice(cartItem.getProduct().getPrice()*cartItem.getQuantity());
        cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice()*cartItem.getQuantity());

        CartItem createdCartItem = cartItemRepository.save(cartItem);

        return createdCartItem;
    }

    @Override
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {
        CartItem item = findCartItemById(id);
        User user = userService.findUserById(item.getUserId());

        if (user.getId().equals(userId)) {
            item.setQuantity(cartItem.getQuantity());
            item.setPrice(item.getQuantity()*item.getProduct().getPrice());
            item.setDiscountedPrice(item.getProduct().getDiscountedPrice()*item.getQuantity());
        }

        return cartItemRepository.save(item);
    }

    @Override
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
        CartItem cartItem = cartItemRepository.isCartItemExist(cart, product, size, userId);
        return  cartItem;
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {
        CartItem cartItem = findCartItemById(cartItemId);

        User user = userService.findUserById(cartItem.getUserId());
        User reqUser = userService.findUserById(userId);

        if (user.getId().equals(reqUser.getId())) {
            cartItemRepository.deleteById(cartItemId);
        } else {
            throw new UserException("you can't remove another users item");
        }
    }

    @Override
    public CartItem findCartItemById(Long cartItemId) throws CartItemException {
        Optional<CartItem> opt = cartItemRepository.findById(cartItemId);

        if (opt.isPresent()) {
            return opt.get();
        }
        throw new CartItemException("cart item not found with id : " + cartItemId);
    }
}
