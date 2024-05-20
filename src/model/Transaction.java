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
public class Transaction {
    private int id;
    private int customer_id;
    private int employee_id;
    private double total_p;
    private int status;
    private Date dued;
    private Date payd;
    private Date createdd;

    public Transaction() {
    }

    public Transaction(int id, int customer_id, int employee_id, double total_p, int status, Date dued, Date payd, Date createdd) {
        this.id = id;
        this.customer_id = customer_id;
        this.employee_id = employee_id;
        this.total_p = total_p;
        this.status = status;
        this.dued = dued;
        this.payd = payd;
        this.createdd = createdd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public double getTotal_p() {
        return total_p;
    }

    public void setTotal_p(double total_p) {
        this.total_p = total_p;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDued() {
        return dued;
    }

    public void setDued(Date dued) {
        this.dued = dued;
    }

    public Date getPayd() {
        return payd;
    }

    public void setPayd(Date payd) {
        this.payd = payd;
    }

    public Date getCreatedd() {
        return createdd;
    }

    public void setCreatedd(Date createdd) {
        this.createdd = createdd;
    }

    
}
