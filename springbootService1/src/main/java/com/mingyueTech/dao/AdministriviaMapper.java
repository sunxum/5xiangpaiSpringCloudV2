package com.mingyueTech.dao;

import com.mingyueTech.entity.Administrivia;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdministriviaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Administrivia record);

    int insertSelective(Administrivia record);

    Administrivia selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Administrivia record);

    int updateByPrimaryKey(Administrivia record);

	List<Administrivia> getall();
}