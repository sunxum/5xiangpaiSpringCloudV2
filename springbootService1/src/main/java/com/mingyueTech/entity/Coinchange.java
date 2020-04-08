package com.mingyueTech.entity;

import java.util.Date;

public class Coinchange {
    private Integer id;

    private Integer uId;

    private Integer freecoin;

    private Integer paycoin;

    private Integer practivicoin;

    private Date ctime;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getFreecoin() {
        return freecoin;
    }

    public void setFreecoin(Integer freecoin) {
        this.freecoin = freecoin;
    }

    public Integer getPaycoin() {
        return paycoin;
    }

    public void setPaycoin(Integer paycoin) {
        this.paycoin = paycoin;
    }

    public Integer getPractivicoin() {
        return practivicoin;
    }

    public void setPractivicoin(Integer practivicoin) {
        this.practivicoin = practivicoin;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}