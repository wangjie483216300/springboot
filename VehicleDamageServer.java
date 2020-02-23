package car.car.service;

import car.car.Configuration.Access_token;
import car.car.Util.Base64Util;
import car.car.Util.FileUtil;
import car.car.Util.HttpUtil;
import com.google.gson.JsonObject;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
@Service
public class VehicleDamageServer {
    @Autowired
    private OSSClientServer ossClientServer;
    public String getVehicleDamage(int id){
        String result = "";
        String car = "";
        String car1 = "";
        String parts = "";
        String type = "";
        String probability = "";

        // 获取token
        String accessToken = Access_token.getAuth();
        // 通用识别url
        String otherHost = "https://aip.baidubce.com/rest/2.0/image-classify/v1/vehicle_damage";
        try {
            //读取本地图片输入流
//            String filePath = "/home/wangjie/Pictures/car/123.jpeg";
            byte[] imgData = ossClientServer.putDriverImgA(id);
            String base = Base64Util.encode(imgData);
            System.err.println(base);
            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(base, "UTF-8");
            /**
             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
             */
//            String accessToken = "#####调用鉴权接口获取的token#####";
            result = HttpUtil.post(otherHost, accessToken, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = null;
        JSONObject jsonObject1 = null;
        JSONObject jsonObject2 = null;
        JSONObject jsonObject3 = null;
        try {
          jsonObject = new JSONObject(result);
          String result1 = jsonObject.getString("result");
          jsonObject1 = new JSONObject(result1);
          String damage_info = jsonObject1.getString("damage_info");
          String[] damage_infostr = damage_info.split("");
          String damage_info1 = "";
          for (int j = 2 ; j < (damage_infostr.length-2) ; j++ ){
              damage_info1 =damage_info1+damage_infostr[j];
          }
          System.out.println("hahahah  "+damage_info1);
          damage_info1 = "{"+damage_info1+"}";
          System.out.println("123"+damage_info1);
          String[] strings = damage_info1.split("},");
          for (int i = 0 ; i<strings.length ;i++ ){
              int f=i+1;
               if (i==(strings.length-1)){
                   jsonObject2 = new JSONObject(strings[i]);
                   parts = ",车损部位"+"("+f+")"+":"+jsonObject2.getString("parts");
                   type = ",车损类型"+"("+f+")"+":"+jsonObject2.getString("type");
                   probability = ",车损情况百分比"+"("+f+")"+":"+jsonObject2.getString("probability")+"%";
               }else {
                   jsonObject2 = new JSONObject(strings[i]+"}");
                   parts = ",车损部位"+"("+f+")"+":"+jsonObject2.getString("parts");
                   type = ",车损类型"+"("+f+")"+":"+jsonObject2.getString("type");
                   probability = ",车损情况百分比"+"("+f+")"+":"+jsonObject2.getString("probability")+"%";
               }
               car = car+parts+type+probability;
              System.out.println(car);
          }
          String[] carstr = car.split("");
          for (int k = 1;k<carstr.length;k++){ car1 = car1 + carstr[k];}
          car1 = "{"+car1+"}";
          jsonObject3 = new JSONObject(car1);
          car1 = jsonObject3.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("dd"+car1);
        System.out.println("\n\n"+""+result);
        return car1;
    }
}

