package com.qfedu.shop.es.service;

import com.qfedu.common.vo.R;
import com.qfedu.shop.es.model.EsGoods;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 10:20 2019/6/21
 * @ Description：${description}
 */
public interface EsGoodsService {

    R saver(EsGoods esGoods);

    R querryAll();

    R deleteByid(int id);
}
