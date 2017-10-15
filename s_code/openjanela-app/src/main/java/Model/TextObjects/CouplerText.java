/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Model.TextObjects;


public class CouplerText {

    public double angle = 0;

    public boolean isFixed = true;

    public double centerX = 0;

    public double endY = 0;

    public CouplerText(
            final double a,
            final boolean f,
            final double cX,
            final double eY) {

        angle = a;
        isFixed = f;
        centerX = cX;
        endY = eY;
    }

}
