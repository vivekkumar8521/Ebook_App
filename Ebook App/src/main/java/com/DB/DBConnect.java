package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    private static Connection conn;

    public static Connection getConn() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection( 
                    "jdbc:mysql://localhost:3306/ebook-app", "root", "12345");
                System.out.println("✅ DB Connected Successfully: " + conn);
            }
        } catch (Exception e) {
            System.out.println("❌ DB Connection Error:");
            e.printStackTrace();
        } 
        return conn; 
    }
}
