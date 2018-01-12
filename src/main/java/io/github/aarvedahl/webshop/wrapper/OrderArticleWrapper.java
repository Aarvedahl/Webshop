package io.github.aarvedahl.webshop.wrapper;

import io.github.aarvedahl.webshop.dto.Articledto;
import io.github.aarvedahl.webshop.dto.Purchasedto;
import io.github.aarvedahl.webshop.jpa.Article;

public class OrderArticleWrapper {

    private Purchasedto purchasedto;
    private Articledto articledto;


    public OrderArticleWrapper() {
    }

    public OrderArticleWrapper(Purchasedto purchasedto, Articledto articledto) {
        this.purchasedto = purchasedto;
        this.articledto = articledto;
    }

    public Purchasedto getPurchasedto() {
        return purchasedto;
    }

    public void setPurchasedto(Purchasedto purchasedto) {
        this.purchasedto = purchasedto;
    }

    public Articledto getArticledto() {
        return articledto;
    }

    public void setArticledto(Articledto articledto) {
        this.articledto = articledto;
    }
}
