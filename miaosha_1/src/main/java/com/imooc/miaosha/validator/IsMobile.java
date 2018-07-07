package com.imooc.miaosha.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
*@author 暖暖QvQ
*@version 创建时间:2018年5月22日 上午8:22:48
*类说明：定义一个校验器
*/

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {IsMobileValidator.class})
public @interface IsMobile {
	//参数是不允许为空的，但是在有些情况下他是允许为空的
	boolean required() default true;
	
	String message() default "手机号码格式有误";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
