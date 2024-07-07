package com.hafidtech.spring_ecommerce.repository;

import com.hafidtech.spring_ecommerce.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
