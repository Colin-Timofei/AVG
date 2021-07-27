package md.tekwill.main.swing2.containers;

import javax.swing.*;
import java.awt.event.ActionListener;

import static md.tekwill.main.swing2.components.Buttons.*;

public class Blocks {

    public static void createBlock(JPanel panel, ActionListener cancelButtonListener, ActionListener createButtonListener) {

        JButton cancelButton = createMediumButton("Cancel", cancelButtonListener);
        panel.add(cancelButton);

        JButton createButton = createMediumButton("Create", createButtonListener);
        panel.add(createButton);
    }

    public static void updateBlock(JPanel panel, ActionListener cancelButtonListener, ActionListener deleteButtonListener, ActionListener updateButtonListener) {

        JButton cancelButton = createSmallButton("Cancel", cancelButtonListener);
        panel.add(cancelButton);

        JButton deleteButton = createSmallButton("Delete", deleteButtonListener);
        panel.add(deleteButton);

        JButton updateButton = createSmallButton("Update", updateButtonListener);
        panel.add(updateButton);
    }
}
