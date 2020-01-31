package car.car.service;

import car.car.Configuration.OSSClientUtil;
import com.aliyun.oss.OSS;
import com.aliyun.oss.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.List;

@Service
public class OSSClientServer {
    private static final Logger log = LoggerFactory.getLogger(OSSClientUtil.class);
    @Autowired
    private OSSClientUtil ossClientUtil;
    /***
     * 上传图片到aliyunoss
     * @param file
     * @return
     */
    public URL uploadFile(MultipartFile file) {
        /**url*/
        URL url = null;
        /**获取文件名*/
        String filename = file.getOriginalFilename();
        /**数据流*/
        InputStream inputStream = null;
        /**oss对象*/
        OSS ossClient = null;
        try {
            /**获取数据流*/
            inputStream=file.getInputStream();
            /**创建oss对象*/
            ossClient = ossClientUtil.getOSSClientUtil();
            /**创建上传Object的Metadata*/
            ObjectMetadata objectMetadata = new ObjectMetadata();
            /**设置ContentLengt*/
            objectMetadata.setContentLength(inputStream.available());
            /**上传文件*/
            ossClient.putObject(OSSClientUtil.getBucketName(), filename, inputStream, objectMetadata);
            /**设置URl过期时间为1小时*/
            Date expiration = new Date(new Date().getTime() + 3600L * 1000L);
            /**生成url*/
            url= ossClient.generatePresignedUrl(OSSClientUtil.getBucketName(),filename,expiration);
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        } finally {
            try {
                if (inputStream != null) {
                    /**关闭数据流*/
                    inputStream.close();
                    ossClient.shutdown();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return url;
    }
    /***
     *获取图片并返回图片
     * @param filename
     * @return
     */
    public byte[] putImg(String filename){
        OSS ossClient;
        OSSObject ossObject;
        InputStream inputStream;
        byte[] btImg = new byte[0];
        try {
            ossClient=OSSClientUtil.getOSSClientUtil();
            ossObject= ossClient.getObject(OSSClientUtil.getBucketName(), filename);
            inputStream =ossObject.getObjectContent();
            btImg = readInputStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return btImg;
    }
    /**转换byte[]*/
    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }
}
