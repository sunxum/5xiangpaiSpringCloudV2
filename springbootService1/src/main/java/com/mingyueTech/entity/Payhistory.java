package com.mingyueTech.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Payhistory {
    private Integer id;

    private Integer uid;

    private String alipayOrderid;

    private String payOrderid;

    private BigDecimal paymoney;

    private Date ctime;

    private Date utime;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAlipayOrderid() {
        return alipayOrderid;
    }

    public void setAlipayOrderid(String alipayOrderid) {
        this.alipayOrderid = alipayOrderid == null ? null : alipayOrderid.trim();
    }

    public String getPayOrderid() {
        return payOrderid;
    }

    public void setPayOrderid(String payOrderid) {
        this.payOrderid = payOrderid == null ? null : payOrderid.trim();
    }

    public BigDecimal getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(BigDecimal paymoney) {
        this.paymoney = paymoney;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}