package soal1;

import java.util.LinkedList;
import java.util.Scanner;

public class DaduMain {
public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LinkedList<Dadu> daftarDadu = new LinkedList<>();

		        System.out.println(" ");
		        int jumlah = input.nextInt();

		        int totalNilai = 0;

		        for (int i = 0; i < jumlah; i++) {
		            Dadu d = new Dadu();
		            daftarDadu.add(d);
		        }

		        for (int i = 0; i < daftarDadu.size(); i++) {
		            int nilai = daftarDadu.get(i).getNilai();
		            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + nilai);
		            totalNilai += nilai;
		        }

		        System.out.println("Total nilai dadu keseluruhan " + totalNilai);

		        input.close();
	}

}