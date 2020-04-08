package com.mingyueTech.service.impl;

import com.mingyueTech.dao.SendareaMapper;
import com.mingyueTech.entity.Sendarea;
import com.mingyueTech.service.SendareaBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "sendareaBiz")
public class SendareaBizImpl implements SendareaBiz {
	@Autowired
	private SendareaMapper sendareaDAO;

	@Override
	public void insert(Sendarea sendarea) {
		sendareaDAO.insertSelective(sendarea);
		
	}

	@Override
	public List<Sendarea> getsendareabyuser(int uid) {
		return sendareaDAO.getsendareabyuser(uid);
	}

	@Override
	public void update(Sendarea sendarea) {
		sendareaDAO.updateByPrimaryKeySelective(sendarea);
	}

	@Override
	public Sendarea getsendareabyid(int id) {
		return sendareaDAO.selectByPrimaryKey(id);
	}


}
