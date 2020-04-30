package com.wph.demo.sh.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wph.demo.sh.entity.ShUser;
import com.wph.demo.sh.mapper.UserMapper;
import com.wph.demo.sh.service.UserService;
import com.wph.demo.sh.utils.JsonUtil;
import com.wph.demo.sh.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @Description :
 * @Author :wangcheng
 * @Date :2020/4/25 18:43
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisUtil redis;
    @Autowired
    private UserMapper userMapper;


    @Override
    public String login(ShUser user) {
        String token=null;
        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(password);
        QueryWrapper queryWrapper=new QueryWrapper(user);
        ShUser tempUser = userMapper.selectOne(queryWrapper);
        if(null!=tempUser){
            token=DigestUtils.md5DigestAsHex((tempUser.getUsername()+System.currentTimeMillis()).getBytes());
            tempUser.setPassword(""+System.currentTimeMillis());
            redis.set(token,JsonUtil.to(tempUser));
        }
        return token;
    }

    @Override
    public void addUser(ShUser user) {
        String shPassword=DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(shPassword);
        userMapper.insert(user);
    }
}
