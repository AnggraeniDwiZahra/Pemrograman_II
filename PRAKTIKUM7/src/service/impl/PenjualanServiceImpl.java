package service.impl;

import dao.PenjualanDAO;
import model.Penjualan;
import service.PenjualanService;
import javafx.collections.ObservableList;

public class PenjualanServiceImpl implements PenjualanService {
    
    private PenjualanDAO penjualanDAO = new PenjualanDAO();
    
    @Override
    public boolean addPenjualan(Penjualan penjualan) {
        return penjualanDAO.addPenjualan(penjualan);
    }
    
    @Override
    public boolean updatePenjualan(Penjualan penjualan) {
        return penjualanDAO.updatePenjualan(penjualan);
    }
    
    @Override
    public boolean deletePenjualan(int id) {
        return penjualanDAO.deletePenjualan(id);
    }
    
    @Override
    public ObservableList<Penjualan> getAllPenjualan() {
        return penjualanDAO.getAllPenjualan();
    }
}