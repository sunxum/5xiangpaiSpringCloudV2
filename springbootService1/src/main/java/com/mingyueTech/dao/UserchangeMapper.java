package com.mingyueTech.dao;

import org.springframework.stereotype.Repository;

import com.mingyueTech.entity.Userchange;
@Repository
public interface UserchangeMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Userchange record);

    int insertSelective(Userchange record);

    Userchange selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Userchange record);

    int updateByPrimaryKey(Userchange record);
}