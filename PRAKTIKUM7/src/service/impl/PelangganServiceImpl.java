package service.impl;

import dao.PelangganDAO; 
import model.Pelanggan;
import service.PelangganService;
import javafx.collections.ObservableList;

public class PelangganServiceImpl implements PelangganService {
    
    private PelangganDAO pelangganDAO = new PelangganDAO();
    
    @Override
    public boolean addPelanggan(Pelanggan pelanggan) {
        return pelangganDAO.addPelanggan(pelanggan);
    }
    
    @Override
    public boolean updatePelanggan(Pelanggan pelanggan) {
        return pelangganDAO.updatePelanggan(pelanggan);
    }
    
    @Override
    public boolean deletePelanggan(int id) {
        return pelangganDAO.deletePelanggan(id);
    }
    
    @Override
    public ObservableList<Pelanggan> getAllPelanggan() {
        return pelangganDAO.getAllPelanggan();
    }
}