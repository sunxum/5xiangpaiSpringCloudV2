package com.mingyueTech.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mingyueTech.entity.Buyhistory;
import com.mingyueTech.entity.BuyhistoryDetail;
import com.mingyueTech.entity.BuyhistoryDetailVo;
@Repository
public interface BuyhistoryMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(Buyhistory record);

    int insertSelective(Buyhistory record);

    Buyhistory selectByPrimaryKey(Integer bId);

    int updateByPrimaryKeySelective(Buyhistory record);

    int updateByPrimaryKey(Buyhistory record);

	List<Map<String, Object>> getallcomplate();

	List<BuyhistoryDetail> getbuyhistorybyuser(Integer userId);

	int getbuyhistorycountbyuser(Integer userId);

	int getbuyhistoryispaybyuser(Integer userId);

	int getbuyhistoryissendbyuser(Integer userId);

	int getbuyhistoryistakebyuser(Integer userId);

	int getbuyhistoryispublicpicbyuser(Integer userId);

	List<BuyhistoryDetail> getbuyhistorynopayDetailbyuser(Integer userId);

	List<BuyhistoryDetail> getbuyhistoryissendDetailbyuser(Integer userId);

	List<BuyhistoryDetail> getbuyhistoryistakeDetailbyuser(Integer userId);

	List<BuyhistoryDetail> getbuyhistory();

	List<Map<String, Object>> getBuyHistoryList(int userId);

	int getMaxId();

	Buyhistory getByOrderId(String trade_no);

	BuyhistoryDetailVo getOrderDetail(String bid);
}