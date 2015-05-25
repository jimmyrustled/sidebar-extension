package org.rustled.extension.api.ui;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Icon extends Parent {

    /**
     * need to implement Toggle
     */

    private final Image defaultIcon;
    private final Image hoverIcon;
    private final Image selectedIcon;
    private final ImageView iv;

    public Icon(Image icon) {
        iv = new ImageView(icon);

        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        if(icon.getWidth() != 16)
            iv.setFitWidth(16);
        if(icon.getHeight() != 16)
            iv.setFitHeight(16);
        ColorAdjust saturate = new ColorAdjust(0, -.95, 0, 0);
        iv.setEffect(saturate);
        this.defaultIcon = iv.getImage();
        this.hoverIcon = iv.getImage();
        this.selectedIcon = iv.getImage();
    }

    private Icon(Image defaultIcon, Image hoverIcon, Image selectedIcon, Scene scene) {
        if(defaultIcon.getWidth() > 16 || defaultIcon.getHeight() > 16)
            throw new IllegalArgumentException("Default icon size too large, 16x16 required");
        if(hoverIcon.getWidth() > 16 || hoverIcon.getHeight() > 16)
            throw new IllegalArgumentException("Hover icon size too large, 16x16 required");
        if(selectedIcon.getWidth() > 16 || selectedIcon.getHeight() > 16)
            throw new IllegalArgumentException("Selected icon size too large, 16x16 requried");
        this.defaultIcon = defaultIcon;
        this.hoverIcon = hoverIcon;
        this.selectedIcon = selectedIcon;

        iv = new ImageView(defaultIcon);
        iv.setOnMouseDragOver(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                onIconHover();
            }
        });
        iv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                onIconClick();
            }
        });
    }

    private void onIconClick() {
        if(iv.getImage() == selectedIcon)
            iv.setImage(defaultIcon);
        else
            iv.setImage(selectedIcon);
    }

    private void onIconHover() {
        iv.setImage(hoverIcon);
    }
}
