package ru.vsu.cs.p_p_v.GUI;

import ru.vsu.cs.p_p_v.*;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormMain extends JFrame {
    private JTable tableInput;
    private JTable tableOutput;
    private JButton buttonLoad;
    private JButton buttonSave;
    private JButton buttonProcess;
    private JPanel panelMain;
    private JButton buttonIncreaseSize;
    private JButton buttonDecreaseSize;

    public FormMain() {
        this.setTitle("Arithmetic progression creator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelMain);
        this.setSize(430, 300);

        buttonIncreaseSize.setMargin(new Insets(0, 0, 0, 0));
        buttonDecreaseSize.setMargin(new Insets(0, 0, 0, 0));

        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(1);
        model.setColumnCount(2);
        tableInput.setModel(model);

        buttonLoad.addActionListener(e -> buttonLoadPressed());
        buttonProcess.addActionListener(e -> buttonProcessPressed());
        buttonSave.addActionListener(e -> buttonSavePressed());
        buttonIncreaseSize.addActionListener(e -> buttonIncreaseSizePressed());
        buttonDecreaseSize.addActionListener(e -> buttonDecreaseSizePressed());
    }

    private void buttonLoadPressed() {
        try {
            JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
            int returnVal = fc.showOpenDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                List<Integer> data = ListFile.listRead(file.getPath());

                DefaultTableModel model = new DefaultTableModel();
                model.setColumnCount(data.size());
                model.insertRow(0, data.toArray(new Integer[0]));

                tableInput.setModel(model);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void buttonProcessPressed() {
        try {
            List<Integer> tableData = getTableData(tableInput);
            ArithmeticProgression.makeProgression(tableData);

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnCount(tableData.size());
            model.insertRow(0, tableData.toArray(new Integer[0]));

            tableOutput.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void buttonSavePressed() {
        try {
            JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
            int returnVal = fc.showSaveDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                List<Integer> data = getTableData(tableOutput);
                ListFile.listWrite(file.getPath(), data);
                JOptionPane.showMessageDialog(null, "Saved!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void buttonIncreaseSizePressed() {
        try {
            DefaultTableModel model = (DefaultTableModel) tableInput.getModel();
            model.addColumn((Object[]) null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void buttonDecreaseSizePressed() {
        try {
            DefaultTableModel model = (DefaultTableModel) tableInput.getModel();

            if (model.getColumnCount() > 1) {
                model.setColumnCount(model.getColumnCount() - 1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public List<Integer> getTableData(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int colNum = dtm.getColumnCount();

        List<Integer> tableData = new ArrayList<>();

        for (int i = 0; i < colNum; i++)
            tableData.add((Integer.parseInt(dtm.getValueAt(0, i).toString())));

        return tableData;
    }
}
