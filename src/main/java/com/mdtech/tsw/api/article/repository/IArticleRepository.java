package com.mdtech.tsw.api.article.repository;

import com.mdtech.tsw.api.article.model.Article;
import com.mdtech.tsw.common.reposiotry.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IArticleRepository extends BaseRepository<Article, Integer> {

    @Transactional
    @Modifying
    @Query("update Article set visit= visit+1 where id =:id")
    public void addVisit(@Param(value = "id") Integer id);

}