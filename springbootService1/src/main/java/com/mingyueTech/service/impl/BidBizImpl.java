package com.mingyueTech.service.impl;

import com.mingyueTech.dao.BidMapper;
import com.mingyueTech.entity.Bid;
import com.mingyueTech.entity.BidAllForUser;
import com.mingyueTech.entity.Bidlite;
import com.mingyueTech.service.BidBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "bidBiz")
public class BidBizImpl implements BidBiz{
	@Autowired
	private BidMapper bidDAO;
	@Override
	public void addBiz(Bid item) {
		bidDAO.insertSelective(item);
		
	}

	@Override
	public List<Integer> getRealbidnum(Integer goodsId) {
		return bidDAO.getRealbidnum(goodsId);
	}

	@Override
	public Integer getPaycoinByUser(Integer goodsId, Integer userId) {
		return bidDAO.getPaycoinByUser(goodsId, userId);
	}

	@Override
	public Integer getlessBiduser(Integer goodsId) {
		return bidDAO.getlessBiduser(goodsId);
	}

	@Override
	public List<Bidlite> getbidsbygoodsid(Integer goodsid) {
		return bidDAO.getbidsbygoodsid(goodsid);
	}

	@Override
	public List getMyBidList(Integer userId) {
		return bidDAO.getMyBidList(userId);
	}

	@Override
	public List<BidAllForUser> getMyBidAllList(int userId) {
		return bidDAO.getMyBidAllList(userId);
	}

	@Override
	public List getBidingList(int userId) {
		return bidDAO.getBidingList(userId);
	}

	@Override
	public Bid getById(int bid) {
		return bidDAO.selectByPrimaryKey(bid);
	}

	@Override
	public void update(Bid b) {
		bidDAO.updateByPrimaryKeySelective(b);
		
	}

}
