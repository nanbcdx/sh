package com.wph.demo.sh.service;

import com.wph.demo.sh.entity.ShOrder;

public interface OrderService {
     String createToken();

     void addOrder(ShOrder order);

    ShOrder selectById(Integer id);
}
