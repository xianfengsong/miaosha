package com.throwsnew.miaosha;

import com.throwsnew.miaosha.dao.mapper.ItemMapper;
import com.throwsnew.miaosha.dao.model.ItemDO;
import com.throwsnew.miaosha.dao.model.ItemDOCriteria;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
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

    public static String randomAlphaNumeric(int count) {
        final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    @Test
    public void init() {
        int productNumber = 200000;
        String[] categoryList = new String[]{"phone", "drone", "food", "keyboard", "medicine"};

        ForkJoinPool pool = new ForkJoinPool(32);
        List<ItemDO> itemList = new ArrayList<>();
        for (int i = 0; i < productNumber; i++) {
            double random = Math.random();
            String category = categoryList[i % categoryList.length];
            ItemDO itemDO = new ItemDO();
            itemDO.setAmount(100000L);
            itemDO.setCategory(category);
            itemDO.setDescription(randomAlphaNumeric(i % 2000));
            itemDO.setName(category + "-" + random * 10);
            itemDO.setPrice((int) (random * 100));
            itemList.add(itemDO);
            if (itemList.size() >= 100 || i == productNumber - 1) {
                pool.execute(new InsertItemAction(itemMapper, itemList));
                itemList = new ArrayList<>();
            }
        }
        Long start = System.currentTimeMillis();
        pool.awaitQuiescence(1, TimeUnit.DAYS);
        System.out.println("用时：" + (System.currentTimeMillis() - start));
    }

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
        itemDO.setName("testX");
        itemMapper.updateByPrimaryKey(itemDO);
    }

    @Test
    public void select() {
        ItemDOCriteria criteria = new ItemDOCriteria();
        criteria.createCriteria().andIdIsNotNull();
        List<ItemDO> itemDOList = itemMapper.selectByExample(criteria);
        System.out.println(
                itemDOList.stream().map(ItemDO::toString).collect(Collectors.joining("\r\n")));
    }

}
