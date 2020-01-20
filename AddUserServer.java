package car.car.service;

import car.car.dao.AdduserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddUserServer {
    @Autowired
    private AdduserDao adduserDao;

    public String adduser(){
        adduserDao.adduser("wangjie",22,"男",10086,"0","0",0,1);
        return "yes";
    }
}
