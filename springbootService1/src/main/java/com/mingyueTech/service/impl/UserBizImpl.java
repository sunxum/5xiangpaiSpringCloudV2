package com.mingyueTech.service.impl;

import com.mingyueTech.dao.UserMapper;
import com.mingyueTech.entity.User;
import com.mingyueTech.service.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service(value = "userBiz")
@Transactional
public class UserBizImpl implements UserBiz {

	@Autowired
	private UserMapper userDAO;

	public boolean isExists(String username) {
		User user = this.userDAO.getbyusername(username);

		if (null != user) {
			return true;
		} else {
			return false;
		}
	}

	public User login(String username, String password) {
		User user = this.userDAO.getbyusername(username);
		if (null != user) {
			if (user.getUserPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	public void add(User item) {
		this.userDAO.insertSelective(item);
	}

	@Override
	public User getbyusername(String username) {

		User user = this.userDAO.getbyusername(username);

		return user;

	}

	@Override
	public String getlessBiduserStatus(Integer goodsId) {
		return userDAO.getlessBiduserStatus(goodsId);
	}

	@Override
	public void update(User user) {
		userDAO.updateByPrimaryKeySelective(user);
	}

	@Override
	public User getbyid(Integer uId) {
		return userDAO.selectByPrimaryKey(uId);
	}

	@Override
	public User getrandomCuser() {
		return userDAO.getrandomCuser();
	}

	@Override
	public List<HashMap<String, String>> getUserNameList() {
		return userDAO.getUserNameList();
	}

	@Override
	public User getbyQqOpenId(String openID) {
		return userDAO.getbyQqOpenId(openID);
	}

	@Override
	public List<User> getall() {
		return userDAO.getall();
	}

	@Override
	public Integer getlessBiduserId(Integer goodsId) {
		return userDAO.getlessBiduserId(goodsId);
	}

}
