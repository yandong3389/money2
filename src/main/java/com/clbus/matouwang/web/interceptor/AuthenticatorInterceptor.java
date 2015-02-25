package com.clbus.matouwang.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthenticatorInterceptor implements HandlerInterceptor {

    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exception) throws Exception {
        // TODO Auto-generated method stub
        
        System.out.println("afterCompletion.................");
        
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("postHandle.................");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        
        
        System.out.println("request.getRequestURL().toString(); -=========="  + request.getRequestURL().toString());
        System.out.println("request.getRequestURI().toString(); -=========="  + request.getRequestURI().toString());
        
        
        System.out.println("request.getLocalName()  =============" + request.getLocalName());
        System.out.println("request.getLocalAddr()  =============" + request.getLocalAddr());
        System.out.println("request.getServerName()  =============" + request.getServerName());
        
        
        System.out.println("preHandle.................");
        return true;
    }

}
