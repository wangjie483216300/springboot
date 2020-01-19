package car.car.service;

import car.car.bean.Message;
import car.car.bean.PERSONAL_CENTER;
import car.car.bean.User;
import car.car.dao.RegistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistSever {
    @Autowired
    private RegistDao registDao;
    /**
     * 注册
     * @return
     */
    public Message regist(){
        User user=new User();
        Message message=new Message();
        message.setSuccess(false);
        try {
            int id = registDao.findid(3);
            if (id==0){
                registDao.regist(3,3,1);
                user.setID(registDao.getid(3));
                user.setPASSWORD(registDao.getpsw(3));
                user.setORDINARY_OR_SPECIAL(registDao.getoos(3));
                System.out.println(registDao.getoos(3));
                if (registDao.getoos(3)==1){
                    message.setMsg("您注册为估价师!");
                }else {
                    message.setMsg("您注册为普通户!");
                }
                message.setSuccess(true);
                message.setDetail(user);
            }else {
                message.setMsg("用户已存在,请返回登录!");
                message.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}
