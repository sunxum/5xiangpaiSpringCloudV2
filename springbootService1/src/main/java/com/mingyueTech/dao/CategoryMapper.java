package com.mingyueTech.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mingyueTech.entity.Category;
@Repository
public interface CategoryMapper {
    int deleteByPrimaryKey(Integer epcId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer epcId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

	List<Category> getbyroot();

	String getcategoryname(int cid);

	List<Category> getGoodsCategory();
}