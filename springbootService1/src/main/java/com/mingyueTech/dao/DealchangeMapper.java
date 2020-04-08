package com.mingyueTech.dao;

import org.springframework.stereotype.Repository;

import com.mingyueTech.entity.Dealchange;
@Repository
public interface DealchangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dealchange record);

    int insertSelective(Dealchange record);

    Dealchange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dealchange record);

    int updateByPrimaryKey(Dealchange record);
}