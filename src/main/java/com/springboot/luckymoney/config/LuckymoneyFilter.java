package com.springboot.luckymoney.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@Component
@WebFilter(urlPatterns = {"/*"},filterName = "luckymoneyFilter")
public class LuckymoneyFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LuckymoneyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("filter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("执行filter");
    }

    @Override
    public void destroy() {
        logger.info("filter销毁");
    }
}
