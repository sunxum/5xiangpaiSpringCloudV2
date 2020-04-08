package com.mingyueTech.controller;

import com.mingyueTech.entity.Administrivia;
import com.mingyueTech.service.AdministriviaBiz;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
@Controller
public class AdministriviaAction {
	@Qualifier("administriviaBiz")
	private AdministriviaBiz administriviaBiz;
	
	@RequestMapping(value = "/administriviatoadd", method = RequestMethod.POST)
	@ResponseBody
	public void administriviatoadd(HttpServletRequest request, HttpServletResponse response,Administrivia item) {
		if(null!=item.getId()) {
			administriviaBiz.update(item);
		}else {
			item.setCtime(new Date());
			administriviaBiz.add(item);
		}
		try {
			response.sendRedirect("/admi/publicadministriviasuccess.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/loadadministrivia", method = RequestMethod.POST)
	@ResponseBody
	public List<Administrivia> loadadministrivia(HttpServletRequest request, HttpServletResponse response) {
		List<Administrivia> list=administriviaBiz.getall();
		return list;

	}
	@RequestMapping(value = "/newsdescription", method = RequestMethod.POST)
	@ResponseBody
	public Administrivia loadadministrivia(HttpServletRequest request, HttpServletResponse response,Integer id) {
		Administrivia administrivia=administriviaBiz.selectByPrimaryKey(id);
		return administrivia;
	}
	@RequestMapping(value = "/deletenews", method = RequestMethod.POST)
	@ResponseBody
	public void deletenews(HttpServletRequest request, HttpServletResponse response,Integer id) {
		administriviaBiz.drop(id);
	}
	
}
