package com.wuhulala.loginsystem.controller;

import com.wuhulala.loginsystem.dal.model.User;
import com.wuhulala.loginsystem.service.UserService;
import com.wuhulala.loginsystem.dto.BaseResult;
import com.wuhulala.loginsystem.dto.ReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2017/1/5
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<?> register(User model){
        BaseResult<?> result = new BaseResult<>();
        int tmp = userService.register(model);
        if(tmp == 1) result.setReturnCode(ReturnCode.REGISTER_NAME_IS_EXIST);
        if(tmp == 2) result.setReturnCode(ReturnCode.REGISTER_ERROR);
        if(tmp == 3) result.setReturnCode(ReturnCode.REGISTER_SUCCESS);
        return result;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<User> login(User model, HttpSession session){

        BaseResult<User> result = new BaseResult<>();
        User account = userService.login(model);
        if(null == account){
            result.setReturnCode(ReturnCode.LOGIN_ERROR);
        }else{
            session.setAttribute("loginUser",account);
            result.setData(account);
        }
        return result;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout( HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
