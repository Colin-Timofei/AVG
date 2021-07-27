package md.tekwill.main.swing2.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Buttons {

    static Dimension bigButtonDimension = new Dimension(200, 30);
    static Dimension mediumButtonDimension = new Dimension(100,25);
    static Dimension smallButtonDimension = new Dimension(75, 25);

    public static JButton createButton(String name, ActionListener listener, Dimension dimension) {

        JButton tmp = new JButton(name);
        tmp.setPreferredSize(dimension);
        tmp.addActionListener(listener);

        return tmp;
    }

    public static JButton createBigButton(String name, ActionListener listener) {

        return createButton(name, listener, bigButtonDimension);
    }

    public static JButton createMediumButton(String name, ActionListener listener) {

        return createButton(name, listener, mediumButtonDimension);
    }

    public static JButton createSmallButton(String name, ActionListener listener) {

        return createButton(name, listener, smallButtonDimension);
    }
}