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
public class Book_details {
    private int id;
    private int book_id;
    private String Sku;
    private double price;
    private int status;
    private Date createdd;
    private int createdu;
    private Date updatedd;
    private int updatedu;

    public Book_details() {
    }

    public Book_details(int id, int book_id, String Sku, double price, int status, Date createdd, int createdu, Date updatedd, int updatedu) {
        this.id = id;
        this.book_id = book_id;
        this.Sku = Sku;
        this.price = price;
        this.status = status;
        this.createdd = createdd;
        this.createdu = createdu;
        this.updatedd = updatedd;
        this.updatedu = updatedu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getSku() {
        return Sku;
    }

    public void setSku(String Sku) {
        this.Sku = Sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatedd() {
        return createdd;
    }

    public void setCreatedd(Date createdd) {
        this.createdd = createdd;
    }

    public int getCreatedu() {
        return createdu;
    }

    public void setCreatedu(int createdu) {
        this.createdu = createdu;
    }

    public Date getUpdatedd() {
        return updatedd;
    }

    public void setUpdatedd(Date updatedd) {
        this.updatedd = updatedd;
    }

    public int getUpdatedu() {
        return updatedu;
    }

    public void setUpdatedu(int updatedu) {
        this.updatedu = updatedu;
    }
    
    
}
