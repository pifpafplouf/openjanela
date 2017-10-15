/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Model.ProfileParts;


import Model.ShapeObject;
import org.apache.log4j.Logger;


public class LeftObject extends ProfileParts implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(LeftObject.class);

    /**
     * Create LeftObject
     */
    public LeftObject() {
        position = 8; // 1
    }

    /**
     * Create LeftObject
     *
     * @param levelShape, ShapeObject
     * @param newPart,    boolean
     */
    public LeftObject(ShapeObject levelShape, boolean newPart) {

        //Call former constructor
        this();

        this.myFrame = levelShape;
        this.startingX = this.myFrame.startingX;
        this.startingY = this.myFrame.startingY;
        this.bkgrdStartX = this.myFrame.startingX;
        this.bkgrdStartY = this.myFrame.startingY;
        if (newPart) {
            this.setLeftObjectInitData();
        } else {
            this.partID = this.myFrame.left.partID;
            this.partDimB = this.myFrame.left.partDimB;
            this.partDimA = this.myFrame.left.partDimA;
            this.partDimC = this.myFrame.left.partDimC;
            this.partDimM = this.myFrame.left.partDimM;
            this.endTypeLT = this.myFrame.left.endTypeLT;
            this.endTypeRB = this.myFrame.left.endTypeRB;

        }
        this.setLeanTo();
        this.myTopWidth = this.myFrame.widthPix;

        if (this.myFrame.shapeID == 1
                || this.myFrame.shapeID <= 115
                || this.myFrame.shapeID >= 200 && this.myFrame.shapeID <= 699) {
            this.myTopWidth = this.myFrame.widthPix;
        } else if (this.myFrame.shapeID == 150) {
            this.myTopWidth =
                    this.myFrame.widthPix - this.myFrame.dimA2;
        } else if (this.myFrame.shapeID == 154) {
            this.myTopWidth =
                    this.myFrame.widthPix - this.myFrame.dimA2;
        } else if (this.myFrame.shapeID == 155) {

        } else if (this.myFrame.shapeID == 160
                || this.myFrame.shapeID == 165) {
            this.myTopWidth = this.myFrame.dimA1;
        }

    }

    public void setLeanTo() {

        this.myLean = this.myFrame.lean;
        this.myLean2 = this.myFrame.lean2;
        this.myLean3 = this.myFrame.lean3;
        this.myLean4 = this.myFrame.lean4;
        if (this.myFrame.shapeID == 150) {

            this.myLean2 = 0;

        } else if (this.myFrame.shapeID == 154) {

            this.myLean2 = 0;

        } else if (this.myFrame.shapeID == 155) {

            this.myLean2 = 0;

        } else if (this.myFrame.shapeID == 160
                || this.myFrame.shapeID == 165) {

            this.myLean2 = 0;

        }
    }

    public void setLeftObjectInitData() {// Inititalize from

        // Rules Execute
        // Rules
        // should pass the entire part object to
        // this Side
        // object

        this.partShape = 0; // L, T, Z, I, H,
        this.ABClines = 0; // if reflects lines for
        // ABC dims of
        // parts, by T
        // partDimA = 0f / myFrame.myMainPanel.scale;
        // partDimB = 0 / myFrame.myMainPanel.scale;
        // partDimC = 0 / myFrame.myMainPanel.scale;
        // partDimM = 0f / myFrame.myMainPanel.scale;

        this.partID = 999;
        this.stockCode = "FramePart";

    }

    public void leftStraightLineB() {

        if (this.myFrame.shapeID == 400 && !this.myFrame.leftIn) {
            this.endTypeLT = 3;
        }
        if (this.myFrame.shapeID == 401 && !this.myFrame.leftIn) {
            this.endTypeLT = 3;
        } else if (this.myFrame.shapeID == 401 && this.myFrame.leftIn) {
            this.endTypeLT = 1;
        }

        if (this.myFrame.shapeID == 402) {
            this.endTypeLT = 1;
        }
        this.startX = this.myFrame.startingX;
        this.endX = this.myFrame.startingX;
        double startPointY = this.myFrame.startingY;

        if (this.myFrame.top1.partForm == 1) {
            startPointY = this.myFrame.startingY;
        }
        if (this.myFrame.top1.partForm == 2
                || this.myFrame.top1.partForm == 3 && this.myFrame.wire) {
            startPointY = this.myFrame.startingY + this.myFrame.dimD2;
        }
        if (this.myFrame.shapeID == 403) {
            startPointY = this.myFrame.startingY;
        }
        if (this.myFrame.shapeID == 401 && this.myFrame.leftIn) {
            startPointY = this.myFrame.startingY;
        }
        if (this.myFrame.shapeID == 200
                || this.myFrame.shapeID == 201) {
            this.endTypeLT = 3;
        }
        if (this.myLean3 == 3 && this.myLean4 == 1) {
            this.startX = this.myFrame.startingX + this.myFrame.dimC2;
        }

        if (this.myLean4 == 1) {// Lean Bot

            final double myTheta =
                    Math.atan(this.myTopWidth / this.myFrame.dimD2);

            if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
                this.endY = startPointY + this.myFrame.dimD2;
            } else if (this.endTypeLT == 2) {// Straight Cut
                this.endY = startPointY + this.myFrame.dimD2;
            } else if (this.endTypeLT == 3) {

                this.endY =
                        startPointY + this.myFrame.dimD2 + this.myFrame.top1.partDimB
                                / Math.sin(myTheta);
                if (this.myFrame.shapeID == 400
                        || this.myFrame.shapeID == 401
                        || this.myFrame.shapeID == 402
                        || this.myFrame.shapeID == 200
                        || this.myFrame.shapeID == 201) {
                    this.endY = startPointY;
                }
                // Must do this at the end
                // after Get
                // Left PartDims
            }

            if (this.myLean2 == 2 || this.myLean2 == 0) {
                if (this.endTypeRB == 1 || this.endTypeRB == 0) {
                    this.startY = this.myFrame.bY4;
                } else if (this.endTypeRB == 2) {
                    this.startY = this.myFrame.bY4;
                    ;
                } else if (this.endTypeRB == 3) {
                    this.startY =
                            this.myFrame.bY4
                                    - this.myFrame.bot1.partDimB;
                }
            } else {
                final double theta =
                        Math.atan(this.myFrame.widthPix
                                / this.myFrame.dimB2);
                if (this.endTypeRB == 1 || this.endTypeRB == 0) {
                    this.startY = this.myFrame.bY4;
                } else if (this.endTypeRB == 2) {
                    this.startY = this.myFrame.bY4;
                    ;
                } else if (this.endTypeRB == 3) {
                    this.startY =
                            this.myFrame.bY4 - this.myFrame.bot1.partDimB
                                    / Math.sin(theta);
                }
            }
            this.myFrame.dimD0 = 0;

        }

        if (this.myLean4 == 2) { // Lean Top

            if (this.myLean2 == 1 || this.myLean2 == 0) {
                if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
                    this.endY = startPointY;
                    ;
                } else if (this.endTypeLT == 2) {// Straight Cut
                    this.endY = startPointY;
                    ;
                } else if (this.endTypeLT == 3) {

                    this.endY =
                            startPointY + this.myFrame.top1.partDimB;

                }
            }

            if (this.myLean2 == 2) {
                final double theta =
                        Math.atan(this.myTopWidth
                                / this.myFrame.dimB1);
                if (this.endTypeLT == 1 || this.endTypeLT == 0) {
                    this.endY = startPointY;
                } else if (this.endTypeLT == 2) {
                    this.endY = startPointY;
                } else if (this.endTypeLT == 3) {
                    this.endY =
                            startPointY
                                    + this.myFrame.top1.partDimB
                                    / Math.sin(theta);
                }
            }

            final double myTheta =
                    Math.atan(this.myFrame.widthPix
                            / this.myFrame.dimD1);
            if (this.endTypeRB == 1 || this.endTypeRB == 0) {
                this.startY = this.myFrame.bY4 - this.myFrame.dimD1;
            } else if (this.endTypeRB == 2) {
                this.startY = this.myFrame.bY4 - this.myFrame.dimD1;
            } else if (this.endTypeRB == 3) {

                this.startY =
                        this.myFrame.bY4
                                - this.myFrame.dimD1
                                - this.myFrame.bot1.partDimB
                                / Math.sin(myTheta);

            }
            this.myFrame.dimD0 = 0;

        }

        if (this.myLean4 == 3) { // Centered
            double myTheta =
                    Math.atan(this.myTopWidth / this.myFrame.dimD2);
            if (this.myFrame.bot3.posInUse) {
                myTheta =
                        Math.atan(this.myFrame.dimA1
                                / this.myFrame.dimD2);
            }

            if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
                this.endY = startPointY + this.myFrame.dimD2;
            } else if (this.endTypeLT == 2) {// Straight Cut
                this.endY = startPointY + this.myFrame.dimD2;
            } else if (this.endTypeLT == 3) {
                this.endY =
                        startPointY
                                + this.myFrame.dimD2
                                + this.myFrame.top1.partDimB
                                / Math.sin(myTheta);
            }

            if (this.endTypeRB == 1 || this.endTypeRB == 0) {

                this.startY = this.myFrame.bY4 - this.myFrame.dimD0;
            } else if (this.endTypeRB == 2) {
                this.startY = this.myFrame.bY4 - this.myFrame.dimD0;
            } else if (this.endTypeRB == 3) {

                this.startY =
                        this.myFrame.bY4
                                - this.myFrame.dimD0
                                - this.myFrame.bot1.partDimB
                                / Math.sin(myTheta);

            }

        }

        if (this.myLean4 == 0) { // Not Leaning

            if (this.myLean2 == 2 || this.myLean2 == 0) {
                if (this.endTypeRB == 1 || this.endTypeRB == 0) {
                    this.startY = this.myFrame.bY4;
                } else if (this.endTypeRB == 2) {
                    this.startY = this.myFrame.bY4;
                    ;
                } else if (this.endTypeRB == 3) {
                    this.startY =
                            this.myFrame.bY4
                                    - this.myFrame.bot1.partDimB;
                }
            }

            if (this.myLean2 == 1 || this.myLean2 == 3) {
                final double theta =
                        Math.atan(this.myFrame.widthPix
                                / this.myFrame.dimB2);
                if (this.endTypeRB == 1 || this.endTypeRB == 0) {
                    this.startY = this.myFrame.bY4;
                } else if (this.endTypeRB == 2) {
                    this.startY = this.myFrame.bY4;
                    ;
                } else if (this.endTypeRB == 3) {
                    this.startY =
                            this.myFrame.bY4
                                    - this.myFrame.bot1.partDimB
                                    / Math.sin(theta);
                }
            }

            if (this.myLean2 == 1 || this.myLean2 == 0) {
                if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
                    this.endY = startPointY;
                    ;
                } else if (this.endTypeLT == 2) {// Straight Cut
                    this.endY = startPointY;
                    ;
                } else if (this.endTypeLT == 3) {
                    this.endY =
                            startPointY + this.myFrame.top1.partDimB;

                }
            }

            if (this.myLean2 == 2 || this.myLean2 == 3) {
                double theta =
                        Math.atan(this.myTopWidth
                                / this.myFrame.dimB1);
                if (this.myLean2 == 3) {
                    theta =
                            Math.atan(this.myTopWidth
                                    / this.myFrame.dimB0);
                }
                if (this.endTypeLT == 1 || this.endTypeLT == 0) {
                    this.endY = startPointY;
                } else if (this.endTypeLT == 2) {
                    this.endY = startPointY;
                } else if (this.endTypeLT == 3) {
                    this.endY =
                            startPointY
                                    + this.myFrame.top1.partDimB
                                    / Math.sin(theta);
                }
            }

            this.startX = this.myFrame.bX4;
            if (this.endTypeRB == 1 || this.endTypeRB == 0) {
                if (this.myLean3 == 2 || this.myLean3 == 0) {

                    this.startX = this.myFrame.bX4;

                } else if (this.myLean3 == 1 || this.myLean3 == 3) {
                    this.startX =
                            this.myFrame.bX4 + this.myFrame.dimC2;
                }
            } else if (this.endTypeRB == 2) {
                if (this.myLean3 == 2 || this.myLean3 == 0) {
                    this.startX = this.myFrame.bX4;
                } else if (this.myLean3 == 1 || this.myLean3 == 3) {
                    this.startX =
                            this.myFrame.bX4 + this.myFrame.dimC2;
                }
            } else { // RB==3
                if (this.myLean3 == 2 || this.myLean3 == 0) {
                    if (this.myLean2 == 2 || this.myLean2 == 0) {
                        if (this.myLean == 1 || this.myLean == 0) {
                            this.startX = this.myFrame.bX4;
                        } else {
                            double theta =
                                    Math.atan(this.myFrame.heightPix
                                            / this.myFrame.dimA1);
                            if (this.myLean == 3) {
                                theta =
                                        Math
                                                .atan(this.myFrame.heightPix
                                                        / this.myFrame.dimA0);
                            }
                            this.startX =
                                    this.myFrame.bX4
                                            + this.myFrame.bot1.partDimB
                                            / Math.tan(theta);
                        }
                    } else if (this.myLean2 == 1
                            || this.myLean2 == 3) {
                        if (this.myLean == 1 || this.myLean == 0) {
                            this.startX = this.myFrame.bX4;// -this.myLevelShape.bot1.partDimB;
                        } else {
                            double theta =
                                    Math.atan(this.myFrame.heightPix
                                            / this.myFrame.dimA1);
                            if (this.myLean == 3) {
                                theta =
                                        Math
                                                .atan(this.myFrame.heightPix
                                                        / this.myFrame.dimA0);
                            }
                            this.startX =
                                    this.myFrame.bX4
                                            + this.myFrame.bot1.partDimB
                                            / Math.tan(theta);
                        }
                        // double
                        // theta = (double)
                        // Math.atan(this.myLevelShape.wB/this.myLevelShape.dimB2);
                        // this.startX
                        // =
                        // this.myLevelShape.bX4
                        // -
                        // (this.myLevelShape.bot1.partDimB/(double)
                        // Math.sin(theta));
                    }

                } else if (this.myLean3 == 1 || this.myLean3 == 3) {
                    final double theta =
                            Math.atan(this.myFrame.heightPix
                                    / this.myFrame.dimC2);
                    if (this.myLean2 == 2 || this.myLean2 == 0) {
                        this.startX =
                                this.myFrame.bX4
                                        + this.myFrame.dimC2
                                        - this.myFrame.bot1.partDimB
                                        / Math.tan(theta);
                    } else if (this.myLean2 == 1
                            || this.myLean2 == 3) {
                        this.startX =
                                this.myFrame.bX4
                                        + this.myFrame.dimC2
                                        - this.myFrame.bot1.partDimB
                                        / Math.tan(theta);
                    }

                }

            }

            this.endX = this.myFrame.startingX;
            if (this.endTypeLT == 1 || this.endTypeLT == 0) {
                if (this.myLean == 1 || this.myLean == 0) {
                    this.endX = this.myFrame.startingX;

                } else if (this.myLean == 2) {
                    this.endX =
                            this.myFrame.startingX
                                    + this.myFrame.dimA1;
                } else if (this.myLean == 3) {
                    this.endX =
                            this.myFrame.startingX
                                    + this.myFrame.dimA0;
                }
            } else if (this.endTypeLT == 2) {
                if (this.myLean == 1 || this.myLean == 0) {
                    this.endX = this.myFrame.startingX;
                } else if (this.myLean == 2) {
                    this.endX =
                            this.myFrame.startingX
                                    + this.myFrame.dimA1;
                } else if (this.myLean == 3) {
                    this.endX =
                            this.myFrame.startingX
                                    + this.myFrame.dimA0;
                }
            } else { // LT==3
                if (this.myLean == 1 || this.myLean == 0) {
                    if (this.myLean3 == 2 || this.myLean3 == 0) {
                        if (this.myLean2 == 1
                                || this.myLean2 == 0) {
                            this.endX = this.myFrame.startingX;
                        } else if (this.myLean2 == 2) {
                            this.endX = this.myFrame.startingX;
                        } else if (this.myLean2 == 3) {
                            this.endX = this.myFrame.startingX;
                        }
                    } else {
                        final double theta =
                                Math.atan(this.myFrame.heightPix
                                        / this.myFrame.dimC2);
                        this.endX =
                                this.myFrame.startingX
                                        + this.myFrame.top1.partDimB
                                        / Math.tan(theta);
                    }

                } else if (this.myLean == 2) {
                    final double theta =
                            Math.atan(this.myFrame.heightPix
                                    / this.myFrame.dimA1);
                    if (this.myLean2 == 0 || this.myLean2 == 1) {
                        this.endX =
                                this.myFrame.startingX
                                        + this.myFrame.dimA1
                                        - this.myFrame.top1.partDimB
                                        / Math.tan(theta);
                    } else if (this.myLean2 == 2
                            || this.myLean2 == 3) {
                        this.endX =
                                this.myFrame.startingX
                                        + this.myFrame.dimA1
                                        - -(this.myFrame.top1.partDimB / Math
                                        .tan(theta));
                    }

                } else if (this.myLean == 3) {
                    final double theta =
                            Math.atan(this.myFrame.heightPix
                                    / this.myFrame.dimA0);
                    if (this.myLean2 == 0 || this.myLean2 == 1) {
                        this.endX =
                                this.myFrame.startingX
                                        + this.myFrame.dimA0
                                        - this.myFrame.top1.partDimB
                                        / Math.tan(theta);
                    } else if (this.myLean2 == 2
                            || this.myLean2 == 3) {
                        this.endX =
                                this.myFrame.startingX
                                        + this.myFrame.dimA0
                                        - -(this.myFrame.top1.partDimB / Math
                                        .tan(theta));
                    }

                }

            }

        }
        if (this.myFrame.top1.partForm == 2
                || this.myFrame.top1.partForm == 3) {
            this.endY = this.myFrame.startingY;
            if (this.myFrame.shapeID != 305) {
                this.endY = this.myFrame.top1.startY;
            }
            if (this.myFrame.shapeID == 305) {
                this.endY = this.myFrame.startingY;
            }
            if (this.myFrame.shapeID == 305
                    && this.myFrame.endCol - this.myFrame.startCol > 0
                    && this.myFrame.bX2 == this.myFrame.parentCX2) {
                this.endY =
                        this.myFrame.startingY + this.myFrame.dimD2;
            }

        }

        this.slope =
                (this.startY - this.endY) / (this.startX - this.endX);
        this.length =
                Math
                        .sqrt(Math.pow((Math.max(
                                this.endX,
                                this.startX) - Math.min(
                                this.endX,
                                this.startX)), 2)
                                + Math.pow((Math.max(
                                this.endY,
                                this.startY) - Math.min(
                                this.endY,
                                this.startY)), 2));
        this.radius1 = 0;
        this.radius2 = 0;
        this.bkgrdWidth = this.myTopWidth;
        this.bkgrdHeight = this.myFrame.heightPix;

    }

    public void leftStraightLineBA() {

        double startPointY = this.myFrame.startingY;
        if (this.myFrame.top1.partForm == 1) {
            startPointY = this.myFrame.startingY;
        } else if (this.myFrame.top1.partForm == 2
                || this.myFrame.top1.partForm == 3) {
            startPointY = this.myFrame.startingY + this.myFrame.dimD2;
        }
        if (this.myFrame.shapeID == 403) {
            startPointY = this.myFrame.startingY;
        }
        if (this.myFrame.shapeID == 401 && this.myFrame.leftIn) {
            startPointY = this.myFrame.startingY;
        }

        if (this.myFrame.a_levelID == 3) {
            // System.out.print("hello");
        }
        if (this.myFrame.shapeID == 400) {
            this.endTypeLT = 3;
        }
        if (this.myFrame.shapeID == 401 && !this.myFrame.leftIn) {
            this.endTypeLT = 3;
        } else if (this.myFrame.shapeID == 401 && this.myFrame.leftIn) {
            this.endTypeLT = 1;
        }

        if (this.myFrame.shapeID == 402) {
            this.endTypeLT = 1;
        }
        if (this.myFrame.shapeID == 200
                || this.myFrame.shapeID == 201) {
            this.endTypeLT = 3;
        }

        if (this.myLean4 == 1) {// Lean Bot

            this.endXBA = this.endX + this.partDimB;
            this.startXBA = this.endXBA;

            double theta =
                    Math.atan(this.myTopWidth / this.myFrame.dimD2);

            if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered

                this.endYBA =
                        startPointY
                                + this.myFrame.dimD2
                                - this.partDimB
                                / Math.tan(theta)
                                + this.myFrame.top1.partDimB
                                / Math.sin(theta);
                if (this.myFrame.shapeID == 401
                        && this.myFrame.leftIn) {

                    // double thetae =
                    // (double)
                    // Math.acos(this.myLevelShape.top1.startXBA/(this.myLevelShape.parentW/2));
                    this.endYBA = this.myFrame.top1.startYBA;// (double)
                    // Math.abs((
                    // this.myLevelShape.parentRadius1/2)
                    // * (double)
                    // Math.sin(thetae));

                }

            } else if (this.endTypeLT == 2) {// Straight Cut
                this.endYBA =
                        startPointY
                                + this.myFrame.dimD2
                                - this.partDimB
                                / Math.tan(theta);
            } else if (this.endTypeLT == 3) {
                this.endYBA =
                        startPointY
                                + this.myFrame.dimD2
                                - this.partDimB
                                / Math.tan(theta)
                                + this.myFrame.top1.partDimB
                                / Math.sin(theta);
                if (this.myFrame.shapeID == 400
                        || this.myFrame.shapeID == 401
                        || this.myFrame.shapeID == 402
                        || this.myFrame.shapeID == 200
                        || this.myFrame.shapeID == 201) {
                    this.endYBA = startPointY;
                }
            }
            if (this.myLean2 == 2 || this.myLean2 == 0) {
                if (this.endTypeRB == 1 || this.endTypeRB == 0) {
                    this.startYBA =
                            this.myFrame.bY4
                                    - this.myFrame.bot1.partDimB;
                } else if (this.endTypeRB == 2) {
                    this.startYBA = this.myFrame.bY4;
                } else if (this.endTypeRB == 3) {

                    if (this.myFrame.bot1.partDimB != 0) {
                        this.startYBA =
                                this.myFrame.bY4
                                        - this.myFrame.bot1.partDimB;
                    }
                }
            } else {
                theta =
                        Math.atan(this.myFrame.widthPix
                                / this.myFrame.dimB2);
                if (this.endTypeRB == 1 || this.endTypeRB == 0) {
                    this.startYBA =
                            this.startY
                                    - this.partDimB
                                    / Math.tan(theta)
                                    - this.myFrame.bot1.partDimB
                                    / Math.sin(theta);
                } else if (this.endTypeRB == 2) {
                    this.startYBA =
                            this.startY
                                    - this.partDimB
                                    / Math.tan(theta);
                } else if (this.endTypeRB == 3) {

                    if (this.myFrame.bot1.partDimB != 0) {
                        this.startYBA =
                                this.startY
                                        - this.partDimB
                                        / Math.tan(theta);
                    }
                }
            }
            if (this.myLean3 == 3 || this.myLean3 == 2) {

                double theta1 =
                        Math.atan(this.myFrame.dimC2
                                / this.myFrame.dimD1);
                final double theta2 =
                        Math.atan(this.myFrame.dimA1
                                / this.myFrame.dimD2);
                final double myTheta =
                        Math.toRadians(180) - theta1 - theta2;
                final double hypotenus =
                        this.partDimB / Math.sin(myTheta / 2);
                final double baseY =
                        hypotenus * Math.cos(myTheta / 2 + theta1);
                final double baseX =
                        hypotenus * Math.sin(myTheta / 2 + theta1);
                this.endXBA = this.endX + baseX;// base;

                this.endYBA = this.endY + baseY;

                theta1 =
                        Math.atan(this.myFrame.dimD1
                                / this.myFrame.dimC2);

                if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
                    this.startXBA =
                            this.startX
                                    + this.partDimB
                                    / Math.sin(theta1)
                                    - this.partDimB
                                    / Math.tan(theta1);
                } else if (this.endTypeLT == 2) {// Straight Cut
                    this.startXBA =
                            this.startX
                                    + this.partDimB
                                    / Math.sin(theta1);
                } else if (this.endTypeLT == 3) {
                    this.startXBA =
                            this.startX
                                    + this.partDimB
                                    / Math.sin(theta1);
                }
                this.startYBA =
                        this.startY - this.myFrame.bot1.partDimB;
            }

            this.myFrame.dimB0 = 0;

        }

        if (this.myLean4 == 2) { // LeanTop
            this.endXBA = this.endX + this.partDimB;
            this.startXBA = this.endXBA;

            double theta =
                    Math.atan(this.myFrame.widthPix
                            / this.myFrame.dimD1);

            if (this.myLean2 == 0 || this.myLean2 == 1) {
                if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered

                    this.endYBA =
                            startPointY + this.myFrame.top1.partDimB;
                    // (this.partDimB*(double)
                    // Math.tan(theta));
                } else if (this.endTypeLT == 2) {// Straight Cut
                    this.endYBA = startPointY;
                } else if (this.endTypeLT == 3) {
                    this.endYBA =
                            startPointY + this.myFrame.top1.partDimB;
                }
            } else {
                final double xtheta =
                        Math.atan(this.myTopWidth
                                / this.myFrame.dimB1);
                if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
                    this.endYBA =
                            this.endY
                                    + this.myFrame.top1.partDimB
                                    / Math.sin(xtheta)
                                    + this.partDimB
                                    / Math.tan(xtheta);
                } else if (this.endTypeLT == 2) {// Straight Cut
                    this.endYBA =
                            this.endY
                                    + this.myFrame.top1.partDimB
                                    / Math.sin(xtheta)
                                    + this.partDimB
                                    / Math.tan(xtheta);
                } else if (this.endTypeLT == 3) {
                    this.endYBA =
                            this.endY
                                    + this.partDimB
                                    / Math.tan(xtheta);
                    ;
                }

            }

            if (this.myLean2 == 2 || this.myLean2 == 0) {
                if (this.endTypeRB == 1 || this.endTypeRB == 0) {
                    this.startYBA =
                            this.myFrame.bY4
                                    - this.myFrame.dimD1
                                    + this.partDimB
                                    / Math.tan(theta)
                                    - this.myFrame.bot1.partDimB
                                    / Math.sin(theta);
                } else if (this.endTypeRB == 2) {
                    this.startYBA =
                            this.myFrame.bY4
                                    - this.myFrame.dimD1
                                    + this.partDimB
                                    / Math.tan(theta);
                } else if (this.endTypeRB == 3) {
                    this.startYBA =
                            this.myFrame.bY4
                                    - this.myFrame.dimD1
                                    + this.partDimB
                                    / Math.tan(theta)
                                    - this.myFrame.bot1.partDimB
                                    / Math.sin(theta);

                }
            } else {
                theta =
                        Math.atan(this.myFrame.widthPix
                                / this.myFrame.dimB1);
                if (this.myLean2 == 3) {
                    theta =
                            Math.atan(this.myFrame.widthPix
                                    / this.myFrame.dimB0);
                }
                if (this.endTypeRB == 1 || this.endTypeRB == 0) {
                    this.startYBA =
                            this.startY
                                    + this.partDimB
                                    / Math.tan(theta);
                } else if (this.endTypeRB == 2) {
                    this.startYBA =
                            this.startY
                                    + this.partDimB
                                    / Math.tan(theta);

                } else if (this.endTypeRB == 3) {
                    this.startYBA =
                            this.startY
                                    + this.partDimB
                                    / Math.tan(theta);
                    ;

                }
            }
            this.myFrame.dimB0 = 0;

        }
        if (this.myLean4 == 3) { // Centered
            this.endXBA = this.endX + this.partDimB;
            this.startXBA = this.endXBA;
            double theta =
                    Math.atan(this.myTopWidth / this.myFrame.dimD2);
            if (this.myFrame.bot3.posInUse) {
                theta =
                        Math.atan(this.myFrame.dimA1
                                / this.myFrame.dimD2);
            }
            if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
                this.endYBA =
                        startPointY
                                + this.myFrame.dimD2
                                - this.partDimB
                                / Math.tan(theta)
                                + this.myFrame.top1.partDimB
                                / Math.sin(theta);

            } else if (this.endTypeLT == 2) {// Straight Cut
                this.endYBA =
                        startPointY
                                + this.myFrame.dimD2
                                - this.partDimB
                                / Math.tan(theta);
            } else if (this.endTypeLT == 3) {
                this.endYBA =
                        startPointY
                                + this.myFrame.dimD2
                                - this.partDimB
                                / Math.tan(theta)
                                + this.myFrame.top1.partDimB
                                / Math.sin(theta);
            }
            theta = Math.atan(this.myTopWidth / this.myFrame.dimD0);
            if (this.myFrame.bot3.posInUse) {
                theta =
                        Math.atan(this.myFrame.dimC2
                                / this.myFrame.dimD0);
            }
            if (this.endTypeRB == 1 || this.endTypeRB == 0) {
                this.startYBA =
                        this.myFrame.bY4
                                - this.myFrame.dimD0
                                + this.partDimB
                                / Math.tan(theta)
                                - this.myFrame.bot1.partDimB
                                / Math.sin(theta);
            } else if (this.endTypeRB == 2) {
                this.startYBA =
                        this.myFrame.bY4
                                - this.myFrame.dimD0
                                + this.partDimB
                                / Math.tan(theta);
            } else if (this.endTypeRB == 3) {
                this.startYBA =
                        this.myFrame.bY4
                                - this.myFrame.dimD0
                                + this.partDimB
                                / Math.tan(theta)
                                - this.myFrame.bot1.partDimB
                                / Math.sin(theta);

            }

        }

        if (this.myLean4 == 0) {

            this.startXBA = this.startX + this.partDimB;
            this.endXBA = this.endX + this.partDimB;

            if (this.myLean == 2 || this.myLean == 3) {
                double theta =
                        Math.atan(this.myFrame.heightPix
                                / this.myFrame.dimA1);
                if (this.myLean == 3) {
                    theta =
                            Math.atan(this.myFrame.heightPix
                                    / this.myFrame.dimA0);
                }
                if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
                    if (this.myLean == 2) {
                        this.endXBA =
                                this.endX
                                        + this.partDimB
                                        / Math.sin(theta)
                                        - this.myFrame.top1.partDimB
                                        / Math.tan(theta);
                    } else if (this.myLean == 3) {
                        this.endXBA =
                                this.endX
                                        + this.partDimB
                                        / Math.sin(theta)
                                        - this.myFrame.top1.partDimB
                                        / Math.tan(theta);
                    }
                } else if (this.endTypeLT == 2) {// Straight Cut
                    if (this.myLean == 2) {
                        this.endXBA =
                                this.endX
                                        + this.partDimB
                                        / Math.sin(theta);
                    } else if (this.myLean == 3) {
                        this.endXBA =
                                this.endX
                                        + this.partDimB
                                        / Math.sin(theta);
                    }
                } else if (this.endTypeLT == 3) {
                    if (this.myLean == 2) {
                        this.endXBA =
                                this.endX
                                        + this.partDimB
                                        / Math.sin(theta);
                    } else if (this.myLean == 3) {
                        this.endXBA =
                                this.endX
                                        + this.partDimB
                                        / Math.sin(theta);
                    }
                }

            }

            if (this.myLean3 == 1 || this.myLean3 == 3) {
                final double theta =
                        Math.atan(this.myFrame.heightPix
                                / this.myFrame.dimC2);

                if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
                    this.endXBA =
                            this.endX
                                    + this.myFrame.top1.partDimB
                                    / Math.tan(theta)
                                    + this.partDimB
                                    / Math.sin(theta);
                } else if (this.endTypeLT == 2) {// Straight Cut
                    this.endXBA =
                            this.endX
                                    + this.partDimB
                                    / Math.sin(theta);
                } else if (this.endTypeLT == 3) {
                    this.endXBA =
                            this.endX
                                    + this.partDimB
                                    / Math.sin(theta);
                }

            }

            if (this.myLean == 2 || this.myLean == 3) {
                double theta =
                        Math.atan(this.myFrame.heightPix
                                / this.myFrame.dimA1);
                if (this.myLean == 3) {
                    theta =
                            Math.atan(this.myFrame.heightPix
                                    / this.myFrame.dimA0);
                }
                if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
                    this.startXBA =
                            this.startX
                                    + this.partDimB
                                    / Math.sin(theta)
                                    + this.myFrame.bot1.partDimB
                                    / Math.tan(theta);
                } else if (this.endTypeRB == 2) {// Straight Cut
                    this.startXBA =
                            this.startX
                                    + this.partDimB
                                    / Math.sin(theta);
                } else if (this.endTypeRB == 3) {
                    this.startXBA =
                            this.startX
                                    + this.partDimB
                                    / Math.sin(theta);
                }

            }

            if (this.myLean3 == 1 || this.myLean3 == 3) {
                final double theta =
                        Math.atan(this.myFrame.heightPix
                                / this.myFrame.dimC2);

                if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
                    this.startXBA =
                            this.startX
                                    + this.partDimB
                                    / Math.sin(theta)
                                    - this.myFrame.bot1.partDimB
                                    / Math.tan(theta);
                } else if (this.endTypeRB == 2) {// Straight Cut
                    this.startXBA =
                            this.startX
                                    + this.partDimB
                                    / Math.sin(theta);
                } else if (this.endTypeRB == 3) {
                    this.startXBA =
                            this.startX
                                    + this.partDimB
                                    / Math.sin(theta);
                }

            }

            if (this.myLean2 == 0 || this.myLean2 == 2) {
                if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
                    this.startYBA =
                            this.myFrame.bY4
                                    - this.myFrame.bot1.partDimB;
                } else if (this.endTypeRB == 2) {// Straight Cut
                    this.startYBA = this.myFrame.bY4;
                } else if (this.endTypeRB == 3) {
                    this.startYBA =
                            this.myFrame.bY4
                                    - this.myFrame.bot1.partDimB;
                }
            } else {
                final double myTheta =
                        Math.atan(this.myFrame.widthPix
                                / this.myFrame.dimB2);
                if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
                    this.startYBA =
                            this.myFrame.bY4
                                    - this.partDimB
                                    / Math.tan(myTheta)
                                    - this.myFrame.bot1.partDimB
                                    / Math.sin(myTheta);
                } else if (this.endTypeRB == 2) {// Straight Cut
                    this.startYBA =
                            this.myFrame.bY4
                                    - this.partDimB
                                    / Math.tan(myTheta);
                } else if (this.endTypeRB == 3) {
                    this.startYBA =
                            this.myFrame.bY4
                                    - this.partDimB
                                    / Math.tan(myTheta)
                                    - this.myFrame.bot1.partDimB
                                    / Math.sin(myTheta);
                }
            }
            if (this.myLean2 == 0 || this.myLean2 == 1) {
                if (this.endTypeLT == 1 || this.endTypeLT == 0) {
                    this.endYBA =
                            startPointY + this.myFrame.top1.partDimB;
                } else if (this.endTypeLT == 2) {
                    this.endYBA = startPointY;
                } else {
                    this.endYBA =
                            startPointY + this.myFrame.top1.partDimB;
                }
            } else {
                double myTheta =
                        Math.atan(this.myTopWidth
                                / this.myFrame.dimB1);
                if (this.myLean2 == 3) {
                    myTheta =
                            Math.atan(this.myTopWidth
                                    / this.myFrame.dimB0);
                }
                if (this.endTypeLT == 1 || this.endTypeLT == 0) {
                    this.endYBA =
                            startPointY
                                    + this.partDimB
                                    / Math.tan(myTheta)
                                    + this.myFrame.top1.partDimB
                                    / Math.sin(myTheta);
                } else if (this.endTypeLT == 2) {
                    this.endYBA =
                            startPointY
                                    + this.partDimB
                                    / Math.tan(myTheta);
                } else {
                    this.endYBA =
                            startPointY
                                    + this.partDimB
                                    / Math.tan(myTheta)
                                    + this.myFrame.top1.partDimB
                                    / Math.sin(myTheta);
                }

            }
        }
        if (this.myFrame.top1.partForm == 2
                || this.myFrame.top1.partForm == 3) {

            this.endYBA = this.myFrame.top1.startYBA;

        }
        // if (this.myLevelShape.shapeID >= 90 &&
        // this.myLevelShape.shapeID <
        // 100) {
        // this.endYBA =
        // this.myLevelShape.top1.startYBA;
        // this.endXBA =
        // this.myLevelShape.top1.startXBA;
        // this.startYBA =
        // this.myLevelShape.bot1.endYBA;
        // this.startXBA =
        // this.myLevelShape.bot1.endXBA;
        // }

    }

    public void leftStraightLineA() {

        double startPointY = this.myFrame.startingY;
        if (this.myFrame.top1.partForm == 1) {
            startPointY = this.myFrame.startingY;
        } else if (this.myFrame.top1.partForm == 2
                || this.myFrame.top1.partForm == 3) {
            startPointY = this.myFrame.startingY + this.myFrame.dimD2;
        }
        if (this.myFrame.shapeID == 403) {
            startPointY = this.myFrame.startingY;
        }
        if (this.myFrame.shapeID == 401 && this.myFrame.leftIn) {
            startPointY = this.myFrame.startingY;
        }

        if (this.myFrame.a_levelID == 3) {
            // System.out.print("hello");
        }
        if (this.myFrame.shapeID == 400) {
            this.endTypeLT = 3;
        }
        if (this.myFrame.shapeID == 401 && !this.myFrame.leftIn) {
            this.endTypeLT = 3;
        } else if (this.myFrame.shapeID == 401 && this.myFrame.leftIn) {
            this.endTypeLT = 1;
        }
        if (this.myFrame.shapeID == 402) {
            this.endTypeLT = 1;
        }
        if (this.myFrame.shapeID == 200
                || this.myFrame.shapeID == 201) {
            this.endTypeLT = 3;
        }

        if (this.myLean4 == 1) {// Lean Bot

            this.endXA = this.endX + this.partDimB + this.partDimA;
            this.startXA = this.endXA;

            double theta =
                    Math.atan(this.myTopWidth / this.myFrame.dimD2);

            if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
                this.endYA =
                        startPointY
                                + this.myFrame.dimD2
                                - (this.partDimB + this.partDimA)
                                / Math.tan(theta)
                                + (this.myFrame.top1.partDimB + this.myFrame.top1.partDimA)
                                / Math.sin(theta);

                if (this.myFrame.shapeID == 401
                        && this.myFrame.leftIn) {
                    this.endYA = this.myFrame.top1.startYA;
                }

            } else if (this.endTypeLT == 2) {// Straight Cut
                this.endYA =
                        startPointY
                                + this.myFrame.dimD2
                                - (this.partDimB + this.partDimA)
                                / Math.tan(theta)
                                + (this.myFrame.top1.partDimB + this.myFrame.top1.partDimA)
                                / Math.sin(theta);
            } else if (this.endTypeLT == 3) {
                this.endYA =
                        this.endY
                                - (this.partDimB + this.partDimA)
                                / Math.tan(theta);// ((this.myLevelShape.top1.partDimB+this.myLevelShape.top1.partDimA)/(double)
                // Math.sin(theta));
                if (this.myFrame.shapeID == 400
                        || this.myFrame.shapeID == 401
                        || this.myFrame.shapeID == 402
                        || this.myFrame.shapeID == 200
                        || this.myFrame.shapeID == 201) {
                    this.endYA = startPointY;
                }
            }
            if (this.myLean2 == 2 || this.myLean2 == 0) {
                if (this.endTypeRB == 1 || this.endTypeRB == 0) {
                    this.startYA =
                            this.myFrame.bY4
                                    - (this.myFrame.bot1.partDimB + this.myFrame.bot1.partDimA);
                } else if (this.endTypeRB == 2) {
                    this.startYA =
                            this.myFrame.bY4
                                    - (this.myFrame.bot1.partDimB + this.myFrame.bot1.partDimA);
                } else if (this.endTypeRB == 3) {

                    if (this.myFrame.bot1.partDimB
                            + this.myFrame.bot1.partDimA != 0) {
                        this.startYA =
                                this.myFrame.bY4
                                        - this.myFrame.bot1.partDimB;
                    }
                }
            } else {
                theta =
                        Math.atan(this.myFrame.widthPix
                                / this.myFrame.dimB2);
                if (this.endTypeRB == 1 || this.endTypeRB == 0) {
                    this.startYA =
                            this.startY
                                    - (this.partDimB + this.partDimA)
                                    / Math.tan(theta)
                                    - (this.myFrame.top1.partDimB + this.myFrame.top1.partDimA)
                                    / Math.sin(theta);
                } else if (this.endTypeRB == 2) {
                    this.startYA =
                            this.startY
                                    - (this.partDimB + this.partDimA)
                                    / Math.tan(theta)
                                    - (this.myFrame.top1.partDimB + this.myFrame.top1.partDimA)
                                    / Math.sin(theta);
                } else if (this.endTypeRB == 3) {

                    if (this.myFrame.bot1.partDimB != 0) {
                        this.startYA =
                                this.startY
                                        - (this.partDimB + this.partDimA)
                                        / Math.tan(theta);
                    }
                }
            }
            if (this.myLean3 == 3 || this.myLean3 == 2) {

                double theta1 =
                        Math.atan(this.myFrame.dimC2
                                / this.myFrame.dimD1);
                final double theta2 =
                        Math.atan(this.myFrame.dimA1
                                / this.myFrame.dimD2);
                final double myTheta =
                        Math.toRadians(180) - theta1 - theta2;
                final double hypotenus =
                        (this.partDimB + this.partDimA)
                                / Math.sin(myTheta / 2);
                final double baseY =
                        hypotenus * Math.cos(myTheta / 2 + theta1);
                final double baseX =
                        hypotenus * Math.sin(myTheta / 2 + theta1);
                this.endXA = this.endX + baseX;// base;

                this.endYA = this.endY + baseY;
                theta1 =
                        Math.atan(this.myFrame.dimD1
                                / this.myFrame.dimC2);
                if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
                    this.startXA =
                            this.startX
                                    + (this.partDimB + this.partDimA)
                                    / Math.sin(theta1)
                                    - (this.partDimB + this.partDimA)
                                    / Math.tan(theta1);
                } else if (this.endTypeLT == 2) {// Straight Cut
                    this.startXA =
                            this.startX
                                    + (this.partDimB + this.partDimA)
                                    / Math.sin(theta1);
                } else if (this.endTypeLT == 3) {
                    this.startXA =
                            this.startX
                                    + (this.partDimB + this.partDimA)
                                    / Math.sin(theta1);
                }
                this.startYA =
                        this.startY
                                - this.myFrame.bot1.partDimB
                                - this.myFrame.bot1.partDimA;
            }
            this.myFrame.dimB0 = 0;

        }

        if (this.myLean4 == 2) { // LeanTop
            this.endXA = this.endX + this.partDimB + this.partDimA;
            this.startXA = this.endXA;
            this.stopAeX = this.endXA - this.partDimA;
            this.stopAsX = this.startXA - this.partDimA;
            double theta =
                    Math.atan(this.myFrame.widthPix
                            / this.myFrame.dimD1);

            if (this.myLean2 == 0 || this.myLean2 == 1) {
                if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered

                    this.endYA =
                            this.endY
                                    + this.myFrame.top1.partDimB
                                    + this.myFrame.top1.partDimA;
                    // ((this.partDimB+this.partDimA)*(double)
                    // Math.tan(theta));
                } else if (this.endTypeLT == 2) {// Straight Cut
                    this.endYA =
                            this.endY
                                    + this.myFrame.top1.partDimB
                                    + this.myFrame.top1.partDimA;
                    this.stopAeY = this.endYA;
                } else if (this.endTypeLT == 3) {
                    this.endYA = this.endY;// +
                    // (this.myLevelShape.top1.partDimB+this.myLevelShape.top1.partDimA);
                }
            } else {
                final double xtheta =
                        Math.atan(this.myTopWidth
                                / this.myFrame.dimB1);
                if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
                    this.endYA =
                            this.endY
                                    + (this.myFrame.top1.partDimB + this.myFrame.top1.partDimA)
                                    / Math.sin(xtheta)
                                    + (this.partDimB + this.partDimA)
                                    / Math.tan(xtheta);

                } else if (this.endTypeLT == 2) {// Straight Cut
                    this.endYA =
                            this.endY
                                    + (this.myFrame.top1.partDimB + this.myFrame.top1.partDimA)
                                    / Math.sin(xtheta)
                                    + (this.partDimB + this.partDimA)
                                    / Math.tan(xtheta);
                    this.stopAeY =
                            this.endYA
                                    - this.partDimA
                                    / Math.tan(xtheta);
                } else if (this.endTypeLT == 3) {
                    this.endYA =
                            this.endY
                                    + (this.partDimB + this.partDimA)
                                    / Math.tan(xtheta);
                    ;
                }

            }

            if (this.myLean2 == 0 || this.myLean2 == 1) {
                if (this.endTypeRB == 1 || this.endTypeRB == 0) {
                    this.startYA =
                            this.startY
                                    + (this.partDimB + this.partDimA)
                                    / Math.tan(theta)
                                    - (this.myFrame.bot1.partDimB + this.myFrame.bot1.partDimA)
                                    / Math.sin(theta);
                } else if (this.endTypeRB == 2) {
                    this.startYA =
                            this.startY
                                    + (this.partDimB + this.partDimA)
                                    / Math.tan(theta)
                                    - (this.myFrame.bot1.partDimB + this.myFrame.bot1.partDimA)
                                    / Math.sin(theta);
                    this.stopAsY =
                            this.startYA
                                    - this.partDimA
                                    / Math.tan(theta);
                } else if (this.endTypeRB == 3) {
                    this.startYA =
                            this.startY
                                    + (this.partDimB + this.partDimA)
                                    / Math.tan(theta);

                }
            } else {
                theta =
                        Math.atan(this.myFrame.widthPix
                                / this.myFrame.dimD1);
                if (this.endTypeRB == 1 || this.endTypeRB == 0) {
                    this.startYA =
                            this.startY
                                    + (this.partDimB + this.partDimA)
                                    / Math.tan(theta)
                                    - (this.myFrame.bot1.partDimB + this.myFrame.bot1.partDimA)
                                    / Math.sin(theta);
                } else if (this.endTypeRB == 2) {
                    this.startYA =
                            this.startY
                                    + (this.partDimB + this.partDimA)
                                    / Math.tan(theta)
                                    - (this.myFrame.bot1.partDimB + this.myFrame.bot1.partDimA)
                                    / Math.sin(theta);
                    this.stopAsY =
                            this.startYA
                                    - this.partDimA
                                    / Math.tan(theta);
                } else if (this.endTypeRB == 3) {
                    this.startYA =
                            this.startY
                                    + (this.partDimB + this.partDimA)
                                    / Math.tan(theta);

                }

            }
            this.myFrame.dimB0 = 0;

        }
        if (this.myLean4 == 3) { // Centered
            this.endXA = this.endX + this.partDimB + this.partDimA;
            this.startXA = this.endXA;
            double theta =
                    Math.atan(this.myTopWidth / this.myFrame.dimD2);
            if (this.myFrame.bot3.posInUse) {
                theta =
                        Math.atan(this.myFrame.dimA1
                                / this.myFrame.dimD2);
            }
            if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
                this.endYA =
                        startPointY
                                + this.myFrame.dimD2
                                - (this.partDimB + this.partDimA)
                                / Math.tan(theta)
                                + (this.myFrame.top1.partDimB + this.myFrame.top1.partDimA)
                                / Math.sin(theta);

            } else if (this.endTypeLT == 2) {// Straight Cut
                this.endYA =
                        this.endY
                                - (this.partDimB + this.partDimA)
                                / Math.tan(theta)
                                + (this.myFrame.top1.partDimB + this.myFrame.top1.partDimA)
                                / Math.sin(theta);
                this.stopAeY =
                        this.endYA + this.partDimA / Math.tan(theta);
            } else if (this.endTypeLT == 3) {
                this.endYA =
                        this.endY
                                - (this.partDimB + this.partDimA)
                                / Math.tan(theta);
            }
            theta = Math.atan(this.myTopWidth / this.myFrame.dimD0);
            if (this.myFrame.bot3.posInUse) {
                theta =
                        Math.atan(this.myFrame.dimC2
                                / this.myFrame.dimD0);
            }
            if (this.endTypeRB == 1 || this.endTypeRB == 0) {
                this.startYA =
                        this.myFrame.bY4
                                - this.myFrame.dimD0
                                + (this.partDimB + this.partDimA)
                                / Math.tan(theta)
                                - (this.myFrame.bot1.partDimB + this.myFrame.bot1.partDimA)
                                / Math.sin(theta);
            } else if (this.endTypeRB == 2) {
                this.startYA =
                        this.startY
                                + (this.partDimB + this.partDimA)
                                / Math.tan(theta)
                                - (this.myFrame.bot1.partDimB + this.myFrame.bot1.partDimA)
                                / Math.sin(theta);
                this.stopAsY =
                        this.startYA
                                - this.partDimA
                                / Math.tan(theta);
            } else if (this.endTypeRB == 3) {
                this.startYA =
                        this.startY
                                + (this.partDimB + this.partDimA)
                                / Math.tan(theta);

            }

        }
        if (this.myLean4 == 0) {

            this.startXA =
                    this.startX + this.partDimB + this.partDimA;
            this.endXA = this.endX + this.partDimB + this.partDimA;

            if (this.myLean == 2 || this.myLean == 3) {
                double theta =
                        Math.atan(this.myFrame.heightPix
                                / this.myFrame.dimA1);
                if (this.myLean == 3) {
                    theta =
                            Math.atan(this.myFrame.heightPix
                                    / this.myFrame.dimA0);
                }
                if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
                    if (this.myLean == 2) {
                        this.endXA =
                                this.endXBA
                                        + this.partDimA
                                        / Math.sin(theta)
                                        - this.myFrame.top1.partDimA
                                        / Math.tan(theta);
                    } else if (this.myLean == 3) {
                        this.endXA =
                                this.endXBA
                                        + this.partDimA
                                        / Math.sin(theta)
                                        - this.myFrame.top1.partDimA
                                        / Math.tan(theta);
                    }
                } else if (this.endTypeLT == 2) {// Straight Cut
                    if (this.myLean == 2) {
                        this.endXA =
                                this.endX
                                        + (this.partDimA + this.partDimB)
                                        / Math.sin(theta)
                                        - (this.myFrame.top1.partDimB + this.myFrame.top1.partDimA)
                                        / Math.tan(theta);
                    } else if (this.myLean == 3) {
                        this.endXA =
                                this.endX
                                        + (this.partDimA + this.partDimB)
                                        / Math.sin(theta)
                                        - (this.myFrame.top1.partDimB + this.myFrame.top1.partDimA)
                                        / Math.tan(theta);
                    }
                } else if (this.endTypeLT == 3) {
                    if (this.myLean == 2) {
                        this.endXA =
                                this.endXBA
                                        + this.partDimA
                                        / Math.sin(theta);
                    } else if (this.myLean == 3) {
                        this.endXA =
                                this.endXBA
                                        + this.partDimA
                                        / Math.sin(theta);
                    }
                }

            }

            if (this.myLean3 == 1 || this.myLean3 == 3) {
                final double theta =
                        Math.atan(this.myFrame.heightPix
                                / this.myFrame.dimC2);

                if (this.endTypeLT == 1 || this.endTypeLT == 0) { // Mitered
                    this.endXA =
                            this.endX
                                    + (this.myFrame.top1.partDimB + this.myFrame.top1.partDimA)
                                    / Math.tan(theta)
                                    + (this.partDimB + this.partDimA)
                                    / Math.sin(theta);
                } else if (this.endTypeLT == 2) {// Straight Cut
                    this.endXA =
                            this.endX
                                    + (this.myFrame.top1.partDimB + this.myFrame.top1.partDimA)
                                    / Math.tan(theta)
                                    + (this.partDimB + this.partDimA)
                                    / Math.sin(theta);
                    this.stopAeX =
                            this.endXA
                                    - this.partDimA
                                    / Math.tan(theta);
                } else if (this.endTypeLT == 3) {
                    this.endXA =
                            this.endX
                                    + (this.partDimB + this.partDimA)
                                    / Math.sin(theta);
                }

            }

            if (this.myLean == 2 || this.myLean == 3) {

                double theta =
                        Math.atan(this.myFrame.heightPix
                                / this.myFrame.dimA1);
                if (this.myLean == 3) {
                    theta =
                            Math.atan(this.myFrame.heightPix
                                    / this.myFrame.dimA0);
                }
                if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
                    this.startXA =
                            this.startX
                                    + (this.partDimB + this.partDimA)
                                    / Math.sin(theta)
                                    + (this.myFrame.bot1.partDimB + this.myFrame.bot1.partDimA)
                                    / Math.tan(theta);
                } else if (this.endTypeRB == 2) {// Straight Cut
                    this.startXA =
                            this.startX
                                    + (this.partDimB + this.partDimA)
                                    / Math.sin(theta)
                                    + (this.myFrame.bot1.partDimB + this.myFrame.bot1.partDimA)
                                    / Math.tan(theta);

                } else if (this.endTypeRB == 3) {
                    this.startXA =
                            this.startX
                                    + (this.partDimB + this.partDimA)
                                    / Math.sin(theta);
                }

            }

            if (this.myLean3 == 1 || this.myLean3 == 3) {
                final double theta =
                        Math.atan(this.myFrame.heightPix
                                / this.myFrame.dimC2);

                if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
                    this.startXA =
                            this.startX
                                    + (this.partDimB + this.partDimA)
                                    / Math.sin(theta)
                                    - (this.myFrame.bot1.partDimB + this.myFrame.bot1.partDimA)
                                    / Math.tan(theta);
                } else if (this.endTypeRB == 2) {// Straight Cut
                    this.startXA =
                            this.startX
                                    + (this.partDimB + this.partDimA)
                                    / Math.sin(theta)
                                    - (this.myFrame.bot1.partDimB + this.myFrame.bot1.partDimA)
                                    / Math.tan(theta);
                    this.stopAsX =
                            this.startXA
                                    + this.partDimA
                                    / Math.sin(theta);
                } else if (this.endTypeRB == 3) {
                    this.startXA =
                            this.startX
                                    + (this.partDimB + this.partDimA)
                                    / Math.sin(theta);
                }

            }

            if (this.myLean2 == 0 || this.myLean2 == 2) {
                if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
                    this.startYA =
                            this.myFrame.bY4
                                    - (this.myFrame.bot1.partDimB + this.myFrame.bot1.partDimA);
                } else if (this.endTypeRB == 2) {// Straight Cut
                    this.startYA =
                            this.startY
                                    - (this.myFrame.bot1.partDimB + this.myFrame.bot1.partDimA);
                } else if (this.endTypeRB == 3) {
                    this.startYA = this.startY;// this.myLevelShape.bY4-(this.myLevelShape.bot1.partDimB+this.myLevelShape.bot1.partDimA);
                }
            } else {
                final double myTheta =
                        Math.atan(this.myFrame.widthPix
                                / this.myFrame.dimB2);
                if (this.endTypeRB == 1 || this.endTypeRB == 0) { // Mitered
                    this.startYA =
                            this.myFrame.bY4
                                    - (this.partDimB + this.partDimA)
                                    / Math.tan(myTheta)
                                    - (this.myFrame.bot1.partDimB + this.myFrame.bot1.partDimA)
                                    / Math.sin(myTheta);
                } else if (this.endTypeRB == 2) {// Straight Cut
                    this.startYA =
                            this.myFrame.bY4
                                    - (this.partDimB + this.partDimA)
                                    / Math.tan(myTheta)
                                    - (this.myFrame.bot1.partDimB + this.myFrame.bot1.partDimA)
                                    / Math.sin(myTheta);
                    this.stopAsY =
                            this.startYA
                                    + this.partDimA
                                    / Math.tan(myTheta);
                    this.stopAsX = this.startXA - this.partDimA;
                } else if (this.endTypeRB == 3) {
                    this.startYA =
                            this.myFrame.bY4
                                    - (this.partDimB + this.partDimA)
                                    / Math.tan(myTheta)
                                    - this.myFrame.bot1.partDimB
                                    / Math.sin(myTheta);

                }
            }

            if (this.myLean2 == 0 || this.myLean2 == 1) {
                if (this.endTypeLT == 1 || this.endTypeLT == 0) {
                    this.endYA =
                            startPointY
                                    + this.myFrame.top1.partDimB
                                    + this.myFrame.top1.partDimA;
                } else if (this.endTypeLT == 2) {
                    this.endYA =
                            this.endY
                                    + this.myFrame.top1.partDimB
                                    + this.myFrame.top1.partDimA;
                    this.stopAeY = this.endYA;
                    this.stopAeX = this.endXA - this.partDimA;
                } else {
                    this.endYA = this.endY;// startPointY+(this.myLevelShape.top1.partDimB+this.myLevelShape.top1.partDimA);
                }
            } else {
                double myTheta =
                        Math.atan(this.myTopWidth
                                / this.myFrame.dimB1);
                if (this.myLean2 == 3) {
                    myTheta =
                            Math.atan(this.myTopWidth
                                    / this.myFrame.dimB0);
                }
                if (this.endTypeLT == 1 || this.endTypeLT == 0) {
                    this.endYA =
                            startPointY
                                    + (this.partDimB + this.partDimA)
                                    / Math.tan(myTheta)
                                    + (this.myFrame.top1.partDimB + this.myFrame.top1.partDimA)
                                    / Math.sin(myTheta);
                } else if (this.endTypeLT == 2) {
                    this.endYA =
                            this.endY
                                    + (this.partDimB + this.partDimA)
                                    / Math.tan(myTheta)
                                    + (this.myFrame.top1.partDimB + this.myFrame.top1.partDimA)
                                    / Math.sin(myTheta);
                    this.stopAeY =
                            this.endYA
                                    - this.partDimA
                                    / Math.tan(myTheta);
                    this.stopAeX = this.endXA - this.partDimA;
                } else {
                    this.endYA =
                            this.endY
                                    + (this.partDimB + this.partDimA)
                                    / Math.tan(myTheta);
                }

            }
        }

        if (this.myFrame.top1.partForm == 2
                || this.myFrame.top1.partForm == 3) {
            this.endYA = this.myFrame.top1.startYA;

        }

        // this.stopAeX = this.myFrame.top1.startXA;
        // this.stopAeY = this.myFrame.top1.startYA;
        //
        // this.stopAsX = this.myFrame.bot1.endXA;
        // this.stopAsY = this.myFrame.bot1.endYA;

        this.ltAngle =
                Math.atan((this.endX - this.endXA)
                        / (this.endY - this.endYA));
        this.rbAngle =
                Math.atan((this.endX - this.endXA)
                        / (this.endY - this.endYA));
    }

    public LeftObject clone() {
        try {

            LeftObject newObject = (LeftObject) super.clone();

            return newObject;

        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

}
