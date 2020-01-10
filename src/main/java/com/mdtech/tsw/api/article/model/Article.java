package com.mdtech.tsw.api.article.model;

import com.mdtech.tsw.common.util.SimpleHtmlParser;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "img")
    private String img;

    @Column(name = "intro")
    private String intro;

    @Column(name = "content")
    private String content = "";

    @Column(name = "created_at")
    private Long createdAt;

    @Column(name = "status")
    private Integer status;

    @Column(name = "visit")
    private Integer visit;

    public Article() {
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

    public Integer getVisit() {
        return visit;
    }

    public void setVisit(Integer visit) {
        this.visit = visit;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
