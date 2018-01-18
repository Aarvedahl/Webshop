package io.github.aarvedahl.webshop.controllers;

import io.github.aarvedahl.webshop.jpa.Article;
import io.github.aarvedahl.webshop.jpa.Purchase;
import io.github.aarvedahl.webshop.jpa.Purchase_article;
import io.github.aarvedahl.webshop.jpa.Users;
import io.github.aarvedahl.webshop.repository.OrderRepository;
import io.github.aarvedahl.webshop.repository.Purchase_articleRepository;
import io.github.aarvedahl.webshop.wrapper.OrderArticleWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired OrderRepository orderRepository;
    @Autowired Purchase_articleRepository purchaseRepository;

    List<Purchase> orders;

    @GetMapping
    public List<Purchase> getOrders() {
        orders = orderRepository.findAll();
        return orders;
    }

    @RequestMapping(value = "/addOrder")
    public List<Purchase> makeOrder(@RequestBody Purchase purchase, @RequestBody List<Article> articles) {
        orderRepository.save(purchase);
        for(Article article: articles) {
            Purchase_article purchaseArticle = new Purchase_article(new Purchase(purchase.getOrderid()), new Article(article.getArticleid()));
            purchaseRepository.save(purchaseArticle);
        }
        orders = orderRepository.findAll();
        return orders;
    }

    @PostMapping
    public void addOrder(@RequestBody OrderArticleWrapper orderArticleWrapper) {
        Purchase purchase = new Purchase(orderArticleWrapper.getPurchasedto().getOrderid(), new Users(orderArticleWrapper.getPurchasedto().getUserid()), orderArticleWrapper.getPurchasedto().getOrderdate(), orderArticleWrapper.getPurchasedto().isCanceled());
        orderRepository.save(purchase);
        Purchase_article purchaseArticle = new Purchase_article(new Purchase(purchase.getOrderid()), new Article(orderArticleWrapper.getArticledto().getArticleid()));
        purchaseRepository.save(purchaseArticle);
    }

    @PatchMapping
    public void editOrder(@RequestBody OrderArticleWrapper orderArticleWrapper) {
        Purchase purchase = new Purchase(orderArticleWrapper.getPurchasedto().getOrderid(), new Users(orderArticleWrapper.getPurchasedto().getUserid()), orderArticleWrapper.getPurchasedto().getOrderdate(), orderArticleWrapper.getPurchasedto().isCanceled());
        orderRepository.save(purchase);
        Purchase_article purchaseArticle = new Purchase_article(new Purchase(purchase.getOrderid()), new Article(orderArticleWrapper.getArticledto().getArticleid()));
        purchaseRepository.save(purchaseArticle);
    }
    /*
    {
        "purchasedto": {
            "orderdate": 1515538800000,
            "canceled": false,
             "userid":4
        },
        "articledto": {
            "articleid": 2,
            "articlename": "Amazon Echo Dot (2nd Generation)",
            "description": "Play music from Amazon Music, Spotify, Pandora, iHeartRadio, and TuneIn.",
            "price": 699,
            "stock": 72,
            "brand": "Amazon"
        }
    }


     */
}
