package car.car.service;

import car.car.Configuration.OSSClientUtil;
import car.car.dao.ImgDao;
import car.car.dao.PersonalDado;
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

@Service
public class OSSClientServer {
    private static final Logger log = LoggerFactory.getLogger(OSSClientUtil.class);
    @Autowired
    private OSSClientUtil ossClientUtil;
    /**上传驾照图片A-aliyunoss*/
    public String uploadFileDriverImgA(MultipartFile file,int id) {
        /**获取文件名*/
//        String originalFilename=file.getOriginalFilename();
//        /**获取最后一个.的位置*/
//        int lastIndexOf = originalFilename.lastIndexOf(".");
//        /**获取文件的后缀名*/
//        String suffix = originalFilename.substring(lastIndexOf);
//        /**获取文件名*/
//        String imgname="DriverImgA"+suffix;
        String imgname="DriverImgA";
        String filename = String.valueOf(id)+imgname;
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
        return "oss上传成功:"+filename;
    }
    /**上传驾照图片B-aliyunoss*/
    public String uploadFileDriverImgB(MultipartFile file,int id) {
        /**获取文件名*/
//        String originalFilename=file.getOriginalFilename();
//        /**获取最后一个.的位置*/
//        int lastIndexOf = originalFilename.lastIndexOf(".");
//        /**获取文件的后缀名*/
//        String suffix = originalFilename.substring(lastIndexOf);
//        /**获取文件名*/
//        String imgname="DriverImgB"+suffix;
        String imgname="DriverImgB";
        String filename = String.valueOf(id)+imgname;
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
        return "上传成功:"+filename;
    }
    /**上传评估图片A-aliyunoss*/
    public String uploadFileAssessmentImgA(MultipartFile file,int id) {
//        /**获取文件名*/
//        String originalFilename=file.getOriginalFilename();
//        /**获取最后一个.的位置*/
//        int lastIndexOf = originalFilename.lastIndexOf(".");
//        /**获取文件的后缀名*/
//        String suffix = originalFilename.substring(lastIndexOf);
//        /**获取文件名*/
//        String imgname="AssessmentImgA"+suffix;
        String imgname="AssessmentImgA";
        String filename = String.valueOf(id)+imgname;
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
        return "oss上传成功:"+filename;
    }
    /**上传评估图片B-aliyunoss*/
    public String uploadFileAssessmentImgB(MultipartFile file,int id) {
        /**获取文件名*/
//        String originalFilename=file.getOriginalFilename();
////        /**获取最后一个.的位置*/
////        int lastIndexOf = originalFilename.lastIndexOf(".");
////        /**获取文件的后缀名*/
////        String suffix = originalFilename.substring(lastIndexOf);
////        /**获取文件名*/
////        String imgname="AssessmentImgB"+suffix;
        String imgname="AssessmentImgB";
        String filename = String.valueOf(id)+imgname;
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
        return "oss上传成功:"+filename;
    }
    /**上传评估图片C-aliyunoss*/
    public String uploadFileAssessmentImgC(MultipartFile file,int id) {
//        /**获取文件名*/
//        String originalFilename=file.getOriginalFilename();
//        /**获取最后一个.的位置*/
//        int lastIndexOf = originalFilename.lastIndexOf(".");
//        /**获取文件的后缀名*/
//        String suffix = originalFilename.substring(lastIndexOf);
//        /**获取文件名*/
//        String imgname="AssessmentImgC"+suffix;
        String imgname="AssessmentImgC";
        String filename = String.valueOf(id)+imgname;
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
        return "oss上传成功:"+filename;
    }


    /**oss-获取驾驶证图片A并返回图片*/
    public byte[] putDriverImgA(int id){
        String imgname="DriverImgA";
        String filename= String.valueOf(id)+imgname;
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
    /**oss-获取驾驶证图片A并返回图片*/
    public byte[] putDriverImgB(int id){
        String imgname="DriverImgB";
        String filename= String.valueOf(id)+imgname;
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
    /**oss-获取驾驶证图片A并返回图片*/
    public byte[] putAssessmentImgA(int id){
        String imgname="AssessmentImgA";
        String filename= String.valueOf(id)+imgname;
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
    /**oss-获取驾驶证图片A并返回图片*/
    public byte[] putAssessmentImgB(int id){
        String imgname="AssessmentImgB";
        String filename= String.valueOf(id)+imgname;
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
    /**oss-获取驾驶证图片A并返回图片*/
    public byte[] putAssessmentImgC(int id){
        String imgname="AssessmentImgC";
        String filename= String.valueOf(id)+imgname;
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
