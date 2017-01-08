package com.wuhulala.loginsystem.dal.mapper;

import com.wuhulala.loginsystem.dal.model.Order;
import com.wuhulala.loginsystem.dto.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2017/1/5
 */
public interface OrderMapper {

    @Insert("INSERT INTO tb_order (combo_name,org_name,phone,nick_name,submit_time,exam_time,price,state,create_time,extra_info,sex,user_id)"+
            "VALUES(#{comboName},#{orgName},#{phone},#{nickName},#{submitTime},#{examTime},#{price},#{state},#{createTime},#{extraInfo},#{sex},#{userId})")
    int insert(Order order);

    @Select("select * from tb_order where user_id = #{userId} order by id desc")
    List<Order> getOrderByUserId(@Param("userId")int userId);

    @Select("select * from tb_order " +
            "where combo_name like '%${page.keyword}%' or phone like '%${page.keyword}%' or nick_name like '%${page.keyword}%' " +
            "limit #{page.start},#{page.length}")
    List<Order> getOrderByKeyword(@Param("page") Page page);

    @Select("select count(*) from tb_order " +
            "where combo_name like '%${page.keyword}%' or phone like '%${page.keyword}%' or nick_name like '%${page.keyword}%' " )
    int getCountByKeyword(@Param("page") Page page);

    @Select("select count(*) from tb_order")
    int selectCount();

    @Select("select * from tb_order where id = #{id}")
    Order findById(@Param("id") int id);
}
