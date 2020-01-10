package com.mdtech.tsw.api.custcase.model;

import com.mdtech.tsw.api.custcase.converter.CaseBannerArrayConverter;
import com.mdtech.tsw.api.custcase.entity.CaseBanner;
import com.mdtech.tsw.common.util.SimpleHtmlParser;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "custcase")
public class Custcase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "img")
    private String img;

    @Convert(converter = CaseBannerArrayConverter.class)
    @Column(name = "banners")
    private List<CaseBanner> banners;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "context")
    private String context;

    @Column(name = "customer")
    private String customer;

    @Column(name = "industry")
    private String industry;

    @Column(name = "service")
    private String service;

    @Column(name = "content")
    private String content;

    @Column(name = "settop")
    private Integer settop;

    @Column(name = "top_intro")
    private String topIntro;

    @Column(name = "top_img")
    private String topImg;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "status")
    private Integer status;

    public Custcase() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return SimpleHtmlParser.removeScript(content);
    }

    public void setContent(String content) {
        this.content = SimpleHtmlParser.removeScript(content);
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public List<CaseBanner> getBanners() {
        return banners;
    }

    public void setBanners(List<CaseBanner> banners) {
        this.banners = banners;
    }

    public Integer getSettop() {
        return settop;
    }

    public void setSettop(Integer settop) {
        this.settop = settop;
    }

    public String getTopIntro() {
        return topIntro;
    }

    public void setTopIntro(String topIntro) {
        this.topIntro = topIntro;
    }

    public String getTopImg() {
        return topImg;
    }

    public void setTopImg(String topImg) {
        this.topImg = topImg;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
