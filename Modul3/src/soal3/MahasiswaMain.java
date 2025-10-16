package soal3;

import java.util.ArrayList;
import java.util.Scanner;

public class MahasiswaMain {
	public static void main(String[] args) {

		        Scanner input = new Scanner(System.in);
		        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

		        int pilihan;
		        do {
		            System.out.println("\nMenu:");
		            System.out.println("1. Tambah Mahasiswa");
		            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
		            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
		            System.out.println("4. Tampilkan Daftar Mahasiswa");
		            System.out.println("0. Keluar");
		            System.out.print("Pilihan: ");
		            pilihan = input.nextInt();
		            input.nextLine(); 

		            switch (pilihan) {
		                case 1:
		                    System.out.print("Masukkan Nama Mahasiswa: ");
		                    String nama = input.nextLine();
		                    System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
		                    String nim = input.nextLine();

		                    boolean duplikat = false;
		                    for (Mahasiswa m : daftarMahasiswa) {
		                        if (m.getNim().equals(nim)) {
		                            duplikat = true;
		                            break;
		                        }
		                    }

		                    if (duplikat) {
		                        System.out.println("NIM sudah digunakan! Gagal menambahkan mahasiswa.");
		                    } else {
		                        daftarMahasiswa.add(new Mahasiswa(nama, nim));
		                        System.out.println("Mahasiswa " + nama + " ditambahkan.");
		                    }
		                    break;

		                case 2:
		                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
		                    String nimHapus = input.nextLine();
		                    boolean ditemukan = false;

		                    for (int i = 0; i < daftarMahasiswa.size(); i++) {
		                        if (daftarMahasiswa.get(i).getNim().equals(nimHapus)) {
		                            daftarMahasiswa.remove(i);
		                            System.out.println("Mahasiswa dengan NIM " + nimHapus + " dihapus.");
		                            ditemukan = true;
		                            break;
		                        }
		                    }

		                    if (!ditemukan) {
		                        System.out.println("Mahasiswa dengan NIM " + nimHapus + " tidak ditemukan.");
		                    }
		                    break;

		                case 3:
		                    System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
		                    String nimCari = input.nextLine();
		                    boolean ketemu = false;

		                    for (Mahasiswa m : daftarMahasiswa) {
		                        if (m.getNim().equals(nimCari)) {
		                            System.out.println("Data Mahasiswa ditemukan:");
		                            System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama());
		                            ketemu = true;
		                            break;
		                        }
		                    }

		                    if (!ketemu) {
		                        System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
		                    }
		                    break;

		                case 4:
		                    if (daftarMahasiswa.isEmpty()) {
		                        System.out.println("Belum ada data mahasiswa.");
		                    } else {
		                        System.out.println("Daftar Mahasiswa:");
		                        for (Mahasiswa m : daftarMahasiswa) {
		                            System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama());
		                        }
		                    }
		                    break;

		                case 0:
		                    System.out.println("Terima kasih!");
		                    daftarMahasiswa.clear(); 
		                    break;

		                default:
		                    System.out.println("Pilihan tidak valid!");
		            }

		        } while (pilihan != 0);

		        input.close();
		    }
}