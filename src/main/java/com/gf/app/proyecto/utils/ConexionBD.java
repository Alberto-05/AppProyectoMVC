/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.proyecto.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alber
 */
public class ConexionBD {
    
    private static Connection conn;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bd_proyecto";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, DB_USER,DB_PASSWORD);
        return conn;

    }
    
}
