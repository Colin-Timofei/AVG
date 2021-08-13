package md.tekwill.main.swing2.containers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import static md.tekwill.main.swing2.components.Buttons.*;
import static md.tekwill.main.swing2.containers.ScrollPanes.*;

public class Boxes {

    static Dimension firstBoxDimension = new Dimension(850, 300);
    static Dimension secondBoxDimension = new Dimension(850, 100);

    public static Box firstBox(JTable table, MouseAdapter adapter, int[] width) {

        Box tmp = new Box(BoxLayout.X_AXIS);
        tmp.setPreferredSize(firstBoxDimension);

        JScrollPane jScrollPane = createScrollPanelFromTable(table, adapter, width);
        tmp.add(jScrollPane);

        return tmp;
    }

    public static Box secondBox(String name, ActionListener listener) {

        Box tmp = new Box(BoxLayout.X_AXIS);
        tmp.setPreferredSize(secondBoxDimension);

        JButton createButton = createBigButton(name, listener);
        tmp.add(createButton);

        return tmp;
    }
}