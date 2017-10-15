package Presentation;

import Model.OpeningObject;
import Model.ProfileParts.Profiles;
//import com.keypoint.PngEncoder;
import com.objectplanet.image.PngEncoder;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 12/22/13
 *          Time: 9:04 PM
 */
public class DrawImageRequest extends JPanel {

    //Apache Log4j
    private static final Logger logger = Logger.getLogger(DrawImage.class);

    //Graphics 2D Implementation
    private Graphics2D g2;

    //Default Font Value
    private Font font;

    //Frame Main Principal
    private ItemFrame myFrame;

    //******************************************************************************************************************
    //Drawing variables
    //******************************************************************************************************************

    //Identify OpenJanela Model Object to draw
    private Object drawObject = null;

    //Draw Glass Design
    private boolean drawGlass = false;

    /**
     * Draw Image Request Construction Panel
     *
     * @param myFrame, ItemFrame
     */
    public DrawImageRequest(ItemFrame myFrame) {
        this.myFrame = myFrame;
    }

    @Override
    public void paint(Graphics g) {

        //Init Graphics 2D
        g2 = (Graphics2D) g;

        //Init Font Value
        initFont();

        //1. Draw Glass Design
        if (drawGlass) {
            drawGlass(drawObject);
        }
    }

    /**
     * Paint Graphics to Image
     *
     * @param drawObject, OpeningObject Model to draw
     * @return byte[]
     */
    public byte[] drawImageGlass(Object drawObject) {

        // Setting drawing only glass [TRUE]
        this.drawGlass = true;

        // Setting object to draw
        this.drawObject = drawObject;

        BufferedImage awtImage = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
        Graphics g = awtImage.getGraphics();
        this.paint(g);

        // Conver to PNG format and save into byte[] array
        PngEncoder encoder = new PngEncoder(PngEncoder.COLOR_TRUECOLOR_ALPHA);

        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            encoder.encode(awtImage, out);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return out.toByteArray();
    }

    //******************************************************************************************************************
    //Private Drawing Methods
    //******************************************************************************************************************

    /**
     * Get fonts configuration
     */
    private void initFont() {

        font = new Font("SansSerif", 0, 9);

        if (myFrame.facetUsed != null) {
            if (myFrame.facetUsed.bOpeningObject.xCols >= 5) {
                font = new Font("SansSerif", 0, 8);
            }
            if (myFrame.facetUsed.bOpeningObject.xCols >= 7) {
                font = new Font("SansSerif", 0, 8);
            }
            if (myFrame.facetUsed.bOpeningObject.xCols >= 9) {
                font = new Font("SansSerif", 0, 7);
            }
            if (myFrame.facetUsed.bOpeningObject.xCols >= 10) {
                font = new Font("SansSerif", 0, 6);
            }
            if (myFrame.facetUsed.bOpeningObject.xCols >= 12) {
                font = new Font("SansSerif", 0, 5);
            }
        }

    }

    /**
     * Drawing glass object
     *
     * @param O , OpeningObject
     */
    private void drawGlass(Object O) {

        if (((OpeningObject) O).contentIn == 1 && ((OpeningObject) O).myGlassIn != null) {

            if (((OpeningObject) O).myGlassIn.glazingType != 0 && !((OpeningObject) O).unGlazed) {

                if (((OpeningObject) O).dloIn.hasGrids) {
                    this.doGrids(O);
                }

                g2.setColor(Color.DARK_GRAY);

                new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{3}, 0);

                g2.draw(((OpeningObject) O).myGlassIn.gp);
                g2.setPaint(new Color(235, 235, 240, 64));
                g2.fill(((OpeningObject) O).myGlassIn.gp);

                if (((OpeningObject) O).dloIn.masterW && this.myFrame.dim.showGridMaster.isSelected()) {
                    String masterW = "V";
                    FontRenderContext frc = g2.getFontRenderContext();

                    TextLayout view = new TextLayout(masterW, font, frc);
                    g2.setColor(Color.BLUE);
                    view.draw(g2, (float) (((OpeningObject) O).startingXA + 10), (float) (((OpeningObject) O).startingYA + 10));
                }

                if (((OpeningObject) O).dloIn.masterH && this.myFrame.dim.showGridMaster.isSelected()) {

                    String masterW = "H";
                    FontRenderContext frc = g2.getFontRenderContext();

                    TextLayout view = new TextLayout(masterW, font, frc);
                    g2.setColor(Color.BLUE);
                    view.draw(g2, (float) (((OpeningObject) O).startingXA + 12), (float) (((OpeningObject) O).startingYA + 10));
                }
            }
        }

