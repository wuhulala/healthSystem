package com.wuhulala.loginsystem.dal.model;

public class Organization {

    public  Organization(){

    }

    public  Organization(Integer id,String name,String address,String description,String phone){
        super();
        this.id=id;
        this.name=name;
        this.address=address;
        this.description=description;
        this.phone=phone;
    }

    public  Organization(String name,String address,String description,String phone){
        super();
        this.name=name;
        this.address=address;
        this.description=description;
        this.phone=phone;
    }

    private Integer id;
    private String name;
    private String address;
    private String description;
    private String phone;
    private String picture;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
