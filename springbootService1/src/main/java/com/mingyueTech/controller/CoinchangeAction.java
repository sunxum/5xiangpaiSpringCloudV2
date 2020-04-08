package com.mingyueTech.controller;

import com.mingyueTech.entity.Bid;
import com.mingyueTech.entity.Coinchange;
import com.mingyueTech.entity.User;
import com.mingyueTech.service.BidBiz;
import com.mingyueTech.service.CoinchangeBiz;
import com.mingyueTech.service.UserBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
public class CoinchangeAction {
	private CoinchangeBiz coinchangeBiz;
	private UserBiz	userBiz;
	private BidBiz bidBiz;
	
	
	@RequestMapping(value = "/getcoinchangebyuser", method = RequestMethod.POST)
	@ResponseBody
	public List<Coinchange> getcoinchangebyuser(HttpServletRequest request, HttpServletResponse response,String uid) {
		List<Coinchange> coinchangelist=coinchangeBiz.getcoinchangebyuser(Integer.parseInt(uid));
		return coinchangelist;
	}
	@RequestMapping(value = "/doPostBack", method = RequestMethod.POST)
	@ResponseBody
	public String doPostBack(HttpServletRequest request, HttpServletResponse response,String uid,int bid,int freecoin) {
		int uId=Integer.parseInt(uid);
		//记录
		Coinchange coinchange=new Coinchange();
		coinchange.setFreecoin(freecoin);
		coinchange.setPaycoin(0);
		coinchange.setPractivicoin(0);
		coinchange.setuId(uId);
		coinchange.setCtime(new Date());
		coinchange.setDescription("返还拍币");
		coinchangeBiz.insert(coinchange);
		//更新用户拍币
		User u=userBiz.getbyid(uId);
		u.setFreecoin(u.getFreecoin()+freecoin);
		userBiz.update(u);
		//改变最后竞拍id状态
		Bid b=bidBiz.getById(bid);
		b.setBidStatus(2);
		bidBiz.update(b);
		return "返还拍币成功";
	}
	
	@RequestMapping(value = "/changeCoin", method = RequestMethod.POST)
	@ResponseBody
	public String changeCoin(HttpServletRequest request, HttpServletResponse response,Integer userId,Integer num) {
		User u=userBiz.getbyid(userId);
		if(num>u.getScore()) {
			return "您的积分不足";
		}
		u.setScore(u.getScore()-num);
		u.setFreecoin(u.getFreecoin()+num*2);
		userBiz.update(u);
		//写入coinChange
		Coinchange coinchange=new Coinchange();
		coinchange.setFreecoin(num*2);
		coinchange.setPaycoin(0);
		coinchange.setPractivicoin(0);
		coinchange.setuId(userId);
		coinchange.setCtime(new Date());
		coinchange.setDescription("积分兑换拍币");
		coinchangeBiz.insert(coinchange);
		return "兑换成功";
	}
	
	
}
