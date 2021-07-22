package md.tekwill.main;

import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import static md.tekwill.main.SwingMain.*;
import static md.tekwill.main.Helper.*;

public class EmployeePanel {

    static JPanel employeePanel = new JPanel();
    static final String[] columns = new String[]{"ID", "First Name", "Last Name", "Department"};
    static DefaultTableModel model = new DefaultTableModel(esi.getAll(), columns);
    static JTable employeeTable = new JTable(model);
    static MouseAdapter employeeTableListener = tableClick();
    static JButton employeeCreateButton = makeButton("Add New Employee", newEmployeeListener(), new Dimension(200, 30));


    public static JPanel makeEmployeePanel() {


        setBoxPanel(employeePanel);

        Box box1 = makeBox(firstBoxDimension);
        JScrollPane scrollPane = makeScrollPaneFromTableWithListener(employeeTable, employeeTableListener, new int[] {50, 100, 100, 100});
        box1.add(scrollPane);

        Box box2 = makeBox(secondBoxDimension);
        box2.add(employeeCreateButton);

        employeePanel.add(box1);
        employeePanel.add(box2);

        return employeePanel;
    }

    private static JDialog createEmployeeDialog(String name) {
        return createDialog(name, employeeTable, employeeTableListener, employeeCreateButton);
    }

    private static void unlockPanel() {
        unlockPane(employeeTable, employeeTableListener, employeeCreateButton);
    }

    private static void lockPanel() {
        lockPane(employeeTable, employeeTableListener, employeeCreateButton);
    }

    private static ActionListener cancelButtonListener(JDialog dialog) {

        return e -> {
            unlockPanel();
            dialog.dispose();
        };
    }

    private static ActionListener createButtonListener(JTextField firstNameField, JTextField lastNameField, JComboBox departmentComboBox, JLabel errorMsg) {

        return e -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String department = (String)departmentComboBox.getSelectedItem();
            Employee newEmployee = new Employee(firstName, lastName, new Department(department));

            String[] result = esi.create(newEmployee);
            errorMsg.setText(result[1]);

            if (Boolean.parseBoolean(result[0])) {
                model.setDataVector(esi.getAll(), columns);
            }
        };
    }

    private static ActionListener updateButtonListener(JTextField firstNameField, JTextField lastNameField, JComboBox departmentComboBox, String[] element, JLabel errorMsg) {

        return e -> {

            int id = Integer.parseInt(element[1]);
            String updatedFirstName = firstNameField.getText();
            String updatedLastName = lastNameField.getText();
            String updatedDepartment = (String)departmentComboBox.getSelectedItem();
            String[] result = esi.update(id, new Employee(updatedFirstName, updatedLastName, new Department(updatedDepartment)));

            errorMsg.setText(result[1]);
            model.setDataVector(esi.getAll(), columns);
        };
    }

    private static ActionListener deleteButtonListener(JDialog dialog, String[] element) {

        return e -> {
            int id = Integer.parseInt(element[1]);
            esi.delete(id);

            model.setDataVector(esi.getAll(), columns);
            unlockPanel();
            dialog.dispose();
        };
    }

    private static ActionListener newEmployeeListener() {
        return e -> {

            lockPanel();

            JDialog dialog = createEmployeeDialog("Add Employee");
            JPanel panel = createDialogPanel();

            JLabel nameLabel = makeLabel("Enter the details of the new employee : ", bigDimension);
            JLabel errorLabel = makeLabel("", bigDimension);

            JLabel firstNameLabel = makeLabel("First Name : ", mediumDimension);
            JTextField firstNameField = makeTextField("", mediumPlusDimension, true);

            JLabel lastNameLabel = makeLabel("Last Name : ", mediumDimension);
            JTextField lastNameField = makeTextField("", mediumPlusDimension, true);

            String[] departments = dsi.getDepartmentNames();
            JLabel departmentLabel = makeLabel("Department : ", mediumDimension);
            JComboBox departmentComboBox = new JComboBox(departments);

            JButton cancel = makeDialogCancelButton(cancelButtonListener(dialog), mediumDimension);
            JButton submit = makeDialogCreateButton(createButtonListener(firstNameField, lastNameField, departmentComboBox, errorLabel), mediumDimension);

            panel.add(nameLabel);

            panel.add(firstNameLabel);
            panel.add(firstNameField);

            panel.add(lastNameLabel);
            panel.add(lastNameField);

            panel.add(departmentLabel);
            panel.add(departmentComboBox);

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

                    JDialog dialog = createEmployeeDialog("Update or Remove Employee");
                    JPanel panel = createDialogPanel();

                    JLabel errorLabel = makeLabel("", bigDimension);

                    int row = ((JTable) e.getSource()).getSelectedRow();
                    int employeeId = Integer.parseInt(employeeTable.getModel().getValueAt(row, 0).toString());
                    String[] getElement = esi.read(employeeId);

                    if (Boolean.parseBoolean(getElement[0])) {

                        JLabel idLabel = makeLabel("ID : ", smallDimension);
                        JTextField idField = makeTextField(getElement[1], mediumPlusDimension, false);
                        panel.add(idLabel);
                        panel.add(idField);

                        JLabel firstNameLabel = makeLabel("First Name : ", smallDimension);
                        JTextField firstNameField = makeTextField(getElement[2], mediumPlusDimension, true);
                        panel.add(firstNameLabel);
                        panel.add(firstNameField);

                        JLabel lastNameLabel = makeLabel("Last Name : ", smallDimension);
                        JTextField lastNameField = makeTextField(getElement[3], mediumPlusDimension, true);
                        panel.add(lastNameLabel);
                        panel.add(lastNameField);

                        String[] departments = dsi.getDepartmentNames();
                        JLabel departmentLabel = makeLabel("Department : ", smallDimension);
                        JComboBox departmentComboBox = new JComboBox(departments);
                        departmentComboBox.setPreferredSize(mediumPlusDimension);
                        panel.add(departmentLabel);
                        panel.add(departmentComboBox);

                        JButton cancel = makeDialogCancelButton(cancelButtonListener(dialog), smallDimension);
                        JButton delete = makeDialogDeleteButton(deleteButtonListener(dialog, getElement),smallDimension);
                        JButton update = makeDialogUpdateButton(updateButtonListener(firstNameField, lastNameField, departmentComboBox, getElement, errorLabel), smallDimension);

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
