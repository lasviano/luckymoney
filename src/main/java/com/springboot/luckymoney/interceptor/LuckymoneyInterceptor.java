package com.springboot.luckymoney.interceptor;

import com.bimface.gateway.interceptor.bean.GatewayRequired;
import com.bimface.gateway.interceptor.bean.GatewayRequiredReader;
import com.bimface.gateway.interceptor.bean.RequestMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.List;

@Component
public class LuckymoneyInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(LuckymoneyInterceptor.class);

    private static final String XML_FILE = "context/gateway-required.xml";
    private static List<GatewayRequired> list;

    @PostConstruct
    public void init(){
        try {
            InputStream inputStream =getClass().getClassLoader().getResourceAsStream(XML_FILE);
            GatewayRequiredReader handler = new GatewayRequiredReader();
            SAXParserFactory.newInstance().newSAXParser().parse(inputStream,handler);
            list = handler.get();
        } catch (Exception e) {
            logger.info("read xml fail,xml="+XML_FILE,e);
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("do preHandle");
        if (!filterRequest(request)){
            return true;
        }
//        logger.info("被拦截");
        //token认证
        return true;
    }

    private boolean filterRequest(HttpServletRequest request) {
        if (list == null || list.size()<1){
            return true;
        }
        RequestMatcher matcher = null;
        for (GatewayRequired e:list){
            matcher = new RequestMatcher(e.getPattern(),e.getMethod().toUpperCase());
            if (matcher.matches(request)){
                return e.isRequired();
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
//        logger.info("do postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
//        logger.info("do afterCompletion");
    }
}
