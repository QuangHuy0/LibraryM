/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Author;

/**
 *
 * @author Uygi
 */
public class Authordao extends Database{
    public ArrayList<Author> getAllAuthor() {
        ArrayList<Author> lstau = new ArrayList<Author>();
        try{
            String sql = "SELECT * FROM author";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while( rs.next()) {
                Author a = new Author();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setDescription(rs.getString("description"));
                
                lstau.add(a);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return lstau;
    }
    
    public Author getAnAuthorById(int id) {
        Author a = new Author();
        try{
            String sql = "SELECT * FROM author WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while( rs.next()) {
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setDescription(rs.getString("description"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return a;
    }
    
    public ArrayList<Author> getAuthorByName(String name) {
        ArrayList<Author> lstau = new ArrayList<Author>();
        try{
            String sql = "SELECT * FROM author WHERE name LIKE ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            
            while( rs.next()) {
                Author a = new Author();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setDescription(rs.getString("description"));
                
                lstau.add(a);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return lstau;
    }
    
    public boolean addNewAuthor(int id, String name, String description) {
        try{
            String sql1 = "SELECT * FROM author WHERE id = 'id'" ;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql1);
            if(!rs.next()) {
                String sql2 = "INSERT INTO author VALUES (?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql2);
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, description);
                
                int number = ps.executeUpdate();
                if(number>0) {
                    return true;
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateAuthor(int id, String name, String description) {
        try{
            String sql = "UPDATE author SET name = ?, description = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setInt(3, id);
            
            int number = ps.executeUpdate();
            if(number > 0) {
                return true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delAuthor(int id) {
        try{
            String sql = "DELETE FROM author WHERE id = ?";
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
    
    public ArrayList<Author> getAllAuthorByid(int id) {
        ArrayList<Author> lstau = new ArrayList<Author>();
        try{
            String sql = "SELECT * FROM author WHERE id LIKE ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            
            while( rs.next()) {
                Author a = new Author();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                a.setDescription(rs.getString("description"));
                
                lstau.add(a);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return lstau;
    }
}
