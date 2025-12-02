package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Penjualan;
import util.KoneksiDB;

import java.sql.*;

public class PenjualanDAO {
    
    // READ
    public ObservableList<Penjualan> getAllPenjualan() {
        ObservableList<Penjualan> penjualanList = FXCollections.observableArrayList();
        String query = "SELECT penjualan_id, jumlah, total_harga, tanggal, pelanggan_id, buku_id FROM Penjualan";
        
        try (Connection conn = KoneksiDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                int id = rs.getInt("penjualan_id");
                int jumlah = rs.getInt("jumlah");
                double totalHarga = rs.getDouble("total_harga");
                String tanggal = rs.getString("tanggal"); // Atau rs.getDate("tanggal").toString()
                int pelangganId = rs.getInt("pelanggan_id");
                int bukuId = rs.getInt("buku_id");
                
                Penjualan p = new Penjualan(id, jumlah, totalHarga, tanggal, pelangganId, bukuId);
                penjualanList.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Gagal membaca data penjualan: " + e.getMessage());
        }
        return penjualanList;
    }

    // CREATE
    public boolean addPenjualan(Penjualan p) {
        String query = "INSERT INTO Penjualan (jumlah, total_harga, tanggal, pelanggan_id, buku_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, p.getJumlah());
            ps.setDouble(2, p.getTotal_harga());
            ps.setString(3, p.getTanggal()); 
            ps.setInt(4, p.getPelanggan_id());
            ps.setInt(5, p.getBuku_id());
            
            int rowAffected = ps.executeUpdate();
            return rowAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Gagal menambah data penjualan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // UPDATE 
    public boolean updatePenjualan(Penjualan p) {
        String query = "UPDATE Penjualan SET jumlah = ?, total_harga = ?, tanggal = ?, pelanggan_id = ?, buku_id = ? WHERE penjualan_id = ?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, p.getJumlah());
            ps.setDouble(2, p.getTotal_harga());
            ps.setString(3, p.getTanggal());
            ps.setInt(4, p.getPelanggan_id());
            ps.setInt(5, p.getBuku_id());
            ps.setInt(6, p.getPenjualan_id()); 
            
            int rowAffected = ps.executeUpdate();
            return rowAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Gagal memperbarui data penjualan: " + e.getMessage());
            return false;
        }
    }
    
    // DELETE
    public boolean deletePenjualan(int id) {
        String query = "DELETE FROM Penjualan WHERE penjualan_id = ?";
        try (Connection conn = KoneksiDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, id);
            
            int rowAffected = ps.executeUpdate();
            return rowAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("Gagal menghapus data penjualan: " + e.getMessage());
            return false;
        }
    }
}
