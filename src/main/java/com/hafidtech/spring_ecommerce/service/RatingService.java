package com.hafidtech.spring_ecommerce.service;

import com.hafidtech.spring_ecommerce.exception.ProductException;
import com.hafidtech.spring_ecommerce.model.Rating;
import com.hafidtech.spring_ecommerce.model.User;
import com.hafidtech.spring_ecommerce.request.RatingRequest;
import org.springframework.stereotype.Service;

@Service
public interface RatingService {

    public Rating createRating(RatingRequest request, User user) throws ProductException;
}
