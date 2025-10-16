package soal2;
import java.util.*;

public class Negara {
 private String nama;
 private String jenisKepemimpinan;
 private String namaPemimpin;
 private int tanggalKemerdekaan;
 private int bulanKemerdekaan;
 private int tahunKemerdekaan;
 private boolean monarki;

 // Constructor negara monarki
 public Negara(String nama, String jenisKepemimpinan, String namaPemimpin) {
     this.nama = nama;
     this.jenisKepemimpinan = jenisKepemimpinan;
     this.namaPemimpin = namaPemimpin;
     this.monarki = true;
 }

 // Constructor negara non-monarki
 public Negara(String nama, String jenisKepemimpinan, String namaPemimpin, 
               int tanggal, int bulan, int tahun) {
     this.nama = nama;
     this.jenisKepemimpinan = jenisKepemimpinan;
     this.namaPemimpin = namaPemimpin;
     this.tanggalKemerdekaan = tanggal;
     this.bulanKemerdekaan = bulan;
     this.tahunKemerdekaan = tahun;
     this.monarki = false;
 }

 public void tampilkanInfo(HashMap<Integer, String> bulanMap) {
     if (monarki) {
         System.out.println("Negara " + nama + " mempunyai Raja bernama " + namaPemimpin);
     } else {
         String jabatan = Character.toUpperCase(jenisKepemimpinan.charAt(0)) + 
                          jenisKepemimpinan.substring(1);
         System.out.println("Negara " + nama + " mempunyai " + jabatan + 
                            " bernama " + namaPemimpin);
         System.out.println("Deklarasi Kemerdekaan pada Tanggal " + 
                            tanggalKemerdekaan + " " + 
                            bulanMap.get(bulanKemerdekaan) + " " + 
                            tahunKemerdekaan);
     }
     System.out.println(); 
 }
}