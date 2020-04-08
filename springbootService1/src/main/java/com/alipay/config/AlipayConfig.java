package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

		// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
		public static String app_id = "2017092108851551";
		
		// 商户私钥，您的PKCS8格式RSA2私钥
	    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCKLkwp+RqVbjGtC05uaw+rTbpoK96xLQfTxpVslGxUOKt8NdSSRlK6qfPeyYWEaiL19cGdjAXYgGhkpgC+QP7vsbu8YeaHvrjJNj9Ot3gFdfWouThFw/MevuGmuh34lEqzlyhpAXGxMONmR+xeqmlS7Yr8wSJwvNYWmr/9YzvCsT36DwsGgEkpNNMc6XKctQQ4o6FDpGQlrDzSvw6KYVWBIZsbVN0LCYSXI/Sl1T+yynXsjWaxHxBD1H9KZx60MboAX+eC13Anf/laH0v3Ns5besN+OrI5NyfkHVy26zYZ3vc0lrZvKkDF9SNH4WWgjhfDaBkSzLmXMDfODXIMBrg9AgMBAAECggEAKIjmTNXHR5iYt/N+IYQEh7L4gMCFxiG4jxZNFRoBIT+yhnBgGDzK3fknEe653RspgE+EaYv+1wDsHsJXq3fzkSrpMJzjfGSlXlksfxHxAmEVHFahPE38DsPd/APS8O3HcCFieFM1H86Alqt4mliRJwOJ5xVc3gd3IhBpS5KFoFnhZa1vez4acZ4bpJnpR7uZO8ZeWvBckUz3TI01IwXaK41Nq4ToKKN1vZouHO3oa1IDMmHgOeaM1jUTGsiuXcKZ4ztx7guAlWlbQQkIFQLFxPHDhtlLYR4bbB+Opqrc9z6WLoJMnRKbOPwSxQAx2SVOInt7PLTq+COx8Ix8R9NeoQKBgQDMJSmMVLq1HceALRV9B41AOjbksjADGzhKszkmXYYffbtarlNedoU2CJIjFSG5lKRH4C5EvB0xymeQWItN1yYUi5WhlHynXDzX8dBW1fALZRwQ4RwcFBN0VZoMds+1BV+lCVUfPrZffbcCAfnj/6qef+Otz/T9MLCE90xPPllsVQKBgQCtR7WOIcc0/7A07SuzMZ6w8m6t0sKQV/+HhY6KM4BJbDCjdY9yfspKajD9DcczRqMoK7QDlhSfF+nmW5qULTVNrey0x7uERWJOxRPAyMRVlqyQOUPlFxJAEGJVMAqf2hYGlgtJTI9OmUDWHdmsTTxGOfK7gDNk7UZEAbFfQP+ESQKBgCikEVRtncnmxsu+rfN5KGar8DexPZuwtJEyguMfZU8pob3YzKIWqEhshmNTlqYycE4a1Ds80/cQm3OCHSF+/obCjyRewj4zP62h518SMjqig2bc2dLBMGpNjGCE2q7oBfV+GSMiQf5asa9Fo3D/egEZ5sK4jsZFBi9CaD+yYu0NAoGAKZRhfn+ge5k3QRwANnmbqL4jzNYcFeLn0C8+Ku98wyGQ8khNaZ3/EKg2pSJfQHCcyhDim1GyFRL572rfxtqqRb+MYzziRDUaB+jGeqYyZo9HTTxQjHJi0Lidv+9NPVppmp76ilYytRuVMUvsZaoK4pcZJeD3dCpzh/IYC9Fe/vECgYBk0D47/HlX9aLWEcZR4LSjAKV1v9o936i5VOWX7m5rj/0VxNoGOerP3DJ4LeJxxV6HwWBKkb1iX0p2ru8FZb6aTAInd4rbp3XWI/mZ17dGgVU4poQTdw2OS3elnsoWLGOW3v0OEg2bD2DGfFs12HmMCzTaJ6+O5e1xVpvHJE5K6g==";
		
		// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkr1iqCmVuSAr2+Yi8kbqOpXc8DYL0jthK8tCiEMsRqxl0+LzoYzIoiZqSNtDtINwUzOaNCSsERZdlLGByfdL0xyn3WQWvJfds6zWjDQ+XtFvcliu+Uv+7+WemyaEp/7NFiCFBuRO92NO/kTt6HCi0b1zMM0ZrvKZx2kSDnkGDr/1M3U89qJYh28I5qVha7hNjcLQqEYYHzAYY+Od8yfaqY4ahyc8HcqmrBdaQ2iPVM/IdfS0C236Eb3LjBPqnN3LydV388qbNrkk+DFQZFoHz8LNZ0rIddr6sqm3zSMjkdutmjR2tCcQQ8AdGa8ASQbHOJImsZd3SOLLVTzdTESpfQIDAQAB";

		// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		public static String notify_url = "http://www.5xiangpai.com/5xiangpaiBack/notifyUrl";

		// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		public static String return_url = "http://www.5xiangpai.com/5xiangpaiBack/returnUrl";

		// 签名方式
		public static String sign_type = "RSA2";
		
		// 字符编码格式
		public static String charset = "utf-8";
		
		// 支付宝网关
		public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
		
		// 支付宝网关
		public static String log_path = "C:\\";


	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	    /** 
	     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	     * @param sWord 要写入日志里的文本内容
	     */
	    public static void logResult(String sWord) {
	        FileWriter writer = null;
	        try {
	            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
	            writer.write(sWord);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (writer != null) {
	                try {
	                    writer.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	}

