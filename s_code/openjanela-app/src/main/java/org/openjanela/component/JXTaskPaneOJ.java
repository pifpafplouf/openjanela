package org.openjanela.component;

import org.jdesktop.swingx.JXTaskPane;

import java.awt.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif ElDibani
 * @author Eddy Montenegro
 * @version 2.0.8
 */
public class JXTaskPaneOJ extends JXTaskPane {

    /**
     * JXTaskPane Constructor
     */
    public JXTaskPaneOJ() {
        this.setAnimated(false);
    }

    /**
     * JXTaskPane Constructor
     *
     * @param layout, LayoutManager
     */
    public JXTaskPaneOJ(LayoutManager layout) {
        this.setAnimated(false);
        this.setLayout(layout);
    }

}
