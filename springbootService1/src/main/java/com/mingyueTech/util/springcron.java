package com.mingyueTech.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;    
import org.springframework.stereotype.Component;

import com.mingyueTech.service.BidBiz;
import com.mingyueTech.service.BuyhistoryBiz;
import com.mingyueTech.service.GoodslistBiz;
import com.mingyueTech.service.UserBiz;

@Component
public class springcron {

	
	@Autowired
	@Qualifier("goodslistBiz")
	private GoodslistBiz goodslistBiz;
	
	@Autowired
	@Qualifier("userBiz")
	private UserBiz userBiz;
	
	@Autowired
	@Qualifier("bidBiz")
	private BidBiz bidBiz;
	
	@Autowired
	@Qualifier("buyhistoryBiz")
	private BuyhistoryBiz buyhistoryBiz;
	
	
	
	@Scheduled(cron = "* * * * * ? ")
    public void job1() {
		try {
			//goodslistBiz.refrshGoods();
			
//			List<Goods> goodsset=goodsBiz.getgoodszero();
//			for(Goods goods:goodsset) {
//			Goodslist goodslistone=goodslistBiz.getGoodsbyid(goods.getGlId());
//			String lessBiduserstatus = userBiz.getlessBiduserStatus(goods.getGoodsId());
//			Integer lessBidUserId=userBiz.getlessBiduserId(goods.getGoodsId());
//			List<Integer> userIdList =bidBiz.getRealbidnum(goods.getGoodsId());
//			
//			//TODO:算法得变
//			BigDecimal tempnormal=goods.getLessMoney().multiply(new BigDecimal(0).multiply(goodslistone.getGoodsDownMoney()).multiply( new BigDecimal(3).divide(new BigDecimal(2), 2, RoundingMode.HALF_UP)));
//			Boolean condition=goodslistone.getGoodsPrice().compareTo(tempnormal) <0;
//			if (("admin".equals(lessBiduserstatus) && condition)) {
//				// 写入buyhistory
//				// Integer userID=bidBiz.getlessBiduser(item.getGoodsId());
//				User user = userBiz.getbyusername(goods.getLessBidusername());
//				
//				//生成订单ID----开始
//				//商户订单号，商户网站订单系统中唯一订单号，必填
//				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
//				String date=df.format(new Date());
//				//用户Id
//		        NumberFormat nf = NumberFormat.getInstance();
//		        //设置是否使用分组
//		        nf.setGroupingUsed(false);
//		        //设置最大整数位数
//		        nf.setMaximumIntegerDigits(7);
//		        //设置最小整数位数    
//		        nf.setMinimumIntegerDigits(7);
//		        String userIdresult=nf.format(user.getUserId());
//		        //获取最大Id
//		        int maxid=buyhistoryBiz.getMaxId();
//		        NumberFormat nf2 = NumberFormat.getInstance();
//		        //设置是否使用分组
//		        nf2.setGroupingUsed(false);
//		        //设置最大整数位数
//		        nf2.setMaximumIntegerDigits(7);
//		        //设置最小整数位数    
//		        nf2.setMinimumIntegerDigits(7);
//		        String nextId=nf2.format(maxid+1);
//				String orderId = date+userIdresult+nextId;
//				//生成订单Id----结束
//				
//				Buyhistory bh = new Buyhistory();
//				bh.setOrderId(orderId);
//				bh.setgId(goods.getGoodsId());
//				bh.setuId(user.getUserId());
//				bh.setDealmoney(goods.getLessMoney());
//				bh.setAlreadyPay(new BigDecimal(0));
//				bh.setNeedMoney(goods.getLessMoney());
//				bh.setCtime(new Date());
//				buyhistoryBiz.add(bh);
//				//置状态位展示
//				goods.setGoodsStatus(2);
//				goods.setDealtime(new Date());
//				goodsBiz.update(goods);
//
//				// 添加新goods
//				goods.setGoodsId(null);
//					goods.setGlId(goods.getGlId());
//					goods.setCtime(new Date());
//					goods.setGoodsStatus(1);
//					goods.setLessUid(2);
//					goods.setLessBidusername("admin");
//					goods.setLessMoney(new BigDecimal(0.00));
//					goods.setLessSecond(4*60*60);
//					goodsBiz.addGoods(goods);
//				
//				
//			}else if (userIdList.contains(lessBidUserId)) {
//				// 写入buyhistory
//				// Integer userID=bidBiz.getlessBiduser(item.getGoodsId());
//				User user = userBiz.getbyusername(goods.getLessBidusername());
//				Buyhistory bh = new Buyhistory();
//				bh.setgId(goods.getGoodsId());
//				bh.setuId(user.getUserId());
//				bh.setDealmoney(goods.getLessMoney());
//				bh.setCtime(new Date());
//				buyhistoryBiz.add(bh);
//				//置状态位展示
//				goods.setGoodsStatus(2);
//				goods.setDealtime(new Date());
//				goodsBiz.update(goods);
//					// 新建goods，goodslist里的goodsnum-1
//					if (goodslistone.getGoodsNum() > 0) {
//						goodslistone.setGoodsNum(goodslistone.getGoodsNum() - 1);
//						// 添加新goods
//						goods.setGoodsId(null);
//						goods.setGlId(goods.getGlId());
//						goods.setCtime(new Date());
//						goods.setGoodsStatus(1);
//						goods.setLessUid(2);
//						goods.setLessBidusername("admin");
//						goods.setLessMoney(new BigDecimal(0.00));
//						goods.setLessSecond(4*60*60);
//						goodsBiz.addGoods(goods);
//					} else {
//						goodslistone.setGoodsStatus(0);
//						
//					}
//					goodslistBiz.update(goodslistone);
//					
//				
//			}  else {
//				User user = null;
//				do {
//					user = userBiz.getrandomCuser();
//				}while(goods.getLessBidusername().equals(user.getUserName()));
//				goods.setLessUid(user.getUserId());
//				goods.setLessBidusername(user.getUserName());
//				goods.setLessSecond(goods.getLessSecond() + 10);
//				
//				BigDecimal bidprice = goods.getLessMoney().add(goodslistone.getGoodsDownMoney());
//				goods.setLessMoney(bidprice);
//				goodsBiz.update(goods);
//				Bid biditem = new Bid();
//				biditem.setGoodsId(goods.getGoodsId());
//				biditem.setBuyerId(user.getUserId());
//				if (goods.getLessMoney() == null) {
//					goods.setLessMoney(new BigDecimal(0));
//				}
//				biditem.setBidPrice(bidprice);
//				biditem.setBidTime(new Date());
//				bidBiz.addBiz(biditem);
//			}
//			
//			}
//			goodsBiz.refrshGoodsStatus();
    	}catch (Exception e) {
    		System.out.println(e);
    	} 
    }  
	
//	@Scheduled(cron = "* * 1 * * ? ")
//    public void job2() {
//		try {
//			List<Goodslist> goodslistlist=goodslistBiz.getAllCanSale();
//			Goods goods=null;
//			for(Goodslist goodslistone : goodslistlist) {
//				goods=goodsBiz.getOnSaleGoodsBybhid(goodslistone.getGlId());
//				if(null==goods) {
//					goods=new Goods();
//					goods.setGlId(goodslistone.getGlId());
//					goods.setCtime(new Date());
//					goods.setGoodsStatus(1);
//					goods.setLessUid(2);
//					goods.setLessBidusername("admin");
//					goods.setLessMoney(new BigDecimal(0));
//					goods.setLessSecond(10000);
//					goodsBiz.addGoods(goods);
//				}
//			}
//    	}catch (Exception e) {
//    		System.out.println(e);
//    	} 
//    }  
}  