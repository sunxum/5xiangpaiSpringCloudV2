package com.mingyueTech.controller;

import com.mingyueTech.entity.Buyhistory;
import com.mingyueTech.entity.BuyhistoryDetail;
import com.mingyueTech.entity.BuyhistoryDetailVo;
import com.mingyueTech.entity.Sendarea;
import com.mingyueTech.service.BidBiz;
import com.mingyueTech.service.BuyhistoryBiz;
import com.mingyueTech.service.GoodslistBiz;
import com.mingyueTech.service.SendareaBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class BuyhistoryAction {
	private BuyhistoryBiz buyhistoryBiz;

	private GoodslistBiz goodslistBiz;
	private BidBiz bidBiz;
	private SendareaBiz sendareaBiz;
	


	

	@RequestMapping(value = "/loaddealhistory", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> loadDealHistory(HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, Object>> buyhistoryList = buyhistoryBiz.getallcomplate();
		return buyhistoryList;
	}

	@RequestMapping(value = "/getbuyhistorycountbyuser", method = RequestMethod.POST)
	@ResponseBody
	public String getbuyhistorycountbyuser(HttpServletRequest request, HttpServletResponse response, Integer userId) {
		int buyhistorySumList = buyhistoryBiz.getbuyhistorycountbyuser(userId);
		int buyhistoryispayList = buyhistoryBiz.getbuyhistoryispaybyuser(userId);
		int buyhistoryissendList = buyhistoryBiz.getbuyhistoryissendbyuser(userId);
		int buyhistoryistakeList = buyhistoryBiz.getbuyhistoryistakebyuser(userId);
		int buyhistoryispublicpicList = buyhistoryBiz.getbuyhistoryispublicpicbyuser(userId);
		return buyhistorySumList + "," + buyhistoryispayList + "," + buyhistoryissendList + "," + buyhistoryistakeList
				+ "," + buyhistoryispublicpicList;
	}

	@RequestMapping(value = "/getbuyhistory", method = RequestMethod.POST)
	@ResponseBody
	public List<BuyhistoryDetail> getbuyhistory(HttpServletRequest request, HttpServletResponse response) {
		List<BuyhistoryDetail> buyhistoryDetailList =buyhistoryBiz.getbuyhistory();
		return buyhistoryDetailList;
	}
	@RequestMapping(value = "/getbuyhistorybyuser", method = RequestMethod.POST)
	@ResponseBody
	public List<BuyhistoryDetail> getbuyhistorybyuser(HttpServletRequest request, HttpServletResponse response,
			Integer userId, Integer bStatus) {
		List<BuyhistoryDetail> buyhistoryDetailList = null;
		if (null == bStatus) {
			buyhistoryDetailList = buyhistoryBiz.getbuyhistorybyuser(userId);
		} else {
			switch (bStatus) {
			case 1:
				buyhistoryDetailList = buyhistoryBiz.getbuyhistorynopayDetailbyuser(userId);
				break;
			case 2:
				buyhistoryDetailList = buyhistoryBiz.getbuyhistoryissendDetailbyuser(userId);
				break;
			case 3:
				buyhistoryDetailList = buyhistoryBiz.getbuyhistoryissendDetailbyuser(userId);
				break;
			case 4:
				buyhistoryDetailList = buyhistoryBiz.getbuyhistoryistakeDetailbyuser(userId);
				break;
			}
		}
		return buyhistoryDetailList;
	}
	@RequestMapping(value = "/getBuyHistoryList", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> getBuyHistoryList(HttpServletRequest request, HttpServletResponse response,int userId) {
		List<Map<String, Object>> buyhistoryList = buyhistoryBiz.getBuyHistoryList(userId);
		return buyhistoryList;
	}
	@RequestMapping(value = "/getOrderDetail", method = RequestMethod.POST)
	@ResponseBody
	public BuyhistoryDetailVo getOrderDetail(HttpServletRequest request, HttpServletResponse response,String bId) {
		BuyhistoryDetailVo buyhistoryList = buyhistoryBiz.getOrderDetail(bId);
		return buyhistoryList;
	}
	@RequestMapping(value = "/reciveGoods", method = RequestMethod.POST)
	@ResponseBody
	public String reciveGoods(HttpServletRequest request, HttpServletResponse response,String bId) {
		Buyhistory buyhistory = buyhistoryBiz.getByOrderId(bId);
		buyhistory.setBuystatus(30+"");
		buyhistoryBiz.update(buyhistory);
		return "收货成功";
	}
	@RequestMapping(value = "/addAddressInOrder", method = RequestMethod.POST)
	@ResponseBody
	public void addAddressInOrder(HttpServletRequest request, HttpServletResponse response,String bId) {
		Buyhistory buyhistory = buyhistoryBiz.getbyid(Integer.parseInt(bId));
		List<Sendarea> sendAreaList=sendareaBiz.getsendareabyuser(buyhistory.getuId());
		if(sendAreaList.size()>0) {
			buyhistory.setUserRealName(sendAreaList.get(0).getUrealname());
			buyhistory.setUserRealMobile(sendAreaList.get(0).getUrealmobile());
			buyhistory.setDetailArea(sendAreaList.get(0).getDetailarea());
			buyhistory.setAreaAid(sendAreaList.get(0).getAid());
			for(Sendarea sendarea:sendAreaList) {
				if(2==sendarea.getSaStutas()) {
					buyhistory.setUserRealName(sendarea.getUrealname());
					buyhistory.setUserRealMobile(sendarea.getUrealmobile());
					buyhistory.setDetailArea(sendarea.getDetailarea());
					buyhistory.setAreaAid(sendarea.getAid());
				}
			}
			buyhistoryBiz.update(buyhistory);
		}
		
	}
	
}
