package com.hafidtech.spring_ecommerce.service.impl;

import com.hafidtech.spring_ecommerce.config.JwtProvider;
import com.hafidtech.spring_ecommerce.exception.UserException;
import com.hafidtech.spring_ecommerce.model.User;
import com.hafidtech.spring_ecommerce.repository.UserRepository;
import com.hafidtech.spring_ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User findUserById(Long userId) throws UserException {

        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        }

        throw new UserException("user not found with id : " + userId);
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {
        String email = jwtProvider.getEmailFromToken(jwt);

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UserException("user not found with email" + email);
        }
        return user;
    }
}
