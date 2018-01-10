package io.github.aarvedahl.webshop.jpa;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderid;

    @ManyToMany
    @JoinTable(
            name = "order_article",
            joinColumns = {
                    @JoinColumn(
                            name="orderid", // Mellantabell Kolumnen vi vill joina till
                            referencedColumnName = "orderid" // Super Tabellen
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name="articleid",
                            referencedColumnName = "articleid"
                    )
            }
    )
    private List<Article> articleList;

    @ManyToOne
    @JoinColumn(name="userid", referencedColumnName = "userid", nullable = false)
    private Users userid;

    @Column
    private Instant orderdate;

    public Order() { }

    public int getOrderid() { return orderid; }
    public void setOrderid(int orderid) { this.orderid = orderid;    }
    public List<Article> getArticleList() { return articleList; }
    public void setArticleList(List<Article> articleList) { this.articleList = articleList; }
    public Users getUserid() { return userid; }
    public void setUserid(Users userid) { this.userid = userid; }
    public Instant getOrderdate() { return orderdate; }
    public void setOrderdate(Instant orderdate) { this.orderdate = orderdate; }
}
