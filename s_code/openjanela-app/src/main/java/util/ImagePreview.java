/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package util;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.*;

public class ImagePreview extends JComponent
        implements PropertyChangeListener {

    public ImagePreview(JFileChooser fc) {
        thumbnail = null;
        file = null;
        setPreferredSize(new Dimension(320, 240));
        fc.addPropertyChangeListener(this);
    }

    public void loadImage() {
        if (file == null)
            return;
        ImageIcon tmpIcon = new ImageIcon(file.getPath());
        int widthx = tmpIcon.getIconWidth();
        int heighty = tmpIcon.getIconHeight();
        if (widthx > 320)
            widthx = 320;
        if (heighty > 240)
            heighty = 240;
        thumbnail = new ImageIcon(tmpIcon.getImage().getScaledInstance(widthx, heighty, 1));
    }

    public void propertyChange(PropertyChangeEvent e) {
        String prop = e.getPropertyName();
        if (prop.equals("SelectedFileChangedProperty")) {
            file = (File) e.getNewValue();
            if (isShowing()) {
                loadImage();
                repaint();
            }
        }
    }

    public void paintComponent(Graphics g) {
        if (thumbnail == null)
            loadImage();
        if (thumbnail != null) {
            int x = getWidth() / 2 - thumbnail.getIconWidth() / 2;
            int y = getHeight() / 2 - thumbnail.getIconHeight() / 2;
            if (y < 0)
                y = 0;
            if (x < 5)
                x = 5;
            thumbnail.paintIcon(this, g, x, y);
        }
    }

    ImageIcon thumbnail;
    File file;
}
