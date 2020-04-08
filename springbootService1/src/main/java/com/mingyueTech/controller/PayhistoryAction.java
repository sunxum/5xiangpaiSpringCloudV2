package com.mingyueTech.controller;

import com.alipay.api.AlipayApiException;
import com.mingyueTech.entity.Buyhistory;
import com.mingyueTech.service.BuyhistoryBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@Controller
public class PayhistoryAction {
	private BuyhistoryBiz buyhistoryBiz;

	
	@RequestMapping(value = "/getOutTradeNo", method = RequestMethod.POST)
	@ResponseBody
	public String payToCharge(HttpServletRequest request, HttpServletResponse response,Integer id) throws IOException, AlipayApiException {
		String userIdTemp=request.getParameter("uid");
		String totalfeeTemp=request.getParameter("totalfee");
		BigDecimal totalfee=new BigDecimal(totalfeeTemp);

		//商户订单号，商户网站订单系统中唯一订单号，必填
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		String date=df.format(new Date());
		//用户Id
        int userId=Integer.parseInt(userIdTemp);
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(7);
        //设置最小整数位数    
        nf.setMinimumIntegerDigits(7);
        String userIdresult=nf.format(userId);
        //获取最大Id
        int maxid=buyhistoryBiz.getMaxId();
        NumberFormat nf2 = NumberFormat.getInstance();
        //设置是否使用分组
        nf2.setGroupingUsed(false);
        //设置最大整数位数
        nf2.setMaximumIntegerDigits(7);
        //设置最小整数位数    
        nf2.setMinimumIntegerDigits(7);
        String nextId=nf2.format(maxid+1);
		String out_trade_no = date+userIdresult+nextId;
		Buyhistory bh=new Buyhistory();
		bh.setuId(userId);
		bh.setOrderId(out_trade_no);
		bh.setDealmoney(totalfee);
		bh.setBuystatus(0+"");
		bh.setOrderType("充值");
		bh.setCtime(new Date());
		buyhistoryBiz.add(bh);
		return out_trade_no;
	}
}
