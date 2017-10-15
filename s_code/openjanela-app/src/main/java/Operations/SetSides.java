/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Operations;


public class SetSides {

    public int noSides = 0;

    public int noSidesTop = 1;

    public int noSidesBot = 1;

    public int noSidesLeft = 1;

    public int noSidesRight = 1;

    public int shapeID;

    public SetSides(final int shape) {

        shapeID = shape;
        this.analyseShape();

    }

    public void analyseShape() {

        int myShape = 0;
        if (shapeID == 333) {
            shapeID = 301;
        } else if (shapeID == 3333) {
            shapeID = 302;
        }
        if (shapeID == 1 || shapeID <= 9) {
            myShape = 1;
        } else if (shapeID >= 100 && shapeID <= 149) {
            myShape = 1;
        } else if (shapeID == 451) {
            myShape = 401;
        } else if (shapeID == 452) {
            myShape = 402;
        } else {
            myShape = shapeID;
        }

        switch (myShape) {
            case 1: // rectangle// 4 sided
                noSides = 4;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;
            case 10: // rectangle// 4 sided
                noSides = 0;
                noSidesTop = 0;
                noSidesBot = 0;
                noSidesLeft = 0;
                noSidesRight = 0;

                break;
            case 90: // Pentagon
                noSides = 5;
                noSidesTop = 2;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;
            case 91: // rectangle// 4 sided
                noSides = 6;

                noSidesTop = 3;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;
            case 92: // rectangle// 4 sided
                noSides = 6;

                noSidesTop = 3;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;
            case 93: // rectangle// 4 sided
                noSides = 8;

                noSidesTop = 3;
                noSidesBot = 3;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;
            case 150: // rectangle// 4 sided
                noSides = 5;

                noSidesTop = 2;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;
            case 154: // rectangle// 4 sided
                noSides = 5;

                noSidesTop = 2;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;
            case 155: // rectangle// 4 sided
                noSides = 5;

                noSidesTop = 2;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;
            case 160: // rectangle// 4 sided
                noSides = 6;

                noSidesTop = 3;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;
            case 165: // rectangle// 4 sided
                noSides = 6;

                noSidesTop = 3;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;
                break;
            case 200: // extended HR
                noSides = 4;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;
            case 201: // extended HR
                noSides = 4;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;
            case 202: // extended HR
                noSides = 4;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;
            case 203: // HR
                noSides = 2;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 0;
                noSidesRight = 0;

                break;
            case 204: // qRl
                noSides = 3;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 0;
                noSidesRight = 1;

                break;
            case 205: // qRr
                noSides = 3;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 0;

                break;
            case 300: // extended Arc
                noSides = 4;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;
            case 301: // extended Arc End 90
                noSides = 4;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;
            case 302: // extended Arc start 90
                noSides = 4;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;

            case 303: // HR/Arc
                noSides = 2;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 0;
                noSidesRight = 0;

                break;
            case 304: // qRl
                noSides = 2;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 0;
                noSidesRight = 1;

                break;
            case 305: // qRr
                noSides = 3;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 0;

                break;
            case 400: // Extended Ellipse
                noSides = 4;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;
            case 401: // Extended Ellipse
                noSides = 4;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;
            case 402: // Extended Ellipse
                noSides = 4;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;
            case 403: // Extended Ellipse
                noSides = 4;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 1;

                break;

            case 450: // extended Lancet/Gothic
                this.extendedGothic();
                break;
            case 451: // extended Lancet/Gothic
                this.extendedGothic();
                break;
            case 452: // extended Lancet/Gothic
                this.extendedGothic();
                break;
            case 453: // extended Lancet/Gothic
                this.gothic();
                break;
            case 454: // extended Lancet/Gothic
                this.extendedGothic();
                break;
            case 455: // extended Lancet/Gothic
                this.gothic();
                break;
            case 456: // extended Lancet/Gothic
                this.extendedGothic();
                break;
            case 457: // extended Lancet/Gothic
                this.gothic();
                break;
            case 458: // extended Lancet/Gothic
                this.extendedGothic();
                break;
            case 459: // extended Lancet/Gothic
                this.gothic();
                break;
            case 460: // extended Lancet/Gothic
                this.extendedGothic();
                break;
            case 461: // extended Lancet/Gothic
                this.gothic();
                break;

            case 700: // right Triangle - Right
                noSides = 3;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 0;
                noSidesRight = 1;

                break;
            case 701: // right Triangle - left
                noSides = 3;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 1;

                break;
            case 702: // triangle iso R
                noSides = 3;

                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 0;
                noSidesRight = 1;

                break;
            case 703: // triangle left
                noSides = 3;

                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 0;

                break;
            case 704: // triangle iso top
                noSides = 3;

                noSidesTop = 2;
                noSidesBot = 1;
                noSidesLeft = 0;
                noSidesRight = 0;

                break;
            case 705: // Right Triangle LeanTop
// (L)
                noSides = 3;

                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 0;
                noSidesRight = 1;

                break;
            case 706: // Right triangle Lean Top
// R
                noSides = 3;

                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 1;
                noSidesRight = 0;

                break;
            case 800: // HR
                noSides = 2;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 0;
                noSidesRight = 0;

                break;
            case 801: // Ellipse
                noSides = 2;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 0;
                noSidesRight = 0;
                break;
            case 802: // Ellipse V
                noSides = 2;
                noSidesTop = 1;
                noSidesBot = 1;
                noSidesLeft = 0;
                noSidesRight = 0;

                break;

        }// Switch
    }// analyseShapes

    private void extendedGothic() {

        noSides = 5;
        noSidesTop = 2;
        noSidesBot = 1;
        noSidesLeft = 1;
        noSidesRight = 1;

    }

    private void gothic() {

        noSides = 3;
        noSidesTop = 2;
        noSidesBot = 1;
        noSidesLeft = 0;
        noSidesRight = 0;

    }

}
