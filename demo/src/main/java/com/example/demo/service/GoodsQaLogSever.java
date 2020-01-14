package com.example.demo.service;

import com.example.demo.model.TB_GOODS_QA_LOG;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper//为了给接口,自动根据一个添加@Mapper注解的接口生成一个实现类
public interface GoodsQaLogSever {
    void updateGoodsQaLog();
    List<TB_GOODS_QA_LOG> selectGoodsQaLog();
}
