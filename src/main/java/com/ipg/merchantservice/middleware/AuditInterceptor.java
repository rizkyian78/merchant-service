package com.ipg.merchantservice.middleware;

import com.ipg.merchantservice.entity.Audit;
import com.ipg.merchantservice.repository.AuditRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AuditInterceptor implements HandlerInterceptor {

@Autowired
AuditRepository auditRepository;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!request.getMethod().equals(HttpMethod.GET.name())) {
            Audit audit = new Audit();
            audit.setIpAddress(request.getRemoteAddr());
            audit.setAccessEndpoint(request.getRequestURI());
            audit.setControllerGroup("Merchant-Service");
            auditRepository.save(audit);
        }
        return true; // Return true to continue the request processing, or false to stop it.
    }

        @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // Post-processing logic here
    }

}
