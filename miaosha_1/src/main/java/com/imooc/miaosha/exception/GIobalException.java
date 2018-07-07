package com.imooc.miaosha.exception;

import com.imooc.miaosha.result.CodeMsg;

/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月22日 上午9:31:55
*类说明：全局异常或者可以说的业务异常
*/
public class GIobalException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private CodeMsg cm;
	
	public GIobalException(CodeMsg cm) {
		
		super(cm.toString());
		this.cm = cm;
	}

	public CodeMsg getCm() {
		return cm;
	}

	public void setCm(CodeMsg cm) {
		this.cm = cm;
	}
	
}
