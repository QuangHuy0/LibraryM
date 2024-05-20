/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Book;

/**
 *
 * @author Uygi
 */
public class Bookdao extends Database {

    public ArrayList<Book> getAllBook() {
        ArrayList<Book> lstb = new ArrayList<Book>();
        try {
            String sql = "SELECT * FROM book";
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setLang_id(rs.getInt("lang_id"));
                b.setEdition(rs.getInt("edition"));
                b.setQuantity(rs.getInt("quantity"));
                b.setStatus(rs.getInt("status"));
                b.setPublish_year(rs.getInt("publish_year"));
                b.setDescription(rs.getString("description"));
                b.setCreatedd(rs.getDate("created_date"));
                b.setCreatedu(rs.getInt("created_user"));
                b.setUpdatedd(rs.getDate("updated_date"));
                b.setUpdatedu(rs.getInt("updated_user"));

                lstb.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstb;
    }

    public ArrayList<Book> getBookById(int id) {
        ArrayList<Book> lstb = new ArrayList<Book>();
        try {
            String sql = "SELECT * FROM book WHERE id = '" + id + "'";
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setLang_id(rs.getInt("lang_id"));
                b.setEdition(rs.getInt("edition"));
                b.setQuantity(rs.getInt("quantity"));
                b.setStatus(rs.getInt("status"));
                b.setPublish_year(rs.getInt("publish_year"));
                b.setDescription(rs.getString("description"));
                b.setCreatedd(rs.getDate("created_date"));
                b.setCreatedu(rs.getInt("created_user"));
                b.setUpdatedd(rs.getDate("updated_date"));
                b.setUpdatedu(rs.getInt("updated_user"));

                lstb.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstb;
    }

    public Book getABookById(int id) {
        Book b = new Book();
        try {
            String sql = "SELECT * FROM book WHERE id = '" + id + "'";
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setLang_id(rs.getInt("lang_id"));
                b.setEdition(rs.getInt("edition"));
                b.setQuantity(rs.getInt("quantity"));
                b.setStatus(rs.getInt("status"));
                b.setPublish_year(rs.getInt("publish_year"));
                b.setDescription(rs.getString("description"));
                b.setCreatedd(rs.getDate("created_date"));
                b.setCreatedu(rs.getInt("created_user"));
                b.setUpdatedd(rs.getDate("updated_date"));
                b.setUpdatedu(rs.getInt("updated_user"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public boolean addNewBook(int id, String title, int lang_id,
            int edition, int quantity, int status, int publish_year,
            String description, Date created_date, int created_user, Date updated_date, int updated_user) {

        try {
            String sql1 = "SELECT * FROM book WHERE id = 'id'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql1);
            if (!rs.next()) {
                String sql2 = "INSERT INTO book VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql2);
                ps.setInt(1, id);
                ps.setString(2, title);
                ps.setInt(3, lang_id);
                ps.setInt(4, edition);
                ps.setInt(5, quantity);
                ps.setInt(6, status);
                ps.setInt(7, publish_year);
                ps.setString(8, description);
                ps.setDate(9, created_date);
                ps.setInt(10, created_user);
                ps.setDate(11, updated_date);
                ps.setInt(12, updated_user);

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

    public boolean updateBook(int id, String title, int lang_id,
            int edition, int quantity, int status, int publish_year,
            String description, Date created_date, int created_user, Date updated_date, int updated_user) {
        try {
            String sql = "UPDATE book SET title = ?, lang_id = ?, edition = ?, quantity = ?, status = ?, publish_year = ?, description = ?, created_date = ?, created_user = ?, updated_date = ?, updated_user = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setInt(2, lang_id);
            ps.setInt(3, edition);
            ps.setInt(4, quantity);
            ps.setInt(5, status);
            ps.setInt(6, publish_year);
            ps.setString(7, description);
            ps.setDate(8, created_date);
            ps.setInt(9, created_user);
            ps.setDate(10, updated_date);
            ps.setInt(11, updated_user);
            ps.setInt(12, id);
            int number = ps.executeUpdate();
            if (number > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delBook(int id) {
        try {
            String sql = "DELETE FROM book WHERE id = ?";
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
