package com.mingyueTech.service.impl;

import com.mingyueTech.dao.PublicpicMapper;
import com.mingyueTech.entity.PublicPicVo;
import com.mingyueTech.entity.Publicpic;
import com.mingyueTech.service.PublicpicBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "publicpicBiz")
public class PublicpicBizImpl implements PublicpicBiz {
	@Autowired
	private PublicpicMapper publicpicDAO;
	@Override
	public List getpublicList() {
		return publicpicDAO.getall();
	}
	@Override
	public void addpublicpic(Publicpic item) {
		publicpicDAO.insertSelective(item);
		
	}
	@Override
	public Publicpic selectByPrimaryKey(Integer id) {
		return publicpicDAO.selectByPrimaryKey(id);
	}
	@Override
	public List<PublicPicVo> getpublicListAll() {
		return publicpicDAO.getpublicListAll();
	}
	@Override
	public PublicPicVo getpublicpicbypid(Integer pid) {
		return publicpicDAO.getpublicpicbypid(pid);
	}
	@Override
	public List<PublicPicVo> getpublicListFour() {
		return publicpicDAO.getPublicPicFour();
	}
	@Override
	public void deletePublicPic(int id) {
		publicpicDAO.deleteByPrimaryKey(id);
		
	}
	@Override
	public PublicPicVo getPublicVoById(int id) {
		return publicpicDAO.getPublicVoById(id);
	}
	@Override
	public void update(Publicpic item) {
		publicpicDAO.updateByPrimaryKeySelective(item);
		
	}
	@Override
	public Publicpic getPublicyId(int id) {
		return publicpicDAO.selectByPrimaryKey(id);
	}

}
