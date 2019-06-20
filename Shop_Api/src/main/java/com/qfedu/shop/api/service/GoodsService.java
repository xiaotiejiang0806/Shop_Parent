package com.qfedu.shop.api.service;

import com.qfedu.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 20:18 2019/6/19
 * @ Description：${description}
 */
@FeignClient(name = "GoodsProvider")
public interface GoodsService {

    @PostMapping("/goods/findAll.do")
    public R findGoodListByGtid(@RequestBody Map<String,String> map);


    @GetMapping("/goods/findDetail.do")
    public R findGoodsDetail(@RequestParam("id") int id);
}
