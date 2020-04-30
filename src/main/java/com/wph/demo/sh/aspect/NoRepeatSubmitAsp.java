package com.wph.demo.sh.aspect;

import com.wph.demo.sh.anno.NoRepeatSubmit;
import com.wph.demo.sh.constant.OrderConstant;
import com.wph.demo.sh.exception.IllegalOperationException;
import com.wph.demo.sh.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description :
 * @Author :wangcheng
 * @Date :2020/4/25 16:54
 */
@Component
@Aspect
public class NoRepeatSubmitAsp {

    @Autowired
    private RedisUtil redis;

    @Around("@annotation(com.wph.demo.sh.anno.NoRepeatSubmit)")
    public Object proceed(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attr.getRequest();
        MethodSignature signature=(MethodSignature)joinPoint.getSignature();
        NoRepeatSubmit anno = signature.getMethod().getAnnotation(NoRepeatSubmit.class);
        String type = anno.type();
        String token=null;
        if(OrderConstant.PARAMETER.equals(type)){
            token = request.getParameter("token");
        }else {
            token=request.getHeader("token");
        }
        if(StringUtils.isEmpty(token)){
            throw new IllegalArgumentException("");
        }
        String result = (String)redis.get(token);
        if(StringUtils.isEmpty(result)){
            throw new IllegalOperationException();
        }
        Object object = joinPoint.proceed();
        redis.del(token);
        return object;
    }
}
