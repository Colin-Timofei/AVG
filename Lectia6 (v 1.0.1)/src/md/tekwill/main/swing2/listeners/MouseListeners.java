package md.tekwill.main.swing2.listeners;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static md.tekwill.main.swing2.containers.Dialogs.*;
import static md.tekwill.main.swing2.main.SwingMain.*;

public class MouseListeners {

    public static MouseAdapter departmentTableListener() {

        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    jfrm.setEnabled(false);
                    JDialog dialog = updateDepartmentDialog(((JTable) e.getSource()).getSelectedRow());
                    dialog.setVisible(true);
                }
            }
        };
    }

    public static MouseAdapter employeeTableListener() {

        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    jfrm.setEnabled(false);
                    JDialog dialog = updateEmployeeDialog(((JTable) e.getSource()).getSelectedRow());
                    dialog.setVisible(true);
                }
            }
        };
    }
}