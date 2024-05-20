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

import model.Book_details;

/**
 *
 * @author Uygi
 */
public class Book_detailsdao extends Database {

    public ArrayList<Book_details> getAllRelaBooks(int book_id) {
        ArrayList<Book_details> lstbd = new ArrayList<Book_details>();
        try {
            String sql = "SELECT * FROM book_details WHERE book_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, book_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book_details bd = new Book_details();
                bd.setId(rs.getInt("id"));
                bd.setBook_id(rs.getInt("book_id"));
                bd.setSku(rs.getString("sku_code"));
                bd.setPrice(rs.getDouble("price"));
                bd.setStatus(rs.getInt("status"));
                bd.setCreatedd(rs.getDate("created_date"));
                bd.setCreatedu(rs.getInt("created_user"));
                bd.setUpdatedd(rs.getDate("updated_date"));
                bd.setUpdatedu(rs.getInt("updated_user"));

                lstbd.add(bd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstbd;
    }

    public Book_details getARelaBooksById(int id) {
        Book_details bd = new Book_details();
        try {
            String sql = "SELECT * FROM book_details WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bd.setId(rs.getInt("id"));
                bd.setBook_id(rs.getInt("book_id"));
                bd.setSku(rs.getString("sku_code"));
                bd.setPrice(rs.getDouble("price"));
                bd.setStatus(rs.getInt("status"));
                bd.setCreatedd(rs.getDate("created_date"));
                bd.setCreatedu(rs.getInt("created_user"));
                bd.setUpdatedd(rs.getDate("updated_date"));
                bd.setUpdatedu(rs.getInt("updated_user"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bd;
    }

    public String getARelaBooksTitle(int id) {
        String title = null;
        try {
            String sql = "SELECT book.title FROM book inner join book_details on book.id=book_details.book_id WHERE book_details.id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                title = rs.getString("title");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return title;
    }
    
    public boolean addNewBook_details(int book_id,
            String sku_code, double price, int status,
            Date createdd, int createdu, Date updatedd,
            int updatedu) {
        try {
            String sql2 = "INSERT INTO book_details VALUES(null,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setInt(1, book_id);
            ps.setString(2, sku_code);
            ps.setDouble(3, price);
            ps.setInt(4, status);
            ps.setDate(5, createdd);
            ps.setInt(6, createdu);
            ps.setDate(7, updatedd);
            ps.setInt(8, updatedu);
            int number = ps.executeUpdate();
            if (number > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateBook_details(int id, int book_id,
            String sku_code, double price, int status,
            Date createdd, int createdu, Date updatedd,
            int updatedu) {
        try {
            String sql2 = "UPDATE book_details SET sku_code=?, price =?, status=?, created_date=?, created_user=?, updated_date=?, updated_user=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setString(1, sku_code);
            ps.setDouble(2, price);
            ps.setInt(3, status);
            ps.setDate(4, createdd);
            ps.setInt(5, createdu);
            ps.setDate(6, updatedd);
            ps.setInt(7, updatedu);
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

    public boolean updateBook_detailssku(int id,
            String sku_code) {
        try {
            String sql2 = "UPDATE book_details SET sku_code=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setString(1, sku_code);
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
    
    public boolean delBookDetails(int id) {
        try {
            String sql = "DELETE FROM book_details WHERE id = ?";
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
