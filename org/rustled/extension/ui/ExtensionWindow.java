package org.rustled.extension.ui;

import javax.swing.*;

public class ExtensionWindow extends JWindow {

    public final int WIDTH = 300;

    public ExtensionWindow(int clientHeight, int clientX, int clientY) {
        setSize(WIDTH, clientHeight);
        setLocation(clientX, clientY);
        setVisible(true);
    }
}
