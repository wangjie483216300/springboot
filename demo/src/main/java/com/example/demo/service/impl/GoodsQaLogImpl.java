package com.example.demo.service.impl;


import com.example.demo.dao.GoodsQaLogDao;
import com.example.demo.model.TB_GOODS_QA_LOG;
import com.example.demo.service.GoodsQaLogSever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service//标明为业务类，方便注入到其他层中
public class GoodsQaLogImpl implements GoodsQaLogSever {

    @Autowired //自动把bean里面引用的对象的setter/getter方法省略，它会自动帮你set/get。否则要自己写get，set
    private GoodsQaLogDao goodsQaLogDao;


    private CacheProperties.Redis jedis;
    @Override
    public void updateGoodsQaLog() {
        jedis.lpush();
        jedis.set();
        jedis.lrang();
         goodsQaLogDao.updateGoodsQaLog(2,110  ,"");
    }
    @Override
    public List<TB_GOODS_QA_LOG> selectGoodsQaLog() {
        String uuid= UUID.randomUUID().toString().replaceAll("-","");
        List<TB_GOODS_QA_LOG > list=new ArrayList<>();

        for (int i=1;i<11;i++){
            int id=i;

            list.add(goodsQaLogDao.selectGoodsQaLog(id,uuid));
        }

        return list ;
    }
}
