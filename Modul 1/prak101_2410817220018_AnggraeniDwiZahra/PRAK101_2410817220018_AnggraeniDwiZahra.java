package prak101_2410817220018_AnggraeniDwiZahra;
import java.util.Scanner;

public class PRAK101_2410817220018_AnggraeniDwiZahra {

	public static void main(String[] args) {
	    Scanner myObj = new Scanner(System.in);  
	    System.out.println("Masukkan Nama Lengkap: ");
	    String userName = myObj.nextLine(); 
	    
	    System.out.println("Masukkan Tempat Lahir: ");
	    String place = myObj.nextLine(); 
	    
	    System.out.println("Masukkan Tanggal Lahir: ");
	    int date = myObj.nextInt(); 
	    
	    System.out.println("Masukkan Bulan Lahir: ");
	    int month = myObj.nextInt(); 
	    
	    System.out.println("Masukkan Tahun Lahir: ");
	    int year = myObj.nextInt(); 
	    
	    System.out.println("Masukkan Tinggi Badan: ");
	    int height = myObj.nextInt(); 
	    myObj.nextLine();
	    
	    System.out.println("Masukkan Berat Badan: ");
	    String weight = myObj.nextLine();

	    String[] namaBulan = {
	            "", 
	            "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"
	        };
	        String bulanText = (month >= 1 && month <= 12) ? namaBulan[month] : "Bulan Tidak Valid";
	        
	    System.out.println();
	    System.out.println("Nama Lengkap " + userName + "," + " Lahir di " + place + " Pada Tanggal " + date + " " + bulanText + " " + year);
	    System.out.println("Tinggi badan " + height + " cm dan Berat badan " + weight + " kilogram");
	    

	    myObj.close();
	}
}