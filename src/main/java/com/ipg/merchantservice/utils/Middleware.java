package com.ipg.merchantservice.utils;

import com.ipg.merchantservice.middleware.AuthorizationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@Configuration()
public class Middleware implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(new AuthorizationInterceptor()).excludePathPatterns(excludePatterns());
    }
    private ArrayList<String> excludePatterns() {
        final ArrayList<String> routerPatternExclude = new ArrayList<String>();
        routerPatternExclude.add("/login");
        return routerPatternExclude;
    };

}
