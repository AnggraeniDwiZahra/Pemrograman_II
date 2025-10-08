package buah;

public class Soal1Main {

	public static void main(String[] args) {
		
        Buah apel = new Buah("Apel", 0.4, 7000.0, 40.0);
        apel.info();
        
        Buah mangga = new Buah("mangga", 0.2, 3500.0, 15.0);
        mangga.info();
        
        Buah alpukat = new Buah("alpukat", 0.25, 10000.0, 12.0);
        alpukat.info();
	}

}