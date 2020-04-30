package com.wph.demo.sh.controller;

import com.wph.demo.sh.constant.OrderConstant;
import com.wph.demo.sh.entity.ShUser;
import com.wph.demo.sh.service.UserService;
import com.wph.demo.sh.vo.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description :
 * @Author :wangcheng
 * @Date :2020/4/25 18:42
 */
@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;



    public JsonResult login(ShUser user, HttpServletResponse response){
        String token=userService.login(user);
        Cookie cookie=new Cookie(OrderConstant.SH_TICKET,token);
        cookie.setDomain("localhost");
        cookie.setPath("/");
        cookie.setMaxAge(7*24*60*60);
        response.addCookie(cookie);
        return JsonResult.ok("登录成功!!");
    }

    @PostMapping("addUser")
    public JsonResult addUser(ShUser user){
        userService.addUser(user);
        return JsonResult.ok("添加成功!");
    }


}
