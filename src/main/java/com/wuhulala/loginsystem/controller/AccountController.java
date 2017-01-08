package com.wuhulala.loginsystem.controller;

import com.wuhulala.loginsystem.dal.model.Account;
import com.wuhulala.loginsystem.service.AccountService;
import com.wuhulala.loginsystem.dto.BaseResult;
import com.wuhulala.loginsystem.dto.ReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2016/12/25
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResult<Account> login(String name, String password, HttpSession session){

        BaseResult<Account> result = new BaseResult<>();
        Account account = accountService.login(name,password);
        if(null == account){
            result.setReturnCode(ReturnCode.LOGIN_ERROR);
        }else{
            session.setAttribute("loginAdmin",account);
            result.setData(account);
        }
        return result;
    }



    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public BaseResult<?> register(String name, String password){
        BaseResult<?> result = new BaseResult<>();
        int tmp = accountService.register(name,password);
        if(tmp == 1) result.setReturnCode(ReturnCode.REGISTER_NAME_IS_EXIST);
        if(tmp == 2) result.setReturnCode(ReturnCode.REGISTER_ERROR);
        if(tmp == 3) result.setReturnCode(ReturnCode.REGISTER_SUCCESS);
        return result;
    }

    @RequestMapping(value = "/{id}/pass",method = RequestMethod.PUT)
    public BaseResult<?> editPass(@PathVariable("id") Long id,
                                  @RequestParam("password") String password,
                                  @RequestParam("new_password")String newPassword){
        BaseResult<?> result = new BaseResult<>();
        int tmp = accountService.editPassword(id,password,newPassword);

        if(tmp == 0) result.setReturnCode(ReturnCode.EDIT_PASS_ERROR);
        if(tmp == 1) result.setReturnCode(ReturnCode.EDIT_PASS_PASSWORD_IS_ERROR);
        if(tmp == 2) result.setReturnCode(ReturnCode.SUCCESS);

        return result;
    }
}
