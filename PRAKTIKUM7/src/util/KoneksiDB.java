package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDB {

    private static final String URL = "jdbc:mysql://localhost:3306/db_tokobuku"; 
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi ke database berhasil!"); 
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: Driver JDBC tidak ditemukan. (Pastikan JAR sudah di Build Path)");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("ERROR: Koneksi gagal. Cek URL, User, Password, atau server MySQL.");
            e.printStackTrace();
        }
        return connection;
    }
    
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Gagal menutup koneksi: " + e.getMessage());
            }
        }
    }
}