import java.util.Scanner;

public class Mahasiswa {
    String nim;
    String nama;
    String prodi;

    public Mahasiswa() {}

    public Mahasiswa(String nim, String nama, String prodi) {
        this.nim   = nim;
        this.nama  = nama;
        this.prodi = prodi;
    }

    public void tampilInformasi() {
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("Prodi : " + prodi);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = Integer.parseInt(scanner.nextLine());

        Mahasiswa[] daftar = new Mahasiswa[jumlah];

        // Input data mahasiswa dari pengguna
        for (int i = 0; i < jumlah; i++) {
            System.out.println("\n--- Data Mahasiswa ke-" + (i + 1) + " ---");

            System.out.print("NIM   : ");
            String nim = scanner.nextLine();

            System.out.print("Nama  : ");
            String nama = scanner.nextLine();

            System.out.print("Prodi : ");
            String prodi = scanner.nextLine();

            daftar[i] = new Mahasiswa(nim, nama, prodi);
        }

        // Tampilkan semua data
        System.out.println("\n===== DAFTAR MAHASISWA =====");
        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nMahasiswa ke-" + (i + 1) + ":");
            daftar[i].tampilInformasi();
        }

        scanner.close();
    }
}