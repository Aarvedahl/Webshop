package io.github.aarvedahl.webshop.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(User_roles.class)
public class User_roles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String username;

    @Id
    private String role;

    public User_roles(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public User_roles() { }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
