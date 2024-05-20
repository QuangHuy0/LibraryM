/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Authordao;
import dao.Book_authordao;
import dao.Book_categorydao;
import dao.Book_publisherdao;
import dao.Bookdao;
import dao.Publisherdao;
import dao.Categorydao;
import dao.Languagesdao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.Author;
import model.Book;
import model.Category;
import model.Languages;
import model.Publisher;
import model.Staff;

/**
 *
 * @author Uygi
 */
public class pnbook extends javax.swing.JPanel {

    /**
     * Creates new form pnbook
     */
    private Staff s;
    public pnbook(Staff s) {
        initComponents();
        showAllBook();
        showcbb();
        tblbookClick();
        this.s = s;
    }
    
    public void showAllBook() {
        lblids.setText("");
        badao = new Book_authordao();
        bpdao = new Book_publisherdao();
        bcdao = new Book_categorydao();
        Languagesdao ldao = new Languagesdao();
        Languages l = new Languages();
        Bookdao bdao = new Bookdao();
        lstb = bdao.getAllBook();

        DefaultTableModel dtm = (DefaultTableModel) tblbook.getModel();
        dtm.setRowCount(0);
        for (Book b : lstb) {
            Vector<Object> vt = new Vector();
            vt.add(b.getId());
            vt.add(b.getTitle());
            //author name
            lstau = badao.getAllAuthorByBookId(b.getId());
            ArrayList<String> aname = new ArrayList<String>();
            for (Author a : lstau) {
                aname.add(a.getName());
            }
            vt.add(aname);
            //publisher name
            lstp = bpdao.getAllPublisherByBookId(b.getId());
            ArrayList<String> pname = new ArrayList<String>();
            for (Publisher p : lstp) {
                pname.add(p.getName());
            }
            vt.add(pname);
            //category name
            lstc = bcdao.getAllCategoryByBookId(b.getId());
            ArrayList<String> cname = new ArrayList<String>();
            for (Category c : lstc) {
                cname.add(c.getName());
            }
            vt.add(cname);
            //languages
            l = ldao.getALanguagesById(b.getLang_id());
            vt.add(l.getName());
            vt.add(b.getEdition());
            vt.add(b.getPublish_year());
            if (b.getStatus() == 0) {
                vt.add("Run out");
            } else {
                vt.add("Has ");
            }

            dtm.addRow(vt);
        }
    }

    public void showcbb() {
        cbbauthor.removeAllItems();
        cbbpublisher.removeAllItems();
        cbbcategory.removeAllItems();
        cbbstatus.removeAllItems();

        cbbauthor.addItem("Select");
        Authordao adao = new Authordao();
        lstau = adao.getAllAuthor();
        for (Author a : lstau) {
            cbbauthor.addItem(a.getName());
        }

        cbbpublisher.addItem("Select");
        Publisherdao pdao = new Publisherdao();
        lstp = pdao.getAllPublisher();
        for (Publisher p : lstp) {
            cbbpublisher.addItem(p.getName());
        }

        cbbcategory.addItem("Select");
        Categorydao cdao = new Categorydao();
        lstc = cdao.getAllCategory();
        for (Category c : lstc) {
            cbbcategory.addItem(c.getName());
        }

        cbbstatus.addItem("Select");
        cbbstatus.addItem("usable");
        cbbstatus.addItem("run out");
    }

    public void tblbookClick() {
        tblbook.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && tblbook.getSelectedRow() != -1) {
                    DefaultTableModel dtm = (DefaultTableModel) tblbook.getModel();
                    int selectedRow = tblbook.getSelectedRow();
                    selectedRow = tblbook.convertRowIndexToModel(selectedRow);
//                    System.out.println(selectedRow);

                    Bookdao bdao = new Bookdao();
                    Book b = new Book();
                    b = bdao.getABookById((int) tblbook.getValueAt(selectedRow, 0));

                    BookFrame bframe = new BookFrame(b,s);
                    bframe.setResizable(false);
                    bframe.setVisible(true);
                    bframe.setLocationRelativeTo(null);

                    showAllBook();

                }

            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnbook = new javax.swing.JPanel();
        pnsearch = new javax.swing.JPanel();
        lblbookcode = new javax.swing.JLabel();
        txtbookcode = new javax.swing.JTextField();
        lblauthor = new javax.swing.JLabel();
        lblpublisher = new javax.swing.JLabel();
        cbbpublisher = new javax.swing.JComboBox<>();
        cbbauthor = new javax.swing.JComboBox<>();
        lblcategory = new javax.swing.JLabel();
        lbltrangthai = new javax.swing.JLabel();
        cbbcategory = new javax.swing.JComboBox<>();
        cbbstatus = new javax.swing.JComboBox<>();
        btnadd = new javax.swing.JButton();
        lblids = new javax.swing.JLabel();
        pndetails = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbook = new javax.swing.JTable();

