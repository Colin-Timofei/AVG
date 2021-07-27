package md.tekwill.main.swing2.components;

import javax.swing.*;
import java.awt.*;

public class ComboBoxes {

    static Dimension mediumComboBoxDimension = new Dimension(150, 25);

    public static JComboBox createComboBox(String[] list) {

        JComboBox tmp = new JComboBox(list);
        tmp.setPreferredSize(mediumComboBoxDimension);

        return tmp;
    }

}
