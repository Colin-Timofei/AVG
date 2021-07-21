package md.tekwill.main;

import md.tekwill.domain.Department;
import md.tekwill.service.impl.array.DepartmentServiceImpl;
import md.tekwill.service.impl.array.EmployeeServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingMain {

    static DepartmentServiceImpl dsi = new DepartmentServiceImpl();
    static EmployeeServiceImpl esi = new EmployeeServiceImpl();
    static JFrame jfrm = new JFrame("DAO v1.0.1");

    SwingMain() {

        jfrm.setSize(400, 400);
        jfrm.setResizable(false);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        tabbedPane.addTab("Departments", DepartmentPanel.makeDepartmentPanel());
        tabbedPane.addTab("Employees", makeEmployeePanel());

        jfrm.add(tabbedPane);
        jfrm.setVisible(true);
    }

    private static JPanel makeEmployeePanel() {

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        String[] columns = {"ID", "First Name", "Last Name", "Department"};
        String[][] data = esi.getAll();

        JTable table = new JTable(data, columns);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);

        table.setRowHeight(25);

        JButton button = new JButton("Create New Employee");

        panel.add(table);
        panel.add(button);

        return panel;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingMain();
            }
        });
    }
}
