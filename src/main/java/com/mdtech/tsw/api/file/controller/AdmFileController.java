package com.mdtech.tsw.api.file.controller;

import com.mdtech.tsw.api.admin.authority.AdminPermission;
import com.mdtech.tsw.api.file.service.FileService;
import com.mdtech.tsw.common.authority.AdminType;
import com.mdtech.tsw.common.authority.RequiredPermission;
import com.mdtech.tsw.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/adm/file")
public class AdmFileController extends BaseController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/upload_token")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.NONE)
    public ModelAndView upload_token(String fileName, int fileSize) throws Exception {
        return feedback(fileService.uploadToken("f", fileName, fileSize, true));
    }

}
