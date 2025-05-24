public class Pemlan extends MataKuliah {
    public Pemlan(int tugas, int kuis, int uts, int uas) {
        super(tugas, kuis, uts, uas);
    }

    public double hitungNilaiAkhir() {
        return (0.2 * tugas) + (0.2 * kuis) + (0.3 * uts) + (0.3 * uas);
    }
}
