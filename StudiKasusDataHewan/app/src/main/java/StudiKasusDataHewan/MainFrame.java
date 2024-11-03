/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudiKasusDataHewan;

/**
 *
 * @author ASUS
 */
import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Klinik Hewan - Pendataan Hewan Peliharaan");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Membuat JMenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem petFormItem = new JMenuItem("Data Hewan Peliharaan");

        petFormItem.addActionListener(e -> new PetForm().setVisible(true));
        menu.add(petFormItem);
        menuBar.add(menu);
        
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}

