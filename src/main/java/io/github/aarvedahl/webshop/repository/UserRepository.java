package io.github.aarvedahl.webshop.repository;

import io.github.aarvedahl.webshop.jpa.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUserid(int userid);

    Users findByUsername(String username);
}
