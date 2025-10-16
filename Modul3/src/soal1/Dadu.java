package soal1;

import java.util.Random;

class Dadu {
    private int nilai; 

    public Dadu() {
        acakNilai();
    }

    public void acakNilai() {
        Random random = new Random();
        nilai = random.nextInt(6) + 1; 
    }

    public int getNilai() {
        return nilai;
    }
}