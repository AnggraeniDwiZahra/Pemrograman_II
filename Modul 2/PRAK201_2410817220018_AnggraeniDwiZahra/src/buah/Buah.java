package buah;

class Buah {
    String nama;
    double beratPerUnit;
    double harga;
    double totalBerat;
    public Buah(String nama, double beratPerUnit, double harga, double totalBerat) {
        this.nama = nama;
        this.beratPerUnit = beratPerUnit;
        this.harga = harga;
        this.totalBerat = totalBerat;
    }
    public void info() {
        double totalHargaSebelum = (totalBerat / beratPerUnit) * harga;
        int numGroups = (int) Math.floor(totalBerat / 4.0);
        double diskonPerBatch = harga * 0.02 * 4;  // dari 2% per 4kg 
        double totalDiskon = diskonPerBatch * numGroups;
        double hargaSetelah = totalHargaSebelum - totalDiskon;
        System.out.println("Nama Buah: " + nama + " ");
        System.out.println("Berat: " + beratPerUnit + " ");
        System.out.println("Harga: " + harga + " ");
        System.out.printf("Jumlah Beli: %.1fkg \n", totalBerat);
        System.out.printf("Harga Sebelum Diskon: Rp%.2f \n", totalHargaSebelum);
        System.out.printf("Total Diskon: Rp%.2f \n", totalDiskon);
        System.out.printf("Harga Setelah Diskon: Rp%.2f \n\n", hargaSetelah);
    }
}