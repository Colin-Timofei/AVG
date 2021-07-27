package md.tekwill.main.swing2.main;

import md.tekwill.service.impl.array.DepartmentServiceImpl;
import md.tekwill.service.impl.array.EmployeeServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static md.tekwill.main.swing2.containers.Panels.*;

public class SwingMain {

    public static DepartmentServiceImpl dsi = new DepartmentServiceImpl();
    public static EmployeeServiceImpl esi = new EmployeeServiceImpl();

    public static JFrame jfrm = new JFrame("DAO v1.0.2");

    public static String[] departments = dsi.getDepartmentNames();
    public static final String[] departmentColumns = new String[]{"ID", "Name"};
    public static final String[] employeeColumns = new String[]{"ID", "First Name", "Last Name", "Department"};

    public static DefaultTableModel departmentTableModel = new DefaultTableModel(dsi.getAll(), departmentColumns);
    public static DefaultTableModel employeeTableModel = new DefaultTableModel(esi.getAll(), employeeColumns);

    public static JTable departmentTable = new JTable(departmentTableModel);
    public static JTable employeeTable = new JTable(employeeTableModel);

    SwingMain() {

        jfrm.setSize(400, 400);
        jfrm.setResizable(false);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.addTab("Departments", makeDepartmentPanel());
        tabbedPane.addTab("Employees", makeEmployeePanel());

        jfrm.add(tabbedPane);
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingMain();
            }
        });
    }
}
