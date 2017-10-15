package Presentation;

import Model.*;
import Model.Frame;
import Model.ProfileParts.Profiles;
import com.objectplanet.image.PngEncoder;
import openjanela.model.entities.design.ConstructionMap;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 * <p/>
 * This Method implement a Draw Image Method for Assemblies and Job Item to Images
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 10/7/13
 *          Time: 1:08 PM
 */
public class DrawImage extends JPanel {

    //Apache Log4j
    private static final Logger logger = Logger.getLogger(DrawImage.class);

    //Graphics 2D Implementation
    private Graphics2D g2;

    //Default Font Value
    private Font font;

    //Current Rectangle
    private Rectangle currentRect = null;

    //Frame Main Principal
    private ItemFrame myFrame;

    //******************************************************************************************************************
    //*****************************************<Draw Properties>********************************************************
    //******************************************************************************************************************

    // Construction map for draw
    private ConstructionMap constructionMap = null;

    // Indicate if draw an image frame
    public boolean drawImage = true;

    // Indicate if shape object found for assembly
    public boolean drawAssembly = false;


    /**
     * Draw Image Application Panel
     *
     * @param myFrame, ItemFrame
     */
    public DrawImage(ItemFrame myFrame) {
        this.myFrame = myFrame;
    }

    @Override
    public void paint(Graphics g) {

        //Init Graphics 2D
        g2 = (Graphics2D) g;

        //Init Font Value
        initFont();

        //Draw Facet
        drawFacet();
    }

    /**
     * Paint Graphics to Image
     *
     * @return byte[]
     */
    public byte[] drawImage(ConstructionMap constructionMap) {

        // Setting drawing only assemblies [TRUE]
        this.drawAssembly = true;

        // Setting Construction Map to Draw
        this.constructionMap = constructionMap;

        BufferedImage awtImage = new BufferedImage(750, 600, BufferedImage.TYPE_INT_ARGB);
        Graphics g = awtImage.getGraphics();
        this.paint(g);

        // Conver to PNG format and save into byte[] array
        PngEncoder pngEncoder = new PngEncoder(PngEncoder.COLOR_TRUECOLOR_ALPHA);

        //Convert to Byte Array
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            pngEncoder.encode(awtImage, out);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return out.toByteArray();
    }

    //******************************************************************************************************************
    //******************************************<Draw Image Methods>****************************************************
    //******************************************************************************************************************

