package com.mingyueTech.entity;

import java.math.BigDecimal;
import java.util.Date;

public class BuyhistoryDetailVo {
    private Integer bId;

    private String orderId;
    
    private String orderType;
    
    private Integer userId;

    private String userName;
    
    private Integer goodsId;

    private String goodsName;
    
    private BigDecimal goodsPrice;
    
    private String goodsPic;
    
    private BigDecimal dealMoney;

    private BigDecimal alreadyPay;

    private BigDecimal needMoney;
    private String buyStatus;

    private Date createTime;
    
    private Date sendGoodsTime;
    
    private Date reciveGoodsTime;
    private Integer aid;
    private String uRealName;
    private String uRealMoblie;
    private String detailArea;
    private String postType;

    private Date publicpicTime;
    private Integer postNum;
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
		this.orderId = orderId;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
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
	public BigDecimal getDealMoney() {
		return dealMoney;
	}
	public void setDealMoney(BigDecimal dealMoney) {
		this.dealMoney = dealMoney;
	}
	public BigDecimal getAlreadyPay() {
		return alreadyPay;
	}
	public void setAlreadyPay(BigDecimal alreadyPay) {
		this.alreadyPay = alreadyPay;
	}
	public BigDecimal getNeedMoney() {
		return needMoney;
	}
	public void setNeedMoney(BigDecimal needMoney) {
		this.needMoney = needMoney;
	}
	public String getBuyStatus() {
		return buyStatus;
	}
	public void setBuyStatus(String buyStatus) {
		this.buyStatus = buyStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getuRealName() {
		return uRealName;
	}
	public void setuRealName(String uRealName) {
		this.uRealName = uRealName;
	}
	public String getuRealMoblie() {
		return uRealMoblie;
	}
	public void setuRealMoblie(String uRealMoblie) {
		this.uRealMoblie = uRealMoblie;
	}
	public String getDetailArea() {
		return detailArea;
	}
	public void setDetailArea(String detailArea) {
		this.detailArea = detailArea;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public Date getPublicpicTime() {
		return publicpicTime;
	}
	public void setPublicpicTime(Date publicpicTime) {
		this.publicpicTime = publicpicTime;
	}
	public Integer getPostNum() {
		return postNum;
	}
	public void setPostNum(Integer postNum) {
		this.postNum = postNum;
	}


}
