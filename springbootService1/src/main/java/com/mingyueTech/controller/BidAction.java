package com.mingyueTech.controller;

import com.mingyueTech.entity.*;
import com.mingyueTech.service.BidBiz;
import com.mingyueTech.service.BuyhistoryBiz;
import com.mingyueTech.service.GoodslistBiz;
import com.mingyueTech.service.UserBiz;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class BidAction {


	private GoodslistBiz goodslistBiz;

	private UserBiz userBiz;
	private BuyhistoryBiz buyhistoryBiz;
	private BidBiz bidBiz;
	



	@RequestMapping(value = "/toMyBidList", method = RequestMethod.POST)
	@ResponseBody
	public List<Bidlite> toMyBidList(
			HttpServletRequest request, HttpServletResponse response,int userId) {
		List<Bidlite> list = this.bidBiz.getMyBidList(userId);
		 
		return list;
	}
	@RequestMapping(value = "/getBidingList", method = RequestMethod.POST)
	@ResponseBody
	public List<HashMap<String,String>> getBidingList(
			HttpServletRequest request, HttpServletResponse response,int userId) {
		List<HashMap<String,String>> list = this.bidBiz.getBidingList(userId);
		return list;
	}
	
	@RequestMapping(value = "/buyNow", method = RequestMethod.POST)
	@ResponseBody
	public String buyNow(HttpServletRequest request, HttpServletResponse response, Integer userId, Integer glId) {
		Goodslist goods = goodslistBiz.getGoodsbyid(glId);
		
		Buyhistory buyhistory = new Buyhistory();
		buyhistory.setuId(userId);
		buyhistory.setGlId(glId);
		buyhistory.setDealmoney(goods.getGoodsReservePrice());
		//生成订单ID----开始
		//商户订单号，商户网站订单系统中唯一订单号，必填
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		String date=df.format(new Date());
		//用户Id
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(7);
        //设置最小整数位数    
        nf.setMinimumIntegerDigits(7);
        String userIdresult=nf.format(userId);
        //获取最大Id
        int maxid=buyhistoryBiz.getMaxId();
        NumberFormat nf2 = NumberFormat.getInstance();
        //设置是否使用分组
        nf2.setGroupingUsed(false);
        //设置最大整数位数
        nf2.setMaximumIntegerDigits(7);
        //设置最小整数位数    
        nf2.setMinimumIntegerDigits(7);
        String nextId=nf2.format(maxid+1);
		String orderId = date+userIdresult+nextId;
		buyhistory.setOrderId(orderId);
		//生成订单Id----结束
		buyhistory.setCtime(new Date());
		buyhistory.setOrderType("直接购买");
		buyhistoryBiz.add(buyhistory);
		return buyhistory.getbId()+"";
	}
	@RequestMapping(value = "/refrshBids", method = RequestMethod.POST)
	@ResponseBody
	public List<Bidlite> refrshBids(HttpServletRequest request, HttpServletResponse response) {
		Integer goodsid=Integer.parseInt(request.getParameter("goodsid"));
		List<Bidlite> bids = bidBiz.getbidsbygoodsid(goodsid);
		return bids;
	}
	@RequestMapping(value = "/loadbidbyuser", method = RequestMethod.POST)
	@ResponseBody
	public List<Bidlite> loadbidbyuser(HttpServletRequest request, HttpServletResponse response) {
		Integer goodsid=Integer.parseInt(request.getParameter("goodsid"));
		List<Bidlite> bids = bidBiz.getbidsbygoodsid(goodsid);
		return bids;
	}

	@RequestMapping(value = "/getMyBidAllList", method = RequestMethod.POST)
	@ResponseBody
	public List<BidAllForUserVo> getMyBidAllList(HttpServletRequest request, HttpServletResponse response,int userid) {
		List<BidAllForUser> bids = bidBiz.getMyBidAllList(userid);
		List<BidAllForUserVo> bidonevolist=new ArrayList<BidAllForUserVo>();
		for(BidAllForUser bidone:bids) {
			BidAllForUserVo bidonevo=new BidAllForUserVo(); 
			try {
				if(null==bidone.getGoodsPrice()) {
					bidone.setGoodsPrice(new BigDecimal(0));
				}
				if(null==bidone.getLessMoney()) {
					bidone.setLessMoney(new BigDecimal(0));
				}
				BeanUtils.copyProperties(bidonevo, bidone);

			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			int paycointotal=bidone.getGoodsStepcoin()*bidone.getCount();
			User lessuser=userBiz.getbyusername(bidone.getLessBidusername());
			bidonevo.setLessUserId(lessuser.getUserId());
			bidonevo.setPaycointotal(paycointotal);
			bidonevo.setReturncoin(paycointotal/5);
			bidonevolist.add(bidonevo);
		}
		return bidonevolist;
	}
}
