package com.hafidtech.spring_ecommerce.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;
    private String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
