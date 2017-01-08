package com.wuhulala.loginsystem.controller;

import com.wuhulala.loginsystem.annotation.NeedAdminLogin;
import com.wuhulala.loginsystem.dal.model.Project;
import com.wuhulala.loginsystem.dto.Page;
import com.wuhulala.loginsystem.dto.PageResult;
import com.wuhulala.loginsystem.service.ProjectService;
import com.wuhulala.loginsystem.dto.BaseResult;
import com.wuhulala.loginsystem.dto.ReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2017/1/5
 */
@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<Project> getAllProject(){
        return projectService.getAllProject();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @NeedAdminLogin

    public PageResult<Project> getOrder(Page page){
        PageResult<Project> result = projectService.getOrderByKeyword(page);
        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @NeedAdminLogin
    public BaseResult<?> addProject(Project project){
        BaseResult<?> result = new BaseResult<>();
        int tmp = projectService.insert(project);
        if(tmp == 0) result.setReturnCode(ReturnCode.error);
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    @NeedAdminLogin
    public BaseResult<?> updateOrder(Project project){
        BaseResult<?> result = new BaseResult<>();
        int tmp = projectService.update(project);
        if(tmp == 0) result.setReturnCode(ReturnCode.error);
        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    @NeedAdminLogin
    public BaseResult<?>  deleteOrder(Project project){
        BaseResult<?> result = new BaseResult<>();
        int tmp = projectService.delete(project);
        if(tmp == 0) result.setReturnCode(ReturnCode.error);
        return result;
    }
}
