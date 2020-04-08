package com.mingyueTech.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mingyueTech.entity.PublicPicVo;
import com.mingyueTech.entity.Publicpic;
@Repository
public interface PublicpicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Publicpic record);

    int insertSelective(Publicpic record);

    Publicpic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Publicpic record);

    int updateByPrimaryKey(Publicpic record);

	List getall();

	List<PublicPicVo> getpublicListAll();

	PublicPicVo getpublicpicbypid(Integer pid);

	List<PublicPicVo> getPublicPicFour();

	PublicPicVo getPublicVoById(int id);
}