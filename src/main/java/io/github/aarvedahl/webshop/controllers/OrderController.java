package io.github.aarvedahl.webshop.controllers;

import io.github.aarvedahl.webshop.jpa.Order;
import io.github.aarvedahl.webshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    List<Order> orders;

    @GetMapping
    public List<Order> getOrders() {
        orders = orderRepository.findAll();
        return orders;
    }
    
}
