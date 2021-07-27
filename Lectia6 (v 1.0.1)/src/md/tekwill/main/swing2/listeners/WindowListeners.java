package md.tekwill.main.swing2.listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static md.tekwill.main.swing2.main.SwingMain.*;

public class WindowListeners {

    public static WindowAdapter unlockFrameWindowAdapter() {

        return new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                jfrm.setEnabled(true);
            }
        };
    }
}