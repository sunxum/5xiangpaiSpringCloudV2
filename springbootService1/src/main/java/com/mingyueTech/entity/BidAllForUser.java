package com.mingyueTech.entity;

import java.math.BigDecimal;
import java.util.Date;

public class BidAllForUser {
	private int id;
	private int goodsId;
	private String goodsName;
	private String goodsPic;
	private BigDecimal goodsPrice;
	private int goodsStepcoin;
	private String lessBidusername;
	private BigDecimal lessMoney;
	private int goodsStatus;
	private int count;
	private int bidStatus;
	private Date dealtime;
	private Date bidTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsPic() {
		return goodsPic;
	}
	public void setGoodsPic(String goodsPic) {
		this.goodsPic = goodsPic;
	}
	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	
	
	public int getGoodsStepcoin() {
		return goodsStepcoin;
	}
	public void setGoodsStepcoin(int goodsStepcoin) {
		this.goodsStepcoin = goodsStepcoin;
	}
	public String getLessBidusername() {
		return lessBidusername;
	}
	public void setLessBidusername(String lessBidusername) {
		this.lessBidusername = lessBidusername;
	}
	public BigDecimal getLessMoney() {
		return lessMoney;
	}
	public void setLessMoney(BigDecimal lessMoney) {
		this.lessMoney = lessMoney;
	}
	public int getGoodsStatus() {
		return goodsStatus;
	}
	public void setGoodsStatus(int goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getBidStatus() {
		return bidStatus;
	}
	public void setBidStatus(int bidStatus) {
		this.bidStatus = bidStatus;
	}
	public Date getDealtime() {
		return dealtime;
	}
	public void setDealtime(Date dealtime) {
		this.dealtime = dealtime;
	}
	public Date getBidTime() {
		return bidTime;
	}
	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}
	
}
