/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Model.TextObjects;


import Model.ShapeObject;


public class TextFieldLeft {

    public double getSize() {

        return size;
    }

    public void setSize(final double size) {

        this.size = size;
    }

    public double getSizeC() {

        return sizeC;
    }

    public void setSizeC(final double sizeC) {

        this.sizeC = sizeC;
    }

    public double getPos() {

        return pos;
    }

    public void setPos(final double pos) {

        this.pos = pos;
    }

    public double getPose() {

        return pose;
    }

    public void setPose(final double pose) {

        this.pose = pose;
    }

    public double getPosc() {

        return posc;
    }

    public void setPosc(final double posc) {

        this.posc = posc;
    }

    public double getPosec() {

        return posec;
    }

    public void setPosec(final double posec) {

        this.posec = posec;
    }

    public int getStartRC() {

        return startRowCol;
    }

    public void setStartRC(final int startRC) {

        startRowCol = startRC;
    }

    public int getEndRC() {

        return endRowCol;
    }

    public void setEndRC(final int endRC) {

        endRowCol = endRC;
    }

    public int getmod() {

        return mod;
    }

    public void setmod(final int mod) {

        this.mod = mod;
    }

    public double getDeltaL() {

        return deltaLT;
    }

    public void setDeltaL(final double deltaL) {

        this.deltaLT = deltaL;
    }

    public double getdeltaR() {

        return deltaRB;
    }

    public void setDeltaR(final double deltaR) {

        this.deltaRB = deltaR;
    }

    public int mod = 0;

    public double size = 0;

    public double sizeC = 0;

    public double newSize = 0;

    public double newSizeC = 0;

    public double pos = 0;

    public double pose = 0;

    public double posc = 0;

    public double posec = 0;

    public double newPos = 0;

    public double newPose = 0;

    public double newPosc = 0;

    public double newPosec = 0;

    public int startRowCol = 0;

    public int endRowCol = 0;

    public double deltaLT = 0;

    public double deltaRB = 0;

    public String myTextO = "";

    public String myTextOc = "";

    public boolean active = false;

    public double roundedDelta = 0;

    public int rowNo = 0;

    public int seqID = 0;

    public ShapeObject parent;

    public boolean isSash = false;

    public boolean visible = true;

}
