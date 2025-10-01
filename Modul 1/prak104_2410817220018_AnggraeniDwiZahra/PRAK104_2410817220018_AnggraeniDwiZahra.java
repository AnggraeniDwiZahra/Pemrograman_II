package prak104_2410817220018_AnggraeniDwiZahra;

import java.util.Scanner;
public class PRAK104_2410817220018_AnggraeniDwiZahra {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

		 	System.out.println("Tangan Abu: ");
	        String[] abu = sc.nextLine().split(" ");
	        System.out.println("Tangan Bagas: ");
	        String[] bagas = sc.nextLine().split(" ");

	        int abuScore = 0;
	        int bagasScore = 0;

	        int i = 0;
	        while (i < 3) {
	        	char a = abu[i].charAt(0);
	            char b = bagas[i].charAt(0);
	            
	            if (a != b) {
	            	if ((a == 'B' && b == 'G') || 
	            	   	(a == 'G' && b == 'K') ||
	            	   	(a == 'K' && b == 'B')) {
	            	   abuScore++;
	            	} else {
	            	bagasScore++;
	            	}
	            }
	        
	            i++;
	        }
	        
	       
	        if (abuScore > bagasScore) {
	            System.out.println("Abu");
	        } else if (bagasScore > abuScore) {
	            System.out.println("Bagas");
	        } else {
	            System.out.println("Seri");
	        }

	        sc.close();
	    }
	}