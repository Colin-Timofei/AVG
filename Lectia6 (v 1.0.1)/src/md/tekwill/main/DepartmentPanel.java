package md.tekwill.main;

import md.tekwill.domain.Department;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import static md.tekwill.main.SwingMain.*;
import static md.tekwill.main.Helper.*;

public class DepartmentPanel {

    static JPanel departmentPanel = new JPanel();
    static final String[] columns = new String[]{"ID", "Name"};
    static DefaultTableModel model = new DefaultTableModel(dsi.getAll(), columns);
    static JTable departmentTable = new JTable(model);
    static MouseAdapter departmentTableListener = tableClick();
    static JButton departmentCreateButton = makeButton("Create New Department", newDepartmentListener(), new Dimension(200,30));

    public static JPanel makeDepartmentPanel() {

        setBoxPanel(departmentPanel);

        Box box1 = makeBox(firstBoxDimension);
        JScrollPane scrollPane = makeScrollPaneFromTableWithListener(departmentTable, departmentTableListener, new int[] {100, 200});
        box1.add(scrollPane);

        Box box2 = makeBox(secondBoxDimension);
        box2.add(departmentCreateButton);

        departmentPanel.add(box1);
        departmentPanel.add(box2);

        return departmentPanel;
    }

    private static JDialog createDepartmentDialog(String name) {
        return createDialog(name, departmentTable, departmentTableListener, departmentCreateButton);
    }

    private static void unlockPanel() {
        unlockPane(departmentTable, departmentTableListener, departmentCreateButton);
    }

    private static void lockPanel() {
        lockPane(departmentTable, departmentTableListener, departmentCreateButton);
    }

    private static ActionListener cancelButtonListener(JDialog dialog) {

        return e -> {
            unlockPanel();
            dialog.dispose();
        };
    }

    private static ActionListener createButtonListener(JTextField departmentField, JLabel errorMsg) {

        return e -> {
            String department = departmentField.getText();
            Department newDepartment = new Department(department);
            String[] result = dsi.create(newDepartment);
            errorMsg.setText(result[1]);

            if (Boolean.parseBoolean(result[0])) {
                model.setDataVector(dsi.getAll(), columns);
            }
        };
    }

    private static ActionListener updateButtonListener(JTextField departmentField, String[] element, JLabel errorMsg) {

        return e -> {
            int id = Integer.parseInt(element[1]);
            String updatedDepartment = departmentField.getText();
            String[] result = dsi.update(id, new Department(updatedDepartment));

            errorMsg.setText(result[1]);
            model.setDataVector(dsi.getAll(), columns);
        };
    }

    private static ActionListener deleteButtonListener(JDialog dialog, String[] element) {

        return e -> {
            int id = Integer.parseInt(element[1]);
            dsi.delete(id);

            model.setDataVector(dsi.getAll(), columns);
            unlockPanel();
            dialog.dispose();
        };
    }

    private static ActionListener newDepartmentListener() {
        return e -> {

            lockPanel();

            JDialog dialog = createDepartmentDialog("Create Department");
            JPanel panel = createDialogPanel();

            JLabel nameLabel = makeLabel("Enter the name of the new department : ", bigDimension);
            JLabel errorLabel = makeLabel("", bigDimension);

            JTextField nameField = makeTextField("", bigDimension, true);

            JButton cancel = makeDialogCancelButton(cancelButtonListener(dialog), mediumDimension);
            JButton submit = makeDialogCreateButton(createButtonListener(nameField, errorLabel), mediumDimension);

            panel.add(nameLabel);
            panel.add(nameField);
            panel.add(cancel);
            panel.add(submit);
            panel.add(errorLabel);

            dialog.add(panel);
            dialog.setVisible(true);
        };
    }

    private static MouseAdapter tableClick() {

        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() == 2) {

                    lockPanel();

                    JDialog dialog = createDepartmentDialog("Update or Delete Department");
                    JPanel panel = createDialogPanel();

                    JLabel errorLabel = makeLabel("", bigDimension);

                    int row = ((JTable) e.getSource()).getSelectedRow();
                    int departmentId = Integer.parseInt(departmentTable.getModel().getValueAt(row, 0).toString());
                    String[] getElement = dsi.read(departmentId);

                    if (Boolean.parseBoolean(getElement[0])) {

                        JTextField numberField = makeTextField(getElement[1], mediumDimension, false);
                        panel.add(numberField);

                        JTextField departmentField = makeTextField(getElement[2], mediumDimension, true);
                        panel.add(departmentField);

                        JButton cancel = makeDialogCancelButton(cancelButtonListener(dialog), smallDimension);
                        JButton delete = makeDialogDeleteButton(deleteButtonListener(dialog, getElement),smallDimension);
                        JButton update = makeDialogUpdateButton(updateButtonListener(departmentField, getElement, errorLabel), smallDimension);

                        panel.add(cancel);
                        panel.add(delete);
                        panel.add(update);
                    }

                    panel.add(errorLabel);
                    dialog.add(panel);
                    dialog.setVisible(true);
                }
            }
        };
    }
}