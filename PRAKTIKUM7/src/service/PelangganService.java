package service;

import model.Pelanggan;
import javafx.collections.ObservableList;

public interface PelangganService {
    
    // Method CRUD untuk Pelanggan
    boolean addPelanggan(Pelanggan pelanggan);
    boolean updatePelanggan(Pelanggan pelanggan);
    boolean deletePelanggan(int id);
    ObservableList<Pelanggan> getAllPelanggan();
}