package com.mingyueTech.service;

import java.util.List;

import com.mingyueTech.entity.Category;

public interface CategoryBiz {

	List<Category> getbyroot();

	String getcategoryname(int cid);

	List<Category> getGoodsCategory();

}
