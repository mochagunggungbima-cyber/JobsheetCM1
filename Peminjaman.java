public class Peminjaman {
    Mahasiswa mahasiswa;
    Buku buku;
    int lamaPinjam;
    int keterlambatan;
    int denda;

    int BATAS_PINJAM = 5;
    int DENDA_PER_HARI = 2000;

    public Peminjaman() {}

    public Peminjaman(Mahasiswa mahasiswa, Buku buku, int lamaPinjam) {
        this.mahasiswa  = mahasiswa;
        this.buku       = buku;
        this.lamaPinjam = lamaPinjam;
        hitungDenda();
    }

    public void hitungDenda() {
        if (lamaPinjam > BATAS_PINJAM) {
            keterlambatan = lamaPinjam - BATAS_PINJAM;
            denda = keterlambatan * DENDA_PER_HARI;
        } else {
            keterlambatan = 0;
            denda = 0;
        }
    }

    public void tampilInformasi() {
        System.out.println("NIM             : " + mahasiswa.nim);
        System.out.println("Nama            : " + mahasiswa.nama);
        System.out.println("Judul Buku      : " + buku.judul);
        System.out.println("Lama Pinjam     : " + lamaPinjam + " hari");
        System.out.println("Keterlambatan   : " + keterlambatan + " hari");
        System.out.println("Denda           : Rp " + denda);
    }
}