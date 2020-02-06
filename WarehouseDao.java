package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface WarehouseDao {
    void updateWarehouse(@Param("status")int status,@Param("id")String id,@Param("goodsid") String goodsid );
    String selectID(@Param("rfid") String rfid);
    String selectStyle(@Param("id") String id);
    String selectType(@Param("id") String id);
    String selectColor(@Param("id") String id);
    String selectSize(@Param("id") String id);
}
