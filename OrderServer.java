package car.car.service;

import car.car.dao.OrderDao;
import car.car.dao.SelectEvaDao;
import com.google.gson.JsonObject;
import org.apache.ibatis.annotations.Param;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServer {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private SelectEvaDao selectEvaDao;
    /**下订单*/
    public String placingOrder(int EVA_ID,String EVA_NAME,int ORDINARY_ID,String ORD_NAME){
        String state = "true";
        try {
            String id = UUID.randomUUID().toString().replaceAll("-", "");
            orderDao.insertOrder(id,EVA_ID,EVA_NAME,ORDINARY_ID,ORD_NAME);

        } catch (Exception e) {
            e.printStackTrace();
            state="false";
        }
       return state;
    }
    /**用户查询订单个数---->返回估价师id,用户名,数组*/
    public List<String> generalQuery(int ORDINARY_ID){
        List<String> list = new ArrayList<>();
        try {
            for (int i = 0 ; i < orderDao.selectEVAID1(ORDINARY_ID).length; i++ ){
                int id = orderDao.selectEVAID1(ORDINARY_ID)[i];
                String username = orderDao.selectEVAUSERNAME(id);
                try {
                    JSONObject jsonObject = new JSONObject("{"+"ID:"+id+","+"用户名:"+username+"}");
                    list.add(jsonObject.toString());
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception e) {
            int id = orderDao.selectEVAID2(ORDINARY_ID);
            String username = orderDao.selectEVAUSERNAME(id);
            try {
                JSONObject jsonObject = new JSONObject("{"+"ID:"+id+","+"用户名:"+username+"}");
                list.add(jsonObject.toString());
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return list;
    }
    /**估价师对订单进行编辑*/
    public String Assessment(String CAR_TYPE, String CAR_COLOR, String CAR_YEAR,List<String> list,String CAR_VALUE,int EVA_ID,int ORDINARY_ID){
        String state = "true";
        String DANGE_POSITION1="";
        String DANGE_TYPE1="";
        String DANGE_PERCENT1="";
        String CAR_LOSS1="";
        try {
            List<String> DANGE_POSITION = new ArrayList<>();
            List<String> DANGE_TYPE = new ArrayList<>();
            List<String> DANGE_PERCENT = new ArrayList<>();
            List<String> CAR_LOSS = new ArrayList<>();
            for (int i= 0 ;i < list.size() ; i++ ){
                JSONObject jsonObject = new JSONObject(list.get(i));
                DANGE_POSITION.add(jsonObject.getString("受损部位"));
                DANGE_TYPE.add(jsonObject.getString("受损类型"));
                DANGE_PERCENT.add(jsonObject.getString("受损百分比"));
                CAR_LOSS.add(jsonObject.getString("受损价值"));
            }
            for (int j = 0 ; j < list.size() ; j++ ){
                if (j!=(list.size()-1)){
                    DANGE_POSITION1 = DANGE_POSITION1 + DANGE_POSITION.get(j)+",";
                    DANGE_TYPE1 = DANGE_TYPE1+DANGE_TYPE.get(j)+",";
                    DANGE_PERCENT1 = DANGE_PERCENT1+DANGE_PERCENT.get(j)+",";
                    CAR_LOSS1 = CAR_LOSS1 + CAR_LOSS.get(j)+",";
                }else {
                    DANGE_POSITION1 = DANGE_POSITION1 + DANGE_POSITION.get(j);
                    DANGE_TYPE1 = DANGE_TYPE1+DANGE_TYPE.get(j);
                    DANGE_PERCENT1 = DANGE_PERCENT1+DANGE_PERCENT.get(j);
                    CAR_LOSS1 = CAR_LOSS1 + CAR_LOSS.get(j);
                }
            }
            DANGE_POSITION1 = "{"+DANGE_POSITION1+"}";
            DANGE_TYPE1 = "{"+DANGE_TYPE1+"}";
            DANGE_PERCENT1 = "{"+DANGE_PERCENT1+"}";
            CAR_LOSS1 = "{"+CAR_LOSS1+"}";
            orderDao.Assessment(CAR_TYPE,CAR_COLOR,CAR_YEAR,DANGE_POSITION1,DANGE_TYPE1,DANGE_PERCENT1,CAR_LOSS1,CAR_VALUE,EVA_ID,ORDINARY_ID);
        } catch (Exception e) {
            state = "false";
            e.printStackTrace();
        }
        return state;
    }
}
