package com.wuhulala.loginsystem.aop;

import com.wuhulala.loginsystem.dal.model.Order;
import com.wuhulala.loginsystem.dal.model.User;
import com.wuhulala.loginsystem.exception.AppRuntimeException;
import com.wuhulala.loginsystem.service.OrderService;
import com.wuhulala.loginsystem.dto.ReturnCode;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2017/1/8
 */
@Aspect
@Component
public class IsHaveOrderAspect {

    @Autowired
    OrderService orderService;

    @Pointcut("@annotation(com.wuhulala.loginsystem.annotation.IsHaveOrder)")
    public void isHaveOrder() {
    }

    @Before("isHaveOrder()")
    public void before(JoinPoint joinPoint) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;
        HttpServletRequest request = sra.getRequest();
        int orderId = (int) joinPoint.getArgs()[0];
        if(request.getSession(false).getAttribute("loginAdmin")!=null){
            return;
        }
        User loginUser = (User) request.getSession(false).getAttribute("loginUser");
        if(loginUser != null) {
            Order order = orderService.getOrderById(orderId);
            if(order.getUserId().equals(loginUser.getId())){
                return;
            }
        }
        throw new AppRuntimeException(ReturnCode.USER_IS_NOT_LOGIN);
    }
}
