package org.openjanela.commons.util.ui;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.*;
import java.awt.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-25-13
 *          Time: 11:31 PM
 */
public class JRViewerPanel extends JDialog {

    //Jasper Viewer
    private JRViewer jrViewer;

    /**
     * Jasper Report Viewer Panel Constructor
     */
    public JRViewerPanel(JFrame parentFrame, JasperPrint jasperPrint) {

        //Call Super Constructor
        super(parentFrame, "Report Viewer", false);

        //Setting Icon Image
        if (parentFrame != null) {
            this.setIconImage(parentFrame.getIconImage());
        }

        //Setting size
        this.setSize(new Dimension(1200, 800));

        //Setting position screen
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;

        this.setLocation(x, y);

        //Init components
        initComponents(jasperPrint);

        //Setting visible
        this.setVisible(true);
    }

    /**
     * Init Components UI
     * @param jasperPrint, JasperPrint report
     */
    private void initComponents(JasperPrint jasperPrint) {

        //Setting FlowLayout
        this.setLayout(new BorderLayout());

        //Init Jasper Viewer
        jrViewer = new JRViewer(jasperPrint);

        this.getContentPane().add(jrViewer, BorderLayout.CENTER);
    }

}
