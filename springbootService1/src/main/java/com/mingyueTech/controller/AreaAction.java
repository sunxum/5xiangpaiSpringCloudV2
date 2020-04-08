package com.mingyueTech.controller;

import com.mingyueTech.entity.Area;
import com.mingyueTech.service.AreaBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AreaAction {
	private AreaBiz areaBiz;
	
	@RequestMapping(value = "/getAllLevel1", method = RequestMethod.POST)
	@ResponseBody
	public List<Area> getlevel1(HttpServletRequest request, HttpServletResponse response) {
		List<Area> bids = areaBiz.getlevel1();
		return bids;
	}
	
	@RequestMapping(value = "/getAllLevel2", method = RequestMethod.POST)
	@ResponseBody
	public List<Area> getlevel2(HttpServletRequest request, HttpServletResponse response) {
		Integer goodsid=Integer.parseInt(request.getParameter("level1id"));
		List<Area> bids = areaBiz.getlevel2(goodsid);
		return bids;
	}
	
	@RequestMapping(value = "/getAllLevel3", method = RequestMethod.POST)
	@ResponseBody
	public List<Area> getlevel3(HttpServletRequest request, HttpServletResponse response) {
		Integer goodsid=Integer.parseInt(request.getParameter("level2id"));
		List<Area> bids = areaBiz.getlevel3(goodsid);
		return bids;
	}
	@RequestMapping(value = "/getAreaByLevel3", method = RequestMethod.POST)
	@ResponseBody
	public String getAreaByLevel3(HttpServletRequest request, HttpServletResponse response,int level3aid) {
		Integer level2aid = areaBiz.getlevel2ByLevel3(level3aid);
		Integer level1aid = areaBiz.getlevel1ByLevel2(level2aid);
		return level1aid+","+level2aid+","+level3aid;
	}
	
	@RequestMapping(value = "/getAddrById", method = RequestMethod.POST)
	@ResponseBody
	public String getAddrById(HttpServletRequest request, HttpServletResponse response,int addrId) {

		String addrString = areaBiz.getAddrById(addrId);
		return addrString;
	}
}
