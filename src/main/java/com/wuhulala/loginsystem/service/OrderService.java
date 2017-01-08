package com.wuhulala.loginsystem.service;

import com.wuhulala.loginsystem.dal.mapper.OrderMapper;
import com.wuhulala.loginsystem.dal.model.Order;
import com.wuhulala.loginsystem.dto.Page;
import com.wuhulala.loginsystem.dto.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2017/1/5
 */
@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;
    public int insert(Order order){
        return orderMapper.insert(order);
    }
    public List<Order> getOrderByUserId(int userId){
        return orderMapper.getOrderByUserId(userId);
    }


    public PageResult<Order> getOrderByKeyword(Page page) {
        PageResult<Order>result = new PageResult<>(page);
        result.setData(orderMapper.getOrderByKeyword(page));
        result.setDraw(page.getDraw());
        result.setRecordsFiltered(orderMapper.getCountByKeyword(page));
        result.setRecordsTotal(orderMapper.selectCount());
        return result;
    }

    public Order getOrderById(int id) {
        return orderMapper.findById(id);
    }
}
