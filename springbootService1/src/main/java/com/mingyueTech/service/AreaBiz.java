package com.mingyueTech.service;

import java.util.List;

import com.mingyueTech.entity.Area;

public interface AreaBiz {

	List<Area> getlevel1();

	List<Area> getlevel2(Integer area1id);

	List<Area> getlevel3(Integer area2id);

	Area getbyid(Integer aid);

	Integer getlevel2ByLevel3(Integer level3aid);

	Integer getlevel1ByLevel2(Integer level2aid);

	String getAddrById(int addrId);

}
