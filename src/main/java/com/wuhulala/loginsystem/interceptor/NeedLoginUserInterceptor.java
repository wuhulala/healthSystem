package com.wuhulala.loginsystem.interceptor;

import com.wuhulala.loginsystem.annotation.NeedUserLogin;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2017/1/8
 */
public class NeedLoginUserInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        NeedUserLogin needUserLogin = method.getAnnotation(NeedUserLogin.class);
        if(needUserLogin != null) {
            if (request.getSession(false).getAttribute("loginUser") == null) {
                response.sendRedirect("/index.html");
            }
        }
        return true;
    }



}
