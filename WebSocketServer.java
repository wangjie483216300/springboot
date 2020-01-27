package com.example.demo.service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
@Component
@Slf4j
@ServerEndpoint("/websocket/{id}")
public class WebSocketServer {
//    private static Logger log;
    /**
     *与某个客户端的连接会话,给客户端发送数据
     */
    private Session session;
    /**
     * 接收当前客户端id
     */
    private String id="";
    /**
     * 存放每个客户端对应的websocket对象
     */
    private static CopyOnWriteArrayList<WebSocketServer> webSocketset = new CopyOnWriteArrayList<>();
    /**
     * 建立连接成功调用的方法
     * @param session
     * @param id
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("id") String id){
        this.session=session;
        //加入set中
        webSocketset.add(this);
        this.id=id;
        try {
            sendMessage("连接成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @OnClose
    public void onClose(){
        webSocketset.remove(this.id);
//        log.info("连接关闭");
        System.out.println("连接关闭");

    }
    @OnMessage
    public void onMessage(String message){
        sendInfo(id,message);
//        log.info("来自客户端消息");
        System.out.println("来自客户端消息为:"+message);
    }
    @OnError
    public void onError(){
//        log.error("错误{}");
        System.out.println("链接发生错误!");
    }

    /**
     * 服务器自定义推送
     * @param message
     */
    public void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 发消息
     * @param message
     */
    public  void sendInfo(String message,@PathParam("id") String id) {
        for (WebSocketServer item : webSocketset) {
            try {
                //这里可以设定只推送给这个sid的，为null则全部推送
                if(id==null) {
                    item.sendMessage(message);
                }else if(item.id.equals(id)){
                    item.sendMessage(message);
                }
            } catch (Exception e) {
                continue;
            }
        }
    }
}
