package io.heroeslore.main;

import javax.swing.*;

public class UIMain {

    static JFrame jfrm;

    UIMain() {
        UIHelper.OpenWindow();
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UIMain();

            }
        });
    }
}
