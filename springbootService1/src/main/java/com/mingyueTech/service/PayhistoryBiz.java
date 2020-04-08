package com.mingyueTech.service;

import com.mingyueTech.entity.Payhistory;

public interface PayhistoryBiz {

	int getMaxId();


	void insert(Payhistory ph);


	Payhistory getByAlipayOrderid(String trade_no);

}
