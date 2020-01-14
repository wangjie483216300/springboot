package com.example.demo.controller;

import com.example.demo.service.GoodsQaLogSever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController//@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用
@RequestMapping("/wangjie")
public class GoodsQaLogController {

    @Autowired
    private GoodsQaLogSever goodsQaLogSever;


    @RequestMapping("/submit")//处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径
    public void updateGoodsQaLog(){
        goodsQaLogSever.updateGoodsQaLog();
    }


    @RequestMapping("/qualified")
    public ValueOperations<String, Object> selectGoodsQaLog(){
        return goodsQaLogSever.selectGoodsQaLog();
    }
}
