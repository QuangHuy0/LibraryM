/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.pnauthor;
import view.pnbook;
import view.pnhome;
import view.pntransaction;
import view.pnpublisher;
import view.pncategory;import view.pnreader;
import view.pnstaff;
import model.Staff;
;

/**
 *
 * @author Uygi
 */

public class ChangeMenu {
    private JPanel root;
    private String kindSelected = "";
    private List<Menu> lstmenu = null;
    
    public ChangeMenu(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "Home";
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new pnhome());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List<Menu> lstItem) {
        this.lstmenu = lstItem;
        for(Menu m : lstItem) {
            m.getJlb().addMouseListener(new LabelEvent(m.getKind(), m.getJpn(), m.getJlb(), m.getS()));
        }
    }
    
    class LabelEvent implements MouseListener {
        private JPanel node;
        private String kind;
        private JPanel jpnitem;
        private JLabel jlbitem;
        private Staff s;
        
        public LabelEvent(String kind, JPanel jpnitem, JLabel jlbitem, Staff s) {
            this.kind = kind;
            this.jpnitem = jpnitem;
            this.jlbitem = jlbitem;
            this.s = s;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind) {
                case "Home":
                    node = new pnhome();
                    break;
                case "Book":
                    node = new pnbook(s);
                    break;
                case "Transaction":
                    node = new pntransaction(s);
                    break;
                case "Author":
                    node = new pnauthor();
                    break;
                case "Publisher":
                    node = new pnpublisher();
                    break;
                case "Category":
                    node = new pncategory();
                    break;
                case "Reader":
                    node = new pnreader(s);
                    break;
                case "Staff":
                    node = new pnstaff();
                    break;
                default:
                    node = new pnhome();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}

