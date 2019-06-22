package com.qfedu.shop.es.dao;

import com.qfedu.shop.es.model.EsGoods;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 10:16 2019/6/21
 * @ Description：${description}
 */
public interface EsGoodsDao extends ElasticsearchCrudRepository<EsGoods,Integer> {
}
