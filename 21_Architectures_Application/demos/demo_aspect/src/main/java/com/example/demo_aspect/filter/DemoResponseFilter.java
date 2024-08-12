package com.example.demo_aspect.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//Enregister un filtre dans le container de servlets
@WebFilter(filterName = "responseFilter")
public class DemoResponseFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Response filter");
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendError(500, "Impossible de charger la page");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
