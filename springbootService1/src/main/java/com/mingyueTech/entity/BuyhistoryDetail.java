package com.mingyueTech.entity;

import java.math.BigDecimal;
import java.util.Date;

public class BuyhistoryDetail {
    private Integer bId;

    private String orderId;
    
    private Integer userId;

    private String userName;
    
    private Integer goodsId;

    private String goodsName;
    
    private BigDecimal goodsPrice;
    
    private String goodsPic;
    
    private BigDecimal dealmoney;

    private BigDecimal alreadyPay;

    private BigDecimal needMoney;

    private Date ctime;

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
		this.orderId = orderId;
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

	public BigDecimal getDealmoney() {
        return dealmoney;
    }

    public void setDealmoney(BigDecimal dealmoney) {
        this.dealmoney = dealmoney;
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

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getBuystatus() {
        return buystatus;
    }

    public void setBuystatus(String buystatus) {
        this.buystatus = buystatus == null ? null : buystatus.trim();
    }
}
