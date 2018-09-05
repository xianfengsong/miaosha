package com.throwsnew.miaosha;

import com.throwsnew.miaosha.dao.mapper.ItemMapper;
import com.throwsnew.miaosha.dao.model.ItemDO;
import com.throwsnew.miaosha.dao.model.ItemDOCriteria;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@MapperScan( basePackages = {"com.throwsnew.miaosha.dao.mapper"})
public class MiaoshaApplication implements CommandLineRunner {
    private final ItemMapper itemMapper;

    public MiaoshaApplication(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(MiaoshaApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        ItemDOCriteria criteria=new ItemDOCriteria();
        criteria.createCriteria().andIdIsNotNull();
        List<ItemDO> itemDOList = itemMapper.selectByExample(criteria);
        System.out.println(itemDOList.stream().map(ItemDO::toString).collect(Collectors.joining(",")));
    }
}
