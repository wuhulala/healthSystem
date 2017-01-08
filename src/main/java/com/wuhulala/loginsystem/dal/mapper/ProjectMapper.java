package com.wuhulala.loginsystem.dal.mapper;

import com.wuhulala.loginsystem.dal.model.Project;
import com.wuhulala.loginsystem.dal.provider.ProjectProvider;
import com.wuhulala.loginsystem.dto.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProjectMapper {
    @SelectProvider(type = ProjectProvider.class,method = "getProjectNotInIdList")
    List<Project> getProjectNotInIdList(@Param("ids") List<Integer>ids);

    @SelectProvider(type = ProjectProvider.class,method = "getProjectInIdList")
    List<Project> getProjectInIdList(@Param("ids")List<Integer>ids);

    @Select("select * from tb_project " +
            "where name like '%${page.keyword}%' " +
            "limit #{page.start},#{page.length}")
    List<Project> getProjectByKeyword(@Param("page") Page page);

    @Select("select count(*) from tb_project " +
            "where name like '%${page.keyword}%'" )
    int getCountByKeyword(@Param("page") Page page);

    @Select("select count(*) from tb_project")
    int selectCount();

    @Insert("INSERT INTO tb_project (name, price, comments)" +
            "VALUES" +
            "(#{name}, #{price}, #{comments})")
    int insert(Project project);

    @Update("UPDATE " +
            "tb_project " +
            "SET " +
            "name = #{name}, " +
            "price = #{price}, " +
            "comments = #{comments} " +
            "WHERE id = #{id}")
    int update(Project project);

    @Delete("DELETE " +
            "FROM " +
            "tb_project " +
            "WHERE id= #{id}")
    int delete(Project project);
    @Select("select * from tb_project")
    List<Project> getAll();

}
