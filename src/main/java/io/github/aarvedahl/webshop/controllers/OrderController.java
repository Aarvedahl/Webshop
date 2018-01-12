package io.github.aarvedahl.webshop.controllers;

import io.github.aarvedahl.webshop.dto.Purchasedto;
import io.github.aarvedahl.webshop.jpa.Article;
import io.github.aarvedahl.webshop.jpa.Purchase;
import io.github.aarvedahl.webshop.jpa.Purchase_article;
import io.github.aarvedahl.webshop.jpa.Users;
import io.github.aarvedahl.webshop.repository.OrderRepository;
import io.github.aarvedahl.webshop.repository.Purchase_articleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping
    public List<Purchase> makeOrder(@RequestBody Purchase purchase, @RequestBody List<Article> articles) {
        orderRepository.save(purchase);
        for(Article article: articles) {
            Purchase_article purchaseArticle = new Purchase_article(new Purchase(purchase.getOrderid()), new Article(article.getArticleid()));
            purchaseRepository.save(purchaseArticle);
        }
        orders = orderRepository.findAll();
        return orders;
    }

    @RequestMapping(value = "/addOrder")
    public void addOrder(@RequestBody Purchasedto purchasedto, @RequestBody Article article) {
        Purchase purchase = new Purchase(purchasedto.getOrderid(), new Users(purchasedto.getUserid()), purchasedto.getOrderdate(), purchasedto.isCanceled());
        orderRepository.save(purchase);
        Purchase_article purchaseArticle = new Purchase_article(new Purchase(purchase.getOrderid()), new Article(article.getArticleid()));
        purchaseRepository.save(purchaseArticle);
    }
    @PatchMapping
    public List<Purchase> editOrder(@RequestBody Purchase purchase) {
        orderRepository.save(purchase);
        return getOrders();
    }
}
