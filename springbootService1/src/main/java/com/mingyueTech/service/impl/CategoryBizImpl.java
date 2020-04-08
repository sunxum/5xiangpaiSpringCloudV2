package com.mingyueTech.service.impl;

import com.mingyueTech.dao.CategoryMapper;
import com.mingyueTech.entity.Category;
import com.mingyueTech.service.CategoryBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value="categoryBiz")
public class CategoryBizImpl implements CategoryBiz {
	@Autowired
	private CategoryMapper categoryDAO;

	@Override
	public List<Category> getbyroot() {
		return categoryDAO.getbyroot();
	}

	@Override
	public String getcategoryname(int cid) {
		return categoryDAO.getcategoryname(cid);
	}

	@Override
	public List<Category> getGoodsCategory() {
		return categoryDAO.getGoodsCategory();
	}
}
