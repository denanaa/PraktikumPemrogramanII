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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class PetForm extends JFrame {
    private JTextField petNameField;
    private JTextArea addressArea;
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private ButtonGroup genderGroup;
    private JComboBox<String> petTypeBox;
    private JCheckBox vaccinatedCheckBox;
    private JList<String> breedList;
    private JSlider ageSlider;
    private JSpinner weightSpinner;
    private JTable table;
    private DefaultTableModel tableModel;

    public PetForm() {
        setTitle("Form Data Hewan Peliharaan");
        setSize(1000, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints formGbc = new GridBagConstraints();
        formGbc.insets = new Insets(5, 5, 5, 5);
        formGbc.anchor = GridBagConstraints.WEST;
        formGbc.fill = GridBagConstraints.HORIZONTAL;

        // Name Field
        formGbc.gridx = 0;
        formGbc.gridy = 0;
        formPanel.add(new JLabel("Nama Hewan:"), formGbc);
        petNameField = new JTextField(20);
        formGbc.gridx = 1;
        formPanel.add(petNameField, formGbc);

        // Address Area
        formGbc.gridx = 0;
        formGbc.gridy = 1;
        formPanel.add(new JLabel("Deskripsi:"), formGbc);
        addressArea = new JTextArea(3, 20);
        formGbc.gridx = 1;
        formPanel.add(new JScrollPane(addressArea), formGbc);

        // Gender Radio Buttons
        formGbc.gridx = 0;
        formGbc.gridy = 2;
        formPanel.add(new JLabel("Jenis Kelamin:"), formGbc);
        maleRadio = new JRadioButton("Jantan");
        femaleRadio = new JRadioButton("Betina");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        formGbc.gridx = 1;
        formPanel.add(genderPanel, formGbc);

        // Pet Type ComboBox
        formGbc.gridx = 0;
        formGbc.gridy = 3;
        formPanel.add(new JLabel("Jenis Hewan:"), formGbc);
        String[] petTypes = {"Anjing", "Kucing", "Burung", "Ikan"};
        petTypeBox = new JComboBox<>(petTypes);
        formGbc.gridx = 1;
        formPanel.add(petTypeBox, formGbc);

        // Vaccinated Checkbox
        formGbc.gridx = 0;
        formGbc.gridy = 4;
        formPanel.add(new JLabel("Vaksinasi:"), formGbc);
        vaccinatedCheckBox = new JCheckBox("Sudah Vaksin");
        formGbc.gridx = 1;
        formPanel.add(vaccinatedCheckBox, formGbc);

        // Breed List
        formGbc.gridx = 0;
        formGbc.gridy = 5;
        formPanel.add(new JLabel("Ras:"), formGbc);
        String[] breeds = {"Bulldog", "Persia", "Siam", "Golden Retriever"};
        breedList = new JList<>(breeds);
        breedList.setVisibleRowCount(3);
        formGbc.gridx = 1;
        formPanel.add(new JScrollPane(breedList), formGbc);

        // Age Slider
        formGbc.gridx = 0;
        formGbc.gridy = 6;
        formPanel.add(new JLabel("Usia (Tahun):"), formGbc);
        ageSlider = new JSlider(0, 20, 1);
        ageSlider.setMajorTickSpacing(5);
        ageSlider.setPaintTicks(true);
        ageSlider.setPaintLabels(true);
        formGbc.gridx = 1;
        formPanel.add(ageSlider, formGbc);

        // Weight Spinner
        formGbc.gridx = 0;
        formGbc.gridy = 7;
        formPanel.add(new JLabel("Berat (Kg):"), formGbc);
        weightSpinner = new JSpinner(new SpinnerNumberModel(1, 0, 100, 1));
        formGbc.gridx = 1;
        formPanel.add(weightSpinner, formGbc);

        // Table Section
        tableModel = new DefaultTableModel(new String[]{"Nama", "Deskripsi", "Jenis Kelamin", "Jenis Hewan", "Vaksinasi", "Ras", "Usia", "Berat"}, 0);
        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(1250, 350));
        JScrollPane tableScrollPane = new JScrollPane(table);

        // Button Panel for CRUD
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Tambah");
        addButton.addActionListener(this::addPetData);
        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(this::updatePetData);
        JButton deleteButton = new JButton("Hapus");
        deleteButton.addActionListener(this::deletePetData);

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Adding components to main frame using GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weighty = 0.5;
        add(formPanel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(tableScrollPane, gbc);

        gbc.gridy = 2;
        gbc.weighty = 0.2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(buttonPanel, gbc);

        // Add ListSelectionListener to populate form when a row is selected
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                    populateFormFromTable(table.getSelectedRow());
                }
            }
        });
    }

    private void populateFormFromTable(int row) {
        petNameField.setText(tableModel.getValueAt(row, 0).toString());
        addressArea.setText(tableModel.getValueAt(row, 1).toString());
        String gender = tableModel.getValueAt(row, 2).toString();
        if (gender.equals("Jantan")) {
            maleRadio.setSelected(true);
        } else {
            femaleRadio.setSelected(true);
        }
        petTypeBox.setSelectedItem(tableModel.getValueAt(row, 3).toString());
        vaccinatedCheckBox.setSelected(tableModel.getValueAt(row, 4).toString().equals("Sudah Vaksin"));
        breedList.setSelectedValue(tableModel.getValueAt(row, 5).toString(), true);
        ageSlider.setValue(Integer.parseInt(tableModel.getValueAt(row, 6).toString()));
        weightSpinner.setValue(Integer.parseInt(tableModel.getValueAt(row, 7).toString()));
    }

    private void addPetData(ActionEvent e) {
        String name = petNameField.getText();
        String address = addressArea.getText();
        String gender = maleRadio.isSelected() ? "Jantan" : "Betina";
        String petType = (String) petTypeBox.getSelectedItem();
        String vaccinated = vaccinatedCheckBox.isSelected() ? "Sudah Vaksin" : "Belum Vaksin";
        String breed = breedList.getSelectedValue();
        int age = ageSlider.getValue();
        int weight = (int) weightSpinner.getValue();

        Vector<String> rowData = new Vector<>();
        rowData.add(name);
        rowData.add(address);
        rowData.add(gender);
        rowData.add(petType);
        rowData.add(vaccinated);
        rowData.add(breed);
        rowData.add(String.valueOf(age));
        rowData.add(String.valueOf(weight));

        tableModel.addRow(rowData);
        clearForm();
    }

    private void updatePetData(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.setValueAt(petNameField.getText(), selectedRow, 0);
            tableModel.setValueAt(addressArea.getText(), selectedRow, 1);
            tableModel.setValueAt(maleRadio.isSelected() ? "Jantan" : "Betina", selectedRow, 2);
            tableModel.setValueAt(petTypeBox.getSelectedItem(), selectedRow, 3);
            tableModel.setValueAt(vaccinatedCheckBox.isSelected() ? "Sudah Vaksin" : "Belum Vaksin", selectedRow, 4);
            tableModel.setValueAt(breedList.getSelectedValue(), selectedRow, 5);
            tableModel.setValueAt(ageSlider.getValue(), selectedRow, 6);
            tableModel.setValueAt(weightSpinner.getValue(), selectedRow, 7);
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris untuk diupdate.");
        }
    }

    private void deletePetData(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
            clearForm();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih baris untuk dihapus.");
        }
    }

    private void clearForm() {
        petNameField.setText("");
        addressArea.setText("");
        genderGroup.clearSelection();
        petTypeBox.setSelectedIndex(0);
        vaccinatedCheckBox.setSelected(false);
        breedList.clearSelection();
        ageSlider.setValue(1);
        weightSpinner.setValue(1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PetForm().setVisible(true));
    }
}
