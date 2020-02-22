package car.car.service;

import car.car.Configuration.Access_token;
import car.car.Configuration.OSSClientUtil;
import car.car.Util.Base64Util;
import car.car.Util.FileUtil;
import car.car.Util.HttpUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.model.OSSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import static org.apache.commons.codec.binary.Hex.DEFAULT_CHARSET;

@Service
public class GetmodelsServer {
    @Autowired
    private OSSClientServer ossClientServer;

    public String getModels(int id) {
        String result = "";
        // 获取token
        String accessToken = Access_token.getAuth();
        // 通用识别url
        String otherHost = "https://aip.baidubce.com/rest/2.0/image-classify/v1/car";
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
        return result;
    }
}
