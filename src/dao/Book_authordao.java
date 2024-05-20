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
import model.Author;
import model.Book_author;
import model.Book;

/**
 *
 * @author Uygi
 */
public class Book_authordao extends Database {

    public ArrayList<Author> getAllAuthorByBookId(int id) {
        ArrayList<Author> lstau = new ArrayList<Author>();
        try {
            String sql = "SELECT author.id, author.name, description from author inner join book_author "
                    + "on author.id = book_author.author_id where book_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Author a = new Author();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setDescription(rs.getString("description"));

                lstau.add(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstau;
    }

    public ArrayList<Book> getAllBookByAuthorId(int id) {
        ArrayList<Book> lstb = new ArrayList<Book>();
        try {
            String sql = "SELECT book.id, title, lang_id, edition, quantity, book.status, publish_year, book.description, created_date, created_user, updated_date, updated_user from book inner join book_author "
                    + "on book.id = book_author.book_id where author_id = ?";
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

    public ArrayList<Book> getAllBookByAuthorName(String name) {
        ArrayList<Book> lstb = new ArrayList<Book>();
        try {
            String sql = "SELECT book.id, title, lang_id, edition, quantity, book.status, publish_year, book.description, created_date, created_user, updated_date, updated_user\n"
                    + "from book inner join book_author on book.id = book_author.book_id inner join author on book_author.author_id = author.id\n"
                    + "where author.name LIKE ?";
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

    public boolean addAuthorToBook(int book_id, int author_id) {
        try {
            String sql2 = "INSERT INTO book_author VALUES (NULL,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql2);
            ps.setInt(1, book_id);
            ps.setInt(2, author_id);

            int number = ps.executeUpdate();
            if (number > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateAuthorOfBook(int id, int book_id, int author_id) {
        try {
            String sql = "UPDATE book_author SET book_id = ?, author_id = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, book_id);
            ps.setInt(2, author_id);
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

    public boolean DelAuthorOfBook(int id) {
        try {
            String sql = "DELETE FROM book_author WHERE id = ?";
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

    public boolean delAuthorWithBook(int book_id) {
        try {
            String sql = "DELETE FROM book_author WHERE book_id = ?";
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

    public ArrayList<Book_author> getAllRelaAuthorByBookId(int id) {
        ArrayList<Book_author> lstba = new ArrayList<Book_author>();
        try {
            String sql = "SELECT * from book_author where book_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book_author ba = new Book_author();
                ba.setId(rs.getInt("id"));
                ba.setBook_id(rs.getInt("book_id"));
                ba.setAuthor_id(rs.getInt("author_id"));

                lstba.add(ba);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstba;
    }
}