        setBackground(new java.awt.Color(51, 51, 51));

        pnbook.setBackground(new java.awt.Color(51, 51, 51));

        pnsearch.setBackground(new java.awt.Color(51, 51, 51));
        pnsearch.setForeground(new java.awt.Color(255, 255, 255));

        lblbookcode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblbookcode.setForeground(new java.awt.Color(255, 102, 0));
        lblbookcode.setText("Book Code: ");

        txtbookcode.setBackground(new java.awt.Color(51, 51, 51));
        txtbookcode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtbookcode.setForeground(new java.awt.Color(255, 255, 255));
        txtbookcode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        txtbookcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbookcodeActionPerformed(evt);
            }
        });
        txtbookcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbookcodeKeyPressed(evt);
            }
        });

        lblauthor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblauthor.setForeground(lblbookcode.getForeground());
        lblauthor.setText("Author: ");

        lblpublisher.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblpublisher.setForeground(lblbookcode.getForeground());
        lblpublisher.setText("Publisher: ");

        cbbpublisher.setBackground(new java.awt.Color(51, 51, 51));
        cbbpublisher.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbbpublisher.setForeground(new java.awt.Color(255, 102, 0));
        cbbpublisher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbpublisher.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        cbbpublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbpublisherActionPerformed(evt);
            }
        });

        cbbauthor.setBackground(new java.awt.Color(51, 51, 51));
        cbbauthor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbbauthor.setForeground(new java.awt.Color(255, 102, 0));
        cbbauthor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbauthor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        cbbauthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbauthorActionPerformed(evt);
            }
        });

        lblcategory.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcategory.setForeground(lblbookcode.getForeground());
        lblcategory.setText("Category: ");

        lbltrangthai.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbltrangthai.setForeground(lblbookcode.getForeground());
        lbltrangthai.setText("Status:");

        cbbcategory.setBackground(new java.awt.Color(51, 51, 51));
        cbbcategory.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbbcategory.setForeground(new java.awt.Color(255, 102, 0));
        cbbcategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbcategory.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        cbbcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbcategoryActionPerformed(evt);
            }
        });

        cbbstatus.setBackground(new java.awt.Color(51, 51, 51));
        cbbstatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbbstatus.setForeground(new java.awt.Color(255, 102, 0));
        cbbstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbstatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        btnadd.setBackground(new java.awt.Color(51, 51, 51));
        btnadd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnadd.setForeground(new java.awt.Color(255, 102, 0));
        btnadd.setText("Add");
        btnadd.setBorder(null);
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        lblids.setForeground(new java.awt.Color(51, 51, 51));
        lblids.setText("jLabel1");

        javax.swing.GroupLayout pnsearchLayout = new javax.swing.GroupLayout(pnsearch);
        pnsearch.setLayout(pnsearchLayout);
        pnsearchLayout.setHorizontalGroup(
            pnsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnsearchLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnsearchLayout.createSequentialGroup()
                        .addComponent(lblbookcode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbookcode, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnsearchLayout.createSequentialGroup()
                        .addGroup(pnsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblauthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblpublisher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(pnsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnsearchLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnsearchLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(cbbauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnsearchLayout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addGroup(pnsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbltrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblcategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnsearchLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(lblids)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbcategory, 0, 155, Short.MAX_VALUE)
                            .addComponent(cbbstatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnsearchLayout.setVerticalGroup(
            pnsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnsearchLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblbookcode, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbookcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnsearchLayout.createSequentialGroup()
                        .addGroup(pnsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcategory)
                            .addComponent(cbbcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnsearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbltrangthai)
                                .addComponent(cbbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblids)))
                    .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pndetails.setBackground(new java.awt.Color(51, 51, 51));

        tblbook.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblbook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Title", "Author", "Publisher", "Category", "Language", "Edition", "Publish Year", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblbook);
        if (tblbook.getColumnModel().getColumnCount() > 0) {
            tblbook.getColumnModel().getColumn(0).setMinWidth(40);
            tblbook.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblbook.getColumnModel().getColumn(0).setMaxWidth(40);
            tblbook.getColumnModel().getColumn(6).setMinWidth(80);
            tblbook.getColumnModel().getColumn(6).setPreferredWidth(80);
            tblbook.getColumnModel().getColumn(6).setMaxWidth(80);
            tblbook.getColumnModel().getColumn(7).setMinWidth(80);
            tblbook.getColumnModel().getColumn(7).setPreferredWidth(80);
            tblbook.getColumnModel().getColumn(7).setMaxWidth(80);
            tblbook.getColumnModel().getColumn(8).setMinWidth(80);
            tblbook.getColumnModel().getColumn(8).setPreferredWidth(80);
            tblbook.getColumnModel().getColumn(8).setMaxWidth(80);
        }

        javax.swing.GroupLayout pndetailsLayout = new javax.swing.GroupLayout(pndetails);
        pndetails.setLayout(pndetailsLayout);
        pndetailsLayout.setHorizontalGroup(
            pndetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pndetailsLayout.setVerticalGroup(
            pndetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pnbookLayout = new javax.swing.GroupLayout(pnbook);
        pnbook.setLayout(pnbookLayout);
        pnbookLayout.setHorizontalGroup(
            pnbookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbookLayout.createSequentialGroup()
                .addGroup(pnbookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pndetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnsearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        pnbookLayout.setVerticalGroup(
            pnbookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbookLayout.createSequentialGroup()
                .addComponent(pnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pndetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnbook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnbook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtbookcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbookcodeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtbookcodeActionPerformed

    private void txtbookcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbookcodeKeyPressed
        // TODO add your handling code here:
        Bookdao bdao = new Bookdao();
        Languages l = new Languages();
        Languagesdao ldao = new Languagesdao();

        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            if (txtbookcode.getText().equals("")) {
                lstb = bdao.getAllBook();
                DefaultTableModel dtm = (DefaultTableModel) tblbook.getModel();
                dtm.setRowCount(0);
                for (Book b : lstb) {
                    Vector<Object> vt = new Vector();
                    vt.add(b.getId());
                    vt.add(b.getTitle());
                    //author name
                    lstau = badao.getAllAuthorByBookId(b.getId());
                    ArrayList<String> aname = new ArrayList<String>();
                    for (Author a : lstau) {
                        aname.add(a.getName());
                    }
                    vt.add(aname);
                    //publisher name
                    lstp = bpdao.getAllPublisherByBookId(b.getId());
                    ArrayList<String> pname = new ArrayList<String>();
                    for (Publisher p : lstp) {
                        pname.add(p.getName());
                    }
                    vt.add(pname);
                    //category name
                    lstc = bcdao.getAllCategoryByBookId(b.getId());
                    ArrayList<String> cname = new ArrayList<String>();
                    for (Category c : lstc) {
                        cname.add(c.getName());
                    }
                    vt.add(cname);
                    //other of book
                    l = ldao.getALanguagesById(b.getLang_id());
                    vt.add(l.getName());
                    vt.add(b.getEdition());
                    vt.add(b.getPublish_year());
                    if (b.getStatus() == 0) {
                        vt.add("Run out");
                    } else {
                        vt.add("Has ");
                    }

                    dtm.addRow(vt);
                }
            } else {
                lstb = bdao.getBookById(Integer.parseInt(txtbookcode.getText()));
                DefaultTableModel dtm = (DefaultTableModel) tblbook.getModel();
                dtm.setRowCount(0);
                for (Book b : lstb) {
                    Vector<Object> vt = new Vector();
                    vt.add(b.getId());
                    vt.add(b.getTitle());
                    //author name
                    lstau = badao.getAllAuthorByBookId(b.getId());
                    ArrayList<String> aname = new ArrayList<String>();
                    for (Author a : lstau) {
                        aname.add(a.getName());
                    }
                    vt.add(aname);
                    //publisher name
                    lstp = bpdao.getAllPublisherByBookId(b.getId());
                    ArrayList<String> pname = new ArrayList<String>();
                    for (Publisher p : lstp) {
                        pname.add(p.getName());
                    }
                    vt.add(pname);
                    //category name
                    lstc = bcdao.getAllCategoryByBookId(b.getId());
                    ArrayList<String> cname = new ArrayList<String>();
                    for (Category c : lstc) {
                        cname.add(c.getName());
                    }
                    vt.add(cname);
                    //other of book
                    l = ldao.getALanguagesById(b.getLang_id());
                    vt.add(l.getName());
                    vt.add(b.getEdition());
                    vt.add(b.getPublish_year());
                    if (b.getStatus() == 0) {
                        vt.add("Run out");
                    } else {
                        vt.add("Has ");
                    }

                    dtm.addRow(vt);
                }
            }
        }
    }//GEN-LAST:event_txtbookcodeKeyPressed

    private void cbbauthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbauthorActionPerformed
        // TODO add your handling code here:
        Languages l = new Languages();
        Languagesdao ldao = new Languagesdao();
        String selectedItem = (String) cbbauthor.getSelectedItem();
        Book_authordao badao = new Book_authordao();
        if (cbbauthor.getSelectedItem() == "Select") {
            showAllBook();
            cbbpublisher.setSelectedItem("Select");
            cbbcategory.setSelectedItem("Select");
        } else {
            cbbpublisher.setSelectedItem("Select");
            cbbcategory.setSelectedItem("Select");
            cbbauthor.setSelectedItem(selectedItem);
            lstb = badao.getAllBookByAuthorName(selectedItem);
            DefaultTableModel dtm = (DefaultTableModel) tblbook.getModel();
            dtm.setRowCount(0);
            for (Book b : lstb) {
                Vector<Object> vt = new Vector();
                vt.add(b.getId());
                vt.add(b.getTitle());
                //author name
                lstau = badao.getAllAuthorByBookId(b.getId());
                ArrayList<String> aname = new ArrayList<String>();
                for (Author a : lstau) {
                    aname.add(a.getName());
                }
                vt.add(aname);
                //publisher name
                lstp = bpdao.getAllPublisherByBookId(b.getId());
                ArrayList<String> pname = new ArrayList<String>();
                for (Publisher p : lstp) {
                    pname.add(p.getName());
                }
                vt.add(pname);
                //category name
                lstc = bcdao.getAllCategoryByBookId(b.getId());
                ArrayList<String> cname = new ArrayList<String>();
                for (Category c : lstc) {
                    cname.add(c.getName());
                }
                vt.add(cname);
                //other of book
                l = ldao.getALanguagesById(b.getLang_id());
                vt.add(l.getName());
                vt.add(b.getEdition());
                vt.add(b.getPublish_year());
                if (b.getStatus() == 0) {
                    vt.add("Run out");
                } else {
                    vt.add("Has ");
                }

                dtm.addRow(vt);
            }
        }
    }//GEN-LAST:event_cbbauthorActionPerformed

    private void cbbpublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbpublisherActionPerformed
        // TODO add your handling code here:
        Languagesdao ldao = new Languagesdao();
        Languages l = new Languages();
        String selectedItem = (String) cbbpublisher.getSelectedItem();
        Book_publisherdao bpdao = new Book_publisherdao();
        if (cbbpublisher.getSelectedItem() == "Select") {
            showAllBook();
            cbbauthor.setSelectedItem("Select");
            cbbcategory.setSelectedItem("Select");
        } else {
            cbbauthor.setSelectedItem("Select");
            cbbcategory.setSelectedItem("Select");
            cbbpublisher.setSelectedItem(selectedItem);
            lstb = bpdao.getAllBookByPublisherName(selectedItem);
            DefaultTableModel dtm = (DefaultTableModel) tblbook.getModel();
            dtm.setRowCount(0);
            for (Book b : lstb) {
                Vector<Object> vt = new Vector();
                vt.add(b.getId());
                vt.add(b.getTitle());
                //author name
                lstau = badao.getAllAuthorByBookId(b.getId());
                ArrayList<String> aname = new ArrayList<String>();
                for (Author a : lstau) {
                    aname.add(a.getName());
                }
                vt.add(aname);
                //publisher name
                lstp = bpdao.getAllPublisherByBookId(b.getId());
                ArrayList<String> pname = new ArrayList<String>();
                for (Publisher p : lstp) {
                    pname.add(p.getName());
                }
                vt.add(pname);
                //category name
                lstc = bcdao.getAllCategoryByBookId(b.getId());
                ArrayList<String> cname = new ArrayList<String>();
                for (Category c : lstc) {
                    cname.add(c.getName());
                }
                vt.add(cname);
                //other of book
                l = ldao.getALanguagesById(b.getLang_id());
                vt.add(l.getName());
                vt.add(b.getEdition());
                vt.add(b.getPublish_year());
                if (b.getStatus() == 0) {
                    vt.add("Run out");
                } else {
                    vt.add("Has ");
                }

                dtm.addRow(vt);
            }
        }
    }//GEN-LAST:event_cbbpublisherActionPerformed

    private void cbbcategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbcategoryActionPerformed
        // TODO add your handling code here:
        Languages l = new Languages();
        Languagesdao ldao = new Languagesdao();
        String selectedItem = (String) cbbcategory.getSelectedItem();
        Book_categorydao bcdao = new Book_categorydao();
        if (cbbcategory.getSelectedItem() == "Select") {
            showAllBook();
            cbbauthor.setSelectedItem("Select");
            cbbpublisher.setSelectedItem("Select");
        } else {
            cbbauthor.setSelectedItem("Select");
            cbbpublisher.setSelectedItem("Select");
            cbbcategory.setSelectedItem(selectedItem);
            lstb = bcdao.getAllBookByCategoryName(selectedItem);
            DefaultTableModel dtm = (DefaultTableModel) tblbook.getModel();
            dtm.setRowCount(0);
            for (Book b : lstb) {
                Vector<Object> vt = new Vector();
                vt.add(b.getId());
                vt.add(b.getTitle());
                //author name
                lstau = badao.getAllAuthorByBookId(b.getId());
                ArrayList<String> aname = new ArrayList<String>();
                for (Author a : lstau) {
                    aname.add(a.getName());
                }
                vt.add(aname);
                //publisher name
                lstp = bpdao.getAllPublisherByBookId(b.getId());
                ArrayList<String> pname = new ArrayList<String>();
                for (Publisher p : lstp) {
                    pname.add(p.getName());
                }
                vt.add(pname);
                //category name
                lstc = bcdao.getAllCategoryByBookId(b.getId());
                ArrayList<String> cname = new ArrayList<String>();
                for (Category c : lstc) {
                    cname.add(c.getName());
                }
                vt.add(cname);
                //other of book
                l = ldao.getALanguagesById(b.getLang_id());
                vt.add(l.getName());
                vt.add(b.getEdition());
                vt.add(b.getPublish_year());
                if (b.getStatus() == 0) {
                    vt.add("Run out");
                } else {
                    vt.add("Has ");
                }

                dtm.addRow(vt);
            }
        }
    }//GEN-LAST:event_cbbcategoryActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        btnadd.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BookFrame bf = new BookFrame(new Book(), s);
                bf.setResizable(false);
                bf.setLocationRelativeTo(null);
                bf.setVisible(true);
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
        });
    }//GEN-LAST:event_btnaddActionPerformed

    private ArrayList<Book> lstb = null;
    private ArrayList<Author> lstau = null;
    private ArrayList<Publisher> lstp = null;
    private ArrayList<Category> lstc = null;
    private ArrayList<Languages> lstl = null;
    private Book_authordao badao;
    private Book_publisherdao bpdao;
    private Book_categorydao bcdao;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JComboBox<String> cbbauthor;
    private javax.swing.JComboBox<String> cbbcategory;
    private javax.swing.JComboBox<String> cbbpublisher;
    private javax.swing.JComboBox<String> cbbstatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblauthor;
    private javax.swing.JLabel lblbookcode;
    private javax.swing.JLabel lblcategory;
    private javax.swing.JLabel lblids;
    private javax.swing.JLabel lblpublisher;
    private javax.swing.JLabel lbltrangthai;
    private javax.swing.JPanel pnbook;
    private javax.swing.JPanel pndetails;
    private javax.swing.JPanel pnsearch;
    private javax.swing.JTable tblbook;
    private javax.swing.JTextField txtbookcode;
    // End of variables declaration//GEN-END:variables
}