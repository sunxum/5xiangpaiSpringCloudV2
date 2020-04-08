package com.mingyueTech.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Buyhistory {
    private Integer bId;

    private String orderId;

    private String orderType;

    private Integer uId;

    private Integer glId;

    private BigDecimal dealmoney;

    private Date ctime;

    private Integer areaAid;

    private String detailArea;

    private String userRealName;

    private String userRealMobile;

    private Integer postDetailId;

    private Date sendGoodsTime;

    private Date reciveGoodsTime;

    private String buystatus;

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getGlId() {
		return glId;
	}

	public void setGlId(Integer glId) {
		this.glId = glId;
	}

	public BigDecimal getDealmoney() {
        return dealmoney;
    }

    public void setDealmoney(BigDecimal dealmoney) {
        this.dealmoney = dealmoney;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getAreaAid() {
        return areaAid;
    }

    public void setAreaAid(Integer areaAid) {
        this.areaAid = areaAid;
    }

    public String getDetailArea() {
        return detailArea;
    }

    public void setDetailArea(String detailArea) {
        this.detailArea = detailArea == null ? null : detailArea.trim();
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName == null ? null : userRealName.trim();
    }

    public String getUserRealMobile() {
        return userRealMobile;
    }

    public void setUserRealMobile(String userRealMobile) {
        this.userRealMobile = userRealMobile == null ? null : userRealMobile.trim();
    }

    public Integer getPostDetailId() {
        return postDetailId;
    }

    public void setPostDetailId(Integer postDetailId) {
        this.postDetailId = postDetailId;
    }

    public Date getSendGoodsTime() {
        return sendGoodsTime;
    }

    public void setSendGoodsTime(Date sendGoodsTime) {
        this.sendGoodsTime = sendGoodsTime;
    }

    public Date getReciveGoodsTime() {
        return reciveGoodsTime;
    }

    public void setReciveGoodsTime(Date reciveGoodsTime) {
        this.reciveGoodsTime = reciveGoodsTime;
    }

    public String getBuystatus() {
        return buystatus;
    }

    public void setBuystatus(String buystatus) {
        this.buystatus = buystatus == null ? null : buystatus.trim();
    }
}