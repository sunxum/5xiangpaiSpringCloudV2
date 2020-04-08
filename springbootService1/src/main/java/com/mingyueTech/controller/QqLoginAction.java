package com.mingyueTech.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mingyueTech.entity.User;
import com.mingyueTech.service.UserBiz;
import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.javabeans.weibo.Company;
import com.qq.connect.oauth.Oauth;

@Controller
public class QqLoginAction {
	private UserBiz userBiz;

	@RequestMapping(value = "/qqLogin")
	@ResponseBody
	protected void qqLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		try {
			String url = (new Oauth()).getAuthorizeURL(request);
			response.sendRedirect(url);
		} catch (QQConnectException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/qqAfterLogin")
	@ResponseBody
	protected void qqAfterLogin(HttpServletRequest request, HttpServletResponse response) {
		String userName = null;
		String userHeader = null;
		Date userBirthDay = null;
		String userArea = null;
		try {
			AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);

			String accessToken = null, openID = null;
			long tokenExpireIn = 0L;
			accessToken = accessTokenObj.getAccessToken();
			tokenExpireIn = accessTokenObj.getExpireIn();

			// 利用获取到的accessToken 去获取当前用的openid -------- start
			OpenID openIDObj = new OpenID(accessToken);
			openID = openIDObj.getUserOpenID();

			UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
			UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
			if (userInfoBean.getRet() == 0) {
				userName = userInfoBean.getNickname();
				userHeader = userInfoBean.getAvatar().getAvatarURL100();
			}

			com.qq.connect.api.weibo.UserInfo weiboUserInfo = new com.qq.connect.api.weibo.UserInfo(accessToken,
					openID);
			com.qq.connect.javabeans.weibo.UserInfoBean weiboUserInfoBean = weiboUserInfo.getUserInfo();
			// 获取用户的微博头像----------------------start
			if (null != weiboUserInfoBean.getAvatar()) {
				userHeader = weiboUserInfoBean.getAvatar().getAvatarURL100();
			}
			// 获取用户的微博头像 ---------------------end

			// 获取用户的生日信息 --------------------start
			if (null != weiboUserInfoBean.getBirthday()) {
				String month = null;
				if (10 > weiboUserInfoBean.getBirthday().getMonth()) {
					month = "0" + weiboUserInfoBean.getBirthday().getMonth();
				} else {
					month = weiboUserInfoBean.getBirthday().getMonth() + "";
				}
				String day = null;
				if (10 > weiboUserInfoBean.getBirthday().getDay()) {
					day = "0" + weiboUserInfoBean.getBirthday().getDay();
				} else {
					day = weiboUserInfoBean.getBirthday().getDay() + "";
				}
				String userBirthDayTemp = weiboUserInfoBean.getBirthday().getYear() + "-" + month + "-" + day;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				userBirthDay = sdf.parse(userBirthDayTemp);
			}
			// 获取用户的生日信息 --------------------end

			StringBuffer sb = new StringBuffer();
			sb.append("<p>所在地:" + weiboUserInfoBean.getCountryCode() + "-" + weiboUserInfoBean.getProvinceCode() + "-"
					+ weiboUserInfoBean.getCityCode() + weiboUserInfoBean.getLocation());
			userArea = weiboUserInfoBean.getCountryCode() + "-" + weiboUserInfoBean.getProvinceCode() + "-"
					+ weiboUserInfoBean.getCityCode() + weiboUserInfoBean.getLocation();
			// 获取用户的公司信息---------------------------start
			ArrayList<Company> companies = weiboUserInfoBean.getCompanies();
			if (companies.size() > 0) {
				// 有公司信息
				for (int i = 0, j = companies.size(); i < j; i++) {
					sb.append("<p>曾服役过的公司：公司ID-" + companies.get(i).getID() + " 名称-" + companies.get(i).getCompanyName()
							+ " 部门名称-" + companies.get(i).getDepartmentName() + " 开始工作年-"
							+ companies.get(i).getBeginYear() + " 结束工作年-" + companies.get(i).getEndYear());
				}
			}
			User user = userBiz.getbyQqOpenId(openID);
			if (null == user) {
				User newUser = new User();
				newUser.setUserPassword("QQLogin");
				newUser.setQqOpenid(openID);
				if (null == userName) {
					userName = "QQ用户";
				}
				User reUser = null;
				String count = "0";
				userName=userName.trim();
				String userNewName = userName;
				do {
					if ("".equals(count)) {
						count = "0";
					}
					count = (Integer.parseInt(count) + 1) + "";
					userNewName = userName + count;
					reUser = userBiz.getbyusername(userNewName);
				} while (reUser != null);
				newUser.setUserName(userNewName);
				newUser.setHeadimg(userHeader);
				newUser.setBirthday(userBirthDay);
				newUser.setArea(userArea);
				userBiz.add(newUser);
				Cookie cookie = new Cookie("username", newUser.getUserName());
				cookie.setPath("/");
				response.addCookie(cookie);
				Cookie cookie2 = new Cookie("userid", newUser.getUserId() + "");
				cookie2.setPath("/");
				response.addCookie(cookie2);
			} else {
				Cookie cookie = new Cookie("username", user.getUserName());
				cookie.setPath("/");
				response.addCookie(cookie);
				Cookie cookie2 = new Cookie("userid", user.getUserId() + "");
				cookie2.setPath("/");
				response.addCookie(cookie2);
			}
			response.sendRedirect("/index.jsp");
		} catch (IOException | QQConnectException | ParseException e1) {
			e1.printStackTrace();
		}
	}
}
