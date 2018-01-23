package io.github.aarvedahl.webshop.controllers;

import io.github.aarvedahl.webshop.dto.Purchasedto;
import io.github.aarvedahl.webshop.jpa.Article;
import io.github.aarvedahl.webshop.jpa.Purchase;
import io.github.aarvedahl.webshop.jpa.Purchase_article;
import io.github.aarvedahl.webshop.jpa.Users;
import io.github.aarvedahl.webshop.repository.OrderRepository;
import io.github.aarvedahl.webshop.repository.Purchase_articleRepository;
import io.github.aarvedahl.webshop.repository.UserRepository;
import io.github.aarvedahl.webshop.wrapper.OrderArticleWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired OrderRepository orderRepository;
    @Autowired Purchase_articleRepository purchaseRepository;
    @Autowired UserRepository userRepository;

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
   public void makePurchase(@RequestBody List<Article> articles) {
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       Users users = userRepository.findByUsername(auth.getName());
       Purchase purchase = new Purchase(new Date(), false, new Users(users.getUserid()));
       orderRepository.save(purchase);
       for(Article article: articles) {
           Purchase_article purchase_article = new Purchase_article(new Purchase(purchase.getOrderid()), new Article(article.getArticleid()));
           purchaseRepository.save(purchase_article);
       }
   }

    @PatchMapping
    public void editPurchase(@RequestBody Purchasedto purchasedto) {
        Purchase purchase = new Purchase(purchasedto.getOrderid(), new Users(purchasedto.getUserid()), purchasedto.getOrderdate(), purchasedto.isCanceled());
        orderRepository.save(purchase);
    }

    /* Så här får vi tag på användarnamn

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        System.out.println(name);
     */

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
