package io.heroeslore.main;

import static io.heroeslore.main.UIMain.*;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class UIHelper {

    static void OpenWindow() {

        jfrm = new JFrame("DEmulator v1.0.1");
        jfrm.setSize(450, 600);
        jfrm.setResizable(false);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        URL url = UIHelper.class.getResource("../img/heroes_lore.png");
        ImageIcon background = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(450, 600, Image.SCALE_DEFAULT));;
        JLabel background_label = new JLabel(background);
        jfrm.add(background_label);

        // f68820
//        JLabel opentext = new JLabel("press any key to continue");
//        opentext.setForeground (Color.orange);
//        jfrm.add(opentext);


        jfrm.setVisible(true);
    }
}
