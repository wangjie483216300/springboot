package com.example.demo.dao;


import com.example.demo.model.TB_GOODS_QA_LOG;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository//Spring的注解形式：@Repository、@Service、@Controller，它们分别对应存储层Bean，业务层Bean，和展示层Bean。
public interface GoodsQaLogDao {

    @Select(" select * from TB_GOODS_QA_LOG where ID = #{id}")
    TB_GOODS_QA_LOG selectGoodsQaLog(int id, String uuid);

    @Update({"UPDATE TB_GOODS_QA_LOG SET STATUS=#{status} WHERE #{id}=110"})
    void updateGoodsQaLog(int status,int id,String uuid);
}
