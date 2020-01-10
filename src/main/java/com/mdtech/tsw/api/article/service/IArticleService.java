package com.mdtech.tsw.api.article.service;

import com.mdtech.tsw.api.article.model.Article;
import com.mdtech.tsw.api.article.qo.ArticleQo;
import com.mdtech.tsw.common.exception.ServiceException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IArticleService {

    void addVisit(int id);

    List<Article> getTopArticles(int limit);

    Article article(int id);

    Page<Article> articles(ArticleQo qo, boolean adm);

    void save(Article article) throws ServiceException;

    void remove(int id);

}
