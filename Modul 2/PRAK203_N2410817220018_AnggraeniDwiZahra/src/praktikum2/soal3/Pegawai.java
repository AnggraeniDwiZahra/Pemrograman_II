package praktikum2.soal3;

//Error terjadi karena nama Class berbeda dengan yang digunakan untuk instansiasi di Soal3Main.java (Pegawai).
//public class Employee { 
public class Pegawai {
	    public String nama; 
	    //public char asal;
	    // Error terjadi karena tipe data char tidak dapat menyimpan nilai string seperti "Kingdom of Orvel" di main.
	    public String asal; 
	    public String jabatan; 
	    public int umur; 
	 
	    public String getNama() { 
	        return nama; 
	    } 
	 
	 
	    // Error terjadi karena,method mengembalikan String. Namun, asal bertipe char menyebabkan incompatible types error saat return (char tidak bisa langsung dikembalikan sebagai String tanpa konversi).
	    // Perbaikan dilakukan dengan mengubah tipe asal menjadi String, sehingga return statement tetap valid tanpa perubahan lebih lanjut.
	    // public String getAsal() { 
        //return asal; 
	    //}
	    public String getAsal() { 
	        return asal; 
	    } 
	 
	    //public void setJabatan() { 
	    // Error terjadi karena method tidak menerima parameter String, padahal dipanggil dengan argumen "Assasin" di main, menyebabkan compile error (method setJabatan(String) expected).
	    public void setJabatan(String jabatan) {
	        //this.jabatan = j; 
	        // Error: Variabel 'j' tidak didefinisikan di scope method, menyebabkan compile error (cannot find symbol).
	    	this.jabatan = jabatan;
	    }
}