package com.wph.demo.sh.controller;

import com.wph.demo.sh.entity.ShOrder;
import com.wph.demo.sh.service.OrderService;
import com.wph.demo.sh.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author :wangcheng
 * @Date :2020/4/24 22:31
 */
@RestController
@RequestMapping("/order/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("getToken")
    public JsonResult getToken() {
        String token = orderService.createToken();
        return JsonResult.ok(token);
    }

    @PostMapping("addOrder")
    public JsonResult addOrder(ShOrder order) {
        orderService.addOrder(order);
        return JsonResult.ok(order);
    }

    @GetMapping("selectById")
    public JsonResult selectById(Integer id){
        ShOrder order=orderService.selectById(id);
        return JsonResult.ok(order);
    }


}
