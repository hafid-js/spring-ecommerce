package com.hafidtech.spring_ecommerce.service.impl;

import com.hafidtech.spring_ecommerce.exception.ProductException;
import com.hafidtech.spring_ecommerce.model.Cart;
import com.hafidtech.spring_ecommerce.model.CartItem;
import com.hafidtech.spring_ecommerce.model.Product;
import com.hafidtech.spring_ecommerce.model.User;
import com.hafidtech.spring_ecommerce.repository.CartItemRepository;
import com.hafidtech.spring_ecommerce.repository.CartRepository;
import com.hafidtech.spring_ecommerce.request.AddItemRequest;
import com.hafidtech.spring_ecommerce.service.CartItemService;
import com.hafidtech.spring_ecommerce.service.CartService;
import com.hafidtech.spring_ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;


    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private ProductService productService;

    @Override
    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    @Override
    public String addCartItem(Long userId, AddItemRequest request) throws ProductException {
        Cart cart = cartRepository.findByUserId(userId);
        Product product = productService.findProductById(request.getProductId());

        CartItem isPresent = cartItemService.isCartItemExist(cart, product, request.getSize(), userId);

        if (isPresent == null) {
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setCart(cart);
            cartItem.setQuantity(request.getQuantity());
            cartItem.setUserId(userId);

            int price = request.getQuantity()*product.getDiscountedPrice();
            cartItem.setPrice(price);
            cartItem.setSize(request.getSize());

            CartItem createCartItem = cartItemService.createCartItem(cartItem);
            cart.getCartItems().add(createCartItem);
        }

        return "Item Add To Cart";
    }

    @Override
    public Cart findUserCart(Long userId) {
        Cart cart = cartRepository.findByUserId(userId);
//        CartItem cartItems = cartRepository.findCartItemByUserId(userId);

        int totalPrice = 0;
        int totalDiscountPrice = 0;
        int totalItem = 0;

        for (CartItem cartItem :cart.getCartItems()) {
            totalPrice = totalPrice+cartItem.getPrice();
            totalDiscountPrice = totalDiscountPrice+cartItem.getDiscountedPrice();
            totalItem = totalItem+cartItem.getQuantity();
        }
//
//            totalPrice = totalPrice+cartItems.getPrice();
//            totalDiscountPrice = totalDiscountPrice+cartItems.getDiscountedPrice();
//            totalItem = totalItem+cartItems.getQuantity();

        cart.setTotalDiscountedPrice(totalDiscountPrice);
        cart.setTotalItem(totalItem);
        cart.setTotalPrice(totalPrice);
        cart.setDiscount(totalPrice-totalDiscountPrice);

//        System.out.println(cartItems);
        return cartRepository.save(cart);
    }
}
