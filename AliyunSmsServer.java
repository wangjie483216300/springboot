package car.car.service;


import com.aliyun.oss.ClientException;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.rmi.ServerException;

@Service
public class AliyunSmsServer {
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 阿里云短信服务配置
     * @param mobile
     * @return
     */
    /**短信验证登录*/
    public String sendSmsLogin(String mobile) {
        String vcode=vcode();
        String message="";
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI*********", "CKz46X****************");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "car车辆测评app");
        request.putQueryParameter("TemplateCode", "SMS_184616494");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+vcode+"\"}");
        request.putQueryParameter("SmsUpExtendCode", "90999");
        request.putQueryParameter("OutId", "abcdefgh");
        try {
            CommonResponse response = null;
            try {
                response = client.getCommonResponse(request);
                String returnstr = response.getData();
                System.out.println(returnstr);
                try {
                    JSONObject jsonObject = new JSONObject(returnstr);
                    String returnstrMessage = jsonObject.getString("Message");
                    message = "{"+"Message:"+returnstrMessage+","+"vcode:"+vcode+"}";
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (com.aliyuncs.exceptions.ClientException e) {
                e.printStackTrace();
            }
            System.out.println(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();

        }
        return message;
    }
    /**短信验证注册*/
    public String sendSmsRegist(String mobile) {
        String vcode=vcode();
        String message="";
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FnUox26oDryS2zWRNKb", "CKz46XnppOQEuVD8Kct9rCkl0HqURA");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        /**手机号*/
        request.putQueryParameter("PhoneNumbers", mobile);
        /**短信签名名称*/
        request.putQueryParameter("SignName", "car车辆测评app");
        /**短信模板id*/
        request.putQueryParameter("TemplateCode", "SMS_184631396");
        /**短信模板变量对应的实际值，JSON格式*/
        request.putQueryParameter("TemplateParam", "{\"code\":\""+vcode+"\"}");
        /**上行短信扩展码*/
        request.putQueryParameter("SmsUpExtendCode", "90999");
        /**外部流水扩展字段。*/
        request.putQueryParameter("OutId", "abcdefgh");
        try {
            CommonResponse response = null;
            try {
                response = client.getCommonResponse(request);
                String returnstr = response.getData();
                System.out.println(returnstr);
                try {
                    JSONObject jsonObject = new JSONObject(returnstr);
                    String returnstrMessage = jsonObject.getString("Message");
                    message = "{"+"Message:"+returnstrMessage+","+"vcode:"+vcode+"}";
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (com.aliyuncs.exceptions.ClientException e) {
                e.printStackTrace();
            }
            System.out.println(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return message;
    }
    /**修改手机号短信验证*/
    public String sendSmsSetphone(String mobile) {
        String vcode=vcode();
        String message="";
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FnUox26oDryS2zWRNKb", "CKz46XnppOQEuVD8Kct9rCkl0HqURA");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        /**手机号*/
        request.putQueryParameter("PhoneNumbers", mobile);
        /**短信签名名称*/
        request.putQueryParameter("SignName", "car车辆测评app");
        /**短信模板id*/
        request.putQueryParameter("TemplateCode", "SMS_184631503");
        /**短信模板变量对应的实际值，JSON格式*/
        request.putQueryParameter("TemplateParam", "{\"code\":\""+vcode+"\"}");
        /**上行短信扩展码*/
        request.putQueryParameter("SmsUpExtendCode", "90999");
        /**外部流水扩展字段。*/
        request.putQueryParameter("OutId", "abcdefgh");
        try {
            CommonResponse response = null;
            try {
                response = client.getCommonResponse(request);
                String returnstr = response.getData();
                System.out.println(returnstr);
                try {
                    JSONObject jsonObject = new JSONObject(returnstr);
                    String returnstrMessage = jsonObject.getString("Message");
                    message = "{"+"Message:"+returnstrMessage+","+"vcode:"+vcode+"}";
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (com.aliyuncs.exceptions.ClientException e) {
                e.printStackTrace();
            }
            System.out.println(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return message;
    }
    /**
     * 生成6位随机数验证码
     * @return
     */
    private static String vcode(){
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int) (Math.random() * 9);
        }
        return vcode;
    }
    /**获取验证码*/
    public  String getVcode(){
        return vcode();
    }
}



