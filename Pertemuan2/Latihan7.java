import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Latihan7 extends JFrame {

    public Latihan7() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label untuk Nama
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(50, 40, 100, 20);

        // TextField untuk input Nama
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(150, 40, 150, 30);

        // Label untuk Nomor Telepon
        JLabel labelTelepon = new JLabel("Nomor Telepon:");
        labelTelepon.setBounds(50, 80, 100, 20);

        // TextField untuk input Nomor Telepon
        JTextField textFieldTelepon = new JTextField();
        textFieldTelepon.setBounds(150, 80, 150, 30);

        // Label untuk Jenis Kelamin
        JLabel labelGender = new JLabel("Jenis Kelamin:");
        labelGender.setBounds(50, 120, 100, 20);

        // RadioButton untuk Jenis Kelamin
        JRadioButton maleRadioButton = new JRadioButton("Laki-laki");
        maleRadioButton.setBounds(150, 120, 100, 20);
        JRadioButton femaleRadioButton = new JRadioButton("Perempuan");
        femaleRadioButton.setBounds(250, 120, 100, 20);

        // Mengelompokkan radio buttons agar hanya satu yang bisa dipilih
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        // CheckBox untuk Warga Negara Asing
        JCheckBox foreignCheckbox = new JCheckBox("Warga Negara Asing");
        foreignCheckbox.setBounds(150, 160, 200, 20);

        // Button untuk submit
        JButton button = new JButton("Simpan");
        button.setBounds(150, 200, 100, 40);

        // TextArea untuk menampilkan biodata
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(50, 260, 300, 200);
        txtOutput.setEditable(false);  // Agar tidak bisa diubah secara manual
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setBounds(50, 260, 300, 200);

        // Action Listener untuk Button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String telepon = textFieldTelepon.getText();
                String jenisKelamin = maleRadioButton.isSelected() ? "Laki-laki" : femaleRadioButton.isSelected() ? "Perempuan" : "";
                String wargaAsing = foreignCheckbox.isSelected() ? "Ya" : "Tidak";

                if (!nama.isEmpty() && !telepon.isEmpty() && !jenisKelamin.isEmpty()) {
                    // Menambahkan biodata ke TextArea dengan pemisah
                    txtOutput.append("Nama: " + nama + "\nNomor Telepon: " + telepon + "\nJenis Kelamin: " + jenisKelamin + "\nWarga Negara Asing: " + wargaAsing + "\n=============\n");

                    // Mengosongkan input setelah submit
                    textFieldNama.setText("");
                    textFieldTelepon.setText("");
                    genderGroup.clearSelection();  // Mengosongkan pilihan jenis kelamin
                    foreignCheckbox.setSelected(false);  // Uncheck warga negara asing
                } else {
                    // Pesan error jika input kosong
                    JOptionPane.showMessageDialog(null, "Nama, Nomor Telepon, dan Jenis Kelamin harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Menambahkan komponen ke Frame
        this.add(button);
        this.add(textFieldNama);
        this.add(labelNama);
        this.add(textFieldTelepon);
        this.add(labelTelepon);
        this.add(labelGender);
        this.add(maleRadioButton);
        this.add(femaleRadioButton);
        this.add(foreignCheckbox);
        this.add(scrollPane);

        this.setSize(400, 550);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Latihan7 app = new Latihan7();
                app.setVisible(true);
            }
        });
    }
}
