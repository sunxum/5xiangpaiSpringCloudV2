package com.mingyueTech.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Bid {
    private Integer bidId;

    private Integer goodsId;

    private Integer buyerId;

    private Date bidTime;

    private BigDecimal bidPrice;

    private Integer bidStatus;

    private Integer useFreecoin;

    private Integer usePaycoin;

    private Integer usePractivecoin;

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Date getBidTime() {
        return bidTime;
    }

    public void setBidTime(Date bidTime) {
        this.bidTime = bidTime;
    }

    public BigDecimal getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(BigDecimal bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Integer getBidStatus() {
        return bidStatus;
    }

    public void setBidStatus(Integer bidStatus) {
        this.bidStatus = bidStatus;
    }

    public Integer getUseFreecoin() {
        return useFreecoin;
    }

    public void setUseFreecoin(Integer useFreecoin) {
        this.useFreecoin = useFreecoin;
    }

    public Integer getUsePaycoin() {
        return usePaycoin;
    }

    public void setUsePaycoin(Integer usePaycoin) {
        this.usePaycoin = usePaycoin;
    }

    public Integer getUsePractivecoin() {
        return usePractivecoin;
    }

    public void setUsePractivecoin(Integer usePractivecoin) {
        this.usePractivecoin = usePractivecoin;
    }
}