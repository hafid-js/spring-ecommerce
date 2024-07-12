package com.hafidtech.spring_ecommerce.controller;

import com.hafidtech.spring_ecommerce.exception.CartItemException;
import com.hafidtech.spring_ecommerce.exception.UserException;
import com.hafidtech.spring_ecommerce.model.User;
import com.hafidtech.spring_ecommerce.response.ApiResponse;
import com.hafidtech.spring_ecommerce.service.CartItemService;
import com.hafidtech.spring_ecommerce.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart_items")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UserService userService;

    @DeleteMapping("/{cartItemId}")
    @Operation(description = "Remove Cart Item From Cart")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(description = "Delete Item")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable Long cartItemId,
                                                      @RequestHeader("Authorization") String jwt) throws UserException, CartItemException {
        User user = userService.findUserProfileByJwt(jwt);
        cartItemService.removeCartItem(user.getId(), cartItemId);

        ApiResponse res = new ApiResponse();
        res.setMessage("delete item from cart");
        res.setStatus(true);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}
