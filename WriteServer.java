package com.example.demo.service;

import com.example.demo.dao.WriteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WriteServer {
    @Autowired
    private WriteDao writeDao;
    public boolean goodInfo( String type, String style,  String color, String size){
        boolean state=false;
        try {
            String id = UUID.randomUUID().toString().replaceAll("-", "");
            String typeid = UUID.randomUUID().toString().replaceAll("-", "");
            String styleid = UUID.randomUUID().toString().replaceAll("-", "");
            String colorid = UUID.randomUUID().toString().replaceAll("-", "");
            String sizeid = UUID.randomUUID().toString().replaceAll("-", "");
            writeDao.goodInfo(id, type, typeid, style, styleid, color, colorid, size, sizeid);
            state=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return state;
    }
}
