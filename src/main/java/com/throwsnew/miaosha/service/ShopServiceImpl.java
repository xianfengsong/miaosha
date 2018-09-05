package com.throwsnew.miaosha.service;

import com.throwsnew.miaosha.dao.mapper.ItemMapper;
import com.throwsnew.miaosha.dao.mapper.ItemOrderMapper;
import com.throwsnew.miaosha.dao.model.ItemDO;
import com.throwsnew.miaosha.dao.model.ItemDOCriteria;
import com.throwsnew.miaosha.dao.model.ItemOrderDO;
import com.throwsnew.miaosha.dao.model.ItemOrderDOCriteria;
import com.throwsnew.miaosha.model.Item;
import com.throwsnew.miaosha.model.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Xianfeng
 * E-Mail: songxianfeng@xxxx.com
 * Date: 18-9-4 下午4:56
 * Desc:
 */
@Service
public class ShopServiceImpl implements ShopService {
    private final ItemMapper itemMapper;
    private final ItemOrderMapper itemOrderMapper;

    public ShopServiceImpl(ItemMapper itemMapper, ItemOrderMapper itemOrderMapper) {
        this.itemMapper = itemMapper;
        this.itemOrderMapper = itemOrderMapper;
    }


    @Override
    public List<Item> listItemByCategory(String category) {
        ItemDOCriteria criteria = new ItemDOCriteria();
        criteria.createCriteria().andCategoryEqualTo(category);
        List<ItemDO> doList = itemMapper.selectByExample(criteria);
        return doList.stream().map(Item::new).collect(Collectors.toList());
    }

    @Override
    public Item getItem(Long id) {
        ItemDO itemDO = itemMapper.selectByPrimaryKey(id);
        return new Item(itemDO);
    }

    @Override
    public List<Order> listOrderByUser(String userId) {
        ItemOrderDOCriteria criteria = new ItemOrderDOCriteria();
        criteria.createCriteria().andUserIdEqualTo(userId);
        List<ItemOrderDO> doList = itemOrderMapper.selectByExample(criteria);
        return doList.stream().map(Order::new).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Long makeOrder(Order order) {
        //扣库存
        ItemDO itemDO = itemMapper.selectByPrimaryKey(order.getItemId());
        itemDO.setAmount(itemDO.getAmount() - 1);
        int result = itemMapper.updateByPrimaryKeySelective(itemDO);
        Assert.isTrue(result == 1, "update item amount result not equal one");

        //插入订单
        ItemOrderDO orderDO = new ItemOrderDO();
        BeanUtils.copyProperties(order, orderDO);
        int insert = itemOrderMapper.insert(orderDO);
        Assert.isTrue(insert == 1, "insert order result not equal one");

        return orderDO.getId();
    }
}
