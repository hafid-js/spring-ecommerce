package com.hafidtech.spring_ecommerce.model;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentInformation {

    @Column(name = "cardholder_name")
    private String cardHolderName;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "cvv")
    private String cvv;

    public PaymentInformation(String cardHolderName, String cardNumber, LocalDate expirationDate, String cvv) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }
}
