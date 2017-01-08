package com.wuhulala.loginsystem.controller;

import com.wuhulala.loginsystem.annotation.NeedAdminLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2017/1/6
 */
@Controller
public class AdminViewController {
    @RequestMapping("/admin/{name}.htm")
    @NeedAdminLogin
    public String getAdminView(@PathVariable("name")String name){
        return "/admin/"+name;
    }
}
