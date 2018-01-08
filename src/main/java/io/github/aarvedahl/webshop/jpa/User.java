package io.github.aarvedahl.webshop.jpa;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;

    @Column
    private String username;

    @Column
    private String role;

    @Column
    private String email;

    public User(String username, String role, String email) {
        this.username = username;
        this.role = role;
        this.email = email;
    }

    public User() { }

    public int getUserid() { return userid; }
    public void setUserid(int userid) { this.userid = userid; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
