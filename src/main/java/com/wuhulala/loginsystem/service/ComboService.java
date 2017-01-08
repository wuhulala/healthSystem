package com.wuhulala.loginsystem.service;

import com.wuhulala.loginsystem.dal.mapper.ComboMapper;
import com.wuhulala.loginsystem.dal.mapper.ComboProjectMapper;
import com.wuhulala.loginsystem.dal.mapper.ProjectMapper;
import com.wuhulala.loginsystem.dal.model.Combo;
import com.wuhulala.loginsystem.dal.model.ComboProject;
import com.wuhulala.loginsystem.dal.model.Project;
import com.wuhulala.loginsystem.dto.Page;
import com.wuhulala.loginsystem.dto.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2017/1/4
 */
@Service
public class ComboService {
    @Autowired
    private ComboMapper comboMapper;
    @Autowired
    private ComboProjectMapper comboProjectMapper;
    @Autowired
    private ProjectMapper projectMapper;

    //获取评价最高的套餐
    public List<Combo> getLeastCombo() {
        return comboMapper.getLeastCombos();
    }


    public List<Combo> getAllCombo() {
        return comboMapper.getAllCombos();
    }

    public List<Project> getExtraProjectByComboId(int comboId) {
        List<Project> result;
        List<Integer> projectIds = comboProjectMapper.getProjectIdsByComboId(comboId);
        result = projectMapper.getProjectNotInIdList(projectIds);
        return result;
    }

    public List<Project> getProjectByComboId(int id) {
        List<Project> result = new ArrayList<>();
        List<Integer> projectIds = comboProjectMapper.getProjectIdsByComboId(id);
        if (projectIds.size() < 1) return result;
        result = projectMapper.getProjectInIdList(projectIds);
        return result;
    }

    public PageResult<Combo> getByKeyword(Page page) {
        PageResult<Combo> result = new PageResult<>(page);
        result.setData(comboMapper.getByKeyword(page));
        result.setDraw(page.getDraw());
        result.setRecordsFiltered(comboMapper.getCountByKeyword(page));
        result.setRecordsTotal(comboMapper.selectCount());
        return result;
    }

    @Transactional
    public int insert(Combo combo, ArrayList<Integer> projectIds) {
        comboMapper.insert(combo);
        if (projectIds.size() > 0) {
            List<ComboProject>comboProjects = new ArrayList<>();
            for (int i = 0; i < projectIds.size(); i++) {
                comboProjects.add(new ComboProject(combo.getId(),projectIds.get(i)));
            }
            comboProjectMapper.insertList(comboProjects);
        }
        return 1;
    }

    @Transactional
    public int update(Combo combo, ArrayList<Integer> projectIds) {
        comboProjectMapper.deleteByComboId(combo.getId());
        if (projectIds.size() > 0) {
            List<ComboProject>comboProjects = new ArrayList<>();
            for (int i = 0; i < projectIds.size(); i++) {
                comboProjects.add(new ComboProject(combo.getId(),projectIds.get(i)));
            }
            comboProjectMapper.insertList(comboProjects);
        }
        comboMapper.update(combo);
        return 1;
    }

    public int delete(Combo combo) {
        return comboMapper.delete(combo);
    }
}