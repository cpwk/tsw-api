package com.mdtech.tsw.api.file.controller;

import com.mdtech.tsw.api.file.service.FileService;
import com.mdtech.tsw.api.file.service.ImgBase64Utils;
import com.mdtech.tsw.common.authority.AdminType;
import com.mdtech.tsw.common.authority.RequiredPermission;
import com.mdtech.tsw.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/ems/file")
public class EmsFileController extends BaseController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/upload_token")
    @RequiredPermission(adminType = AdminType.ADMIN)
    public ModelAndView upload_token(String fileName, int fileSize) throws Exception {
        return feedback(fileService.uploadToken("f", fileName, fileSize, true));
    }

    @RequestMapping(value = "/img_to_base64")
    @RequiredPermission(adminType = AdminType.ADMIN)
    public ModelAndView img_to_base64(String url) throws Exception {
        return feedback(ImgBase64Utils.base64FromURL(url));
    }

}
