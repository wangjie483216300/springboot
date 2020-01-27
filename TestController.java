package com.example.demo.controller;

import com.example.demo.service.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @Autowired
    private WebSocketServer webSocketServer;
    @GetMapping("/index/{id}")
    public ModelAndView socket(@PathVariable String id) {
        ModelAndView mav=new ModelAndView("/websocket/{id}");
        mav.addObject("id", id);
        return mav;
    }
    @ResponseBody
    @GetMapping("/sendMessage/{id}")
    public void sendMessage( String message, @PathVariable String id){
        webSocketServer.sendInfo(message,id);
    }
}
