package com.hafidtech.spring_ecommerce.service;

import com.hafidtech.spring_ecommerce.exception.ProductException;
import com.hafidtech.spring_ecommerce.model.Review;
import com.hafidtech.spring_ecommerce.model.User;
import com.hafidtech.spring_ecommerce.request.ReviewRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {

    public Review createReview(ReviewRequest request, User user) throws ProductException;
    public List<Review> getAllReview(Long productId);
}
