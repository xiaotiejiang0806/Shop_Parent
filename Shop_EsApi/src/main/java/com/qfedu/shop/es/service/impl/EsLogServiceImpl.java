package com.qfedu.shop.es.service.impl;

import com.qfedu.common.vo.R;
import com.qfedu.shop.es.dao.EsLogDao;
import com.qfedu.shop.es.model.EsLog;
import com.qfedu.shop.es.service.EsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 20:36 2019/6/21
 * @ Description：${description}
 */
@Service
public class EsLogServiceImpl implements EsLogService {

    @Autowired
    private EsLogDao esLogDao;
    @Override
    public R saveLog(EsLog esLog) {

        return R.setOK("ok",esLogDao.save(esLog));
    }
}
