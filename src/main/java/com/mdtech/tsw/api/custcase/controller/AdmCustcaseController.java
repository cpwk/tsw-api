package com.mdtech.tsw.api.custcase.controller;

import com.mdtech.tsw.api.admin.authority.AdminPermission;
import com.mdtech.tsw.api.custcase.model.Custcase;
import com.mdtech.tsw.api.custcase.qo.CustcaseQo;
import com.mdtech.tsw.api.custcase.service.ICustcaseService;
import com.mdtech.tsw.common.authority.AdminType;
import com.mdtech.tsw.common.authority.RequiredPermission;
import com.mdtech.tsw.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/adm/custcase")
public class AdmCustcaseController extends BaseController {

    @Autowired
    private ICustcaseService custcaseService;

    @RequestMapping(value = "/save")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.CUSTCASE_EDIT)
    public ModelAndView save(String custcase) throws Exception {
        custcaseService.save(parseModel(custcase, new Custcase()));
        return feedback(null);
    }

    @RequestMapping(value = "/remove")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.CUSTCASE_EDIT)
    public ModelAndView remove(Integer id) throws Exception {
        custcaseService.remove(id);
        return feedback(null);
    }

    @RequestMapping(value = "/custcase")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.CUSTCASE_EDIT)
    public ModelAndView custcase(Integer id) throws Exception {
        return feedback(custcaseService.custcase(id));
    }

    @RequestMapping(value = "/custcases")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.CUSTCASE_EDIT)
    public ModelAndView custcases(String custcaseQo) throws Exception {
        return feedback(custcaseService.custcases(parseModel(custcaseQo, new CustcaseQo()), true));
    }

}