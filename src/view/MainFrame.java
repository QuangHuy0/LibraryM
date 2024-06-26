/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.ChangeMenu;
import model.Menu;
import model.Staff;

/**
 *
 * @author Uygi
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private Staff s;
    public MainFrame(Staff s) {
        initComponents();
        this.s = s;
        System.out.println(s.getName());
        //change menu
        ChangeMenu change = new ChangeMenu(pndetails);
        change.setView(pnhome, lblhome);       
        List<Menu> lstmenu = new ArrayList<>();
        lstmenu.add(new Menu("Home", pnhome, lblhome, s));
        lstmenu.add(new Menu("Book", pnbook, lblbook, s));
        lstmenu.add(new Menu("Transaction", pntransaction, lbltransaction, s));
        lstmenu.add(new Menu("Author", pnauthor, lblauthor, s));
        lstmenu.add(new Menu("Publisher", pnpublisher, lblpublisher, s));
        lstmenu.add(new Menu("Category", pncategory, lblcategory, s));
        lstmenu.add(new Menu ("Reader", pnreader, lblreader, s));
        lstmenu.add(new Menu ("Staff", pnstaff, lblstaff, s));
        
        change.setEvent(lstmenu);
        
        //ngay thang
        long millis = System.currentTimeMillis();
        Date date = new java.sql.Date(millis);
        lbldate.setText(date.toString());
        
        lblhello.setText("Hello "+s.getId()+": "+s.getName());
        lblid.setText(Integer.toString(s.getId()));
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
        pnmenu = new javax.swing.JPanel();
        pnhome = new javax.swing.JPanel();
        lblhome = new javax.swing.JLabel();
        pnbook = new javax.swing.JPanel();
        lblbook = new javax.swing.JLabel();
        pntransaction = new javax.swing.JPanel();
        lbltransaction = new javax.swing.JLabel();
        pnauthor = new javax.swing.JPanel();
        lblauthor = new javax.swing.JLabel();
        pnpublisher = new javax.swing.JPanel();
        lblpublisher = new javax.swing.JLabel();
        pncategory = new javax.swing.JPanel();
        lblcategory = new javax.swing.JLabel();
        pnreader = new javax.swing.JPanel();
        lblreader = new javax.swing.JLabel();
        pnstaff = new javax.swing.JPanel();
        lblstaff = new javax.swing.JLabel();
        pnbaocao = new javax.swing.JPanel();
        pntop = new javax.swing.JPanel();
        lblhello = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        lbllogout = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        pndetails = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnback.setBackground(new java.awt.Color(51, 51, 51));

        pnmenu.setBackground(new java.awt.Color(51, 51, 51));

        pnhome.setBackground(new java.awt.Color(51, 51, 51));
        pnhome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblhome.setBackground(new java.awt.Color(51, 51, 51));
        lblhome.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblhome.setForeground(new java.awt.Color(255, 255, 255));
        lblhome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblhome.setText("Home");
        lblhome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        lblhome.setFocusable(false);

        javax.swing.GroupLayout pnhomeLayout = new javax.swing.GroupLayout(pnhome);
        pnhome.setLayout(pnhomeLayout);
        pnhomeLayout.setHorizontalGroup(
            pnhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblhome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnhomeLayout.setVerticalGroup(
            pnhomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblhome, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        pnbook.setBackground(new java.awt.Color(51, 51, 51));
        pnbook.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblbook.setBackground(new java.awt.Color(51, 51, 51));
        lblbook.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblbook.setForeground(new java.awt.Color(255, 255, 255));
        lblbook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbook.setText("Book");
        lblbook.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnbookLayout = new javax.swing.GroupLayout(pnbook);
        pnbook.setLayout(pnbookLayout);
        pnbookLayout.setHorizontalGroup(
            pnbookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblbook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnbookLayout.setVerticalGroup(
            pnbookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblbook, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        pntransaction.setBackground(new java.awt.Color(51, 51, 51));
        pntransaction.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbltransaction.setBackground(new java.awt.Color(51, 51, 51));
        lbltransaction.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbltransaction.setForeground(new java.awt.Color(255, 255, 255));
        lbltransaction.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltransaction.setText("Transaction");
        lbltransaction.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pntransactionLayout = new javax.swing.GroupLayout(pntransaction);
        pntransaction.setLayout(pntransactionLayout);
        pntransactionLayout.setHorizontalGroup(
            pntransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbltransaction, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pntransactionLayout.setVerticalGroup(
            pntransactionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbltransaction, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        pnauthor.setBackground(new java.awt.Color(51, 51, 51));
        pnauthor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblauthor.setBackground(new java.awt.Color(51, 51, 51));
        lblauthor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblauthor.setForeground(new java.awt.Color(255, 255, 255));
        lblauthor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblauthor.setText("Author");
        lblauthor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnauthorLayout = new javax.swing.GroupLayout(pnauthor);
        pnauthor.setLayout(pnauthorLayout);
        pnauthorLayout.setHorizontalGroup(
            pnauthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblauthor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnauthorLayout.setVerticalGroup(
            pnauthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblauthor, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        pnpublisher.setBackground(new java.awt.Color(51, 51, 51));
        pnpublisher.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblpublisher.setBackground(new java.awt.Color(51, 51, 51));
        lblpublisher.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblpublisher.setForeground(new java.awt.Color(255, 255, 255));
        lblpublisher.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblpublisher.setText("Publisher");
        lblpublisher.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnpublisherLayout = new javax.swing.GroupLayout(pnpublisher);
        pnpublisher.setLayout(pnpublisherLayout);
        pnpublisherLayout.setHorizontalGroup(
            pnpublisherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblpublisher, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnpublisherLayout.setVerticalGroup(
            pnpublisherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblpublisher, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        pncategory.setBackground(new java.awt.Color(51, 51, 51));
        pncategory.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblcategory.setBackground(new java.awt.Color(51, 51, 51));
        lblcategory.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblcategory.setForeground(new java.awt.Color(255, 255, 255));
        lblcategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcategory.setText("Category");
        lblcategory.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pncategoryLayout = new javax.swing.GroupLayout(pncategory);
        pncategory.setLayout(pncategoryLayout);
        pncategoryLayout.setHorizontalGroup(
            pncategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblcategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pncategoryLayout.setVerticalGroup(
            pncategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblcategory, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        pnreader.setBackground(new java.awt.Color(51, 51, 51));
        pnreader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblreader.setBackground(new java.awt.Color(51, 51, 51));
        lblreader.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblreader.setForeground(new java.awt.Color(255, 255, 255));
        lblreader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblreader.setText("Reader");
        lblreader.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnreaderLayout = new javax.swing.GroupLayout(pnreader);
        pnreader.setLayout(pnreaderLayout);
        pnreaderLayout.setHorizontalGroup(
            pnreaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblreader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnreaderLayout.setVerticalGroup(
            pnreaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblreader, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        pnstaff.setBackground(new java.awt.Color(51, 51, 51));
        pnstaff.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblstaff.setBackground(new java.awt.Color(51, 51, 51));
        lblstaff.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblstaff.setForeground(new java.awt.Color(255, 255, 255));
        lblstaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblstaff.setText("Staff");
        lblstaff.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        javax.swing.GroupLayout pnstaffLayout = new javax.swing.GroupLayout(pnstaff);
        pnstaff.setLayout(pnstaffLayout);
        pnstaffLayout.setHorizontalGroup(
            pnstaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblstaff, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnstaffLayout.setVerticalGroup(
            pnstaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblstaff, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        pnbaocao.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout pnbaocaoLayout = new javax.swing.GroupLayout(pnbaocao);
        pnbaocao.setLayout(pnbaocaoLayout);
        pnbaocaoLayout.setHorizontalGroup(
            pnbaocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 157, Short.MAX_VALUE)
        );
        pnbaocaoLayout.setVerticalGroup(
            pnbaocaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnmenuLayout = new javax.swing.GroupLayout(pnmenu);
        pnmenu.setLayout(pnmenuLayout);
        pnmenuLayout.setHorizontalGroup(
            pnmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnbook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pntransaction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnauthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnpublisher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pncategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnreader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnstaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnbaocao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnhome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnmenuLayout.setVerticalGroup(
            pnmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnmenuLayout.createSequentialGroup()
                .addComponent(pnhome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnbook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pntransaction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pncategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnreader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnstaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnbaocao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 54, Short.MAX_VALUE))
        );

        pntop.setBackground(new java.awt.Color(51, 51, 51));

        lblhello.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblhello.setForeground(new java.awt.Color(0, 153, 0));
        lblhello.setText("Hello: ");

        lbldate.setBackground(new java.awt.Color(0, 0, 0));
        lbldate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbldate.setForeground(lblhello.getForeground());
        lbldate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldate.setText("date");

        lbllogout.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbllogout.setForeground(lblhello.getForeground());
        lbllogout.setText("Logout");
        lbllogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllogoutMouseClicked(evt);
            }
        });

        lblid.setForeground(new java.awt.Color(51, 51, 51));
        lblid.setText("jLabel1");

        javax.swing.GroupLayout pntopLayout = new javax.swing.GroupLayout(pntop);
        pntop.setLayout(pntopLayout);
        pntopLayout.setHorizontalGroup(
            pntopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pntopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblhello, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(lblid)
                .addGap(86, 86, 86)
                .addComponent(lbllogout, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        pntopLayout.setVerticalGroup(
            pntopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pntopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pntopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblhello, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pntopLayout.createSequentialGroup()
                        .addGroup(pntopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbllogout)
                            .addComponent(lbldate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblid))
                        .addContainerGap())))
        );

        pndetails.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout pndetailsLayout = new javax.swing.GroupLayout(pndetails);
        pndetails.setLayout(pndetailsLayout);
        pndetailsLayout.setHorizontalGroup(
            pndetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pndetailsLayout.setVerticalGroup(
            pndetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnbackLayout = new javax.swing.GroupLayout(pnback);
        pnback.setLayout(pnbackLayout);
        pnbackLayout.setHorizontalGroup(
            pnbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbackLayout.createSequentialGroup()
                .addComponent(pntop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
            .addGroup(pnbackLayout.createSequentialGroup()
                .addComponent(pnmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pndetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnbackLayout.setVerticalGroup(
            pnbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnbackLayout.createSequentialGroup()
                .addComponent(pntop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnbackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pndetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void lbllogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllogoutMouseClicked
        // TODO add your handling code here:
        LoginFrame lg = new LoginFrame();
        lg.setResizable(false);
        lg.setVisible(true);
        lg.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_lbllogoutMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblauthor;
    private javax.swing.JLabel lblbook;
    private javax.swing.JLabel lblcategory;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lblhello;
    private javax.swing.JLabel lblhome;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lbllogout;
    private javax.swing.JLabel lblpublisher;
    private javax.swing.JLabel lblreader;
    private javax.swing.JLabel lblstaff;
    private javax.swing.JLabel lbltransaction;
    private javax.swing.JPanel pnauthor;
    private javax.swing.JPanel pnback;
    private javax.swing.JPanel pnbaocao;
    private javax.swing.JPanel pnbook;
    private javax.swing.JPanel pncategory;
    private javax.swing.JPanel pndetails;
    private javax.swing.JPanel pnhome;
    private javax.swing.JPanel pnmenu;
    private javax.swing.JPanel pnpublisher;
    private javax.swing.JPanel pnreader;
    private javax.swing.JPanel pnstaff;
    private javax.swing.JPanel pntop;
    private javax.swing.JPanel pntransaction;
    // End of variables declaration//GEN-END:variables
}
