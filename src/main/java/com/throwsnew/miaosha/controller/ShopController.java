package com.throwsnew.miaosha.controller;

import com.throwsnew.miaosha.model.Item;
import com.throwsnew.miaosha.model.Order;
import com.throwsnew.miaosha.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return shopService.listItemByCategory(category);
    }

    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable Long id) {
        return shopService.getItem(id);
    }

    @GetMapping("/myOrder/{uid}")
    public List<Item> listOrder(@PathVariable String category) {
        return shopService.listItemByCategory(category);
    }

    //一份商品算一个订单
    @PostMapping("/order")
    public ResponseEntity order(@RequestBody Order order) {
        shopService.makeOrder(order);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
