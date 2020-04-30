package com.wph.demo.sh.aspect;

import com.wph.demo.sh.constant.OrderConstant;
import com.wph.demo.sh.utils.JsonUtil;
import com.wph.demo.sh.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description :
 * @Author :wangcheng
 * @Date :2020/4/26 11:43
 */
@Aspect
@Component
@Slf4j
public class CacheOrderAspect {

    @Autowired
    private RedisUtil redis;

    @Around("@annotation(com.wph.demo.sh.anno.Cache_Order)")
    public Object proceed(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result=null;
        MethodSignature signature=(MethodSignature)joinPoint.getSignature();
        String key= OrderConstant.ORDER_CACHE_KEY+String.valueOf(joinPoint.getArgs()[0]);
        String obj = (String) redis.get(key);
        if(!StringUtils.isEmpty(obj)){
            Class returnType = signature.getReturnType();
            result = JsonUtil.from(obj, returnType);
        }
        result= joinPoint.proceed();
        String jsonResult = JsonUtil.to(result);
        redis.set(key,jsonResult);
        return result;

    }

}
