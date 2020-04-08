package com.mingyueTech.service.impl;

import com.mingyueTech.dao.SignlogMapper;
import com.mingyueTech.entity.Signlog;
import com.mingyueTech.service.SignlogBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "signlogBiz")
public class SignlogBizImpl implements SignlogBiz {
	@Autowired
	private SignlogMapper signlogDAO;

	@Override
	public void add(Signlog item) {
		signlogDAO.insertSelective(item);
	}

	@Override
	public List<Signlog> getSignlogByUser(Integer userId) {
		return signlogDAO.getSignlogByUser(userId);
		
	}

	@Override
	public Integer getsigndayByUser(Integer userId) {
		return signlogDAO.getsigndayByUser(userId);
	}

	@Override
	public Signlog getsigntoday(Integer userId) {
		return signlogDAO.getsigntoday(userId);
	}

	@Override
	public Integer getsigntodayByUser(Integer userId) {
		return signlogDAO.getsigntodayByUser(userId);
	}
	
}
