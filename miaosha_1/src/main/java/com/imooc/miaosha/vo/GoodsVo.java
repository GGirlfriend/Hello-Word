package com.imooc.miaosha.vo;

import java.sql.Date;

import com.imooc.miaosha.domain.Goods;

/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月23日 上午9:15:44
*类说明：
*/
public class GoodsVo extends Goods{
	private Double miaoshaPrice;
	private Integer stockCount;
	private Date startDate;
	private Date endDate;
	public Integer getStockCount() {
		return stockCount;
	}
	public void setStockCount(Integer stockCount) {
		this.stockCount = stockCount;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Double getMiaoshaPrice() {
		return miaoshaPrice;
	}
	public void setMiaoshaPrice(Double miaoshaPrice) {
		this.miaoshaPrice = miaoshaPrice;
	}
	
	
}
