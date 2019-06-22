package com.qfedu.shop.es.task;

import com.alibaba.fastjson.JSON;
import com.qfedu.common.config.ProjectConfig;
import com.qfedu.common.util.JedisUtil;
import com.qfedu.common.util.TimeUtil;
import com.qfedu.shop.es.model.EsGoods;
import com.qfedu.shop.es.model.EsLog;
import com.qfedu.shop.es.service.EsGoodsService;
import com.qfedu.shop.es.service.EsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 19:53 2019/6/21
 * @ Description：每隔四个小时将redis中修改过的数据更新到ES数据库中
 */
@Component
public class EsDataGoodsTask {

    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private EsGoodsService esGoodsService;

    @Autowired
    private EsLogService esLogService;

    @Scheduled(cron = "0 0 0/4 * * ?")
    public void datasyn(){
     // 新增
        if (jedisUtil.exists(ProjectConfig.ESGOODSADD)){
            Map<String, String> map = jedisUtil.hgetall(ProjectConfig.ESGOODSADD);

            readToSave(map,1);
        }else {
            if (jedisUtil.exists(ProjectConfig.ESGOODSADDBU)){
                EsLog esLog = new EsLog();
                esLog.setContent(TimeUtil.getFormatDate(new Date()) + "使用了备份数据添加进入ES");
                esLogService.saveLog(esLog);
                readToSave(jedisUtil.hgetall(ProjectConfig.ESGOODSADDBU),1);
            }
        }
     // 删除
        if (jedisUtil.exists(ProjectConfig.ESGOODSDEL)){
            Map<String, String> map = jedisUtil.hgetall(ProjectConfig.ESGOODSDEL);
            del(map);
        }else {
            if (jedisUtil.exists(ProjectConfig.ESGOODSDELBU)){
                Map<String, String> map = jedisUtil.hgetall(ProjectConfig.ESGOODSDEL);
                EsLog esLog = new EsLog();
                esLog.setContent(TimeUtil.getFormatDate(new Date()) + "使用了备份数据删除进入ES");
                esLogService.saveLog(esLog);
                del(map);
            }
        }
        
     // 修改
        
        if (jedisUtil.exists(ProjectConfig.ESGOODSUPDATE)){
            readToSave(jedisUtil.hgetall(ProjectConfig.ESGOODSUPDATE),2);
        }else {
            if (jedisUtil.exists(ProjectConfig.ESGOODSUPDATEBU)){
                EsLog esLog = new EsLog();
                esLog.setContent(TimeUtil.getFormatDate(new Date()) + "使用了备份数据更改进入ES");
                esLogService.saveLog(esLog);
                readToSave(jedisUtil.hgetall(ProjectConfig.ESGOODSUPDATEBU),2);
            }
        }
    }

    private void readToSave(Map<String,String> map,int type){
        if (map != null){
            Collection<String> list = map.values();
            for (String j : list){
                esGoodsService.saver(JSON.parseObject(j, EsGoods.class));
            }
            if (type == 1){
                jedisUtil.del(ProjectConfig.ESGOODSADD,ProjectConfig.ESGOODSADDBU);
            }
            if (type == 2){
                jedisUtil.del(ProjectConfig.ESGOODSUPDATE,ProjectConfig.ESGOODSUPDATEBU);
            }
        }
    }

    private void del(Map<String,String> map){
        if (map != null){
            Set<String> set = map.keySet();
            for (String s : set) {
                esGoodsService.deleteByid(Integer.parseInt(s));
            }
        }
        jedisUtil.del(ProjectConfig.ESGOODSDEL,ProjectConfig.ESGOODSDELBU);
    }
}
