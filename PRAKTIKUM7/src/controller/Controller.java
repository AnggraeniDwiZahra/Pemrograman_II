package controller;

import service.impl.PelangganServiceImpl;
import service.impl.BukuServiceImpl;
import service.impl.PenjualanServiceImpl;

import model.Buku;
import model.Pelanggan;
import model.Penjualan;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*; 
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // 1. INSTANSIASI SERVICE 
    private PelangganServiceImpl pelangganService = new PelangganServiceImpl();
    private BukuServiceImpl bukuService = new BukuServiceImpl();
    private PenjualanServiceImpl penjualanService = new PenjualanServiceImpl();


    // 2. DEKLARASI KOMPONEN GUI (@FXML)

    // TAB PELANGGAN
    @FXML private TableView<Pelanggan> tvPelanggan;
    @FXML private TableColumn<Pelanggan, Integer> colPelangganId; 
    @FXML private TableColumn<Pelanggan, String> colNama;        
    @FXML private TableColumn<Pelanggan, String> colEmail;       
    @FXML private TableColumn<Pelanggan, String> colTelepon;     
    @FXML private TextField txtNamaPelanggan;
    @FXML private TextField txtEmailPelanggan;
    @FXML private TextField txtTeleponPelanggan;
    @FXML private Button btnAddPelanggan;
    @FXML private Button btnEditPelanggan;
    @FXML private Button btnDeletePelanggan;



    // TAB BUKU
    @FXML private TableView<Buku> tvBuku;
    @FXML private TableColumn<Buku, Integer> colBukuId;
    @FXML private TableColumn<Buku, String> colJudulBuku;
    @FXML private TableColumn<Buku, String> colPenulisBuku;
    @FXML private TableColumn<Buku, Double> colHargaBuku;
    @FXML private TableColumn<Buku, Integer> colStokBuku;
    @FXML private TextField txtJudulBuku;
    @FXML private TextField txtPenulisBuku;
    @FXML private TextField txtHargaBuku;
    @FXML private TextField txtStokBuku;
    @FXML private Button btnAddBuku;
    @FXML private Button btnEditBuku;
    @FXML private Button btnDeleteBuku;



    // TAB PENJUALAN
    @FXML private TableView<Penjualan> tvPenjualan;
    @FXML private TableColumn<Penjualan, Integer> colPenjualanId;
    @FXML private TableColumn<Penjualan, Integer> colJumlahJual;
    @FXML private TableColumn<Penjualan, Double> colTotalHargaJual;
    @FXML private TableColumn<Penjualan, String> colTanggalJual;
    @FXML private TableColumn<Penjualan, Integer> colPelangganIdJual; 
    @FXML private TableColumn<Penjualan, Integer> colBukuIdJual;     

    @FXML private TextField txtJumlahJual;
    @FXML private TextField txtTotalHargaJual;
    @FXML private TextField txtTanggalJual;
    @FXML private TextField txtPelangganIdJual;
    @FXML private TextField txtBukuIdJual;
    @FXML private Button btnAddPenjualan;
    @FXML private Button btnEditPenjualan;
    @FXML private Button btnDeletePenjualan;

    // 3. INITIALIZE
    @SuppressWarnings("unused")
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Setup Kolom PELANGGAN
        colPelangganId.setCellValueFactory(cellData -> cellData.getValue().pelanggan_idProperty().asObject());
        colNama.setCellValueFactory(cellData -> cellData.getValue().namaProperty());
        colEmail.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        colTelepon.setCellValueFactory(cellData -> cellData.getValue().teleponProperty());
        showPelangganData();
        tvPelanggan.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showPelangganDetails(newValue));

        // Setup Kolom BUKU
        colBukuId.setCellValueFactory(cellData -> cellData.getValue().buku_idProperty().asObject());
        colJudulBuku.setCellValueFactory(cellData -> cellData.getValue().judulProperty());
        colPenulisBuku.setCellValueFactory(cellData -> cellData.getValue().penulisProperty());
        colHargaBuku.setCellValueFactory(cellData -> cellData.getValue().hargaProperty().asObject());
        colStokBuku.setCellValueFactory(cellData -> cellData.getValue().stokProperty().asObject());
        showBukuData();
        tvBuku.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showBukuDetails(newValue));

        // Setup Kolom PENJUALAN-
        colPenjualanId.setCellValueFactory(cellData -> cellData.getValue().penjualan_idProperty().asObject());
        colJumlahJual.setCellValueFactory(cellData -> cellData.getValue().jumlahProperty().asObject());
        colTotalHargaJual.setCellValueFactory(cellData -> cellData.getValue().total_hargaProperty().asObject());
        colTanggalJual.setCellValueFactory(cellData -> cellData.getValue().tanggalProperty());
        colPelangganIdJual.setCellValueFactory(cellData -> cellData.getValue().pelanggan_idProperty().asObject());
        colBukuIdJual.setCellValueFactory(cellData -> cellData.getValue().buku_idProperty().asObject());
        showPenjualanData();
        tvPenjualan.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showPenjualanDetails(newValue));
    }

    // 4. LOGIKA CRUD - PELANGGAN
    
    private void showPelangganData() {
        ObservableList<Pelanggan> list = pelangganService.getAllPelanggan(); 
        tvPelanggan.setItems(list);
    }
    
    private void showPelangganDetails(Pelanggan pelanggan) {
        if (pelanggan != null) {
            txtNamaPelanggan.setText(pelanggan.getNama());
            txtEmailPelanggan.setText(pelanggan.getEmail());
            txtTeleponPelanggan.setText(pelanggan.getTelepon());
        } else {
            txtNamaPelanggan.clear();
            txtEmailPelanggan.clear();
            txtTeleponPelanggan.clear();
        }
    }

    @FXML
    private void handleAddPelanggan() {
        String nama = txtNamaPelanggan.getText();
        String email = txtEmailPelanggan.getText();
        String telepon = txtTeleponPelanggan.getText();
        Pelanggan newPelanggan = new Pelanggan(nama, email, telepon);

        if (pelangganService.addPelanggan(newPelanggan)) { 
            showAlert("Data Pelanggan berhasil ditambahkan!", Alert.AlertType.INFORMATION);
            showPelangganData(); 
            showPelangganDetails(null);
        } else {
            showAlert("Gagal menambahkan data Pelanggan.");
        }
    }

    @FXML
    private void handleEditPelanggan() {
        Pelanggan selected = tvPelanggan.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setNama(txtNamaPelanggan.getText());
            selected.setEmail(txtEmailPelanggan.getText());
            selected.setTelepon(txtTeleponPelanggan.getText());
            
            if (pelangganService.updatePelanggan(selected)) { 
                showAlert("Data Pelanggan berhasil diperbarui!", Alert.AlertType.INFORMATION);
                showPelangganData(); 
            } else {
                showAlert("Gagal memperbarui data Pelanggan.");
            }
        } else {
            showAlert("Pilih satu baris di tabel untuk diubah.");
        }
    }
    
    @FXML
    private void handleDeletePelanggan() {
        Pelanggan selected = tvPelanggan.getSelectionModel().getSelectedItem();
        if (selected != null) {
            if (pelangganService.deletePelanggan(selected.getPelanggan_id())) { 
                showAlert("Data Pelanggan berhasil dihapus!", Alert.AlertType.INFORMATION);
                showPelangganData(); 
                showPelangganDetails(null);
            } else {
                showAlert("Gagal menghapus data Pelanggan.");
            }
        } else {
            showAlert("Pilih satu baris di tabel untuk dihapus.");
        }
    }

    // 5. LOGIKA CRUD - BUKU
    
    private void showBukuData() {
        ObservableList<Buku> list = bukuService.getAllBuku(); 
        tvBuku.setItems(list);
    }
    
    private void showBukuDetails(Buku buku) {
        if (buku != null) {
            txtJudulBuku.setText(buku.getJudul());
            txtPenulisBuku.setText(buku.getPenulis());
            txtHargaBuku.setText(String.valueOf(buku.getHarga()));
            txtStokBuku.setText(String.valueOf(buku.getStok()));
        } else {
            txtJudulBuku.clear();
            txtPenulisBuku.clear();
            txtHargaBuku.clear();
            txtStokBuku.clear();
        }
    }

    @FXML
    private void handleAddBuku() {
        try {
            String judul = txtJudulBuku.getText();
            String penulis = txtPenulisBuku.getText();
            double harga = Double.parseDouble(txtHargaBuku.getText()); 
            int stok = Integer.parseInt(txtStokBuku.getText());

            Buku newBuku = new Buku(0, judul, penulis, harga, stok);
            
            if (bukuService.addBuku(newBuku)) { 
                showAlert("Data Buku berhasil ditambahkan!", Alert.AlertType.INFORMATION);
                showBukuData(); 
                showBukuDetails(null);
            } else {
                showAlert("Gagal menambahkan data Buku.");
            }
        } catch (NumberFormatException e) {
            showAlert("Harga dan Stok harus berupa angka yang valid.");
        }
    }

    @FXML
    private void handleEditBuku() {
        Buku selected = tvBuku.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                selected.setJudul(txtJudulBuku.getText());
                selected.setPenulis(txtPenulisBuku.getText());
                selected.setHarga(Double.parseDouble(txtHargaBuku.getText()));
                selected.setStok(Integer.parseInt(txtStokBuku.getText()));
                
                if (bukuService.updateBuku(selected)) {
                    showAlert("Data Buku berhasil diperbarui!", Alert.AlertType.INFORMATION);
                    showBukuData(); 
                } else {
                    showAlert("Gagal memperbarui data Buku.");
                }
            } catch (NumberFormatException e) {
                showAlert("Harga dan Stok harus berupa angka yang valid.");
            }
        } else {
            showAlert("Pilih satu baris di tabel untuk diubah.");
        }
    }
    
    @FXML
    private void handleDeleteBuku() {
        Buku selected = tvBuku.getSelectionModel().getSelectedItem();
        if (selected != null) {
            if (bukuService.deleteBuku(selected.getbuku_id())) { 
                showAlert("Data Buku berhasil dihapus!", Alert.AlertType.INFORMATION);
                showBukuData(); 
                showBukuDetails(null);
            } else {
                showAlert("Gagal menghapus data Buku.");
            }
        } else {
            showAlert("Pilih satu baris di tabel untuk dihapus.");
        }
    }

    // 6. LOGIKA CRUD - PENJUALAN

    private void showPenjualanData() {
        ObservableList<Penjualan> list = penjualanService.getAllPenjualan(); 
        tvPenjualan.setItems(list);
    }
    
    private void showPenjualanDetails(Penjualan penjualan) {
        if (penjualan != null) {
            txtJumlahJual.setText(String.valueOf(penjualan.getJumlah()));
            txtTotalHargaJual.setText(String.valueOf(penjualan.getTotal_harga()));
            txtTanggalJual.setText(penjualan.getTanggal());
            txtPelangganIdJual.setText(String.valueOf(penjualan.getPelanggan_id()));
            txtBukuIdJual.setText(String.valueOf(penjualan.getBuku_id()));
        } else {
            txtJumlahJual.clear();
            txtTotalHargaJual.clear();
            txtTanggalJual.clear();
            txtPelangganIdJual.clear();
            txtBukuIdJual.clear();
        }
    }

    @FXML
    private void handleAddPenjualan() {
        try {
            int jumlah = Integer.parseInt(txtJumlahJual.getText());
            double totalHarga = Double.parseDouble(txtTotalHargaJual.getText());
            String tanggal = txtTanggalJual.getText(); 
            int pelangganId = Integer.parseInt(txtPelangganIdJual.getText());
            int bukuId = Integer.parseInt(txtBukuIdJual.getText());

            Penjualan newPenjualan = new Penjualan(jumlah, totalHarga, tanggal, pelangganId, bukuId);
            
            if (penjualanService.addPenjualan(newPenjualan)) { 
                showAlert("Transaksi berhasil dicatat!", Alert.AlertType.INFORMATION);
                showPenjualanData(); 
                showPenjualanDetails(null);
            } else {
                showAlert("Gagal mencatat transaksi. Cek ID Pelanggan/Buku.");
            }
        } catch (NumberFormatException e) {
            showAlert("Pastikan semua input berupa angka yang valid.");
        }
    }
    
    @FXML
    private void handleEditPenjualan() {
        Penjualan selected = tvPenjualan.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                selected.setJumlah(Integer.parseInt(txtJumlahJual.getText()));
                selected.setTotal_harga(Double.parseDouble(txtTotalHargaJual.getText()));
                selected.setTanggal(txtTanggalJual.getText());
                selected.setPelanggan_id(Integer.parseInt(txtPelangganIdJual.getText()));
                selected.setBuku_id(Integer.parseInt(txtBukuIdJual.getText()));
                
                if (penjualanService.updatePenjualan(selected)) {
                    showAlert("Data Penjualan berhasil diperbarui!", Alert.AlertType.INFORMATION);
                    showPenjualanData(); 
                } else {
                    showAlert("Gagal memperbarui data Penjualan.");
                }
            } catch (NumberFormatException e) {
                showAlert("Pastikan semua input berupa angka yang valid.");
            }
        } else {
            showAlert("Pilih satu baris di tabel untuk diubah.");
        }
    }
    
    @FXML
    private void handleDeletePenjualan() {
        Penjualan selected = tvPenjualan.getSelectionModel().getSelectedItem();
        if (selected != null) {
            if (penjualanService.deletePenjualan(selected.getPenjualan_id())) { 
                showAlert("Data Penjualan berhasil dihapus!", Alert.AlertType.INFORMATION);
                showPenjualanData(); 
                showPenjualanDetails(null);
            } else {
                showAlert("Gagal menghapus data Penjualan.");
            }
        } else {
            showAlert("Pilih satu baris di tabel untuk dihapus.");
        }
    }

    // 7. UTILITY (Alert)
    
    private void showAlert(String message) {
        showAlert(message, Alert.AlertType.ERROR);
    }
    
    private void showAlert(String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Informasi CRUD");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}