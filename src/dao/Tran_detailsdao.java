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
import model.Tran_details;

/**
 *
 * @author Uygi
 */
public class Tran_detailsdao extends Database {

    public ArrayList<Tran_details> getAllTran_details() {
        ArrayList<Tran_details> lsttd = new ArrayList<Tran_details>();
        try {
            String sql = "SELECT * FROM transactions_details";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Tran_details td = new Tran_details();
                td.setId(rs.getInt("id"));
                td.setBdid(rs.getInt("book_details_id"));
                td.setTranid(rs.getInt("transaction_id"));
                td.setPid(rs.getInt("punish_id"));
                td.setPrice(rs.getDouble("price"));

                lsttd.add(td);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsttd;
    }

    public ArrayList<Tran_details> getAllTran_detailsByTranId(int id) {
        ArrayList<Tran_details> lsttd = new ArrayList<Tran_details>();
        try {
            String sql = "SELECT * FROM transactions_details WHERE transaction_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tran_details td = new Tran_details();
                td.setId(rs.getInt("id"));
                td.setBdid(rs.getInt("book_details_id"));
                td.setTranid(rs.getInt("transaction_id"));
                td.setPid(rs.getInt("punish_id"));
                td.setPrice(rs.getDouble("price"));

                lsttd.add(td);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsttd;
    }

    public Tran_details getATran_detailsById(int id) {
        Tran_details td = new Tran_details();
        try {
            String sql = "SELECT * FROM transactions_details WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                td.setId(rs.getInt("id"));
                td.setBdid(rs.getInt("book_details_id"));
                td.setTranid(rs.getInt("transaction_id"));
                td.setPid(rs.getInt("punish_id"));
                td.setPrice(rs.getDouble("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return td;
    }

    public boolean addNewTran_details(int bdid,
            int tranid, int pid, double price) {
        try {
            String sql2 = "INSERT INTO transactions_details VALUES(null, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setInt(1, bdid);
            ps.setInt(2, tranid);
            ps.setInt(3, pid);
            ps.setDouble(4, price);
            int number = ps.executeUpdate();
            if (number > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateTran_details(int id, int bdid,
            int tranid, int pid, double price) {
        try {
            String sql2 = "UPDATE transactions_details SET book_details_id=?, transaction_id=?, punish_id=?, price=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setInt(1, bdid);
            ps.setInt(2, tranid);
            ps.setInt(3, pid);
            ps.setDouble(4, price);
            ps.setInt(5, id);
            int number = ps.executeUpdate();
            if (number > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateTran_detailsprice(int id, double price) {
        try {
            String sql2 = "UPDATE transactions_details SET price=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setDouble(1, price);
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

    public boolean delTran_details(int id) {
        try {
            String sql = "DELETE FROM transactions_details WHERE id =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int number = ps.executeUpdate();
            if (number > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delRelaTran_details(int id) {
        try {
            String sql = "DELETE FROM transactions_details WHERE transaction_id =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int number = ps.executeUpdate();
            if (number > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
