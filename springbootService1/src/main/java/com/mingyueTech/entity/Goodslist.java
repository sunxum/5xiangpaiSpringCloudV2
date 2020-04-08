package com.mingyueTech.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Goodslist {
    private Integer glId;

    private String goodsName;

    private BigDecimal goodsPrice;

    private String goodsPic;

    private BigDecimal goodsReservePrice;

    private String goodsCategory;

    private Integer goodsNum;

    private BigDecimal goodsUpMoney;

    private BigDecimal goodsDownMoney;

    private Date beginTime;

    private Date endTime;

    private Integer goodsStatus;

    private String taobaoUrl;

    private BigDecimal taobaoPrice;

    private String taobaoSaleusername;

    private Integer publicUserid;

    private Date ctime;

    private String goodsDesc;

    public Integer getGlId() {
        return glId;
    }

    public void setGlId(Integer glId) {
        this.glId = glId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic == null ? null : goodsPic.trim();
    }


    public BigDecimal getGoodsReservePrice() {
		return goodsReservePrice;
	}

	public void setGoodsReservePrice(BigDecimal goodsReservePrice) {
		this.goodsReservePrice = goodsReservePrice;
	}

	public String getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory == null ? null : goodsCategory.trim();
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public BigDecimal getGoodsUpMoney() {
        return goodsUpMoney;
    }

    public void setGoodsUpMoney(BigDecimal goodsUpMoney) {
        this.goodsUpMoney = goodsUpMoney;
    }

    public BigDecimal getGoodsDownMoney() {
        return goodsDownMoney;
    }

    public void setGoodsDownMoney(BigDecimal goodsDownMoney) {
        this.goodsDownMoney = goodsDownMoney;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getTaobaoUrl() {
        return taobaoUrl;
    }

    public void setTaobaoUrl(String taobaoUrl) {
        this.taobaoUrl = taobaoUrl == null ? null : taobaoUrl.trim();
    }

    public BigDecimal getTaobaoPrice() {
        return taobaoPrice;
    }

    public void setTaobaoPrice(BigDecimal taobaoPrice) {
        this.taobaoPrice = taobaoPrice;
    }

    public String getTaobaoSaleusername() {
        return taobaoSaleusername;
    }

    public void setTaobaoSaleusername(String taobaoSaleusername) {
        this.taobaoSaleusername = taobaoSaleusername == null ? null : taobaoSaleusername.trim();
    }

    public Integer getPublicUserid() {
        return publicUserid;
    }

    public void setPublicUserid(Integer publicUserid) {
        this.publicUserid = publicUserid;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
    }
}