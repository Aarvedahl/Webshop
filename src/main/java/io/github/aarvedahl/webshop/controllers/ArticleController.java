package io.github.aarvedahl.webshop.controllers;


import io.github.aarvedahl.webshop.dto.Articledto;
import io.github.aarvedahl.webshop.jpa.Article;
import io.github.aarvedahl.webshop.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    List<Article> articles;
    List<Articledto> articledtos;

    @GetMapping
    public List<Article> getAllArticles() {
        return getArticles();
    }

    @PatchMapping
    public void updateArticle(@RequestBody Article article) {
        articleRepository.save(article);
    }

    @PostMapping
    public void addArticle(@RequestBody Article article) {
        articleRepository.save(article);
    }

    @DeleteMapping
    public void deleteArticle(@RequestBody Article article) {
        articleRepository.delete(article);
    }

    public List<Article> getArticles() {
        if(articles == null) {
            articles = articleRepository.findAll();
        }
        return articles;
    }

    public List<Articledto> getArticledtos() {
        if(articledtos == null) {
            articledtos = new LinkedList<>();
            for(Article article: getArticles()) {
                Articledto articledto = new Articledto(article.getArticleid(), article.getArticlename(), article.getDescription(), article.getPrice(), article.getStock(), article.getBrand());
                articledtos.add(articledto);
            }
        }
        return articledtos;
    }
}
