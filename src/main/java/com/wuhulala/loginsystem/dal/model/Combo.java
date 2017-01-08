package com.wuhulala.loginsystem.dal.model;


public class Combo {

    private Integer id;
    private String name;
    private Double price;
    private String picture;

    public Combo(){

    }

    public Combo(String name, Double price) {
        super();
        this.name = name;
        this.price = price;
    }

    public Combo(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Combo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
