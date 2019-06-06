package com.springboot.luckymoney.config;

import com.springboot.luckymoney.interceptor.LuckymoneyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LuckyMoneyWebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LuckymoneyInterceptor luckymoneyInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(luckymoneyInterceptor).addPathPatterns("/*");
    }
}
