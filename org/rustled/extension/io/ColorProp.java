package org.rustled.extension.io;

import java.io.*;
import java.util.Properties;

public class ColorProp {

    public String mainStyle = "-fx-background-color: rgb(102, 102, 102);-fx-background-color: rgb(26, 26, 26);-fx-background-color: rgb(51, 51, 51);";
    public String tabPaneStyle = "-fx-background-color: rgb(102, 102, 102);-fx-background-color: rgb(77, 77, 77);-fx-background-color: rgb(51, 51, 51);-fx-background-color: rgb(77, 77, 77);";
    public String textStyle = "-fx-fill: rgb(230, 230, 230);";
    public String menuHoverStyle = "-fx-background-color: rgb(102, 102, 102);-fx-background-color: rgb(26, 26, 26);-fx-background-color: rgb(51, 51, 51); -fx-accent: rgb(51, 0, 51); -fx-accent: rgb(230, 230, 230); -fx-accent: rgb(153, 153, 153); -fx-accent: rgb(128, 128, 128);";
    public String tabStyle = "-fx-background-color: rgb(204, 204, 204);";

    private final String PROP_FILE_PATH = System.getProperty("user.home") + File.separator + "DreamBot" + File.separator + "BotData" + File.separator + "colors.properties";

    public ColorProp() {
        if(!loadLocalStyle())
            loadGlobalStyle();
    }

    private void loadGlobalStyle() {
        final File propFile = new File(PROP_FILE_PATH);
        Properties styleProp = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream(propFile);
            styleProp.load(input);
            mainStyle = sanitizedProp("main", styleProp, mainStyle);
            tabPaneStyle = sanitizedProp("tabPane", styleProp, tabPaneStyle);
            textStyle = sanitizedProp("text", styleProp, textStyle);
            menuHoverStyle = sanitizedProp("menuHover", styleProp, menuHoverStyle);
            tabStyle = sanitizedProp("tab", styleProp, tabStyle);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *
     *
     * @return false if localStyle does not exist
     */
    private boolean loadLocalStyle() {

        return false;
    }

    public void saveLocalStyle() {

    }

    /**
     * Sanitizes the specified property (removes all back-slashes).
     *
     * @param propName The name of the property
     * @param prop The {@link Properties} object for the colors file
     * @param def The style that will be used if there is no value set or there was an error loading the file
     * @return The sanitized value of the specified property, or def if the file failed to load
     */
    private String sanitizedProp(String propName, Properties prop, String def) {
        String sanitizedProp = def;

        if(prop != null) {
            if(prop.getProperty(propName) != null) {
                sanitizedProp = prop.getProperty(propName).replace("\\", "");
            }
        }

        return sanitizedProp.equalsIgnoreCase("") ? def : sanitizedProp;
    }
}