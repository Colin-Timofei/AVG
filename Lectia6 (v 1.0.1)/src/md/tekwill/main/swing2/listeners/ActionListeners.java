package md.tekwill.main.swing2.listeners;

import md.tekwill.domain.Department;
import md.tekwill.domain.Employee;

import javax.swing.*;
import java.awt.event.ActionListener;

import static md.tekwill.main.swing2.main.SwingMain.*;
import static md.tekwill.main.swing2.containers.Dialogs.*;

public class ActionListeners {

    public static ActionListener createNewDepartmentButtonListener() {

        return e -> {
            jfrm.setEnabled(false);
            JDialog dialog = createDepartmentDialog();
            dialog.setVisible(true);
        };
    }

    public static ActionListener createNewEmployeeButtonListener() {

        return e -> {
            jfrm.setEnabled(false);
            JDialog dialog = createEmployeeDialog();
            dialog.setVisible(true);
        };
    }

    public static ActionListener cancelButtonListener(JDialog dialog) {

        return e -> {
            jfrm.setEnabled(true);
            dialog.dispose();
        };
    }

    public static ActionListener createDepartmentButtonListener(JTextField departmentField, JLabel errorLabel) {

        return e -> {
            String[] result = dsi.create(new Department(departmentField.getText()));
            errorLabel.setText(result[1]);

            if (Boolean.parseBoolean(result[0])) {
                departmentTableModel.setDataVector(dsi.getAll(), departmentColumns);
            }
        };
    }

    public static ActionListener updateDepartmentButtonListener(int id, JTextField departmentField, JLabel errorLabel) {

        return e -> {
            String[] result = dsi.update(id, new Department(departmentField.getText()));
            errorLabel.setText(result[1]);

            if (Boolean.parseBoolean(result[0])) {
                departmentTableModel.setDataVector(dsi.getAll(), departmentColumns);
            }
        };
    }

    public static ActionListener deleteDepartmentButtonListener(int id, JDialog dialog) {

        return e -> {
            dsi.delete(id);
            departmentTableModel.setDataVector(dsi.getAll(), departmentColumns);
            jfrm.setEnabled(true);
            dialog.dispose();
        };
    }

    public static ActionListener createEmployeeButtonListener(JTextField firstNameField, JTextField lastNameField, JComboBox departmentComboBox, JLabel errorLabel) {

        return e -> {
            String[] result = esi.create(new Employee(firstNameField.getText(), lastNameField.getText(), new Department((String)departmentComboBox.getSelectedItem())));
            errorLabel.setText(result[1]);

            if (Boolean.parseBoolean(result[0])) {
                employeeTableModel.setDataVector(esi.getAll(), employeeColumns);
            }
        };
    }


    public static ActionListener updateEmployeeButtonListener(int id, JTextField firstNameField, JTextField lastNameField, JComboBox departmentComboBox, JLabel errorLabel) {

        return e -> {
            String[] result = esi.update(id, new Employee(firstNameField.getText(), lastNameField.getText(), new Department(departmentComboBox.getSelectedItem().toString())));
            errorLabel.setText(result[1]);

            if (Boolean.parseBoolean(result[0])) {
                employeeTableModel.setDataVector(esi.getAll(), employeeColumns);
            }
        };
    }

    public static ActionListener deleteEmployeeButtonListener(int id, JDialog dialog) {

        return e -> {
            esi.delete(id);
            employeeTableModel.setDataVector(esi.getAll(), employeeColumns);
            jfrm.setEnabled(true);
            dialog.dispose();
        };
    }
}
