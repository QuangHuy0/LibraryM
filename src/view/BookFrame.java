/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Authordao;
import dao.Categorydao;
import dao.Publisherdao;
import dao.Book_authordao;
import dao.Book_categorydao;
import dao.Book_detailsdao;
import dao.Book_publisherdao;
import dao.Bookdao;
import dao.Languagesdao;
import dao.Staffdao;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Author;
import model.Book;
import model.Book_author;
import model.Book_category;
import model.Book_details;
import model.Book_publisher;
import model.Category;
import model.Languages;
import model.Publisher;
import model.Staff;

/**
 *
 * @author Uygi
 */
public class BookFrame extends javax.swing.JFrame {

    /**
     * Creates new form BookFrame
     */
    public BookFrame(Book b, Staff s) {
        initComponents();
        showdetails(b);
        showAllAuthor();
        showAllPublisher();
        showAllCategory();
        showRelaAuthor();
        showRelaPublisher();
        showRelaCategory();
        showRelaBooks();
        pickARelabook();
        this.s = s;
    }

    public void showdetails(Book b) {
        Languagesdao ldao = new Languagesdao();
        Languages l = new Languages();
        txtlanguages.removeAllItems();
        txtlanguages.addItem("Select");
        lstl = ldao.getAllLanguages();
        for (Languages la : lstl) {
            txtlanguages.addItem(la.toString());
        }
        try {
            txtid.setText(Integer.toString(b.getId()));
            txttitle.setText(b.getTitle());
            l = ldao.getALanguagesById(b.getLang_id());
            txtlanguages.setSelectedItem(l.toString());

            txtedition.setText(Integer.toString(b.getEdition()));
            txtquantity.setText(Integer.toString(b.getQuantity()));
            txtstatus.setText(Integer.toString(b.getStatus()));
            txtpublishy.setText(Integer.toString(b.getPublish_year()));
            txtdescription.setText(b.getDescription());

            Staff st = new Staff();
            Staffdao stdao = new Staffdao();
            st = stdao.getAStaffById(b.getCreatedu());
            txtcreateduser.setText(st.getName());
            createdu = b.getCreatedu();
            txtcreateddate.setText(b.getCreatedd().toString());
            
            st = stdao.getAStaffById(b.getUpdatedu());
            txtupdateduser.setText(st.getName());
            txtupdateddate.setText(b.getUpdatedd().toString());
            book_id = b.getId();
        } catch (NullPointerException ex) {
            txtid.setText("");
            txttitle.setText("");
            txtlanguages.setSelectedItem("Select");
            txtedition.setText("");
            txtquantity.setText("");
            txtstatus.setText("");
            txtpublishy.setText("");
            txtdescription.setText("");
            txtcreateduser.setText("");
            txtcreateddate.setText("");
            txtupdateduser.setText("");
            txtupdateddate.setText("");
        }
    }

    public void showAllAuthor() {
        Authordao adao = new Authordao();
        lsta = adao.getAllAuthor();
        DefaultTableModel dtm = (DefaultTableModel) tbllista.getModel();
        dtm.setRowCount(0);
        for (Author a : lsta) {
            Vector<Object> vt = new Vector();
            vt.add(a.getId());
            vt.add(a.getName());
            vt.add(a.getDescription());

            dtm.addRow(vt);
        }
    }

    public void showAllPublisher() {
        Publisherdao pdao = new Publisherdao();
        lstp = pdao.getAllPublisher();
        DefaultTableModel dtm = (DefaultTableModel) tbllistp.getModel();
        dtm.setRowCount(0);
        for (Publisher p : lstp) {
            Vector<Object> vt = new Vector();
            vt.add(p.getId());
            vt.add(p.getName());
            vt.add(p.getDescription());

            dtm.addRow(vt);
        }
    }

    public void showAllCategory() {
        Categorydao cdao = new Categorydao();
        lstc = cdao.getAllCategory();
        DefaultTableModel dtm = (DefaultTableModel) tbllistc.getModel();
        dtm.setRowCount(0);
        for (Category c : lstc) {
            Vector<Object> vt = new Vector();
            vt.add(c.getId());
            vt.add(c.getName());
            vt.add(c.getDescription());

            dtm.addRow(vt);
        }
    }

    public void showRelaAuthor() {
        Book_authordao badao = new Book_authordao();
        lstba = badao.getAllRelaAuthorByBookId(book_id);
        DefaultTableModel dtm = (DefaultTableModel) tblbooka.getModel();
        dtm.setRowCount(0);
        for (Book_author ba : lstba) {
            Vector<Object> vt = new Vector();
            vt.add(ba.getId());
            Authordao adao = new Authordao();
            Author a = adao.getAnAuthorById(ba.getAuthor_id());
            vt.add(a.getName());

            dtm.addRow(vt);
        }
    }

    public void showRelaPublisher() {
        Book_publisherdao bpdao = new Book_publisherdao();
        lstbp = bpdao.getAllRelaPublisherByBookId(book_id);
        DefaultTableModel dtm = (DefaultTableModel) tblbookp.getModel();
        dtm.setRowCount(0);
        for (Book_publisher bp : lstbp) {
            Vector<Object> vt = new Vector();
            vt.add(bp.getId());
            Publisherdao pdao = new Publisherdao();
            Publisher p = pdao.getPublisherById(bp.getPublisher_id());
            vt.add(p.getName());

            dtm.addRow(vt);
        }
    }

    public void showRelaCategory() {
        Book_categorydao bcdao = new Book_categorydao();
        lstbc = bcdao.getAllRelaCategoryByBookId(book_id);
        DefaultTableModel dtm = (DefaultTableModel) tblbookc.getModel();
        dtm.setRowCount(0);
        for (Book_category bc : lstbc) {
            Vector<Object> vt = new Vector();
            vt.add(bc.getId());
            Categorydao cdao = new Categorydao();
            Category c = cdao.getCategoryById(bc.getCategory_id());
            vt.add(c.getName());

            dtm.addRow(vt);
        }
    }

    public void showRelaBooks() {
        Book_detailsdao bddao = new Book_detailsdao();
        lstbd = bddao.getAllRelaBooks(book_id);
        DefaultTableModel dtm = (DefaultTableModel) tblrelab.getModel();
        dtm.setRowCount(0);
        for (Book_details bd : lstbd) {
            Vector<Object> vt = new Vector();
            vt.add(bd.getId());
            vt.add(bd.getSku());
            vt.add(bd.getPrice());
            vt.add(bd.getStatus());

            dtm.addRow(vt);
        }
    }

