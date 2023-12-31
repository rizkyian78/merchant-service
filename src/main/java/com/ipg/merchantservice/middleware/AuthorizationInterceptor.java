package com.ipg.merchantservice.middleware;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.ipg.merchantservice.entity.User;
import com.ipg.merchantservice.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // Pre-processing logic here
        String header = request.getHeader("Authorization");
        if(header == null || header.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Header is not provided");
        }
        String[] getTypeAndBearer = header.split(" ", 2);

        if (getTypeAndBearer.length < 2 || !getTypeAndBearer[0].startsWith("Bearer")) {

            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid token provided");
        }

        String id = JWT.decode(getTypeAndBearer[1]).getClaim("userId").asString();

        User user = userRepository.findFirstById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User Not Authorized"));

        request.setAttribute("id", user.getId());
        return true; // Return true to continue the request processing, or false to stop it.
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        // Post-processing logic here
//        System.out.println("masok kemana 2");
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        // Cleanup logic here
//        System.out.println("masok kemana 3");
//    }
}
