package md.tekwill.main.swing2.containers;

import javax.swing.*;


import static md.tekwill.main.swing2.listeners.ActionListeners.*;
import static md.tekwill.main.swing2.listeners.MouseListeners.*;
import static md.tekwill.main.swing2.main.SwingMain.*;
import static md.tekwill.main.swing2.containers.Boxes.*;

public class Panels {

    public static JPanel makeDepartmentPanel() {

        JPanel tmp = new JPanel();
        tmp.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        tmp.setLayout(new BoxLayout(tmp, BoxLayout.PAGE_AXIS));

        Box box1 = firstBox(departmentTable, departmentTableListener(), new int[] {100, 200});
        tmp.add(box1);

        Box box2 = secondBox("Create Department", createNewDepartmentButtonListener());
        tmp.add(box2);

        return tmp;
    }

    public static JPanel makeEmployeePanel() {

        JPanel tmp = new JPanel();
        tmp.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        tmp.setLayout(new BoxLayout(tmp, BoxLayout.PAGE_AXIS));

        Box box1 = firstBox(employeeTable, employeeTableListener(), new int[] {50, 100, 100, 100});
        tmp.add(box1);

        Box box2 = secondBox("Add New Employee", createNewEmployeeButtonListener());
        tmp.add(box2);

        return tmp;
    }
}
