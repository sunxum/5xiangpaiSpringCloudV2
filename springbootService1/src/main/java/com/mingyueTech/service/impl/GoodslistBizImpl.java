package com.mingyueTech.service.impl;

import com.mingyueTech.dao.GoodslistMapper;
import com.mingyueTech.entity.Goodslist;
import com.mingyueTech.service.GoodslistBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value="goodslistBiz")
public class GoodslistBizImpl implements GoodslistBiz {
	@Autowired
	private GoodslistMapper goodslistDAO;

	@Override
	public void addGoods(Goodslist item) {
		goodslistDAO.insertSelective(item);
		
	}

	@Override
	public Goodslist getGoodsbyid(Integer glId) {
		return goodslistDAO.selectByPrimaryKey(glId);
	}

	@Override
	public void update(Goodslist goodslistone) {
		goodslistDAO.updateByPrimaryKeySelective(goodslistone);
		
	}

	@Override
	public List<Goodslist> getAllCanSale() {
		return goodslistDAO.getAllCanSale();
	}

	@Override
	public List getMyGoodsList(Integer userId) {
		return goodslistDAO.getMyGoodsList(userId);
	}

	@Override
	public List<Goodslist> getAllGoods() {
		return goodslistDAO.getAllGoods();
	}

	@Override
	public void updatestutasGoodsList(Goodslist goodsList) {
		goodslistDAO.updateByPrimaryKeySelective(goodsList);
	}

	@Override
	public Goodslist getGoodsListById(int glId) {
		return goodslistDAO.selectByPrimaryKey(glId);
	}

	@Override
	public List<Goodslist> getAllGoodsByStats() {
		return goodslistDAO.getAllGoodsByStats();
	}

	@Override
	public List getrefrshGoods() {
		
		return goodslistDAO.getrefrshGoods();
	}

	@Override
	public void refrshGoods() {
		goodslistDAO.refrshGoods();
		
	}


}
