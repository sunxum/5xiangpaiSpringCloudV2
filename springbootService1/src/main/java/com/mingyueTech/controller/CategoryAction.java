package com.mingyueTech.controller;

import com.mingyueTech.entity.Category;
import com.mingyueTech.service.CategoryBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
public class CategoryAction {
	private CategoryBiz categoryBiz;
	
	@RequestMapping(value = "/getbyroot", method = RequestMethod.POST)
	@ResponseBody
	public List<Category> getbyroot(HttpServletRequest request, HttpServletResponse response) {
		List<Category> categorylist=categoryBiz.getbyroot();
		return categorylist;
	}
		
		@RequestMapping(value = "/getcategoryname", method = RequestMethod.POST)
		@ResponseBody
		public String getcategoryname(HttpServletRequest request, HttpServletResponse response,int cid) {
			String categoryname=categoryBiz.getcategoryname(cid);
			return categoryname;
	}
		
		@RequestMapping(value = "/getGoodsCategory", method = RequestMethod.POST)
		@ResponseBody
		public List<Category> getGoodsCategory(HttpServletRequest request, HttpServletResponse response) {
			List<Category> categoryList=categoryBiz.getGoodsCategory();
			return categoryList;
	}
}
