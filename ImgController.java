package car.car.controller;

import car.car.service.ImgSerever;
import car.car.service.OSSClientServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/Img")
public class ImgController {
    @Autowired
    private OSSClientServer ossClientServer;
    @Autowired
    private ImgSerever imgSerever;
    /***
     * 上传图片到aliyunoss并同步数据库字段
     * @param file
     * @param id
     * @return
     */
    /**上传驾驶证照片A*/
    @PostMapping("/uploadDriverImgA")
    public String uploadDriverImgA(@RequestParam("file") MultipartFile file, int id) {
        return ossClientServer.uploadFileDriverImgA(file,id)+"\n"+imgSerever.InsertDriverImgA(id);
    }
    /**上传驾驶证照片B*/
    @PostMapping("/uploadDriverImgB")
    public String uploadDriverImgB(@RequestParam("file") MultipartFile file,int id) {
        return ossClientServer.uploadFileDriverImgB(file,id)+"\n"+imgSerever.InsertDriverImgB(id);
    }
    /**上传评估照片A*/
    @PostMapping("/uploadAssessmentImgA")
    public String uploadAssessmentImgA(@RequestParam("file") MultipartFile file,int id) {
        return ossClientServer.uploadFileAssessmentImgA(file,id)+"\n"+imgSerever.InsertAssessmentimga(id);
    }
    /**上传评估照片B*/
    @PostMapping("/uploadAssessmentImgB")
    public String uploadAssessmentImgB(@RequestParam("file") MultipartFile file,int id) {
        return ossClientServer.uploadFileAssessmentImgB(file,id)+"\n"+imgSerever.InsertAssessmentimgb(id);
    }
    /**上传评估照片C*/
    @PostMapping("/uploadAssessmentImgC")
    public String uploadAssessmentImgC(@RequestParam("file") MultipartFile file,int id) {
        return ossClientServer.uploadFileAssessmentImgC(file,id)+"\n"+imgSerever.InsertAssessmentimgc(id);
    }
    @ResponseBody
    @PostMapping(value = "/getDriverImgA",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] putDriverImgA(int id){
        return ossClientServer.putDriverImgA(id);
    }
    @ResponseBody
    @PostMapping(value = "/getDriverImgB",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] putDriverImgB(int id){
        return ossClientServer.putDriverImgB(id);
    }
    @ResponseBody
    @PostMapping(value = "/getAssessmentImgA",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] putAssessmentImgA(int id){
        return ossClientServer.putAssessmentImgA(id);
    }
    @ResponseBody
    @PostMapping(value = "/getAssessmentImgB",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] putAssessmentImgB(int id){
        return ossClientServer.putAssessmentImgB(id);
    }
    @ResponseBody
    @PostMapping(value = "/getAssessmentImgC",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] putAssessmentImgC(int id){
        return ossClientServer.putAssessmentImgC(id);
    }
}
