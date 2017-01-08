package com.wuhulala.loginsystem.interceptor;

import com.wuhulala.loginsystem.annotation.NeedAdminLogin;
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
public class NeedLoginAdminInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        NeedAdminLogin needAdminLogin = method.getAnnotation(NeedAdminLogin.class);
        if(needAdminLogin != null) {
            if (null == request.getSession(false).getAttribute("loginAdmin")) {
                response.sendRedirect("/index.html");
            }
        }
        return true;
    }



}
