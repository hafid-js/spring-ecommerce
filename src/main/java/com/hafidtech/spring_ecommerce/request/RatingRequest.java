package com.hafidtech.spring_ecommerce.request;

import lombok.Data;

@Data
public class RatingRequest {

    private long productId;
    private double rating;
}
