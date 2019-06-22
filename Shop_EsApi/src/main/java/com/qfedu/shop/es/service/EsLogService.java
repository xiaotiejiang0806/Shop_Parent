package com.qfedu.shop.es.service;

import com.qfedu.common.vo.R;
import com.qfedu.shop.es.model.EsLog;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 20:35 2019/6/21
 * @ Description：${description}
 */
public interface EsLogService {
    R saveLog(EsLog esLog);
}
