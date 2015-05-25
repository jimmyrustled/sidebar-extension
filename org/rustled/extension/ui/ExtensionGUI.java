package org.rustled.extension.ui;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.rustled.extension.api.ui.Icon;

import java.io.IOException;
import java.util.*;

public class ExtensionGUI extends JFXPanel {

    Map<Icon, Scene> iconMap = new HashMap<Icon, Scene>(); //Holds the sideicons and their respective scenes

    /**
     * Configures the primary scene of the pluginGUI. Should be executed on the JavaFX EDT
     *
     */
    public void build() {
        VBox rootLayout = new VBox();
        Pane topPane = new Pane();
        HBox bottomBox = new HBox();
        Pane pluginPane = new Pane();
        Pane iconPane = new Pane();
        rootLayout.setPrefSize(300, 623);
        topPane.setPrefSize(300, 50);
        bottomBox.setPrefSize(300, 573);
        pluginPane.setPrefSize(250, 573);
        iconPane.setPrefSize(50, 573);
        Button b1 = new Button("h");
        pluginPane.getChildren().addAll(b1);
        bottomBox.getChildren().addAll(pluginPane, iconPane);
        rootLayout.getChildren().addAll(topPane, bottomBox);

        Scene scene = new Scene(rootLayout);
        setScene(scene);
    }

    /**
     * Loads the root layout from FXML.
     *
     * @return The main {@link VBox} of the scene
     */
    private VBox getRootLayout() {
        VBox rootLayout = null;

        try {
            System.out.println(getClass().getResource("view/main_view.fxml"));
            rootLayout = FXMLLoader.load(getClass().getResource("view/main_view.fxml"));
        } catch (IOException e) {
            System.out.println("[PluginGUI] Failed to load root fx layout");
        }

        return rootLayout;
    }
}