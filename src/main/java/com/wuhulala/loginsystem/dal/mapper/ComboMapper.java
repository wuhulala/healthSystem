package com.wuhulala.loginsystem.dal.mapper;

import com.wuhulala.loginsystem.dal.model.Combo;
import com.wuhulala.loginsystem.dto.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 账户
 *
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2016/12/25
 */
public interface ComboMapper {

    @Select("select * from tb_combo limit 0,6")
    List<Combo>getLeastCombos();

    @Select("select * from tb_combo")
    List<Combo>getAllCombos();

    @Select("select * from tb_combo " +
            "where name like '%${page.keyword}%' " +
            "limit #{page.start},#{page.length}")
    List<Combo> getByKeyword(@Param("page") Page page);

    @Select("select count(*) from tb_combo " +
            "where name like '%${page.keyword}%' ")
    int getCountByKeyword(@Param("page") Page page);

    @Select("select count(*) from tb_combo ")
    int selectCount();


    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO tb_combo ( name, price, picture) \n" +
            "VALUES\n" +
            "  ( #{name}, #{price}, #{picture})")
    void insert(Combo combo);

    @Update("UPDATE \n" +
            " .tb_combo \n" +
            "SET\n" +
            "  name = #{name},\n" +
            "  price = #{price}\n" +
            "WHERE id = #{id} ")
    int update(Combo combo);
    @Delete("DELETE \n" +
            "FROM\n" +
            "  tb_combo \n" +
            "WHERE id = #{id}")
    int delete(Combo combo);
}
