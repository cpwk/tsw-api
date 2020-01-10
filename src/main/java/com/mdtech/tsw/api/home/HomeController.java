package com.mdtech.tsw.api.home;

import com.mdtech.tsw.api.article.model.Article;
import com.mdtech.tsw.api.article.qo.ArticleQo;
import com.mdtech.tsw.api.article.service.IArticleService;
import com.mdtech.tsw.api.banner.qo.BannerQo;
import com.mdtech.tsw.api.banner.service.IBannerService;
import com.mdtech.tsw.api.custcase.model.Custcase;
import com.mdtech.tsw.api.custcase.qo.CustcaseQo;
import com.mdtech.tsw.api.custcase.service.ICustcaseService;
import com.mdtech.tsw.api.custeval.service.ICustevalService;
import com.mdtech.tsw.common.authority.AdminType;
import com.mdtech.tsw.common.authority.RequiredPermission;
import com.mdtech.tsw.common.controller.BaseController;
import com.mdtech.tsw.common.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/usr/home")
public class HomeController extends BaseController {

    @Autowired
    private IBannerService bannerService;

    @Autowired
    private IArticleService articleService;

    @Autowired
    private ICustcaseService custcaseService;

    @Autowired
    private ICustevalService custevalService;

    @RequestMapping(value = "/home")
    @RequiredPermission(adminType = AdminType.NONE)
    public ModelAndView home() throws Exception {

        List<Custcase> cases = custcaseService.getTopCases(9);
        List<Article> articles = articleService.getTopArticles(3);
        return feedback(CollectionUtil.arrayAsMap("topCases", cases, "articles", articles));
    }

    @RequestMapping(value = "/banners")
    @RequiredPermission(adminType = AdminType.NONE)
    public ModelAndView banners(String bannerQo) throws Exception {
        return feedback(bannerService.banners(parseModel(bannerQo, new BannerQo()), false));
    }

    @RequestMapping(value = "/custcases")
    @RequiredPermission(adminType = AdminType.NONE)
    public ModelAndView custcases(String custcaseQo) throws Exception {
        return feedback(custcaseService.custcases(parseModel(custcaseQo, new CustcaseQo()), false));
    }

    @RequestMapping(value = "/custcase")
    @RequiredPermission(adminType = AdminType.NONE)
    public ModelAndView custcase(Integer id) throws Exception {
        return feedback(custcaseService.custcase(id));
    }

    @RequestMapping(value = "/custevals")
    @RequiredPermission(adminType = AdminType.NONE)
    public ModelAndView custevals(Integer limit) throws Exception {
        return feedback(custevalService.getTopCustevals(limit));
    }

    @RequestMapping(value = "/articles")
    @RequiredPermission(adminType = AdminType.NONE)
    public ModelAndView articles(String articleQo) throws Exception {
        return feedback(articleService.articles(parseModel(articleQo, new ArticleQo()), false));
    }

    @RequestMapping(value = "/article")
    @RequiredPermission(adminType = AdminType.NONE)
    public ModelAndView article(Integer id) throws Exception {
        articleService.addVisit(id);
        return feedback(articleService.article(id));
    }


}