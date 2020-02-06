package com.example.demo.controller;

import com.example.demo.service.WarehouseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {
    @Autowired
    private WarehouseServer warehouseServer;
    @PostMapping("/inbound")
    public String updateWarehouse1(String tag, String type, String style, String size, String color){
        return warehouseServer.updateWarehouse1(tag, type, style, size, color);
    }
    @PostMapping("/outbound")
    public String updateWarehouse2(String tag, String type, String style, String size, String color){
        return warehouseServer.updateWarehouse2(tag, type, style, size, color);
    }
}
