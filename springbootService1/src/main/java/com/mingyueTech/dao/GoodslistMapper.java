package com.mingyueTech.dao;

import com.mingyueTech.entity.Goodslist;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GoodslistMapper {
    int deleteByPrimaryKey(Integer glId);

    int insert(Goodslist record);

    int insertSelective(Goodslist record);

    Goodslist selectByPrimaryKey(Integer glId);

    int updateByPrimaryKeySelective(Goodslist record);

    int updateByPrimaryKeyWithBLOBs(Goodslist record);

    int updateByPrimaryKey(Goodslist record);

	List<Goodslist> getAllCanSale();

	List getMyGoodsList(Integer userId);//卖家商品列表

	List<Goodslist> getAllGoods();

	List<Goodslist> getAllGoodsByStats();

	List<Goodslist> getrefrshGoods();

	void refrshGoods();
}