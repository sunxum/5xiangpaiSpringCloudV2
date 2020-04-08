package com.mingyueTech.service.impl;

import com.mingyueTech.dao.AreaMapper;
import com.mingyueTech.entity.Area;
import com.mingyueTech.service.AreaBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "areaBiz")
public class AreaBizImpl implements AreaBiz {
	@Autowired
	private AreaMapper areaDAO;

	@Override
	public List<Area> getlevel1() {
		return areaDAO.getlevel1();
	}

	@Override
	public List<Area> getlevel2(Integer area1id) {
		return areaDAO.getlevel2(area1id);
	}

	@Override
	public List<Area> getlevel3(Integer area2id) {
		return areaDAO.getlevel3(area2id);
	}

	@Override
	public Area getbyid(Integer aid) {
		return areaDAO.getbyid(aid);
	}

	@Override
	public Integer getlevel2ByLevel3(Integer level3aid) {
		return areaDAO.getfid(level3aid);
	}

	@Override
	public Integer getlevel1ByLevel2(Integer level2aid) {
		return areaDAO.getfid(level2aid);
	}

	@Override
	public String getAddrById(int addrId) {
		return areaDAO.getAddrById(addrId);
	}
}
