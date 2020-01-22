package com.example.demo.controller;

import com.example.demo.service.WriteServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/write")
public class WriteController {
    @Autowired
    private WriteServer writeServer;

    @PostMapping("/goodInfo")
    boolean goodInfo(String type,String style,String color,String size){
        return writeServer.goodInfo(type,style,color,size);
    }
}
