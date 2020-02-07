package com.example.demo.service;

import com.example.demo.dao.GetTypeDao;
import com.example.demo.model.User.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetTypeServer {
    @Autowired
    private GetTypeDao getTypeDao;
    public String GetType(){
        String type="";
        List<String> list=new ArrayList<>();
        list=getTypeDao.selectType();
        for (int i=0;i<list.size();i++){
            if (i==0){ }else { type=type+list.get(i-1)+"/"; }
        }
        type=type+list.get(list.size()-1);
        return type;
    }
}
