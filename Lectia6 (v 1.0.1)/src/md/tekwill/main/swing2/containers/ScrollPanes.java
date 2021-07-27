package md.tekwill.main.swing2.containers;

import javax.swing.*;
import java.awt.event.MouseAdapter;

public class ScrollPanes {

    public static JScrollPane createScrollPanelFromTable(JTable table, MouseAdapter adapter, int[] width) {

        int size = width.length;

        for(int i = 0; i < size; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(width[i]);
        }

        table.addMouseListener(adapter);
        table.setRowHeight(25);

        return new JScrollPane(table);
    }
}