        if (((OpeningObject) O).contentMid == 1 && ((OpeningObject) O).myGlassMid != null) {

            if (((OpeningObject) O).myGlassMid.glazingType != 0 && !((OpeningObject) O).unGlazed) {

                if (((OpeningObject) O).dloMid.hasGrids) {
                    this.doGrids(O);
                }

                g2.setPaint(new Color(200, 200, 200, 64));
                g2.fill(((OpeningObject) O).myGlassMid.gp);

                if (((OpeningObject) O).dloMid.masterW && !((OpeningObject) O).dloMid.masterH &&
                        this.myFrame.dim.showGridMaster.isSelected()) {

                    String masterW = "|";
                    FontRenderContext frc = g2.getFontRenderContext();

                    TextLayout view = new TextLayout(masterW, font, frc);
                    g2.setColor(Color.RED);
                    view.draw(g2, (float) (((OpeningObject) O).startingXA + 12), (float) (((OpeningObject) O).startingYA + 10));
                }

                if (((OpeningObject) O).dloMid.masterH && !((OpeningObject) O).dloMid.masterW &&
                        this.myFrame.dim.showGridMaster.isSelected()) {

                    String masterW = "---";
                    FontRenderContext frc = g2.getFontRenderContext();

                    final TextLayout view = new TextLayout(masterW, font, frc);
                    g2.setColor(Color.RED);
                    view.draw(g2, (float) (((OpeningObject) O).startingXA + 12), (float) (((OpeningObject) O).startingYA + 10));
                }
                if (((OpeningObject) O).dloMid.masterH && ((OpeningObject) O).dloMid.masterW &&
                        this.myFrame.dim.showGridMaster.isSelected()) {

                    String masterW = "-|-";
                    FontRenderContext frc = g2.getFontRenderContext();

                    final TextLayout view = new TextLayout(masterW, font, frc);
                    g2.setColor(Color.RED);
                    view.draw(g2, (float) (((OpeningObject) O).startingXA + 12), (float) (((OpeningObject) O).startingYA + 10));
                }
            }
        }

