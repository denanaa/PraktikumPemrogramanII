import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class BiodataTemanApp extends JFrame {

    public BiodataTemanApp() {
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

        // Button untuk submit
        JButton button = new JButton("Simpan");
        button.setBounds(150, 120, 100, 40);

        // TextArea untuk menampilkan biodata
        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(50, 180, 300, 200);
        txtOutput.setEditable(false);  // Agar tidak bisa diubah secara manual
        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setBounds(50, 180, 300, 200);

        // Action Listener untuk Button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String telepon = textFieldTelepon.getText();

                if (!nama.isEmpty() && !telepon.isEmpty()) {
                    // Menambahkan biodata ke TextArea dengan pemisah
                    txtOutput.append("Nama: " + nama + "\nNomor Telepon: " + telepon + "\n" + "=============\n");

                    // Mengosongkan input setelah submit
                    textFieldNama.setText("");
                    textFieldTelepon.setText("");
                } else {
                    // Pesan error jika input kosong
                    JOptionPane.showMessageDialog(null, "Nama dan Nomor Telepon harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Menambahkan komponen ke Frame
        this.add(button);
        this.add(textFieldNama);
        this.add(labelNama);
        this.add(textFieldTelepon);
        this.add(labelTelepon);
        this.add(scrollPane);

        this.setSize(400, 450);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BiodataTemanApp app = new BiodataTemanApp();
                app.setVisible(true);
            }
        });
    }
}
