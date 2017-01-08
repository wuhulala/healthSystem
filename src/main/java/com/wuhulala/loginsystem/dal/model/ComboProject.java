package com.wuhulala.loginsystem.dal.model;

public class ComboProject {

    private Integer comboId;
    private Integer projectId;

    public ComboProject() {
    }

    public ComboProject(Integer comboId, Integer projectId){
        super();
        this.comboId=comboId;
        this.projectId=projectId;
    }

    public Integer getComboId() {
        return comboId;
    }

    public void setComboId(Integer comboId) {
        this.comboId = comboId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
