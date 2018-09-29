package com.throwsnew.miaosha;

import com.throwsnew.miaosha.dao.mapper.ItemMapper;
import com.throwsnew.miaosha.dao.model.ItemDO;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * author Xianfeng <br/>
 * date 18-9-29 下午4:33 <br/>
 * Desc:
 */
public class InsertItemAction extends RecursiveAction {

    private ItemMapper itemMapper;
    private List<ItemDO> itemDOList;

    public InsertItemAction(ItemMapper itemMapper,
            List<ItemDO> itemDOList) {
        this.itemMapper = itemMapper;
        this.itemDOList = itemDOList;
    }

    @Override
    protected void compute() {
        itemMapper.insertBatch(itemDOList);
    }
}
