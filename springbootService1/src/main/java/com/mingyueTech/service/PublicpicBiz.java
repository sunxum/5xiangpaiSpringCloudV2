package com.mingyueTech.service;

import java.util.List;

import com.mingyueTech.entity.PublicPicVo;
import com.mingyueTech.entity.Publicpic;

public interface PublicpicBiz {
	public List getpublicList();

	public void addpublicpic(Publicpic item);
	Publicpic selectByPrimaryKey(Integer id);

	public List<PublicPicVo> getpublicListAll();

	public PublicPicVo getpublicpicbypid(Integer pid);

	public List<PublicPicVo> getpublicListFour();

	public void deletePublicPic(int id);

	public PublicPicVo getPublicVoById(int id);

	public void update(Publicpic item);

	public Publicpic getPublicyId(int id);
}
