package com.example.real.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TransactionalServicesInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("++++++++++++++++++++++");
        System.out.println("understanding pre handle");
        System.out.println("+++++++++++++++++");
        return true;

    }
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) {
        System.out.println("-------------------------------------");
        System.out.println("Post Handle method learning");
        System.out.println("----------------------------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) {
        System.out.println("*******************************");
        System.out.println("Request and Response is completed");
    }
}