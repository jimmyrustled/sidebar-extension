package org.rustled.extension.ui.listener;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FocusListener implements WindowListener {

    private JWindow pluginWindow;

    public FocusListener(JWindow pluginFrame) {
        this.pluginWindow = pluginFrame;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
        pluginWindow.setVisible(false);
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        pluginWindow.setVisible(true);
    }

    @Override
    public void windowActivated(WindowEvent e) {
        pluginWindow.setAlwaysOnTop(true);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        pluginWindow.setAlwaysOnTop(false);
    }
}