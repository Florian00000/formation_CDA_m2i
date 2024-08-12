package com.example.correction_exercice_1.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.time.LocalDateTime;


@WebFilter(filterName = "LoggingFilter", urlPatterns = "*")
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //URI
        System.out.println("URI " + request.getRequestURI());
        //Method
        System.out.println("Method " + request.getMethod());
        //TimesTamp
        System.out.println("Timestamp "+ LocalDateTime.now().toString());
        //Client IP
        System.out.println("IP client " + request.getRemoteAddr());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
