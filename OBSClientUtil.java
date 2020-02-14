package car.car.Configuration;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.obs.services.IObsClient;
import com.obs.services.ObsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OBSClientUtil {
    private static final Logger log = LoggerFactory.getLogger(OBSClientUtil.class);
    /**华为云bucket名称*/
    private static String bucketName= "car-pictureout";
    /**华为云key*/
    private static String accessKeyId="PSAPH0ZXXCIIQGANKJWP";
    /** 华为云psw*/
    private static String accessKeySecret="cRJStaaB61F5y3uRiQkvJR9nTv8RUJwm9CElixNp";
    /** 华为内网域名*/
    private static String endpoint= "https://obs.cn-north-4.myhuaweicloud.com";

    public static ObsClient getOBSClientUtil(){
        ObsClient obsClient = new ObsClient(accessKeyId, accessKeySecret, endpoint);
        return obsClient;
    }
    public static String getBucketName() {
        return bucketName;
    }

    public static void setBucketName(String bucketName) {
        OBSClientUtil.bucketName = bucketName;
    }

    public static String getAccessKeyId() {
        return accessKeyId;
    }

    public static void setAccessKeyId(String accessKeyId) {
        OBSClientUtil.accessKeyId = accessKeyId;
    }

    public static String getAccessKeySecret() {
        return accessKeySecret;
    }

    public static void setAccessKeySecret(String accessKeySecret) {
        OBSClientUtil.accessKeySecret = accessKeySecret;
    }

    public static String getEndpoint() {
        return endpoint;
    }

    public static void setEndpoint(String endpoint) {
        OBSClientUtil.endpoint = endpoint;
    }
    public static Logger getLog() {
        return log;
    }
}
