package praktikum2.soal3;

public class Soal3Main {

	public static void main(String[] args) {
		  Pegawai p1 = new Pegawai(); 
	        // p1.nama = "Roi" 
	        // Error terjadi karena statement assignment tidak diakhiri dengan titik koma (;), sehingga menampilkan hasil compile error (';' expected).
	        p1.nama = "Roi";
	        p1.asal = "Kingdom of Orvel"; 
	        p1.setJabatan("Assasin"); 
	        // Tambahan baris ini diperlukan karena umur tidak diinisialisasi (default 0), tetapi output yang diharapkan memiliki nilai 17.
	        p1.umur = 17; 
	        
	        //System.out.println("Nama Pegawai: " + p1.getNama()); 
	        //String output tidak sesuai dengan yang diminta ("Nama: Roi"), sehingga perlu dirubah dari "Nama Pegawai" menjadi "Nama" saja.
	        System.out.println("Nama: " + p1.getNama()); 
	        System.out.println("Asal: " + p1.getAsal()); 
	        System.out.println("Jabatan: " + p1.jabatan); 
	        //System.out.println("Umur: " + p1.umur);
	        // Output tidak terjadi sesuai yang diharapkan karena string output tidak sesuai dengan yang diminta ("Umur: 17 tahun"), dan umur default 0 menyebabkan keluaran salah (hanya angka tanpa "tahun").
	        System.out.println("Umur: " + p1.umur + " tahun"); 
	}

}