        if (((OpeningObject) O).contentOut == 1 && ((OpeningObject) O).myGlassOut != null) {

            if (((OpeningObject) O).myGlassOut.glazingType != 0 && !((OpeningObject) O).unGlazed) {

                if (((OpeningObject) O).dloOut.hasGrids) {
                    this.doGrids(O);
                }

                g2.setColor(Color.DARK_GRAY);
                new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{3}, 0);

                g2.draw(((OpeningObject) O).myGlassOut.gp);
                g2.setPaint(new Color(235, 235, 240, 64));
                g2.fill(((OpeningObject) O).myGlassOut.gp);

                if (((OpeningObject) O).dloOut.masterW && this.myFrame.dim.showGridMaster.isSelected()) {

                    String masterW = "V";
                    FontRenderContext frc = g2.getFontRenderContext();

                    TextLayout view = new TextLayout(masterW, font, frc);
                    g2.setColor(Color.BLUE);
                    view.draw(g2, (float) (((OpeningObject) O).startingXA + 10), (float) (((OpeningObject) O).startingYA + 10));
                }

                if (((OpeningObject) O).dloOut.masterH && this.myFrame.dim.showGridMaster.isSelected()) {

                    String masterW = "H";
                    FontRenderContext frc = g2.getFontRenderContext();

                    final TextLayout view = new TextLayout(masterW, font, frc);
                    g2.setColor(Color.BLUE);
                    view.draw(g2, (float) (((OpeningObject) O).startingXA + 12), (float) (((OpeningObject) O).startingYA + 10));
                }
            }
        }
    }

    /**
     * Do draw glass for opening object
     *
     * @param O2 , Object
     */
    private void doGrids(Object O2) {

        //Draw Grids Spokes
        this.drawSpokes(((OpeningObject) O2).dloMid.gridPartsS.toArray());

        //Draw Grids Horizontals
        this.drawGrids(((OpeningObject) O2).dloMid.bOpeningObject.mullionsH.toArray());

        for (Object h : ((OpeningObject) O2).dloMid.bOpeningObject.mullionsH.toArray()) {
            this.drawSelectedMullions(h, true);
        }

        //Draw Grids Verticals
        this.drawGrids(((OpeningObject) O2).dloMid.bOpeningObject.mullions.toArray());

        for (Object v : ((OpeningObject) O2).dloMid.bOpeningObject.mullions.toArray()) {
            this.drawSelectedMullions(v, true);
        }
    }

    /**
     * Drawing spokes
     *
     * @param parts , Object[]
     */
    private void drawSpokes(Object[] parts) {

        for (Object p : parts) {

            Profiles profile = (Profiles) p;

            if (!profile.remove) {

                if (profile.partForm == 1) {
                    g2.setColor(new Color(profile.rgb_R, profile.rgb_G, profile.rgb_B, 255));
                    g2.fill(profile.gp);
                    g2.setColor(Color.black);
                    g2.draw(profile.gp);

                } else if (profile.profileSelected == 1 && profile.partForm == 1) {
                    g2.setColor(new Color(255, 0, 0, 64));
                    g2.fill(profile.gp);
                    g2.setColor(Color.black);
                    g2.draw(profile.gp);

                } else if (profile.profileSelected == 1 && profile.partForm == 1) {
                    g2.setColor(new Color(255, 0, 0, 64));
                    g2.fill(profile.gp);
                    g2.setColor(Color.black);
                    g2.draw(profile.gp);
                }

                g2.setColor(Color.black);
                g2.setStroke(new BasicStroke());
            }
        }
    }

    /**
     * Drawing grids parts from background opening object from DLO
     *
     * @param parts , Object[]
     */
    private void drawGrids(Object[] parts) {

        for (Object p : parts) {

            Profiles profile = (Profiles) p;

            if (!profile.remove) {

                if (profile.partForm == 1) {
                    g2.setColor(new Color(profile.rgb_R, profile.rgb_G, profile.rgb_B, 255));
                    g2.fill(profile.gp);

                    g2.setColor(Color.black);
                    g2.draw(profile.gp);

                } else if (profile.partForm > 1) {
                    g2.setColor(new Color(profile.rgb_R, profile.rgb_G, profile.rgb_B, profile.transp));
                    g2.draw(profile.gp);

                    g2.setColor(Color.black);
                    g2.draw(profile.curveB);
                    g2.draw(profile.curveBA);
                    g2.draw(profile.curveA);
                }

                g2.setColor(Color.black);
                g2.setStroke(new BasicStroke());
            }
        }
    }

    /**
     * Draw Selected Mullions
     *
     * @param M      , Object
     * @param isGrid , is a Grid
     */
    private void drawSelectedMullions(Object M, final boolean isGrid) {

        if (((Profiles) M).profileSelected == 1) {

            Polygon m = ((Profiles) M).poly;
            if (!isGrid) {
                g2.setColor(new Color(255, 0, 0, 64));
            } else {
                g2.setColor(new Color(255, 0, 0, 200));
            }

            g2.fill(m);
            g2.setColor(Color.black);
            g2.setStroke(new BasicStroke());

        } else if (((Profiles) M).profileSelected == 2) {

            Polygon m = ((Profiles) M).poly;

            if (!isGrid) {
                g2.setColor(new Color(0, 255, 0, 64));
            } else {
                g2.setColor(new Color(0, 255, 0, 200));
            }

            g2.fill(m);
            g2.setColor(Color.black);
            g2.setStroke(new BasicStroke());
        } else if (((Profiles) M).potentialS) {

            Polygon m = ((Profiles) M).poly;

            if (!isGrid) {
                g2.setColor(new Color(0, 0, 255, 64));
            } else {
                g2.setColor(new Color(0, 0, 255, 200));
            }

            g2.fill(m);
            g2.setColor(Color.black);
            g2.setStroke(new BasicStroke());
        }
    }
}
