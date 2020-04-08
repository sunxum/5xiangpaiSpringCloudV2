package com.mingyueTech.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mingyueTech.entity.Sendarea;
@Repository
public interface SendareaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sendarea record);

    int insertSelective(Sendarea record);

    Sendarea selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sendarea record);

    int updateByPrimaryKey(Sendarea record);

	List<Sendarea> getsendareabyuser(int uid);
}