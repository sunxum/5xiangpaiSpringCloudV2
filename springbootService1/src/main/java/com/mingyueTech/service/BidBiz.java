package com.mingyueTech.service;

import java.util.HashMap;
import java.util.List;

import com.mingyueTech.entity.Bid;
import com.mingyueTech.entity.BidAllForUser;
import com.mingyueTech.entity.Bidlite;

public interface BidBiz {
	public void addBiz(Bid item);
	public List<Integer> getRealbidnum(Integer goodsId);
	public Integer getPaycoinByUser(Integer goodsId, Integer userId);
	public Integer getlessBiduser(Integer goodsId);
	public List<Bidlite> getbidsbygoodsid(Integer goodsid);
	public List getMyBidList(Integer userId);
	public List<BidAllForUser> getMyBidAllList(int userId);
	public List<HashMap<String,String>> getBidingList(int userId);
	public Bid getById(int bid);
	public void update(Bid b);
}
