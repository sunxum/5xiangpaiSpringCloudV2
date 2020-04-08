package com.mingyueTech.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mingyueTech.entity.Coinchange;
@Repository
public interface CoinchangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Coinchange record);

    int insertSelective(Coinchange record);

    Coinchange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Coinchange record);

    int updateByPrimaryKey(Coinchange record);

	List<Coinchange> getcoinchangebyuser(int parseInt);
}