   public abstract class MataKuliah {
    protected int tugas, kuis, uts, uas;

    public MataKuliah(int tugas, int kuis, int uts, int uas) {
        this.tugas = tugas;
        this.kuis = kuis;
        this.uts = uts;
        this.uas = uas;
    }

    public abstract double hitungNilaiAkhir();
}
