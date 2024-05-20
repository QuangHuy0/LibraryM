/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.Punish;
import java.util.ArrayList;

/**
 *
 * @author Uygi
 */
public class Punishdao extends Database {

    public ArrayList<Punish> getAllPunish() {
        ArrayList<Punish> lstpn = new ArrayList<Punish>();
        try {
            String sql = "SELECT * FROM punish";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Punish pn = new Punish();
                pn.setId(rs.getInt("id"));
                pn.setName(rs.getString("name"));
                pn.setDescription(rs.getString("description"));

                lstpn.add(pn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstpn ;
    }
    
    public ArrayList<Punish> getAllPunishById(int id) {
        ArrayList<Punish> lstpn = new ArrayList<Punish>();
        try {
            String sql = "SELECT * FROM punish WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Punish pn = new Punish();
                pn.setId(rs.getInt("id"));
                pn.setName(rs.getString("name"));
                pn.setDescription(rs.getString("description"));

                lstpn.add(pn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstpn ;
    }
    
    public ArrayList<Punish> getAllPunishByName(String name) {
        ArrayList<Punish> lstpn = new ArrayList<Punish>();
        try {
            String sql = "SELECT * FROM punish WHERE name LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Punish pn = new Punish();
                pn.setId(rs.getInt("id"));
                pn.setName(rs.getString("name"));
                pn.setDescription(rs.getString("description"));

                lstpn.add(pn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstpn ;
    }
    
    public boolean addAPunish(int id, String name, String description) {
        try{
            String sql1 = "SELECT * FROM punish WHERE id = 'id'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql1);
            if(!rs.next()) {
                String sql2 = "INSERT INTO punish VALUES(?, ?, ?)";
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
    
    public boolean updateAPunish(int id, String name, String description) {
        try{
                String sql = "UPDATE punish SET name = ?, description = ? WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, description);
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
    
    public boolean delPunish(int id) {
        try{
            String sql = "DELETE FROM punish WHERE id = ?";
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
