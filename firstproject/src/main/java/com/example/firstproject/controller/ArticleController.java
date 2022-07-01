package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
public class ArticleController {

    @Autowired // 스프링부트가 미리 생성해놓은 객체를 가져다가 자동으로 연결해준다.
    private ArticleRepository articleRepository; // = new articleRepository();

    @GetMapping("/articles/new")
    public String newArticleForm(){ //폼을 보여주기 위한 메소드

        return"articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){

        log.info(form.toString());

      //  System.out.println(form.toString());

        //1. Dto 를 변환! Entity로 변환!
        Article article = form.toEntity();
        log.info(article.toString());
       // System.out.println(article.toString());

        //2. Repository에게 Entity를 DB안에 저장하게 한다.
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        //System.out.println(saved.toString());

        return"redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id , Model model ) {
        log.info("id = " + id);

        Article articleEntity = articleRepository.findById(id).orElse(null);

        model.addAttribute("article", articleEntity);


        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        List<Article> articleEntityList = (List<Article>) articleRepository.findAll();
        model.addAttribute("articleList", articleEntityList);
        return "articles/index";
    }
}