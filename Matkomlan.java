public class Matkomlan extends MataKuliah {
    public Matkomlan(int tugas, int kuis, int uts, int uas) {
        super(tugas, kuis, uts, uas);
    }

    public double hitungNilaiAkhir() {
        return (0.1 * tugas) + (0.2 * kuis) + (0.3 * uts) + (0.4 * uas);
    }
}
