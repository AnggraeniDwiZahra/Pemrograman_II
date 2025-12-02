package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Pelanggan;
import util.KoneksiDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PelangganDAO {
    
    // READ
    public ObservableList<Pelanggan> getAllPelanggan() {
        ObservableList<Pelanggan> pelangganList = FXCollections.observableArrayList();
        String query = "SELECT pelanggan_id, nama, email, telepon FROM Pelanggan";
        
        try (Connection conn = KoneksiDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                int id = rs.getInt("pelanggan_id");
                String nama = rs.getString("nama");
                String email = rs.getString("email");
                String telepon = rs.getString("telepon");
                
                Pelanggan p = new Pelanggan(id, nama, email, telepon);
                pelangganList.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Gagal membaca data pelanggan: " + e.getMessage());
            e.printStackTrace();
        }
        return pelangganList;
    }

    // CREATE
    public boolean addPelanggan(Pelanggan p) {
        String query = "INSERT INTO Pelanggan (nama, email, telepon) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = KoneksiDB.getConnection();
            ps = conn.prepareStatement(query);
            
            ps.setString(1, p.getNama());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getTelepon());
            
            int rowAffected = ps.executeUpdate();
            return rowAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Gagal menambah data pelanggan: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) { }
            KoneksiDB.closeConnection(conn);
        }
    }
    
    // UPDATE
    public boolean updatePelanggan(Pelanggan p) {
        String query = "UPDATE Pelanggan SET nama = ?, email = ?, telepon = ? WHERE pelanggan_id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = KoneksiDB.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, p.getNama());
            ps.setString(2, p.getEmail());
            ps.setString(3, p.getTelepon());
            ps.setInt(4, p.getPelanggan_id()); // Parameter ke-4 adalah ID (WHERE clause)
            
            int rowAffected = ps.executeUpdate();
            return rowAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Gagal memperbarui data pelanggan: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) { }
            KoneksiDB.closeConnection(conn);
        }
    }
    
    // DELETE
    public boolean deletePelanggan(int id) {
        String query = "DELETE FROM Pelanggan WHERE pelanggan_id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = KoneksiDB.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            
            int rowAffected = ps.executeUpdate();
            return rowAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Gagal menghapus data pelanggan: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) { }
            KoneksiDB.closeConnection(conn);
        }
    }
}