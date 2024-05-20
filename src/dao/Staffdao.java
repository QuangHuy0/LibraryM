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
import model.Staff;

/**
 *
 * @author Uygi
 */
public class Staffdao extends Database {

    public ArrayList<Staff> getAllStaff() {
        ArrayList<Staff> lsts = new ArrayList<Staff>();
        try {
            String sql = "SELECT * FROM employee";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Staff s = new Staff();
                s.setId(rs.getInt("id"));
                s.setUser(rs.getString("user_name"));
                s.setPass(rs.getString("password"));
                s.setAvatar(rs.getString("avatar"));
                s.setName(rs.getString("full_name"));
                s.setPhone(rs.getString("phone"));
                s.setBirthday(rs.getDate("birthday"));
                s.setGender(rs.getInt("gender"));
                s.setAddress(rs.getString("address"));
                s.setStatus(rs.getInt("status"));
                s.setStartd(rs.getDate("start_date"));
                s.setEndd(rs.getDate("end_date"));

                lsts.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsts;
    }

    public ArrayList<Staff> getAllStaffById(int id) {
        ArrayList<Staff> lsts = new ArrayList<Staff>();
        try {
            String sql = "SELECT * FROM employee WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Staff s = new Staff();
                s.setId(rs.getInt("id"));
                s.setUser(rs.getString("user_name"));
                s.setPass(rs.getString("password"));
                s.setAvatar(rs.getString("avatar"));
                s.setName(rs.getString("full_name"));
                s.setPhone(rs.getString("phone"));
                s.setBirthday(rs.getDate("birthday"));
                s.setGender(rs.getInt("gender"));
                s.setAddress(rs.getString("address"));
                s.setStatus(rs.getInt("status"));
                s.setStartd(rs.getDate("start_date"));
                s.setEndd(rs.getDate("end_date"));

                lsts.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsts;
    }

    public ArrayList<Staff> getAllStaffByName(String name) {
        ArrayList<Staff> lsts = new ArrayList<Staff>();
        try {
            String sql = "SELECT * FROM employee WHERE full_name LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Staff s = new Staff();
                s.setId(rs.getInt("id"));
                s.setUser(rs.getString("user_name"));
                s.setPass(rs.getString("password"));
                s.setAvatar(rs.getString("avatar"));
                s.setName(rs.getString("full_name"));
                s.setPhone(rs.getString("phone"));
                s.setBirthday(rs.getDate("birthday"));
                s.setGender(rs.getInt("gender"));
                s.setAddress(rs.getString("address"));
                s.setStatus(rs.getInt("status"));
                s.setStartd(rs.getDate("start_date"));
                s.setEndd(rs.getDate("end_date"));

                lsts.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lsts;
    }

    public Staff getAStaffById(int id) {
        Staff s = new Staff();
        try {
            String sql = "SELECT * FROM employee WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s.setId(rs.getInt("id"));
                s.setUser(rs.getString("user_name"));
                s.setPass(rs.getString("password"));
                s.setAvatar(rs.getString("avatar"));
                s.setName(rs.getString("full_name"));
                s.setPhone(rs.getString("phone"));
                s.setBirthday(rs.getDate("birthday"));
                s.setGender(rs.getInt("gender"));
                s.setAddress(rs.getString("address"));
                s.setStatus(rs.getInt("status"));
                s.setStartd(rs.getDate("start_date"));
                s.setEndd(rs.getDate("end_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    
    public Staff getAStaffByUserPass(String user, String pass) {
        Staff s = new Staff();
        try {
            String sql = "SELECT * FROM employee WHERE user_name = ? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s.setId(rs.getInt("id"));
                s.setUser(rs.getString("user_name"));
                s.setPass(rs.getString("password"));
                s.setAvatar(rs.getString("avatar"));
                s.setName(rs.getString("full_name"));
                s.setPhone(rs.getString("phone"));
                s.setBirthday(rs.getDate("birthday"));
                s.setGender(rs.getInt("gender"));
                s.setAddress(rs.getString("address"));
                s.setStatus(rs.getInt("status"));
                s.setStartd(rs.getDate("start_date"));
                s.setEndd(rs.getDate("end_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public boolean addNewStaff(int id, String user, String pass, String avatar,
            String name, String phone, Date birthday, int gender,
            String address, int statuss, Date startd, Date endd) {
        try {
            String sql1 = "SELECT * FROM employee WHERE id = 'id'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql1);
            if (!rs.next()) {
                String sql2 = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql2);
                ps.setInt(1, id);
                ps.setString(2, user);
                ps.setString(3, pass);
                ps.setString(4, avatar);
                ps.setString(5, name);
                ps.setString(6, phone);
                ps.setDate(7, birthday);
                ps.setInt(8, gender);
                ps.setString(9, address);
                ps.setInt(10, statuss);
                ps.setDate(11, startd);
                ps.setDate(12, endd);
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

    public boolean updateStaff(int id, String user, String pass, String avatar,
            String name, String phone, Date birthday, int gender,
            String address, int statuss, Date startd, Date endd) {
        try {
            String sql = "UPDATE employee SET user_name=?, password=?, avatar = ?, full_name=?, phone=?, birthday=?, gender=?, address=?, status=?, start_date=?, end_date=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, avatar);
            ps.setString(4, name);
            ps.setString(5, phone);
            ps.setDate(6, birthday);
            ps.setInt(7, gender);
            ps.setString(8, address);
            ps.setInt(9, statuss);
            ps.setDate(10, startd);
            ps.setDate(11, endd);
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

    public boolean delStaff(int id) {
        try {
            String sql = "DELETE FROM employee WHERE id = ?";
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
    
    public boolean checkLogin(String user, String pass) {
        try {
            String sql = "Select * FROM employee WHERE user_name = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
