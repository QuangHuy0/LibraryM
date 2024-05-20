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
import model.Languages;
/**
 *
 * @author Uygi
 */
public class Languagesdao extends Database{
    public ArrayList<Languages> getAllLanguages() {
        ArrayList<Languages> lstl = new ArrayList<Languages>();
        try{
            String sql = "SELECT * FROM languages";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                Languages l = new Languages();
                l.setId(rs.getInt("id"));
                l.setName(rs.getString("name"));
                
                lstl.add(l);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return lstl;
    }
    
    public ArrayList<Languages> getAllLanguagesById(int id) {
        ArrayList<Languages> lstl = new ArrayList<Languages>();
        try{
            String sql = "SELECT * FROM languages WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()) {
                Languages l = new Languages();
                l.setId(rs.getInt("id"));
                l.setName(rs.getString("name"));
                
                lstl.add(l);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return lstl;
    }
    
    public Languages getALanguagesByName(String name) {
        Languages l = new Languages();
        try{
            String sql = "SELECT * FROM languages WHERE name LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {

                l.setId(rs.getInt("id"));
                l.setName(rs.getString("name"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return l;
    }
    
    public Languages getALanguagesById(int id) {
        Languages l = new Languages();
        try{
            String sql = "SELECT * FROM languages WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                l.setId(rs.getInt("id"));
                l.setName(rs.getString("name"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return l;
    }
    
    public boolean addLanguages(int id, String name) {
        try{
            String sql1 = "SELECT * FROM languages WHERE id = 'id'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql1);
            if(!rs.next()) {
                String sql2 = "INSERT INTO languages VALUES (?,?)";
                PreparedStatement ps = conn.prepareStatement(sql2);
                ps.setInt(1, id);
                ps.setString(2, name);
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
    
    public boolean updateLanguages(int id, String name) {
        try{
            String sql = "UPDATE languages SET name = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, id);
            
            int number = ps.executeUpdate();
            if(number > 0) {
                return true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delLanguages(int id) {
        try{
            String sql = "DELETE FROM languages WHERE id = ?";
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
