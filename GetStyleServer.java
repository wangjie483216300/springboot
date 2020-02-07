package com.example.demo.service;

import com.example.demo.dao.GetStyleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetStyleServer {
    @Autowired
    private GetStyleDao getStyleDao;

    public String getStyle(String type){
        String style="";
        List<String> list = new ArrayList<>();
        list=getStyleDao.selectStyle(type);
        for (int i=0;i<list.size();i++){
            if (i==0){ }else { style=style+list.get(i-1)+"/"; }
        }
        style=style+list.get(list.size()-1);
        return style;
    }
}
