package io.github.aarvedahl.webshop.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Purchase_article implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="orderid", referencedColumnName = "orderid", nullable = false)
    private Purchase orderid;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="articleid", referencedColumnName = "articleid", nullable = false)
    private Article articleid;

    public Purchase_article(Purchase orderid, Article articleid) {
        this.orderid = orderid;
        this.articleid = articleid;
    }

    public Purchase_article() { }

    public Purchase getOrderid() { return orderid; }
    public void setOrderid(Purchase orderid) { this.orderid = orderid; }
    public Article getArticleid() { return articleid; }
    public void setArticleid(Article articleid) { this.articleid = articleid; }



    }




