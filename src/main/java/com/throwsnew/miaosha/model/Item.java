package com.throwsnew.miaosha.model;

import com.throwsnew.miaosha.dao.model.ItemDO;

/**
 * Created by Xianfeng
 * E-Mail: songxianfeng@xxxx.com
 * Date: 18-9-4 下午4:35
 * Desc:
 */
public class Item {

    private Long id;

    private Long amout;

    private String name;

    private String description;

    private String category;

    private Integer price;

    public Item() {
    }

    public Item(ItemDO itemDO) {
        this.id = itemDO.getId();
        this.amout = itemDO.getAmount();
        this.name = itemDO.getName();
        this.description = itemDO.getDescription();
        this.category = itemDO.getCategory();
        this.price = itemDO.getPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmout() {
        return amout;
    }

    public void setAmout(Long amout) {
        this.amout = amout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", amout=" + amout +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
