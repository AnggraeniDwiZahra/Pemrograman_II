package service;

import model.Penjualan;
import javafx.collections.ObservableList;

public interface PenjualanService {
    
    // Method CRUD untuk Penjualan
    boolean addPenjualan(Penjualan penjualan);
    boolean updatePenjualan(Penjualan penjualan);
    boolean deletePenjualan(int id);
    ObservableList<Penjualan> getAllPenjualan();
}
