package com.throwsnew.miaosha.dao.mapper;

import com.throwsnew.miaosha.dao.model.ItemOrderDO;
import com.throwsnew.miaosha.dao.model.ItemOrderDOCriteria;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemOrderMapper {

    int insert(ItemOrderDO record);


    List<ItemOrderDO> selectByExample(ItemOrderDOCriteria example);

    ItemOrderDO selectByPrimaryKey(Long id);

}