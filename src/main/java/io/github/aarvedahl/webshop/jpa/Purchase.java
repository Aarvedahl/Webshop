package io.github.aarvedahl.webshop.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Purchase implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderid;

    @Column
    private Date orderdate;

    @Column
    private boolean canceled;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="userid", referencedColumnName = "userid", nullable = false)
    private Users userid;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "purchase_article",
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

    public Purchase() { }
    public Purchase(Users userid, Date orderdate, Boolean canceled) {
        this.userid = userid;
        this.orderdate = orderdate;
        this.canceled = canceled;
    }
    public int getOrderid() { return orderid; }
    public void setOrderid(int orderid) { this.orderid = orderid; }
    public Users getUserid() { return userid; }
    public void setUserid(Users userid) { this.userid = userid; }
    public Date getOrderdate() { return orderdate; }
    public boolean getCanceled() { return canceled; }
    public void setCanceled(boolean canceled) { this.canceled = canceled; }
    public void setOrderdate(Date orderdate) { this.orderdate = orderdate; }
}
