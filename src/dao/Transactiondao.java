/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.Transaction;

/**
 *
 * @author Uygi
 */
public class Transactiondao extends Database {

    public ArrayList<Transaction> getAllTran() {
        ArrayList<Transaction> lsttran = new ArrayList<Transaction>();
        try {
            String sql = "SELECT * FROM transactions";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Transaction tran = new Transaction();
                tran.setId(rs.getInt("id"));
                tran.setCustomer_id(rs.getInt("customer_id"));
                tran.setEmployee_id(rs.getInt("employee_id"));
                tran.setTotal_p(rs.getDouble("total_price"));
                tran.setStatus(rs.getInt("status"));
                tran.setDued(rs.getDate("due_date"));
                tran.setPayd(rs.getDate("pay_date"));
                tran.setCreatedd(rs.getDate("created_date"));

                lsttran.add(tran);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsttran;
    }

    public ArrayList<Transaction> getAllTranById(int id) {
        ArrayList<Transaction> lsttran = new ArrayList<Transaction>();
        try {
            String sql = "SELECT * FROM transactions WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transaction tran = new Transaction();
                tran.setId(rs.getInt("id"));
                tran.setCustomer_id(rs.getInt("customer_id"));
                tran.setEmployee_id(rs.getInt("employee_id"));
                tran.setTotal_p(rs.getDouble("total_price"));
                tran.setStatus(rs.getInt("status"));
                tran.setDued(rs.getDate("due_date"));
                tran.setPayd(rs.getDate("pay_date"));
                tran.setCreatedd(rs.getDate("created_date"));

                lsttran.add(tran);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsttran;
    }
    
    public ArrayList<Transaction> getAllTranByCusId(int id) {
        ArrayList<Transaction> lsttran = new ArrayList<Transaction>();
        try {
            String sql = "SELECT * FROM transactions WHERE customer_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transaction tran = new Transaction();
                tran.setId(rs.getInt("id"));
                tran.setCustomer_id(rs.getInt("customer_id"));
                tran.setEmployee_id(rs.getInt("employee_id"));
                tran.setTotal_p(rs.getDouble("total_price"));
                tran.setStatus(rs.getInt("status"));
                tran.setDued(rs.getDate("due_date"));
                tran.setPayd(rs.getDate("pay_date"));
                tran.setCreatedd(rs.getDate("created_date"));

                lsttran.add(tran);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsttran;
    }
    
    public ArrayList<Transaction> getAllTranByEmpId(int id) {
        ArrayList<Transaction> lsttran = new ArrayList<Transaction>();
        try {
            String sql = "SELECT * FROM transactions WHERE employee_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transaction tran = new Transaction();
                tran.setId(rs.getInt("id"));
                tran.setCustomer_id(rs.getInt("customer_id"));
                tran.setEmployee_id(rs.getInt("employee_id"));
                tran.setTotal_p(rs.getDouble("total_price"));
                tran.setStatus(rs.getInt("status"));
                tran.setDued(rs.getDate("due_date"));
                tran.setPayd(rs.getDate("pay_date"));
                tran.setCreatedd(rs.getDate("created_date"));

                lsttran.add(tran);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsttran;
    }
    
    public ArrayList<Transaction> getAllTranByStatus(int id) {
        ArrayList<Transaction> lsttran = new ArrayList<Transaction>();
        try {
            String sql = "SELECT * FROM transactions WHERE status = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transaction tran = new Transaction();
                tran.setId(rs.getInt("id"));
                tran.setCustomer_id(rs.getInt("customer_id"));
                tran.setEmployee_id(rs.getInt("employee_id"));
                tran.setTotal_p(rs.getDouble("total_price"));
                tran.setStatus(rs.getInt("status"));
                tran.setDued(rs.getDate("due_date"));
                tran.setPayd(rs.getDate("pay_date"));
                tran.setCreatedd(rs.getDate("created_date"));

                lsttran.add(tran);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsttran;
    }

    public Transaction getATranById(int id) {
        Transaction tran = new Transaction();
        try {
            String sql = "SELECT * FROM transactions WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tran.setId(rs.getInt("id"));
                tran.setCustomer_id(rs.getInt("customer_id"));
                tran.setEmployee_id(rs.getInt("employee_id"));
                tran.setTotal_p(rs.getDouble("total_price"));
                tran.setStatus(rs.getInt("status"));
                tran.setDued(rs.getDate("due_date"));
                tran.setPayd(rs.getDate("pay_date"));
                tran.setCreatedd(rs.getDate("created_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tran;
    }

    public boolean addNewTran(int id, int cus_id,
            int emp_id, double total, int status,
            Date due, Date pay, Date createdd) {
        try {
            String sql1 = "SELECT * FROM transactions WHERE id = 'id'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql1);
            if (!rs.next()) {
                String sql2 = "INSERT INTO transactions VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql2);
                ps.setInt(1, id);
                ps.setInt(2, cus_id);
                ps.setInt(3, emp_id);
                ps.setDouble(4, total);
                ps.setInt(5, status);
                ps.setDate(6, due);
                ps.setDate(7, pay);
                ps.setDate(8, createdd);
                int number = ps.executeUpdate();
                if (number > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateTran(int id, int cus_id,
            int emp_id, double total, int status,
            Date due, Date pay, Date createdd) {
        try {
            String sql2 = "UPDATE transactions SET customer_id=?, employee_id=?, total_price=?, status=?, due_date=?, pay_date=?, created_date=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setInt(1, cus_id);
            ps.setInt(2, emp_id);
            ps.setDouble(3, total);
            ps.setInt(4, status);
            ps.setDate(5, due);
            ps.setDate(6, pay);
            ps.setDate(7, createdd);
            ps.setInt(8, id);
            int number = ps.executeUpdate();
            if (number > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateTrantotal(int id, double total) {
        try {
            String sql2 = "UPDATE transactions SET total_price=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setDouble(1, total);
            ps.setInt(2, id);
            int number = ps.executeUpdate();
            if (number > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateTranstatus(int id, int status) {
        try {
            String sql2 = "UPDATE transactions SET status=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setDouble(1, status);
            ps.setInt(2, id);
            int number = ps.executeUpdate();
            if (number > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delTran(int id) {
        try{
            String sql = "DELETE FROM transactions WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int number = ps.executeUpdate();
            if(number>0) {
                return true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
