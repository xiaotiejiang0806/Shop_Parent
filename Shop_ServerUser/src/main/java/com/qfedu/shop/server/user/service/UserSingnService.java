package com.qfedu.shop.server.user.service;

import com.qfedu.common.vo.R;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 14:24 2019/6/15
 * @ Description：${description}
 */
public interface UserSingnService {

    R saveSingn(String token);

    R querryByDays (String token ,int days);

    R querryByUid(String token);

    R querrySingle(String token);

}
