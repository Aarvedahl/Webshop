package io.github.aarvedahl.webshop.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Users implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;

    @Column
    private String username;

    @Column
    private String password;

    @OneToMany(mappedBy = "userid", cascade=CascadeType.MERGE)
    private List<Purchase> orders;

    public Users() { }

    public Users(int userid) {
        this.userid = userid;
    }
    public Users(int userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public int getUserid() { return userid; }
    public void setUserid(int userid) { this.userid = userid; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public List<Purchase> getOrders() { return orders; }
    public void setOrders(List<Purchase> orders) { this.orders = orders; }
}
