package com.hafidtech.spring_ecommerce.service;

import com.hafidtech.spring_ecommerce.model.Product;
import com.hafidtech.spring_ecommerce.request.CreateProductRequest;

public interface ProductService {

    public Product createProduct(CreateProductRequest request);
}
