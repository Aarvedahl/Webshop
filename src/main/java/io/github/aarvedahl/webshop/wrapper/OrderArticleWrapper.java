package io.github.aarvedahl.webshop.wrapper;

import io.github.aarvedahl.webshop.dto.Purchasedto;
import io.github.aarvedahl.webshop.jpa.Article;

public class OrderArticleWrapper {

    private Purchasedto purchasedto;
    private Article article;

    public OrderArticleWrapper() {
    }

    public OrderArticleWrapper(Purchasedto purchasedto, Article article) {
        this.purchasedto = purchasedto;
        this.article = article;
    }

    public Purchasedto getPurchasedto() {
        return purchasedto;
    }

    public void setPurchasedto(Purchasedto purchasedto) {
        this.purchasedto = purchasedto;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
