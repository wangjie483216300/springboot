package car.car.controller;

import car.car.service.ImgSerever;
import car.car.service.OBSClientServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/test")
public class OBSController {
    @Autowired
    private OBSClientServer obsClientServer ;
    @Autowired
    private ImgSerever imgSerever;
    @PostMapping("/uploadDriverImgA")
    public String uploadDriverImgA(@RequestParam("file") MultipartFile file, int id) {
        return obsClientServer.uploadFileDriverImgA(file,id)+"\n"+imgSerever.InsertDriverImgA(id);
    }
}
