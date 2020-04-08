package com.mingyueTech.service;

import java.util.List;

import com.mingyueTech.entity.Message;

public interface MessageBiz {
	public void add(Message item);

	public List<Message> getall();

	public Message selectByPrimaryKey(Integer nid);

	public List<Message> getbyUsername(String username);

	public List<Message> getbyfromUsername(String username);

	public void update(Message message);

	public void delete(int parseInt);

	public List<Message> getbyfId(int fid);

	public Message getbyId(int fid);

}
