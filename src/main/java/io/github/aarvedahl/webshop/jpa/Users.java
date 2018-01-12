package io.github.aarvedahl.webshop.jpa;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private String role;

    @Column
    private String email;

    @OneToMany(mappedBy = "userid")
    private List<Purchase> orders;

    public Users() { }

    public Users(int userid) {
        this.userid = userid;
    }
    public Users(int userid, String username, String role, String email) {
        this.userid = userid;
        this.username = username;
        this.role = role;
        this.email = email;
      //  this.orders = orders;
    }

    public int getUserid() { return userid; }
    public void setUserid(int userid) { this.userid = userid; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Purchase> getOrders() { return orders; }
    public void setOrders(List<Purchase> orders) { this.orders = orders; }
}
