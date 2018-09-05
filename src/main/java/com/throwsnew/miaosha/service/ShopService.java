package com.throwsnew.miaosha.service;

import com.throwsnew.miaosha.model.Item;
import com.throwsnew.miaosha.model.Order;

import java.util.List;

/**
 * Created by Xianfeng
 * E-Mail: songxianfeng@xxxx.com
 * Date: 18-9-4 下午5:07
 * Desc:
 */
public interface ShopService {
    List<Item> listItemByCategory(String category);

    Item getItem(Long id);

    List<Order> listOrderByUser(String userId);

    Long makeOrder(Order order);
}
