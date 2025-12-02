package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Buku;
import util.KoneksiDB;

import java.sql.*;

public class BukuDAO {
	   
    // READ
    public ObservableList<Buku> getAllBuku() {
        ObservableList<Buku> bukuList = FXCollections.observableArrayList();
        String query = "SELECT buku_id, judul, penulis, harga, stok FROM Buku";
        
        try (Connection conn = KoneksiDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                int id = rs.getInt("buku_id");
                String judul = rs.getString("judul");
                String penulis = rs.getString("penulis");
                double harga = rs.getDouble("harga");
                int stok = rs.getInt("stok");
                
                Buku b = new Buku(id, judul, penulis, harga, stok);
                bukuList.add(b);
            }
        } catch (SQLException e) {
            System.err.println("Gagal membaca data buku: " + e.getMessage());
        }
        return bukuList;
    }

    // CREATE
    public boolean addBuku(Buku b) {
        String query = "INSERT INTO Buku (judul, penulis, harga, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, b.getJudul());
            ps.setString(2, b.getPenulis());
            ps.setDouble(3, b.getHarga());
            ps.setInt(4, b.getStok());
            
            int rowAffected = ps.executeUpdate();
            return rowAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Gagal menambah data buku: " + e.getMessage());
            return false;
        }
    }
    
    // UPDATE
    public boolean updateBuku(Buku b) {
        String query = "UPDATE Buku SET judul = ?, penulis = ?, harga = ?, stok = ? WHERE buku_id = ?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, b.getJudul());
            ps.setString(2, b.getPenulis());
            ps.setDouble(3, b.getHarga());
            ps.setInt(4, b.getStok());
            ps.setInt(5, b.getbuku_id()); 
            
            int rowAffected = ps.executeUpdate();
            return rowAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Gagal memperbarui data buku: " + e.getMessage());
            return false;
        }
    }
    
    // DELETE
    public boolean deleteBuku(int id) {
        String query = "DELETE FROM Buku WHERE buku_id = ?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, id);
            
            int rowAffected = ps.executeUpdate();
            return rowAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Gagal menghapus data buku: " + e.getMessage());
            return false;
        }
    }
}