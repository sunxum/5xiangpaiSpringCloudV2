package com.mingyueTech.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mingyueTech.entity.Signlog;
@Repository
public interface SignlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Signlog record);

    int insertSelective(Signlog record);

    Signlog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Signlog record);

    int updateByPrimaryKey(Signlog record);

	List<Signlog> getSignlogByUser(Integer userId);

	Integer getsigndayByUser(Integer userId);

	Signlog getsigntoday(Integer userId);

	Integer getsigntodayByUser(Integer userId);
}