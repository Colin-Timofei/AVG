package md.tekwill.main;

import javax.swing.*;
import java.awt.*;


public class Test extends JFrame {

    Test() {

        JFrame jfrm = new JFrame();
        jfrm.setSize(400, 400);
        jfrm.setResizable(false);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        tabbedPane.addTab("One", makePanel());
        tabbedPane.addTab("Two", makePanel());

        jfrm.add(tabbedPane);
        jfrm.setVisible(true);
    }

    private JPanel makePanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        Box box1 = new Box(BoxLayout.X_AXIS);
        box1.setPreferredSize(new Dimension(400, 300));

        String[][] data = new String[][] {
                {"A", "123", "Tesla"},
                {"B", "312", "Tesla"},
                {"C", "441", "Tesla"},
                {"A", "123", "Tesla"},
                {"B", "312", "Tesla"},
                {"C", "441", "Tesla"},
                {"A", "123", "Tesla"},
                {"B", "312", "Tesla"},
                {"C", "441", "Tesla"},
                {"A", "123", "Tesla"},
                {"B", "312", "Tesla"},
                {"C", "441", "Tesla"}
        };

        String[] columns = {"letter", "number", "car"};

        JTable table = new JTable(data, columns);
        table.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(table);
        box1.add(scrollPane);

        panel.add(box1);

        Box box2 = new Box(BoxLayout.X_AXIS);
        box2.setPreferredSize(new Dimension(400,100));
        box2.add(new JButton("Do"));
        panel.add(box2);

        return panel;
    }

    public static void main(String args[])
    {
        new Test();
    }
}