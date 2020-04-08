package com.mingyueTech.service.impl;

import com.mingyueTech.dao.PayhistoryMapper;
import com.mingyueTech.entity.Payhistory;
import com.mingyueTech.service.PayhistoryBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service(value = "payhistoryBiz")
public class PayhistoryBizImpl implements PayhistoryBiz {
	@Autowired
	private PayhistoryMapper payhistoryDAO;

	@Override
	public int getMaxId() {
		return payhistoryDAO.getMaxId();
	}



	@Override
	public void insert(Payhistory ph) {
		payhistoryDAO.insertSelective(ph);
		
	}



	@Override
	public Payhistory getByAlipayOrderid(String trade_no) {
		return payhistoryDAO.getByAlipayOrderid(trade_no);
	}
}
