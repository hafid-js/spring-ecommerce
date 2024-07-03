package com.hafidtech.spring_ecommerce.response;

import lombok.Data;

@Data
public class AuthResponse {

    private String jwt;
    private String message;

    public AuthResponse() {
        this.jwt = jwt;
        this.message = message;
    }
}
