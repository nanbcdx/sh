package com.wph.demo.sh.interceptor;

import com.wph.demo.sh.constant.OrderConstant;
import com.wph.demo.sh.entity.ShUser;
import com.wph.demo.sh.utils.JsonUtil;
import com.wph.demo.sh.utils.RedisUtil;
import com.wph.demo.sh.utils.UserThredLocal;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description :
 * @Author :wangcheng
 * @Date :2020/4/25 18:10
 */
@Component
@Slf4j
public class MyInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtil redis;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=null;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(OrderConstant.SH_TICKET.equals(cookie.getName())){
                token=cookie.getValue();
                break;
            }
        }
        if(!StringUtils.isEmpty(token)){
            String userJson = (String)redis.get(token);
            if(!StringUtils.isEmpty(userJson)){
                ShUser user = JsonUtil.from(userJson, ShUser.class);
                UserThredLocal.set(user);
                return true;
            }
        }
        response.sendRedirect("/login.html");

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserThredLocal.remove();
    }
}
