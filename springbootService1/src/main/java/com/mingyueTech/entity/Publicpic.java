package com.mingyueTech.entity;

import java.util.Date;

public class Publicpic {
    private Integer id;

    private Integer bId;

    private String context;

    private String picone;

    private String pictwo;

    private String picthree;

    private Date ctime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getPicone() {
        return picone;
    }

    public void setPicone(String picone) {
        this.picone = picone == null ? null : picone.trim();
    }

    public String getPictwo() {
        return pictwo;
    }

    public void setPictwo(String pictwo) {
        this.pictwo = pictwo == null ? null : pictwo.trim();
    }

    public String getPicthree() {
        return picthree;
    }

    public void setPicthree(String picthree) {
        this.picthree = picthree == null ? null : picthree.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}