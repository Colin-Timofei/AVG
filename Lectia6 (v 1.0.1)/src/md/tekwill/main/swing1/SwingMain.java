package md.tekwill.main.swing1;

import md.tekwill.service.impl.array.DepartmentServiceImpl;
import md.tekwill.service.impl.array.EmployeeServiceImpl;
import static md.tekwill.main.swing1.DepartmentPanel.makeDepartmentPanel;
import static md.tekwill.main.swing1.EmployeePanel.makeEmployeePanel;

import javax.swing.*;
import java.awt.*;

public class SwingMain {

    static DepartmentServiceImpl dsi = new DepartmentServiceImpl();
    static EmployeeServiceImpl esi = new EmployeeServiceImpl();

    static JFrame jfrm = new JFrame("DAO v1.0.1");
    static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

    static int rowHeight = 25;

    static Dimension firstBoxDimension = new Dimension(400, 300);
    static Dimension secondBoxDimension = new Dimension(400, 100);

    static Dimension bigDimension = new Dimension(250, rowHeight);
    static Dimension mediumPlusDimension = new Dimension(150, rowHeight);
    static Dimension mediumDimension = new Dimension(100, rowHeight);
    static Dimension smallDimension = new Dimension(75, rowHeight);

    SwingMain() {

        jfrm.setSize(400, 400);
        jfrm.setResizable(false);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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