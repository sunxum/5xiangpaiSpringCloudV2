package com.mingyueTech.service;

import java.util.List;

import com.mingyueTech.entity.Coinchange;

public interface CoinchangeBiz {

	void update(Coinchange coinchange);

	void insert(Coinchange coinchange);

	List<Coinchange> getcoinchangebyuser(int parseInt);

}
