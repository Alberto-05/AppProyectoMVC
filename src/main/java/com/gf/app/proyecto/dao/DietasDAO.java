/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.proyecto.dao;

import com.gf.app.proyecto.entities.Dietas;
import com.gf.app.proyecto.utils.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author alber
 */
public class DietasDAO {

    public static int insert(Dietas d) throws Exception {
        String sql = "INSERT INTO dietas VALUES (?,?,?,?,?)";
        try (Connection conn = ConexionBD.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, d.getId());
            ps.setBoolean(2, d.isBlanda());
            ps.setBoolean(3, d.isAstringente());
            ps.setBoolean(4, d.isAyuno());
            ps.setBoolean(5, d.isSonda());
            return ps.executeUpdate();
        }
    }

    public static int update(Dietas d) throws Exception {
        String sql = "UPDATE dietas SET blanda=?, astringente=?, ayuno=?, sonda=? WHERE id=?";
        try (Connection conn = ConexionBD.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, d.isBlanda());
            ps.setBoolean(2, d.isAstringente());
            ps.setBoolean(3, d.isAyuno());
            ps.setBoolean(4, d.isSonda());
            ps.setInt(5, d.getId());
            return ps.executeUpdate();
        }
    }

    public static int delete(Dietas s) throws Exception {
        String sql = "DELETE  FROM  dietas  WHERE id= ?";
        try (Connection conn = ConexionBD.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getId());
            return ps.executeUpdate();
        }
    }

    public static boolean selectId(Dietas d) throws Exception {
        String sql = "SELECT * FROM dietas WHERE id=?";
        boolean exist = false;
        try (Connection conn = ConexionBD.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, d.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                exist = true;
            }
        }
        return exist;
    }

    public static Set<Dietas> select(Dietas d) throws Exception {
        String sql_id = "SELECT * FROM dietas WHERE id=?";
        String sql_total = "SELECT * FROM dietas";
        Set<Dietas> list = new HashSet<>();
        PreparedStatement ps;
        try (Connection conn = ConexionBD.getConnection()) {
            if (d.getId() != 0) {
                ps = conn.prepareStatement(sql_id);
                ps.setInt(1, d.getId());
            } else {
                ps = conn.prepareStatement(sql_total);
                
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dietas dietas = new Dietas();
                dietas.setId(rs.getInt(1));
                dietas.setBlanda(rs.getBoolean(2));
                dietas.setAstringente(rs.getBoolean(3));
                dietas.setAyuno(rs.getBoolean(4));
                dietas.setSonda(rs.getBoolean(5));
                list.add(dietas);
            }
        }
        return list;
    }

}
