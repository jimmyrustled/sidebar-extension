package org.rustled.extension.test;

import javafx.application.Platform;
import org.rustled.extension.ui.ExtensionGUI;
import org.rustled.extension.ui.ExtensionWindow;

import javax.swing.*;

/**
 * Stand-alone extension window for testing themes and other features specific to the sidebar extension.
 *
 */
public class SAWindow {

    private static ExtensionWindow pluginWindow;
    private static ExtensionGUI extensionGUI;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            pluginWindow = new ExtensionWindow(623, 10, 10);
            extensionGUI = new ExtensionGUI();
            pluginWindow.add(extensionGUI);
            Platform.runLater(() -> {
                extensionGUI.build();
            });
        });
    }
}
