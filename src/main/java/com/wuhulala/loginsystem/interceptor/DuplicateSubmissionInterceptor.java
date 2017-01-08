package com.wuhulala.loginsystem.interceptor;

import com.wuhulala.loginsystem.annotation.FormToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2017/1/8
 */
public class DuplicateSubmissionInterceptor extends HandlerInterceptorAdapter {
    private final static Logger log = LoggerFactory.getLogger(DuplicateSubmissionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        FormToken token = method.getAnnotation(FormToken.class);
        if (token != null) {
            boolean generatorToken = token.generatorToken();
            if (generatorToken) {
                request.getSession(false).setAttribute("formToken", UUID.randomUUID().toString());
            }
            boolean removeToken = token.removeToken();
            if (removeToken) {
                if (isRepeatSubmit(request)) {
                    log.warn(request.getRemoteAddr()+"：想重复提交表单，但是已被拦截");
                    return false;
                }
                request.getSession(false).removeAttribute("formToken");
            }
        }
        return true;
    }

    private boolean isRepeatSubmit(HttpServletRequest request) {
        String serverToken = (String) request.getSession(false).getAttribute("formToken");
        if (serverToken == null) {
            return true;
        }
        String clientToken = request.getParameter("formToken");
        return clientToken == null || !serverToken.equals(clientToken);
    }

}
