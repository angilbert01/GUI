import java.awt.*;
import java.awt.event.*;

public class MainGUI extends Frame implements ActionListener {
    Label lblMK, lblTugas, lblKuis, lblUTS, lblUAS, lblHasil;
    TextField txtTugas, txtKuis, txtUTS, txtUAS, txtHasil;
    TextArea textArea;
    CheckboxGroup group;
    Checkbox cbPemlan, cbASD, cbMatkomlan, cbProbstat;
    Button btnHitung;

    MainGUI() {
        setTitle("Nilai Akhir Mata Kuliah");
        setLayout(null);
        setSize(500, 400);
        setLocation(200, 100);

        lblMK = new Label("Pilih Mata Kuliah:");
        lblMK.setBounds(30, 40, 120, 20);
        add(lblMK);

        group = new CheckboxGroup();
        cbPemlan = new Checkbox("Pemlan", group, false);
        cbASD = new Checkbox("ASD", group, false);
        cbMatkomlan = new Checkbox("Matkomlan", group, false);
        cbProbstat = new Checkbox("Probstat", group, false);

        cbPemlan.setBounds(150, 40, 100, 20);
        cbASD.setBounds(250, 40, 100, 20);
        cbMatkomlan.setBounds(150, 60, 100, 20);
        cbProbstat.setBounds(250, 60, 100, 20);

        add(cbPemlan); add(cbASD); add(cbMatkomlan); add(cbProbstat);

        cbPemlan.addItemListener(e -> clearFields());
        cbASD.addItemListener(e -> clearFields());
        cbMatkomlan.addItemListener(e -> clearFields());
        cbProbstat.addItemListener(e -> clearFields());

        lblTugas = new Label("Tugas:");
        lblKuis = new Label("Kuis:");
        lblUTS = new Label("UTS:");
        lblUAS = new Label("UAS:");
        lblHasil = new Label("Nilai Akhir:");

        lblTugas.setBounds(30, 100, 80, 20);
        lblKuis.setBounds(30, 130, 80, 20);
        lblUTS.setBounds(30, 160, 80, 20);
        lblUAS.setBounds(30, 190, 80, 20);
        lblHasil.setBounds(30, 220, 80, 20);

        add(lblTugas); add(lblKuis); add(lblUTS); add(lblUAS); add(lblHasil);

        txtTugas = new TextField();
        txtKuis = new TextField();
        txtUTS = new TextField();
        txtUAS = new TextField();
        txtHasil = new TextField();
        txtHasil.setEditable(false);

        txtTugas.setBounds(150, 100, 50, 20);
        txtKuis.setBounds(150, 130, 50, 20);
        txtUTS.setBounds(150, 160, 50, 20);
        txtUAS.setBounds(150, 190, 50, 20);
        txtHasil.setBounds(150, 220, 100, 20);

        add(txtTugas); add(txtKuis); add(txtUTS); add(txtUAS); add(txtHasil);

        btnHitung = new Button("Hitung");
        btnHitung.setBounds(280, 220, 100, 30);
        btnHitung.addActionListener(this);
        add(btnHitung);

        textArea = new TextArea();
        textArea.setBounds(30, 260, 430, 100);
        textArea.setEditable(false);
        add(textArea);

        setVisible(true);
    }

    void clearFields() {
        txtTugas.setText("");
        txtKuis.setText("");
        txtUTS.setText("");
        txtUAS.setText("");
        txtHasil.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int tugas = Integer.parseInt(txtTugas.getText());
            int kuis = Integer.parseInt(txtKuis.getText());
            int uts = Integer.parseInt(txtUTS.getText());
            int uas = Integer.parseInt(txtUAS.getText());

            MataKuliah mk = null;
            String namaMK = "";

            if (cbPemlan.getState()) {
                mk = new Pemlan(tugas, kuis, uts, uas);
                namaMK = "Pemlan";
            } else if (cbASD.getState()) {
                mk = new ASD(tugas, kuis, uts, uas);
                namaMK = "ASD";
            } else if (cbMatkomlan.getState()) {
                mk = new Matkomlan(tugas, kuis, uts, uas);
                namaMK = "Matkomlan";
            } else if (cbProbstat.getState()) {
                mk = new Probstat(tugas, kuis, uts, uas);
                namaMK = "Probstat";
            }

            if (mk != null) {
                double nilai = mk.hitungNilaiAkhir();
                txtHasil.setText(String.format("%.2f", nilai));
                textArea.append(namaMK + ": " + nilai + "\n");
            }

        } catch (NumberFormatException ex) {
            textArea.append("Input tidak valid!\n");
        }
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}
