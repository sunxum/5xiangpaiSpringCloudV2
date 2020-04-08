package com.mingyueTech.service.impl;

import com.mingyueTech.dao.BuyhistoryMapper;
import com.mingyueTech.entity.Buyhistory;
import com.mingyueTech.entity.BuyhistoryDetail;
import com.mingyueTech.entity.BuyhistoryDetailVo;
import com.mingyueTech.service.BuyhistoryBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service(value = "buyhistoryBiz")
public class BuyhistoryBizImpl implements BuyhistoryBiz {
	@Autowired
	private BuyhistoryMapper buyhistoryDAO;

	@Override
	public void add(Buyhistory item) {
		buyhistoryDAO.insertSelective(item);
		
	}

	@Override
	public List<Map<String, Object>> getallcomplate() {
		
		return buyhistoryDAO.getallcomplate();
	}

	@Override
	public Buyhistory getbyid(Integer bId) {
		return buyhistoryDAO.selectByPrimaryKey(bId);
		
	}

	@Override
	public List<BuyhistoryDetail> getbuyhistorybyuser(Integer userId) {
		return buyhistoryDAO.getbuyhistorybyuser(userId);
	}

	@Override
	public int getbuyhistorycountbyuser(Integer userId) {
		return buyhistoryDAO.getbuyhistorycountbyuser(userId);
	}

	@Override
	public int getbuyhistoryispaybyuser(Integer userId) {
		return buyhistoryDAO.getbuyhistoryispaybyuser(userId);
	}

	@Override
	public int getbuyhistoryissendbyuser(Integer userId) {
		return buyhistoryDAO.getbuyhistoryissendbyuser(userId);
	}

	@Override
	public int getbuyhistoryistakebyuser(Integer userId) {
		return buyhistoryDAO.getbuyhistoryistakebyuser(userId);
	}

	@Override
	public int getbuyhistoryispublicpicbyuser(Integer userId) {
		return buyhistoryDAO.getbuyhistoryispublicpicbyuser(userId);
	}

	@Override
	public List<BuyhistoryDetail> getbuyhistorynopayDetailbyuser(Integer userId) {
		return buyhistoryDAO.getbuyhistorynopayDetailbyuser(userId);
	}

	@Override
	public List<BuyhistoryDetail> getbuyhistoryissendDetailbyuser(Integer userId) {
		return buyhistoryDAO.getbuyhistoryissendDetailbyuser(userId);
	}

	@Override
	public List<BuyhistoryDetail> getbuyhistoryistakeDetailbyuser(Integer userId) {
		return buyhistoryDAO.getbuyhistoryistakeDetailbyuser(userId);
	}

	@Override
	public void update(Buyhistory buyhistory) {
		buyhistoryDAO.updateByPrimaryKeySelective(buyhistory);
	}

	@Override
	public List<BuyhistoryDetail> getbuyhistory() {
		return buyhistoryDAO.getbuyhistory();
	}

	@Override
	public List<Map<String, Object>> getBuyHistoryList(int userId) {
		return buyhistoryDAO.getBuyHistoryList(userId);
	}

	@Override
	public int getMaxId() {
		return buyhistoryDAO.getMaxId();
	}

	@Override
	public Buyhistory getByOrderId(String trade_no) {
		return buyhistoryDAO.getByOrderId(trade_no);
	}

	@Override
	public BuyhistoryDetailVo getOrderDetail(String bid) {
		return buyhistoryDAO.getOrderDetail(bid) ;
	}
}
