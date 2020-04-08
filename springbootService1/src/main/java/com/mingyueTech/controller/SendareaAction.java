package com.mingyueTech.controller;

import com.mingyueTech.entity.Area;
import com.mingyueTech.entity.Buyhistory;
import com.mingyueTech.entity.Sendarea;
import com.mingyueTech.service.AreaBiz;
import com.mingyueTech.service.BuyhistoryBiz;
import com.mingyueTech.service.SendareaBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class SendareaAction {
	private BuyhistoryBiz buyhistoryBiz;
	private SendareaBiz sendareaBiz;
	private AreaBiz areaBiz;

	@RequestMapping(value = "/addsendarea", method = RequestMethod.POST)
	@ResponseBody
	public String addsendarea(HttpServletRequest request, HttpServletResponse response, Sendarea sendarea) {

		if (null == sendarea.getId()) {

			Area area = areaBiz.getbyid(sendarea.getAid());
			sendarea.setAreaname(area.getName());
			sendareaBiz.insert(sendarea);
			
		} else {
			
			sendareaBiz.update(sendarea);
			
		}
		return "保存收货地址成功";
	}
	@RequestMapping(value = "/addSendAreaAndInOrder", method = RequestMethod.POST)
	@ResponseBody
	public String addSendAreaAndInOrder(HttpServletRequest request, HttpServletResponse response) {
		String bId=request.getParameter("bId");
		Buyhistory buyhistory = buyhistoryBiz.getByOrderId(bId);
		
		Sendarea sendarea=new Sendarea();
		String urealname=request.getParameter("urealname");
		String detailarea=request.getParameter("detailarea");
		String urealmobile=request.getParameter("urealmobile");
		sendarea.setUid(buyhistory.getuId());
		sendarea.setDetailarea(detailarea);
		sendarea.setUrealname(urealname);
		sendarea.setUrealmobile(urealmobile);
		sendarea.setSaStutas(2);
		sendareaBiz.insert(sendarea);
		buyhistory.setUserRealName(urealname);
		buyhistory.setUserRealMobile(urealmobile);
		buyhistory.setDetailArea(detailarea);
		buyhistoryBiz.update(buyhistory);
			return "保存收货地址成功";
	}
	
	@RequestMapping(value = "/getsendareabyid", method = RequestMethod.POST)
	@ResponseBody
	public Sendarea getsendareabyid(HttpServletRequest request, HttpServletResponse response, int id) {
		Sendarea sendarea = sendareaBiz.getsendareabyid(id);
		return sendarea;
	}

	@RequestMapping(value = "/getsendareabyuser", method = RequestMethod.POST)
	@ResponseBody
	public List<Sendarea> getsendareabyuser(HttpServletRequest request, HttpServletResponse response, int uid) {
		List<Sendarea> sendareaList = sendareaBiz.getsendareabyuser(uid);
		return sendareaList;
	}

	@RequestMapping(value = "/deletearea", method = RequestMethod.POST)
	@ResponseBody
	public String deletearea(HttpServletRequest request, HttpServletResponse response, int id) {
		Sendarea sendarea = sendareaBiz.getsendareabyid(id);
		sendarea.setSaStutas(0);
		sendareaBiz.update(sendarea);
//		try {
////			response.sendRedirect("/usercenter/address.jsp");
////			response.sendRedirect("/index.jsp");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return "删除收货地址成功";
	}

}
