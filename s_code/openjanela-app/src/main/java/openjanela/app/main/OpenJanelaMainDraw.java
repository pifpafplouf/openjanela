package openjanela.app.main;

import openjanela.app.tools.MenuBottomPanel;
import openjanela.app.tools.MenuTopPanel;
import openjanela.commons.components.generic.GenericStyle;

import javax.swing.*;
import java.awt.*;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * <p/>
 * This class configure the main draw panel
 * User: emortiz
 * Date: 02-23-12
 * Time: 04:42 PM
 */
public class OpenJanelaMainDraw extends JPanel {

    //PROPERTY NAME: GenericStyle
    private GenericStyle style;

    //PROPERTY NAME: Top tool panel
    private JPanel topToolPanel;
    //PROPERTY NAME: Botton tool panel
    private JPanel bottomToolPanel;
    //PROPERTY NAME: Right property panel
    private JPanel rightPropPanel;
    //PROPERTY NAME: Tabbed Pane
    private JTabbedPane mainTabbedPane;


    /**
     * Construct a backboard draw panel
     *
     * @param style, Generic Style
     */
    public OpenJanelaMainDraw(GenericStyle style) {

        //Setting generic style
        this.style = style;

        //Setting Layout
        setLayout(new BorderLayout());

        //Setting border
        setBorder(BorderFactory.createEtchedBorder());

        //Setting preferred size
        setPreferredSize(new Dimension(this.style.getGenericFrame().getWidth() - 250, this.style.getGenericFrame().getHeight() - 62));

        //Init components settings
        initComponents();
    }

    /**
     * Init components
     */
    private void initComponents() {

        //Setting right properties panel config
        rightPropPanel = new JPanel();
        rightPropPanel.setPreferredSize(new Dimension(250, this.style.getGenericFrame().getHeight() - 62));
        if (this.style.getGenericFrame().getWidth() <= Constants.SCREEN_DEFAULT_WIDTH)
            rightPropPanel.setPreferredSize(new Dimension(0, this.style.getGenericFrame().getHeight() - 62));

        //Setting topToolPanel properties
        topToolPanel = new JPanel(new BorderLayout());
        topToolPanel.setPreferredSize(new Dimension(500, 100));
        topToolPanel.setBorder(BorderFactory.createEtchedBorder());

        //Creating menuTopPanel
        MenuTopPanel menuTopPanel = new MenuTopPanel(this.style);
        topToolPanel.add(menuTopPanel, BorderLayout.CENTER);

        //Setting botomToolPanel properties
        bottomToolPanel = new JPanel(new BorderLayout());
        if (this.style.getGenericFrame().getHeight() <= Constants.SCREEN_HEIGHT_768)
            bottomToolPanel.setPreferredSize(new Dimension(500, 24));
        else
            bottomToolPanel.setPreferredSize(new Dimension(500, this.style.getGenericFrame().getHeight() - 768 + 24));

        //Creating menuBottomPanel
        MenuBottomPanel menuBottomPanel = new MenuBottomPanel(this.style);
        bottomToolPanel.add(menuBottomPanel, BorderLayout.NORTH);

        //Adding general panels to Main Draw
        this.add(topToolPanel, BorderLayout.NORTH);
        this.add(bottomToolPanel, BorderLayout.SOUTH);

    }

    /**
     * Init tabbed pane draw component
     */
    private void initTabbedPaneComponents() {

        mainTabbedPane = new JTabbedPane();
        mainTabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
    }
}
