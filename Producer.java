package com.company.proxy;

public class Producer implements Iproducer {
    /**
     * 销售产品
     */
    public void safe(float money){
        System.out.println("销售产品,并获得钱: "+money);
    }
    /**
     * 售后服务
     */
    public void afterSafe(float money){
        System.out.println("进行售后服务,并得钱: "+money);
    }
}
