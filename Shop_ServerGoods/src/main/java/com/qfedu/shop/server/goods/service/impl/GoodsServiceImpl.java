package com.qfedu.shop.server.goods.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.common.vo.PageBean;
import com.qfedu.common.vo.R;
import com.qfedu.shop.server.goods.dao.GoodsMapper;
import com.qfedu.shop.server.goods.dto.GoodsListDto;
import com.qfedu.shop.server.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 11:07 2019/6/19
 * @ Description：${description}
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public R querryIndexNew() {

        return R.setOK("ok",goodsMapper.selectAll(null));
    }

    @Override
    public R querryAll(Map<String, Object> map) {

        int page=Integer.parseInt(map.get("page").toString());
        int count=Integer.parseInt(map.get("count").toString());
        PageBean<GoodsListDto> pageBean = new PageBean();

        PageHelper.startPage(page,count);
        List<GoodsListDto> goodList = goodsMapper.findGoodList(map);

        pageBean.setData(goodList);
        pageBean.setCurrPage(page);
        pageBean.setCount(count);
        pageBean.setTotalPage(((Page)goodList).getPages());
        pageBean.setTotalCount((int) ((Page) goodList).getTotal());

        /*Page<GoodsListDto> pageObj= PageHelper.startPage(page,count);
        PageBean<GoodsListDto> pageBean=new PageBean();
        pageBean.setCount(count);
        pageBean.setCurrPage(page);
        pageBean.setTotalCount((int)pageObj.getTotal());
        pageBean.setTotalPage(pageObj.getPages());
        pageBean.setData(pageObj.getResult());*/
        return R.setOK("OK",pageBean);
    }

    @Override
    public R querryDetail(int id) {
        return R.setOK("ok",goodsMapper.findGoodsDetail(id));
    }
}
