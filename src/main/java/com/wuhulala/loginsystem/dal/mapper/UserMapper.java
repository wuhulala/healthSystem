package com.wuhulala.loginsystem.dal.mapper;

import com.wuhulala.loginsystem.dal.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 账户
 *
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2016/12/25
 */
public interface UserMapper {

    @Select("select * from tb_user where name = #{name} and password = #{password} limit 1")
    User login(User account);

    @Select("select * from tb_user where name = #{name}")
    User findByName(@Param("name") String name);

   /* @Update("update tb_user set last_login = #{lastLogin} where id = #{id}")
    void updateLastLogin(User account);*/

    @Insert("insert into tb_user(name,password,phone) values(#{name},#{password},#{phone})")
    void insert(User account);

    @Update("update tb_user set password = #{password} where id = #{id}")
    void updatePassword(User account);

    @Select("select * from tb_user where id = #{id} limit 1")
    User findById(@Param("id") Long id);
}
