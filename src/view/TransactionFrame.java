/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Book_detailsdao;
import dao.Readerdao;
import dao.Staffdao;
import dao.Punishdao;
import dao.Tran_detailsdao;
import dao.Transactiondao;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Punish;
import model.Reader;
import model.Staff;
import model.Tran_details;
import model.Transaction;
import model.Book_details;

/**
 *
 * @author Uygi
 */
public class TransactionFrame extends javax.swing.JFrame {

    /**
     * Creates new form TransactionFrame
     */
    public TransactionFrame(Transaction tran, Staff s) {
        initComponents();
        showTran_details(tran);
        showAllPunish();
        showRelaTran();
        pickARelaTran();
        this.s = s;
    }

    public void showTran_details(Transaction tran) {
        try {
            txtid.setText(Integer.toString(tran.getId()));
            txttotal.setText(Double.toString(tran.getTotal_p()));
//            total = tran.getTotal_p();
            txtcreate.setText(tran.getCreatedd().toString());
            txtdue.setDate(tran.getDued());
            txtpay.setDate(tran.getPayd());

            if (tran.getStatus() == 0) {
                txtstatus.setText("Borrowing");
            } else {
                if (tran.getStatus() == 1) {
                    txtstatus.setText("Overdue");
                } else {
                    txtstatus.setText("Paid");
                }
            }

//            Readerdao rdao = new Readerdao();
//            Reader r = new Reader();
//            r = rdao.getAReaderById(tran.getCustomer_id());
//            txtreader.setText(r.getName());
            txtreader.setText(Integer.toString(tran.getCustomer_id()));
            txtstaff.setText(Integer.toString(tran.getEmployee_id()));
//            Staffdao sdao = new Staffdao();
//            Staff s = new Staff();
//            s = sdao.getAStaffById(tran.getEmployee_id());
//            txtstaff.setText(s.getName());

            tran_id = tran.getId();
            cus_id = tran.getCustomer_id();
            emp_id = tran.getEmployee_id();
        } catch (NullPointerException ex) {
            txtid.setText("");
            txttotal.setText("");
            txtstatus.setText("");
            txtdue.setDate(null);
            txtpay.setDate(null);
            txtreader.setText("");
            txtstaff.setText("");
            txtcreate.setText("");
        }
    }

    public void showAllPunish() {
        Punishdao pdao = new Punishdao();
        lstp = pdao.getAllPunish();
        DefaultTableModel dtm = (DefaultTableModel) tblpunish.getModel();
        dtm.setRowCount(0);
        for (Punish p : lstp) {
            Vector vt = new Vector();
            vt.add(p.getId());
            vt.add(p.getName());
            vt.add(p.getDescription());

            dtm.addRow(vt);
        }
    }

    public void showRelaTran() {
        Tran_detailsdao tddao = new Tran_detailsdao();
        lsttd = tddao.getAllTran_detailsByTranId(tran_id);
        DefaultTableModel dtm = (DefaultTableModel) tbltran.getModel();
        dtm.setRowCount(0);
        for (Tran_details td : lsttd) {
            Vector vt = new Vector();
            vt.add(td.getId());

            Book_detailsdao bddao = new Book_detailsdao();
            String title = new String();
            title = bddao.getARelaBooksTitle(td.getBdid());
            vt.add(title);

            vt.add(td.getPrice());

            dtm.addRow(vt);
        }
    }

