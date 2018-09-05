package com.throwsnew.miaosha;

import com.throwsnew.miaosha.dao.mapper.ItemMapper;
import com.throwsnew.miaosha.dao.model.ItemDO;
import com.throwsnew.miaosha.dao.model.ItemDOCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiaoshaApplicationTests {
    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void contextLoads() {
        ItemDOCriteria criteria=new ItemDOCriteria();
        criteria.createCriteria().andIdIsNotNull();
        List<ItemDO> itemDOList = itemMapper.selectByExample(criteria);
        System.out.println(itemDOList.stream().map(ItemDO::toString).collect(Collectors.joining(",")));
    }

}