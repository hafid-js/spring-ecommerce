package com.hafidtech.spring_ecommerce.controller;

import com.hafidtech.spring_ecommerce.exception.ProductException;
import com.hafidtech.spring_ecommerce.exception.UserException;
import com.hafidtech.spring_ecommerce.model.Review;
import com.hafidtech.spring_ecommerce.model.User;
import com.hafidtech.spring_ecommerce.request.ReviewRequest;
import com.hafidtech.spring_ecommerce.service.ReviewService;
import com.hafidtech.spring_ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody ReviewRequest req,
        @RequestHeader("Authorization") String jwt) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(jwt);

        Review review = reviewService.createReview(req, user);

        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getProductsReview(@PathVariable Long productId) throws UserException, ProductException {

        List<Review> reviews = reviewService.getAllReview(productId);

        return new ResponseEntity<>(reviews, HttpStatus.CREATED);
    }
}
