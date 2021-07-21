package md.tekwill.main;

import md.tekwill.domain.Department;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartmentPanel {

    public static JPanel makeDepartmentPanel() {

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        DefaultTableModel model = new DefaultTableModel(SwingMain.dsi.getAll(), new String[]{"ID", "Name"});
        JTable table = new JTable(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.setRowHeight(25);

        JButton departmentCreate = new JButton("Create New Department");
        departmentCreate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                departmentCreate.setEnabled(false);

                JDialog dialog = new JDialog(SwingMain.jfrm, "New Department");
                dialog.setResizable(false);

                JPanel panel = new JPanel();
                panel.setLayout(new FlowLayout());

                JLabel nameLabel = new JLabel("Enter the name of the new department : ");
                nameLabel.setPreferredSize(new Dimension(250, 25));

                JLabel errorLabel = new JLabel();
                errorLabel.setPreferredSize(new Dimension(250, 25));

                JTextField nameField = new JTextField();
                nameField.setPreferredSize(new Dimension(250, 25));

                JButton cancel = new JButton("Cancel");
                cancel.setPreferredSize(new Dimension(100, 25));
                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        departmentCreate.setEnabled(true);
                        dialog.setVisible(false);
                    }
                });

                JButton submit = new JButton("Submit");
                submit.setPreferredSize(new Dimension(100, 25));
                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String dpt = nameField.getText();
                        Department newdpt = new Department(dpt);
                        String[] result = SwingMain.dsi.create(newdpt);
                        errorLabel.setText(result[1]);
                        model.setDataVector(SwingMain.dsi.getAll(), new String[]{"ID", "Name"});
                        model.fireTableDataChanged();
                    }
                });

                panel.add(nameLabel);
                panel.add(nameField);
                panel.add(cancel);
                panel.add(submit);
                panel.add(errorLabel);

                dialog.add(panel);
                dialog.setSize(300, 300);
                dialog.setVisible(true);
            }
        });

        panel.add(table);
        panel.add(departmentCreate);

        return panel;
    }
}