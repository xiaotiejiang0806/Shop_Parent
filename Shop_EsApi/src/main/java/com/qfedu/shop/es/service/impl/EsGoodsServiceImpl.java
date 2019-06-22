package com.qfedu.shop.es.service.impl;

import com.qfedu.common.vo.R;
import com.qfedu.shop.es.dao.EsGoodsDao;
import com.qfedu.shop.es.model.EsGoods;
import com.qfedu.shop.es.service.EsGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 10:21 2019/6/21
 * @ Description：${description}
 */
@Service
public class EsGoodsServiceImpl implements EsGoodsService {

    @Autowired
    private EsGoodsDao esGoodsDao;

    @Override
    public R saver(EsGoods esGoods) {
        if (esGoodsDao.save(esGoods) != null){
            return R.setOK();
        }else {
            return R.setERROR("网络异常");
        }

    }

    @Override
    public R querryAll() {
        return R.setOK("ok",esGoodsDao.findAll());
    }

    @Override
    public R deleteByid(int id) {

        esGoodsDao.deleteById(id);
        return R.setOK();
    }
}
