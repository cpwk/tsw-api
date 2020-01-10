package com.mdtech.tsw.api.custeval.controller;

import com.mdtech.tsw.api.admin.authority.AdminPermission;
import com.mdtech.tsw.api.custeval.model.Custeval;
import com.mdtech.tsw.api.custeval.qo.CustevalQo;
import com.mdtech.tsw.api.custeval.service.ICustevalService;
import com.mdtech.tsw.common.authority.AdminType;
import com.mdtech.tsw.common.authority.RequiredPermission;
import com.mdtech.tsw.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/adm/custeval")
public class AdmCustevalController extends BaseController {

    @Autowired
    private ICustevalService custevalService;

    @RequestMapping(value = "/save")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.CUSTEVAL_EDIT)
    public ModelAndView save(String custeval) throws Exception {
        custevalService.save(parseModel(custeval, new Custeval()));
        return feedback(null);
    }

    @RequestMapping(value = "/remove")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.CUSTEVAL_EDIT)
    public ModelAndView remove(Integer id) throws Exception {
        custevalService.remove(id);
        return feedback(null);
    }

    @RequestMapping(value = "/custeval")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.CUSTEVAL_EDIT)
    public ModelAndView article(Integer id) throws Exception {
        return feedback(custevalService.custeval(id));
    }

    @RequestMapping(value = "/custevals")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.CUSTEVAL_EDIT)
    public ModelAndView articles(String custevalQo) throws Exception {
        return feedback(custevalService.custevals(parseModel(custevalQo, new CustevalQo()), true));
    }

}