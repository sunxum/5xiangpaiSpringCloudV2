package com.mingyueTech.service;

import com.mingyueTech.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserBiz {	
	public boolean isExists(String username);
	public User login(String username, String password);
	public void add(User item);
	public User getbyusername(String username);
	public String getlessBiduserStatus(Integer goodsId);
	public void update(User user);
	public User getbyid(Integer getuId);
	public User getrandomCuser();
	public List<HashMap<String, String>> getUserNameList();
	public User getbyQqOpenId(String openID);
	public List<User> getall();
	public Integer getlessBiduserId(Integer goodsId);
}
