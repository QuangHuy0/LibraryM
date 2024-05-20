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
import model.Publisher;
/**
 *
 * @author Uygi
 */
public class Publisherdao extends Database{
    public ArrayList<Publisher> getAllPublisher() {
        ArrayList<Publisher> lstp = new ArrayList<Publisher>();
        try{
            String sql = "SELECT * FROM publisher";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while( rs.next()) {
                Publisher p = new Publisher();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                
                lstp.add(p);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return lstp;
    }
    
    public Publisher getPublisherById(int id) {
        Publisher p = new Publisher();
        try{
            String sql = "SELECT * FROM Publisher WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while( rs.next()) {
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return p;
    }
    
    public ArrayList<Publisher> getPublisherByName(String name) {
        ArrayList<Publisher> lstp = new ArrayList<Publisher>();
        try{
            String sql = "SELECT * FROM author WHERE name LIKE ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            
            while( rs.next()) {
                Publisher p = new Publisher();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                
                lstp.add(p);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return lstp;
    }
    
    public boolean addNewPublisher(int id, String name, String description) {
        try{
            String sql1 = "SELECT * FROM Publisher WHERE id = 'id'" ;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql1);
            if(!rs.next()) {
                String sql2 = "INSERT INTO Publisher VALUES (?,?,?)";
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
    
    public boolean updatePublisher(int id, String name, String description) {
        try{
            String sql = "UPDATE Publisher SET name = ?, description = ? WHERE id = ?";
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
    
    public boolean delPublisher(int id) {
        try{
            String sql = "DELETE FROM Publisher WHERE id = ?";
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
    
    public ArrayList<Publisher> getAllPublisherByid(int id) {
        ArrayList<Publisher> lstp = new ArrayList<Publisher>();
        try{
            String sql = "SELECT * FROM publisher WHERE id LIKE ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            
            while( rs.next()) {
                Publisher p = new Publisher();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                
                lstp.add(p);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return lstp;
    }
}
