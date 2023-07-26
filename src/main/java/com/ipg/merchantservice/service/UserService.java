package com.ipg.merchantservice.service;

import com.ipg.merchantservice.entity.User;
import com.ipg.merchantservice.repository.UserRepository;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Void Login(Integer id)  {

        return null;
    }
}
