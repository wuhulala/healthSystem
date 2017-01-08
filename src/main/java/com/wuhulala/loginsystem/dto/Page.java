package com.wuhulala.loginsystem.dto;

/**
 * @author Wuhulala
 * @version 1.0
 * @updateTime 2017/1/6
 */
public class Page {
    private int start;
    private int draw;
    private int length;
    private String keyword;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
