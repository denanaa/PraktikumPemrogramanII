/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pertemuan4PP2;

import static java.awt.SystemColor.text;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author ASUS
 */
import javax.swing.*;  
import java.awt.event.*;  

public class ButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Example"); // Tidak ada "title:"
        JButton button = new JButton("Click Me"); // Tidak ada "text:"

        // Menambahkan ActionListener ke JButton
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!"); // Tidak ada "x:"
            }
        });

        button.setBounds(50, 50, 150, 30); // Tidak ada "x:", "y:", "width:", atau "height:"
        frame.add(button);
        frame.setSize(300, 200); // Tidak ada "width:" atau "height:"
        frame.setLayout(null); // Tidak ada "manager:"
        frame.setVisible(true); // Tidak ada "b:"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

