package com.hafidtech.spring_ecommerce.request;

import lombok.Data;

import java.awt.*;

@Data
public class AddItemRequest {

    private Long productId;
    private String size;
    private int quantity;
    private Integer price;

    public AddItemRequest() {

    }
}
