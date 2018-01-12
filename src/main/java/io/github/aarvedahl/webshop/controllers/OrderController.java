package io.github.aarvedahl.webshop.controllers;

import io.github.aarvedahl.webshop.jpa.Article;
import io.github.aarvedahl.webshop.jpa.Purchase;
import io.github.aarvedahl.webshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    List<Purchase> orders;

    @GetMapping
    public List<Purchase> getOrders() {
        orders = orderRepository.findAll();
        return orders;
    }

    @PostMapping
    public List<Purchase> makeOrder(@RequestBody Purchase purchase) {
        orderRepository.save(purchase);
        orders = orderRepository.findAll();
        return orders;
    }

    @PatchMapping
    public List<Purchase> editOrder(@RequestBody Purchase purchase) {
        orderRepository.save(purchase);
        return getOrders();
    }
}
