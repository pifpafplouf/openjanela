/**
 * Copyright (c) 2009, OpenJanela. All rights reserved.
 * Contributors:
 * Sherif El Dibani
 **/
package Operations;


import java.util.ArrayList;
import java.util.Collection;

import Model.ShapeObject;
import Model.Frame;

/**
 * This class is an implementation for finding selected frame from model
 */
public class GetSelectedFrame {

    //******************************************
    //Axis x and y position selected
    //******************************************
    private int x = 0;
    private int y = 0;

    Object[] frameObjects = null;

    /**
     * Constructor for GetSelectedFrame object
     * @param xxx, Axis x position
     * @param yyy, Axis y position
     * @param frames, Frames Collection
     */
    public GetSelectedFrame(int xxx, int yyy, Collection frames) {
        this.x = xxx;
        this.y = yyy;
        this.frameObjects = frames.toArray();
    }

    /**
     * Get selected frame from Axis position x and y
     * @return Frame
     */
    public Frame getSelectedFrame() {

        //Frame selected
        Frame myFrame = null;

        //Iterate frames to find frame selected
        for (Object frame : this.frameObjects) {

            if (this.x >= Math.min(((Frame) frame).startingX, ((Frame) frame).bX4) && this.x
                    <= Math.max(((Frame) frame).bX2, ((Frame) frame).bX3) && this.y >= ((Frame) frame).highestY
                    && this.y <= ((Frame) frame).lowestY) {

                myFrame = (Frame) frame;
            }
        }

        return myFrame;
    }

    /**
     * Get selected opening
     * @return ShapeObject
     */
    public ShapeObject getSelectedOpening() {

        ShapeObject myFrame = null;

        for (Object frame : this.frameObjects) {

            if (this.x >= ((ShapeObject) frame).startingX && this.x <= ((ShapeObject) frame).bX2
                    && this.x <= ((ShapeObject) frame).bX3 && this.x >= ((ShapeObject) frame).bX4
                    && this.y >= ((ShapeObject) frame).highestY && this.y <= ((ShapeObject) frame).bY3
                    && this.y <= ((ShapeObject) frame).bY4) {

                myFrame = (ShapeObject) frame;
            }
        }

        return myFrame;
    }

    /**
     * Setting selected frame
     * @param myFrame, ShapeObject model
     * @param frames, Collection of frames
     * @param scale, Scale
     * @param noVCouplers, Vertical couplers
     * @param newPart, New part
     * @param newShape, New shape
     * @return Collection
     */
    public Collection setSelectedFrame(ShapeObject myFrame, Collection frames, double scale, boolean noVCouplers,
            boolean newPart, boolean newShape) {

        //Initialize new frames collection
        Collection newframes = new ArrayList();

        //Get array of frames
        Object[] myFrames = frames.toArray();
        //Clear frames collection param
        frames.clear();

        for (Object frame : myFrames) {

            if (this.x >= ((Frame) frame).startingX && this.x <= ((Frame) frame).bX2 && this.x <= ((Frame) frame).bX3
                    && this.x >= ((Frame) frame).bX4 && this.y >= ((Frame) frame).startingY && this.y >= ((Frame) frame).bY2
                    && this.y <= ((Frame) frame).bY3 && this.y <= ((Frame) frame).bY4) {

                if (!noVCouplers) {
                    myFrame.shapeChanged = true;
                } else {
                    myFrame.shapeChanged = false;

                }

                //Setting myframe new part
                myFrame.newPart = true;

                if (myFrame.shapeID >= 90 && myFrame.shapeID < 100) {
                    myFrame.bY3 = ((Frame) frame).startingY + myFrame.heightPix / scale;
                    myFrame.bY4 = ((Frame) frame).startingY + myFrame.heightPix / scale;
                }

                //Adding frame to collection
                newframes.add(myFrame);

            } else {
                myFrame.newPart = true;
                newframes.add(frame);
            }
        }

        return newframes;
    }

}