    public void pickARelabook() {
        tblrelab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowSelected = tblrelab.getSelectedRow();
                int row = (int) tblrelab.getValueAt(rowSelected, 0);
                Book_detailsdao bddao = new Book_detailsdao();
                Book_details bd = new Book_details();
                bd = bddao.getARelaBooksById(row);
                txtbid.setText(Integer.toString(bd.getId()));
                txtbrelia.setText(bd.getSku());
                txtbprice.setText(Double.toString(bd.getPrice()));
                txtbstatus.setText(Integer.toString(bd.getStatus()));
                txtbcreatedd.setText(bd.getCreatedd().toString());
                
                Staff st = new Staff();
                Staffdao stdao = new Staffdao();
                st = stdao.getAStaffById(bd.getCreatedu());
                bcreatedu = bd.getCreatedu();
                txtbcreatedu.setText(st.getName());
                txtbupdatedd.setText(bd.getUpdatedd().toString());
                st = stdao.getAStaffById(bd.getUpdatedu());
                txtbupdatedu.setText(st.getName());
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

//    public void pickIdAuthor() {
//        tblbooka.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                Book_authordao bdao = new Book_authordao();
//                int rowSelected = tblbooka.getSelectedRow();
//                int row = (int) tblbooka.getValueAt(rowSelected, 0);
//                txtidauthor.setText(Integer.toString((int) tblbooka.getValueAt(rowSelected, 0)));
//            }
//            @Override
//            public void mousePressed(MouseEvent e) {
//            }
//            @Override
//            public void mouseReleased(MouseEvent e) {
//            }
//            @Override
//            public void mouseEntered(MouseEvent e) {
//            }
//            @Override
//            public void mouseExited(MouseEvent e) {
//            }
//    });
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        pnback = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pndetails = new javax.swing.JPanel();
        pnleft = new javax.swing.JPanel();
        pnid = new javax.swing.JPanel();
        lblid = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        pntitle = new javax.swing.JPanel();
        txttitle = new javax.swing.JTextField();
        pnedition = new javax.swing.JPanel();
        lbleidition = new javax.swing.JLabel();
        txtedition = new javax.swing.JTextField();
        pnquantity = new javax.swing.JPanel();
        lblquantity = new javax.swing.JLabel();
        txtquantity = new javax.swing.JTextField();
        pnlanguages = new javax.swing.JPanel();
        lbllanguages = new javax.swing.JLabel();
        txtlanguages = new javax.swing.JComboBox<>();
        pnstatus = new javax.swing.JPanel();
        lblstatus = new javax.swing.JLabel();
        txtstatus = new javax.swing.JTextField();
        pnpublishy = new javax.swing.JPanel();
        lblpublishy = new javax.swing.JLabel();
        txtpublishy = new javax.swing.JTextField();
        pndescription = new javax.swing.JPanel();
        lbldescription = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtdescription = new javax.swing.JTextArea();
        pncreateduser = new javax.swing.JPanel();
        lblcreateduser = new javax.swing.JLabel();
        txtcreateduser = new javax.swing.JTextField();
        pncreateddate = new javax.swing.JPanel();
        lblcreateddate = new javax.swing.JLabel();
        txtcreateddate = new javax.swing.JTextField();
        pnupdateduser = new javax.swing.JPanel();
        lblupdateduser = new javax.swing.JLabel();
        txtupdateduser = new javax.swing.JTextField();
        pnupdateddate = new javax.swing.JPanel();
        lblupdateddate = new javax.swing.JLabel();
        txtupdateddate = new javax.swing.JTextField();
        pnright = new javax.swing.JPanel();
        btnadd = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btndel = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        pnauthor = new javax.swing.JPanel();
        pnleftauthor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbooka = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbllista = new javax.swing.JTable();
        pnright1 = new javax.swing.JPanel();
        btnaddauthor = new javax.swing.JButton();
        btndelauthor = new javax.swing.JButton();
        txtsearchauthor = new javax.swing.JTextField();
        txtidauthor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnpublisher = new javax.swing.JPanel();
        pnleftpublisher = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblbookp = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbllistp = new javax.swing.JTable();
        pnright3 = new javax.swing.JPanel();
        btnaddpublisher = new javax.swing.JButton();
        btndelpublisher = new javax.swing.JButton();
        txtsearchpublisher = new javax.swing.JTextField();
        lblsearchpub = new javax.swing.JLabel();
        lblidpub = new javax.swing.JLabel();
        txtidpublisher = new javax.swing.JTextField();
        pncategory = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblbookc = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbllistc = new javax.swing.JTable();
        pnright4 = new javax.swing.JPanel();
        btnaddcat = new javax.swing.JButton();
        btndelcat = new javax.swing.JButton();
        lblsearchcat = new javax.swing.JLabel();
        txtsearchcat = new javax.swing.JTextField();
        lblidcat = new javax.swing.JLabel();
        txtidcat = new javax.swing.JTextField();
        pnbooks = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblrelab = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        pnbid = new javax.swing.JPanel();
        lblbid = new javax.swing.JLabel();
        txtbid = new javax.swing.JTextField();
        pnbrelia = new javax.swing.JPanel();
        lblbrelia = new javax.swing.JLabel();
        txtbrelia = new javax.swing.JTextField();
        pnbcreatedu = new javax.swing.JPanel();
        lblbcreatedu = new javax.swing.JLabel();
        txtbcreatedu = new javax.swing.JTextField();
        pnbupdatedu = new javax.swing.JPanel();
        lblbupdatedu = new javax.swing.JLabel();
        txtbupdatedu = new javax.swing.JTextField();
        pnbupdatedd = new javax.swing.JPanel();
        lblbupdatedd = new javax.swing.JLabel();
        txtbupdatedd = new javax.swing.JTextField();
        pnbcreatedd = new javax.swing.JPanel();
        lblbcreatedd = new javax.swing.JLabel();
        txtbcreatedd = new javax.swing.JTextField();
        pnbprice = new javax.swing.JPanel();
        lblbprice = new javax.swing.JLabel();
        txtbprice = new javax.swing.JTextField();
        pnbstatus = new javax.swing.JPanel();
        lblbstatus = new javax.swing.JLabel();
        txtbstatus = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnbadd = new javax.swing.JButton();
        btnbsave = new javax.swing.JButton();
        btnbdel = new javax.swing.JButton();
        btnbclear = new javax.swing.JButton();
        txttime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnback.setBackground(new java.awt.Color(51, 51, 51));

        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        pndetails.setBackground(new java.awt.Color(51, 51, 51));
        pndetails.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        pnleft.setBackground(new java.awt.Color(51, 51, 51));

        pnid.setBackground(new java.awt.Color(51, 51, 51));
        pnid.setForeground(new java.awt.Color(0, 153, 0));

        lblid.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblid.setForeground(new java.awt.Color(0, 153, 0));
        lblid.setText("ID:");

        txtid.setBackground(new java.awt.Color(51, 51, 51));
        txtid.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtid.setForeground(new java.awt.Color(0, 153, 0));
        txtid.setBorder(null);

        javax.swing.GroupLayout pnidLayout = new javax.swing.GroupLayout(pnid);
        pnid.setLayout(pnidLayout);
        pnidLayout.setHorizontalGroup(
            pnidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnidLayout.createSequentialGroup()
                .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        pnidLayout.setVerticalGroup(
            pnidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtid))
        );

        pntitle.setBackground(new java.awt.Color(0, 0, 102));

