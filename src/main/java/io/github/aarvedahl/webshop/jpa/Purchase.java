package io.github.aarvedahl.webshop.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Purchase implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderid;

    @Column
    private int userid;

    @Column
    private Date orderdate;

    @Column
    private boolean canceled;

    public Purchase() { }
    public Purchase(int userid, Date orderdate, Boolean canceled) {
        this.userid = userid;
        this.orderdate = orderdate;
        this.canceled = canceled;
    }
    public int getOrderid() { return orderid; }
    public void setOrderid(int orderid) { this.orderid = orderid; }
    public int getUserid() { return userid; }
    public void setUserid(int userid) { this.userid = userid; }
    public Date getOrderdate() { return orderdate; }
    public boolean getCanceled() { return canceled; }
    public void setCanceled(boolean canceled) { this.canceled = canceled; }
    public void setOrderdate(Date orderdate) { this.orderdate = orderdate; }
}
