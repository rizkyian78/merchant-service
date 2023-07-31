package com.ipg.merchantservice.route;

import com.ipg.merchantservice.entity.User;
import com.ipg.merchantservice.model.ApiResponse;
import com.ipg.merchantservice.model.LoginRequest;
import com.ipg.merchantservice.model.LoginResponse;
import com.ipg.merchantservice.model.UserResponse;
import com.ipg.merchantservice.repository.UserRepository;
import com.ipg.merchantservice.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRouter {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<LoginResponse> Login(@RequestBody LoginRequest body) {
        Logger logger = LoggerFactory.getLogger("/Login");
        LoginResponse data = userService.Login(body, logger);
        return ApiResponse.<LoginResponse>builder().data(data).build();
    }

    @GetMapping(value = "/users/me", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<UserResponse> Me(HttpServletRequest request) {
        String id = (String) request.getAttribute("id");
        UserResponse user = userService.Me(id);
        return ApiResponse.<UserResponse>builder().data(user).build();
    }
}
