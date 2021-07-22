package md.tekwill.main;

import md.tekwill.service.impl.array.DepartmentServiceImpl;
import md.tekwill.service.impl.array.EmployeeServiceImpl;

import javax.swing.*;

public class SwingMain {

    static DepartmentServiceImpl dsi = new DepartmentServiceImpl();
    static EmployeeServiceImpl esi = new EmployeeServiceImpl();

    static JFrame jfrm = new JFrame("DAO v1.0.1");
    static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

    SwingMain() {

        jfrm.setSize(400, 400);
        jfrm.setResizable(false);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane.addTab("Departments", DepartmentPanel.makeDepartmentPanel());
        tabbedPane.addTab("Employees", EmployeePanel.makeEmployeePanel());

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