        txttitle.setBackground(new java.awt.Color(51, 51, 51));
        txttitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txttitle.setForeground(new java.awt.Color(255, 102, 0));
        txttitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pntitleLayout = new javax.swing.GroupLayout(pntitle);
        pntitle.setLayout(pntitleLayout);
        pntitleLayout.setHorizontalGroup(
            pntitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pntitleLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(txttitle, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        pntitleLayout.setVerticalGroup(
            pntitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txttitle, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
        );

        pnedition.setBackground(new java.awt.Color(51, 51, 51));

        lbleidition.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbleidition.setForeground(new java.awt.Color(255, 102, 0));
        lbleidition.setText("Edition:");

        txtedition.setBackground(new java.awt.Color(51, 51, 51));
        txtedition.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtedition.setForeground(new java.awt.Color(255, 255, 255));
        txtedition.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pneditionLayout = new javax.swing.GroupLayout(pnedition);
        pnedition.setLayout(pneditionLayout);
        pneditionLayout.setHorizontalGroup(
            pneditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneditionLayout.createSequentialGroup()
                .addComponent(lbleidition, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
            .addComponent(txtedition)
        );
        pneditionLayout.setVerticalGroup(
            pneditionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pneditionLayout.createSequentialGroup()
                .addComponent(lbleidition, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtedition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnquantity.setBackground(new java.awt.Color(51, 51, 51));

        lblquantity.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblquantity.setForeground(new java.awt.Color(255, 102, 0));
        lblquantity.setText("Quantity:");

        txtquantity.setBackground(new java.awt.Color(51, 51, 51));
        txtquantity.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtquantity.setForeground(new java.awt.Color(255, 255, 255));
        txtquantity.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnquantityLayout = new javax.swing.GroupLayout(pnquantity);
        pnquantity.setLayout(pnquantityLayout);
        pnquantityLayout.setHorizontalGroup(
            pnquantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnquantityLayout.createSequentialGroup()
                .addComponent(lblquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
            .addComponent(txtquantity)
        );
        pnquantityLayout.setVerticalGroup(
            pnquantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnquantityLayout.createSequentialGroup()
                .addComponent(lblquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlanguages.setBackground(new java.awt.Color(51, 51, 51));

        lbllanguages.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbllanguages.setForeground(new java.awt.Color(255, 102, 0));
        lbllanguages.setText("Languages:");

        txtlanguages.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtlanguages.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnlanguagesLayout = new javax.swing.GroupLayout(pnlanguages);
        pnlanguages.setLayout(pnlanguagesLayout);
        pnlanguagesLayout.setHorizontalGroup(
            pnlanguagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlanguagesLayout.createSequentialGroup()
                .addComponent(lbllanguages, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txtlanguages, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlanguagesLayout.setVerticalGroup(
            pnlanguagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlanguagesLayout.createSequentialGroup()
                .addComponent(lbllanguages, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtlanguages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnstatus.setBackground(new java.awt.Color(51, 51, 51));

        lblstatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblstatus.setForeground(new java.awt.Color(255, 102, 0));
        lblstatus.setText("Status:");

        txtstatus.setBackground(new java.awt.Color(51, 51, 51));
        txtstatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtstatus.setForeground(new java.awt.Color(255, 255, 255));
        txtstatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnstatusLayout = new javax.swing.GroupLayout(pnstatus);
        pnstatus.setLayout(pnstatusLayout);
        pnstatusLayout.setHorizontalGroup(
            pnstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnstatusLayout.createSequentialGroup()
                .addComponent(lblstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
            .addComponent(txtstatus)
        );
        pnstatusLayout.setVerticalGroup(
            pnstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnstatusLayout.createSequentialGroup()
                .addComponent(lblstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnpublishy.setBackground(new java.awt.Color(51, 51, 51));

        lblpublishy.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblpublishy.setForeground(new java.awt.Color(255, 102, 0));
        lblpublishy.setText("Publish year:");

        txtpublishy.setBackground(new java.awt.Color(51, 51, 51));
        txtpublishy.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtpublishy.setForeground(new java.awt.Color(255, 255, 255));
        txtpublishy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnpublishyLayout = new javax.swing.GroupLayout(pnpublishy);
        pnpublishy.setLayout(pnpublishyLayout);
        pnpublishyLayout.setHorizontalGroup(
            pnpublishyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnpublishyLayout.createSequentialGroup()
                .addComponent(lblpublishy, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
            .addComponent(txtpublishy)
        );
        pnpublishyLayout.setVerticalGroup(
            pnpublishyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnpublishyLayout.createSequentialGroup()
                .addComponent(lblpublishy, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpublishy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pndescription.setBackground(new java.awt.Color(51, 51, 51));

        lbldescription.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbldescription.setForeground(new java.awt.Color(255, 102, 0));
        lbldescription.setText("Description:");

        txtdescription.setBackground(new java.awt.Color(51, 51, 51));
        txtdescription.setColumns(20);
        txtdescription.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtdescription.setForeground(new java.awt.Color(255, 255, 255));
        txtdescription.setRows(5);
        txtdescription.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jScrollPane8.setViewportView(txtdescription);

        javax.swing.GroupLayout pndescriptionLayout = new javax.swing.GroupLayout(pndescription);
        pndescription.setLayout(pndescriptionLayout);
        pndescriptionLayout.setHorizontalGroup(
            pndescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndescriptionLayout.createSequentialGroup()
                .addComponent(lbldescription, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane8)
        );
        pndescriptionLayout.setVerticalGroup(
            pndescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndescriptionLayout.createSequentialGroup()
                .addComponent(lbldescription, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8))
        );

        pncreateduser.setBackground(new java.awt.Color(51, 51, 51));

        lblcreateduser.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblcreateduser.setForeground(new java.awt.Color(255, 102, 0));
        lblcreateduser.setText("Created user:");

        txtcreateduser.setEditable(false);
        txtcreateduser.setBackground(new java.awt.Color(51, 51, 51));
        txtcreateduser.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtcreateduser.setForeground(new java.awt.Color(255, 255, 255));
        txtcreateduser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pncreateduserLayout = new javax.swing.GroupLayout(pncreateduser);
        pncreateduser.setLayout(pncreateduserLayout);
        pncreateduserLayout.setHorizontalGroup(
            pncreateduserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pncreateduserLayout.createSequentialGroup()
                .addComponent(lblcreateduser, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txtcreateduser)
        );
        pncreateduserLayout.setVerticalGroup(
            pncreateduserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pncreateduserLayout.createSequentialGroup()
                .addComponent(lblcreateduser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcreateduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pncreateddate.setBackground(new java.awt.Color(51, 51, 51));

        lblcreateddate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblcreateddate.setForeground(new java.awt.Color(255, 102, 0));
        lblcreateddate.setText("Created date:");

        txtcreateddate.setEditable(false);
        txtcreateddate.setBackground(new java.awt.Color(51, 51, 51));
        txtcreateddate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtcreateddate.setForeground(new java.awt.Color(255, 255, 255));
        txtcreateddate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pncreateddateLayout = new javax.swing.GroupLayout(pncreateddate);
        pncreateddate.setLayout(pncreateddateLayout);
        pncreateddateLayout.setHorizontalGroup(
            pncreateddateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pncreateddateLayout.createSequentialGroup()
                .addComponent(lblcreateddate, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
            .addComponent(txtcreateddate)
        );
        pncreateddateLayout.setVerticalGroup(
            pncreateddateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pncreateddateLayout.createSequentialGroup()
                .addComponent(lblcreateddate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcreateddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnupdateduser.setBackground(new java.awt.Color(51, 51, 51));

        lblupdateduser.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblupdateduser.setForeground(new java.awt.Color(255, 102, 0));
        lblupdateduser.setText("Updated user:");

        txtupdateduser.setEditable(false);
        txtupdateduser.setBackground(new java.awt.Color(51, 51, 51));
        txtupdateduser.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtupdateduser.setForeground(new java.awt.Color(255, 255, 255));
        txtupdateduser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnupdateduserLayout = new javax.swing.GroupLayout(pnupdateduser);
        pnupdateduser.setLayout(pnupdateduserLayout);
        pnupdateduserLayout.setHorizontalGroup(
            pnupdateduserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnupdateduserLayout.createSequentialGroup()
                .addComponent(lblupdateduser, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 149, Short.MAX_VALUE))
            .addComponent(txtupdateduser)
        );
        pnupdateduserLayout.setVerticalGroup(
            pnupdateduserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnupdateduserLayout.createSequentialGroup()
                .addComponent(lblupdateduser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtupdateduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnupdateddate.setBackground(new java.awt.Color(51, 51, 51));

        lblupdateddate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblupdateddate.setForeground(new java.awt.Color(255, 102, 0));
        lblupdateddate.setText("Updated date:");

        txtupdateddate.setEditable(false);
        txtupdateddate.setBackground(new java.awt.Color(51, 51, 51));
        txtupdateddate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtupdateddate.setForeground(new java.awt.Color(255, 255, 255));
        txtupdateddate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnupdateddateLayout = new javax.swing.GroupLayout(pnupdateddate);
        pnupdateddate.setLayout(pnupdateddateLayout);
        pnupdateddateLayout.setHorizontalGroup(
            pnupdateddateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnupdateddateLayout.createSequentialGroup()
                .addComponent(lblupdateddate, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
            .addComponent(txtupdateddate)
        );
        pnupdateddateLayout.setVerticalGroup(
            pnupdateddateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnupdateddateLayout.createSequentialGroup()
                .addComponent(lblupdateddate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtupdateddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnleftLayout = new javax.swing.GroupLayout(pnleft);
        pnleft.setLayout(pnleftLayout);
        pnleftLayout.setHorizontalGroup(
            pnleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pntitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnleftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnleftLayout.createSequentialGroup()
                        .addGroup(pnleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnedition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(pnleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnpublishy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnleftLayout.createSequentialGroup()
                        .addGroup(pnleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnupdateduser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pncreateduser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pncreateddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnupdateddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlanguages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pndescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        pnleftLayout.setVerticalGroup(
            pnleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnleftLayout.createSequentialGroup()
                .addComponent(pnid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pntitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnleftLayout.createSequentialGroup()
                        .addGroup(pnleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnleftLayout.createSequentialGroup()
                                .addComponent(pnquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pnpublishy, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnleftLayout.createSequentialGroup()
                                .addComponent(pnedition, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pnstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(pnleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pncreateduser, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pncreateddate, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnupdateduser, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnupdateddate, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnleftLayout.createSequentialGroup()
                        .addComponent(pnlanguages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pndescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnright.setBackground(new java.awt.Color(51, 51, 51));

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

        javax.swing.GroupLayout pnrightLayout = new javax.swing.GroupLayout(pnright);
        pnright.setLayout(pnrightLayout);
        pnrightLayout.setHorizontalGroup(
            pnrightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnrightLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnrightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        pnrightLayout.setVerticalGroup(
            pnrightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnrightLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btndel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pndetailsLayout = new javax.swing.GroupLayout(pndetails);
        pndetails.setLayout(pndetailsLayout);
        pndetailsLayout.setHorizontalGroup(
            pndetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndetailsLayout.createSequentialGroup()
                .addComponent(pnleft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnright, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pndetailsLayout.setVerticalGroup(
            pndetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pndetailsLayout.createSequentialGroup()
                .addGroup(pndetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnleft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnright, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Details", pndetails);

        pnauthor.setBackground(new java.awt.Color(51, 51, 51));

        tblbooka.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblbooka.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblbooka);
        if (tblbooka.getColumnModel().getColumnCount() > 0) {
            tblbooka.getColumnModel().getColumn(0).setMinWidth(40);
            tblbooka.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblbooka.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        tbllista.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbllista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbllista);
        if (tbllista.getColumnModel().getColumnCount() > 0) {
            tbllista.getColumnModel().getColumn(0).setMinWidth(40);
            tbllista.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbllista.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        javax.swing.GroupLayout pnleftauthorLayout = new javax.swing.GroupLayout(pnleftauthor);
        pnleftauthor.setLayout(pnleftauthorLayout);
        pnleftauthorLayout.setHorizontalGroup(
            pnleftauthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnleftauthorLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnleftauthorLayout.setVerticalGroup(
            pnleftauthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pnright1.setBackground(new java.awt.Color(51, 51, 51));

        btnaddauthor.setBackground(new java.awt.Color(51, 51, 51));
        btnaddauthor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnaddauthor.setForeground(new java.awt.Color(255, 102, 0));
        btnaddauthor.setText("Add");
        btnaddauthor.setBorder(null);
        btnaddauthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddauthorActionPerformed(evt);
            }
        });

        btndelauthor.setBackground(new java.awt.Color(51, 51, 51));
        btndelauthor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btndelauthor.setForeground(new java.awt.Color(255, 102, 0));
        btndelauthor.setText("Del");
        btndelauthor.setBorder(null);
        btndelauthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelauthorActionPerformed(evt);
            }
        });

        txtsearchauthor.setBackground(new java.awt.Color(51, 51, 51));
        txtsearchauthor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtsearchauthor.setForeground(new java.awt.Color(255, 255, 255));
        txtsearchauthor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        txtsearchauthor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearchauthorKeyPressed(evt);
            }
        });

        txtidauthor.setBackground(new java.awt.Color(51, 51, 51));
        txtidauthor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtidauthor.setForeground(new java.awt.Color(255, 255, 255));
        txtidauthor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Search author name:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("ID:");

        javax.swing.GroupLayout pnright1Layout = new javax.swing.GroupLayout(pnright1);
        pnright1.setLayout(pnright1Layout);
        pnright1Layout.setHorizontalGroup(
            pnright1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnright1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnright1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnaddauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(pnright1Layout.createSequentialGroup()
                .addGroup(pnright1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtidauthor)
                    .addComponent(txtsearchauthor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnright1Layout.createSequentialGroup()
                        .addGroup(pnright1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnright1Layout.setVerticalGroup(
            pnright1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnright1Layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtsearchauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(txtidauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnaddauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btndelauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout pnauthorLayout = new javax.swing.GroupLayout(pnauthor);
        pnauthor.setLayout(pnauthorLayout);
        pnauthorLayout.setHorizontalGroup(
            pnauthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnauthorLayout.createSequentialGroup()
                .addComponent(pnleftauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnright1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnauthorLayout.setVerticalGroup(
            pnauthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnleftauthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnright1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Author", pnauthor);

        pnleftpublisher.setPreferredSize(new java.awt.Dimension(728, 0));

        jScrollPane4.setPreferredSize(new java.awt.Dimension(452, 371));

        tblbookp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblbookp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblbookp);
        if (tblbookp.getColumnModel().getColumnCount() > 0) {
            tblbookp.getColumnModel().getColumn(0).setMinWidth(40);
            tblbookp.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblbookp.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        tbllistp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbllistp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tbllistp);
        if (tbllistp.getColumnModel().getColumnCount() > 0) {
            tbllistp.getColumnModel().getColumn(0).setMinWidth(40);
            tbllistp.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbllistp.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        javax.swing.GroupLayout pnleftpublisherLayout = new javax.swing.GroupLayout(pnleftpublisher);
        pnleftpublisher.setLayout(pnleftpublisherLayout);
        pnleftpublisherLayout.setHorizontalGroup(
            pnleftpublisherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnleftpublisherLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnleftpublisherLayout.setVerticalGroup(
            pnleftpublisherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pnright3.setBackground(new java.awt.Color(51, 51, 51));
        pnright3.setPreferredSize(new java.awt.Dimension(155, 365));

        btnaddpublisher.setBackground(new java.awt.Color(51, 51, 51));
        btnaddpublisher.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnaddpublisher.setForeground(new java.awt.Color(255, 102, 0));
        btnaddpublisher.setText("Add");
        btnaddpublisher.setBorder(null);
        btnaddpublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddpublisherActionPerformed(evt);
            }
        });

        btndelpublisher.setBackground(new java.awt.Color(51, 51, 51));
        btndelpublisher.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btndelpublisher.setForeground(new java.awt.Color(255, 102, 0));
        btndelpublisher.setText("Del");
        btndelpublisher.setBorder(null);
        btndelpublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelpublisherActionPerformed(evt);
            }
        });

        txtsearchpublisher.setBackground(new java.awt.Color(51, 51, 51));
        txtsearchpublisher.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtsearchpublisher.setForeground(new java.awt.Color(255, 255, 255));
        txtsearchpublisher.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        txtsearchpublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchpublisherActionPerformed(evt);
            }
        });
        txtsearchpublisher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearchpublisherKeyPressed(evt);
            }
        });

        lblsearchpub.setBackground(new java.awt.Color(51, 51, 51));
        lblsearchpub.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblsearchpub.setForeground(new java.awt.Color(255, 102, 0));
        lblsearchpub.setText("Search publisher name:");

        lblidpub.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblidpub.setForeground(new java.awt.Color(255, 102, 0));
        lblidpub.setText("ID:");

        txtidpublisher.setBackground(new java.awt.Color(51, 51, 51));
        txtidpublisher.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtidpublisher.setForeground(new java.awt.Color(255, 255, 255));
        txtidpublisher.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnright3Layout = new javax.swing.GroupLayout(pnright3);
        pnright3.setLayout(pnright3Layout);
        pnright3Layout.setHorizontalGroup(
            pnright3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnright3Layout.createSequentialGroup()
                .addComponent(lblsearchpub)
                .addGap(0, 99, Short.MAX_VALUE))
            .addGroup(pnright3Layout.createSequentialGroup()
                .addGroup(pnright3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnright3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnright3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtsearchpublisher)
                            .addComponent(txtidpublisher)))
                    .addGroup(pnright3Layout.createSequentialGroup()
                        .addGroup(pnright3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnright3Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(pnright3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btndelpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnaddpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnright3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblidpub)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnright3Layout.setVerticalGroup(
            pnright3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnright3Layout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addComponent(lblsearchpub)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtsearchpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblidpub)
                .addGap(1, 1, 1)
                .addComponent(txtidpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnaddpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btndelpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout pnpublisherLayout = new javax.swing.GroupLayout(pnpublisher);
        pnpublisher.setLayout(pnpublisherLayout);
        pnpublisherLayout.setHorizontalGroup(
            pnpublisherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnpublisherLayout.createSequentialGroup()
                .addComponent(pnleftpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnright3, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
        );
        pnpublisherLayout.setVerticalGroup(
            pnpublisherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnright3, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
            .addComponent(pnleftpublisher, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Publisher", pnpublisher);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        tblbookc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblbookc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblbookc);
        if (tblbookc.getColumnModel().getColumnCount() > 0) {
            tblbookc.getColumnModel().getColumn(0).setMinWidth(40);
            tblbookc.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblbookc.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        tbllistc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbllistc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tbllistc);
        if (tbllistc.getColumnModel().getColumnCount() > 0) {
            tbllistc.getColumnModel().getColumn(0).setMinWidth(40);
            tbllistc.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbllistc.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pnright4.setBackground(new java.awt.Color(51, 51, 51));

        btnaddcat.setBackground(new java.awt.Color(51, 51, 51));
        btnaddcat.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnaddcat.setForeground(new java.awt.Color(255, 102, 0));
        btnaddcat.setText("Add");
        btnaddcat.setBorder(null);
        btnaddcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddcatActionPerformed(evt);
            }
        });

        btndelcat.setBackground(new java.awt.Color(51, 51, 51));
        btndelcat.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btndelcat.setForeground(new java.awt.Color(255, 102, 0));
        btndelcat.setText("Del");
        btndelcat.setBorder(null);
        btndelcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelcatActionPerformed(evt);
            }
        });

        lblsearchcat.setBackground(new java.awt.Color(51, 51, 51));
        lblsearchcat.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblsearchcat.setForeground(new java.awt.Color(255, 102, 0));
        lblsearchcat.setText("Search category name:");

        txtsearchcat.setBackground(new java.awt.Color(51, 51, 51));
        txtsearchcat.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtsearchcat.setForeground(new java.awt.Color(255, 255, 255));
        txtsearchcat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        txtsearchcat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearchcatKeyPressed(evt);
            }
        });

        lblidcat.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblidcat.setForeground(new java.awt.Color(255, 102, 0));
        lblidcat.setText("ID:");

        txtidcat.setBackground(new java.awt.Color(51, 51, 51));
        txtidcat.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtidcat.setForeground(new java.awt.Color(255, 255, 255));
        txtidcat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnright4Layout = new javax.swing.GroupLayout(pnright4);
        pnright4.setLayout(pnright4Layout);
        pnright4Layout.setHorizontalGroup(
            pnright4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnright4Layout.createSequentialGroup()
                .addGroup(pnright4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnright4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnright4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidcat, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtsearchcat)))
                    .addGroup(pnright4Layout.createSequentialGroup()
                        .addGroup(pnright4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnright4Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(pnright4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btndelcat, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnaddcat, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnright4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblsearchcat)))
                        .addGap(0, 81, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnright4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblidcat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnright4Layout.setVerticalGroup(
            pnright4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnright4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblsearchcat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtsearchcat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblidcat)
                .addGap(5, 5, 5)
                .addComponent(txtidcat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnaddcat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btndelcat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout pncategoryLayout = new javax.swing.GroupLayout(pncategory);
        pncategory.setLayout(pncategoryLayout);
        pncategoryLayout.setHorizontalGroup(
            pncategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pncategoryLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnright4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pncategoryLayout.setVerticalGroup(
            pncategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnright4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Category", pncategory);

        pnbooks.setBackground(new java.awt.Color(51, 51, 51));
        pnbooks.setForeground(new java.awt.Color(255, 102, 0));

        tblrelab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Reliabitily", "Price", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tblrelab);
        if (tblrelab.getColumnModel().getColumnCount() > 0) {
            tblrelab.getColumnModel().getColumn(0).setMinWidth(60);
            tblrelab.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblrelab.getColumnModel().getColumn(0).setMaxWidth(60);
            tblrelab.getColumnModel().getColumn(3).setMinWidth(80);
            tblrelab.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblrelab.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        pnbid.setBackground(new java.awt.Color(51, 51, 51));

        lblbid.setBackground(new java.awt.Color(51, 51, 51));
        lblbid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblbid.setForeground(new java.awt.Color(255, 102, 0));
        lblbid.setText("ID:");

        txtbid.setBackground(new java.awt.Color(51, 51, 51));
        txtbid.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtbid.setForeground(new java.awt.Color(255, 255, 255));
        txtbid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnbidLayout = new javax.swing.GroupLayout(pnbid);
        pnbid.setLayout(pnbidLayout);
        pnbidLayout.setHorizontalGroup(
            pnbidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtbid)
            .addGroup(pnbidLayout.createSequentialGroup()
                .addComponent(lblbid, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 112, Short.MAX_VALUE))
        );
        pnbidLayout.setVerticalGroup(
            pnbidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbidLayout.createSequentialGroup()
                .addComponent(lblbid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtbid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnbrelia.setBackground(new java.awt.Color(51, 51, 51));

        lblbrelia.setBackground(new java.awt.Color(51, 51, 51));
        lblbrelia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblbrelia.setForeground(new java.awt.Color(255, 102, 0));
        lblbrelia.setText("Reliability:");

        txtbrelia.setBackground(new java.awt.Color(51, 51, 51));
        txtbrelia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtbrelia.setForeground(new java.awt.Color(255, 255, 255));
        txtbrelia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnbreliaLayout = new javax.swing.GroupLayout(pnbrelia);
        pnbrelia.setLayout(pnbreliaLayout);
        pnbreliaLayout.setHorizontalGroup(
            pnbreliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtbrelia)
            .addGroup(pnbreliaLayout.createSequentialGroup()
                .addComponent(lblbrelia)
                .addGap(0, 120, Short.MAX_VALUE))
        );
        pnbreliaLayout.setVerticalGroup(
            pnbreliaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbreliaLayout.createSequentialGroup()
                .addComponent(lblbrelia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbrelia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnbcreatedu.setBackground(new java.awt.Color(51, 51, 51));

        lblbcreatedu.setBackground(new java.awt.Color(51, 51, 51));
        lblbcreatedu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblbcreatedu.setForeground(new java.awt.Color(255, 102, 0));
        lblbcreatedu.setText("Created user:");

        txtbcreatedu.setBackground(new java.awt.Color(51, 51, 51));
        txtbcreatedu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtbcreatedu.setForeground(new java.awt.Color(255, 255, 255));
        txtbcreatedu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnbcreateduLayout = new javax.swing.GroupLayout(pnbcreatedu);
        pnbcreatedu.setLayout(pnbcreateduLayout);
        pnbcreateduLayout.setHorizontalGroup(
            pnbcreateduLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbcreateduLayout.createSequentialGroup()
                .addComponent(lblbcreatedu)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txtbcreatedu)
        );
        pnbcreateduLayout.setVerticalGroup(
            pnbcreateduLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbcreateduLayout.createSequentialGroup()
                .addComponent(lblbcreatedu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbcreatedu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnbupdatedu.setBackground(new java.awt.Color(51, 51, 51));

        lblbupdatedu.setBackground(new java.awt.Color(51, 51, 51));
        lblbupdatedu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblbupdatedu.setForeground(new java.awt.Color(255, 102, 0));
        lblbupdatedu.setText("Updated user:");

        txtbupdatedu.setBackground(new java.awt.Color(51, 51, 51));
        txtbupdatedu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtbupdatedu.setForeground(new java.awt.Color(255, 255, 255));
        txtbupdatedu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnbupdateduLayout = new javax.swing.GroupLayout(pnbupdatedu);
        pnbupdatedu.setLayout(pnbupdateduLayout);
        pnbupdateduLayout.setHorizontalGroup(
            pnbupdateduLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbupdateduLayout.createSequentialGroup()
                .addComponent(lblbupdatedu)
                .addGap(0, 219, Short.MAX_VALUE))
            .addComponent(txtbupdatedu)
        );
        pnbupdateduLayout.setVerticalGroup(
            pnbupdateduLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbupdateduLayout.createSequentialGroup()
                .addComponent(lblbupdatedu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtbupdatedu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnbupdatedd.setBackground(new java.awt.Color(51, 51, 51));

        lblbupdatedd.setBackground(new java.awt.Color(51, 51, 51));
        lblbupdatedd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblbupdatedd.setForeground(new java.awt.Color(255, 102, 0));
        lblbupdatedd.setText("Updated date:");

        txtbupdatedd.setBackground(new java.awt.Color(51, 51, 51));
        txtbupdatedd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtbupdatedd.setForeground(new java.awt.Color(255, 255, 255));
        txtbupdatedd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnbupdateddLayout = new javax.swing.GroupLayout(pnbupdatedd);
        pnbupdatedd.setLayout(pnbupdateddLayout);
        pnbupdateddLayout.setHorizontalGroup(
            pnbupdateddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbupdateddLayout.createSequentialGroup()
                .addComponent(lblbupdatedd)
                .addGap(0, 74, Short.MAX_VALUE))
            .addComponent(txtbupdatedd)
        );
        pnbupdateddLayout.setVerticalGroup(
            pnbupdateddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbupdateddLayout.createSequentialGroup()
                .addComponent(lblbupdatedd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtbupdatedd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnbcreatedd.setBackground(new java.awt.Color(51, 51, 51));

        lblbcreatedd.setBackground(new java.awt.Color(51, 51, 51));
        lblbcreatedd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblbcreatedd.setForeground(new java.awt.Color(255, 102, 0));
        lblbcreatedd.setText("Created date:");

        txtbcreatedd.setBackground(new java.awt.Color(51, 51, 51));
        txtbcreatedd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtbcreatedd.setForeground(new java.awt.Color(255, 255, 255));
        txtbcreatedd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnbcreateddLayout = new javax.swing.GroupLayout(pnbcreatedd);
        pnbcreatedd.setLayout(pnbcreateddLayout);
        pnbcreateddLayout.setHorizontalGroup(
            pnbcreateddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbcreateddLayout.createSequentialGroup()
                .addComponent(lblbcreatedd)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txtbcreatedd)
        );
        pnbcreateddLayout.setVerticalGroup(
            pnbcreateddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbcreateddLayout.createSequentialGroup()
                .addComponent(lblbcreatedd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbcreatedd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnbprice.setBackground(new java.awt.Color(51, 51, 51));

        lblbprice.setBackground(new java.awt.Color(51, 51, 51));
        lblbprice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblbprice.setForeground(new java.awt.Color(255, 102, 0));
        lblbprice.setText("Price:");

        txtbprice.setBackground(new java.awt.Color(51, 51, 51));
        txtbprice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtbprice.setForeground(new java.awt.Color(255, 255, 255));
        txtbprice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnbpriceLayout = new javax.swing.GroupLayout(pnbprice);
        pnbprice.setLayout(pnbpriceLayout);
        pnbpriceLayout.setHorizontalGroup(
            pnbpriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbpriceLayout.createSequentialGroup()
                .addComponent(lblbprice)
                .addGap(0, 129, Short.MAX_VALUE))
            .addComponent(txtbprice)
        );
        pnbpriceLayout.setVerticalGroup(
            pnbpriceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbpriceLayout.createSequentialGroup()
                .addComponent(lblbprice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnbstatus.setBackground(new java.awt.Color(51, 51, 51));

        lblbstatus.setBackground(new java.awt.Color(51, 51, 51));
        lblbstatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblbstatus.setForeground(new java.awt.Color(255, 102, 0));
        lblbstatus.setText("Status:");

        txtbstatus.setBackground(new java.awt.Color(51, 51, 51));
        txtbstatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtbstatus.setForeground(new java.awt.Color(255, 255, 255));
        txtbstatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnbstatusLayout = new javax.swing.GroupLayout(pnbstatus);
        pnbstatus.setLayout(pnbstatusLayout);
        pnbstatusLayout.setHorizontalGroup(
            pnbstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbstatusLayout.createSequentialGroup()
                .addComponent(lblbstatus)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txtbstatus)
        );
        pnbstatusLayout.setVerticalGroup(
            pnbstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbstatusLayout.createSequentialGroup()
                .addComponent(lblbstatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnbcreatedu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnbupdatedu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnbcreatedd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnbupdatedd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnbid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnbprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnbrelia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnbstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnbid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnbrelia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnbprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pnbcreatedu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnbupdatedu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pnbcreatedd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnbupdatedd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        btnbadd.setBackground(new java.awt.Color(51, 51, 51));
        btnbadd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnbadd.setForeground(new java.awt.Color(255, 102, 0));
        btnbadd.setText("Add");
        btnbadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbaddActionPerformed(evt);
            }
        });

        btnbsave.setBackground(new java.awt.Color(51, 51, 51));
        btnbsave.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnbsave.setForeground(new java.awt.Color(255, 102, 0));
        btnbsave.setText("Save");
        btnbsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbsaveActionPerformed(evt);
            }
        });

        btnbdel.setBackground(new java.awt.Color(51, 51, 51));
        btnbdel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnbdel.setForeground(new java.awt.Color(255, 102, 0));
        btnbdel.setText("Del");
        btnbdel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbdelActionPerformed(evt);
            }
        });

        btnbclear.setBackground(new java.awt.Color(51, 51, 51));
        btnbclear.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnbclear.setForeground(new java.awt.Color(255, 102, 0));
        btnbclear.setText("Clear");
        btnbclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbclearActionPerformed(evt);
            }
        });

        txttime.setBackground(new java.awt.Color(51, 51, 51));
        txttime.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txttime.setForeground(new java.awt.Color(255, 255, 255));
        txttime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setText("Time ?");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txttime, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbadd, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnbsave, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnbdel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnbclear, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbclear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbdel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbsave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbadd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttime, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnbooksLayout = new javax.swing.GroupLayout(pnbooks);
        pnbooks.setLayout(pnbooksLayout);
        pnbooksLayout.setHorizontalGroup(
            pnbooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbooksLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnbooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnbooksLayout.setVerticalGroup(
            pnbooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnbooksLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Books", pnbooks);

        javax.swing.GroupLayout pnbackLayout = new javax.swing.GroupLayout(pnback);
        pnback.setLayout(pnbackLayout);
        pnbackLayout.setHorizontalGroup(
            pnbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbackLayout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(0, 0, 0))
        );
        pnbackLayout.setVerticalGroup(
            pnbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        Bookdao bdao = new Bookdao();
        long millis = System.currentTimeMillis();
        Date date = new java.sql.Date(millis);

        Languages l = new Languages();
        Languagesdao ldao = new Languagesdao();
        l = ldao.getALanguagesByName((String) txtlanguages.getSelectedItem());

        if (bdao.addNewBook(Integer.parseInt(txtid.getText()), txttitle.getText(), l.getId(), Integer.parseInt(txtedition.getText()), Integer.parseInt(txtquantity.getText()), Integer.parseInt(txtstatus.getText()), Integer.parseInt(txtpublishy.getText()), txtdescription.getText(), date, s.getId(), date, s.getId())) {
            JOptionPane.showMessageDialog(null, "added " + txtid.getText());
            book_id = Integer.parseInt(txtid.getText());
            System.out.println(book_id);
        } else {
            JOptionPane.showMessageDialog(null, "Add false");
        }

    }//GEN-LAST:event_btnaddActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        txtid.setText("");
        txttitle.setText("");
        txtlanguages.setSelectedItem("Select");
        txtedition.setText("");
        txtquantity.setText("");
        txtstatus.setText("");
        txtpublishy.setText("");
        txtdescription.setText("");
        txtcreateduser.setText("");
        txtcreateddate.setText("");
        txtupdateduser.setText("");
        txtupdateddate.setText("");
    }//GEN-LAST:event_btnclearActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        Bookdao bdao = new Bookdao();
        long millis = System.currentTimeMillis();
        Date date = new java.sql.Date(millis);

        Languages l = new Languages();
        Languagesdao ldao = new Languagesdao();
        l = ldao.getALanguagesByName((String) txtlanguages.getSelectedItem());

        if (bdao.updateBook(Integer.parseInt(txtid.getText()), txttitle.getText(), l.getId(), Integer.parseInt(txtedition.getText()), Integer.parseInt(txtquantity.getText()), Integer.parseInt(txtstatus.getText()), Integer.parseInt(txtpublishy.getText()), txtdescription.getText(), Date.valueOf(txtcreateddate.getText()), createdu, date, s.getId())) {
            JOptionPane.showMessageDialog(null, "saved " + txtid.getText());

        } else {
            JOptionPane.showMessageDialog(null, "save false");
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btndelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelActionPerformed
        // TODO add your handling code here:
        Bookdao bdao = new Bookdao();
        Book_authordao badao = new Book_authordao();
        Book_publisherdao bpdao = new Book_publisherdao();
        Book_categorydao bcdao = new Book_categorydao();
        if (txtid.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Pick a Book and i will make it dissapear");
        } else {
            if (bdao.delBook(Integer.parseInt(txtid.getText()))) {
                JOptionPane.showMessageDialog(null, "Deleted " + txtid.getText());
                if (badao.delAuthorWithBook(Integer.parseInt(txtid.getText()))) {
                    System.out.println("Deleted author related");
                }
                if (bpdao.delPublisherWithBook(Integer.parseInt(txtid.getText()))) {
                    System.out.println("Deleted publisher related");
                }
                if (bcdao.delCategoryWithBook(Integer.parseInt(txtid.getText()))) {
                    System.out.println("Deleted category related");
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Delete false");
            }
        }
    }//GEN-LAST:event_btndelActionPerformed

    private void txtsearchauthorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchauthorKeyPressed
        // TODO add your handling code here:
        Authordao adao = new Authordao();
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            if (txtsearchauthor.getText().equals("")) {
                lsta = adao.getAllAuthor();
                DefaultTableModel dtm = (DefaultTableModel) tbllista.getModel();
                dtm.setRowCount(0);
                for (Author a : lsta) {
                    Vector<Object> vt = new Vector();
                    vt.add(a.getId());
                    vt.add(a.getName());
                    vt.add(a.getDescription());

                    dtm.addRow(vt);
                }
            } else {
                lsta = adao.getAuthorByName(txtsearchauthor.getText());
                DefaultTableModel dtm = (DefaultTableModel) tbllista.getModel();
                dtm.setRowCount(0);
                for (Author a : lsta) {
                    Vector<Object> vt = new Vector();
                    vt.add(a.getId());
                    vt.add(a.getName());
                    vt.add(a.getDescription());

                    dtm.addRow(vt);
                }
            }
        }
    }//GEN-LAST:event_txtsearchauthorKeyPressed

    private void btnaddauthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddauthorActionPerformed
        // TODO add your handling code here:
        Book_authordao badao = new Book_authordao();
        if (badao.addAuthorToBook(book_id, Integer.parseInt(txtidauthor.getText()))) {
            JOptionPane.showMessageDialog(null, "added ");
            lstba = badao.getAllRelaAuthorByBookId(book_id);
            DefaultTableModel dtm = (DefaultTableModel) tblbooka.getModel();
            dtm.setRowCount(0);
            for (Book_author ba : lstba) {
                Vector vt = new Vector();
                vt.add(ba.getId());
                Authordao adao = new Authordao();
                Author a = adao.getAnAuthorById(ba.getAuthor_id());
                vt.add(a.getName());

                dtm.addRow(vt);
            }
        }

    }//GEN-LAST:event_btnaddauthorActionPerformed

    private void btndelauthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelauthorActionPerformed
        // TODO add your handling code here:
        Book_authordao badao = new Book_authordao();
        int rowSelected = tblbooka.getSelectedRow();
        txtidauthor.setText(Integer.toString((int) tblbooka.getValueAt(rowSelected, 0)));
        int row = (int) tblbooka.getValueAt(rowSelected, 0);
        if (txtidauthor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Pick a name and ill make it dissapear");
        } else {
            if (badao.DelAuthorOfBook(row)) {
                JOptionPane.showMessageDialog(null, "Deleted " + txtidauthor.getText());
                lstba = badao.getAllRelaAuthorByBookId(book_id);
                DefaultTableModel dtm = (DefaultTableModel) tblbooka.getModel();
                dtm.setRowCount(0);
                for (Book_author ba : lstba) {
                    Vector<Object> vt = new Vector();
                    vt.add(ba.getId());
                    Authordao adao = new Authordao();
                    Author a = adao.getAnAuthorById(ba.getAuthor_id());
                    vt.add(a.getName());

                    dtm.addRow(vt);
                }
            }
        }
    }//GEN-LAST:event_btndelauthorActionPerformed

    private void txtsearchpublisherKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchpublisherKeyPressed
        // TODO add your handling code here:
        Publisherdao pdao = new Publisherdao();
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            if (txtsearchpublisher.getText().equals("")) {
                lstp = pdao.getAllPublisher();
                DefaultTableModel dtm = (DefaultTableModel) tbllistp.getModel();
                dtm.setRowCount(0);
                for (Publisher p : lstp) {
                    Vector<Object> vt = new Vector();
                    vt.add(p.getId());
                    vt.add(p.getName());
                    vt.add(p.getDescription());

                    dtm.addRow(vt);
                }
            } else {
                lstp = pdao.getPublisherByName(txtsearchpublisher.getText());
                DefaultTableModel dtm = (DefaultTableModel) tbllistp.getModel();
                dtm.setRowCount(0);
                for (Publisher p : lstp) {
                    Vector<Object> vt = new Vector();
                    vt.add(p.getId());
                    vt.add(p.getName());
                    vt.add(p.getDescription());

                    dtm.addRow(vt);
                }
            }
        }
    }//GEN-LAST:event_txtsearchpublisherKeyPressed

    private void txtsearchcatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchcatKeyPressed
        // TODO add your handling code here:
        Categorydao cdao = new Categorydao();
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            if (txtsearchcat.getText().equals("")) {
                lstc = cdao.getAllCategory();
                DefaultTableModel dtm = (DefaultTableModel) tbllistc.getModel();
                dtm.setRowCount(0);
                for (Category c : lstc) {
                    Vector<Object> vt = new Vector();
                    vt.add(c.getId());
                    vt.add(c.getName());
                    vt.add(c.getDescription());

                    dtm.addRow(vt);
                }
            } else {
                lstc = cdao.getCategoryByName(txtsearchcat.getText());
                DefaultTableModel dtm = (DefaultTableModel) tbllistc.getModel();
                dtm.setRowCount(0);
                for (Category c : lstc) {
                    Vector<Object> vt = new Vector();
                    vt.add(c.getId());
                    vt.add(c.getName());
                    vt.add(c.getDescription());

                    dtm.addRow(vt);
                }
            }
        }
    }//GEN-LAST:event_txtsearchcatKeyPressed

    private void txtsearchpublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchpublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchpublisherActionPerformed

    private void btnaddpublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddpublisherActionPerformed
        // TODO add your handling code here:
        Book_publisherdao bpdao = new Book_publisherdao();
        if (bpdao.addPublisherToBook(book_id, Integer.parseInt(txtidpublisher.getText()))) {
            JOptionPane.showMessageDialog(null, "added ");
            lstbp = bpdao.getAllRelaPublisherByBookId(book_id);
            DefaultTableModel dtm = (DefaultTableModel) tblbookp.getModel();
            dtm.setRowCount(0);
            for (Book_publisher bp : lstbp) {
                Vector vt = new Vector();
                vt.add(bp.getId());
                Publisherdao pdao = new Publisherdao();
                Publisher p = pdao.getPublisherById(bp.getPublisher_id());
                vt.add(p.getName());

                dtm.addRow(vt);
            }
        }
    }//GEN-LAST:event_btnaddpublisherActionPerformed

    private void btnaddcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddcatActionPerformed
        // TODO add your handling code here:
        Book_categorydao bcdao = new Book_categorydao();
        if (bcdao.addCategoryToBook(book_id, Integer.parseInt(txtidcat.getText()))) {
            JOptionPane.showMessageDialog(null, "added ");
            lstbc = bcdao.getAllRelaCategoryByBookId(book_id);
            DefaultTableModel dtm = (DefaultTableModel) tblbookc.getModel();
            dtm.setRowCount(0);
            for (Book_category bc : lstbc) {
                Vector vt = new Vector();
                vt.add(bc.getId());
                Categorydao cdao = new Categorydao();
                Category c = cdao.getCategoryById(bc.getCategory_id());
                vt.add(c.getName());

                dtm.addRow(vt);
            }
        }
    }//GEN-LAST:event_btnaddcatActionPerformed

    private void btndelpublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelpublisherActionPerformed
        // TODO add your handling code here:
        Book_publisherdao bpdao = new Book_publisherdao();
        int rowSelected = tblbookp.getSelectedRow();
        txtidpublisher.setText(Integer.toString((int) tblbookp.getValueAt(rowSelected, 0)));
        int row = (int) tblbookp.getValueAt(rowSelected, 0);
        if (txtidpublisher.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Pick a name and ill make it dissapear");
        } else {
            if (bpdao.DelPublisherOfBook(row)) {
                JOptionPane.showMessageDialog(null, "Deleted " + txtidpublisher.getText());
                lstbp = bpdao.getAllRelaPublisherByBookId(book_id);
                DefaultTableModel dtm = (DefaultTableModel) tblbookp.getModel();
                dtm.setRowCount(0);
                for (Book_publisher bp : lstbp) {
                    Vector<Object> vt = new Vector();
                    vt.add(bp.getId());
                    Publisherdao pdao = new Publisherdao();
                    Publisher p = pdao.getPublisherById(bp.getPublisher_id());
                    vt.add(p.getName());

                    dtm.addRow(vt);
                }
            }
        }
    }//GEN-LAST:event_btndelpublisherActionPerformed

    private void btndelcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelcatActionPerformed
        // TODO add your handling code here:
        Book_categorydao bcdao = new Book_categorydao();
        int rowSelected = tblbookc.getSelectedRow();
        txtidcat.setText(Integer.toString((int) tblbookc.getValueAt(rowSelected, 0)));
        int row = (int) tblbookc.getValueAt(rowSelected, 0);
        if (txtidcat.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Pick a name and ill make it dissapear");
        } else {
            if (bcdao.DelCategoryOfBook(row)) {
                JOptionPane.showMessageDialog(null, "Deleted " + txtidcat.getText());
                lstbc = bcdao.getAllRelaCategoryByBookId(book_id);
                DefaultTableModel dtm = (DefaultTableModel) tblbookc.getModel();
                dtm.setRowCount(0);
                for (Book_category bc : lstbc) {
                    Vector<Object> vt = new Vector();
                    vt.add(bc.getId());
                    Categorydao cdao = new Categorydao();
                    Category c = cdao.getCategoryById(bc.getCategory_id());
                    vt.add(c.getName());

                    dtm.addRow(vt);
                }
            }
        }
    }//GEN-LAST:event_btndelcatActionPerformed

    private void btnbclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbclearActionPerformed
        // TODO add your handling code here:
        txtbid.setText("");
        txtbrelia.setText("");
        txtbprice.setText("");
        txtbstatus.setText("");
        txtbcreatedd.setText("");
        txtbcreatedu.setText("");
        txtbupdatedd.setText("");
        txtbupdatedu.setText("");
    }//GEN-LAST:event_btnbclearActionPerformed

    private void btnbaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbaddActionPerformed
        // TODO add your handling code here:
        long millis = System.currentTimeMillis();
        Date date = new java.sql.Date(millis);
        Book_detailsdao bddao = new Book_detailsdao();
        if (txttime.getText().equals("")) {
            if (bddao.addNewBook_details(book_id, txtbrelia.getText(),
                    Double.parseDouble(txtbprice.getText()), Integer.parseInt(txtbstatus.getText()),
                    date, s.getId(), date, s.getId())) {
                JOptionPane.showMessageDialog(null, "Added " + txtbid.getText());
                showRelaBooks();
            } else {
                JOptionPane.showMessageDialog(null, "Added false");
            }
        } else {
            int n = Integer.parseInt(txttime.getText());
            int c = 0;
            for (int i = 0; i < n; i++) {
                if (bddao.addNewBook_details(book_id, txtbrelia.getText(),
                        Double.parseDouble(txtbprice.getText()), Integer.parseInt(txtbstatus.getText()),
                        date, 1, date, 1)) {
                    c++;
                    showRelaBooks();
                    txttime.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Added false");
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Added " + c);
        }

    }//GEN-LAST:event_btnbaddActionPerformed

    private void btnbsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbsaveActionPerformed
        // TODO add your handling code here:
        long millis = System.currentTimeMillis();
        Date date = new java.sql.Date(millis);
        Book_detailsdao bddao = new Book_detailsdao();
        if (bddao.updateBook_details(Integer.parseInt(txtbid.getText()), book_id, txtbrelia.getText(),
                Double.parseDouble(txtbprice.getText()), Integer.parseInt(txtbstatus.getText()),
                Date.valueOf(txtbcreatedd.getText()), bcreatedu, date, s.getId())) {
            JOptionPane.showMessageDialog(null, "Saved " + txtbid.getText());
            showRelaBooks();
        } else {
            JOptionPane.showMessageDialog(null, "Saved false");
        }
    }//GEN-LAST:event_btnbsaveActionPerformed

    private void btnbdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbdelActionPerformed
        // TODO add your handling code here:
        Book_detailsdao bddao = new Book_detailsdao();
        if(txtbid.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Pick one and i'll make it dissapear");
        }else{
            if(bddao.delBookDetails(Integer.parseInt(txtbid.getText()))) {
                 JOptionPane.showMessageDialog(null, "Deleted " + txtbid.getText());
                 showRelaBooks();
                 txtbid.setText("");
                 txtbrelia.setText("");
                 txtbprice.setText("");
                 txtbstatus.setText("");
                 txtbcreatedu.setText("");
                 txtbcreatedd.setText("");
                 txtbupdatedu.setText("");
                 txtbupdatedd.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Deleted false");
            }
        }
    }//GEN-LAST:event_btnbdelActionPerformed

    private int book_id, lang_id, createdu, bcreatedu;
    private ArrayList<Book> lstb = null;
    private ArrayList<Author> lsta = null;
    private ArrayList<Publisher> lstp = null;
    private ArrayList<Category> lstc = null;
    private ArrayList<Book_author> lstba = null;
    private ArrayList<Book_publisher> lstbp = null;
    private ArrayList<Book_category> lstbc = null;
    private ArrayList<Languages> lstl = null;
    private ArrayList<Book_details> lstbd = null;
    private Book book = null;
    private Staff s;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnaddauthor;
    private javax.swing.JButton btnaddcat;
    private javax.swing.JButton btnaddpublisher;
    private javax.swing.JButton btnbadd;
    private javax.swing.JButton btnbclear;
    private javax.swing.JButton btnbdel;
    private javax.swing.JButton btnbsave;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndel;
    private javax.swing.JButton btndelauthor;
    private javax.swing.JButton btndelcat;
    private javax.swing.JButton btndelpublisher;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblbcreatedd;
    private javax.swing.JLabel lblbcreatedu;
    private javax.swing.JLabel lblbid;
    private javax.swing.JLabel lblbprice;
    private javax.swing.JLabel lblbrelia;
    private javax.swing.JLabel lblbstatus;
    private javax.swing.JLabel lblbupdatedd;
    private javax.swing.JLabel lblbupdatedu;
    private javax.swing.JLabel lblcreateddate;
    private javax.swing.JLabel lblcreateduser;
    private javax.swing.JLabel lbldescription;
    private javax.swing.JLabel lbleidition;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblidcat;
    private javax.swing.JLabel lblidpub;
    private javax.swing.JLabel lbllanguages;
    private javax.swing.JLabel lblpublishy;
    private javax.swing.JLabel lblquantity;
    private javax.swing.JLabel lblsearchcat;
    private javax.swing.JLabel lblsearchpub;
    private javax.swing.JLabel lblstatus;
    private javax.swing.JLabel lblupdateddate;
    private javax.swing.JLabel lblupdateduser;
    private javax.swing.JPanel pnauthor;
    private javax.swing.JPanel pnback;
    private javax.swing.JPanel pnbcreatedd;
    private javax.swing.JPanel pnbcreatedu;
    private javax.swing.JPanel pnbid;
    private javax.swing.JPanel pnbooks;
    private javax.swing.JPanel pnbprice;
    private javax.swing.JPanel pnbrelia;
    private javax.swing.JPanel pnbstatus;
    private javax.swing.JPanel pnbupdatedd;
    private javax.swing.JPanel pnbupdatedu;
    private javax.swing.JPanel pncategory;
    private javax.swing.JPanel pncreateddate;
    private javax.swing.JPanel pncreateduser;
    private javax.swing.JPanel pndescription;
    private javax.swing.JPanel pndetails;
    private javax.swing.JPanel pnedition;
    private javax.swing.JPanel pnid;
    private javax.swing.JPanel pnlanguages;
    private javax.swing.JPanel pnleft;
    private javax.swing.JPanel pnleftauthor;
    private javax.swing.JPanel pnleftpublisher;
    private javax.swing.JPanel pnpublisher;
    private javax.swing.JPanel pnpublishy;
    private javax.swing.JPanel pnquantity;
    private javax.swing.JPanel pnright;
    private javax.swing.JPanel pnright1;
    private javax.swing.JPanel pnright3;
    private javax.swing.JPanel pnright4;
    private javax.swing.JPanel pnstatus;
    private javax.swing.JPanel pntitle;
    private javax.swing.JPanel pnupdateddate;
    private javax.swing.JPanel pnupdateduser;
    private javax.swing.JTable tblbooka;
    private javax.swing.JTable tblbookc;
    private javax.swing.JTable tblbookp;
    private javax.swing.JTable tbllista;
    private javax.swing.JTable tbllistc;
    private javax.swing.JTable tbllistp;
    private javax.swing.JTable tblrelab;
    private javax.swing.JTextField txtbcreatedd;
    private javax.swing.JTextField txtbcreatedu;
    private javax.swing.JTextField txtbid;
    private javax.swing.JTextField txtbprice;
    private javax.swing.JTextField txtbrelia;
    private javax.swing.JTextField txtbstatus;
    private javax.swing.JTextField txtbupdatedd;
    private javax.swing.JTextField txtbupdatedu;
    private javax.swing.JTextField txtcreateddate;
    private javax.swing.JTextField txtcreateduser;
    private javax.swing.JTextArea txtdescription;
    private javax.swing.JTextField txtedition;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidauthor;
    private javax.swing.JTextField txtidcat;
    private javax.swing.JTextField txtidpublisher;
    private javax.swing.JComboBox<String> txtlanguages;
    private javax.swing.JTextField txtpublishy;
    private javax.swing.JTextField txtquantity;
    private javax.swing.JTextField txtsearchauthor;
    private javax.swing.JTextField txtsearchcat;
    private javax.swing.JTextField txtsearchpublisher;
    private javax.swing.JTextField txtstatus;
    private javax.swing.JTextField txttime;
    private javax.swing.JTextField txttitle;
    private javax.swing.JTextField txtupdateddate;
    private javax.swing.JTextField txtupdateduser;
    // End of variables declaration//GEN-END:variables
}
