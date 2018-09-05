package com.throwsnew.miaosha.model;

import com.throwsnew.miaosha.dao.model.ItemOrderDO;

/**
 * Created by Xianfeng
 * E-Mail: songxianfeng@xxxx.com
 * Date: 18-9-4 下午4:38
 * Desc:
 */
public class Order {


    private Long id;

    private Long itemId;

    private String userId;

    public Order() {
    }

    public Order(ItemOrderDO itemOrderDO) {
        this.id = itemOrderDO.getId();
        this.itemId = itemOrderDO.getItemId();
        this.userId = itemOrderDO.getUserId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", userId='" + userId + '\'' +
                '}';
    }
}
