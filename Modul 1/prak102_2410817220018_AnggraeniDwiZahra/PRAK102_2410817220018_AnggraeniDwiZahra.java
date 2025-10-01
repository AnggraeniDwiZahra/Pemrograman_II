package prak102_2410817220018_AnggraeniDwiZahra;

import java.util.Scanner;
public class PRAK102_2410817220018_AnggraeniDwiZahra {

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
	while (input.hasNextInt()) {
		int start = input.nextInt(); 

        int count = 0;
        int current = start;

        while (count < 11) {
            int output;
            if (current % 5 == 0) {
                output = (current / 5) - 1;
            } else {
                output = current;
            }

            System.out.print(output);

            if (count < 10) {
                System.out.print(",");
            }

            current++;
            count++;
        }

        System.out.println(); 
    }

    input.close();
	}
}