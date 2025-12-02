package service;

import model.Buku;
import javafx.collections.ObservableList;

public interface BukuService {
    
    // Method CRUD untuk Buku
    boolean addBuku(Buku buku);
    boolean updateBuku(Buku buku);
    boolean deleteBuku(int id);
    ObservableList<Buku> getAllBuku();
}