package com.hafidtech.spring_ecommerce.response;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class ApiResponse extends RuntimeException {

//    private static final long serialVersionUID = -6593330219878485669L;
    public Boolean status;
    public String message;

}
