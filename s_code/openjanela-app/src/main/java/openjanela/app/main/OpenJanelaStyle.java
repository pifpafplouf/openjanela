package openjanela.app.main;

import openjanela.commons.components.generic.GenericFrame;
import openjanela.commons.components.generic.GenericStyle;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 02-23-12
 * Time: 04:14 PM
 */
public class OpenJanelaStyle extends GenericStyle {

    //************************************************
    //PROPERTIES
    //************************************************
    private OpenJanelaMainPanel mainPanel;
    private OpenJanelaMainDraw mainDraw;

    /**
     * Creating Generic Style
     *
     * @param frame, GenericFrame
     */
    public OpenJanelaStyle(GenericFrame frame) {

        //Call super constructor
        super(frame);
    }

    @Override
    public void initialize() {

        //Initialize panel draw
        mainDraw = new OpenJanelaMainDraw(this);
    }
}
