package org.rustled.extension.ui.listener;

import javax.swing.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MovementListener implements ComponentListener {

    private JWindow pluginWindow;

    public MovementListener(JWindow pluginFrame) {
        this.pluginWindow = pluginFrame;
    }

    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {
        pluginWindow.setLocation(e.getComponent().getX() + e.getComponent().getWidth(), e.getComponent().getY());
    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
