/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Authordao;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Author;

/**
 *
 * @author Uygi
 */
public class pnauthor extends javax.swing.JPanel {

    /**
     * Creates new form pnauthor
     */
    public pnauthor() {
        initComponents();
        showAllAuthor();
        pickAnAuthor();
    }

    public void showAllAuthor() {
        Authordao adao = new Authordao();
        lsta = adao.getAllAuthor();
        DefaultTableModel dtm = (DefaultTableModel) tblauthor.getModel();
        dtm.setRowCount(0);
        for(Author a : lsta) {
            Vector vt = new Vector();
            vt.add(a.getId());
            vt.add(a.getName());
            vt.add(a.getDescription());
            
            dtm.addRow(vt);
        }
    }
    
    public void pickAnAuthor() {
        tblauthor.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowSelected = tblauthor.getSelectedRow();
                txtid.setText(Integer.toString((int) tblauthor.getValueAt(rowSelected, 0)));
                txtname.setText((String) tblauthor.getValueAt(rowSelected, 1));
                txtdescription.setText((String) tblauthor.getValueAt(rowSelected, 2));
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
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnauthor = new javax.swing.JPanel();
        pnltbl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblauthor = new javax.swing.JTable();
        pndetail = new javax.swing.JPanel();
        pntop = new javax.swing.JPanel();
        pnid = new javax.swing.JPanel();
        lblid = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        pnname = new javax.swing.JPanel();
        lblname = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        pndescription = new javax.swing.JPanel();
        lbldescription = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdescription = new javax.swing.JTextArea();
        pnbot = new javax.swing.JPanel();
        btnadd = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btndel = new javax.swing.JButton();

        pnauthor.setBackground(new java.awt.Color(51, 51, 51));
        pnauthor.setPreferredSize(new java.awt.Dimension(767, 544));

        tblauthor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblauthor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblauthor);
        if (tblauthor.getColumnModel().getColumnCount() > 0) {
            tblauthor.getColumnModel().getColumn(0).setMinWidth(60);
            tblauthor.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblauthor.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        javax.swing.GroupLayout pnltblLayout = new javax.swing.GroupLayout(pnltbl);
        pnltbl.setLayout(pnltblLayout);
        pnltblLayout.setHorizontalGroup(
            pnltblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );
        pnltblLayout.setVerticalGroup(
            pnltblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pndetail.setBackground(new java.awt.Color(51, 51, 51));

        pntop.setBackground(new java.awt.Color(51, 51, 51));

        pnid.setBackground(new java.awt.Color(51, 51, 51));

        lblid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblid.setForeground(new java.awt.Color(255, 102, 0));
        lblid.setText("ID:");

        txtid.setBackground(new java.awt.Color(51, 51, 51));
        txtid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtid.setForeground(new java.awt.Color(255, 255, 255));
        txtid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnidLayout = new javax.swing.GroupLayout(pnid);
        pnid.setLayout(pnidLayout);
        pnidLayout.setHorizontalGroup(
            pnidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnidLayout.createSequentialGroup()
                .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txtid)
        );
        pnidLayout.setVerticalGroup(
            pnidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnidLayout.createSequentialGroup()
                .addComponent(lblid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnname.setBackground(new java.awt.Color(51, 51, 51));

        lblname.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblname.setForeground(new java.awt.Color(255, 102, 0));
        lblname.setText("Name:");

        txtname.setBackground(new java.awt.Color(51, 51, 51));
        txtname.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtname.setForeground(new java.awt.Color(255, 255, 255));
        txtname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        txtname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnameKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnnameLayout = new javax.swing.GroupLayout(pnname);
        pnname.setLayout(pnnameLayout);
        pnnameLayout.setHorizontalGroup(
            pnnameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtname)
            .addGroup(pnnameLayout.createSequentialGroup()
                .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 248, Short.MAX_VALUE))
        );
        pnnameLayout.setVerticalGroup(
            pnnameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnnameLayout.createSequentialGroup()
                .addComponent(lblname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pndescription.setBackground(new java.awt.Color(51, 51, 51));

        lbldescription.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbldescription.setForeground(new java.awt.Color(255, 102, 0));
        lbldescription.setText("Description:");

        txtdescription.setBackground(new java.awt.Color(51, 51, 51));
        txtdescription.setColumns(20);
        txtdescription.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtdescription.setForeground(new java.awt.Color(255, 255, 255));
        txtdescription.setRows(5);
        txtdescription.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jScrollPane2.setViewportView(txtdescription);

        javax.swing.GroupLayout pndescriptionLayout = new javax.swing.GroupLayout(pndescription);
        pndescription.setLayout(pndescriptionLayout);
        pndescriptionLayout.setHorizontalGroup(
            pndescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndescriptionLayout.createSequentialGroup()
                .addComponent(lbldescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(204, 204, 204))
            .addComponent(jScrollPane2)
        );
        pndescriptionLayout.setVerticalGroup(
            pndescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndescriptionLayout.createSequentialGroup()
                .addComponent(lbldescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pntopLayout = new javax.swing.GroupLayout(pntop);
        pntop.setLayout(pntopLayout);
        pntopLayout.setHorizontalGroup(
            pntopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pntopLayout.createSequentialGroup()
                .addGroup(pntopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pntopLayout.createSequentialGroup()
                        .addComponent(pnname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(66, 66, 66))
                    .addComponent(pndescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pntopLayout.createSequentialGroup()
                        .addComponent(pnid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(223, 223, 223)))
                .addContainerGap())
        );
        pntopLayout.setVerticalGroup(
            pntopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pntopLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(pnid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(pndescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        pnbot.setBackground(new java.awt.Color(51, 51, 51));

        btnadd.setBackground(new java.awt.Color(51, 51, 51));
        btnadd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnadd.setForeground(new java.awt.Color(255, 102, 0));
        btnadd.setText("Add");
        btnadd.setBorder(null);
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnsave.setBackground(new java.awt.Color(51, 51, 51));
        btnsave.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnsave.setForeground(new java.awt.Color(255, 102, 0));
        btnsave.setText("Save");
        btnsave.setBorder(null);
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnclear.setBackground(new java.awt.Color(51, 51, 51));
        btnclear.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnclear.setForeground(new java.awt.Color(255, 102, 0));
        btnclear.setText("Clear");
        btnclear.setBorder(null);
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        btndel.setBackground(new java.awt.Color(51, 51, 51));
        btndel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btndel.setForeground(new java.awt.Color(255, 102, 0));
        btndel.setText("Del");
        btndel.setBorder(null);
        btndel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnbotLayout = new javax.swing.GroupLayout(pnbot);
        pnbot.setLayout(pnbotLayout);
        pnbotLayout.setHorizontalGroup(
            pnbotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbotLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(pnbotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnclear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(pnbotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btndel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(103, 103, 103))
        );
        pnbotLayout.setVerticalGroup(
            pnbotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbotLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnbotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnadd, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnsave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnbotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnbotLayout.createSequentialGroup()
                        .addComponent(btndel, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addComponent(btnclear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pndetailLayout = new javax.swing.GroupLayout(pndetail);
        pndetail.setLayout(pndetailLayout);
        pndetailLayout.setHorizontalGroup(
            pndetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pntop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnbot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pndetailLayout.setVerticalGroup(
            pndetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndetailLayout.createSequentialGroup()
                .addComponent(pntop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnbot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout pnauthorLayout = new javax.swing.GroupLayout(pnauthor);
        pnauthor.setLayout(pnauthorLayout);
        pnauthorLayout.setHorizontalGroup(
            pnauthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnauthorLayout.createSequentialGroup()
                .addComponent(pnltbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pndetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnauthorLayout.setVerticalGroup(
            pnauthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnltbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pndetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnauthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnauthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        Authordao adao = new Authordao();
        if(adao.addNewAuthor(Integer.parseInt(txtid.getText()), txtname.getText(), txtdescription.getText())) {
            JOptionPane.showMessageDialog(null, "Added "+ txtid.getText());
            lsta = adao.getAllAuthor();
            DefaultTableModel dtm = (DefaultTableModel) tblauthor.getModel();
            dtm.setRowCount(0);
            for(Author a : lsta) {
                Vector vt = new Vector();
                vt.add(a.getId());
                vt.add(a.getName());
                vt.add(a.getDescription());
                
                dtm.addRow(vt);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Add false");
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        txtid.setText("");
        txtname.setText("");
        txtdescription.setText("");
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        Authordao adao = new Authordao();
        if(adao.updateAuthor(Integer.parseInt(txtid.getText()), txtname.getText(), txtdescription.getText())) {
            JOptionPane.showMessageDialog(null, "saved "+ txtid.getText());
            lsta = adao.getAllAuthor();
            DefaultTableModel dtm = (DefaultTableModel) tblauthor.getModel();
            dtm.setRowCount(0);
            for(Author a : lsta) {
                Vector vt = new Vector();
                vt.add(a.getId());
                vt.add(a.getName());
                vt.add(a.getDescription());
                
                dtm.addRow(vt);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Save false");
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btndelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelActionPerformed
        // TODO add your handling code here:
        Authordao adao = new Authordao();
        if(adao.delAuthor(Integer.parseInt(txtid.getText()))) {
            JOptionPane.showMessageDialog(null, "Deleted "+ txtid.getText());
            lsta = adao.getAllAuthor();
            DefaultTableModel dtm = (DefaultTableModel) tblauthor.getModel();
            dtm.setRowCount(0);
            for(Author a : lsta) {
                Vector vt = new Vector();
                vt.add(a.getId());
                vt.add(a.getName());
                vt.add(a.getDescription());
                
                dtm.addRow(vt);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Delete false");
        }
    }//GEN-LAST:event_btndelActionPerformed

    private void txtidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyPressed
        // TODO add your handling code here:
        Authordao adao = new Authordao();
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            if(txtid.getText().equals("")) {
                lsta = adao.getAllAuthor();
                DefaultTableModel dtm = (DefaultTableModel) tblauthor.getModel();
                dtm.setRowCount(0);
                for(Author a : lsta ) {
                    Vector vt = new Vector();
                    vt.add(a.getId());
                    vt.add(a.getName());
                    vt.add(a.getDescription());
                    
                    dtm.addRow(vt);
                }
            }else{
                lsta = adao.getAllAuthorByid(Integer.parseInt(txtid.getText()));
                DefaultTableModel dtm = (DefaultTableModel) tblauthor.getModel();
                dtm.setRowCount(0);
                for(Author a : lsta ) {
                    Vector vt = new Vector();
                    vt.add(a.getId());
                    vt.add(a.getName());
                    vt.add(a.getDescription());
                    
                    dtm.addRow(vt);
                }
            }
        }
    }//GEN-LAST:event_txtidKeyPressed

    private void txtnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnameKeyPressed
        // TODO add your handling code here:
        Authordao adao = new Authordao();
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            if(txtname.getText().equals("")) {
                lsta = adao.getAllAuthor();
                DefaultTableModel dtm = (DefaultTableModel) tblauthor.getModel();
                dtm.setRowCount(0);
                for(Author a : lsta ) {
                    Vector vt = new Vector();
                    vt.add(a.getId());
                    vt.add(a.getName());
                    vt.add(a.getDescription());
                    
                    dtm.addRow(vt);
                }
            }else{
                lsta = adao.getAuthorByName(txtname.getText());
                DefaultTableModel dtm = (DefaultTableModel) tblauthor.getModel();
                dtm.setRowCount(0);
                for(Author a : lsta ) {
                    Vector vt = new Vector();
                    vt.add(a.getId());
                    vt.add(a.getName());
                    vt.add(a.getDescription());
                    
                    dtm.addRow(vt);
                }
            }
        }
    }//GEN-LAST:event_txtnameKeyPressed

    public ArrayList<Author> lsta = null;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndel;
    private javax.swing.JButton btnsave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbldescription;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblname;
    private javax.swing.JPanel pnauthor;
    private javax.swing.JPanel pnbot;
    private javax.swing.JPanel pndescription;
    private javax.swing.JPanel pndetail;
    private javax.swing.JPanel pnid;
    private javax.swing.JPanel pnltbl;
    private javax.swing.JPanel pnname;
    private javax.swing.JPanel pntop;
    private javax.swing.JTable tblauthor;
    private javax.swing.JTextArea txtdescription;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
