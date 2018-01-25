package io.github.aarvedahl.webshop.controllers;


import io.github.aarvedahl.webshop.dto.Articledto;
import io.github.aarvedahl.webshop.jpa.Article;
import io.github.aarvedahl.webshop.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    List<Article> articles;
    List<Articledto> articledtos;

    @GetMapping
    public List<Article> getAllArticles() {
        return getArticles();
    }

    @PutMapping
    public List<Article> updateFullArticle(@RequestBody Article article) {
        articleRepository.save(article);
        return getArticles();
    }

    @PatchMapping
    public List<Article> updateArticle(@RequestBody Article article) {
        articleRepository.save(article);
        return getArticles();
    }

    @PostMapping
    public List<Article> addArticle(@RequestBody Article article) {
        articleRepository.save(article);
        return getArticles();
    }

    @DeleteMapping
    public List<Article> deleteArticle(@RequestBody Article article) {
        articleRepository.delete(article);
        return getArticles();
    }


    public List<Article> getArticles() {
        articles = articleRepository.findAll();
        return articles;
    }

}
