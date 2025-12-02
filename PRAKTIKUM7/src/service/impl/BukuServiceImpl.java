package service.impl;

import dao.BukuDAO;
import model.Buku;
import service.BukuService;
import javafx.collections.ObservableList;

public class BukuServiceImpl implements BukuService {
    
    private BukuDAO bukuDAO = new BukuDAO();
    
    @Override
    public boolean addBuku(Buku buku) {
        if (buku.getStok() < 0) return false;
        return bukuDAO.addBuku(buku);
    }
    
    @Override
    public boolean updateBuku(Buku buku) {
        return bukuDAO.updateBuku(buku);
    }
    
    @Override
    public boolean deleteBuku(int id) {
        return bukuDAO.deleteBuku(id);
    }
    
    @Override
    public ObservableList<Buku> getAllBuku() {
        return bukuDAO.getAllBuku();
    }
}