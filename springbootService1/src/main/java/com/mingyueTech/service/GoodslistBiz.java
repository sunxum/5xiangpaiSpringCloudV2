package com.mingyueTech.service;

import com.mingyueTech.entity.Goodslist;

import java.util.List;

public interface GoodslistBiz {

	void addGoods(Goodslist item);

	Goodslist getGoodsbyid(Integer glId);

	void update(Goodslist goodslistone);

	List<Goodslist> getAllCanSale();

	List getMyGoodsList(Integer userId);

	List<Goodslist> getAllGoods();

	void updatestutasGoodsList(Goodslist goodsList);

	Goodslist getGoodsListById(int id);

	List<Goodslist> getAllGoodsByStats();
	
	public List getrefrshGoods();

	void refrshGoods();

}
