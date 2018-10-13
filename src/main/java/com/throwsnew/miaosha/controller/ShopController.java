package com.throwsnew.miaosha.controller;

import com.throwsnew.miaosha.model.Item;
import com.throwsnew.miaosha.model.Order;
import com.throwsnew.miaosha.service.ShopService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Xianfeng
 * E-Mail: songxianfeng@xxxx.com
 * Date: 18-9-4 下午4:32
 * Desc:
 */
@RestController
public class ShopController {
    @Autowired
    private ShopService shopService;

    @GetMapping("/items/{category}")
    public List<Item> listItem(@PathVariable String category) {
        //todo 分页返回
        return shopService.listItemByCategory(category);
    }

    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable Long id) {
        return shopService.getItem(id);
    }

    @GetMapping("/myOrder/{uid}")
    public List<Order> listOrder(@PathVariable String uid) {
        return shopService.listOrderByUser(uid);
    }

    /**
     * 下单后扣除库存-1
     */
    @PostMapping("/order")
    public ResponseEntity order(@RequestBody Order order) {
        shopService.makeOrder(order);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
