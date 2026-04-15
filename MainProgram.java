import java.util.Scanner;

public class MainProgram_No3 {
    public static void main(String[] args) {
        RuangBaca_No3 sistem = new RuangBaca_No3();
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n========================================");
            System.out.println("   SISTEM PEMINJAMAN BUKU RUANG BACA JTI");
            System.out.println("========================================");
            System.out.println("1. Tampil Data Mahasiswa dan Buku");
            System.out.println("2. Tampil Data Peminjaman");
            System.out.println("3. Hitung Keterlambatan dan Denda");
            System.out.println("4. Urutkan Data Berdasarkan Denda Terbesar");
            System.out.println("5. Cari Peminjaman Berdasarkan NIM (+Indeks)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1: sistem.tampilDataMahasiswaDanBuku(); break;
                case 2: sistem.tampilDataPeminjaman(); break;
                case 3: sistem.tampilHitungDenda(); break;
                case 4: sistem.insertionSortByDenda(); break;
                case 5:
                    System.out.print("Masukkan NIM yang dicari : ");
                    String nim = sc.next();
                    sistem.binarySearchByNIM(nim);
                    break;
                case 0: System.out.println("Terima kasih. Program selesai."); break;
                default: System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);

        sc.close();
    }
}