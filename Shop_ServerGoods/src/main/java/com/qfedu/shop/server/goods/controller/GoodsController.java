package com.qfedu.shop.server.goods.controller;

import com.qfedu.common.vo.R;
import com.qfedu.shop.server.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 20:13 2019/6/19
 * @ Description：${description}
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    @PostMapping("/goods/findAll.do")
    public R findGoodListByGtid(@RequestBody Map<String,String> map){
        return goodsService.querryAll(map);
    }

    @GetMapping("/goods/findDetail.do")
    public R findGoodsDetail(@RequestParam("id") int id){
        return goodsService.querryDetail(id);
    }
}
