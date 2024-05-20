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
import model.Book_category;
import model.Category;
import model.Book;
/**
 *
 * @author Uygi
 */
public class Book_categorydao extends Database{
    public ArrayList<Category> getAllCategoryByBookId(int id) {
        ArrayList<Category> lstc = new ArrayList<Category>();
        try {
            String sql = "SELECT category.id, category.name, description from category inner join book_category "
                    + "on category.id = book_category.category_id where book_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDescription(rs.getString("description"));

                lstc.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstc;
    }
    
    public ArrayList<Book> getAllBookByCategoryId(int id) {
        ArrayList<Book> lstb = new ArrayList<Book>();
        try {
            String sql = "SELECT book.id, title, lang_id, edition, quantity, book.status, publish_year, book.description, created_date, created_user, updated_date, updated_user from book inner join book_category "
                    + "on book.id = book_category.book_id where category_id = ?";
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
    
    public ArrayList<Book> getAllBookByCategoryName(String name) {
        ArrayList<Book> lstb = new ArrayList<Book>();
        try {
            String sql = "SELECT book.id, title, lang_id, edition, quantity, book.status, publish_year, book.description, created_date, created_user, updated_date, updated_user\n"
                    + "from book inner join book_category on book.id = book_category.book_id inner join category on book_category.category_id = category.id\n"
                    + "where category.name LIKE ?";
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
    
    public boolean addCategoryToBook(int book_id, int category_id) {
        try{
                String sql2 = "INSERT INTO book_category VALUES (NULL,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql2);
                ps.setInt(1, book_id);
                ps.setInt(2, category_id);
                
                int number = ps.executeUpdate();
                if(number>0) {
                    return true;
                }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateCategoryOfBook(int id, int book_id, int category_id) {
        try{
            String sql = "UPDATE book_author SET book_id = ?, category_id = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, book_id);
            ps.setInt(2, category_id);
            ps.setInt(3, id);
            int number = ps.executeUpdate();
            if(number>0) {
                return true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean DelCategoryOfBook(int id) {
        try{
            String sql = "DELETE FROM book_category WHERE id = ?";
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
    
    public boolean delCategoryWithBook(int book_id){
        try{
            String sql = "DELETE FROM book_category WHERE book_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, book_id);
            int number = ps.executeUpdate();
            if(number>0) {
                return true;
            }        
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<Book_category> getAllRelaCategoryByBookId(int id) {
        ArrayList<Book_category> lstbc = new ArrayList<Book_category>();
        try {
            String sql = "SELECT * from book_category where book_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book_category bc = new Book_category();
                bc.setId(rs.getInt("id"));
                bc.setBook_id(rs.getInt("book_id"));
                bc.setCategory_id(rs.getInt("category_id"));

                lstbc.add(bc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstbc;
    }
}
