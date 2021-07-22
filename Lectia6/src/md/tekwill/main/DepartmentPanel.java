package md.tekwill.main;

import md.tekwill.domain.Department;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import static md.tekwill.main.SwingMain.*;

public class DepartmentPanel {

    static JPanel panel = new JPanel();
    static Box box1 = new Box(BoxLayout.X_AXIS);
    static DefaultTableModel model = new DefaultTableModel(SwingMain.dsi.getAll(), new String[]{"ID", "Name"});
    static JTable table = new JTable(model);
    static MouseAdapter tableListener = rowClickAL();
    static Box box2 = new Box(BoxLayout.X_AXIS);
    static JButton departmentCreate = new JButton("Create New Department");

    public static JPanel makeDepartmentPanel() {

        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        box1.setPreferredSize(new Dimension(400, 300));

        table.addMouseListener(tableListener);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(table);
        box1.add(scrollPane);

        box2.setPreferredSize(new Dimension(400, 100));

        dptCreateAddAL();
        box2.add(departmentCreate);

        panel.add(box1);
        panel.add(box2);

        return panel;
    }

    private static void lockDepartmentWindow() {
        tabbedPane.setEnabled(false);
        table.removeMouseListener(tableListener);
        departmentCreate.setEnabled(false);
    }

    private static void unlockDepartmentWindow() {
        tabbedPane.setEnabled(true);
        table.addMouseListener(tableListener);
        departmentCreate.setEnabled(true);
    }

    private static void dptCreateAddAL() {
        departmentCreate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                lockDepartmentWindow();

                JDialog dialog = new JDialog(jfrm, "New Department");
                dialog.setSize(new Dimension(300, 300));
                dialog.setResizable(false);

                dialog.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        unlockDepartmentWindow();
                    }
                });

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
                        unlockDepartmentWindow();
                        dialog.dispose();
                    }
                });

                JButton submit = new JButton("Submit");
                submit.setPreferredSize(new Dimension(100, 25));
                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String dpt = nameField.getText();
                        Department newdpt = new Department(dpt);
                        String[] result = dsi.create(newdpt);
                        errorLabel.setText(result[1]);

                        if (Boolean.parseBoolean(result[0])) {
                            model.setDataVector(dsi.getAll(), new String[]{"ID", "Name"});
                        }
                    }
                });

                panel.add(nameLabel);
                panel.add(nameField);
                panel.add(cancel);
                panel.add(submit);
                panel.add(errorLabel);

                dialog.add(panel);
                dialog.setVisible(true);
            }
        });
    }

    private static MouseAdapter rowClickAL() {

        MouseAdapter tmp = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() == 2) {

                    lockDepartmentWindow();

                    JDialog dialog = new JDialog(jfrm, "Update or Delete");
                    dialog.setSize(new Dimension(300, 300));
                    dialog.setResizable(false);

                    JPanel panel = new JPanel();
                    panel.setLayout(new FlowLayout());

                    JLabel errorLabel = new JLabel();
                    errorLabel.setPreferredSize(new Dimension(250, 25));

                    int row = ((JTable) e.getSource()).getSelectedRow();
                    int departmentId = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
                    String[] getElement = dsi.read(departmentId);

                    if (Boolean.parseBoolean(getElement[0])) {

                        JTextField numberField = new JTextField();
                        numberField.setText(getElement[1]);
                        numberField.setEnabled(false);
                        numberField.setPreferredSize(new Dimension(75, 25));
                        panel.add(numberField);

                        JTextField departmentField = new JTextField();
                        departmentField.setText(getElement[2]);
                        departmentField.setPreferredSize(new Dimension(175, 25));
                        panel.add(departmentField);

                        JButton cancel = new JButton("Cancel");
                        cancel.setPreferredSize(new Dimension(75, 25));
                        cancel.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                unlockDepartmentWindow();
                                dialog.dispose();
                            }
                        });

                        JButton delete = new JButton("Delete");
                        delete.setPreferredSize(new Dimension(75, 25));
                        delete.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                int id = Integer.parseInt(getElement[1]);
                                String[] result = dsi.delete(id);

                                model.setDataVector(dsi.getAll(), new String[]{"ID", "Name"});
                                unlockDepartmentWindow();
                                dialog.dispose();
                            }
                        });

                        JButton update = new JButton("Update");
                        update.setPreferredSize(new Dimension(75, 25));
                        update.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                int id = Integer.parseInt(getElement[1]);
                                String updatedDepartment = departmentField.getText();
                                String[] result = dsi.update(id, new Department(updatedDepartment));

                                System.out.println(result[1]);

                                errorLabel.setText(result[1]);
                                model.setDataVector(dsi.getAll(), new String[]{"ID", "Name"});
                            }
                        });

                        panel.add(cancel);
                        panel.add(delete);
                        panel.add(update);
                    }


                    dialog.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                            unlockDepartmentWindow();
                        }
                    });

                    panel.add(errorLabel);
                    dialog.add(panel);
                    dialog.setVisible(true);
                }
            }
        };

        return tmp;
    }
}