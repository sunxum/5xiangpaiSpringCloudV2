package com.alipay.config;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class TradeQuery {
	public String query(HttpServletRequest request, HttpServletResponse response) {
		// 获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type);

		// 设置请求参数
		AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();

		// 商户订单号，商户网站订单系统中唯一订单号
		String out_trade_no = null;
		String trade_no = null;
		String result=null;
		try {
			out_trade_no = new String(request.getParameter("WIDTQout_trade_no").getBytes("ISO-8859-1"), "UTF-8");

		// 支付宝交易号
		trade_no = new String(request.getParameter("WIDTQtrade_no").getBytes("ISO-8859-1"), "UTF-8");
		// 请二选一设置

		alipayRequest
				.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"trade_no\":\"" + trade_no + "\"}");

		// 请求

			result = alipayClient.execute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			e.printStackTrace();
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 输出
		return result;
	}
}
