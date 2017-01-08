package com.wuhulala.loginsystem.controller;

import com.wuhulala.loginsystem.annotation.NeedAdminLogin;
import com.wuhulala.loginsystem.dal.model.Combo;
import com.wuhulala.loginsystem.dal.model.Project;
import com.wuhulala.loginsystem.dto.Page;
import com.wuhulala.loginsystem.dto.PageResult;
import com.wuhulala.loginsystem.service.ComboService;
import com.wuhulala.loginsystem.dto.BaseResult;
import com.wuhulala.loginsystem.dto.ReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2017/1/4
 */


@RequestMapping("/combo")
@Controller
public class ComboController {

    @Autowired
    private ComboService comboService;

    @RequestMapping(value = "/least",method = RequestMethod.GET)
    @ResponseBody
    private BaseResult<List<Combo>> getLeastCombo(){
        BaseResult<List<Combo>> result = new BaseResult<>();
        List<Combo>combos = comboService.getLeastCombo();
        result.setData(combos);
        return result;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    private BaseResult<List<Combo>> getAllCombo(){
        BaseResult<List<Combo>> result = new BaseResult<>();
        List<Combo>combos = comboService.getAllCombo();
        result.setData(combos);
        return result;
    }


    @RequestMapping(value = "/{id}/extra",method = RequestMethod.GET)
    @ResponseBody
    private BaseResult<List<Project>> getComboExtraProject(@PathVariable("id")int id){
        BaseResult<List<Project>> result = new BaseResult<>();
        List<Project>projects = comboService.getExtraProjectByComboId(id);
        result.setData(projects);
        return result;
    }

    @RequestMapping(value = "/{id}/project",method = RequestMethod.GET)
    @ResponseBody
    private BaseResult<List<Project>> getComboProject(@PathVariable("id")int id){
        BaseResult<List<Project>> result = new BaseResult<>();
        List<Project>projects = comboService.getProjectByComboId(id);
        result.setData(projects);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @NeedAdminLogin
    public PageResult<Combo> getOrganization(Page page){
        PageResult<Combo> result = comboService.getByKeyword(page);
        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @NeedAdminLogin
    public BaseResult<?> addOrganization(Combo combo,@RequestParam("projectId")ArrayList<Integer> projectIds){
        BaseResult<?> result = new BaseResult<>();
        combo.setPicture("assets/images/combo1.jpg");
        int tmp = comboService.insert(combo,projectIds);
        if(tmp == 0) result.setReturnCode(ReturnCode.error);
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    @NeedAdminLogin
    public BaseResult<?> updateOrganization(Combo combo,@RequestParam("projectId")ArrayList<Integer> projectIds){
        System.out.println(projectIds.toString());
        BaseResult<?> result = new BaseResult<>();

        int tmp = comboService.update(combo,projectIds);
        if(tmp == 0) result.setReturnCode(ReturnCode.error);
        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    @NeedAdminLogin
    public BaseResult<?>  deleteOrganization(Combo combo){
        BaseResult<?> result = new BaseResult<>();
        int tmp = comboService.delete(combo);
        if(tmp == 0) result.setReturnCode(ReturnCode.error);
        return result;
    }


}
