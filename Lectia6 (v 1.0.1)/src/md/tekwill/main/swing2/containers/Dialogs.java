package md.tekwill.main.swing2.containers;

import javax.swing.*;
import java.awt.*;

import static md.tekwill.main.swing2.main.SwingMain.*;
import static md.tekwill.main.swing2.components.ComboBoxes.*;
import static md.tekwill.main.swing2.components.Labels.*;
import static md.tekwill.main.swing2.components.TextFields.*;
import static md.tekwill.main.swing2.containers.Blocks.*;
import static md.tekwill.main.swing2.listeners.ActionListeners.*;
import static md.tekwill.main.swing2.listeners.WindowListeners.*;

public class Dialogs {

    static Dimension dialogDimension = new Dimension(300, 300);

    public static JDialog createDepartmentDialog() {

        JDialog tmp = new JDialog(jfrm, "Create Department");
        tmp.setSize(dialogDimension);
        tmp.setResizable(false);
        tmp.addWindowListener(unlockFrameWindowAdapter());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel errorLabel = createBigLabel("");

        JLabel departmentLabel = createMediumLabel("Department : ");
        panel.add(departmentLabel);

        JTextField departmentTextField = createEnabledTextField("");
        panel.add(departmentTextField);

        createBlock(panel, cancelButtonListener(tmp), createDepartmentButtonListener(departmentTextField, errorLabel));

        panel.add(errorLabel);
        tmp.add(panel);

        return tmp;
    }

    public static JDialog updateDepartmentDialog(int row) {

        JDialog tmp = new JDialog(jfrm, "Update or Delete Department");
        tmp.setSize(dialogDimension);
        tmp.setResizable(false);
        tmp.addWindowListener(unlockFrameWindowAdapter());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        String[] element = dsi.read(Integer.parseInt(departmentTable.getModel().getValueAt(row, 0).toString()));

        JLabel errorLabel = createBigLabel("");

        if (Boolean.parseBoolean(element[0])) {

            int id = Integer.parseInt(element[1]);
            JLabel IdLabel = createMediumLabel("ID : ");
            panel.add(IdLabel);

            JTextField IdTextField = createDisabledTextField(element[1]);
            panel.add(IdTextField);

            JLabel departmentLabel = createMediumLabel("Department : ");
            panel.add(departmentLabel);

            JTextField departmentTextField = createEnabledTextField(element[2]);
            panel.add(departmentTextField);

            updateBlock(panel, cancelButtonListener(tmp), deleteDepartmentButtonListener(id, tmp), updateDepartmentButtonListener(id, departmentTextField, errorLabel));

        } else {
            errorLabel.setText(element[1]);
        }

        panel.add(errorLabel);
        tmp.add(panel);

        return tmp;
    }

    public static JDialog createEmployeeDialog() {

        JDialog tmp = new JDialog(jfrm, "Add Employee");
        tmp.setSize(dialogDimension);
        tmp.setResizable(false);
        tmp.addWindowListener(unlockFrameWindowAdapter());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel errorLabel = createBigLabel("");

        JLabel firstNameLabel = createMediumLabel("First Name : ");
        panel.add(firstNameLabel);

        JTextField firstNameTextField = createEnabledTextField("");
        panel.add(firstNameTextField);

        JLabel lastNameLabel = createMediumLabel("Last Name : ");
        panel.add(lastNameLabel);

        JTextField lastNameTextField = createEnabledTextField("");
        panel.add(lastNameTextField);

        JLabel departmentLabel = createMediumLabel("Department : ");
        panel.add(departmentLabel);

        JComboBox departmentComboBox = createComboBox(departments);
        panel.add(departmentComboBox);

        createBlock(panel, cancelButtonListener(tmp), createEmployeeButtonListener(firstNameTextField, lastNameTextField, departmentComboBox, errorLabel));

        panel.add(errorLabel);
        tmp.add(panel);

        return tmp;
    }

    public static JDialog updateEmployeeDialog(int row) {

        JDialog tmp = new JDialog(jfrm, "Edit or Remove Employee");
        tmp.setSize(dialogDimension);
        tmp.setResizable(false);
        tmp.addWindowListener(unlockFrameWindowAdapter());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        String[] element = esi.read(Integer.parseInt(employeeTable.getModel().getValueAt(row, 0).toString()));

        JLabel errorLabel = createBigLabel("");

        if (Boolean.parseBoolean(element[0])) {

            JLabel IdLabel = createMediumLabel("ID : ");
            panel.add(IdLabel);

            int id = Integer.parseInt(element[1]);
            JTextField IdTextField = createDisabledTextField(element[1]);
            panel.add(IdTextField);

            JLabel firstNameLabel = createMediumLabel("First Name : ");
            panel.add(firstNameLabel);

            JTextField firstNameTextField = createEnabledTextField(element[2]);
            panel.add(firstNameTextField);

            JLabel lastNameLabel = createMediumLabel("Last Name : ");
            panel.add(lastNameLabel);

            JTextField lastNameTextField = createEnabledTextField(element[3]);
            panel.add(lastNameTextField);

            JLabel departmentLabel = createMediumLabel("Department : ");
            panel.add(departmentLabel);

            JComboBox departmentComboBox = createComboBox(departments);
            departmentComboBox.setSelectedItem(element[4]);
            panel.add(departmentComboBox);

            updateBlock(panel, cancelButtonListener(tmp), deleteEmployeeButtonListener(id, tmp), updateEmployeeButtonListener(id, firstNameTextField, lastNameTextField, departmentComboBox, errorLabel));


        } else {
        errorLabel.setText(element[1]);
    }

        panel.add(errorLabel);
        tmp.add(panel);

        return tmp;
    }
}
