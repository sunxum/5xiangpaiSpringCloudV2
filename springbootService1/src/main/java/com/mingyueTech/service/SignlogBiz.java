package com.mingyueTech.service;

import java.util.List;

import com.mingyueTech.entity.Signlog;

public interface SignlogBiz {

	void add(Signlog item);

	List<Signlog> getSignlogByUser(Integer userId);

	Integer getsigndayByUser(Integer integer);

	Signlog getsigntoday(Integer userId);

	Integer getsigntodayByUser(Integer userId);

}
