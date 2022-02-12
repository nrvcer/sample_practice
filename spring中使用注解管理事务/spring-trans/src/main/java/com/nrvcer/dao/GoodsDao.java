package com.nrvcer.dao;

import com.nrvcer.domain.Goods;

public interface GoodsDao {
    Goods selectGoods(Integer goodsId);
    int updateGoods(Goods goods);
}
