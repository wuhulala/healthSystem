package com.wuhulala.loginsystem.dto;

import java.util.List;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2017/1/6
 */
public class PageResult<T>{
    private Page query;
    private int draw;
    private List<T> data;
    private int recordsTotal;
    private int recordsFiltered;

    public PageResult() {
    }

    public PageResult(Page page) {
        this.query = page;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}
