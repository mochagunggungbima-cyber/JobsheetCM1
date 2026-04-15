public class RuangBaca_No3 {

    Mahasiswa[] listMahasiswa;
    Buku[] listBuku;
    Peminjaman[] listPeminjaman;

    public RuangBaca_No3() {
        listMahasiswa = new Mahasiswa[]{
            new Mahasiswa("22001", "Andi",  "Teknik Informatika"),
            new Mahasiswa("22002", "Budi",  "Teknik Informatika"),
            new Mahasiswa("22003", "Citra", "Sistem Informasi Bisnis")
        };

        listBuku = new Buku[]{
            new Buku("B001", "Algoritma",    2020),
            new Buku("B002", "Basis Data",   2019),
            new Buku("B003", "Pemrograman",  2021),
            new Buku("B004", "Fisika",       2024)
        };

        listPeminjaman = new Peminjaman[]{
            new Peminjaman(listMahasiswa[0], listBuku[0], 7),
            new Peminjaman(listMahasiswa[1], listBuku[1], 3),
            new Peminjaman(listMahasiswa[2], listBuku[2], 10),
            new Peminjaman(listMahasiswa[2], listBuku[3], 6),
            new Peminjaman(listMahasiswa[0], listBuku[1], 4)
        };
    }

    public void tampilDataMahasiswaDanBuku() {
        System.out.println("\n========================================");
        System.out.println("          DATA MAHASISWA");
        System.out.println("========================================");
        System.out.printf("%-8s %-20s %-25s%n", "NIM", "Nama", "Prodi");
        System.out.println("----------------------------------------");
        for (Mahasiswa m : listMahasiswa) {
            System.out.printf("%-8s %-20s %-25s%n", m.nim, m.nama, m.prodi);
        }

        System.out.println("\n========================================");
        System.out.println("            DATA BUKU");
        System.out.println("========================================");
        System.out.printf("%-10s %-20s %-12s%n", "Kode", "Judul", "Tahun Terbit");
        System.out.println("----------------------------------------");
        for (Buku b : listBuku) {
            System.out.printf("%-10s %-20s %-12d%n", b.kodeBuku, b.judul, b.tahunTerbit);
        }
    }

    public void tampilDataPeminjaman() {
        System.out.println("\n========================================");
        System.out.println("         DATA PEMINJAMAN BUKU");
        System.out.println("========================================");
        System.out.printf("%-8s %-10s %-15s %-12s %-15s %-10s%n",
                "NIM", "Nama", "Judul Buku", "Lama Pinjam", "Keterlambatan", "Denda");
        System.out.println("------------------------------------------------------------------------");
        for (Peminjaman p : listPeminjaman) {
            System.out.printf("%-8s %-10s %-15s %-12d %-15d Rp %-8d%n",
                    p.mahasiswa.nim, p.mahasiswa.nama,
                    p.buku.judul, p.lamaPinjam,
                    p.keterlambatan, p.denda);
        }
    }

    public void tampilHitungDenda() {
        System.out.println("\n========================================");
        System.out.println("       PERHITUNGAN DENDA KETERLAMBATAN");
        System.out.println("========================================");
        int totalDenda = 0;
        for (Peminjaman p : listPeminjaman) {
            System.out.println("Nama     : " + p.mahasiswa.nama);
            System.out.println("Buku     : " + p.buku.judul);
            System.out.println("Terlambat: " + p.keterlambatan + " hari");
            System.out.println("Denda    : Rp " + p.denda);
            System.out.println("----------------------------------------");
            totalDenda += p.denda;
        }
        System.out.println("Total Denda Keseluruhan : Rp " + totalDenda);
    }

    // ─── MENU 4: Insertion Sort (tidak dimodifikasi di soal no.3) ────────────
    public void insertionSortByDenda() {
        Peminjaman[] sorted = listPeminjaman.clone();
        int n = sorted.length;

        for (int i = 1; i < n; i++) {
            Peminjaman key = sorted[i];
            int j = i - 1;
            while (j >= 0 && sorted[j].denda < key.denda) {
                sorted[j + 1] = sorted[j];
                j--;
            }
            sorted[j + 1] = key;
        }

        System.out.println("\n========================================");
        System.out.println("  DATA PEMINJAMAN DIURUTKAN BERDASARKAN");
        System.out.println("       DENDA TERBESAR (INSERTION SORT)");
        System.out.println("========================================");
        System.out.printf("%-4s %-8s %-10s %-15s %-10s%n",
                "No", "NIM", "Nama", "Judul Buku", "Denda");
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < sorted.length; i++) {
            Peminjaman p = sorted[i];
            System.out.printf("%-4d %-8s %-10s %-15s Rp %-8d%n",
                    (i + 1), p.mahasiswa.nim, p.mahasiswa.nama,
                    p.buku.judul, p.denda);
        }
    }

    // ─── MENU 5: Binary Search + tampil indeks tempat data ditemukan ─────────
    // MODIFIKASI NO.3: Ditambahkan informasi indeks posisi data di array asli
    public void binarySearchByNIM(String nimCari) {
        Peminjaman[] sorted = listPeminjaman.clone();
        int n = sorted.length;

        // Simpan indeks asli sebelum array diurutkan
        int[] indeksAsli = new int[n];
        for (int i = 0; i < n; i++) indeksAsli[i] = i;

        // Insertion Sort by NIM, sambil ikut geser indeksAsli
        for (int i = 1; i < n; i++) {
            Peminjaman key    = sorted[i];
            int        keyIdx = indeksAsli[i];
            int j = i - 1;
            while (j >= 0 && sorted[j].mahasiswa.nim.compareTo(key.mahasiswa.nim) > 0) {
                sorted[j + 1]    = sorted[j];
                indeksAsli[j + 1] = indeksAsli[j];
                j--;
            }
            sorted[j + 1]    = key;
            indeksAsli[j + 1] = keyIdx;
        }

        System.out.println("\n========================================");
        System.out.println("   PENCARIAN PEMINJAMAN BERDASARKAN NIM");
        System.out.println("         (BINARY SEARCH)");
        System.out.println("========================================");
        System.out.println("NIM yang dicari : " + nimCari);
        System.out.println("----------------------------------------");

        // Binary Search
        int left = 0, right = n - 1;
        int posisi = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = sorted[mid].mahasiswa.nim.compareTo(nimCari);
            if (cmp == 0) { posisi = mid; break; }
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }

        if (posisi != -1) {
            System.out.println(">> Data ditemukan!\n");

            // Tampilkan semua data NIM tersebut beserta indeks aslinya
            for (int i = 0; i < n; i++) {
                if (sorted[i].mahasiswa.nim.equals(nimCari)) {
                    System.out.println(">> Ditemukan pada Indeks ke-" + indeksAsli[i]
                            + " di data peminjaman asli");
                    sorted[i].tampilInformasi();
                    System.out.println("----------------------------------------");
                }
            }
        } else {
            System.out.println("Data dengan NIM " + nimCari + " tidak ditemukan.");
        }
    }
}