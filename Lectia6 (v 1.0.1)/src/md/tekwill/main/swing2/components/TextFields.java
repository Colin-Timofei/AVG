package md.tekwill.main.swing2.components;

import javax.swing.*;
import java.awt.*;

public class TextFields {

    static Dimension mediumTextFieldDimension = new Dimension(150, 25);

    public static JTextField createTextField(String text, boolean isEnabled) {

        JTextField tmp = new JTextField();
        tmp.setPreferredSize(mediumTextFieldDimension);
        tmp.setEnabled(isEnabled);
        tmp.setText(text);

        return tmp;
    }

    public static JTextField createEnabledTextField(String text) {

        return createTextField(text, true);
    }

    public static JTextField createDisabledTextField(String text) {

        return createTextField(text, false);
    }
}
