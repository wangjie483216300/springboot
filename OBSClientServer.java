package car.car.service;

import car.car.Configuration.OBSClientUtil;
import car.car.Configuration.OSSClientUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.model.ObjectMetadata;
import com.obs.services.IObsClient;
import com.obs.services.ObsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamClass;

@Service
public class OBSClientServer {
    private static final Logger log = LoggerFactory.getLogger(OBSClientUtil.class);
    @Autowired
    private OBSClientUtil obsClientUtil;
    public String uploadFileDriverImgA(MultipartFile file, int id) {
        /**获取文件名*/
        String imgname="DriverImgA";
        String filename = String.valueOf(id)+imgname;
        /**数据流*/
        InputStream inputStream = null;
        /**obs对象*/
//        OBS obs=null;
        ObsClient obsClient = null;
        try {
            /**获取数据流*/
            inputStream=file.getInputStream();
            /**创建oss对象*/
            obsClient = obsClientUtil.getOBSClientUtil();
            /**上传文件*/
            obsClient.putObject(OBSClientUtil.getBucketName(), filename, inputStream);
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        } finally {
            try {
                if (inputStream != null) {
                    /**关闭数据流*/
                    inputStream.close();
                    obsClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "obs上传成功:"+filename;
    }

}
