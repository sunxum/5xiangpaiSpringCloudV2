package com.mingyueTech.dao;

import com.mingyueTech.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
//@Repository
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
    User getbyusername(String username);
    String getlessBiduserStatus(Integer goodsId);

	User getrandomCuser();

	List<HashMap<String, String>> getUserNameList();

	User getbyQqOpenId(String openID);

	List<User> getall();

	Integer getlessBiduserId(Integer goodsId);
}