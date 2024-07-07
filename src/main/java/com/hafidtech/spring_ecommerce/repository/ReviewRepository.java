package com.hafidtech.spring_ecommerce.repository;

import com.hafidtech.spring_ecommerce.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {


}
