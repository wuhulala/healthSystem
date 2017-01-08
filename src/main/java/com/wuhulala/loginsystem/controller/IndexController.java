package com.wuhulala.loginsystem.controller;

import com.wuhulala.loginsystem.annotation.FormToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2017/1/4
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/{index}.html")
    public String html(@PathVariable("index")String index){
        return index;
    }


    @RequestMapping("/appointment")
    @FormToken(generatorToken = true)
    public String appointment(){
        return "appointment";
    }
}
