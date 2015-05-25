package org.rustled.extension;

import javafx.application.Platform;
import org.rustled.extension.ui.ExtensionGUI;
import org.rustled.extension.ui.ExtensionWindow;
import org.rustled.extension.ui.listener.FocusListener;
import org.rustled.extension.ui.listener.MovementListener;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {

    private static JFrame clientFrame;
    private static JWindow extensionWindow;
    private static ExtensionGUI extensionGUI;
    private static MovementListener movementListener;
    private static FocusListener focusListener;
    private static String FRAME_CLASS = "org.dreambot.b";
    private static String FRAME_FIELD = "f";

    public static void main(String[] args) {
        setClientFrame();

        if(clientFrame != null) {
            SwingUtilities.invokeLater(() -> {
                extensionWindow = new ExtensionWindow(clientFrame.getHeight(), clientFrame.getX(), clientFrame.getY());
                extensionGUI = new ExtensionGUI();
                movementListener = new MovementListener(extensionWindow);
                focusListener = new FocusListener(extensionWindow);
                clientFrame.addComponentListener(movementListener);
                clientFrame.addWindowListener(focusListener);
                clientFrame.setContentPane(extensionGUI);
                Platform.runLater(() -> {
                    extensionGUI.build();
                });
            });
        }
    }

    private static void setClientFrame() {
        try {
            Class<?> c = Class.forName(FRAME_CLASS);
            Constructor<?> con = c.getDeclaredConstructor();
            con.setAccessible(true);
            Object newInstance = con.newInstance();
            Field frameField = newInstance.getClass().getDeclaredField(FRAME_FIELD);
            frameField.setAccessible(true);
            clientFrame = (JFrame) frameField.get(newInstance);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}