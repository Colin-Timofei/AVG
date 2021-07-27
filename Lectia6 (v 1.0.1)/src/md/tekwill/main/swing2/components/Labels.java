package md.tekwill.main.swing2.components;

import javax.swing.*;
import java.awt.*;

public class Labels {

    static Dimension bigLabelDimension = new Dimension(250, 25);
    static Dimension mediumLabelDimension = new Dimension(100, 25);

    public static JLabel createLabel(String label, Dimension dimension) {

        JLabel tmp = new JLabel(label);
        tmp.setPreferredSize(dimension);

        return tmp;
    }

    public static JLabel createBigLabel(String label) {

        return createLabel(label, bigLabelDimension);
    }

    public static JLabel createMediumLabel(String label) {

        return createLabel(label, mediumLabelDimension);
    }
}
