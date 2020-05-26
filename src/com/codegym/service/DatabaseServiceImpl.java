package com.codegym.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseServiceImpl {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/thuc_hanh_module_3";
    private static String jdbcUser = "root";
    private static String jdbcPassword = "11100001";
    private static final String FOREIGN_KEY_CHECKS = "SET FOREIGN_KEY_CHECKS=0";

    public Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return conn;
    }

    public Connection setCheckForeignKey() {
        Connection conn = getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(FOREIGN_KEY_CHECKS);
            pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return conn;
    }
}
