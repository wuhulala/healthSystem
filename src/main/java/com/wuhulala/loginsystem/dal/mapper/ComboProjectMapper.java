package com.wuhulala.loginsystem.dal.mapper;

import com.wuhulala.loginsystem.dal.model.ComboProject;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ComboProjectMapper {
    @Select("select project_id from tb_combo_project where combo_id = #{comboId}")
    List<Integer> getProjectIdsByComboId(@Param("comboId") int comboId);

    @Delete("delete from tb_combo_project where combo_id = #{id}")
    void deleteByComboId(@Param("id") Integer id);

    void insertList(List<ComboProject>list);
}
