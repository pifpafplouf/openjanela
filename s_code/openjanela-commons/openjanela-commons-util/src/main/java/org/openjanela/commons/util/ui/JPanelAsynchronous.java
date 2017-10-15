package org.openjanela.commons.util.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-14-13
 *          Time: 11:55 PM
 */
public abstract class JPanelAsynchronous extends JPanel {

    public JPanelAsynchronous() {
        this.setBackground(new Color(255, 255, 255));
        this.setOpaque(false);
    }

    public JPanelAsynchronous(LayoutManager layout) {
        this.setLayout(layout);
        this.setBackground(new Color(255, 255, 255));
        this.setOpaque(false);
    }

    /**
     * Implement a refresh User Interface from this panel
     */
    public abstract void refreshUI();
}
