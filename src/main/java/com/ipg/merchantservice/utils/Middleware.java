package com.ipg.merchantservice.utils;

import com.ipg.merchantservice.middleware.AuditInterceptor;
import com.ipg.merchantservice.middleware.AuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration()
@EnableWebMvc
public class Middleware implements WebMvcConfigurer {

    @Autowired
    AuditInterceptor auditInterceptor;

    @Autowired
    AuthorizationInterceptor authorizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(auditInterceptor);
        interceptorRegistry.addInterceptor(authorizationInterceptor ).excludePathPatterns("/login");
    }
    private void excludePatterns() {

    };

}
