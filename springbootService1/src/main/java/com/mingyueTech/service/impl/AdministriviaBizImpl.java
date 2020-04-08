package com.mingyueTech.service.impl;

import com.mingyueTech.dao.AdministriviaMapper;
import com.mingyueTech.entity.Administrivia;
import com.mingyueTech.service.AdministriviaBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "administriviaBiz")
public class AdministriviaBizImpl implements AdministriviaBiz {
	@Autowired
	private AdministriviaMapper administriviaDAO;

	@Override
	public void add(Administrivia item) {
		administriviaDAO.insertSelective(item);
	}

	@Override
	public List<Administrivia> getall() {
		return administriviaDAO.getall();
	}

	@Override
	public Administrivia selectByPrimaryKey(Integer id) {
		return administriviaDAO.selectByPrimaryKey(id);
	}

	@Override
	public void update(Administrivia item) {
		administriviaDAO.updateByPrimaryKeySelective(item);
		
	}

	@Override
	public void drop(Integer id) {
		administriviaDAO.deleteByPrimaryKey(id);
		
	}
}
