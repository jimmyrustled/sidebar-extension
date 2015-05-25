package org.rustled.extension.api.plugin;

import javafx.scene.Scene;
import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.plugin.Plugin;
import org.dreambot.api.plugin.PluginManifest;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public abstract class SidePlugin extends MethodContext implements Runnable {

    private PluginState state;
    private Scene scene;
    private int loopWait = 5000;

    public void setPluginScene(Scene scene) {
        this.scene = scene;
    }

    public abstract void onStart();

    public abstract void onLoop();

    @Override
    public void run() {
        onStart();
        if(scene != null) {
            //Display scene on JavaFX Thread, or add to a queue that will display a set amount of scenes at a time in order to not bottle neck it.
        }
        while(getState() != PluginState.STOP) {
            MethodProvider.sleep(loopWait);
            onLoop();
        }
    }

    public void setLoopWait(int time) {
        this.loopWait = time;
    }

    public void setState(PluginState state) {
        this.state = state;
    }

    public PluginState getState() {
        return state;
    }

    public final PluginManifest getManifest() {
        return (PluginManifest)this.getClass().getAnnotation(PluginManifest.class);
    }
}