package com.wuhulala.loginsystem.controller;

import com.wuhulala.loginsystem.annotation.NeedAdminLogin;
import com.wuhulala.loginsystem.dal.model.Organization;
import com.wuhulala.loginsystem.dto.Page;
import com.wuhulala.loginsystem.dto.PageResult;
import com.wuhulala.loginsystem.service.OrganizationService;
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
 * @updateTime 2017/1/4
 */


@RequestMapping("/organization")
@Controller
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    private BaseResult<List<Organization>> getAllOrganization(){
        BaseResult<List<Organization>> result = new BaseResult<>();
        List<Organization>organizations = organizationService.getAllOrganization();
        result.setData(organizations);
        return result;
    }

    @RequestMapping(value = "/least",method = RequestMethod.GET)
    @ResponseBody
    private BaseResult<List<Organization>> getLeastOrganization(){
        BaseResult<List<Organization>> result = new BaseResult<>();
        List<Organization>organizations = organizationService.getLeastOrganization();
        result.setData(organizations);
        return result;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @NeedAdminLogin
    public PageResult<Organization> getOrganization(Page page){
        PageResult<Organization> result = organizationService.getOrderByKeyword(page);
        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @NeedAdminLogin
    public BaseResult<?> addOrganization(Organization organization){
        BaseResult<?> result = new BaseResult<>();
        organization.setPicture("assets/images/o1.jpg");
        int tmp = organizationService.insert(organization);
        if(tmp == 0) result.setReturnCode(ReturnCode.error);
        return result;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    @NeedAdminLogin
    public BaseResult<?> updateOrganization(Organization project){
        BaseResult<?> result = new BaseResult<>();
        int tmp = organizationService.update(project);
        if(tmp == 0) result.setReturnCode(ReturnCode.error);
        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    @NeedAdminLogin
    public BaseResult<?>  deleteOrganization(Organization project){
        BaseResult<?> result = new BaseResult<>();
        int tmp = organizationService.delete(project);
        if(tmp == 0) result.setReturnCode(ReturnCode.error);
        return result;
    }
}
