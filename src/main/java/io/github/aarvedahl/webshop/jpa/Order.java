package io.github.aarvedahl.webshop.jpa;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderid;

    // TODO Skapa en many to many
    @Column
    private int articleid;

    // TODO Skapa en one to many
    @Column
    private int userid;

    @Column
    private Instant orderdate;

    public Order() { }

    public int getOrderid() { return orderid; }
    public void setOrderid(int orderid) { this.orderid = orderid;    }
    public int getArticleid() { return articleid; }
    public void setArticleid(int articleid) { this.articleid = articleid; }
    public int getUserid() { return userid; }
    public void setUserid(int userid) { this.userid = userid; }
    public Instant getOrderdate() { return orderdate; }
    public void setOrderdate(Instant orderdate) { this.orderdate = orderdate; }
}
