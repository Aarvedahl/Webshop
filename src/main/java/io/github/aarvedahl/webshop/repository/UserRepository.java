package io.github.aarvedahl.webshop.repository;

import io.github.aarvedahl.webshop.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
