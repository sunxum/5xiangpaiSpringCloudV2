package com.mingyueTech.dao;

import com.mingyueTech.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
    Area getRondomOne();

	List<Area> getlevel1();

	List<Area> getlevel2(Integer area1id);

	List<Area> getlevel3(Integer area2id);

	Area getbyid(Integer aid);

	Integer getfid(Integer level3aid);

	String getAddrById(int addrId);

	Integer getAddrAidById(Integer addressArea1);
}