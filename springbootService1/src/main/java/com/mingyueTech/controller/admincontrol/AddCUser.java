package com.mingyueTech.controller.admincontrol;

import com.mingyueTech.dao.AreaMapper;
import com.mingyueTech.entity.User;
import com.mingyueTech.service.UserBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class AddCUser{

	private UserBiz userBiz;

	private AreaMapper areaDAO;
	

	@RequestMapping(value = "/adminuseradd")
	@ResponseBody
	public String adminuseradd() {
List<User> userList=userBiz.getall();
for(User u:userList) {
	Integer aid=areaDAO.getAddrAidById(u.getAddressArea1());
	if(null!=aid) {
	u.setAddressArea1(aid);
	}
	userBiz.update(u);
}
		return "addSuccess";
	}

}
