package Presentation;

import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXTable;
import org.openjanela.component.JOpenJanelaComponent;

import javax.swing.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 03-12-13
 *          Time: 06:03 PM
 */
public class JOpenJanelaGlobalChanges extends JDialog implements JOpenJanelaComponent {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(JOpenJanelaItemDesign.class);

    //Components GUI Properties
    private JPanel pnlOrderItems;
    private JPanel pnlSeries;
    private JPanel pnlOptions;
    private JPanel pnlGlass;

    private JXTable tblOrderItems;


    @Override
    public void initComponents() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void initValueComponents() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void initListenersComponents() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
