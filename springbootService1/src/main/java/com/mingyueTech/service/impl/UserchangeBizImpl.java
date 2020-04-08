package com.mingyueTech.service.impl;

import com.mingyueTech.dao.UserchangeMapper;
import com.mingyueTech.entity.Userchange;
import com.mingyueTech.service.UserchangeBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userchangeBiz")
public class UserchangeBizImpl implements UserchangeBiz {
	@Autowired
	private UserchangeMapper userchangeDAO;

	@Override
	public void insert(Userchange userchange) {
		userchangeDAO.insertSelective(userchange);
		
	}
	
}
