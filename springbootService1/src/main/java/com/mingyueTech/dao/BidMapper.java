package com.mingyueTech.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mingyueTech.entity.Bid;
import com.mingyueTech.entity.Bidlite;
@Repository
public interface BidMapper {
    int deleteByPrimaryKey(Integer bidId);

    int insert(Bid record);

    int insertSelective(Bid record);

    Bid selectByPrimaryKey(Integer bidId);

    int updateByPrimaryKeySelective(Bid record);

    int updateByPrimaryKey(Bid record);
    List<Integer> getRealbidnum(int goodsId);
    public int getPaycoinByUser(Integer goodsId, Integer userId);

	Integer getlessBiduser(Integer goodsId);

	List<Bidlite> getbidsbygoodsid(Integer goodsid);

	List<Bidlite> getMyBidList(Integer userId);

	List getMyBidAllList(Integer userId);

	List getBidingList(int userId);
}