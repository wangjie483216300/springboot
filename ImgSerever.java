package car.car.service;

import car.car.dao.ImgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgSerever {
    @Autowired
    private ImgDao imgDao;
    /**更新驾照图片A*/
    public String InsertDriverImgA(int id){
        /**获取文件名*/
        String imgname="DriverImgA";
        String driverimga = String.valueOf(id)+imgname;
        try {
            if (imgDao.seldriverimga(id)==null){
                imgDao.insertDRIVER_IMGA(driverimga,id);
            }else {
                imgDao.updatedriverimga(id,driverimga);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "数据库字段更新成功:"+driverimga;
    }
    /**更新驾照图片B*/
    public String InsertDriverImgB(int id){
        /**获取文件名*/
        String imgname="DriverImgB";
        String driverimgb = String.valueOf(id)+imgname;
        try {
            if (imgDao.seldriverimgb(id)==null){
                imgDao.insertDRIVER_IMGB(driverimgb, id);
            }else {
                imgDao.updatedriverimgb(id,driverimgb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "数据库字段更新成功:"+driverimgb;
    }
    /**更新评估图片A*/
    public String InsertAssessmentimga(int id){
        /**获取文件名*/
        String imgname="AssessmentImgA";
        String assessmentimga = String.valueOf(id)+imgname;
        try {
            if (imgDao.selassessmentimga(id)==null){
                imgDao.insertASSESSMENT_IMGA(assessmentimga, id);
            }else {
                imgDao.updateassessmentimga(id,assessmentimga);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "数据库字段更新成功:"+assessmentimga;
    }
    /**更新评估图片B*/
    public String InsertAssessmentimgb( int id){
        /**获取文件名*/
        String imgname="AssessmentImgB";
        String assessmentimgb = String.valueOf(id)+imgname;
        try {
            if (imgDao.selassessmentimgb(id)==null){
                imgDao.insertASSESSMENT_IMGB(assessmentimgb, id);
            }else {
                imgDao.updateassessmentimgb(id,assessmentimgb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "数据库字段更新成功:"+assessmentimgb;
    }
    /**更新评估图片C*/
    public String InsertAssessmentimgc( int id){
        /**获取文件名*/
        String imgname="AssessmentImgC";
        String assessmentimgc = String.valueOf(id)+imgname;
        try {
            if (imgDao.selassessmentimgc(id)==null){
                imgDao.insertASSESSMENT_IMGC(assessmentimgc, id);
            }else {
                imgDao.updateassessmentimgc(id,assessmentimgc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "数据库字段更新成功:"+assessmentimgc;
    }
}
