/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Book_publisher;
import model.Publisher;
import model.Book;

/**
 *
 * @author Uygi
 */
public class Book_publisherdao extends Database {

    public ArrayList<Publisher> getAllPublisherByBookId(int id) {
        ArrayList<Publisher> lstp = new ArrayList<Publisher>();
        try {
            String sql = "SELECT publisher.id, publisher.name, description from publisher inner join book_publisher "
                    + "on publisher.id = book_publisher.publisher_id where book_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Publisher p = new Publisher();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));

                lstp.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstp;
    }

    public ArrayList<Book> getAllBookByPublisherId(int id) {
        ArrayList<Book> lstb = new ArrayList<Book>();
        try {
            String sql = "SELECT book.id, title, lang_id, edition, quantity, book.status, publish_year, book.description, created_date, created_user, updated_date, updated_user from book inner join book_publisher "
                    + "on book.id = book_publisher.book_id where publisher_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
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
    
    public ArrayList<Book> getAllBookByPublisherName(String name) {
        ArrayList<Book> lstb = new ArrayList<Book>();
        try {
            String sql = "SELECT book.id, title, lang_id, edition, quantity, book.status, publish_year, book.description, created_date, created_user, updated_date, updated_user\n"
                    + "from book inner join book_publisher on book.id = book_publisher.book_id inner join publisher on book_publisher.publisher_id = publisher.id\n"
                    + "where publisher.name LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
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

    public boolean addPublisherToBook(int book_id, int publisher_id) {
        try {
            String sql2 = "INSERT INTO book_publisher VALUES (NULL,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setInt(1, book_id);
            ps.setInt(2, publisher_id);

            int number = ps.executeUpdate();
            if (number > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updatePublisherOfBook(int id, int book_id, int publisher_id) {
        try {
            String sql = "UPDATE book_publisher SET book_id = ?, publisher_id = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, book_id);
            ps.setInt(2, publisher_id);
            ps.setInt(3, id);
            int number = ps.executeUpdate();
            if (number > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean DelPublisherOfBook(int id) {
        try {
            String sql = "DELETE FROM book_publisher WHERE id = ?";
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

    public boolean delPublisherWithBook(int book_id) {
        try {
            String sql = "DELETE FROM book_publisher WHERE book_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, book_id);
            int number = ps.executeUpdate();
            if (number > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Book_publisher> getAllRelaPublisherByBookId(int id) {
        ArrayList<Book_publisher> lstbp = new ArrayList<Book_publisher>();
        try {
            String sql = "SELECT * from book_publisher where book_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book_publisher bp = new Book_publisher();
                bp.setId(rs.getInt("id"));
                bp.setBook_id(rs.getInt("book_id"));
                bp.setPublisher_id(rs.getInt("publisher_id"));

                lstbp.add(bp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstbp;
    }
}
