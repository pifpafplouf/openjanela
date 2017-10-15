package openjanela.app.main;

import openjanela.commons.components.generic.GenericFrame;
import openjanela.commons.components.generic.GenericStyle;
import org.apache.log4j.Logger;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 02-23-12
 * Time: 04:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class OpenJanelaMainFrame extends GenericFrame {

    //Apache logger
    private static final Logger logger = Logger.getLogger(OpenJanelaMainFrame.class);

    //Generic Style components
    protected GenericStyle style;

    /**
     * Constructor Generic Frame
     *
     * @param name,    Project name
     * @param version, Project version
     */
    public OpenJanelaMainFrame(String name, String version) {

        //Call super constructor
        super(name, version);

        //Init components
        initComponents();
    }

    @Override
    public void initComponents() {

        //Init Style frame component
        style = new OpenJanelaStyle(this);

        //Visualize generic frame
        pack();
        validate();
        repaint();
        setVisible(true);
    }
}
