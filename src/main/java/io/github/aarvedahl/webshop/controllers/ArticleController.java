package io.github.aarvedahl.webshop.controllers;


import io.github.aarvedahl.webshop.dto.Articledto;
import io.github.aarvedahl.webshop.jpa.Article;
import io.github.aarvedahl.webshop.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

   /* @GetMapping
    public List<Article> getAllArticles() {
        return getArticles();
    } */

    @PutMapping
    public List<Article> updateFullArticle(@RequestBody Article article) {
        articleRepository.save(article);
        return getArticles();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Article>> getAll() {
        List<Article> listOfAllCustomers = articleRepository.findAll();
        if (listOfAllCustomers.size() == 0) {
            return new ResponseEntity<List<Article>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Article>>(listOfAllCustomers, HttpStatus.OK);
    }

    @PatchMapping
    public List<Article> updateArticle(@RequestBody Article article) {
        articleRepository.save(article);
        return getArticles();
    }

    @PostMapping
    public List<Article> addArticle(@RequestBody Article article) {
       // articleRepository.save(article);
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
