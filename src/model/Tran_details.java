/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Uygi
 */
public class Tran_details {
    private int id;
    private int bdid;
    private int tranid;
    private int pid;
    private double price;

    public Tran_details() {
    }

    public Tran_details(int id, int bdid, int tranid, int pid, double price) {
        this.id = id;
        this.bdid = bdid;
        this.tranid = tranid;
        this.pid = pid;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBdid() {
        return bdid;
    }

    public void setBdid(int bdid) {
        this.bdid = bdid;
    }

    public int getTranid() {
        return tranid;
    }

    public void setTranid(int tranid) {
        this.tranid = tranid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
