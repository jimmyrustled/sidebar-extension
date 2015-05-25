package org.rustled.extension.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SidePluginLoader {

    private final String BOT_DIR = System.getProperty("user.home") + File.separator + "DreamBot";
    private final String PLUGIN_DIR = BOT_DIR + File.separator + "side_plugins";

    public void loadLocalPlugins() throws IOException {
        final File pluginDir = new File(PLUGIN_DIR);
        if(!pluginDir.exists()) {
            pluginDir.mkdir();
        }

        final List<File> classes = new ArrayList<File>();
        addClasses(classes, pluginDir);

        for(final File file : classes) {

        }
    }

    private void addClasses(List<File> classes, final File directory) {
        for(final File file : directory.listFiles()) {
            if(file.isDirectory()) {
                addClasses(classes, file);
            } else if(file.toString().endsWith(".class")) {
                classes.add(file);
            }
        }
    }
}
