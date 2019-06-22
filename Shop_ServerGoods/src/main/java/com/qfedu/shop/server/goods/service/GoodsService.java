package com.qfedu.shop.server.goods.service;

import com.qfedu.common.vo.R;

import java.util.Map;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 11:07 2019/6/19
 * @ Description：${description}
 */
public interface GoodsService {

    R querryIndexNew();

    R querryAll(Map<String,Object> map);

    R querryDetail(int id);
}
