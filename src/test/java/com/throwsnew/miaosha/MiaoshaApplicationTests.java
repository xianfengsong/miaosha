package com.throwsnew.miaosha;

import com.throwsnew.miaosha.dao.mapper.ItemMapper;
import com.throwsnew.miaosha.dao.model.ItemDO;
import com.throwsnew.miaosha.dao.model.ItemDOCriteria;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiaoshaApplicationTests {

    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void insert() {
        ItemDO itemDO = new ItemDO();
        itemDO.setAmount(1L);
        itemDO.setCategory("phone");
        itemDO.setDescription("desc");
        itemDO.setName("test");
        itemDO.setPrice(10000);
        itemDO.setUpdateTime(new Date());
        itemMapper.insert(itemDO);
    }
    @Test
    public void select() {
        ItemDOCriteria criteria = new ItemDOCriteria();
        criteria.createCriteria().andIdIsNotNull();
        List<ItemDO> itemDOList = itemMapper.selectByExample(criteria);
        System.out.println(
                itemDOList.stream().map(ItemDO::toString).collect(Collectors.joining(",")));
    }

}
