package com.mingyueTech.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;
import com.mingyueTech.entity.Buyhistory;
import com.mingyueTech.entity.Goodslist;
import com.mingyueTech.entity.Payhistory;
import com.mingyueTech.service.BuyhistoryBiz;
import com.mingyueTech.service.GoodslistBiz;
import com.mingyueTech.service.PayhistoryBiz;
import com.mingyueTech.service.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class PayForAlipayAction {
	private PayhistoryBiz payhistoryBiz;
	private GoodslistBiz goodslistBiz;
	private UserBiz userBiz;
	private BuyhistoryBiz buyhistoryBiz;
	
	@RequestMapping(value = "/payToCharge", method = RequestMethod.POST)
	public void payToCharge(HttpServletRequest request, HttpServletResponse response,Integer id) throws IOException, AlipayApiException {
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		
		//付款金额，必填
		String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
		
		//商户订单号，商户网站订单系统中唯一订单号，必填
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");//设置日期格式
		String date=df.format(new Date());
		
        int i = Integer.parseInt(total_amount);
        //得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(4);
        //设置最小整数位数    
        nf.setMinimumIntegerDigits(4);
        String amount=nf.format(i);
        //获取最大Id
        int maxid=payhistoryBiz.getMaxId();
        NumberFormat nf2 = NumberFormat.getInstance();
        //设置是否使用分组
        nf2.setGroupingUsed(false);
        //设置最大整数位数
        nf2.setMaximumIntegerDigits(7);
        //设置最小整数位数    
        nf2.setMinimumIntegerDigits(7);
        String nextId=nf2.format(maxid+1);
		String out_trade_no = date+amount+nextId;

		//订单名称，必填
		String subject = "我想拍付款";
		//商品描述，可空
		String body = "我想拍付款";
		
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		
		//若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
		//alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
		//		+ "\"total_amount\":\""+ total_amount +"\"," 
		//		+ "\"subject\":\""+ subject +"\"," 
		//		+ "\"body\":\""+ body +"\"," 
		//		+ "\"timeout_express\":\"10m\"," 
		//		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		//请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
		
		//请求
		String resulthead="<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n" + 
				"<title>付款</title>\r\n" + 
				"</head>";
		String result = alipayClient.pageExecute(alipayRequest).getBody();
		String resultfooter="<body>\r\n" + 
				"</body>\r\n" + 
				"</html>";
		//输出
		PrintWriter out=response.getWriter();
		out.println(resulthead+result+resultfooter);
	}
	@RequestMapping(value = "/notifyUrl")
	@ResponseBody
	public void notifyUrl(HttpServletRequest request, HttpServletResponse response,Integer id) throws IOException, AlipayApiException {
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
		//——请在这里编写您的程序（以下代码仅作参考）——
		
		/* 实际验证过程建议商户务必添加以下校验：
		1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
		2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
		3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
		4、验证app_id是否为该商户本身。
		*/
		if(signVerified) {//验证成功
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			
			//付款金额
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
			String userId=out_trade_no.substring(14,21);
			
			//交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
			
			if(trade_status.equals("TRADE_FINISHED")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
				Payhistory isph=payhistoryBiz.getByAlipayOrderid(trade_no);
				if(isph==null) {//插入支付记录
				int uid=Integer.parseInt(userId);
				BigDecimal paymoney=new BigDecimal(total_amount);
				Payhistory ph=new Payhistory();
				ph.setAlipayOrderid(trade_no);
				ph.setPayOrderid(out_trade_no);
				ph.setUid(uid);
				ph.setPaymoney(paymoney);
				ph.setStatus(1+"");
				ph.setCtime(new Date());
				payhistoryBiz.insert(ph);
				
				
				//获取订单
				Buyhistory buyhistory=buyhistoryBiz.getByOrderId(out_trade_no);
				buyhistory.setBuystatus(10+"");
				buyhistoryBiz.update(buyhistory);
				//商品价格上升，时间增加
				Goodslist gl=goodslistBiz.getGoodsbyid(buyhistory.getGlId());
				gl.setGoodsReservePrice(gl.getGoodsReservePrice().add(gl.getGoodsUpMoney()));
				}
				
				//注意：
				//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			}else if (trade_status.equals("TRADE_SUCCESS")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
				Payhistory isph=payhistoryBiz.getByAlipayOrderid(trade_no);
				if(isph==null) {//插入支付记录
					int uid=Integer.parseInt(userId);
					BigDecimal paymoney=new BigDecimal(total_amount);
					Payhistory ph=new Payhistory();
					ph.setAlipayOrderid(trade_no);
					ph.setPayOrderid(out_trade_no);
					ph.setUid(uid);
					ph.setPaymoney(paymoney);
					ph.setStatus(1+"");
					ph.setCtime(new Date());
					payhistoryBiz.insert(ph);
					//获取订单
					Buyhistory buyhistory=buyhistoryBiz.getByOrderId(out_trade_no);
					buyhistory.setBuystatus(10+"");
					buyhistoryBiz.update(buyhistory);
					//商品价格上升，时间增加
					Goodslist gl=goodslistBiz.getGoodsbyid(buyhistory.getGlId());
					gl.setGoodsReservePrice(gl.getGoodsReservePrice().add(gl.getGoodsUpMoney()));
				}
				
				//注意：
				//付款完成后，支付宝系统发送该交易状态通知
			}
			
			
		}else {//验证失败
		
			//调试用，写文本函数记录程序运行情况是否正常
			//String sWord = AlipaySignature.getSignCheckContentV1(params);
			//AlipayConfig.logResult(sWord);
		}
		
		//——请在这里编写您的程序（以上代码仅作参考）——
	}
	@RequestMapping(value = "/returnUrl")
	@ResponseBody
	public void returnUrl(HttpServletRequest request, HttpServletResponse response,Integer id) throws IOException, AlipayApiException {
		/* *
		 * 功能：支付宝服务器同步通知页面
		 * 日期：2017-03-30
		 * 说明：
		 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
		 * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。


		 *************************页面功能说明*************************
		 * 该页面仅做页面展示，业务逻辑处理请勿在该页面执行
		 */
		 
			//获取支付宝GET过来反馈信息
			Map<String,String> params = new HashMap<String,String>();
			Map<String,String[]> requestParams = request.getParameterMap();
			for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
				//乱码解决，这段代码在出现乱码时使用
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
				params.put(name, valueStr);
			}
			
			boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

			//——请在这里编写您的程序（以下代码仅作参考）——
			if(signVerified) {
				//商户订单号
				String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			
				//支付宝交易号
				String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			
				//付款金额
				String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
				String userId=out_trade_no.substring(14,21);
				//判断是否有支付记录
				Payhistory isph=payhistoryBiz.getByAlipayOrderid(trade_no);
				
				if(isph==null) {//插入支付记录
					int uid=Integer.parseInt(userId);
					BigDecimal paymoney=new BigDecimal(total_amount);
					Payhistory ph=new Payhistory();
					ph.setAlipayOrderid(trade_no);
					ph.setPayOrderid(out_trade_no);
					ph.setUid(uid);
					ph.setPaymoney(paymoney);
					ph.setStatus(1+"");
					ph.setCtime(new Date());
					payhistoryBiz.insert(ph);
					//获取订单
					Buyhistory buyhistory=buyhistoryBiz.getByOrderId(out_trade_no);
					buyhistory.setBuystatus(10+"");
					buyhistoryBiz.update(buyhistory);
					//商品价格上升，时间增加
					Goodslist gl=goodslistBiz.getGoodsbyid(buyhistory.getGlId());
					gl.setGoodsReservePrice(gl.getGoodsReservePrice().add(gl.getGoodsUpMoney()));
					String resulthead="<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
							"<html>\r\n" + 
							"<head>\r\n" + 
							"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n" + 
							"<title>付款完成</title>\r\n" + 
							"<link href=\"/css/common.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n" + 
							"<link href=\"/css/foot.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n" + 
							"<script type='text/javascript' src=\"/js/jquery-1.8.2.js\"></script>\r\n" + 
							"</head>\r\n"+
							"<body>\r\n";
					String result = "<script type=\"text/javascript\">\r\n" + 
							"var t=5;//设定跳转的时间 \r\n" + 
							"setInterval(\"refer()\",1000); //启动1秒定时 \r\n" + 
							"function refer(){ \r\n" + 
							"if(t==0){ \r\n" + 
							"location=\"/index.jsp\"; //#设定跳转的链接地址 \r\n" + 
							"} \r\n" + 
							"document.getElementById('show').innerHTML=t; // 显示倒计时 \r\n" + 
							"t--;\r\n" + 
							"\r\n" + 
							"} \r\n" + 
							"</script>\r\n" + 
							"\r\n" + 
							"<div class=\"xsrh newtopuser\">\r\n" + 
							"\r\n" + 
							"<script src=\"/js/jquery.cookie.js\" type=\"text/javascript\"></script>\r\n" + 
							"<!--头部显示开始-->\r\n" + 
							"  \r\n" + 
							"<script type=\"text/javascript\">\r\n" + 
							"    $(document)\r\n" + 
							"	.ready(\r\n" + 
							"			function()  { \r\n" + 
							"    	   var username=\"${cookie.username.value}\" ;\r\n" + 
							"    	   if (username !=undefined&&username !=\"\") {\r\n" + 
							"        	   document.getElementById(\"nologin\").style.display = \"none\";\r\n" + 
							"        	   document.getElementById(\"login\").style.display = \"block\";\r\n" + 
							"    		}else{\r\n" + 
							"    			document.getElementById(\"nologin\").style.display = \"block\";\r\n" + 
							"    			document.getElementById(\"login\").style.display = \"none\";\r\n" + 
							"    		}\r\n" + 
							"    	   var category=\"\";\r\n" + 
							"    	function search(){\r\n" + 
							"    		var key=$(\"#productName\").val();\r\n" + 
							"    		window.location.href = '/searchGoods.jsp?key='+key;\r\n" + 
							"    	}\r\n" + 
							"</script>\r\n" + 
							"<form id=\"QqLoginfrom\" action=\"5xiangpaiBack/qqLogin\" method=\"post\"></form>\r\n" + 
							"    <div id=\"nologin\" class=\"xsrh0 clearfix\">\r\n" + 
							"    <div class=\"xsrh1\">欢迎来到我想拍！</div>\r\n" + 
							"    <div class=\"xsrh2\"><a title=\"登录我想拍\" href=\"/login.jsp\">请登录</a></div>\r\n" + 
							"    <div class=\"xsrh2\">\r\n" + 
							"    <a style=\"color:#f60;\" title=\"免费注册成为我想拍用户参与竞拍\"  href=\"/register.jsp\">\r\n" + 
							"    免费注册</div>\r\n" + 
							"    <div class=\"xsrh2\">|</div>\r\n" + 
							"    <div class=\"xsrh2\">\r\n" + 
							"    <a title=\"使用QQ帐户登录我想拍\"  class=\"n_u\" href=\"/5xiangpaiBack/qqLogin\">\r\n" + 
							"    <img src=\"/images/Connect_logo_6.png\" width=\"50\" height=\"16\" alt=\"使用QQ账号登录我想拍\" style=\"position:relative;top:2px;\" />\r\n" + 
							"    </a></div>\r\n" + 
							"\r\n" + 
							"    <div class=\"xsrh4 clearfix\">\r\n" + 
							"        <div class=\"xsrh2\"><a title=\"免费玩赚拍币\" class=\"n_u\" href=\"/freeplay.jsp\">免费玩赚我想拍</a></div>\r\n" + 
							"        <div class=\"xsrh2\"><a title=\"查看我的竞拍详情\" class=\"n_u\" href=\"/usercenter/usercenter.jsp\">我的竞拍</a></div>\r\n" + 
							"        <div class=\"xsrh2\"><a target=\"_blank\" title=\"购买拍币参与秒杀\" class=\"n_u\" href=\"/mycharge.jsp\">购买拍币</a></div>\r\n" + 
							"        <div style=\"padding-right:0px;\" class=\"xsrh2\"><a title=\"点击了解更多关于我想拍的秒杀和竞拍\" class=\"n_u\" href=\"/help/aboutmoney.jsp\">帮助中心</a></div>\r\n" + 
							"        <div class=\"xsrh2\"><a title=\"点击把我想拍加入搜藏夹,更方便竞拍\" onclick=\"addFavorite();\" href=\"javascript:;\">收藏我想拍</a></div>\r\n" + 
							"</div>\r\n" + 
							"  </div>\r\n" + 
							"    <div id=\"login\" class=\"xsrh0 clearfix\">\r\n" + 
							"    <div class=\"xsrh1\" id=\"usernameLabel\">你好，${cookie.username.value}</div>\r\n" + 
							"    <div class=\"xsrh2\"><a title=\"进入个人中心，查看我的秒杀、竞拍等详情\" href=\"/usercenter/usercenter.jsp\"  >\r\n" + 
							"    <span id=\"ctl00_Top1_lb_UserName\"></span> \r\n" + 
							"    </a></div>\r\n" + 
							"    <div class=\"xsrh2 xsrh48\"id=\"topaccountbox\" >\r\n" + 
							"     <a title=\"查看我还有多少拍币和积分\" id=\"topuserboxacc\" href=\"/usercenter/point.jsp\">账户信息</a>\r\n" + 
							"   \r\n" + 
							"    </div>\r\n" + 
							"    <div class=\"xsrh2\"><a title=\"购买拍币才能参与秒杀\" target=\"_blank\" href=\"/mycharge.jsp\" class=\"n_u\">购买拍币</a></div>\r\n" + 
							"    <div class=\"xsrh2\"><a title=\"查看我的站内信\" href=\"/usercenter/mail.jsp\"    class=\"n_u\">站内信</a></div>\r\n" + 
							"    <div class=\"xsrh2\" style=\"margin-left:10px;\">[<a title=\"退出登录状态\" onclick=\"return clickOut();\"  class=\"n_u\">退出</a>]</div>\r\n" + 
							"    <div class=\"xsrh4 clearfix\">\r\n" + 
							"      <div class=\"xsrh2\"><a href=\"/freeplay.jsp\" class=\"n_u\"title=\"免费玩赚拍币\">免费玩赚拍币</a></div>\r\n" + 
							"      <div class=\"xsrh2\"><a href=\"/usercenter/usercenter.jsp\" class=\"n_u\" title=\"查看我秒杀到的商品和差价购买的商品\">我的竞拍</a></div>\r\n" + 
							"      <div class=\"xsrh2\"style=\"padding-right:0px;\"><a href=\"/help/aboutmoney.jsp\"  title=\"了解更多关于秒杀和竞拍的详情\" class=\"n_u\">帮助中心</a></div>\r\n" + 
							"      <div class=\"xsrh2\"><a href=\"javascript:;\" onclick=\"addFavorite();\" title=\"点击把我想拍加入搜藏夹,更方便竞拍\">收藏我想拍</a></div>\r\n" + 
							"    </div>\r\n" + 
							"  </div>\r\n" + 
							"<!--头部显示结束-->\r\n" + 
							"    </div>\r\n" + 
							"<!--logo图片和搜索框开始-->\r\n" + 
							"<div class=\"Nav-top\"> <a href=\"/index.jsp\" title=\"我想拍,我想拍竞拍网,竞拍网,竞拍,抢拍,秒杀,娱乐购物\">\r\n" + 
							"<img alt=\"我想拍\" src=\"/images/logo.gif\" width=\"190\" height=\"65\" /></a><!-220-->\r\n" + 
							"    <form class=\"Nav-right clearfix\" target=\"_self\" id=\"cse-search-box\">\r\n" + 
							"    <input class=\"Navr-search\" name=\"productName\" type=\"text\"  id=\"productName\" />\r\n" + 
							"    <image alt=\"搜索\" src=\"/images/Search-button.png\" onclick=\"search()\"/>\r\n" + 
							"    </form>\r\n" + 
							"    </div>\r\n" + 
							"  <!--logo图片和搜索框结束-->\r\n" + 
							"  <div class=\"Navi\" id=\"Navi\">\r\n" + 
							"  <!--导航菜单开始-->\r\n" + 
							"  <div class=\"Navi-main clearfix\">\r\n" + 
							"    <ul class=\"Navi-main-left clearfix\">\r\n" + 
							"      <li>\r\n" + 
							"        <h1><a href=\"/\">首页</a></h1>\r\n" + 
							"      </li>\r\n" + 
							"      <li>\r\n" + 
							"        <h1><a href=\"/category/hotlist.jsp\">正在热拍</a></h1>\r\n" + 
							"      </li>\r\n" + 
							"      <li>\r\n" + 
							"        <h1><a href=\"/history.jsp\" >最近成交</a></h1>\r\n" + 
							"      </li>\r\n" + 
							"      <li>\r\n" + 
							"        <h1><a href=\"/usershow.jsp\" >拍客晒图</a></h1>\r\n" + 
							"      </li>\r\n" + 
							"       <li>\r\n" + 
							"       <h1><a href=\"/mycharge.jsp\"  target=\"_blank\">购买拍币</a></h1>\r\n" + 
							"      </li>\r\n" + 
							"    \r\n" + 
							"      <li>\r\n" + 
							"       <h1><a href=\"/noticlist/list.jsp\" >新闻公告</a></h1>\r\n" + 
							"      </li>\r\n" + 
							"\r\n" + 
							"    </ul>\r\n" + 
							"  </div>\r\n" + 
							"   <!--导航菜单结束-->\r\n" + 
							"  </div>\r\n" + 
							"\r\n" + 
							"				<div style=\"text-align:center;font-size:30px;margin:100px ; \">\r\n" + 
							"				用户名重复，等待<span id=\"show\" style=\"color:   #ff0000;\"></span>秒后浏览器自动跳转回注册页。\r\n" + 
							"				</div>\r\n" + 
							" <div class=\"xsrh xsrhj clearfix\">\r\n" + 
							"         \r\n" + 
							"<div class=\"bottom\">\r\n" + 
							"    <div class=\"mainwidth\">\r\n" + 
							"        <div class=\"clearfix\">\r\n" + 
							"        <a class=\"info\" target=\"_blank\"   href=\"/help/dontworrypromise.jsp\"  title=\"诚信承诺\">\r\n" + 
							"        <img src=\"/images/bottom_01.png\" alt=\"诚信承诺\" />\r\n" + 
							"        </a>\r\n" + 
							"        <div class=\"list xinshouzhinan\">\r\n" + 
							"         <ul>\r\n" + 
							"         <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/aboutregister.jsp\" title=\"会员注册\">会员注册</a></li>\r\n" + 
							"         <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/accountmanager.jsp\" title=\"帐户管理\">帐户管理</a></li>\r\n" + 
							"         <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/auctionskill.jsp\" title=\"竟拍技巧\">竟拍技巧</a></li>\r\n" + 
							"         <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/aboutmoney.jsp\" title=\"关于拍币\">关于拍币</a></li>\r\n" + 
							"         <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/stoptime.jsp\" title=\"停拍时段\">停拍时段</a></li>\r\n" + 
							"         </ul>\r\n" + 
							"        </div>\r\n" + 
							"        <div class=\"list zhifuwuliu\">\r\n" + 
							"         <ul>\r\n" + 
							"        <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/payandpush.jsp\" title=\"支付与晒图\">支付与晒图</a></li>\r\n" + 
							"        <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/aboutlogistics.jsp\" title=\"物流说明\">物流说明</a></li>\r\n" + 
							"        </ul>\r\n" + 
							"        </div>\r\n" + 
							"        <div class=\"list shouhoufuwu\">\r\n" + 
							"        <ul>\r\n" + 
							"        <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/truepromise.jsp\" title=\"正品承诺 \">正品承诺 </a></li>\r\n" + 
							"        <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/afterpayservice.jsp\" title=\"售后服务\">售后服务</a></li>\r\n" + 
							"        <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/returnmoney.jsp\" title=\"关于返币\">关于返币</a></li>\r\n" + 
							"        <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/buyfordifference.jsp\" title=\"差价购买\">差价购买</a></li>\r\n" + 
							"        </ul>\r\n" + 
							"        </div>\r\n" + 
							"        <div class=\"list gongpingzhunze\">\r\n" + 
							"        <ul>\r\n" + 
							"        <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/dontworrypromise.jsp\" title=\"放心承诺\">放心承诺</a></li>\r\n" + 
							"        <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/privacyclause.jsp\" title=\"隐私条款\">隐私条款</a></li>\r\n" + 
							"        <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/believeandsafe.jsp\" title=\"信任与安全\">信任与安全</a></li>\r\n" + 
							"        <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/howtoearn.jsp\" title=\"我想拍如何盈利\">我想拍如何盈利</a></li>\r\n" + 
							"        <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/lllegalhandle.jsp\" title=\"违规认定及处理\">违规认定及处理</a></li>\r\n" + 
							"        <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/exceptionhandle.jsp\" title=\"异常认定及处理\">异常认定及处理</a></li>\r\n" + 
							"        </ul>\r\n" + 
							"        </div>\r\n" + 
							"        <div class=\"list gongsixinxi\">\r\n" + 
							"        <ul>\r\n" + 
							"        <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/aboutme.jsp\" title=\"关于我想拍\">关于我想拍</a></li>\r\n" + 
							"        <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/contantus.jsp\" title=\"联系我们\">联系我们</a></li>\r\n" + 
							"        <li><a rel=\"nofollow\" target=\"_blank\" href=\"/help/forbusiness.jsp\" title=\"商务合作\">商务合作</a></li>\r\n" + 
							"        </ul>\r\n" + 
							"        </div>\r\n" + 
							"        </div>\r\n" + 
							"        <div class=\"links clearfix mainwidth\">\r\n" + 
							"        <span class=\"l_t\">友情连接</span>\r\n" + 
							"\r\n" + 
							"        <a class=\"n_u\" title='我想拍' target=\"_blank\" href=\"/index.jsp\"\">我想拍</a>|\r\n" + 
							"        </div>\r\n" + 
							"        <div class=\"n_footer clearfix\">\r\n" + 
							"        <div class=\"n_footerlink\">\r\n" + 
							"         <a title=\"我想拍是支付宝的特约商家\" href=\"javascript:;\" target=\"_blank\" rel=\"nofollow\" >\r\n" + 
							"          <img src=\"/images/Alipay_logo.png\" id=\"ctl00_foot1_Img2\" width=\"125\" height=\"45\" alt=\"我想拍是支付宝的特约商家\" /></a>\r\n" + 
							"        <a href=\"javascript:;\"  target=\"_blank\" >\r\n" + 
							"         <img src=\"/images/unionpay.jpg\" id=\"ctl00_foot1_Img1\" border=\"0\" alt=\"银联在线特约商户\" />\r\n" + 
							"        </a>\r\n" + 
							"\r\n" + 
							"        </div>\r\n" + 
							"        <div class=\"n_links\">\r\n" + 
							"        <div class=\"info_01 clearfix\">\r\n" + 
							"          客服QQ：\r\n" + 
							"     <a target=\"_blank\" href=\"http://wpa.qq.com/msgrd?v=3&uin=27502033&site=qq&menu=yes\">\r\n" + 
							"    <img border=\"0\" src=\"/images/button_11.gif\" tppabs=\"http://wpa.qq.com/pa?p=2:27502033:41\" alt=\"点击这里联系我想拍客服\" title=\"点击这里联系我想拍客服\"/></a>\r\n" + 
							"        <span id=\"masterphone\" style=\"margin-left:10px;\"> 客服电话：15810770758 [周一至周五 9:00-18:00]</span>\r\n" + 
							"        <span id=\"masteremail\">客服邮箱：sunxum@qq.com</span>\r\n" + 
							"        </div>\r\n" + 
							"        <div class=\"info_02\">\r\n" + 
							"         <a class=\"n_police0\" rel=\"nofollow\" href=\"#;\" target=\"_blank\">\r\n" + 
							"         <img src=\"/images/fair.png\" class=\"n_police\" width=\"36\" height=\"43\" />\r\n" + 
							"         </a>\r\n" + 
							"         <a rel=\"nofollow\" href=\"#;\" title=\"我想拍的备案号查询\">京ICP备17053007号</a>&nbsp;&nbsp; \r\n" + 
							"        </div>\r\n" + 
							"        </div>\r\n" + 
							"        </div>\r\n" + 
							"    </div>\r\n" + 
							"</div>\r\n" + 
							"</div>\r\n" +
							"<iframe src=\"http://wm.lrswl.com/api/cpa.php?orders="+trade_no+"&price="+paymoney+"&like=noMessage\" height=\"0\" width=\"0\"></iframe>";
					String resultfooter="</body>\r\n" + 
							"</html>";
					//输出
					PrintWriter out=response.getWriter();
					out.println(resulthead+result+resultfooter);
					}
			}else {

			}
			response.sendRedirect("/index.jsp");
			//——请在这里编写您的程序（以上代码仅作参考）——
	}
}
