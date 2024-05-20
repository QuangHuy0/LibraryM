/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
 import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.Category;
/**
 *
 * @author Uygi
 */
public class Categorydao extends Database{
    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> lstc = new ArrayList<Category>();
        try{
            String sql = "SELECT * FROM Category";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while( rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDescription(rs.getString("description"));
                
                lstc.add(c);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return lstc;
    }
    
    public Category getCategoryById(int id) {
        Category c = new Category();
        try{
            String sql = "SELECT * FROM Category WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while( rs.next()) {
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDescription(rs.getString("description"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    
    public ArrayList<Category> getCategoryByName(String name) {
        ArrayList<Category> lstc = new ArrayList<Category>();
        try{
            String sql = "SELECT * FROM Category WHERE name LIKE ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            
            while( rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDescription(rs.getString("description"));
                
                lstc.add(c);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return lstc;
    }
    
    public boolean addNewCategory(int id, String name, String description) {
        try{
            String sql1 = "SELECT * FROM Category WHERE id = 'id'" ;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql1);
            if(!rs.next()) {
                String sql2 = "INSERT INTO Category VALUES (?,?,?)";
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
    
    public boolean updateCategory(int id, String name, String description) {
        try{
            String sql = "UPDATE Category SET name = ?, description = ? WHERE id = ?";
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
    
    public boolean delCategory(int id) {
        try{
            String sql = "DELETE FROM Category WHERE id = ?";
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
    
    public ArrayList<Category> getAllCategoryByid(int id) {
        ArrayList<Category> lstc = new ArrayList<Category>();
        try{
            String sql = "SELECT * FROM Category WHERE id LIKE ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            
            while( rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDescription(rs.getString("description"));
                
                lstc.add(c);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return lstc;
    }
}
