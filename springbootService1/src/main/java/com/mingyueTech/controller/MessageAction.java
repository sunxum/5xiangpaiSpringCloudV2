package com.mingyueTech.controller;

import com.mingyueTech.entity.Message;
import com.mingyueTech.entity.User;
import com.mingyueTech.service.MessageBiz;
import com.mingyueTech.service.UserBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
public class MessageAction {
	private MessageBiz messageBiz;
	private UserBiz userBiz;
	
	@RequestMapping(value = "/messagetoadd", method = RequestMethod.POST)
	@ResponseBody
	public String messagetoadd(HttpServletRequest request, HttpServletResponse response) {
		String ids = request.getParameter("id");
		String fids = request.getParameter("fid");
		String fromUsername=request.getParameter("fromUsername");
		String toUsername=request.getParameter("toUsername");
		String messagecontent=request.getParameter("messagecontent");
		String messagetitle=request.getParameter("messagetitle");
		User fromuser=userBiz.getbyusername(fromUsername);
		User touser=userBiz.getbyusername(toUsername);
				if(null==touser&&null==fids) {
					return "发送失败,请检查收件人是否存在";
				}
				if(null==fids&&fromuser.getUserId().equals(touser.getUserId())) {
					return "不能给自己发信";
				}
				if(null==ids||"".equals(ids)) {
					Message	message=new Message();
					if(!(null==fids||"".equals(fids))) {
						int fid=Integer.parseInt(fids);
						Message messageTemp=messageBiz.getbyId(fid);
						message.setFromUsername(messageTemp.getToUsername());
						message.setToUsername(messageTemp.getFromUsername());
						message.setFid(fid);
						message.setTitle(messagetitle);
						message.setMessage(messagecontent);
						message.setCtime(new Date());
						messageBiz.add(message);
						return "回复成功";
					}else {
						message.setFromUsername(fromUsername);
						message.setToUsername(toUsername);
						message.setTitle(messagetitle);
						message.setMessage(messagecontent);
						message.setCtime(new Date());
						messageBiz.add(message);
						return "发送成功";
					}

		}else {
			Message	message=new Message();
			message.setId(Integer.parseInt(ids));
			message.setFromUsername(fromUsername);
			message.setToUsername(toUsername);
			message.setTitle(messagetitle);
			message.setMessage(messagecontent);
			message.setCtime(new Date());
			messageBiz.update(message);
			return "修改信息成功";
		}
	}
	
	@RequestMapping(value = "/loadmessage", method = RequestMethod.POST)
	@ResponseBody
	public List<Message> loadmessage(HttpServletRequest request, HttpServletResponse response,String username) {
		List<Message> list=messageBiz.getbyUsername(username);
		return list;

	}
	@RequestMapping(value = "/messagedescription")
	@ResponseBody
	public Message messagedescription(HttpServletRequest request, HttpServletResponse response,Integer nid) {
		Message message=messageBiz.selectByPrimaryKey(nid);
		return message;
	}
	@RequestMapping(value = "/loadmessagefromuser", method = RequestMethod.POST)
	@ResponseBody
	public List<Message> loadmessagefromuser(HttpServletRequest request, HttpServletResponse response,String username) {
		List<Message> list=messageBiz.getbyfromUsername(username);
		return list;
	}
	
	@RequestMapping(value = "/loadmessageforuser", method = RequestMethod.POST)
	@ResponseBody
	public List<Message> loadmessageforuser(HttpServletRequest request, HttpServletResponse response,String username) {
		List<Message> list=messageBiz.getbyfromUsername(username);
		//读fromuser
		
		return list;

	}
	@RequestMapping(value = "/getAllMessage", method = RequestMethod.POST)
	@ResponseBody
	public List<Message> getAllMessage(HttpServletRequest request, HttpServletResponse response,String username) {
		List<Message> list=messageBiz.getall();
		return list;

	}
	@RequestMapping(value = "/deleteMessage", method = RequestMethod.POST)
	@ResponseBody
	public String deleteMessage(HttpServletRequest request, HttpServletResponse response,String username) {
		String ids = request.getParameter("id");
		messageBiz.delete(Integer.parseInt(ids));
		return "删除信息成功";

	}
	@RequestMapping(value = "/loadmessageByFid", method = RequestMethod.POST)
	@ResponseBody
	public List<Message> loadmessageByFid(HttpServletRequest request, HttpServletResponse response,String username) {
		String fids = request.getParameter("fid");
		List<Message> messageList=messageBiz.getbyfId(Integer.parseInt(fids));
		return messageList;

	}
	
	
}
