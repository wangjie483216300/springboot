package com.example.demo.service;

import com.example.demo.dao.WarehouseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WarehouseServer {
    @Autowired
    private WarehouseDao warehouseDao;
    @Autowired
    private RedisTemplate redisTemplate;
    public String updateWarehouse1(String uuid1, String type, String style, String size, String color){
        String state="";
        String uuid2="wangjie";
        redisTemplate.opsForList().leftPush(uuid2,"123456");
        while (redisTemplate.opsForList().size(uuid2)>0){
            String TB_GOODS_INVENTORY_LOGID = UUID.randomUUID().toString().replaceAll("-", "");
            String goodsid = warehouseDao.selectID(String.valueOf(redisTemplate.opsForList().leftPop(uuid2)));
            if (warehouseDao.selectStyle(goodsid).equals(style)){}else{state="衣服款式错误";}
            if (warehouseDao.selectType(goodsid).equals(type)){}else {state="衣服类型错误";}
            if (warehouseDao.selectColor(goodsid).equals(color)){}else {state="衣服色号错误";}
            if (warehouseDao.selectSize(goodsid).equals(size)){}else {state="衣服尺码错误";}
            warehouseDao.updateWarehouse(1,TB_GOODS_INVENTORY_LOGID,goodsid);
            state="true";
        }
        return state;
    }
    public String updateWarehouse2(String uuid1, String type, String style, String size, String color){
        String state="";
        String uuid2="wangjie";
        redisTemplate.opsForList().leftPush(uuid2,"123456");
        while (redisTemplate.opsForList().size(uuid2)>0){
            String TB_GOODS_INVENTORY_LOGID = UUID.randomUUID().toString().replaceAll("-", "");
            String goodsid = warehouseDao.selectID(String.valueOf(redisTemplate.opsForList().leftPop(uuid2)));
            if (warehouseDao.selectStyle(goodsid).equals(style)){}else{state="衣服款式错误";}
            if (warehouseDao.selectType(goodsid).equals(type)){}else {state="衣服类型错误";}
            if (warehouseDao.selectColor(goodsid).equals(color)){}else {state="衣服色号错误";}
            if (warehouseDao.selectSize(goodsid).equals(size)){}else {state="衣服尺码错误";}
            warehouseDao.updateWarehouse(2,TB_GOODS_INVENTORY_LOGID,goodsid);
            state="true";
        }
        return state;
    }
}
