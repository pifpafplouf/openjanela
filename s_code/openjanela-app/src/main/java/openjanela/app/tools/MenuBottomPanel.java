package openjanela.app.tools;

import openjanela.app.main.Constants;
import openjanela.commons.components.generic.GenericStyle;
import openjanela.commons.components.generic.XYConstraints;
import openjanela.commons.components.generic.XYLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 02-28-12
 * Time: 10:35 PM
 */
public class MenuBottomPanel extends JPanel {

    //PROPERTY NAME: Generic Style
    private GenericStyle style;

    //Menu bottom buttons
    private JPanel bottomButtons;
    private JPanel buttonsAdverts;

    //PROPERTY NAME: Button Save
    private JButton btnSave;
    //PROPERTY NAME: Button Cancel
    private JButton btnCancel;

    //Init Menu Botton
    public MenuBottomPanel(GenericStyle style) {

        //Setting generic style
        this.style = style;

        //Setting layout
        setLayout(new BorderLayout());

        //Setting border
        setBorder(BorderFactory.createEtchedBorder());

        //Setting preferred size
        setPreferredSize(new Dimension(500, 24));
    }

    /**
     * Init components
     */
    private void initComponents() {

         //btnSave
        btnSave = new JButton();

        //btnCancel
        btnCancel = new JButton();

        //bottomButtons panel
        bottomButtons = new JPanel();
        bottomButtons.setLayout(new XYLayout());
        bottomButtons.setPreferredSize(new Dimension(122, 20));
        bottomButtons.add(btnSave, new XYConstraints(1, 1, 60, 19));
        bottomButtons.add(btnCancel, new XYConstraints(61, 1, 60, 19));

        //bottomAdverts panel
        buttonsAdverts = new JPanel();
        buttonsAdverts.setLayout(new BorderLayout());
        buttonsAdverts.setPreferredSize(new Dimension(500, this.getHeight() - bottomButtons.getHeight()));
    }

    /**
     * Putting components location
     */
    private void puttingComponents() {

        //Adding buttons panel
        this.add(bottomButtons, BorderLayout.NORTH);

        //Adding buttons adverts
        if (style.getGenericFrame().getHeight() > Constants.SCREEN_HEIGHT_768)
            this.add(buttonsAdverts, BorderLayout.CENTER);

    }
}
