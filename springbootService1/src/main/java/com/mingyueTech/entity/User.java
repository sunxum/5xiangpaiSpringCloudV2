package com.mingyueTech.entity;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userIdCode;

    private String userTel;

    private String userAddr;

    private String userZip;

    private String userStatus;

    private String userEmail;

    private String sex;

    private Date birthday;

    private String truename;

    private Integer score;

    private Integer freecoin;

    private Integer paycoin;

    private Integer practicecoin;

    private String headimg;

    private String area;

    private String qqnum;

    private String weixinnum;

    private String qqOpenid;

    private String weixinOpenid;

    private Integer invateUId;

    private Integer addressArea1;

    private String alipayaccount;

    private String ip;

    private Date ctime;

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
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserIdCode() {
        return userIdCode;
    }

    public void setUserIdCode(String userIdCode) {
        this.userIdCode = userIdCode == null ? null : userIdCode.trim();
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr == null ? null : userAddr.trim();
    }

    public String getUserZip() {
        return userZip;
    }

    public void setUserZip(String userZip) {
        this.userZip = userZip == null ? null : userZip.trim();
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename == null ? null : truename.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

    public Integer getPracticecoin() {
        return practicecoin;
    }

    public void setPracticecoin(Integer practicecoin) {
        this.practicecoin = practicecoin;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getQqnum() {
        return qqnum;
    }

    public void setQqnum(String qqnum) {
        this.qqnum = qqnum == null ? null : qqnum.trim();
    }

    public String getWeixinnum() {
        return weixinnum;
    }

    public void setWeixinnum(String weixinnum) {
        this.weixinnum = weixinnum == null ? null : weixinnum.trim();
    }

    public String getQqOpenid() {
        return qqOpenid;
    }

    public void setQqOpenid(String qqOpenid) {
        this.qqOpenid = qqOpenid == null ? null : qqOpenid.trim();
    }

    public String getWeixinOpenid() {
        return weixinOpenid;
    }

    public void setWeixinOpenid(String weixinOpenid) {
        this.weixinOpenid = weixinOpenid == null ? null : weixinOpenid.trim();
    }

    public Integer getInvateUId() {
        return invateUId;
    }

    public void setInvateUId(Integer invateUId) {
        this.invateUId = invateUId;
    }

    public Integer getAddressArea1() {
        return addressArea1;
    }

    public void setAddressArea1(Integer addressArea1) {
        this.addressArea1 = addressArea1;
    }

    public String getAlipayaccount() {
        return alipayaccount;
    }

    public void setAlipayaccount(String alipayaccount) {
        this.alipayaccount = alipayaccount == null ? null : alipayaccount.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}