package com.qfedu.shop.es.controller;

import com.qfedu.common.vo.R;
import com.qfedu.shop.es.service.EsGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 14:17 2019/6/21
 * @ Description：${description}
 */
@RestController
@Api(value = "ES操作",tags = "ES相关操作")
public class EsGoods {

    @Autowired
    private EsGoodsService esGoodsService;

    @ApiOperation(value = "保存数据",notes = "保存商品至数据库")
    @PostMapping("/es/save.do")
    public R save(@RequestBody EsGoods esGoods){
        return esGoods.save(esGoods);
    }


    @ApiOperation(value = "查询数据",notes = "查询所有的商品信息")
    @GetMapping(value = "/es/querry.do")
    public R querryAll(){
        return esGoodsService.querryAll();
    }
}
