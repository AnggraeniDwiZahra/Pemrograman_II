package model;

import javafx.beans.property.*;

public class Penjualan {

 private IntegerProperty penjualan_id;
 private IntegerProperty jumlah;
 private DoubleProperty total_harga;
 private StringProperty tanggal; 
 private IntegerProperty pelanggan_id; // Foreign Key ke Pelanggan
 private IntegerProperty buku_id;      // Foreign Key ke Buku

 // Constructor (mengambil data dari DB)
 public Penjualan(int penjualan_id, int jumlah, double total_harga, String tanggal, int pelanggan_id, int buku_id) {
     this.penjualan_id = new SimpleIntegerProperty(penjualan_id);
     this.jumlah = new SimpleIntegerProperty(jumlah);
     this.total_harga = new SimpleDoubleProperty(total_harga);
     this.tanggal = new SimpleStringProperty(tanggal);
     this.pelanggan_id = new SimpleIntegerProperty(pelanggan_id);
     this.buku_id = new SimpleIntegerProperty(buku_id);
 }
 
 // Constructor untuk data baru
 public Penjualan(int jumlah, double total_harga, String tanggal, int pelanggan_id, int buku_id) {
     this.penjualan_id = new SimpleIntegerProperty(0); 
     this.jumlah = new SimpleIntegerProperty(jumlah);
     this.total_harga = new SimpleDoubleProperty(total_harga);
     this.tanggal = new SimpleStringProperty(tanggal);
     this.pelanggan_id = new SimpleIntegerProperty(pelanggan_id);
     this.buku_id = new SimpleIntegerProperty(buku_id);
 }
 
 // PROPERTY METHODS
 public IntegerProperty penjualan_idProperty() { return penjualan_id; }
 public IntegerProperty jumlahProperty() { return jumlah; }
 public DoubleProperty total_hargaProperty() { return total_harga; }
 public StringProperty tanggalProperty() { return tanggal; }
 public IntegerProperty pelanggan_idProperty() { return pelanggan_id; }
 public IntegerProperty buku_idProperty() { return buku_id; }
 
 // GETTER METHODS
 public int getPenjualan_id() { return penjualan_id.get(); }
 public int getJumlah() { return jumlah.get(); }
 public double getTotal_harga() { return total_harga.get(); }
 public String getTanggal() { return tanggal.get(); }
 public int getPelanggan_id() { return pelanggan_id.get(); }
 public int getBuku_id() { return buku_id.get(); }
 
 // SETTER METHODS
 public void setPenjualan_id(int penjualan_id) { this.penjualan_id.set(penjualan_id); }
 public void setJumlah(int jumlah) { this.jumlah.set(jumlah); }
 public void setTotal_harga(double total_harga) { this.total_harga.set(total_harga); }
 public void setTanggal(String tanggal) { this.tanggal.set(tanggal); }
 public void setPelanggan_id(int pelanggan_id) { this.pelanggan_id.set(pelanggan_id); }
 public void setBuku_id(int buku_id) { this.buku_id.set(buku_id); }
}