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
import model.Reader;

/**
 *
 * @author Uygi
 */
public class Readerdao extends Database {

    public ArrayList<Reader> getAllReader() {
        ArrayList<Reader> lstr = new ArrayList<Reader>();
        try {
            String sql = "SELECT * FROM customer";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Reader r = new Reader();
                r.setId(rs.getInt("id"));
                r.setAvatar(rs.getString("avatar"));
                r.setName(rs.getString("name"));
                r.setPhone(rs.getString("phone"));
                r.setBirthday(rs.getDate("birthday"));
                r.setGender(rs.getInt("gender"));
                r.setStatus(rs.getInt("status"));
                r.setAddress(rs.getString("address"));
                r.setCreatedd(rs.getDate("created_date"));
                r.setCrearedu(rs.getInt("created_user"));
                r.setUpdatedd((rs.getDate("updated_date")));
                r.setUpdatedu(rs.getInt("updated_user"));

                lstr.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstr;
    }

    public ArrayList<Reader> getReaderById(int id) {
        ArrayList<Reader> lstr = new ArrayList<Reader>();
        try {
            String sql = "SELECT * FROM customer WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reader r = new Reader();
                r.setId(rs.getInt("id"));
                r.setAvatar(rs.getString("avatar"));
                r.setName(rs.getString("name"));
                r.setPhone(rs.getString("phone"));
                r.setBirthday(rs.getDate("birthday"));
                r.setGender(rs.getInt("gender"));
                r.setStatus(rs.getInt("status"));
                r.setAddress(rs.getString("address"));
                r.setCreatedd(rs.getDate("created_date"));
                r.setCrearedu(rs.getInt("created_user"));
                r.setUpdatedd((rs.getDate("updated_date")));
                r.setUpdatedu(rs.getInt("updated_user"));

                lstr.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstr;
    }

    public ArrayList<Reader> getReaderByName(String name) {
        ArrayList<Reader> lstr = new ArrayList<Reader>();
        try {
            String sql = "SELECT * FROM customer WHERE name LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reader r = new Reader();
                r.setId(rs.getInt("id"));
                r.setAvatar(rs.getString("avatar"));
                r.setName(rs.getString("name"));
                r.setPhone(rs.getString("phone"));
                r.setBirthday(rs.getDate("birthday"));
                r.setGender(rs.getInt("gender"));
                r.setStatus(rs.getInt("status"));
                r.setAddress(rs.getString("address"));
                r.setCreatedd(rs.getDate("created_date"));
                r.setCrearedu(rs.getInt("created_user"));
                r.setUpdatedd((rs.getDate("updated_date")));
                r.setUpdatedu(rs.getInt("updated_user"));

                lstr.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstr;
    }

    public Reader getAReaderById(int id) {
        Reader r = new Reader();
        try {
            String sql = "SELECT * FROM customer WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                r.setId(rs.getInt("id"));
                r.setAvatar(rs.getString("avatar"));
                r.setName(rs.getString("name"));
                r.setPhone(rs.getString("phone"));
                r.setBirthday(rs.getDate("birthday"));
                r.setGender(rs.getInt("gender"));
                r.setStatus(rs.getInt("status"));
                r.setAddress(rs.getString("address"));
                r.setCreatedd(rs.getDate("created_date"));
                r.setCrearedu(rs.getInt("created_user"));
                r.setUpdatedd((rs.getDate("updated_date")));
                r.setUpdatedu(rs.getInt("updated_user"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public boolean addNewReader(int id, String avatar, String name,
            String phone, Date birthday, int gender, int status, String address,
            Date created_date, int created_user, Date updated_date,
            int updated_user) {
        try {
            String sql1 = "SELECT * FROM customer WHERE id = 'id'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql1);
            if (!rs.next()) {
                String sql2 = "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql2);
                ps.setInt(1, id);
                ps.setString(2, avatar);
                ps.setString(3, name);
                ps.setString(4, phone);
                ps.setDate(5, birthday);
                ps.setInt(6, gender);
                ps.setInt(7, status);
                ps.setString(8, address);
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

    public boolean updateReader(int id, String avatar, String name,
            String phone, Date birthday, int gender, int status, String address,
            Date created_date, int created_user, Date updated_date,
            int updated_user) {
        try {
            String sql = "UPDATE customer SET avatar = ?, name = ?, phone = ?, birthday = ?, gender = ?, status=?, address=?, created_date=?, created_user=?, updated_date=?, updated_user=? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, avatar);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setDate(4, birthday);
            ps.setInt(5, gender);
            ps.setInt(6, status);
            ps.setString(7, address);
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

    public boolean delReader(int id) {
        try {
            String sql = "DELETE FROM customer WHERE id = ?";
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
