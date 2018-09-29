package com.throwsnew.miaosha.dao.mapper;

import com.throwsnew.miaosha.dao.model.ItemDO;
import com.throwsnew.miaosha.dao.model.ItemDOCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemDO record);

    int insertBatch(@Param("records") List<ItemDO> records);

    int insertSelective(ItemDO record);

    List<ItemDO> selectByExample(ItemDOCriteria example);

    ItemDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemDO record,
            @Param("example") ItemDOCriteria example);

    int updateByExample(@Param("record") ItemDO record, @Param("example") ItemDOCriteria example);

    int updateByPrimaryKeySelective(ItemDO record);

    int updateByPrimaryKey(ItemDO record);
}