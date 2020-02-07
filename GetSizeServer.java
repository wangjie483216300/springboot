package com.example.demo.service;

import com.example.demo.dao.GetSizeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetSizeServer {
    @Autowired
    private GetSizeDao getSizeDao;
    public String getSize(String type,String style,String color){
        String size = "";
        List<String> list = new ArrayList<>();
        list = getSizeDao.selectSize(type, style, color);
        for (int i=0;i<list.size();i++){
            if (i==0){ }else { size=size+list.get(i-1)+"/"; }
        }
        size=size+list.get(list.size()-1);
        return size;
    }
}
