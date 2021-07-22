package md.tekwill.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static md.tekwill.main.SwingMain.*;

public class Helper {

    public static void setBoxPanel(JPanel panel) {

        panel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    }

    public static Box makeBox(Dimension dimension) {

        Box tmp = new Box(BoxLayout.X_AXIS);
        tmp.setPreferredSize(dimension);

        return tmp;
    }

    public static JScrollPane makeScrollPaneFromTableWithListener(JTable table, MouseAdapter adapter, int[] width) {

        int size = width.length;

        for(int i = 0; i < size; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(width[i]);
        }

        table.addMouseListener(adapter);
        table.setRowHeight(25);

        return new JScrollPane(table);
    }

    public static JDialog createDialog(String name, JTable table, MouseAdapter mouseAdapter, JButton actionButton) {

        JDialog tmp = new JDialog(jfrm, name);
        tmp.setSize(new Dimension(300, 300));
        tmp.setResizable(false);
        tmp.addWindowListener(onWindowClose(table, mouseAdapter, actionButton));

        return tmp;
    }

    public static JPanel createDialogPanel() {

        JPanel tmp = new JPanel();
        tmp.setLayout(new FlowLayout());

        return tmp;
    }

    public static JLabel makeLabel(String label, Dimension dimension) {

        JLabel tmp = new JLabel(label);
        tmp.setPreferredSize(dimension);

        return tmp;
    }

    public static JTextField makeTextField(String text, Dimension dimension, boolean isEnabled) {

        JTextField tmp = new JTextField();
        tmp.setPreferredSize(dimension);
        tmp.setEnabled(isEnabled);
        tmp.setText(text);

        return tmp;
    }

    public static JButton makeButton(String name, ActionListener listener, Dimension dimension) {

        JButton tmp = new JButton(name);
        tmp.setPreferredSize(dimension);
        tmp.addActionListener(listener);

        return tmp;
    }

    public static JButton makeDialogCancelButton(ActionListener listener, Dimension dimension) {

        return makeButton("Cancel", listener, dimension);
    }

    public static JButton makeDialogCreateButton(ActionListener listener, Dimension dimension) {

        return makeButton("Create", listener, dimension);
    }

    public static JButton makeDialogUpdateButton(ActionListener listener, Dimension dimension) {

        return makeButton("Update", listener, dimension);
    }

    public static JButton makeDialogDeleteButton(ActionListener listener, Dimension dimension) {

        return makeButton("Delete", listener, dimension);
    }

    public static WindowAdapter onWindowClose(JTable table, MouseAdapter mouseAdapter, JButton actionButton) {

        return new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                unlockPane(table, mouseAdapter, actionButton);
            }
        };
    }

    public static void lockPane(JTable table, MouseAdapter mouseAdapter, JButton actionButton) {

        tabbedPane.setEnabled(false);
        table.removeMouseListener(mouseAdapter);
        actionButton.setEnabled(false);
    }

    public static void unlockPane(JTable table, MouseAdapter mouseAdapter, JButton actionButton) {

        tabbedPane.setEnabled(true);
        table.addMouseListener(mouseAdapter);
        actionButton.setEnabled(true);
    }
}