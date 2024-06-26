/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Readerdao;
import dao.Staffdao;
import dao.Transactiondao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.Reader;
import model.Staff;
import model.Transaction;

/**
 *
 * @author Uygi
 */
public class pntransaction extends javax.swing.JPanel {

    /**
     * Creates new form Transaction
     */
    private Staff s;
    public pntransaction(Staff s) {
        initComponents();
        showAllTransaction();
        showcbb();
        tblTranClick();
        this.s = s;
    }

    public void showAllTransaction() {
        long millis = System.currentTimeMillis();
        Date date = new java.sql.Date(millis);
        Transactiondao trandao = new Transactiondao();
        DefaultTableModel dtm = (DefaultTableModel) tbltran.getModel();
        dtm.setRowCount(0);
        lsttran = trandao.getAllTran();
        for (Transaction tran : lsttran) {
            Vector vt = new Vector();
            vt.add(tran.getId());
            //Reader name
            Readerdao rdao = new Readerdao();
            Reader r = new Reader();
            r = rdao.getAReaderById(tran.getCustomer_id());
            vt.add(r.getName());
            //Staff name
            Staffdao sdao = new Staffdao();
            Staff s = new Staff();
            s = sdao.getAStaffById(tran.getEmployee_id());
            vt.add(s.getName());

            vt.add(tran.getDued());
            vt.add(tran.getPayd());
            vt.add(tran.getTotal_p());

            if (cal(date, tran.getDued()) > 0) {
                trandao.updateTranstatus(tran.getId(), 1);
            }
            if (tran.getStatus() == 0) {
                vt.add("Borrowing");
            } else {
                if (tran.getStatus() == 1) {
                    vt.add("Overdue");
                } else {
                    vt.add("Paid");
                }
            }

            dtm.addRow(vt);
        }

    }

    public int cal(Date d, Date d1) {
        int c = (int) ((d.getTime() - d1.getTime()) / (24 * 3600 * 1000));
        return c;
    }

    public void showcbb() {
        cbbreader.removeAllItems();
        cbbstaff.removeAllItems();
        cbbstatus.removeAllItems();

        Readerdao rdao = new Readerdao();
        lstr = rdao.getAllReader();
        DefaultComboBoxModel cbreader = new DefaultComboBoxModel();
        Reader r1 = null;
        cbreader.addElement(r1);
        for (Reader r : lstr) {
            cbreader.addElement(r);
        }
        cbbreader.setModel(cbreader);

        Staffdao sdao = new Staffdao();
        lsts = sdao.getAllStaff();
        DefaultComboBoxModel cbstaff = new DefaultComboBoxModel();
        Staff s1 = null;
        cbstaff.addElement(s1);
        for (Staff s : lsts) {
            cbstaff.addElement(s);
        }
        cbbstaff.setModel(cbstaff);

        cbbstatus.addItem("Select");
        cbbstatus.addItem("Borrowing");
        cbbstatus.addItem("Overdue");
        cbbstatus.addItem("Paid");
    }

