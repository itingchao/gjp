package com.seven.domain;

import java.util.Date;

/**
 * @ClassName:Ledger
 * @Description:TODO
 * @Author:Admin
 * @Date: 2019/1/1621:56
 * @version: 1.0
 */
public class Ledger {
    private int lid;
    private String parent;
    private double money;
    private int sid;
    private String account;
    private Date createtime;
    private String ldesc;

    public Ledger(){

    }
    public Ledger(int lid, String parent, Double money, int sid, String account, Date createtime, String ldesc) {
        this.lid = lid;
        this.parent = parent;
        this.money = money;
        this.sid = sid;
        this.account = account;
        this.createtime = createtime;
        this.ldesc = ldesc;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getLdesc() {
        return ldesc;
    }

    public void setLdesc(String ldesc) {
        this.ldesc = ldesc;
    }

    @Override
    public String toString() {
        return "Ledger{" +
                "lid=" + lid +
                ", parent='" + parent + '\'' +
                ", money=" + money +
                ", sid=" + sid +
                ", account='" + account + '\'' +
                ", createtime=" + createtime +
                ", ldesc='" + ldesc + '\'' +
                '}';
    }
}