package com.ipg.merchantservice.route;

import com.ipg.merchantservice.entity.User;
import com.ipg.merchantservice.model.login.*;
import com.ipg.merchantservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRouter {

    @Autowired
    public UserService userService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String Login(@RequestBody LoginRequest body) {
        userService.Login(1);

        return "okeee";
    }
}
