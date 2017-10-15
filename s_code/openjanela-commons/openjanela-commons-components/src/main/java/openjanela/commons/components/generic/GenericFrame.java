package openjanela.commons.components.generic;

import javax.swing.*;
import java.awt.*;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: Sherif Eldibany
 * User: Eddy Montenegro
 * Date: 02-22-12
 * Time: 11:16 PM
 */
public abstract class GenericFrame extends JFrame {

    /**
     * Content generic pane *
     */
    private JPanel contentPane;

    /**
     * Screen size frame
     */
    private Dimension screenSize;

    /**
     * Constructor Generic Frame
     *
     * @param name,    Project name
     * @param version, Project version
     */
    public GenericFrame(String name, String version) {

        //Call super constructor
        super(name + " " + version);

        //Calculate screen size
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        screenDimension.setSize(screenDimension.width, screenDimension.height - 30); //Setting size less 30px height
        screenSize = new Dimension(screenDimension.width, screenDimension.height);

        //Setting size generic frame
        setSize(new Dimension(screenSize.width, screenSize.height - 30));

        //Setting Icon image
        setIconImage(Toolkit.getDefaultToolkit().getImage(GenericFrame.class.getResource("/openjanela/resources/oj16x16.png")));

        //Config content pane
        contentPane = new JPanel(new XYLayout());
        contentPane.setSize(screenSize);

        //Setting content pane
        setContentPane(contentPane);
    }

    /**
     * Return screen size generic frame
     * @return Dimension
     */
    public Dimension getScreenSize() {
        return screenSize;
    }

    /**
     * Init components services
     */
    public abstract void initComponents();
}
