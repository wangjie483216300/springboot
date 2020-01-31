package car.car.controller;

import car.car.service.OSSClientServer;
import com.aliyun.oss.model.OSSObjectSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/image")
public class putImgController {
    @Autowired
    private OSSClientServer ossClientServer;
    @ResponseBody
    @PostMapping(value = "/getImg",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] putImg( String filename){
        return ossClientServer.putImg(filename);
    }
}
