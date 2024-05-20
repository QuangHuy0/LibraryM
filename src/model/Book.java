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
public class Book {
    private int id;
    private String title;
    private int lang_id;
    private int edition;
    private int quantity;
    private int status;
    private int publish_year;
    private String description;
    private Date createdd;
    private int createdu;
    private Date updatedd;
    private int updatedu;

    public Book() {
    }

    public Book(int id, String title, int lang_id, int edition, int quantity, int status, int publish_year, String description, Date createdd, int createdu, Date updatedd, int updatedu) {
        this.id = id;
        this.title = title;
        this.lang_id = lang_id;
        this.edition = edition;
        this.quantity = quantity;
        this.status = status;
        this.publish_year = publish_year;
        this.description = description;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLang_id() {
        return lang_id;
    }

    public void setLang_id(int lang_id) {
        this.lang_id = lang_id;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPublish_year() {
        return publish_year;
    }

    public void setPublish_year(int publish_year) {
        this.publish_year = publish_year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
