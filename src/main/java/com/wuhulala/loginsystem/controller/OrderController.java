package com.wuhulala.loginsystem.controller;

import com.alibaba.fastjson.JSON;
import com.wuhulala.loginsystem.annotation.FormToken;
import com.wuhulala.loginsystem.annotation.NeedAdminLogin;
import com.wuhulala.loginsystem.annotation.IsHaveOrder;
import com.wuhulala.loginsystem.annotation.NeedUserLogin;
import com.wuhulala.loginsystem.dal.model.Order;
import com.wuhulala.loginsystem.dal.model.Project;
import com.wuhulala.loginsystem.dal.model.User;
import com.wuhulala.loginsystem.dto.Page;
import com.wuhulala.loginsystem.dto.PageResult;
import com.wuhulala.loginsystem.service.OrderService;
import com.wuhulala.loginsystem.dto.BaseResult;
import com.wuhulala.loginsystem.dto.ReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2017/1/5
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseExceptionHandlerController{
    @Autowired
    private OrderService orderService;
    @InitBinder
    public void InitBinder(WebDataBinder dataBinder){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        dateFormatter.setLenient(false);
        dataBinder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormatter,true));
    }


    /**
     * 提交订单
     * @param order 订单
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @FormToken(removeToken = true)
    @NeedUserLogin
    public BaseResult<?> addOrder(Order order){
        BaseResult<?> result = new BaseResult<>();
        order.setState(0);
        int tmp = orderService.insert(order);
        if(tmp == 0){
           result.setReturnCode(ReturnCode.error);
        }
        return  result;
    }

    @RequestMapping(method = RequestMethod.GET)
    @NeedUserLogin
    public String getOrder(Model model,HttpSession session){
        int userId = ((User)session.getAttribute("loginUser")).getId();
        List<Order> orders = orderService.getOrderByUserId(userId);
        model.addAttribute("orders",orders);
        return  "my";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    @NeedAdminLogin
    public PageResult<Order> getOrder(Page page){
        PageResult<Order> result = orderService.getOrderByKeyword(page);
        return result;
    }

    @RequestMapping(value = "/{id}/detail",method = RequestMethod.GET)
    @IsHaveOrder
    public String orderInfo(@PathVariable("id")int id,Model model){
        Order order = orderService.getOrderById(id);
        model.addAttribute("order",order);
        model.addAttribute("projects", JSON.parseArray(order.getExtraInfo(), Project.class));
        return "orderdetail";
    }
}
