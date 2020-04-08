
package com.mingyueTech.controller;

import com.mingyueTech.entity.Coinchange;
import com.mingyueTech.entity.User;
import com.mingyueTech.entity.Userchange;
import com.mingyueTech.service.CoinchangeBiz;
import com.mingyueTech.service.UserBiz;
import com.mingyueTech.service.UserchangeBiz;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserAction {

	@Qualifier("userBiz")
	private UserBiz userBiz;

	@Qualifier("coinchangeBiz")
	private CoinchangeBiz coinchangeBiz;

	@Qualifier("userchangeBiz")
	private UserchangeBiz userchangeBiz;

	@RequestMapping(value = "/userdoAdd", method = RequestMethod.POST)
	@ResponseBody
	public String doAdd(HttpServletRequest request, HttpServletResponse response, User item, String sex,
			String userIdCode, String birthdaystring, String weixinNum, String qqNum) {

		if (this.userBiz.isExists(item.getUserName())) {
			try {
				response.sendRedirect("/repeatname.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "用户名已存在";
		} else {
			// 注册送freecoin
			item.setFreecoin(1000);
			Date birthday = null;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				birthday = sdf.parse(birthdaystring);
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}

			item.setBirthday(birthday);
			item.setSex(sex);
			item.setQqnum(qqNum);
			item.setWeixinnum(weixinNum);
			item.setUserIdCode(userIdCode);
			item.setCtime(new Date());
			this.userBiz.add(item);
			// coinchange
			Coinchange coinchange = new Coinchange();
			coinchange.setuId(item.getUserId());
			coinchange.setFreecoin(1000);
			coinchange.setPaycoin(0);
			coinchange.setPractivicoin(0);
			coinchange.setDescription("注册送免费拍币");
			coinchange.setCtime(new Date());
			coinchangeBiz.insert(coinchange);
			Cookie cookie = new Cookie("username", item.getUserName());
			cookie.setPath("/");
			response.addCookie(cookie);
			Cookie cookie2 = new Cookie("userid", item.getUserId() + "");
			cookie2.setPath("/");
			response.addCookie(cookie2);
			try {
				response.sendRedirect("/index.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		}
	}

	@RequestMapping(value = "/userdoLogin")
	@ResponseBody
	public String doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User item = this.userBiz.login(username, password);
		if (null != item) {// 登录成功
			Cookie cookie = new Cookie("username", username);
			cookie.setPath("/");
			Cookie cookie2 = new Cookie("userid", item.getUserId() + "");
			cookie2.setPath("/");
			response.addCookie(cookie2);
			response.addCookie(cookie);
			return "登录成功";
		} else {
			return "用户名或密码错误，登陆失败！";
		}
	}

	@RequestMapping(value = "/admindoLogin")
	@ResponseBody
	public String admindoLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User item = this.userBiz.login(username, password);
		if (null != item) {// 登录成功
			if ("admin".equals(item.getUserStatus())) {
				Cookie cookie = new Cookie("username", username);
				cookie.setPath("/");
				Cookie cookie2 = new Cookie("userid", item.getUserId() + "");
				cookie2.setPath("/");
				response.addCookie(cookie2);
				response.addCookie(cookie);
				return "登录成功";
			} else {
				return "对不起，您不是管理员";
			}

		} else {
			return "用户名或密码错误，登陆失败！";
		}
	}

	@RequestMapping(value = "/bindmobileback", method = RequestMethod.POST)
	@ResponseBody
	public String bindmobileback(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String userTel = request.getParameter("mobile");
		User user = userBiz.getbyusername(username);
		user.setUserTel(userTel);
		Userchange userchange = new Userchange();
		userchange.setUserId(user.getUserId());
		userchange.setUserTel(userTel);
		userchangeBiz.insert(userchange);
		userBiz.update(user);
		return null;
	}

	@RequestMapping(value = "/getpracticecoin", method = RequestMethod.POST)
	@ResponseBody
	public String getpracticecoin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		User user = userBiz.getbyusername(username);

		return user.getPracticecoin() + "";
	}

	@RequestMapping(value = "/usergetdesc", method = RequestMethod.POST)
	@ResponseBody
	public User usergetdesc(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		User user = userBiz.getbyusername(username);

		return user;
	}

	@RequestMapping(value = "/usergetdescbyid", method = RequestMethod.POST)
	@ResponseBody
	public User usergetdescbyid(HttpServletRequest request, HttpServletResponse response, int userId)
			throws IOException {
		User user = userBiz.getbyid(userId);

		return user;
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	@ResponseBody
	public String changePassWord(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String userPassword = request.getParameter("txtNewPwd");
		User user = userBiz.getbyusername(username);
		user.setUserPassword(userPassword);
		userBiz.update(user);
		return "修改密码成功";
	}

	@RequestMapping(value = "/saveuserdetial", method = RequestMethod.POST)
	@ResponseBody
//	public String saveuserdetial(HttpServletRequest request, HttpServletResponse response, int uid, int addressArea1,
//			 String P1,String C1,String A1,String truename, String userTel, String userEmail, String userIdCode) {

	public String saveuserdetial(HttpServletRequest request,HttpServletResponse response){
			int uid = Integer.parseInt(request.getParameter("uid"));
		 int addressArea1 = Integer.parseInt(request.getParameter("addressArea1"));
		 String sex = request.getParameter("sex");
		 String truename = request.getParameter("truename");
		 String userTel = request.getParameter("userTel");
		 String userEmail=request.getParameter("userEmail");
		 String userIdCode = request.getParameter("userIdCode");
		 String birthdaystring = request.getParameter("birthdaystring");

//		Date birthday = null;
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
//			//birthday = sdf.parse(birthdaystring);
//		} catch (ParseException e) {
//			System.out.println(e.getMessage());
//		}

		User user = userBiz.getbyid(uid);
		//user.setBirthday(birthday);
		user.setTruename(truename);
		user.setUserTel(userTel);
		user.setUserIdCode(userIdCode);
		user.setAddressArea1(addressArea1);
		userBiz.update(user);
		return "保存成功";
	}

	@RequestMapping(value = "/uploadheader", method = RequestMethod.POST)
	@ResponseBody
	public String uploadheader(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, HttpServletResponse response, String username) {

		String path = request.getSession().getServletContext().getRealPath("upload/userheader");
		System.out.println(path);
		String realpath = path.replaceAll("Back", "Front");
		System.out.println(realpath);
		String fileName = file.getOriginalFilename();
		String prefix = fileName.substring(fileName.lastIndexOf("."));
		String fileNewName = new Date().getTime() + prefix;
		File targetFile = new File(realpath, fileNewName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		User user = userBiz.getbyusername(username);
		user.setHeadimg("/upload/userheader/" + fileNewName);
		userBiz.update(user);
		return "/upload/userheader/" + fileNewName;
	}

	@RequestMapping(value = "/getUserNameList", method = RequestMethod.POST)
	@ResponseBody
	public List<HashMap<String, String>> getUserNameList(HttpServletRequest request, HttpServletResponse response) {
		List<HashMap<String, String>> user = userBiz.getUserNameList();
		return user;
	}

}