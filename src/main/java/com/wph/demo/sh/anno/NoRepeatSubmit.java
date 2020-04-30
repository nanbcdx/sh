package com.wph.demo.sh.anno;

import com.wph.demo.sh.constant.OrderConstant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description :
 * @Author :wangcheng
 * @Date :2020/4/25 16:52
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoRepeatSubmit {
    String type() default OrderConstant.PARAMETER;
}
