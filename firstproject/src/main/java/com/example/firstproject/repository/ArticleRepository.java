package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository <Article, Long>{ //JPA에서 제공하는 CRUD 기능들을 정의 없이 사용가능하게 extends

    @Override
    ArrayList<Article> findAll();
}

