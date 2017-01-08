package com.wuhulala.loginsystem.dal.mapper;

import com.wuhulala.loginsystem.dal.model.Account;
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
public interface AccountMapper {

    @Select("select * from tb_admin where name = #{name} and password = #{password} limit 1")
    Account login(Account account);

    @Select("select * from tb_admin where name = #{name}")
    Account findByName(@Param("name") String name);

    @Update("update tb_admin set last_login = #{lastLogin} where id = #{id}")
    void updateLastLogin(Account account);

    @Insert("insert into tb_admin(name,password) values(#{name},#{password})")
    void insert(Account account);

    @Update("update tb_admin set password = #{password} where id = #{id}")
    void updatePassword(Account account);

    @Select("select * from tb_admin where id = #{id} limit 1")
    Account findById(@Param("id") Long id);
}
