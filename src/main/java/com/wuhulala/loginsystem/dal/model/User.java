package com.wuhulala.loginsystem.dal.model;

import java.util.Date;

/**
 * Created by minglin on 2016/12/3.
 */
public class User {

    public User() {
    }

    public User(Integer id,String nickName,String phone,String cardId){
        super();
        this.id = id;
        this.nickName = nickName;
        this.phone = phone;
        this.cardId = cardId;
    }

    private Integer id;
    private String name;
    private String password;
    private String nickName = "";
    private String phone = "";
    private Date birth = new Date();
    private String sex = "";
    private String cardType="";
    private String cardId="";
    private String email="";
    private Integer isMarried= 0;

    public Integer getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(Integer isMarried) {
        this.isMarried = isMarried;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", birth=" + birth +
                ", sex='" + sex + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardId='" + cardId + '\'' +
                ", email='" + email + '\'' +
                ", isMarried=" + isMarried +
                '}';
    }
}
