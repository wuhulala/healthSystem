package com.wuhulala.loginsystem.service;

import com.wuhulala.loginsystem.dal.mapper.OrganizationMapper;
import com.wuhulala.loginsystem.dal.model.Organization;
import com.wuhulala.loginsystem.dto.Page;
import com.wuhulala.loginsystem.dto.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2017/1/4
 */
@Service
public class OrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;

    //获取评价最高的机构
    public List<Organization> getLeastOrganization(){
        return organizationMapper.getLeastOrganizations();
    }
    //获取评价最高的机构
    public List<Organization> getAllOrganization(){
        return organizationMapper.getAllOrganizations();
    }


    public int insert(Organization organization) {
        return organizationMapper.insert(organization);
    }

    public int update(Organization organization) {
        return organizationMapper.update(organization);

    }

    public int delete(Organization organization) {
        return organizationMapper.delete(organization);
    }

    public PageResult<Organization> getOrderByKeyword(Page page) {
        PageResult<Organization>result = new PageResult<>(page);
        result.setData(organizationMapper.getByKeyword(page));
        result.setDraw(page.getDraw());
        result.setRecordsFiltered(organizationMapper.getCountByKeyword(page));
        result.setRecordsTotal(organizationMapper.selectCount());
        return result;
    }
}
