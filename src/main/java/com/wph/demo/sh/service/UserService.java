package com.wph.demo.sh.service;

import com.wph.demo.sh.entity.ShUser;

/**
 * @Description :
 * @Author :wangcheng
 * @Date :2020/4/25 18:42
 */
public interface UserService {

    String login(ShUser user);

    void addUser(ShUser user);
}
