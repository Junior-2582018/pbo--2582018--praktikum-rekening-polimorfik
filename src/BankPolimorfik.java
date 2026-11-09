public class BankPolimorfik {

    public static void main(String[] args) {

        // Membuat object rekening
        Tabungan ani = new Tabungan(
                "101", "Ani", 1000000, 2.5
        );

        Tabungan citra = new Tabungan(
                "102", "Citra", 300000, 2.0
        );

        Giro budi = new Giro(
                "201", "Budi", 200000, 500000
        );

        // Percobaan abstract class
        // Rekening r = new Rekening("999", "Eko", 0);
        // Error: Rekening is abstract; cannot be instantiated.

        // Array semua rekening
        Rekening[] semua = {ani, citra, budi};

        // Array rekening berbunga
        BerBunga[] berbunga = {ani, citra};

        System.out.println("========== REKENING AWAL ==========");

        for (Rekening r : semua) {
            r.cetakInfo();
        }

        System.out.println();
        System.out.println("========== AKHIR BULAN ============");

        // Potong biaya admin semua rekening
        for (Rekening r : semua) {
            int biaya = r.potongBiayaAdmin();

            System.out.printf(
                    "%s biaya admin  : %s%n",
                    r.getNomor(),
                    r.formatRupiah(biaya)
            );
        }

        // Tambahkan bunga rekening berbunga
        for (BerBunga b : berbunga) {
            int bunga = b.tambahBunga();

            System.out.printf(
                    "%s bunga        : %s%n",
                    b.getNomor(),
                    "Rp" + String.format("%,d", bunga)
                            .replace(',', '.')
            );
        }

        System.out.println();
        System.out.println("========== REKENING AKHIR =========");

        int total = 0;

        for (Rekening r : semua) {
            r.cetakInfo();
            total += r.getSaldo();
        }

        System.out.println("-----------------------------------");

        System.out.printf(
                "Total dana bank : Rp%s%n",
                String.format("%,d", total)
                        .replace(',', '.')
        );
    }
}
