package com.mingyueTech.controller;

import com.mingyueTech.entity.*;
import com.mingyueTech.service.BuyhistoryBiz;
import com.mingyueTech.service.CoinchangeBiz;
import com.mingyueTech.service.PublicpicBiz;
import com.mingyueTech.service.UserBiz;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
public class PublicpicAction {
	@Qualifier("userBiz")
	private UserBiz userBiz;
	@Qualifier("publicpicBiz")
	private PublicpicBiz publicpicBiz;
	private CoinchangeBiz coinchangeBiz;
	private BuyhistoryBiz buyhistoryBiz;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/loadpubpic", method = RequestMethod.POST)
	@ResponseBody
	public List<PublicPicVo> loadpubpic(HttpServletRequest request, HttpServletResponse response) {
		List<PublicPicVo> list = publicpicBiz.getpublicList();
		return list;
	}

	@RequestMapping(value = "/loadpubpicAll", method = RequestMethod.POST)
	@ResponseBody
	public List<PublicPicVo> loadpubpicAll(HttpServletRequest request, HttpServletResponse response) {
		List<PublicPicVo> list = publicpicBiz.getpublicListAll();
		return list;
	}

	@RequestMapping(value = "/publicpictoadd", method = RequestMethod.POST)
	@ResponseBody
	public void publicpictoadd(HttpServletRequest request, HttpServletResponse response, Publicpic item) {
		item.setCtime(new Date());
		publicpicBiz.addpublicpic(item);
		Buyhistory buyhistory = buyhistoryBiz.getbyid(item.getbId());
		// 修改buyhistory状态
		buyhistory.setBuystatus(40 + "");
		buyhistoryBiz.update(buyhistory);
		User user = userBiz.getbyid(buyhistory.getuId());

		// 发布送freecoin
		user.setFreecoin(user.getFreecoin() + 3000);
		userBiz.update(user);

		// coinchange
		Coinchange coinchange = new Coinchange();
		coinchange.setuId(buyhistory.getuId());
		coinchange.setPaycoin(0);
		coinchange.setPractivicoin(0);
		coinchange.setFreecoin(3000);
		coinchange.setDescription("晒图赚取积分");
		coinchange.setCtime(new Date());
		coinchangeBiz.insert(coinchange);
	}

	@RequestMapping(value = "/addPublicPic", method = RequestMethod.POST)
	@ResponseBody
	public void addPublicPic(HttpServletRequest request, HttpServletResponse response, Publicpic item) {
		String id = request.getParameter("id");
		if (null == id||"".equals(id)) {
			item.setCtime(new Date());
			publicpicBiz.addpublicpic(item);
		} else {
			publicpicBiz.update(item);
		}

	}

	@RequestMapping(value = "/publicpicdescription", method = RequestMethod.POST)
	@ResponseBody
	public Publicpic publicpicdescription(HttpServletRequest request, HttpServletResponse response, Integer id) {
		return publicpicBiz.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/uploadImgone")
	@ResponseBody
	public String uploadone(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {

		String path = request.getSession().getServletContext().getRealPath("upload/publicpic");
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

		return "/upload/publicpic/" + fileNewName;
	}

	@RequestMapping(value = "/uploadImgtwo")
	@ResponseBody
	public String uploadtwo(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {

		String path = request.getSession().getServletContext().getRealPath("upload/publicpic");
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

		return "/upload/publicpic/" + fileNewName;
	}

	@RequestMapping(value = "/uploadImgthree")
	@ResponseBody
	public String uploadthree(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request) {

		String path = request.getSession().getServletContext().getRealPath("upload/publicpic");
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

		return "/upload/publicpic/" + fileNewName;
	}

	@RequestMapping(value = "/loadpubpicbypid", method = RequestMethod.POST)
	@ResponseBody
	public PublicPicVo publicpicbypid(HttpServletRequest request, HttpServletResponse response, Integer pid) {
		return publicpicBiz.getpublicpicbypid(pid);
	}

	@RequestMapping(value = "/getPublicPicFour", method = RequestMethod.POST)
	@ResponseBody
	public List<PublicPicVo> getPublicPicFour(HttpServletRequest request, HttpServletResponse response) {
		List<PublicPicVo> list = publicpicBiz.getpublicListFour();
		return list;
	}

	@RequestMapping(value = "/deletePublicPic", method = RequestMethod.POST)
	@ResponseBody
	public void deletePublicPic(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		publicpicBiz.deletePublicPic(id);
	}

	@RequestMapping(value = "/editPublicPic", method = RequestMethod.POST)
	@ResponseBody
	public Publicpic editPublicPic(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Publicpic publicPic = publicpicBiz.getPublicyId(id);
		return publicPic;
	}

}
