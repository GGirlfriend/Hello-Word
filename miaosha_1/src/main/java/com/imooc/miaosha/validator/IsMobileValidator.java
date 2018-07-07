package com.imooc.miaosha.validator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.alibaba.druid.util.StringUtils;
import com.imooc.miaosha.util.ValidatorUtil;
/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月22日 上午8:28:14
*类说明：
*/
public class IsMobileValidator implements ConstraintValidator<IsMobile,String>{

	private boolean required = false;
	
	@Override
	public void initialize(IsMobile constraintAnnotation) {
		required =constraintAnnotation.required();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(required) {
			return ValidatorUtil.isMobile(value);
		}else {
			if(StringUtils.isEmpty(value)) {
				return true;
			}else {
				return ValidatorUtil.isMobile(value);
			}
		}
	}

	
	
}