    public void tblTranClick() {
        tbltran.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && tbltran.getSelectedRow() != -1) {
                    DefaultTableModel dtm = (DefaultTableModel) tbltran.getModel();
                    int selectedRow = tbltran.getSelectedRow();
                    selectedRow = tbltran.convertColumnIndexToModel(selectedRow);

                    Transactiondao trandao = new Transactiondao();
                    Transaction tran = new Transaction();
                    tran = trandao.getATranById((int) tbltran.getValueAt(selectedRow, 0));

                    TransactionFrame tranframe = new TransactionFrame(tran,s);
                    tranframe.setResizable(false);
                    tranframe.setVisible(true);
                    tranframe.setLocationRelativeTo(null);

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

        pntransaction = new javax.swing.JPanel();
        pntop = new javax.swing.JPanel();
        pnsearchid = new javax.swing.JPanel();
        lblid = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        pnreader = new javax.swing.JPanel();
        lblreader = new javax.swing.JLabel();
        cbbreader = new javax.swing.JComboBox<>();
        pnstatus = new javax.swing.JPanel();
        lblstatus = new javax.swing.JLabel();
        cbbstatus = new javax.swing.JComboBox<>();
        pnstaff = new javax.swing.JPanel();
        lblstaff = new javax.swing.JLabel();
        cbbstaff = new javax.swing.JComboBox<>();
        btnadd = new javax.swing.JButton();
        pnbot = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltran = new javax.swing.JTable();

        pntransaction.setBackground(new java.awt.Color(51, 51, 51));
        pntransaction.setPreferredSize(new java.awt.Dimension(767, 544));

        pntop.setBackground(new java.awt.Color(51, 51, 51));

        pnsearchid.setBackground(new java.awt.Color(51, 51, 51));

        lblid.setBackground(new java.awt.Color(51, 51, 51));
        lblid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblid.setForeground(new java.awt.Color(255, 102, 0));
        lblid.setText("ID:");

        txtid.setBackground(new java.awt.Color(51, 51, 51));
        txtid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtid.setForeground(new java.awt.Color(255, 255, 255));
        txtid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnsearchidLayout = new javax.swing.GroupLayout(pnsearchid);
        pnsearchid.setLayout(pnsearchidLayout);
        pnsearchidLayout.setHorizontalGroup(
            pnsearchidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnsearchidLayout.createSequentialGroup()
                .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnsearchidLayout.setVerticalGroup(
            pnsearchidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnsearchidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblid)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnreader.setBackground(new java.awt.Color(51, 51, 51));

        lblreader.setBackground(new java.awt.Color(51, 51, 51));
        lblreader.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblreader.setForeground(new java.awt.Color(255, 102, 0));
        lblreader.setText("Reader: ");

        cbbreader.setBackground(new java.awt.Color(51, 51, 51));
        cbbreader.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbbreader.setForeground(new java.awt.Color(255, 102, 0));
        cbbreader.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbreader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        cbbreader.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbreaderItemStateChanged(evt);
            }
        });
        cbbreader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbreaderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnreaderLayout = new javax.swing.GroupLayout(pnreader);
        pnreader.setLayout(pnreaderLayout);
        pnreaderLayout.setHorizontalGroup(
            pnreaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnreaderLayout.createSequentialGroup()
                .addComponent(lblreader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbreader, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnreaderLayout.setVerticalGroup(
            pnreaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnreaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblreader)
                .addComponent(cbbreader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnstatus.setBackground(new java.awt.Color(51, 51, 51));

        lblstatus.setBackground(new java.awt.Color(51, 51, 51));
        lblstatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblstatus.setForeground(new java.awt.Color(255, 102, 0));
        lblstatus.setText("Status:");

        cbbstatus.setBackground(new java.awt.Color(51, 51, 51));
        cbbstatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbbstatus.setForeground(new java.awt.Color(255, 102, 0));
        cbbstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbstatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        cbbstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbstatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnstatusLayout = new javax.swing.GroupLayout(pnstatus);
        pnstatus.setLayout(pnstatusLayout);
        pnstatusLayout.setHorizontalGroup(
            pnstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnstatusLayout.createSequentialGroup()
                .addComponent(lblstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnstatusLayout.setVerticalGroup(
            pnstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblstatus)
                .addComponent(cbbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnstaff.setBackground(new java.awt.Color(51, 51, 51));

        lblstaff.setBackground(new java.awt.Color(51, 51, 51));
        lblstaff.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblstaff.setForeground(new java.awt.Color(255, 102, 0));
        lblstaff.setText("Staff:");

        cbbstaff.setBackground(new java.awt.Color(51, 51, 51));
        cbbstaff.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbbstaff.setForeground(new java.awt.Color(255, 102, 0));
        cbbstaff.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbstaff.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        cbbstaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbstaffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnstaffLayout = new javax.swing.GroupLayout(pnstaff);
        pnstaff.setLayout(pnstaffLayout);
        pnstaffLayout.setHorizontalGroup(
            pnstaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnstaffLayout.createSequentialGroup()
                .addComponent(lblstaff, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbstaff, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        pnstaffLayout.setVerticalGroup(
            pnstaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbbstaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lblstaff)
        );

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

        javax.swing.GroupLayout pntopLayout = new javax.swing.GroupLayout(pntop);
        pntop.setLayout(pntopLayout);
        pntopLayout.setHorizontalGroup(
            pntopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pntopLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pntopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pntopLayout.createSequentialGroup()
                        .addComponent(pnreader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(pnstaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnsearchid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        pntopLayout.setVerticalGroup(
            pntopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pntopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pntopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pntopLayout.createSequentialGroup()
                        .addComponent(pnsearchid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pntopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnreader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnstaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tbltran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbltran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Reader", "Staff", "Due date", "Pay date", "Price", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbltran);
        if (tbltran.getColumnModel().getColumnCount() > 0) {
            tbltran.getColumnModel().getColumn(0).setMinWidth(60);
            tbltran.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbltran.getColumnModel().getColumn(0).setMaxWidth(60);
            tbltran.getColumnModel().getColumn(3).setMinWidth(100);
            tbltran.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbltran.getColumnModel().getColumn(3).setMaxWidth(100);
            tbltran.getColumnModel().getColumn(4).setMinWidth(100);
            tbltran.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbltran.getColumnModel().getColumn(4).setMaxWidth(100);
            tbltran.getColumnModel().getColumn(5).setMinWidth(100);
            tbltran.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbltran.getColumnModel().getColumn(5).setMaxWidth(100);
            tbltran.getColumnModel().getColumn(6).setMinWidth(80);
            tbltran.getColumnModel().getColumn(6).setPreferredWidth(80);
            tbltran.getColumnModel().getColumn(6).setMaxWidth(80);
        }

        javax.swing.GroupLayout pnbotLayout = new javax.swing.GroupLayout(pnbot);
        pnbot.setLayout(pnbotLayout);
        pnbotLayout.setHorizontalGroup(
            pnbotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnbotLayout.setVerticalGroup(
            pnbotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pntransactionLayout = new javax.swing.GroupLayout(pntransaction);
        pntransaction.setLayout(pntransactionLayout);
        pntransactionLayout.setHorizontalGroup(
            pntransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pntop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnbot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pntransactionLayout.setVerticalGroup(
            pntransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pntransactionLayout.createSequentialGroup()
                .addComponent(pntop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnbot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pntransaction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pntransaction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbreaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbreaderActionPerformed
        // TODO add your handling code here:
        Transactiondao trandao = new Transactiondao();
        if (cbbreader.getSelectedItem() == null) {
            showAllTransaction();
        } else {
            try {
                lsttran = trandao.getAllTranByCusId(((Reader) cbbreader.getSelectedItem()).getId());
                cbbreader.setSelectedItem(((Reader) cbbreader.getSelectedItem()).getName());
                DefaultTableModel dtmm = (DefaultTableModel) tbltran.getModel();
                dtmm.setRowCount(0);
                for (Transaction tran : lsttran) {
                    Vector vt = new Vector();
                    vt.add(tran.getId());
                    //Reader name
                    Readerdao rdao = new Readerdao();
                    Reader r = new Reader();
                    r = rdao.getAReaderById(tran.getCustomer_id());
                    vt.add(r.getName());
                    //Staff name
                    Staffdao sdao = new Staffdao();
                    Staff s = new Staff();
                    s = sdao.getAStaffById(tran.getEmployee_id());
                    vt.add(s.getName());

                    vt.add(tran.getDued());
                    vt.add(tran.getPayd());
                    vt.add(tran.getTotal_p());
                    if (tran.getStatus() == 0) {
                        vt.add("Borrowing");
                    } else {
                        if (tran.getStatus() == 1) {
                            vt.add("Overdue");
                        } else {
                            vt.add("Paid");
                        }
                    }

                    dtmm.addRow(vt);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_cbbreaderActionPerformed

    private void cbbreaderItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbreaderItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbreaderItemStateChanged

    private void cbbstaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbstaffActionPerformed
        // TODO add your handling code here:
        Transactiondao trandao = new Transactiondao();
        if (cbbstaff.getSelectedItem() == null) {
            showAllTransaction();
        } else {
            try {
                int staff = ((Staff) cbbstaff.getSelectedItem()).getId();
                lsttran = trandao.getAllTranByEmpId(staff);
                DefaultTableModel dtm = (DefaultTableModel) tbltran.getModel();
                dtm.setRowCount(0);
                for (Transaction tran : lsttran) {
                    Vector vt = new Vector();
                    vt.add(tran.getId());
                    //Reader name
                    Readerdao rdao = new Readerdao();
                    Reader r = new Reader();
                    r = rdao.getAReaderById(tran.getCustomer_id());
                    vt.add(r.getName());
                    //Staff name
                    Staffdao sdao = new Staffdao();
                    Staff s = new Staff();
                    s = sdao.getAStaffById(tran.getEmployee_id());
                    vt.add(s.getName());

                    vt.add(tran.getDued());
                    vt.add(tran.getPayd());
                    vt.add(tran.getTotal_p());
                    if (tran.getStatus() == 0) {
                        vt.add("Borrowing");
                    } else {
                        if (tran.getStatus() == 1) {
                            vt.add("Overdue");
                        } else {
                            vt.add("Paid");
                        }
                    }

                    dtm.addRow(vt);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_cbbstaffActionPerformed

    private void cbbstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbstatusActionPerformed
        // TODO add your handling code here:
        Transactiondao trandao = new Transactiondao();
        String selected = (String) cbbstatus.getSelectedItem();
        if (selected == "Select") {
            showAllTransaction();
        } else {
            if (selected == "Borrowing") {
                lsttran = trandao.getAllTranByStatus(0);
                DefaultTableModel dtm = (DefaultTableModel) tbltran.getModel();
                dtm.setRowCount(0);
                for (Transaction tran : lsttran) {
                    Vector vt = new Vector();
                    vt.add(tran.getId());
                    //Reader name
                    Readerdao rdao = new Readerdao();
                    Reader r = new Reader();
                    r = rdao.getAReaderById(tran.getCustomer_id());
                    vt.add(r.getName());
                    //Staff name
                    Staffdao sdao = new Staffdao();
                    Staff s = new Staff();
                    s = sdao.getAStaffById(tran.getEmployee_id());
                    vt.add(s.getName());

                    vt.add(tran.getDued());
                    vt.add(tran.getPayd());
                    vt.add(tran.getTotal_p());
                    if (tran.getStatus() == 0) {
                        vt.add("Borrowing");
                    } else {
                        if (tran.getStatus() == 1) {
                            vt.add("Overdue");
                        } else {
                            vt.add("Paid");
                        }
                    }

                    dtm.addRow(vt);
                }
            } else {
                if (selected == "Overdue") {
                    lsttran = trandao.getAllTranByStatus(1);
                    DefaultTableModel dtm = (DefaultTableModel) tbltran.getModel();
                    dtm.setRowCount(0);
                    for (Transaction tran : lsttran) {
                        Vector vt = new Vector();
                        vt.add(tran.getId());
                        //Reader name
                        Readerdao rdao = new Readerdao();
                        Reader r = new Reader();
                        r = rdao.getAReaderById(tran.getCustomer_id());
                        vt.add(r.getName());
                        //Staff name
                        Staffdao sdao = new Staffdao();
                        Staff s = new Staff();
                        s = sdao.getAStaffById(tran.getEmployee_id());
                        vt.add(s.getName());

                        vt.add(tran.getDued());
                        vt.add(tran.getPayd());
                        vt.add(tran.getTotal_p());
                        if (tran.getStatus() == 0) {
                            vt.add("Borrowing");
                        } else {
                            if (tran.getStatus() == 1) {
                                vt.add("Overdue");
                            } else {
                                vt.add("Paid");
                            }
                        }

                        dtm.addRow(vt);
                    }
                } else {
                    lsttran = trandao.getAllTranByStatus(2);
                    DefaultTableModel dtm = (DefaultTableModel) tbltran.getModel();
                    dtm.setRowCount(0);
                    for (Transaction tran : lsttran) {
                        Vector vt = new Vector();
                        vt.add(tran.getId());
                        //Reader name
                        Readerdao rdao = new Readerdao();
                        Reader r = new Reader();
                        r = rdao.getAReaderById(tran.getCustomer_id());
                        vt.add(r.getName());
                        //Staff name
                        Staffdao sdao = new Staffdao();
                        Staff s = new Staff();
                        s = sdao.getAStaffById(tran.getEmployee_id());
                        vt.add(s.getName());

                        vt.add(tran.getDued());
                        vt.add(tran.getPayd());
                        vt.add(tran.getTotal_p());
                        if (tran.getStatus() == 0) {
                            vt.add("Borrowing");
                        } else {
                            if (tran.getStatus() == 1) {
                                vt.add("Overdue");
                            } else {
                                vt.add("Paid");
                            }
                        }

                        dtm.addRow(vt);
                    }
                }
            }
        }
    }//GEN-LAST:event_cbbstatusActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        TransactionFrame tf = new TransactionFrame(new Transaction(), s);
        tf.setResizable(false);
        tf.setLocationRelativeTo(null);
        tf.setVisible(true);
    }//GEN-LAST:event_btnaddActionPerformed

    ArrayList<Reader> lstr = null;
    ArrayList<Staff> lsts = null;
    ArrayList<Transaction> lsttran = null;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JComboBox<String> cbbreader;
    private javax.swing.JComboBox<String> cbbstaff;
    private javax.swing.JComboBox<String> cbbstatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblreader;
    private javax.swing.JLabel lblstaff;
    private javax.swing.JLabel lblstatus;
    private javax.swing.JPanel pnbot;
    private javax.swing.JPanel pnreader;
    private javax.swing.JPanel pnsearchid;
    private javax.swing.JPanel pnstaff;
    private javax.swing.JPanel pnstatus;
    private javax.swing.JPanel pntop;
    private javax.swing.JPanel pntransaction;
    private javax.swing.JTable tbltran;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
