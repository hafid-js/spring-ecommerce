package com.hafidtech.spring_ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Size {

    private String name;
    private int quantity;

    public Size(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
