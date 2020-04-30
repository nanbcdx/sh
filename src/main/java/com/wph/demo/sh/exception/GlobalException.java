package com.wph.demo.sh.exception;

import com.wph.demo.sh.vo.JsonResult;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description :
 * @Author :wangcheng
 * @Date :2020/4/25 17:41
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(RuntimeException.class)
    public JsonResult doException(RuntimeException e) {
        if (e instanceof IllegalArgumentException) {
            return JsonResult.err("非法参数");
        } else if (e instanceof IllegalOperationException) {
            return JsonResult.err("不可重复提交!!");
        } else {
            return JsonResult.err(e.getMessage());
        }
    }

    @ExceptionHandler(ShiroException.class)
    public JsonResult doShiroExcepiton(ShiroException e){
        JsonResult result=new JsonResult();
        result.setCode(JsonResult.EXCEPTION);
        if (e instanceof UnknownAccountException){
            result.setMsg("账号不存在");
        }else if(e instanceof LockedAccountException){
            result.setMsg("账号被禁用");
        }else if (e instanceof IncorrectCredentialsException){
            result.setMsg("密码错误");
        }else if(e instanceof AuthorizationException){
            result.setMsg("没有操作权限");
        } else{
            result.setMsg("系统维护中");
        }
        return result;
    }

}
