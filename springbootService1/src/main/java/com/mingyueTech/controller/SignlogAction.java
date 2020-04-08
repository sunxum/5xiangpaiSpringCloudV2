package com.mingyueTech.controller;

import com.mingyueTech.entity.Coinchange;
import com.mingyueTech.entity.Signlog;
import com.mingyueTech.entity.User;
import com.mingyueTech.service.CoinchangeBiz;
import com.mingyueTech.service.SignlogBiz;
import com.mingyueTech.service.UserBiz;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class SignlogAction {
	@Qualifier("signlogBiz")
	private SignlogBiz signlogBiz;

	@Qualifier("userBiz")
	private UserBiz userBiz;

	private CoinchangeBiz coinchangeBiz;
	@RequestMapping(value = "/signdoadd", method = RequestMethod.POST)
	@ResponseBody
	public String signdoadd(HttpServletRequest request, HttpServletResponse response,String username) {
		int coin=Integer.parseInt(request.getParameter("addcoin"));
		User user=userBiz.getbyusername(username);
		Signlog signlog=new Signlog();		
		signlog.setUid(user.getUserId());
		signlog.setCtime(new Date());
		signlogBiz.add(signlog);
		//送freecoin
		user.setPracticecoin(user.getPracticecoin()+coin);
		user.setScore(user.getScore()+50);
		userBiz.update(user);
		//coinchange
		Coinchange coinchange=new Coinchange();
		coinchange.setuId(user.getUserId());
		coinchange.setPractivicoin(coin);
		coinchange.setCtime(new Date());
		coinchange.setDescription("打卡增加拍币");
		coinchange.setFreecoin(0);
		coinchange.setPaycoin(0);
		coinchangeBiz.insert(coinchange);
		try {
			response.sendRedirect("/usercenter/signday.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";		
	}
	
	@RequestMapping(value = "/getsignlog", method = RequestMethod.POST)
	@ResponseBody
	public List<Signlog> getsignlog(HttpServletRequest request, HttpServletResponse response,Integer userId) {
		List<Signlog> signloglist=signlogBiz.getSignlogByUser(userId);
			return signloglist;		
	}
	@RequestMapping(value = "/getsignday", method = RequestMethod.POST)
	@ResponseBody
	public String getsignday(HttpServletRequest request, HttpServletResponse response,String username) {
		User user=userBiz.getbyusername(username);
		Signlog signtoday=signlogBiz.getsigntoday(user.getUserId());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(new Date());
		if(signtoday==null) {
			return "0,false";
		}
		else {
		String signlasttime = formatter.format(signtoday.getCtime());
		Integer signday=0;
		if(dateString.equals(signlasttime)) {
			signday=signlogBiz.getsigntodayByUser(user.getUserId());
			if(null==signday) {
				signday=0;
			}
			   return (signday-1)+",true";
		   }else {
			signday=signlogBiz.getsigndayByUser(user.getUserId());
			if(null==signday) {
				signday=0;
			}
			return signday+",false";	
		   }
		}
	}
}
