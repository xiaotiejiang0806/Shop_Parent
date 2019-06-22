package com.qfedu.shop.api.controller;

import com.qfedu.common.vo.R;
import com.qfedu.shop.api.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 11:37 2019/6/20
 * @ Description：${description}
 */
@RestController
@Api(value = "商品操作",tags = "关于商品的接口实现")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "商品列表",notes = "根据提供的信息查询商品的二级列表")
    @PostMapping("/goods/findAll.do")
    public R findGoodListByGtid(@RequestBody Map<String,Object> map){
        return goodsService.findGoodListByGtid(map);
    }

    @ApiOperation(value = "商品详情",notes = "根据商品列表查看商品信息")
    @GetMapping("/goods/findDetail.do")
    public R findGoodsDetail(@RequestParam("id") int id){
        return goodsService.findGoodsDetail(id);
    }
}
