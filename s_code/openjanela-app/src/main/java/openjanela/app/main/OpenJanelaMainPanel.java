package openjanela.app.main;

import javax.swing.*;
import java.awt.*;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * <p/>
 * This class represents the main panel configuration
 * User: emortiz
 * Date: 02-23-12
 * Time: 04:16 PM
 */
public class OpenJanelaMainPanel extends JPanel {

    /**
     * Initialize the newly created object
     */
    public OpenJanelaMainPanel() {

        //Setting preferred
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        screenDimension.setSize(screenDimension.width, screenDimension.height - 62); //Setting size less 60px height
        setPreferredSize(new Dimension(screenDimension.width, screenDimension.height));

        //Setting layout
        setLayout(new BorderLayout());

    }
}
