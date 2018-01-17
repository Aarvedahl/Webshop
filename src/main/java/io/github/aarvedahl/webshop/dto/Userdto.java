package io.github.aarvedahl.webshop.dto;

public class Userdto {

    private int userid;
    private String username;
    private String password;

    public Userdto(int userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public Userdto() { }

    public int getUserid() { return userid; }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
