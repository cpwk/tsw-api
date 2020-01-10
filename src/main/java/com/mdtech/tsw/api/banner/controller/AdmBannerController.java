package com.mdtech.tsw.api.banner.controller;

import com.mdtech.tsw.api.admin.authority.AdminPermission;
import com.mdtech.tsw.api.banner.model.Banner;
import com.mdtech.tsw.api.banner.qo.BannerQo;
import com.mdtech.tsw.api.banner.service.IBannerService;
import com.mdtech.tsw.common.authority.AdminType;
import com.mdtech.tsw.common.authority.RequiredPermission;
import com.mdtech.tsw.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/adm/banner")
public class AdmBannerController extends BaseController {

    @Autowired
    private IBannerService bannerService;

    @RequestMapping(value = "/save")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.BANNER_EDIT)
    public ModelAndView save(String banner) throws Exception {
        bannerService.save(parseModel(banner, new Banner()));
        return feedback(null);
    }

    @RequestMapping(value = "/remove")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.BANNER_EDIT)
    public ModelAndView remove(Integer id) throws Exception {
        bannerService.remove(id);
        return feedback(null);
    }

    @RequestMapping(value = "/banner")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.BANNER_EDIT)
    public ModelAndView banner(Integer id) throws Exception {
        return feedback(bannerService.banner(id));
    }

    @RequestMapping(value = "/banners")
    @RequiredPermission(adminType = AdminType.ADMIN, adminPermission = AdminPermission.BANNER_EDIT)
    public ModelAndView banners(String bannerQo) throws Exception {
        return feedback(bannerService.banners(parseModel(bannerQo, new BannerQo()), true));
    }

}