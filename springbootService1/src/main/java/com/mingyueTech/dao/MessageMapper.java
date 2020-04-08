package com.mingyueTech.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mingyueTech.entity.Message;
@Repository
public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

	List<Message> getall();


	List<Message> getbyUsername(String username);

	List<Message> getbyfromUsername(String username);

	List<Message> getbyfId(int fid);
}