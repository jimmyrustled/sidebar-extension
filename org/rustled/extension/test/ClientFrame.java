package org.rustled.extension.test;

import javax.swing.*;
import java.awt.geom.RoundRectangle2D;

public class ClientFrame extends JFrame {

    public ClientFrame() {
        setSize(700, 700);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0.0, 0.0, getWidth(), getHeight(), 15.0, 15.0));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
