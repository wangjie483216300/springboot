package com.example.demo.service;

import com.example.demo.dao.QualityTestDao;
import com.example.demo.model.User.Qualified;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.web.config.QuerydslWebConfiguration;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class QualityTestServer {
    @Autowired
    private QualityTestDao qualityTestDao;
    @Autowired
    private RedisTemplate redisTemplate;
    /**grpc生成uuid(tag)*/
    private static String uuid2 = UUID.randomUUID().toString().replaceAll("-", "");
    /**前端将uuid(tag)返回后端*/
    public Qualified updatestatus1(String uuid1, String type, String style, String size, String color){
        Qualified qualified=new Qualified();
        qualified.setGoodscount(123);
        qualified.setQA_ID("123");
        qualified.setMessage("");
        String uuid="wangjie";
//         String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        /**前端返回tag之前-grpc将rfid以uuid(tag)为K,将若干rfid写入redis缓存*/
//            redisTemplate.opsForList().leftPush(uuid,1);
//            redisTemplate.opsForList().leftPush(uuid,2);
//            redisTemplate.opsForList().leftPush(uuid,3);
        /**前端返回tag之前-grpc传送数据并核对数量-调用websocket.sendInfo();*/
        try {
            WebSocketServer.sendInfo(uuid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        redisTemplate.opsForList().leftPush(uuid,"123456");
        while (redisTemplate.opsForList().size(uuid)>0) {
            String testid = qualityTestDao.selectID(String.valueOf(redisTemplate.opsForList().leftPop(uuid)));
            if (qualityTestDao.selectStyle(testid).equals(style)) {
                qualified.setMessage("");
            } else {
                qualified.setMessage("衣服款式错误!");
                break;
            }
            if (qualityTestDao.selectType(testid).equals(type)) {
                qualified.setMessage("");
            } else {
                qualified.setMessage("衣服类型错误!");
                break;
            }
            if (qualityTestDao.selectColor(testid).equals(color)) {
                qualified.setMessage("");
            } else {
                qualified.setMessage("衣服色号错误!");
                break;
            }
            if (qualityTestDao.selectSize(testid).equals(size)) {
                qualified.setMessage("");
            } else {
                qualified.setMessage("衣服尺码错误");
                break;
            }
            /**修改TB_GOODS_INFO表status字段*/
            qualityTestDao.updatestatus1(4,testid);
            /**修改TB_GOODS_QA_LOG表status字段*/
//            qualityTestDao.updatestatus2(4,testid);
            qualified.setMessage("true");
        }
        return qualified;
    }
    public Qualified updatestatus2(String uuid1, String type, String style, String size, String color){
        Qualified qualified=new Qualified();
        qualified.setGoodscount(123);
        qualified.setQA_ID("123");
        qualified.setMessage("");
        String uuid="wangjie";
//         String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        /**前端返回tag之前-grpc将rfid以uuid(tag)为K,将若干rfid写入redis缓存*/
//            redisTemplate.opsForList().leftPush(uuid,1);
//            redisTemplate.opsForList().leftPush(uuid,2);
//            redisTemplate.opsForList().leftPush(uuid,3);
        /**前端返回tag之前-grpc传送数据并核对数量-调用websocket.sendInfo();*/
        try {
            WebSocketServer.sendInfo(uuid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        redisTemplate.opsForList().leftPush(uuid,"123456");
        while (redisTemplate.opsForList().size(uuid)>0) {
            String testid = qualityTestDao.selectID(String.valueOf(redisTemplate.opsForList().leftPop(uuid)));
            if (qualityTestDao.selectStyle(testid).equals(style)) {
                qualified.setMessage("");
            } else {
                qualified.setMessage("衣服款式错误!");
                break;
            }
            if (qualityTestDao.selectType(testid).equals(type)) {
                qualified.setMessage("");
            } else {
                qualified.setMessage("衣服类型错误!");
                break;
            }
            if (qualityTestDao.selectColor(testid).equals(color)) {
                qualified.setMessage("");
            } else {
                qualified.setMessage("衣服色号错误!");
                break;
            }
            if (qualityTestDao.selectSize(testid).equals(size)) {
                qualified.setMessage("");
            } else {
                qualified.setMessage("衣服尺码错误");
                break;
            }
            /**修改TB_GOODS_INFO表status字段*/
            qualityTestDao.updatestatus1(2,testid);
            /**修改TB_GOODS_QA_LOG表status字段*/
//            qualityTestDao.updatestatus2(2,testid);
            qualified.setMessage("true");
        }
        return qualified;
    }
}

