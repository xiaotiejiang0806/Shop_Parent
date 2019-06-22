package com.qfedu.shop.es.dao;

import com.qfedu.shop.es.model.EsLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 20:34 2019/6/21
 * @ Description：${description}
 */
public interface EsLogDao extends ElasticsearchCrudRepository<EsLog,Integer> {
}
