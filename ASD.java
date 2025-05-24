public class ASD extends MataKuliah {
    public ASD(int tugas, int kuis, int uts, int uas) {
        super(tugas, kuis, uts, uas);
    }

    public double hitungNilaiAkhir() {
        return (0.25 * tugas) + (0.25 * kuis) + (0.25 * uts) + (0.25 * uas);
    }
}