    public void pickARelaTran() {
        tbltran.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowSelected = tbltran.getSelectedRow();
                int row = (int) tbltran.getValueAt(rowSelected, 0);
                Tran_detailsdao tddao = new Tran_detailsdao();
                Tran_details tran = new Tran_details();
                tran = tddao.getATran_detailsById(row);
                txtdid.setText(Integer.toString(tran.getId()));
                txtbid.setText(Integer.toString(tran.getBdid()));
                txtprice.setText(Double.toString(tran.getPrice()));
                txtpunish.setText(Integer.toString(tran.getPid()));

                Book_detailsdao bddao = new Book_detailsdao();
                Book_details bd = new Book_details();
                bd = bddao.getARelaBooksById(tran.getBdid());
                txtrelia.setText(bd.getSku());
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

    public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public int cal(Date d, Date d1) {
//        long millis = System.currentTimeMillis();
//        Date date = new java.sql.Date(millis);
        int c = (int) ((d.getTime() - d1.getTime()) / (24 * 3600 * 1000));
        System.out.println(c);
        return c;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnback = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pntran = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        pnid = new javax.swing.JPanel();
        lblid = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        pnreader = new javax.swing.JPanel();
        lblreader = new javax.swing.JLabel();
        txtreader = new javax.swing.JTextField();
        pnstaff = new javax.swing.JPanel();
        lblstaff = new javax.swing.JLabel();
        txtstaff = new javax.swing.JTextField();
        pnstatus = new javax.swing.JPanel();
        lblstatus = new javax.swing.JLabel();
        txtstatus = new javax.swing.JTextField();
        pndue = new javax.swing.JPanel();
        lbldue = new javax.swing.JLabel();
        txtdue = new com.toedter.calendar.JDateChooser();
        pnpay = new javax.swing.JPanel();
        lblpay = new javax.swing.JLabel();
        txtpay = new com.toedter.calendar.JDateChooser();
        pncreate = new javax.swing.JPanel();
        lblcreate = new javax.swing.JLabel();
        txtcreate = new javax.swing.JTextField();
        pntotal = new javax.swing.JPanel();
        lbltotal = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnadd = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btndel = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        pndetails = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltran = new javax.swing.JTable();
        pndid = new javax.swing.JPanel();
        lbldid = new javax.swing.JLabel();
        txtdid = new javax.swing.JTextField();
        pnbid = new javax.swing.JPanel();
        lblbid = new javax.swing.JLabel();
        txtbid = new javax.swing.JTextField();
        pnpunish = new javax.swing.JPanel();
        lblpunish = new javax.swing.JLabel();
        txtpunish = new javax.swing.JTextField();
        pnprice = new javax.swing.JPanel();
        lblprice = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblpunish = new javax.swing.JTable();
        btndadd = new javax.swing.JButton();
        btndsave = new javax.swing.JButton();
        btnddel = new javax.swing.JButton();
        btndclear = new javax.swing.JButton();
        pnrelia = new javax.swing.JPanel();
        lblrelia = new javax.swing.JLabel();
        txtrelia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnback.setPreferredSize(new java.awt.Dimension(767, 582));

        pntran.setBackground(new java.awt.Color(51, 51, 51));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        pnid.setBackground(new java.awt.Color(51, 51, 51));

        lblid.setBackground(new java.awt.Color(51, 51, 51));
        lblid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblid.setForeground(new java.awt.Color(255, 102, 0));
        lblid.setText("ID:");

        txtid.setBackground(new java.awt.Color(51, 51, 51));
        txtid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtid.setForeground(new java.awt.Color(255, 255, 255));
        txtid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnidLayout = new javax.swing.GroupLayout(pnid);
        pnid.setLayout(pnidLayout);
        pnidLayout.setHorizontalGroup(
            pnidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtid)
            .addGroup(pnidLayout.createSequentialGroup()
                .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
        );
        pnidLayout.setVerticalGroup(
            pnidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnidLayout.createSequentialGroup()
                .addComponent(lblid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnreader.setBackground(new java.awt.Color(51, 51, 51));

        lblreader.setBackground(new java.awt.Color(51, 51, 51));
        lblreader.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblreader.setForeground(new java.awt.Color(255, 102, 0));
        lblreader.setText("Reader:");

        txtreader.setBackground(new java.awt.Color(51, 51, 51));
        txtreader.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtreader.setForeground(new java.awt.Color(255, 255, 255));
        txtreader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnreaderLayout = new javax.swing.GroupLayout(pnreader);
        pnreader.setLayout(pnreaderLayout);
        pnreaderLayout.setHorizontalGroup(
            pnreaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtreader)
            .addGroup(pnreaderLayout.createSequentialGroup()
                .addComponent(lblreader, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 172, Short.MAX_VALUE))
        );
        pnreaderLayout.setVerticalGroup(
            pnreaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnreaderLayout.createSequentialGroup()
                .addComponent(lblreader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtreader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnstaff.setBackground(new java.awt.Color(51, 51, 51));

        lblstaff.setBackground(new java.awt.Color(51, 51, 51));
        lblstaff.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblstaff.setForeground(new java.awt.Color(255, 102, 0));
        lblstaff.setText("Staff:");

        txtstaff.setBackground(new java.awt.Color(51, 51, 51));
        txtstaff.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtstaff.setForeground(new java.awt.Color(255, 255, 255));
        txtstaff.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnstaffLayout = new javax.swing.GroupLayout(pnstaff);
        pnstaff.setLayout(pnstaffLayout);
        pnstaffLayout.setHorizontalGroup(
            pnstaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnstaffLayout.createSequentialGroup()
                .addComponent(lblstaff)
                .addGap(0, 200, Short.MAX_VALUE))
            .addComponent(txtstaff)
        );
        pnstaffLayout.setVerticalGroup(
            pnstaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnstaffLayout.createSequentialGroup()
                .addComponent(lblstaff)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtstaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnstatus.setBackground(new java.awt.Color(51, 51, 51));

        lblstatus.setBackground(new java.awt.Color(51, 51, 51));
        lblstatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblstatus.setForeground(new java.awt.Color(255, 102, 0));
        lblstatus.setText("Status:");

        txtstatus.setBackground(new java.awt.Color(51, 51, 51));
        txtstatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtstatus.setForeground(new java.awt.Color(255, 255, 255));
        txtstatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnstatusLayout = new javax.swing.GroupLayout(pnstatus);
        pnstatus.setLayout(pnstatusLayout);
        pnstatusLayout.setHorizontalGroup(
            pnstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnstatusLayout.createSequentialGroup()
                .addComponent(lblstatus)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txtstatus)
        );
        pnstatusLayout.setVerticalGroup(
            pnstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnstatusLayout.createSequentialGroup()
                .addComponent(lblstatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pndue.setBackground(new java.awt.Color(51, 51, 51));

        lbldue.setBackground(new java.awt.Color(51, 51, 51));
        lbldue.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbldue.setForeground(new java.awt.Color(255, 102, 0));
        lbldue.setText("Due date:");

        txtdue.setDateFormatString("dd/MM/yyyy");
        txtdue.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout pndueLayout = new javax.swing.GroupLayout(pndue);
        pndue.setLayout(pndueLayout);
        pndueLayout.setHorizontalGroup(
            pndueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndueLayout.createSequentialGroup()
                .addComponent(lbldue)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txtdue, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        pndueLayout.setVerticalGroup(
            pndueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndueLayout.createSequentialGroup()
                .addComponent(lbldue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtdue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnpay.setBackground(new java.awt.Color(51, 51, 51));

        lblpay.setBackground(new java.awt.Color(51, 51, 51));
        lblpay.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblpay.setForeground(new java.awt.Color(255, 102, 0));
        lblpay.setText("Pay date:");

        txtpay.setDateFormatString("dd/MM/yyyy");
        txtpay.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnpayLayout = new javax.swing.GroupLayout(pnpay);
        pnpay.setLayout(pnpayLayout);
        pnpayLayout.setHorizontalGroup(
            pnpayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnpayLayout.createSequentialGroup()
                .addComponent(lblpay)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txtpay, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        pnpayLayout.setVerticalGroup(
            pnpayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnpayLayout.createSequentialGroup()
                .addComponent(lblpay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtpay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pncreate.setBackground(new java.awt.Color(51, 51, 51));

        lblcreate.setBackground(new java.awt.Color(51, 51, 51));
        lblcreate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblcreate.setForeground(new java.awt.Color(255, 102, 0));
        lblcreate.setText("Created date:");

        txtcreate.setBackground(new java.awt.Color(51, 51, 51));
        txtcreate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtcreate.setForeground(new java.awt.Color(255, 255, 255));
        txtcreate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pncreateLayout = new javax.swing.GroupLayout(pncreate);
        pncreate.setLayout(pncreateLayout);
        pncreateLayout.setHorizontalGroup(
            pncreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pncreateLayout.createSequentialGroup()
                .addComponent(lblcreate)
                .addGap(0, 61, Short.MAX_VALUE))
            .addComponent(txtcreate)
        );
        pncreateLayout.setVerticalGroup(
            pncreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pncreateLayout.createSequentialGroup()
                .addComponent(lblcreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pntotal.setBackground(new java.awt.Color(51, 51, 51));

        lbltotal.setBackground(new java.awt.Color(51, 51, 51));
        lbltotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbltotal.setForeground(new java.awt.Color(255, 102, 0));
        lbltotal.setText("Total price:");

        txttotal.setBackground(new java.awt.Color(51, 51, 51));
        txttotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txttotal.setForeground(new java.awt.Color(255, 255, 255));
        txttotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pntotalLayout = new javax.swing.GroupLayout(pntotal);
        pntotal.setLayout(pntotalLayout);
        pntotalLayout.setHorizontalGroup(
            pntotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pntotalLayout.createSequentialGroup()
                .addComponent(lbltotal)
                .addGap(0, 41, Short.MAX_VALUE))
            .addComponent(txttotal)
        );
        pntotalLayout.setVerticalGroup(
            pntotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pntotalLayout.createSequentialGroup()
                .addComponent(lbltotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(pnid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(pndue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(pntotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pncreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(pnpay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(pnreader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(pnstaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnid, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pntotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pndue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnpay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pncreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnreader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnstaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        btnadd.setBackground(new java.awt.Color(51, 51, 51));
        btnadd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnadd.setForeground(new java.awt.Color(255, 102, 0));
        btnadd.setText("Add");
        btnadd.setBorder(null);
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnsave.setBackground(new java.awt.Color(51, 51, 51));
        btnsave.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnsave.setForeground(new java.awt.Color(255, 102, 0));
        btnsave.setText("Save");
        btnsave.setBorder(null);
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btndel.setBackground(new java.awt.Color(51, 51, 51));
        btndel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btndel.setForeground(new java.awt.Color(255, 102, 0));
        btndel.setText("Del");
        btndel.setBorder(null);
        btndel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelActionPerformed(evt);
            }
        });

        btnclear.setBackground(new java.awt.Color(51, 51, 51));
        btnclear.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnclear.setForeground(new java.awt.Color(255, 102, 0));
        btnclear.setText("Clear");
        btnclear.setBorder(null);
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnsave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btndel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnclear, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btndel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pntranLayout = new javax.swing.GroupLayout(pntran);
        pntran.setLayout(pntranLayout);
        pntranLayout.setHorizontalGroup(
            pntranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pntranLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pntranLayout.setVerticalGroup(
            pntranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pntranLayout.createSequentialGroup()
                .addGroup(pntranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Transaction", pntran);

        pndetails.setBackground(new java.awt.Color(51, 51, 51));

        tbltran.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbltran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book", "Price"
            }
        ));
        jScrollPane1.setViewportView(tbltran);
        if (tbltran.getColumnModel().getColumnCount() > 0) {
            tbltran.getColumnModel().getColumn(0).setMinWidth(60);
            tbltran.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbltran.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        pndid.setBackground(new java.awt.Color(51, 51, 51));

        lbldid.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbldid.setForeground(new java.awt.Color(255, 102, 0));
        lbldid.setText("ID:");

        txtdid.setBackground(new java.awt.Color(51, 51, 51));
        txtdid.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtdid.setForeground(new java.awt.Color(255, 255, 255));
        txtdid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pndidLayout = new javax.swing.GroupLayout(pndid);
        pndid.setLayout(pndidLayout);
        pndidLayout.setHorizontalGroup(
            pndidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtdid)
            .addGroup(pndidLayout.createSequentialGroup()
                .addComponent(lbldid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pndidLayout.setVerticalGroup(
            pndidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndidLayout.createSequentialGroup()
                .addComponent(lbldid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnbid.setBackground(new java.awt.Color(51, 51, 51));

        lblbid.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblbid.setForeground(new java.awt.Color(255, 102, 0));
        lblbid.setText("Book id:");

        txtbid.setBackground(new java.awt.Color(51, 51, 51));
        txtbid.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtbid.setForeground(new java.awt.Color(255, 255, 255));
        txtbid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnbidLayout = new javax.swing.GroupLayout(pnbid);
        pnbid.setLayout(pnbidLayout);
        pnbidLayout.setHorizontalGroup(
            pnbidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbidLayout.createSequentialGroup()
                .addComponent(lblbid)
                .addGap(0, 60, Short.MAX_VALUE))
            .addComponent(txtbid)
        );
        pnbidLayout.setVerticalGroup(
            pnbidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbidLayout.createSequentialGroup()
                .addComponent(lblbid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtbid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnpunish.setBackground(new java.awt.Color(51, 51, 51));

        lblpunish.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblpunish.setForeground(new java.awt.Color(255, 102, 0));
        lblpunish.setText("Punish:");

        txtpunish.setBackground(new java.awt.Color(51, 51, 51));
        txtpunish.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtpunish.setForeground(new java.awt.Color(255, 255, 255));
        txtpunish.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnpunishLayout = new javax.swing.GroupLayout(pnpunish);
        pnpunish.setLayout(pnpunishLayout);
        pnpunishLayout.setHorizontalGroup(
            pnpunishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnpunishLayout.createSequentialGroup()
                .addComponent(lblpunish)
                .addGap(0, 60, Short.MAX_VALUE))
            .addComponent(txtpunish)
        );
        pnpunishLayout.setVerticalGroup(
            pnpunishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnpunishLayout.createSequentialGroup()
                .addComponent(lblpunish)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtpunish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnprice.setBackground(new java.awt.Color(51, 51, 51));

        lblprice.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblprice.setForeground(new java.awt.Color(255, 102, 0));
        lblprice.setText("Price:");

        txtprice.setEditable(false);
        txtprice.setBackground(new java.awt.Color(51, 51, 51));
        txtprice.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtprice.setForeground(new java.awt.Color(255, 255, 255));
        txtprice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnpriceLayout = new javax.swing.GroupLayout(pnprice);
        pnprice.setLayout(pnpriceLayout);
        pnpriceLayout.setHorizontalGroup(
            pnpriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnpriceLayout.createSequentialGroup()
                .addComponent(lblprice)
                .addGap(0, 60, Short.MAX_VALUE))
            .addComponent(txtprice)
        );
        pnpriceLayout.setVerticalGroup(
            pnpriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnpriceLayout.createSequentialGroup()
                .addComponent(lblprice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        tblpunish.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tblpunish.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
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
        jScrollPane2.setViewportView(tblpunish);
        if (tblpunish.getColumnModel().getColumnCount() > 0) {
            tblpunish.getColumnModel().getColumn(0).setMinWidth(40);
            tblpunish.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblpunish.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        btndadd.setBackground(new java.awt.Color(51, 51, 51));
        btndadd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btndadd.setForeground(new java.awt.Color(255, 102, 0));
        btndadd.setText("Add");
        btndadd.setBorder(null);
        btndadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndaddActionPerformed(evt);
            }
        });

        btndsave.setBackground(new java.awt.Color(51, 51, 51));
        btndsave.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btndsave.setForeground(new java.awt.Color(255, 102, 0));
        btndsave.setText("Save");
        btndsave.setBorder(null);
        btndsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndsaveActionPerformed(evt);
            }
        });

        btnddel.setBackground(new java.awt.Color(51, 51, 51));
        btnddel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnddel.setForeground(new java.awt.Color(255, 102, 0));
        btnddel.setText("Del");
        btnddel.setBorder(null);
        btnddel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnddelActionPerformed(evt);
            }
        });

        btndclear.setBackground(new java.awt.Color(51, 51, 51));
        btndclear.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btndclear.setForeground(new java.awt.Color(255, 102, 0));
        btndclear.setText("Clear");
        btndclear.setBorder(null);
        btndclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndclearActionPerformed(evt);
            }
        });

        pnrelia.setBackground(new java.awt.Color(51, 51, 51));

        lblrelia.setBackground(new java.awt.Color(51, 51, 51));
        lblrelia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblrelia.setForeground(new java.awt.Color(255, 102, 0));
        lblrelia.setText("Reliability:");

        txtrelia.setBackground(new java.awt.Color(51, 51, 51));
        txtrelia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtrelia.setForeground(new java.awt.Color(255, 255, 255));
        txtrelia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnreliaLayout = new javax.swing.GroupLayout(pnrelia);
        pnrelia.setLayout(pnreliaLayout);
        pnreliaLayout.setHorizontalGroup(
            pnreliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnreliaLayout.createSequentialGroup()
                .addComponent(lblrelia)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txtrelia)
        );
        pnreliaLayout.setVerticalGroup(
            pnreliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnreliaLayout.createSequentialGroup()
                .addComponent(lblrelia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtrelia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pndetailsLayout = new javax.swing.GroupLayout(pndetails);
        pndetails.setLayout(pndetailsLayout);
        pndetailsLayout.setHorizontalGroup(
            pndetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndetailsLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pndetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pndetailsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pndetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pndetailsLayout.createSequentialGroup()
                                .addGroup(pndetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pnprice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pndid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pndetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pnbid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pnpunish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(pnrelia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pndetailsLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btndadd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btndsave, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnddel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btndclear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pndetailsLayout.setVerticalGroup(
            pndetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(pndetailsLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(pndetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pndetailsLayout.createSequentialGroup()
                        .addGroup(pndetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pndid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnbid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pndetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnpunish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(pnrelia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pndetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndadd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndsave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnddel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndclear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jTabbedPane1.addTab("Details", pndetails);

        javax.swing.GroupLayout pnbackLayout = new javax.swing.GroupLayout(pnback);
        pnback.setLayout(pnbackLayout);
        pnbackLayout.setHorizontalGroup(
            pnbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbackLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        pnbackLayout.setVerticalGroup(
            pnbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnback, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnback, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        Transactiondao trandao = new Transactiondao();
        long millis = System.currentTimeMillis();
        Date date = new java.sql.Date(millis);
        java.sql.Date due = convertJavaDateToSqlDate(txtdue.getDate());
        java.sql.Date pay = convertJavaDateToSqlDate(txtpay.getDate());
        if (trandao.addNewTran(Integer.parseInt(txtid.getText()), Integer.parseInt(txtreader.getText()), s.getId(), 0, 0, due, pay, date)) {
            JOptionPane.showMessageDialog(null, "Added " + txtid.getText());
            tran_id = Integer.parseInt(txtid.getText());
            System.out.println(tran_id);
        } else {
            JOptionPane.showMessageDialog(null, "Add false");
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        java.sql.Date due = convertJavaDateToSqlDate(txtdue.getDate());
        java.sql.Date pay = convertJavaDateToSqlDate(txtpay.getDate());
        Transactiondao trandao = new Transactiondao();
        int status = 0;
        if (txtstatus.getText().equals("Borrowing")) {
            status = 0;
        } else {
            if (txtstatus.getText().equals("Overdue")) {
                status = 1;
            } else {
                if (txtstatus.getText().equals("Paid")) {
                    status = 2;
                }
            }
        }

        if (trandao.updateTran(Integer.parseInt(txtid.getText()), Integer.parseInt(txtreader.getText()), Integer.parseInt(txtstaff.getText()), Double.parseDouble(txttotal.getText()), status, due, pay, Date.valueOf(txtcreate.getText()))) {
            JOptionPane.showMessageDialog(null, "Saved " + txtid.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Save false");
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btndelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelActionPerformed
        // TODO add your handling code here:
        Transactiondao trandao = new Transactiondao();
        Tran_detailsdao tddao = new Tran_detailsdao();
        if (txtid.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Pick one and ill make it dissapear");
        } else {
            if (trandao.delTran(Integer.parseInt(txtid.getText()))) {
                JOptionPane.showMessageDialog(null, "Deleted " + txtid.getText());
                if (tddao.delRelaTran_details(tran_id)) {
                    System.out.println("Deleted rela transaction_details");
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Delete false");
            }
        }

    }//GEN-LAST:event_btndelActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        txtid.setText("");
        txttotal.setText("");
        txtstatus.setText("");
        txtdue.setDate(null);
        txtpay.setDate(null);
        txtcreate.setText("");
        txtreader.setText("");
        txtstaff.setText("");
    }//GEN-LAST:event_btnclearActionPerformed

    private void btndaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndaddActionPerformed
        // TODO add your handling code here:
        Tran_detailsdao tddao = new Tran_detailsdao();
        Book_detailsdao bddao = new Book_detailsdao();
        Transactiondao trandao = new Transactiondao();
        if (tddao.addNewTran_details(Integer.parseInt(txtbid.getText()), tran_id, 0, 1000)) {
            JOptionPane.showMessageDialog(null, "Added ");
            lsttd = tddao.getAllTran_detailsByTranId(tran_id);
            DefaultTableModel dtm = (DefaultTableModel) tbltran.getModel();
            dtm.setRowCount(0);
            for (Tran_details td : lsttd) {
                Vector vt = new Vector();
                vt.add(td.getId());

                String title = new String();
                title = bddao.getARelaBooksTitle(td.getBdid());
                vt.add(title);

                vt.add(td.getPrice());

                total = total + td.getPrice();
                dtm.addRow(vt);
            }
            trandao.updateTrantotal(tran_id, total);
            
        } else {
            JOptionPane.showMessageDialog(null, "Add false");
        }
    }//GEN-LAST:event_btndaddActionPerformed

    private void btndsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndsaveActionPerformed
        // TODO add your handling code here:
        Transactiondao trandao = new Transactiondao();
        Transaction tran = new Transaction();
        Tran_detailsdao tddao = new Tran_detailsdao();
        Book_detailsdao bddao = new Book_detailsdao();
        Book_details bd = new Book_details();
        if (txtpunish.getText().equals("1")) {
            bd = bddao.getARelaBooksById(Integer.parseInt(txtbid.getText()));
            txtprice.setText(Double.toString(bd.getPrice()));
        } else {
            if (txtpunish.getText().equals("2")) {
                long millis = System.currentTimeMillis();
                Date date = new java.sql.Date(millis);
                tran = trandao.getATranById(tran_id);
                double c = cal(date, tran.getDued()) * 10000;
                txtprice.setText(Double.toString(c));
            } else {
                txtprice.setText("1000");
            }
        }
        if (tddao.updateTran_details(Integer.parseInt(txtdid.getText()), Integer.parseInt(txtbid.getText()), tran_id, Integer.parseInt(txtpunish.getText()), Double.parseDouble(txtprice.getText()))) {
            JOptionPane.showMessageDialog(null, "Saved " + txtdid.getText());
            bddao.updateBook_detailssku(Integer.parseInt(txtbid.getText()), txtrelia.getText());
            lsttd = tddao.getAllTran_detailsByTranId(tran_id);
            DefaultTableModel dtm = (DefaultTableModel) tbltran.getModel();
            dtm.setRowCount(0);
            for (Tran_details td : lsttd) {
                Vector vt = new Vector();
                vt.add(td.getId());

                String title = new String();
                title = bddao.getARelaBooksTitle(td.getBdid());
                vt.add(title);

                vt.add(td.getPrice());

                total = total + td.getPrice();
                dtm.addRow(vt);
            }
            trandao.updateTrantotal(tran_id, total);
        } else {
            JOptionPane.showMessageDialog(null, "Save false");
        }
    }//GEN-LAST:event_btndsaveActionPerformed

    private void btnddelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnddelActionPerformed
        // TODO add your handling code here:
        Tran_detailsdao tddao = new Tran_detailsdao();
        Transactiondao trandao = new Transactiondao();
        Book_detailsdao bddao = new Book_detailsdao();
        if (txtdid.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Pick one and ill make it dissapear");
        } else {
            if (tddao.delTran_details(Integer.parseInt(txtdid.getText()))) {
                JOptionPane.showMessageDialog(null, "Deleted " + txtdid.getText());
                lsttd = tddao.getAllTran_detailsByTranId(tran_id);
                DefaultTableModel dtm = (DefaultTableModel) tbltran.getModel();
                dtm.setRowCount(0);
                for (Tran_details td : lsttd) {
                    Vector vt = new Vector();
                    vt.add(td.getId());

                    String title = new String();
                    title = bddao.getARelaBooksTitle(td.getBdid());
                    vt.add(title);

                    vt.add(td.getPrice());

                    total = total + td.getPrice();
                    dtm.addRow(vt);
                }
                trandao.updateTrantotal(tran_id, total);
            } else {
                JOptionPane.showMessageDialog(null, "Delete false");
            }
        }
    }//GEN-LAST:event_btnddelActionPerformed

    private void btndclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndclearActionPerformed
        // TODO add your handling code here:
        txtdid.setText("");
        txtbid.setText("");
        txtprice.setText("");
        txtrelia.setText("");
        txtpunish.setText("");
    }//GEN-LAST:event_btndclearActionPerformed

    private ArrayList<Transaction> lsttran = null;
    private ArrayList<Tran_details> lsttd = null;
    private ArrayList<Punish> lstp = null;
    int tran_id, cus_id, emp_id;
    private Staff s;
    double total = 0;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndadd;
    private javax.swing.JButton btndclear;
    private javax.swing.JButton btnddel;
    private javax.swing.JButton btndel;
    private javax.swing.JButton btndsave;
    private javax.swing.JButton btnsave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblbid;
    private javax.swing.JLabel lblcreate;
    private javax.swing.JLabel lbldid;
    private javax.swing.JLabel lbldue;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblpay;
    private javax.swing.JLabel lblprice;
    private javax.swing.JLabel lblpunish;
    private javax.swing.JLabel lblreader;
    private javax.swing.JLabel lblrelia;
    private javax.swing.JLabel lblstaff;
    private javax.swing.JLabel lblstatus;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JPanel pnback;
    private javax.swing.JPanel pnbid;
    private javax.swing.JPanel pncreate;
    private javax.swing.JPanel pndetails;
    private javax.swing.JPanel pndid;
    private javax.swing.JPanel pndue;
    private javax.swing.JPanel pnid;
    private javax.swing.JPanel pnpay;
    private javax.swing.JPanel pnprice;
    private javax.swing.JPanel pnpunish;
    private javax.swing.JPanel pnreader;
    private javax.swing.JPanel pnrelia;
    private javax.swing.JPanel pnstaff;
    private javax.swing.JPanel pnstatus;
    private javax.swing.JPanel pntotal;
    private javax.swing.JPanel pntran;
    private javax.swing.JTable tblpunish;
    private javax.swing.JTable tbltran;
    private javax.swing.JTextField txtbid;
    private javax.swing.JTextField txtcreate;
    private javax.swing.JTextField txtdid;
    private com.toedter.calendar.JDateChooser txtdue;
    private javax.swing.JTextField txtid;
    private com.toedter.calendar.JDateChooser txtpay;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtpunish;
    private javax.swing.JTextField txtreader;
    private javax.swing.JTextField txtrelia;
    private javax.swing.JTextField txtstaff;
    private javax.swing.JTextField txtstatus;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
