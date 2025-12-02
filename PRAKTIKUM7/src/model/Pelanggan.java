package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pelanggan {
    private IntegerProperty pelanggan_id; 
    private StringProperty nama;
    private StringProperty email;
    private StringProperty telepon;

    // Constructor
    public Pelanggan(int pelanggan_id, String nama, String email, String telepon) {
        this.pelanggan_id = new SimpleIntegerProperty(pelanggan_id);
        this.nama = new SimpleStringProperty(nama);
        this.email = new SimpleStringProperty(email);
        this.telepon = new SimpleStringProperty(telepon);
    }
    
    // Constructor untuk data baru
    public Pelanggan(String nama, String email, String telepon) {
        this.pelanggan_id = new SimpleIntegerProperty(0);
        this.nama = new SimpleStringProperty(nama);
        this.email = new SimpleStringProperty(email);
        this.telepon = new SimpleStringProperty(telepon);
    }

    // PROPERTY METHODS
    public IntegerProperty pelanggan_idProperty() { return pelanggan_id; }
    public StringProperty namaProperty() { return nama; }
    public StringProperty emailProperty() { return email; }
    public StringProperty teleponProperty() { return telepon; }

    // GETTER METHODS
    public int getPelanggan_id() { return pelanggan_id.get(); }
    public String getNama() { return nama.get(); }
    public String getEmail() { return email.get(); }
    public String getTelepon() { return telepon.get(); }
    
    // SETTER METHODS
    public void setPelanggan_id(int pelanggan_id) { this.pelanggan_id.set(pelanggan_id); }
    public void setNama(String nama) { this.nama.set(nama); }
    public void setEmail(String email) { this.email.set(email); }
    public void setTelepon(String telepon) { this.telepon.set(telepon); }
}
