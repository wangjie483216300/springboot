package car.car.service;

import car.car.dao.PriceDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceServer {
    @Autowired
    private PriceDao priceDao;

    public void setPrice(String VEHICLE_TYPE,int ORIGINAL_PRICE, int ANNUAL_LOSS, int SCRATGH_LOSS, int SUNKEN_LOSS, int CRACK_LOSS, int FOLD_LOSS, int PERFORATION_LOSS){
        priceDao.setPrice(VEHICLE_TYPE,ORIGINAL_PRICE,ANNUAL_LOSS,SCRATGH_LOSS,SUNKEN_LOSS,CRACK_LOSS,FOLD_LOSS,PERFORATION_LOSS);
    }
     public int getPersentPrice(String CAR_TYPE, String DANGE_POSITION ,String DANGE_PERCENT){
        int result = 0 ;
        String[] strings = DANGE_POSITION.split("");
        DANGE_POSITION = strings[0]+strings[1];
        switch (DANGE_POSITION){
            case "刮擦":
                result = (priceDao.SCRATGH_LOSS(CAR_TYPE)*Integer.parseInt(DANGE_PERCENT))/100;
                break;
            case "凹陷":
                result = (priceDao.SUNKEN_LOSS(CAR_TYPE)*Integer.parseInt(DANGE_PERCENT))/100;
                break;
            case "开裂":
                result = (priceDao.CRACK_LOSS(CAR_TYPE)*Integer.parseInt(DANGE_PERCENT))/100;
                break;
            case "褶皱":
                result = (priceDao.FOLD_LOSS(CAR_TYPE)*Integer.parseInt(DANGE_PERCENT))/100;
                break;
            case "穿孔":
                result = (priceDao.PERFORATION_LOSS(CAR_TYPE)*Integer.parseInt(DANGE_PERCENT))/100;
                break;
        }
        return result;
    }
    public int getResultPrice(String CAR_TYPE,int[] persentPrice,String year){
        int resultPrice = 0;
        resultPrice = priceDao.ORIGINAL_PRICE(CAR_TYPE) - (priceDao.ORIGINAL_PRICE(CAR_TYPE)*(2021-Integer.parseInt(year)));
        for (int i = 0 ; i < persentPrice.length ; i++ ){
           resultPrice = resultPrice - persentPrice[i] ;
        }
        return resultPrice;
    }
}
