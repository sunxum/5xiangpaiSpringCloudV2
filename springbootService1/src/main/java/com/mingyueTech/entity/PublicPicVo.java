package com.mingyueTech.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PublicPicVo {

	private Integer pid;
	private Integer userId;
    private String userName;

    private String userHeader;
    private Integer goodsId;
    
    private String goodsName;
    
    private BigDecimal dealMoney;
    
    private Date dealTime;
    private BigDecimal goodsPrice;
    private String goodsPic;
    private String context;

    private String picone;

    private String pictwo;

    private String picthree;

    private Date ctime;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserHeader() {
		return userHeader;
	}

	public void setUserHeader(String userHeader) {
		this.userHeader = userHeader;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public BigDecimal getDealMoney() {
		return dealMoney;
	}

	public void setDealMoney(BigDecimal dealMoney) {
		this.dealMoney = dealMoney;
	}

	public Date getDealTime() {
		return dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
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
		this.goodsPic = goodsPic;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getPicone() {
		return picone;
	}

	public void setPicone(String picone) {
		this.picone = picone;
	}

	public String getPictwo() {
		return pictwo;
	}

	public void setPictwo(String pictwo) {
		this.pictwo = pictwo;
	}

	public String getPicthree() {
		return picthree;
	}

	public void setPicthree(String picthree) {
		this.picthree = picthree;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
    
    
}
