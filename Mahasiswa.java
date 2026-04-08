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
}