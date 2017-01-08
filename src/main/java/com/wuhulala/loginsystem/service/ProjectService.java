package com.wuhulala.loginsystem.service;

import com.wuhulala.loginsystem.dal.mapper.ProjectMapper;
import com.wuhulala.loginsystem.dal.model.Project;
import com.wuhulala.loginsystem.dto.Page;
import com.wuhulala.loginsystem.dto.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2017/1/6
 */
@Service
public class ProjectService {
    @Autowired
    private ProjectMapper projectMapper;


    public PageResult<Project> getOrderByKeyword(Page page) {
        PageResult<Project>result = new PageResult<>(page);
        result.setData(projectMapper.getProjectByKeyword(page));
        result.setDraw(page.getDraw());
        result.setRecordsFiltered(projectMapper.getCountByKeyword(page));
        result.setRecordsTotal(projectMapper.selectCount());
        return result;
    }

    public int insert(Project project) {
        return projectMapper.insert(project);
    }

    public int delete(Project project) {
        return projectMapper.delete(project);
    }

    public int update(Project project) {

        projectMapper.update(project);
        return 1;
    }

    public List<Project> getAllProject() {
        return projectMapper.getAll();
    }
}
