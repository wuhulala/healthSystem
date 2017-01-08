package com.wuhulala.loginsystem.controller;

import com.wuhulala.loginsystem.exception.AppRuntimeException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2016/11/29
 */

public abstract class BaseExceptionHandlerController {
    /** 基于@ExceptionHandler异常处理 */
    @ExceptionHandler
    public String exp(HttpServletRequest request, Exception ex) {
        String result = "index";
        // 根据不同错误转向不同页面
        if(ex instanceof AppRuntimeException) {
            result = "redirect:/index.html";
        }
        return result;
    }
}
