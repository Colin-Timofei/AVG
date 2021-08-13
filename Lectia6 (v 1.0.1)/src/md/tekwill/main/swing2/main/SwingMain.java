package md.tekwill.main.swing2.main;

import md.tekwill.service.impl.DepartmentServiceImpl;
import md.tekwill.service.impl.EmployeeServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static md.tekwill.main.swing2.containers.Panels.*;

public class SwingMain {

    // change variant to use different dao implementations
    // options : Array, ArrayList, Map
    public static String variant = "ArrayList";

    public static DepartmentServiceImpl dsi = new DepartmentServiceImpl();
    public static EmployeeServiceImpl esi = new EmployeeServiceImpl();

    public static JFrame jfrm = new JFrame("DAO v1.0.3");

    public static String[] departments = dsi.getDepartmentNames();
    public static final String[] departmentColumns = new String[]{"ID", "Name", "Created", "Last Updated"};
    public static final String[] employeeColumns = new String[]{"ID", "First Name", "Last Name", "Department", "Created", "Last Updated"};

    public static DefaultTableModel departmentTableModel = new DefaultTableModel(dsi.getAll(), departmentColumns);
    public static DefaultTableModel employeeTableModel = new DefaultTableModel(esi.getAll(), employeeColumns);

    public static JTable departmentTable = new JTable(departmentTableModel);
    public static JTable employeeTable = new JTable(employeeTableModel);

    SwingMain() {

        jfrm.setSize(850, 400);
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
