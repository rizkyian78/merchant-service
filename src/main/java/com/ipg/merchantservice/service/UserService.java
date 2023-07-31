package com.ipg.merchantservice.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ipg.merchantservice.entity.User;
import com.ipg.merchantservice.model.LoginRequest;
import com.ipg.merchantservice.model.LoginResponse;
import com.ipg.merchantservice.model.UserResponse;
import com.ipg.merchantservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {


    @Autowired
    UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public LoginResponse Login(LoginRequest body, Logger logger) {


        User user = userRepository.findFirstByEmail(body.email).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));
        logger.info("User found go to next process");

        if (!BCrypt.checkpw(body.password, user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid Password");
        }
        logger.info("compare password is pass go to next process");

        Algorithm algorithm = Algorithm.HMAC256("Halo");
        String jwt = JWT.create()
                .withClaim("userId", user.getId())
                .withClaim("email", user.getEmail())
                .withClaim("name", user.getName())
                .withClaim("realm", user.getRealm())
                .withExpiresAt(new Date(System.currentTimeMillis() + 360000))
                .sign(algorithm).toString();
        logger.info("Successfully login");

        return toLoginResponse(user, jwt);
    }

    private LoginResponse toLoginResponse(User user, String token) {
    return LoginResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .email(user.getEmail())
            .realm(user.getRealm())
            .token(token).build();
    }

    public UserResponse Me(String id) {

        User user = userRepository.findById(id).get();
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .partnerId(user.getPartnerId())
                .merchantId(user.getMerchantId())
                .name(user.getName())
                .realm(user.getRealm())
                .status(user.getStatus())
                .email(user.getEmail())
                .photoUrl(user.getPhotoUrl())
                .createdAt(user.getCreatedAt().toString())
                .updatedAt(user.getUpdatedAt().toString()).build();
    }
}
