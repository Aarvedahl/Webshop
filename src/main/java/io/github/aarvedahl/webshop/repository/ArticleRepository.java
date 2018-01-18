package io.github.aarvedahl.webshop.repository;

import io.github.aarvedahl.webshop.jpa.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByArticleid(int articleid);
}
