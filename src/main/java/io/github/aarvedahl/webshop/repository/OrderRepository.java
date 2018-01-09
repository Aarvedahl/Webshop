package io.github.aarvedahl.webshop.repository;

import io.github.aarvedahl.webshop.jpa.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
