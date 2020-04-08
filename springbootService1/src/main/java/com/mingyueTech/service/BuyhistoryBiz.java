package com.mingyueTech.service;

import java.util.List;
import java.util.Map;

import com.mingyueTech.entity.Buyhistory;
import com.mingyueTech.entity.BuyhistoryDetail;
import com.mingyueTech.entity.BuyhistoryDetailVo;

public interface BuyhistoryBiz {
	public void add(Buyhistory item);

	public List<Map<String, Object>> getallcomplate();

	public Buyhistory getbyid(Integer bId);

	public List<BuyhistoryDetail> getbuyhistorybyuser(Integer userId);

	public int getbuyhistorycountbyuser(Integer userId);

	public int getbuyhistoryispaybyuser(Integer userId);

	public int getbuyhistoryissendbyuser(Integer userId);

	public int getbuyhistoryistakebyuser(Integer userId);

	public int getbuyhistoryispublicpicbyuser(Integer userId);

	public List<BuyhistoryDetail> getbuyhistorynopayDetailbyuser(Integer userId);
	
	public List<BuyhistoryDetail> getbuyhistoryissendDetailbyuser(Integer userId);
	
	public List<BuyhistoryDetail> getbuyhistoryistakeDetailbyuser(Integer userId);

	public void update(Buyhistory buyhistory);

	public List<BuyhistoryDetail> getbuyhistory();

	public List<Map<String, Object>> getBuyHistoryList(int userId);

	public int getMaxId();

	public Buyhistory getByOrderId(String trade_no);

	public BuyhistoryDetailVo getOrderDetail(String bid);
}
