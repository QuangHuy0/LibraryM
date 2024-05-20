/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Uygi
 */
public class Menu {
    private String kind;
    private JPanel jpn;
    private JLabel jlb;
    private Staff s;

    public Menu(String kind, JPanel jpn, JLabel jlb, Staff s) {
        this.kind = kind;
        this.jpn = jpn;
        this.jlb = jlb;
        this.s = s;
    }

    public Menu() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }

    public Staff getS() {
        return s;
    }

    public void setS(Staff s) {
        this.s = s;
    }
    
    
    
    
}
