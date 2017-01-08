package com.wuhulala.loginsystem.dal.mapper;

import com.wuhulala.loginsystem.dal.model.Organization;
import com.wuhulala.loginsystem.dto.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 医院
 *
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2016/12/25
 */
public interface OrganizationMapper {

    @Select("select * from tb_organization limit 0,6")
    List<Organization>getLeastOrganizations();

    @Select("select * from tb_organization")
    List<Organization> getAllOrganizations();

    @Select("select * from tb_organization " +
            "where name like '%${page.keyword}%' or phone like '%${page.keyword}%' or address like '%${page.keyword}%' " +
            "limit #{page.start},#{page.length}")
    List<Organization> getByKeyword(@Param("page") Page page);
    @Select("select count(*) from tb_organization " +
            "where name like '%${page.keyword}%' or phone like '%${page.keyword}%' or address like '%${page.keyword}%' ")
    int getCountByKeyword(@Param("page") Page page);

    @Select("select count(*) from tb_organization ")
    int selectCount();

    @Insert("INSERT INTO health.tb_organization (\n" +
            "  name,\n" +
            "  address,\n" +
            "  description,\n" +
            "  phone,\n" +
            "  picture\n" +
            ") \n" +
            "VALUES\n" +
            "  (\n" +
            "    #{name},\n" +
            "    #{address},\n" +
            "    #{description},\n" +
            "    #{phone},\n" +
            "    #{picture}\n" +
            "  ) ;")
    int insert(Organization organization);

    @Update("UPDATE \n" +
            "  tb_organization \n" +
            "SET\n" +
            "  name = #{name},\n" +
            "  address = #{address},\n" +
            "  description = #{description},\n" +
            "  phone = #{phone}\n" +
            "WHERE id = #{id} ;")
    int update(Organization organization);

    @Delete("DELETE \n" +
            "FROM\n" +
            "  tb_organization \n" +
            "WHERE id = #{id} ;")
    int delete(Organization organization);

}
