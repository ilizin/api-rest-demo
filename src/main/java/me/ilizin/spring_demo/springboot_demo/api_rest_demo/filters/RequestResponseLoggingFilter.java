package me.ilizin.spring_demo.springboot_demo.api_rest_demo.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.ilizin.spring_demo.springboot_demo.api_rest_demo.controllers.StringRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public  class RequestResponseLoggingFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(StringRestController.class);

    @Override
    public void doFilter(jakarta.servlet.ServletRequest request, jakarta.servlet.ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            logger.info("Logging Request  {} : {}", httpServletRequest.getMethod(), httpServletRequest.getRequestURI());
            chain.doFilter(request, response);
            logger.info("Logging Response :{}", httpServletResponse.getContentType());
        } else {
            chain.doFilter(request, response);
        }
    }
}
