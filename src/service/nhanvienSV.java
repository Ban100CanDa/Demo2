/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import model.nhanvien;
import java.sql.*;

/**
 *
 * @author acer
 */
public class nhanvienSV {
    public ArrayList<nhanvien> listnv;
    Connection conn = JDBC.getConnection();

    public nhanvienSV() {
        listnv = new ArrayList<>();
    }

    public ArrayList<nhanvien> getListnv() {
        listnv = new ArrayList<>();
        try {
            String sql = "select Ma, NgaySinh, Sdt, TrangThai from NhanVien";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                String ma = rs.getString(1);
                Date ngay = rs.getDate(2);
                String sdt = rs.getString(3);
                int tt = rs.getInt(4);
                nhanvien nv = new nhanvien(ma, ngay, sdt, tt);
                listnv.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listnv;
    }
    public Integer them(nhanvien nv){
        try {
            String sql = "insert into NhanVien(Ma, NgaySinh, Sdt, TrangThai) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getMa());
            ps.setDate(2, (Date) nv.getNgay());
            ps.setString(3, nv.getSo());
            ps.setInt(4, nv.getTrangthai());
            int r = ps.executeUpdate();
            if(r>0){
                return r;
            }
        } catch (Exception e) {
        }
        return null;
    }
    public Integer xoa(String ma){
        try {
            String sql = "delete from NhanVien where Ma =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            int r = ps.executeUpdate();
            if(r>0){
                return r;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Integer sua(String ma, nhanvien nv){
        try {
            String sql ="update NhanVien set NgaySinh=?, Sdt=?, TrangThai=? where Ma =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, (Date) nv.getNgay());
            ps.setString(2, nv.getSo());
            ps.setInt(3, nv.getTrangthai());
            ps.setString(4, nv.getMa());
            int r = ps.executeUpdate();
            if(r>0){
                return r;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setListnv(ArrayList<nhanvien> listnv) {
        this.listnv = listnv;
    }
    
}
