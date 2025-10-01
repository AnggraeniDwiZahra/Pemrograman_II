package prak103_2410817220018_AnggraeniDwiZahra;

import java.util.Scanner;
public class PRAK103_2410817220018_AnggraeniDwiZahra {

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while (input.hasNextInt()) {
            int N = input.nextInt();
            int start = input.nextInt();

            int count = 0;
            int current = start;

            StringBuilder output = new StringBuilder();

            do {
                // Cek ganjil atau genap
                if (current % 2 != 0) {
                    output.append(current);
                    count++;

                    if (count < N) {
                        output.append(",");
                    }
                }
                current++;
            } while (count < N);

            System.out.println(output.toString());
        }

        input.close();
	}

}