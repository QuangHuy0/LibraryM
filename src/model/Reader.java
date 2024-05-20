/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Uygi
 */
public class Reader {
    private int id;
    private String avatar;
    private String name;
    private String phone;
    private Date birthday;
    private int gender;
    private int status;
    private String address;
    private Date createdd;
    private int crearedu;
    private Date updatedd;
    private int updatedu;

    public Reader() {
    }

    public Reader(int id, String avatar, String name, String phone, Date birthday, int gender, int status, String address, Date createdd, int crearedu, Date updatedd, int updatedu) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.status = status;
        this.address = address;
        this.createdd = createdd;
        this.crearedu = crearedu;
        this.updatedd = updatedd;
        this.updatedu = updatedu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedd() {
        return createdd;
    }

    public void setCreatedd(Date createdd) {
        this.createdd = createdd;
    }

    public int getCrearedu() {
        return crearedu;
    }

    public void setCrearedu(int crearedu) {
        this.crearedu = crearedu;
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

    @Override
    public String toString() {
        return  name;
    }
    
}
