package com.mingyueTech.controller;

import com.mingyueTech.entity.Goodslist;
import com.mingyueTech.service.GoodslistBiz;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class GoodslistAction {
	@Qualifier("goodslistBiz")
	private GoodslistBiz goodslistBiz;

	
	@RequestMapping(value = "/goodstoadd", method = RequestMethod.POST)
	@ResponseBody
	public String doAdd(
			HttpServletRequest request, HttpServletResponse response,Goodslist item,String endTimeString,String beginTimeString) {
		String ids=request.getParameter("glId");
		if(null==ids||"".equals(ids)) {
		Date endDate = null;
		try  
		{  
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		    endDate = sdf.parse(endTimeString);  
		}  
		catch (ParseException e)  
		{  
		    System.out.println(e.getMessage());  
		} 
		Date beginDate = null;
		try  
		{  
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		    beginDate = sdf.parse(beginTimeString);  
		}  
		catch (ParseException e)  
		{  
		    System.out.println(e.getMessage());  
		} 
		item.setEndTime(endDate);
		item.setBeginTime(beginDate);
		item.setCtime(new Date());
		goodslistBiz.addGoods(item);
		return "添加商品成功";
		}else {		
			int id=Integer.parseInt(ids);
			Goodslist goodslist=goodslistBiz.getGoodsListById(id);
		goodslist.setGoodsStatus(0);
		goodslistBiz.update(goodslist);
		goodslist.setGlId(null);
		goodslist.setCtime(new Date());
		goodslist.setGoodsStatus(1);
		goodslistBiz.addGoods(goodslist);}
		return "更新商品成功";
	}
	@RequestMapping(value = "/getgoodslist", method = RequestMethod.POST)
	@ResponseBody
	public List<Goodslist> getgoodslist(
			HttpServletRequest request, HttpServletResponse response,Goodslist item,String endTimeString,String beginTimeString) {
		List<Goodslist> goodslist=goodslistBiz.getAllGoodsByStats();
		return goodslist;
	}
	@RequestMapping(value = "/toMyGoodsList", method = RequestMethod.POST)
	@ResponseBody
	public List toMyGoodsList(
			HttpServletRequest request, HttpServletResponse response) {
		Integer userId = 0;
		List list = this.goodslistBiz.getMyGoodsList(userId);
		 
		return list;
	}
	@RequestMapping(value = "/getGoodsListbyId", method = RequestMethod.POST)
	@ResponseBody
	public Goodslist getGoodsListbyId(
			HttpServletRequest request, HttpServletResponse response,Goodslist item,String endTimeString,String beginTimeString) {
		int id=Integer.parseInt(request.getParameter("id"));
		Goodslist goodslist=goodslistBiz.getGoodsListById(id);
		return goodslist;
	}
	@RequestMapping(value = "/deleteGoodsList", method = RequestMethod.POST)
	@ResponseBody
	public String deleteGoodsList(
			HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		Goodslist goodsList=goodslistBiz.getGoodsbyid(id);
		goodsList.setGoodsStatus(0);
		this.goodslistBiz.updatestutasGoodsList(goodsList);
		 
		return "软删除成功";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getrefrshGoods", method = RequestMethod.POST)
	@ResponseBody
	public List<Goodslist> getrefrshGoods(){

			List<Goodslist> goodsList =goodslistBiz.getrefrshGoods();
			return goodsList;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/onsalelist")
	@ResponseBody
	public List<Goodslist> onsalelist(HttpServletRequest request, HttpServletResponse response){
			List<Goodslist> goodsList =goodslistBiz.getAllCanSale();
			return goodsList;
	}
}
