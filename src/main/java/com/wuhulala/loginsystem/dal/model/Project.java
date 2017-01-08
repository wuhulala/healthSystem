package com.wuhulala.loginsystem.dal.model;

public class Project {

    private Integer id;
    private String name;
    private Float price;
    private String comments;

    public Project() {
    }

    public  Project(Integer id, String name, Float price, String comments){
        super();
        this.id = id;
        this.name=name;
        this.price=price;
        this.comments=comments;

    }

    public  Project(String name,Float price,String comments){
        super();
        this.name=name;
        this.price=price;
        this.comments=comments;

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
