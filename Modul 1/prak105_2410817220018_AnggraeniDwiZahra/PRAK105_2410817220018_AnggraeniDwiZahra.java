package prak105_2410817220018_AnggraeniDwiZahra;

import java.util.Scanner;
import java.util.Locale;

public class PRAK105_2410817220018_AnggraeniDwiZahra {
    public static final double PHI = 3.14;

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 sc.useLocale(Locale.US); 
		 
			 System.out.println("Masukkan jari-jari: ");
	            double jariJari = sc.nextDouble();

	            System.out.println("Masukkan tinggi: ");
	            double tinggi = sc.nextDouble();

	            double volume = PHI * jariJari * jariJari * tinggi;

	            System.out.printf(Locale.US,
	                "\nVolume tabung dengan jari-jari %.1f cm dan\ntinggi %.1f cm adalah %.3f m3\n\n",
	                jariJari, tinggi, volume);
		sc.close();
	}
}