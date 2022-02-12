package com.nrvcer.service.impl;

import com.nrvcer.dao.GoodsDao;
import com.nrvcer.dao.SaleDao;
import com.nrvcer.domain.Goods;
import com.nrvcer.domain.Sale;
import com.nrvcer.exces.NotEnoughException;
import com.nrvcer.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {
    private GoodsDao goodsDao;
    private SaleDao saleDao;

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    @Override
    // 表示使用的是事务控制的默认值，默认的传播行为是REQUIRED，默认的隔离级别是DEFAULT
    // 默认抛出运行时异常，回滚事务
    // @Transactional
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    NullPointerException.class,NotEnoughException.class
            }
    )
    public void buy(Integer goodsId, Integer goodsAmount) {
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(goodsAmount);
        // 往销售表中插入销售订单
        saleDao.insertSale(sale);

        Goods goods = goodsDao.selectGoods(goodsId);
        if (goods == null) {
            throw new NullPointerException("无此商品");
        }
        if (goodsAmount > goods.getAmount()) {
            throw  new NotEnoughException("库存不足");
        }

        // 更新商品信息
        goods = new Goods();
        goods.setAmount(goodsAmount);
        goods.setId(goodsId);
        goodsDao.updateGoods(goods);
    }
}