    /**
     * Draw Facets Shape Object
     */
    public void drawFacet() {

        // ******************************************************
        // Drawing Facet Shape Object
        // ******************************************************
        for (Object object : this.myFrame.jobItem.design.frames) {

            // Return Facet Object
            Facet facet = (Facet) object;

            //Evaluate if for shape selected
            boolean isForShape = facet.isForShape(this.constructionMap);

            // Drawing profiles curves
            this.drawProfilesCurves(isForShape, facet.partObjects.toArray());

            // Drawing profiles
            this.drawProfiles(isForShape, facet.partObjects.toArray());

            // Drawing couplers for Facet Object
            this.drawCouplers(facet);

            // Draw Coupler for Overall Object
            this.drawCouplers(this.myFrame.jobItem.design);

            // Drawing mullions selected
            this.drawMullionsSelected(facet, false);

            // ***************************************************
            // Drawing Frame Shape Object
            // ***************************************************
            if (this.myFrame.jobItem.viewOut) {
                drawFrame(facet);
                drawFrameSelected(facet);
            }

            // ***************************************************
            // Setting Default Values Configuration
            // ***************************************************
            Stroke drawingStroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{2}, 0);

            if (this.myFrame.alignClicks == 2) {
                g2.setStroke(drawingStroke);
                g2.setColor(Color.RED);
                g2.draw(this.myFrame.facetUsed.myLine);
                g2.setStroke(new BasicStroke());
            }

            if (this.myFrame.alignSeq == 2) {
                this.myFrame.dim.doAlign.setEnabled(true);
            }
        }
    }

    /**
     * Draw Frames Shape Object Model
     *
     * @param facet , Facet
     */
    public void drawFrame(Facet facet) {

        // ***************************************************
        // Setting Default Values Configuration
        // ***************************************************
        if (this.currentRect != null && this.currentRect.width > 0 && this.currentRect.height > 0) {
            g2.setColor(Color.BLUE);
            g2.draw(currentRect);

            g2.setColor(new Color(255, 255, 255, 64));
            g2.setStroke(new BasicStroke(2));
        }

        // ***************************************************
        // Init Frames Values Collection
        // ***************************************************
        for (Object object : facet.frames) {

            // Get Frame Object Model
            Frame frame = (Frame) object;

            if (frame.shapeID != 10) {

                // *********************************************************************
                // Setting draw assembly true
                // *********************************************************************
                boolean isForFrame = frame.isForFrame(this.drawAssembly, this.constructionMap);

                if (!isForFrame) {
                    continue;
                }

                if (this.drawAssembly && isForFrame) {

                    // Draw Image setting false
                    this.drawImage = true;
                }

                // *******************************************************************
                // Do Open in Sash Object
                // *******************************************************************
                for (Object opening : frame.openings) {

                    //Do Open In Sash
                    this.doOpenInSash(frame, opening);

                    //Draw Glass for Frame Object
                    if (((OpeningObject) opening).contentMid != 3) {
                        this.drawGlass(opening);
                    }
                }

                // Preparing draw inter locks
                if (!frame.glazedout) {
                    this.prepareDrawInterlocks(frame);
                }

                // *******************************************************************
                // Drawing part objects from Frame object
                // *******************************************************************
                boolean isForShape = frame.isForShape(this.constructionMap);

                if (frame.partObjects != null && frame.partObjects.size() > 0) {
                    this.drawProfilesCurves(isForShape, frame.partObjects.toArray());
                    this.drawProfiles(isForShape, frame.partObjects.toArray());
                }

                // *******************************************************************
                // Drawing mullions from Frame object
                // *******************************************************************
                if (frame.bOpeningObject != null &&
                        (frame.bOpeningObject.mullions != null || frame.bOpeningObject.mullionsH != null) &&
                        (frame.bOpeningObject.mullions.size() > 0 || frame.bOpeningObject.mullionsH.size() > 0)) {
                    this.drawMullions(frame);
                }

                if (frame.glazedout) {
                    this.prepareDrawInterlocks(frame);
                }

                // Draw fixed pane slider beads
                this.drawFixedPaneSliderBeads(frame);

                // *******************************************************************
                // Drawing opening from Frame Object
                // *******************************************************************
                for (Object opening : frame.openings) {

                    if (((OpeningObject) opening).contentMid != 3) {
                        doOpenOutSash(opening);
                    } else {

                        // Get frames from subfacet in opening object
                        Object[] subFrames = ((OpeningObject) opening).subFacet.frames.toArray();

                        for (Object subFrame : subFrames) {

                            if (((Frame) subFrame).shapeID != 10) {

                                // Get openings from subFrame
                                Object[] subFrameOpenings = ((Frame) subFrame).openings.toArray();

                                // **************************************************
                                // Draw Open in sash
                                // **************************************************
                                for (Object subFrameOpening : subFrameOpenings) {
                                    doOpenInSash(subFrame, subFrameOpening);
                                }

                                // **************************************************
                                // Draw SubFrame opening
                                // **************************************************
                                for (Object subFrameOpening : subFrameOpenings) {
                                    if (((OpeningObject) subFrameOpening).contentMid != 3) {
                                        this.drawGlass(subFrameOpening);
                                    }
                                }

                                // Preparing draw interlocks
                                this.prepareDrawInterlocks(subFrame);

                                // **************************************************
                                // Draw Parts object from SubFrame
                                // **************************************************
                                //Evaluate if for shape selected
                                boolean isForSubFrameShape = ((Frame) subFrame).isForShape(this.constructionMap);

                                if (((Frame) subFrame).partObjects != null && ((Frame) subFrame).partObjects.size() > 0) {
                                    this.drawProfilesCurves(isForSubFrameShape, ((Frame) subFrame).partObjects.toArray());
                                    this.drawProfiles(isForSubFrameShape, ((Frame) subFrame).partObjects.toArray());
                                }

                                // **************************************************
                                // Draw Mullions from BkgrdOpening object
                                // **************************************************
                                if (((Frame) subFrame).bOpeningObject != null &&
                                        (((Frame) subFrame).bOpeningObject.mullions != null ||
                                                ((Frame) subFrame).bOpeningObject.mullionsH != null)) {
                                    this.drawMullions((Frame) subFrame);
                                }

                                // Draw Fixed pane slider beads
                                this.drawFixedPaneSliderBeads(subFrame);

                                // *************************************************
                                // Do Open out sash
                                // *************************************************
                                for (Object subFrameOpening : subFrameOpenings) {
                                    doOpenOutSash(subFrameOpening);
                                }
                            }
                        }
                    }
                }

                // ******************************************************************
                // Frame found - stop loop
                // ******************************************************************
                if (drawImage) {
                    break;
                }
            }
        }
    }

    /**
     * Draw Frames Shape Object Model Selected
     *
     * @param facet , Facet
     */
    public void drawFrameSelected(Facet facet) {

        for (Object object : facet.frames) {

            // Get Frame Object
            Frame frame = (Frame) object;

            if (frame.shapeID != 10) {

                // *********************************************************************
                // Setting draw assembly true
                // *********************************************************************
                boolean isForFrame = frame.isForFrame(this.drawAssembly, this.constructionMap);

                if (!isForFrame) {
                    continue;
                }

                if (this.drawAssembly && isForFrame) {

                    // Draw Image setting false
                    this.drawImage = true;
                }

                this.drawMullionsSelected(frame, false);

                // Get array of openings from frame object
                Object[] openingObjects = frame.openings.toArray();

                for (Object O : openingObjects) {

                    // Opening sash in object
                    if (((OpeningObject) O).sashObjectIn != null) {

                        // getting frames from sashIn object
                        Object[] sash = ((OpeningObject) O).sashObjectIn.frames.toArray();

                        // Drawing sashes
                        this.drawSashes(sash, true);
                    }

                    // Opening sash mid object
                    if (((OpeningObject) O).sashObjectMid != null) {

                        // getting frames from sashMid object
                        Object[] sash = ((OpeningObject) O).sashObjectMid.frames.toArray();

                        // Drawing sashes
                        this.drawSashes(sash, true);

                    }

                    // Opening sash out object
                    if (((OpeningObject) O).sashObjectOut != null) {

                        // getting frames from sashOut object
                        Object[] sash = ((OpeningObject) O).sashObjectOut.frames.toArray();

                        // Drawing sashes
                        this.drawSashes(sash, true);

                    } else {
                        // drawGlazingBeads(O);
                    }
                }

                // *********************************************************************
                // Setting draw assembly true
                // *********************************************************************
                if (drawImage) {
                    break;
                }
            }
        }
    }

    /**
     * Do Open Out Sash
     *
     * @param O, OpeningObject
     */
    public void doOpenOutSash(Object O) {

        if (((OpeningObject) O).sashObjectIn != null && ((OpeningObject) O).contentIn == 2 &&
                ((OpeningObject) O).sashObjectIn.opens == 1) {
            Object[] sash = ((OpeningObject) O).sashObjectIn.frames.toArray();

            this.drawSashes(sash, false);

        } else if (((OpeningObject) O).contentIn == 1) {
            this.drawGlazingBeads(O);
        }

        if (((OpeningObject) O).sashObjectMid != null && ((OpeningObject) O).contentMid == 2 &&
                ((OpeningObject) O).sashObjectMid.opens == 1) {
            Object[] sash = ((OpeningObject) O).sashObjectMid.frames.toArray();
            this.drawSashes(sash, false);
        } else if (((OpeningObject) O).contentMid == 1) {
            this.drawGlazingBeads(O);
        }

        if (((OpeningObject) O).sashObjectOut != null && ((OpeningObject) O).contentOut == 2 &&
                ((OpeningObject) O).sashObjectOut.opens == 1) {
            Object[] sash = ((OpeningObject) O).sashObjectOut.frames.toArray();
            this.drawSashes(sash, false);
        } else if (((OpeningObject) O).contentOut == 1) {
            this.drawGlazingBeads(O);
        }
    }

    /**
     * Do Open In Sash
     *
     * @param f, FrameObject
     * @param o, OpeningObject
     */
    public void doOpenInSash(Object f, Object o) {

        OpeningObject opening = (OpeningObject)o;

        if (opening.sashObjectIn != null && opening.contentIn == 2 && opening.sashObjectIn.opens >= 2) {

            Object[] sash = opening.sashObjectIn.frames.toArray();
            this.drawSashes(sash, false);
        } else if (opening.contentIn == 1) {
            this.drawGlazingBeads(opening);
        }

        if (opening.sashObjectMid != null && opening.contentMid == 2 && opening.sashObjectMid.opens >= 2) {

            Object[] sash = opening.sashObjectMid.frames.toArray();
            this.drawSashes(sash, false);
            this.prepareDrawAstragalsOut(f);
        } else if (opening.contentMid == 1) {
            this.drawGlazingBeads(opening);
        }

        if (opening.sashObjectOut != null && opening.contentOut == 2 && opening.sashObjectOut.opens >= 2) {
            Object[] sash = opening.sashObjectOut.frames.toArray();
            this.drawSashes(sash, false);
        } else if (opening.contentOut == 1) {
            this.drawGlazingBeads(opening);
        }
    }

    public void prepareDrawInterlocks(Object F) {

        Object[] openings = ((ShapeObject) F).openings.toArray();

        for (final Object O : openings) {
            if (((OpeningObject) O).sashObjectIn != null && ((OpeningObject) O).contentIn == 2 &&
                    (((OpeningObject) O).sashObjectIn.opens == 1 || ((OpeningObject) O).sashObjectIn.opens == 3 ||
                            ((OpeningObject) O).sashObjectIn.opens == 4)) {
                if (((OpeningObject) O).sashObjectIn.sashClassType >= 11 && ((OpeningObject) O).sashObjectIn.sashClassType <= 50
                        || ((OpeningObject) O).sashObjectIn.sashClassType >= 70) {
                    Object[] openingOb = ((OpeningObject) O).sashObjectIn.openings.toArray();

                    for (Object o : openingOb) {
                        this.drawGlass(o);
                    }

                    this.drawInterLocks(((OpeningObject) O).sashObjectIn.bOpeningObject);
                }
            }

            if (((OpeningObject) O).sashObjectMid != null
                    && ((OpeningObject) O).contentMid == 2 && (((OpeningObject) O).sashObjectMid.opens == 1
                    || ((OpeningObject) O).sashObjectMid.opens == 3 || ((OpeningObject) O).sashObjectMid.opens == 4)) {

                if (((OpeningObject) O).sashObjectMid.sashClassType >= 11 && ((OpeningObject) O).sashObjectMid.sashClassType <= 50
                        || ((OpeningObject) O).sashObjectMid.sashClassType >= 70) {
                    final Object[] so = ((OpeningObject) O).sashObjectMid.openings.toArray();

                    for (final Object o : so) {
                        this.drawGlass(o);
                    }

                    this.drawInterLocks(((OpeningObject) O).sashObjectMid.bOpeningObject);
                }
            }

            if (((OpeningObject) O).sashObjectOut != null && ((OpeningObject) O).contentOut == 2
                    && (((OpeningObject) O).sashObjectOut.opens == 1 || ((OpeningObject) O).sashObjectOut.opens == 3 ||
                    ((OpeningObject) O).sashObjectOut.opens == 4)) {

                if (((OpeningObject) O).sashObjectOut.sashClassType >= 11 &&
                        ((OpeningObject) O).sashObjectOut.sashClassType <= 50 ||
                        ((OpeningObject) O).sashObjectOut.sashClassType >= 70) {

                    Object[] so = ((OpeningObject) O).sashObjectOut.openings.toArray();

                    for (final Object o : so) {
                        this.drawGlass(o);
                    }

                    this.drawInterLocks(((OpeningObject) O).sashObjectOut.bOpeningObject);
                }
            }
        }
    }

    public void prepareDrawAstragalsOut(Object F) {

        Object[] ops = ((ShapeObject) F).openings.toArray();
        for (Object O : ops) {
            if (((OpeningObject) O).sashObjectIn != null && ((OpeningObject) O).contentIn == 2 &&
                    ((OpeningObject) O).sashObjectIn.opens == 2) {

                if (((OpeningObject) O).sashObjectIn.sashClassType >= 11 &&
                        ((OpeningObject) O).sashObjectIn.sashClassType <= 50 ||
                        ((OpeningObject) O).sashObjectIn.sashClassType >= 70) {
                    this.drawInterLocks(((OpeningObject) O).sashObjectIn.bOpeningObject);
                }
            }

            if (((OpeningObject) O).sashObjectMid != null && ((OpeningObject) O).contentMid == 2 &&
                    ((OpeningObject) O).sashObjectMid.opens == 2) {

                if (((OpeningObject) O).sashObjectMid.sashClassType >= 11 &&
                        ((OpeningObject) O).sashObjectMid.sashClassType <= 50 ||
                        ((OpeningObject) O).sashObjectMid.sashClassType >= 70) {
                    this.drawInterLocks(((OpeningObject) O).sashObjectMid.bOpeningObject);
                }
            }

            if (((OpeningObject) O).sashObjectOut != null && ((OpeningObject) O).contentOut == 2 &&
                    ((OpeningObject) O).sashObjectOut.opens == 2) {
                if (((OpeningObject) O).sashObjectOut.sashClassType >= 11 &&
                        ((OpeningObject) O).sashObjectOut.sashClassType <= 50 ||
                        ((OpeningObject) O).sashObjectOut.sashClassType >= 70) {
                    this.drawInterLocks(((OpeningObject) O).sashObjectOut.bOpeningObject);
                }
            }
        }
    }

    public void drawFixedPaneSliderBeads(Object F) {

        Object[] ops = ((ShapeObject) F).openings.toArray();
        for (Object O : ops) {
            if (((OpeningObject) O).sashObjectIn != null && ((OpeningObject) O).contentIn == 2 &&
                    (((OpeningObject) O).sashObjectIn.opens == 1 || ((OpeningObject) O).sashObjectIn.opens == 3 ||
                            ((OpeningObject) O).sashObjectIn.opens == 4)) {
                if (((OpeningObject) O).sashObjectIn.sashClassType >= 11 || ((OpeningObject) O).sashObjectIn.sashClassType <= 40) {
                    Object[] ops2 = ((OpeningObject) O).sashObjectIn.openings.toArray();
                    for (Object o : ops2) {
                        this.drawGlazingBeads(o);
                    }
                }

            }
            if (((OpeningObject) O).sashObjectMid != null && (((OpeningObject) O).sashObjectMid.opens == 1 ||
                    ((OpeningObject) O).sashObjectMid.opens == 3 || ((OpeningObject) O).sashObjectMid.opens == 4)) {

                if (((OpeningObject) O).sashObjectMid.sashClassType >= 11 ||
                        ((OpeningObject) O).sashObjectMid.sashClassType <= 40) {
                    Object[] so = ((OpeningObject) O).sashObjectMid.openings.toArray();
                    for (Object o : so) {
                        this.drawGlazingBeads(o);
                    }
                }

            }
            if (((OpeningObject) O).sashObjectOut != null && ((OpeningObject) O).contentOut == 2
                    && (((OpeningObject) O).sashObjectOut.opens == 1 || ((OpeningObject) O).sashObjectMid.opens == 3 ||
                    ((OpeningObject) O).sashObjectMid.opens == 4)) {
                if (((OpeningObject) O).sashObjectOut.sashClassType >= 11 ||
                        ((OpeningObject) O).sashObjectOut.sashClassType <= 40) {
                    Object[] so = ((OpeningObject) O).sashObjectOut.openings.toArray();
                    for (Object o : so) {
                        this.drawGlazingBeads(o);
                    }
                }
            }
        }
    }

    /**
     * Drawing glass object
     *
     * @param O , OpeningObject
     */
    public void drawGlass(Object O) {

        if (((OpeningObject) O).contentIn == 1 && ((OpeningObject) O).myGlassIn != null) {

            if (((OpeningObject) O).myGlassIn.glazingType != 0 && !((OpeningObject) O).unGlazed) {

                if (((OpeningObject) O).dloIn.hasGrids) {
                    this.doGrids(O);
                }

                //Init Color from Glass Configuration
                Color color = new Color(235, 235, 240, 64);

                if (((OpeningObject) O).myGlassIn.r_rgb != 0 || ((OpeningObject) O).myGlassIn.g_rgb != 0 ||
                        ((OpeningObject) O).myGlassIn.b_rgb != 0 || ((OpeningObject) O).myGlassIn.a_rgb != 0) {
                    color = new Color(((OpeningObject) O).myGlassIn.r_rgb, ((OpeningObject) O).myGlassIn.g_rgb,
                            ((OpeningObject) O).myGlassIn.b_rgb, ((OpeningObject) O).myGlassIn.a_rgb);
                }

                g2.setColor(color);

                new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{3}, 0);

                g2.draw(((OpeningObject) O).myGlassIn.gp);
                g2.setPaint(color);
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

                //Init Color from Glass Configuration
                Color color = new Color(200, 200, 200, 64);

                if (((OpeningObject) O).myGlassMid.r_rgb != 0 || ((OpeningObject) O).myGlassMid.g_rgb != 0 ||
                        ((OpeningObject) O).myGlassMid.b_rgb != 0 || ((OpeningObject) O).myGlassMid.a_rgb != 0) {
                    color = new Color(((OpeningObject) O).myGlassMid.r_rgb, ((OpeningObject) O).myGlassMid.g_rgb,
                            ((OpeningObject) O).myGlassMid.b_rgb, ((OpeningObject) O).myGlassMid.a_rgb);
                }

                g2.setColor(color);

                g2.setPaint(color);
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

                new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{3}, 0);

                Color color = new Color(235, 235, 240, 64);

                if (((OpeningObject) O).myGlassOut.r_rgb != 0 || ((OpeningObject) O).myGlassOut.g_rgb != 0 ||
                        ((OpeningObject) O).myGlassOut.b_rgb != 0 || ((OpeningObject) O).myGlassOut.a_rgb != 0) {
                    color = new Color(((OpeningObject) O).myGlassOut.r_rgb, ((OpeningObject) O).myGlassOut.g_rgb,
                            ((OpeningObject) O).myGlassOut.b_rgb, ((OpeningObject) O).myGlassOut.a_rgb);
                }

                g2.draw(((OpeningObject) O).myGlassOut.gp);
                g2.setPaint(color);
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
     * Drawing couplers
     *
     * @param facet , Facet
     */
    public void drawCouplers(Facet facet) {

        // Get array of verticals mullions
        facet.bOpeningObject.mullionObjectsV = facet.bOpeningObject.mullions.toArray();

        // Get array of horizontal mullions
        facet.bOpeningObject.mullionObjectsH = facet.bOpeningObject.mullionsH.toArray();

        // Drawing horizontal couplers or mullions
        drawHC(facet);

        // Drawing Vertical coupler or mullions
        drawVC(facet);
    }

    /**
     * Draw Vertical coupler
     *
     * @param facet, Facet
     */
    public void drawVC(Facet facet) {

        for (Object v : facet.bOpeningObject.mullionObjectsV) {

            Profiles profile = (Profiles) v;

            if (profile.isValid) {
                g2.setColor(new Color(profile.rgb_R, profile.rgb_G, profile.rgb_B, profile.transp));
                g2.fill(profile.gp);
                g2.setColor(Color.black);
                g2.draw(profile.gp);

                if (profile.profileSelected == 1) {
                    g2.setColor(new Color(255, 0, 0, 64));
                    g2.fill(profile.poly);
                    g2.setColor(Color.black);
                    g2.draw(profile.poly);
                    g2.setColor(Color.black);
                    g2.setStroke(new BasicStroke());
                }
            }
        }
    }

    /**
     * Drawing horizontal coupler or mullions
     *
     * @param facet, Facet
     */
    public void drawHC(Facet facet) {

        for (Object h : facet.bOpeningObject.mullionObjectsH) {

            Profiles profile = (Profiles) h;

            if (profile.isValid) {

                g2.setColor(new Color(profile.rgb_R, profile.rgb_G, profile.rgb_B, profile.transp));
                g2.fill(profile.gp);
                g2.setColor(Color.black);
                g2.draw(profile.gp);

                if (profile.profileSelected == 1) {
                    g2.setColor(new Color(255, 0, 0, 64));
                    g2.fill(profile.poly);
                    g2.setColor(Color.black);
                    g2.draw(profile.poly);
                    g2.setColor(Color.black);
                    g2.setStroke(new BasicStroke());
                }
            }
        }
    }

    /**
     * Drawing couplers from BkgrdOpening Object
     *
     * @param overall , Overall
     */
    public void drawCouplers(Overall overall) {

        overall.bOpeningObject.mullionObjectsV = overall.bOpeningObject.mullions.toArray();
        overall.bOpeningObject.mullionObjectsH = overall.bOpeningObject.mullionsH.toArray();

        for (Object v : overall.bOpeningObject.mullionObjectsV) {

            Profiles coupler = (Profiles) v;

            if (coupler.thickness > 0) {

                g2.setColor(new Color(coupler.rgb_R, coupler.rgb_G, coupler.rgb_B, coupler.transp));
                g2.fill(coupler.gp);
                g2.setColor(Color.black);
                g2.draw(coupler.gp);

                if (coupler.profileSelected == 1) {
                    g2.setColor(new Color(255, 0, 0, 64));
                    g2.fill(coupler.poly);
                    g2.setColor(Color.black);
                    g2.draw(coupler.poly);
                    g2.setColor(Color.black);
                    g2.setStroke(new BasicStroke());
                }
            }
        }

        for (Object h : overall.bOpeningObject.mullionObjectsH) {

            Profiles coupler = (Profiles) h;

            if (coupler.thickness > 0) {
                g2.setColor(new Color(coupler.rgb_R, coupler.rgb_G, coupler.rgb_B, coupler.transp));
                g2.fill(coupler.gp);
                g2.setColor(Color.black);
                g2.draw(coupler.gp);

                if (coupler.profileSelected == 1) {
                    g2.setColor(new Color(255, 0, 0, 64));
                    g2.fill(coupler.poly);
                    g2.setColor(Color.black);
                    g2.draw(coupler.poly);
                    g2.setColor(Color.black);
                    g2.setStroke(new BasicStroke());
                }
            }
        }
    }

    /**
     * Drawing profiles
     *
     * @param isForShape, Is For Shape Object
     * @param parts , Object[]
     */
    public void drawProfiles(boolean isForShape, Object[] parts) {

        for (final Object P : parts) {

            if (!((Profiles) P).remove && (((Profiles) P).partDimB > 0 || ((Profiles) P).partDimA > 0 ||
                    ((Profiles) P).partDimC > 0)) {

                if (((Profiles) P).partForm == 1) {

                    if (isForShape) {
                        g2.setColor(Color.GREEN);
                    } else {
                        g2.setColor(new Color(((Profiles) P).rgb_R, ((Profiles) P).rgb_G, ((Profiles) P).rgb_B, ((Profiles) P).transp));
                    }

                    g2.fill(((Profiles) P).gp);
                    g2.setColor(Color.black);
                    g2.draw(((Profiles) P).gp);

                }

                if (((Profiles) P).profileSelected == 1 && ((Profiles) P).partForm == 1) {
                    if (isForShape) {
                        g2.setColor(Color.GREEN);
                    } else {
                        g2.setColor(new Color(255, 0, 0, 64));
                    }

                    g2.fill(((Profiles) P).polygon);
                } else if (((Profiles) P).profileSelected == 1 && ((Profiles) P).partForm == 1) {

                    if (isForShape) {
                        g2.setColor(Color.GREEN);
                    } else {
                        g2.setColor(new Color(255, 0, 0, 64));
                    }

                    g2.fill(((Profiles) P).polygon);
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
    public void drawGrids(Object[] parts) {

        for (Object p : parts) {

            Profiles profile = (Profiles)p;

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
     * Drawing spokes
     *
     * @param parts , Object[]
     */
    public void drawSpokes(Object[] parts) {

        for (Object p : parts) {

            Profiles profile = (Profiles)p;

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
     * Drawing profiles curves
     *
     * @param isForShape, Draw Profiles with different color
     * @param parts , Object[]
     */
    public void drawProfilesCurves(boolean isForShape, Object[] parts) {

        for (Object p : parts) {

            Profiles profile = (Profiles) p;

            if (!profile.remove && (profile.partDimB > 0 || profile.partDimA > 0 || profile.partDimC > 0)) {

                if (profile.partForm != 1) {

                    if (isForShape) {
                        g2.setColor(Color.GREEN);
                    } else {
                        g2.setColor(new Color(profile.rgb_R, profile.rgb_G, profile.rgb_B, profile.transp));
                    }

                    g2.draw(profile.gp);

                    g2.setColor(Color.black);
                    g2.draw(profile.curveB);
                    g2.draw(profile.curveA);

                    if (profile.partDimA > 0) {
                        g2.draw(profile.curveBA);
                    }
                }

                g2.setColor(Color.black);
                g2.setStroke(new BasicStroke());
            }
        }
    }

    /**
     * Drawin mullions components from BkgrdOpening
     *
     * @param shapeObject , ShapeObject
     */
    public void drawMullions(ShapeObject shapeObject) {

        //********************************************************************************************
        // Draw Mullion Objects Verticals
        //********************************************************************************************
        shapeObject.bOpeningObject.mullionObjectsV = shapeObject.bOpeningObject.mullions.toArray();

        for (Object v : shapeObject.bOpeningObject.mullionObjectsV) {

            Profiles profile = (Profiles) v;

            //Set Default Profile Selected = 0
            g2.setColor(new Color(profile.rgb_R, profile.rgb_G, profile.rgb_B, profile.transp));
            g2.fill(profile.gp);
            g2.setColor(Color.black);
            g2.draw(profile.gp);

            if (profile.profileSelected == 1) {

                Polygon m = profile.poly;
                g2.setColor(new Color(255, 0, 0, 64));
                g2.fill(m);

            } else if (profile.profileSelected == 2) {

                Polygon m = profile.poly;
                g2.setColor(new Color(0, 0, 255, 64));
                g2.fill(m);

            } else if (profile.potentialS) {

                Polygon m = profile.poly;
                g2.setColor(new Color(0, 255, 0, 64));
                g2.fill(m);
            }
        }

        //Set Default Color & Basic Stroke
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke());

        //********************************************************************************************
        // Draw Mullion Objects Horizontal
        //********************************************************************************************
        shapeObject.bOpeningObject.mullionObjectsH = shapeObject.bOpeningObject.mullionsH.toArray();

        for (Object h : shapeObject.bOpeningObject.mullionObjectsH) {

            Profiles profile = (Profiles) h;

            //Set Default Profile Selected = 0
            g2.setColor(new Color(profile.rgb_R, profile.rgb_G, profile.rgb_B, profile.transp));
            g2.fill(profile.gp);
            g2.setColor(Color.black);
            g2.draw(profile.gp);

            if (profile.profileSelected == 1) {

                Polygon m = profile.poly;
                g2.setColor(new Color(255, 0, 0, 64));
                g2.fill(m);

            } else if (profile.profileSelected == 2) {

                Polygon m = profile.poly;
                g2.setColor(new Color(0, 0, 255, 64));
                g2.fill(m);

            } else if (profile.potentialS) {

                Polygon m = profile.poly;
                g2.setColor(new Color(0, 255, 0, 64));
                g2.fill(m);
            }
        }

        //Set Default Color & Basic Stroke
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke());
    }

    /**
     * Draw mullions selected
     *
     * @param shapeObject , ShapeObject
     * @param isGrid      , is a Grid
     */
    public void drawMullionsSelected(ShapeObject shapeObject, boolean isGrid) {

        shapeObject.bOpeningObject.mullionObjectsV = shapeObject.bOpeningObject.mullions.toArray();

        for (Object v : shapeObject.bOpeningObject.mullionObjectsV) {
            this.drawSelectedMullions(v, false);
        }

        shapeObject.bOpeningObject.mullionObjectsH = shapeObject.bOpeningObject.mullionsH.toArray();

        for (Object h : shapeObject.bOpeningObject.mullionObjectsH) {
            this.drawSelectedMullions(h, isGrid);
        }
    }

    /**
     * Draw Selected Mullions
     *
     * @param M      , Object
     * @param isGrid , is a Grid
     */
    public void drawSelectedMullions(Object M, final boolean isGrid) {

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

    /**
     * Draw Interlocks
     *
     * @param F , BkgrdOpening Object
     */
    public void drawInterLocks(BkgrdOpeningObject F) {

        Object[] vm = F.mullions.toArray();

        for (Object M : vm) {
            if (((Profiles) M).profileSelected == 0) {
                g2.setColor(new Color(((Profiles) M).rgb_R, ((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
                        ((Profiles) M).transp));

                g2.fill(((Profiles) M).gp);
                g2.setColor(Color.black);
                g2.draw(((Profiles) M).gp);
            } else if (((Profiles) M).profileSelected == 1) {
                g2.setColor(new Color(((Profiles) M).rgb_R, ((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
                        ((Profiles) M).transp));

                g2.fill(((Profiles) M).gp);

                g2.setColor(Color.black);
                g2.draw(((Profiles) M).gp);

                Polygon m = ((Profiles) M).poly;
                g2.setColor(new Color(255, 0, 0, 64));
                g2.fill(m);

                g2.setColor(Color.black);
                g2.setStroke(new BasicStroke());
            } else if (((Profiles) M).profileSelected == 2) {
                g2.setColor(new Color(((Profiles) M).rgb_R, ((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
                        ((Profiles) M).transp));

                g2.fill(((Profiles) M).gp);

                g2.setColor(Color.black);
                g2.draw(((Profiles) M).gp);

                Polygon m = ((Profiles) M).poly;
                g2.setColor(new Color(0, 0, 255, 64));
                g2.fill(m);
                g2.setColor(Color.black);
                g2.setStroke(new BasicStroke());
            } else if (((Profiles) M).potentialS) {
                g2.setColor(new Color(((Profiles) M).rgb_R, ((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
                        ((Profiles) M).transp));

                g2.fill(((Profiles) M).gp);

                g2.setColor(Color.black);
                g2.draw(((Profiles) M).gp);

                Polygon m = ((Profiles) M).poly;
                g2.setColor(new Color(0, 255, 0, 64));
                g2.fill(m);
                g2.setColor(Color.black);
                g2.setStroke(new BasicStroke());
            }

        }

        Object[] hm = F.mullionsH.toArray();

        for (Object M : hm) {

            if (((Profiles) M).profileSelected == 0) {
                g2.setColor(new Color(((Profiles) M).rgb_R, ((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
                        ((Profiles) M).transp));

                g2.fill(((Profiles) M).gp);

                g2.setColor(Color.black);
                g2.draw(((Profiles) M).gp);
            } else if (((Profiles) M).profileSelected == 1) {
                g2.setColor(new Color(((Profiles) M).rgb_R, ((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
                        ((Profiles) M).transp));

                g2.fill(((Profiles) M).gp);

                g2.setColor(Color.black);
                g2.draw(((Profiles) M).gp);

                Polygon m = ((Profiles) M).poly;
                g2.setColor(new Color(255, 0, 0, 64));
                g2.fill(m);

                g2.setColor(Color.black);
                g2.setStroke(new BasicStroke());
            } else if (((Profiles) M).profileSelected == 2) {
                g2.setColor(new Color(((Profiles) M).rgb_R, ((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
                        ((Profiles) M).transp));

                g2.fill(((Profiles) M).gp);

                g2.setColor(Color.black);
                g2.draw(((Profiles) M).gp);

                Polygon m = ((Profiles) M).poly;
                g2.setColor(new Color(0, 0, 255, 64));
                g2.fill(m);
                g2.setColor(Color.black);
                g2.setStroke(new BasicStroke());
            } else if (((Profiles) M).potentialS) {
                g2.setColor(new Color(((Profiles) M).rgb_R, ((Profiles) M).rgb_G, ((Profiles) M).rgb_B,
                        ((Profiles) M).transp));

                g2.fill(((Profiles) M).gp);
                g2.setColor(Color.black);
                g2.draw(((Profiles) M).gp);

                Polygon m = ((Profiles) M).poly;
                g2.setColor(new Color(0, 255, 0, 64));
                g2.fill(m);
                g2.setColor(Color.black);
                g2.setStroke(new BasicStroke());
            }
        }
    }

    /**
     * Drawing sashes
     *
     * @param sash     , Object[]
     * @param selected , boolean
     */
    public void drawSashes(Object[] sash, boolean selected) {

        Collection sashesOrderedOnTrack = new ArrayList();

        int track = 1;

        for (Object B : sash) {
            for (Object B2 : sash) {
                if (((SashLeaf) B2).trackNo == track) {
                    sashesOrderedOnTrack.add(B2);
                }
            }

            track++;
        }

        Object[] orderedSashes = sashesOrderedOnTrack.toArray();

        for (Object b : orderedSashes) {

            SashLeaf sashLeaf = (SashLeaf)b;

            //Is For Shape Object
            boolean isForShape = sashLeaf.isForShape(this.constructionMap);

            if (!selected) {
                Object[] openingObjects = sashLeaf.openings.toArray();
                Object[] parts = sashLeaf.partObjects.toArray();

                if (!sashLeaf.glazedOut) {

                    this.drawSashOpenings(sashLeaf);

                    this.drawProfilesCurves(isForShape, parts);
                    this.drawProfiles(isForShape, parts);

                    this.drawMullions(sashLeaf);
                    this.drawMullionsSelected(sashLeaf, false);

                    for (Object opening : openingObjects) {
                        this.drawGlazingBeads(opening);
                    }

                    drawSashMullions(selected, sashesOrderedOnTrack);

                } else {

                    this.drawProfilesCurves(isForShape, parts);
                    this.drawProfiles(isForShape, parts);

                    this.drawMullions(sashLeaf);
                    this.drawMullionsSelected(sashLeaf, false);

                    this.drawSashMullions(selected, sashesOrderedOnTrack);

                    this.drawSashOpenings(sashLeaf);

                    for (Object opening : openingObjects) {
                        this.drawGlazingBeads(opening);
                    }
                }
            } else {
                this.drawMullionsSelected(sashLeaf, false);
            }

            Object[] symbols = sashLeaf.symbol.toArray();

            for (Object L : symbols) {

                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                if (sashLeaf.paneType != 50 && sashLeaf.paneType != 51) {
                    g2.setColor(new Color(255, 0, 0, 128));
                    g2.draw((Shape) L);
                } else {
                    Stroke drawingStroke = new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1,
                            new float[]{10}, 0);

                    g2.setStroke(drawingStroke);
                    g2.setColor(new Color(255, 0, 0, 128));

                    g2.draw((Shape) L);
                    g2.setColor(Color.black);
                    g2.setStroke(new BasicStroke());
                }

                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            }
        }
    }

    /**
     * Draw Sash Mullions
     *
     * @param selected             , If Object is selected
     * @param sashesOrderedOnTrack , sashes Ordered On Track
     */
    public void drawSashMullions(boolean selected, Collection sashesOrderedOnTrack) {

        Object[] orderedSashes = sashesOrderedOnTrack.toArray();

        for (Object b : orderedSashes) {

            SashLeaf sashLeaf = (SashLeaf)b;

            if (!selected) {
                this.drawMullions(sashLeaf);
                this.drawMullionsSelected(sashLeaf, false);

            } else {
                this.drawMullionsSelected(sashLeaf, false);
            }
        }
    }

    /**
     * Draw Sash Openings
     *
     * @param B , Object
     */
    public void drawSashOpenings(Object B) {

        Object[] openingObjects = ((SashLeaf) B).openings.toArray();

        for (Object O2 : openingObjects) {
            this.drawGlass(O2);
        }
    }

    /**
     * Do draw glass for opening object
     *
     * @param O2 , Object
     */
    public void doGrids(Object O2) {

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
     * Draw Glazing beads
     *
     * @param O , Object
     */
    public void drawGlazingBeads(Object O) {

        //Evaluate if is for Shape Object
        boolean isForShape = ((OpeningObject) O).isForShape(this.constructionMap);

        if (((OpeningObject) O).myParent.glazedOut && this.myFrame.jobItem.viewOut) {
            if (((OpeningObject) O).contentIn == 1 && ((OpeningObject) O).myGlassIn != null) {
                Object[] bead = ((OpeningObject) O).glazingBeadsIn.toArray();
                this.drawProfilesCurves(isForShape, bead);
                this.drawProfiles(isForShape, bead);
            }

            if (((OpeningObject) O).contentMid == 1) {
                Object[] sos = ((OpeningObject) O).openings.toArray();

                for (Object oo : sos) {
                    Object[] bead = ((OpeningObject) oo).glazingBeadsMid.toArray();

                    this.drawProfilesCurves(isForShape, bead);
                    this.drawProfiles(isForShape, bead);
                }

                Object[] bead = ((OpeningObject) O).glazingBeadsMid.toArray();

                this.drawProfilesCurves(isForShape, bead);
                this.drawProfiles(isForShape, bead);

            }

            if (((OpeningObject) O).contentOut == 1 && ((OpeningObject) O).myGlassOut != null) {
                Object[] bead = ((OpeningObject) O).glazingBeadsOut.toArray();
                this.drawProfilesCurves(isForShape, bead);
                this.drawProfiles(isForShape, bead);

            }
        }

    }

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
}
