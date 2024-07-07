package com.hafidtech.spring_ecommerce.service;

import com.hafidtech.spring_ecommerce.config.JwtProvider;
import com.hafidtech.spring_ecommerce.exception.UserException;
import com.hafidtech.spring_ecommerce.model.User;
import com.hafidtech.spring_ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

public interface UserService {

    public User findUserById(Long userId) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;
}
