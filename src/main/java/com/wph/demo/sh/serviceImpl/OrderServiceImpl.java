package com.wph.demo.sh.serviceImpl;

import com.wph.demo.sh.anno.Cache_Order;
import com.wph.demo.sh.anno.NoRepeatSubmit;
import com.wph.demo.sh.constant.OrderConstant;
import com.wph.demo.sh.entity.ShOrder;
import com.wph.demo.sh.mapper.OrderMapper;
import com.wph.demo.sh.service.OrderService;
import com.wph.demo.sh.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @Description :
 * @Author :wangcheng
 * @Date :2020/4/25 14:05
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RedisUtil redis;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public String createToken() {
        String token = UUID.randomUUID().toString().replace("-", "");
        token = DigestUtils.md5DigestAsHex(token.getBytes());
        redis.set(token, token);
        return token;
    }

    @Override
    @NoRepeatSubmit(type = OrderConstant.HEADERS)
    public void addOrder(ShOrder order) {
        order.setCreatedTime(new Date());
        order.setModifiedTime(new Date());
        int result = orderMapper.insert(order);
        if (result != 1) {
            throw new RuntimeException("订单添加失败");
        }
    }

    @Override
    @Cache_Order(seconds = 7*60)
    public ShOrder selectById(Integer id) {
        ShOrder order = orderMapper.selectById(id);
        if (null == order) {
            throw new RuntimeException("没有该订单信息");
        }
        return order;
    }
}
