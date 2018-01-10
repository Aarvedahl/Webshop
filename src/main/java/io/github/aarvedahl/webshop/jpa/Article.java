package io.github.aarvedahl.webshop.jpa;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int articleid;

    @Column
    private String articlename;

    @Column
    private String description;

    @Column
    private int price;

    @Column
    private int stock;

    @Column
    private String brand;

  //  @ManyToMany(mappedBy = "articleList")
 //   public List<Purchase> orderList;

    public Article() { }

    public int getArticleid() { return articleid; }
    public void setArticleid(int articleid) { this.articleid = articleid; }
    public String getArticlename() { return articlename; }
    public void setArticlename(String articlename) { this.articlename = articlename; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
  //  public List<Purchase> getOrderList() { return orderList; }
    /*    @ManyToMany
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
    private Users userid; */
}

