package com.amigoscode.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

// TODO: 17 - Implement a logging filter:
//  - Annotate this class with @Component
//  - Implement the Filter interface (jakarta.servlet.Filter)
//  - Override the doFilter method
//  - Before calling chain.doFilter(), print the HTTP method and URI:
//    HttpServletRequest req = (HttpServletRequest) request;
//    System.out.println(req.getMethod() + " " + req.getRequestURI());
//  - After calling chain.doFilter(), print the response status:
//    HttpServletResponse res = (HttpServletResponse) response;
//    System.out.println("Response status: " + res.getStatus());

@Component
public class LoggingFilter implements Filter {


    @Override
        public void doFilter(ServletRequest servletRequest,
                             ServletResponse servletResponse,
                             FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println(request.getMethod() + " " + request.getRequestURI());

        chain.doFilter(servletRequest,servletResponse);

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("Response status: " + response.getStatus());



    }


}
