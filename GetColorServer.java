package com.example.demo.service;

import com.example.demo.dao.GetColorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetColorServer {
    @Autowired
    private GetColorDao getColorDao;
    public String selectColor(String type,String style){
        String color = "";
        List<String> list = new ArrayList<>();
        list = getColorDao.selectColor(type,style);
        for (int i=0;i<list.size();i++){
            if (i==0){ }else { color=color+list.get(i-1)+"/"; }
        }
        color=color+list.get(list.size()-1);
        return color;
    }
}
