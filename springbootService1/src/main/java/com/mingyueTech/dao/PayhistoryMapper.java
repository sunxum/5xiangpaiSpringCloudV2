package com.mingyueTech.dao;

import org.springframework.stereotype.Repository;

import com.mingyueTech.entity.Payhistory;
@Repository
public interface PayhistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Payhistory record);

    int insertSelective(Payhistory record);

    Payhistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Payhistory record);

    int updateByPrimaryKey(Payhistory record);

	int getMaxId();

	Payhistory getByAlipayOrderid(String trade_no);
}