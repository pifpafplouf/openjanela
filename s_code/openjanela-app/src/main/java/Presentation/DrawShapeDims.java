/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Presentation;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class DrawShapeDims {

    public ShapeDimensionDialog myParent = null;

    public Graphics2D gsd;

    public JPanel drawPanel = new JPanel();

    public DrawShapeDims(final ShapeDimensionDialog dialog) {

        this.myParent = dialog;
        this.initialize();
    }

    public void initialize() {

        this.drawPanel.setPreferredSize(new Dimension(400, 400));
        this.drawPanel.setBorder(BorderFactory.createEtchedBorder());
    }

    public void paint(final Graphics g) {

        this.gsd = (Graphics2D) g;

        this.gsd.setRenderingHint(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        this.gsd.setRenderingHint(
                RenderingHints.KEY_STROKE_CONTROL,
                RenderingHints.VALUE_STROKE_PURE);
        // g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
        // RenderingHints.VALUE_STROKE_PURE);
        this.gsd.setRenderingHint(
                RenderingHints.KEY_DITHERING,
                RenderingHints.VALUE_DITHER_ENABLE);

        // this.gsd.draw(this.myParent.myParent.myParent.myShape);

    }

}
