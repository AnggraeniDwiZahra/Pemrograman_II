package soal2;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Negaramain {
	 public static void main(String[] args) {
	     Scanner input = new Scanner(System.in);

	     HashMap<Integer, String> bulanMap = new HashMap<>();
	     bulanMap.put(1, "Januari");
	     bulanMap.put(2, "Februari");
	     bulanMap.put(3, "Maret");
	     bulanMap.put(4, "April");
	     bulanMap.put(5, "Mei");
	     bulanMap.put(6, "Juni");
	     bulanMap.put(7, "Juli");
	     bulanMap.put(8, "Agustus");
	     bulanMap.put(9, "September");
	     bulanMap.put(10, "Oktober");
	     bulanMap.put(11, "November");
	     bulanMap.put(12, "Desember");

	     LinkedList<Negara> daftarNegara = new LinkedList<>();

	     System.out.println("");
	     int jumlah = Integer.parseInt(input.nextLine());

	     for (int i = 0; i < jumlah; i++) {
	         String nama = input.nextLine();
	         String jenis = input.nextLine();
	         String pemimpin = input.nextLine();

	         if (jenis.equalsIgnoreCase("monarki")) {
	             Negara n = new Negara(nama, jenis, pemimpin);
	             daftarNegara.add(n);
	         } else {
	             int tanggal = Integer.parseInt(input.nextLine());
	             int bulan = Integer.parseInt(input.nextLine());
	             int tahun = Integer.parseInt(input.nextLine());
	             Negara n = new Negara(nama, jenis, pemimpin, tanggal, bulan, tahun);
	             daftarNegara.add(n);
	         }
	     }

	     System.out.println();

	     for (Negara n : daftarNegara) {
	         n.tampilkanInfo(bulanMap);
	     }

	     input.close();
	 }
	}