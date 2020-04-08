package com.mingyueTech.entity;

public class Category {
    private Integer epcId;

    private String epcName;

    private Integer epcParentId;

    private String epcFlag;

    public Integer getEpcId() {
        return epcId;
    }

    public void setEpcId(Integer epcId) {
        this.epcId = epcId;
    }

    public String getEpcName() {
        return epcName;
    }

    public void setEpcName(String epcName) {
        this.epcName = epcName == null ? null : epcName.trim();
    }

    public Integer getEpcParentId() {
        return epcParentId;
    }

    public void setEpcParentId(Integer epcParentId) {
        this.epcParentId = epcParentId;
    }

    public String getEpcFlag() {
        return epcFlag;
    }

    public void setEpcFlag(String epcFlag) {
        this.epcFlag = epcFlag == null ? null : epcFlag.trim();
    }
}