package com.mingyueTech.service.impl;

import com.mingyueTech.dao.CoinchangeMapper;
import com.mingyueTech.entity.Coinchange;
import com.mingyueTech.service.CoinchangeBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value="coinchangeBiz")
public class CoinchangeBizImpl implements CoinchangeBiz {
	@Autowired
	private CoinchangeMapper coinchangeDAO;
	@Override
	public void update(Coinchange coinchange) {
		coinchangeDAO.updateByPrimaryKeySelective(coinchange);
		
	}
	@Override
	public void insert(Coinchange coinchange) {
		coinchangeDAO.insertSelective(coinchange);
		
	}
	@Override
	public List<Coinchange> getcoinchangebyuser(int parseInt) {
		return coinchangeDAO.getcoinchangebyuser(parseInt);
	}

}
