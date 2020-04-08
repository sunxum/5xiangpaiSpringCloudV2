package com.mingyueTech.service.impl;

import com.mingyueTech.dao.MessageMapper;
import com.mingyueTech.entity.Message;
import com.mingyueTech.service.MessageBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "messageBiz")
public class MessageBizImpl implements MessageBiz {
	@Autowired
	private MessageMapper messageDAO;

	@Override
	public void add(Message item) {
		messageDAO.insertSelective(item);
		
	}

	@Override
	public List<Message> getall() {
		return messageDAO.getall();
	}

	@Override
	public Message selectByPrimaryKey(Integer nid) {
		return messageDAO.selectByPrimaryKey(nid);
	}

	@Override
	public List<Message> getbyUsername(String username) {
		return messageDAO.getbyUsername(username);
	}

	@Override
	public List<Message> getbyfromUsername(String username) {
		return messageDAO.getbyfromUsername(username);
	}

	@Override
	public void update(Message message) {
		messageDAO.updateByPrimaryKeySelective(message);
	}

	@Override
	public void delete(int parseInt) {
		messageDAO.deleteByPrimaryKey(parseInt);
	}

	@Override
	public List<Message> getbyfId(int fid) {
		return messageDAO.getbyfId(fid);
	}

	@Override
	public Message getbyId(int fid) {
		return messageDAO.selectByPrimaryKey(fid);
	}



}
