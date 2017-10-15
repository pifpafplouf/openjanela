/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Operations;


import Model.ProfileParts.Profiles;

import java.awt.geom.Arc2D;


public class CalculateGridV {

    AddMullionV addMullionV;

    double myThetaBot = 0;

    double myThetaBot2 = 0;

    double myThetaBot3 = 0;

    double myThetaBotA = 0;

    double myThetaBotC = 0;

    double baseRTBot = 0;

    double baseLBBot = 0;

    double baseRTBotc = 0;

    double baseLBBota = 0;

    double baseCenterBot = 0;

    double newYBotRT = 0;

    double newYBotLB = 0;

    double newYBotRTc = 0;

    double newYBotLBa = 0;

    double newYBotCenter = 0;

    double botXRT = 0;

    double botXRTc = 0;

    double botXLB = 0;

    double botXLBa = 0;

    double botXCenter = 0;

    boolean setYs = false;

    boolean setYe = false;

    double y1a3 = 0;

    double x2a3 = 0;

    double y2a3 = 0;

    double x3a3 = 0;

    double y3a3 = 0;

    double x4a3 = 0;

    double y4a3 = 0;

    public CalculateGridV(final AddMullionV parent) {
        addMullionV = parent;
        // TODO Auto-generated constructor stub
    }

    public void setInitValues(final Profiles myMullion) {

        botXRT = myMullion.x3;
        botXRTc = myMullion.x3cl;
        botXLB = myMullion.x4;
        botXLBa = myMullion.x4al;
        botXCenter = myMullion.centerXe;

        newYBotRT = addMullionV.vcEndY;
        newYBotLB = addMullionV.vcEndY;
        newYBotRTc = addMullionV.vcEndY;
        newYBotLBa = addMullionV.vcEndY;
        newYBotCenter = addMullionV.vcEndY;

        y1a3 = 0;
        x2a3 = 0;
        y2a3 = 0;
        x3a3 = 0;
        y3a3 = 0;
        x4a3 = 0;
        y4a3 = 0;

        setYs = false;
        setYe = false;
    }

    public Profiles calculateCoord(final Profiles myMullion) {

        this.setInitValues(myMullion);
        // // Top Ys
        if (addMullionV.limitStart.partForm == 1) {
            if ((myMullion.startPos == 1 || myMullion.startPos > 1)
                    && !addMullionV.inMiddle) {

                double hypCenter = addMullionV.dimTM;
                if (addMullionV.newAlpha > 0) {
                    hypCenter =
                            addMullionV.dimTM / Math
                                    .sin(addMullionV.newAlpha);
                } else if (addMullionV.thetaOffset > 0) {
                    hypCenter =
                            addMullionV.dimTM / Math
                                    .sin(addMullionV.thetaOffset);
                }

                if (myMullion.endTypeLT == 3) {

                    addMullionV.newStartingYRTc =
                            addMullionV.intersectY(myMullion.x2cl, //
                                    addMullionV.newStartingYRTc, //
                                    myMullion.x2cl, //
                                    newYBotRTc, //
                                    addMullionV.limitStartXsBA, //
                                    addMullionV.limitStartYsBA, //
                                    addMullionV.limitStartXeBA, //
                                    addMullionV.limitStartYeBA//
                            );

                    y1a3 = addMullionV.intersectY(
                            //
                            myMullion.x1al, //
                            addMullionV.newStartingYLBa, //
                            myMullion.x1al, //
                            newYBotLBa, //
                            addMullionV.limitStartXsA, //
                            addMullionV.limitStartYsA, //
                            addMullionV.limitStartXeA, //
                            addMullionV.limitStartYeA//
                    );

                    y2a3 = addMullionV.intersectY(
                            //
                            myMullion.x2cl, //
                            addMullionV.newStartingYLBa, //
                            myMullion.x2cl, //
                            newYBotLBa, //
                            addMullionV.limitStartXsA, //
                            addMullionV.limitStartYsA, //
                            addMullionV.limitStartXeA, //
                            addMullionV.limitStartYeA//
                    );

                    addMullionV.newStartingYLBa =
                            addMullionV.intersectY(
                                    //
                                    myMullion.x1al, //
                                    addMullionV.newStartingYLBa, //
                                    myMullion.x1al, //
                                    newYBotLBa, //
                                    addMullionV.limitStartXsBA, //
                                    addMullionV.limitStartYsBA, //
                                    addMullionV.limitStartXeBA, //
                                    addMullionV.limitStartYeBA//
                            );

                    addMullionV.newStartingYRT =
                            addMullionV.intersectY(
                                    //
                                    myMullion.x2, //
                                    addMullionV.newStartingYRT, //
                                    myMullion.x2, //
                                    newYBotRT, //
                                    addMullionV.limitStartXsBA, //
                                    addMullionV.limitStartYsBA, //
                                    addMullionV.limitStartXeBA, //
                                    addMullionV.limitStartYeBA//
                            );

                    addMullionV.newStartingYLB =
                            addMullionV.intersectY(
                                    //
                                    myMullion.x1, //
                                    addMullionV.newStartingYLB, //
                                    myMullion.x1, //
                                    newYBotLB, //
                                    addMullionV.limitStartXsBA, //
                                    addMullionV.limitStartYsBA, //
                                    addMullionV.limitStartXeBA, //
                                    addMullionV.limitStartYeBA//
                            );

                    addMullionV.newStartingYCenter =
                            addMullionV.intersectY(
                                    //
                                    myMullion.centerXs, //
                                    addMullionV.newStartingYCenter, //
                                    myMullion.centerXs, //
                                    newYBotCenter, //
                                    addMullionV.limitStartXsBA, //
                                    addMullionV.limitStartYsBA, //
                                    addMullionV.limitStartXeBA, //
                                    addMullionV.limitStartYeBA//
                            );

                } else if (myMullion.endTypeLT == 2) {

                    addMullionV.newStartingYRTc =
                            addMullionV.intersectY(myMullion.x2cl, //
                                    addMullionV.newStartingYRTc, //
                                    myMullion.x2cl, //
                                    newYBotRTc, //
                                    addMullionV.limitStartXsA, //
                                    addMullionV.limitStartYsA, //
                                    addMullionV.limitStartXeA, //
                                    addMullionV.limitStartYeA//
                            );

                    y2a3 = addMullionV.intersectY(myMullion.x2cl, //
                            addMullionV.newStartingYRTc, //
                            myMullion.x2cl, //
                            newYBotRTc, //
                            addMullionV.limitStartXsB, //
                            addMullionV.limitStartYsB, //
                            addMullionV.limitStartXeB, //
                            addMullionV.limitStartYeB//
                    );

                    addMullionV.newStartingYLBa =
                            addMullionV.intersectY(
                                    //
                                    myMullion.x1al, //
                                    addMullionV.newStartingYLBa, //
                                    myMullion.x1al, //
                                    newYBotLBa, //
                                    addMullionV.limitStartXsA, //
                                    addMullionV.limitStartYsA, //
                                    addMullionV.limitStartXeA, //
                                    addMullionV.limitStartYeA//
                            );

                    y1a3 = addMullionV.intersectY(
                            //
                            myMullion.x1al, //
                            addMullionV.newStartingYLBa, //
                            myMullion.x1al, //
                            newYBotLBa, //
                            addMullionV.limitStartXsB, //
                            addMullionV.limitStartYsB, //
                            addMullionV.limitStartXeB, //
                            addMullionV.limitStartYeB//
                    );

                    addMullionV.newStartingYRT =
                            addMullionV.intersectY(
                                    //
                                    myMullion.x2, //
                                    addMullionV.newStartingYRT, //
                                    myMullion.x2, //
                                    newYBotRT, //
                                    addMullionV.limitStartXsB, //
                                    addMullionV.limitStartYsB, //
                                    addMullionV.limitStartXeB, //
                                    addMullionV.limitStartYeB//
                            );

                    addMullionV.newStartingYLB =
                            addMullionV.intersectY(
                                    //
                                    myMullion.x1, //
                                    addMullionV.newStartingYLB, //
                                    myMullion.x1, //
                                    newYBotLB, //
                                    addMullionV.limitStartXsB, //
                                    addMullionV.limitStartYsB, //
                                    addMullionV.limitStartXeB, //
                                    addMullionV.limitStartYeB//
                            );

                    addMullionV.newStartingYCenter =
                            addMullionV.intersectY(
                                    //
                                    myMullion.centerXs, //
                                    addMullionV.newStartingYCenter, //
                                    myMullion.centerXs, //
                                    newYBotCenter, //
                                    addMullionV.limitStartXsB, //
                                    addMullionV.limitStartYsB, //
                                    addMullionV.limitStartXeB, //
                                    addMullionV.limitStartYeB//
                            );

                } else {

                    addMullionV.newStartingYRTc =
                            addMullionV.intersectY(
                                    //
                                    myMullion.x2cl, //
                                    addMullionV.newStartingYRTc, //
                                    myMullion.x2cl, //
                                    newYBotRTc, //

                                    addMullionV.limitStartXsA, //
                                    addMullionV.limitStartYsA, //
                                    addMullionV.limitStartXeA, //
                                    addMullionV.limitStartYeA//
                            );

                    addMullionV.newStartingYLBa =
                            addMullionV.intersectY(
                                    //
                                    myMullion.x1al, //
                                    addMullionV.newStartingYLBa, //
                                    myMullion.x1al, //
                                    newYBotLBa, //
                                    addMullionV.limitStartXsA, //
                                    addMullionV.limitStartYsA, //
                                    addMullionV.limitStartXeA, //
                                    addMullionV.limitStartYeA//
                            );

                    addMullionV.newStartingYCenter =
                            addMullionV.intersectY(
                                    //
                                    myMullion.centerXs, //
                                    addMullionV.newStartingYCenter, //
                                    myMullion.centerXs, //
                                    newYBotCenter, //
                                    addMullionV.limitStartXsBA, //
                                    addMullionV.limitStartYsBA
                                            - hypCenter, //
                                    addMullionV.limitStartXeBA, //
                                    addMullionV.limitStartYeBA
                                            - hypCenter//
                            );

                    addMullionV.newStartingYRT =
                            addMullionV.intersectY(
                                    //
                                    addMullionV.newStartingXRTc, //
                                    addMullionV.newStartingYRTc, //
                                    myMullion.centerXs, //
                                    addMullionV.newStartingYCenter, //
                                    myMullion.x2, //
                                    addMullionV.newStartingYRT, //
                                    myMullion.x2, //
                                    newYBotRT //
                            );

                    addMullionV.newStartingYLB =
                            addMullionV.intersectY(
                                    //
                                    //
                                    addMullionV.newStartingXLBa, //
                                    addMullionV.newStartingYLBa, //
                                    myMullion.centerXs, //
                                    addMullionV.newStartingYCenter, //
                                    myMullion.x1, //
                                    addMullionV.newStartingYLB, //
                                    myMullion.x1, //
                                    newYBotLB //
                            );

                }

            } else if ((myMullion.startPos == 1 || myMullion.startPos > 1)
                    && addMullionV.inMiddle) {

                final double hypCenter = addMullionV.dimTM;

                if (myMullion.endTypeLT == 3) {

                    addMullionV.newStartingYRTc =
                            addMullionV.intersectY(
                                    //
                                    addMullionV.newStartingXRTc, //
                                    addMullionV.newStartingYRTc, //
                                    myMullion.x3cl, //
                                    newYBotRTc, //
                                    addMullionV.limitStartXsBAm, //
                                    addMullionV.limitStartYsBAm, //
                                    addMullionV.limitStartXeBAm, //
                                    addMullionV.limitStartYeBAm//
                            );

                    addMullionV.newStartingYLBa =
                            addMullionV.intersectY(
                                    //
                                    addMullionV.newStartingXLBa, //
                                    addMullionV.newStartingYLBa, //
                                    myMullion.x4al, //
                                    newYBotLBa, //
                                    addMullionV.limitStartXsBA, //
                                    addMullionV.limitStartYsBA, //
                                    addMullionV.limitStartXeBA, //
                                    addMullionV.limitStartYeBA//
                            );

                    addMullionV.newStartingYRT =
                            addMullionV.intersectY(
                                    //
                                    addMullionV.newStartingXRT, //
                                    addMullionV.newStartingYRT, //
                                    myMullion.x3, //
                                    newYBotRT, //
                                    addMullionV.limitStartXsBAm, //
                                    addMullionV.limitStartYsBAm, //
                                    addMullionV.limitStartXeBAm, //
                                    addMullionV.limitStartYeBAm//
                            );

                    addMullionV.newStartingYLB =
                            addMullionV.intersectY(
                                    //
                                    addMullionV.newStartingXLB, //
                                    addMullionV.newStartingYLB, //
                                    myMullion.x4, //
                                    newYBotLB, //
                                    addMullionV.limitStartXsBA, //
                                    addMullionV.limitStartYsBA, //
                                    addMullionV.limitStartXeBA, //
                                    addMullionV.limitStartYeBA//
                            );

                    y2a3 = addMullionV.intersectY(
                            //
                            addMullionV.newStartingXRT, //
                            addMullionV.newStartingYRT, //
                            myMullion.x3, //
                            newYBotRT, //
                            addMullionV.limitStartXsBAm, //
                            addMullionV.limitStartYsBAm, //
                            addMullionV.limitStartXeBAm, //
                            addMullionV.limitStartYeBAm//
                    );

                    y1a3 = addMullionV.intersectY(
                            //
                            addMullionV.newStartingXLB, //
                            addMullionV.newStartingYLB, //
                            myMullion.x4, //
                            newYBotLB, //
                            addMullionV.limitStartXsBA, //
                            addMullionV.limitStartYsBA, //
                            addMullionV.limitStartXeBA, //
                            addMullionV.limitStartYeBA//
                    );
                    addMullionV.newStartingYCenter =
                            addMullionV.intersectY(
                                    //
                                    addMullionV.newStartingXCenter, //
                                    addMullionV.newStartingYCenter, //
                                    myMullion.centerXe, //
                                    newYBotCenter, //
                                    addMullionV.limitStartXsBA, //
                                    addMullionV.limitStartYsBA, //
                                    addMullionV.limitStartXeBA, //
                                    addMullionV.limitStartYeBA//
                            );

                } else if (myMullion.endTypeLT == 2) {

                    addMullionV.newStartingYRTc =
                            addMullionV.intersectY(
                                    //
                                    addMullionV.newStartingXRTc, //
                                    addMullionV.newStartingYRTc, //
                                    myMullion.x3cl, //
                                    newYBotRTc, //
                                    addMullionV.limitStartXsAm, //
                                    addMullionV.limitStartYsAm, //
                                    addMullionV.limitStartXeAm, //
                                    addMullionV.limitStartYeAm//
                            );

                    addMullionV.newStartingYLBa =
                            addMullionV.intersectY(
                                    //
                                    addMullionV.newStartingXLBa, //
                                    addMullionV.newStartingYLBa, //
                                    myMullion.x4al, //
                                    newYBotLBa, //
                                    addMullionV.limitStartXsA, //
                                    addMullionV.limitStartYsA, //
                                    addMullionV.limitStartXeA, //
                                    addMullionV.limitStartYeA//
                            );

                    addMullionV.newStartingYRT =
                            addMullionV.intersectY(
                                    //
                                    addMullionV.newStartingXRT, //
                                    addMullionV.newStartingYRT, //
                                    myMullion.x3, //
                                    newYBotRT, //
                                    addMullionV.limitStartXsBm, //
                                    addMullionV.limitStartYsBm, //
                                    addMullionV.limitStartXeBm, //
                                    addMullionV.limitStartYeBm//
                            );

                    addMullionV.newStartingYLB =
                            addMullionV.intersectY(
                                    //
                                    addMullionV.newStartingXLB, //
                                    addMullionV.newStartingYLB, //
                                    myMullion.x4, //
                                    newYBotLB, //
                                    addMullionV.limitStartXsB, //
                                    addMullionV.limitStartYsB, //
                                    addMullionV.limitStartXeB, //
                                    addMullionV.limitStartYeB//
                            );

                    addMullionV.newStartingYCenter =
                            addMullionV.intersectY(
                                    //
                                    addMullionV.newStartingXCenter, //
                                    addMullionV.newStartingYCenter, //
                                    myMullion.centerXe, //
                                    newYBotCenter, //
                                    addMullionV.limitStartXsB, //
                                    addMullionV.limitStartYsB, //
                                    addMullionV.limitStartXeB, //
                                    addMullionV.limitStartYeB//
                            );

                } else {

                    addMullionV.newStartingYRTc =
                            addMullionV.intersectY(
                                    //
                                    addMullionV.newStartingXRTc, //
                                    addMullionV.newStartingYRTc, //
                                    myMullion.x3cl, //
                                    newYBotRTc, //
                                    addMullionV.limitStartXsAm, //
                                    addMullionV.limitStartYsAm, //
                                    addMullionV.limitStartXeAm, //
                                    addMullionV.limitStartYeAm//
                            );

                    addMullionV.newStartingYLBa =
                            addMullionV.intersectY(
                                    //
                                    addMullionV.newStartingXLBa, //
                                    addMullionV.newStartingYLBa, //
                                    myMullion.x4al, //
                                    newYBotLBa, //
                                    addMullionV.limitStartXsA, //
                                    addMullionV.limitStartYsA, //
                                    addMullionV.limitStartXeA, //
                                    addMullionV.limitStartYeA//
                            );

                    addMullionV.newStartingYCenter =
                            addMullionV.intersectY(
                                    //
                                    addMullionV.newStartingXCenter, //
                                    addMullionV.newStartingYCenter, //
                                    myMullion.centerXe, //
                                    newYBotCenter, //
                                    addMullionV.limitStartXsBA, //
                                    addMullionV.limitStartYsBA
                                            - hypCenter, //
                                    addMullionV.limitStartXeBA, //
                                    addMullionV.limitStartYeBA
                                            - hypCenter//
                            );

                    addMullionV.newStartingYRT =
                            addMullionV.intersectY(
                                    //
                                    addMullionV.newStartingXRTc, //
                                    addMullionV.newStartingYRTc, //
                                    myMullion.centerXs, //
                                    addMullionV.newStartingYCenter, //
                                    addMullionV.newStartingXRT, //
                                    addMullionV.newStartingYRT, //
                                    myMullion.x3, //
                                    newYBotRT//
                            );

                    addMullionV.newStartingYLB =
                            addMullionV.intersectY(
                                    //
                                    //
                                    addMullionV.newStartingXLBa, //
                                    addMullionV.newStartingYLBa, //
                                    myMullion.centerXs, //
                                    addMullionV.newStartingYCenter, //
                                    addMullionV.newStartingXLB, //
                                    addMullionV.newStartingYLB, //
                                    myMullion.x4, //
                                    newYBotLB//
                            );

                }
            }
        }
        if (addMullionV.limitStart.partForm == 2) {
//                && myMullion.startPos == 1) {

            this.calculateCoordinArchIIT(myMullion);
            setYs = true;
        }// top =1 & Radius > 0 && partform == 2

        if (addMullionV.myParentBO.noSidesTop == 1
//                && myMullion.startPos == 1
                && addMullionV.limitStart.partForm == 3) {

            this.getCCoordinatesForEllipse(myMullion);
            setYs = true;
        }

        this.botCoordsii(myMullion);

        // //////////////////////////////////////////////////////
        if (!setYs) {

            myMullion.centerYs = addMullionV.newStartingYCenter;
            myMullion.y1 = addMullionV.newStartingYLB;

            myMullion.y2 = addMullionV.newStartingYRT;

            myMullion.y1al =
                    myMullion.y1a = addMullionV.newStartingYLBa;

            myMullion.y2cl =
                    myMullion.y2a = addMullionV.newStartingYRTc;
            if (y2a3 > 0) {
                myMullion.y1a3 = y1a3;
                myMullion.y2a3 = y2a3;
            }
        }
        if (!setYe) {

            myMullion.centerYe = newYBotCenter;
            myMullion.y4 = newYBotLB;
            myMullion.y3 = newYBotRT;

            myMullion.y4al = myMullion.y4a = newYBotLBa;

            myMullion.y3cl = myMullion.y3a = newYBotRTc;
            if (y3a3 > 0) {
                myMullion.y4a3 = y4a3;
                myMullion.y3a3 = y3a3;
            }

        }

        if (myMullion.cOrM == 2) {
            myMullion.glazedInOut();
        } else if (myMullion.cOrM == 1) {
            myMullion.couplerDraw();
        }

// recalcM

        return myMullion;
    }

    // ////////////////////////////////////

    public Profiles calculateCoordinArchIIT(final Profiles myMullion) {

        // if (addMullionH.newStartingYLBa <
// addMullionH.myParentBO.myParent.startingY
        // +
// addMullionH.myParentBO.myParent.dimD2
        // && addMullionH.myParentBO.radius1 >
// 0
        // && addMullionH.myParentBO.noSidesTop
// == 1) {
        setYs = true;
        final EllipseLineIntersections arcX =
                new EllipseLineIntersections();

        if (myMullion.endTypeLT == 3) {

            myMullion.centerYs =
                    arcX.getYusingX(
                            myMullion.centerXs,
                            myMullion.centerYs,
                            myMullion.centerXe,
                            myMullion.centerYe,
                            addMullionV.limitStart.radius1BA,
                            addMullionV.limitStart.x1,
                            addMullionV.limitStart.y1,
                            false);

            myMullion.y1 =
                    myMullion.y1a3 =
                            myMullion.y1a =
                                    y1a3 =
                                            arcX
                                                    .getYusingX(
                                                            myMullion.x1,
                                                            myMullion.y1,
                                                            myMullion.x4,
                                                            myMullion.y4,
                                                            addMullionV.limitStart.radius1BA,
                                                            addMullionV.limitStart.x1,
                                                            addMullionV.limitStart.y1,
                                                            false);

            myMullion.y1al =
                    arcX.getYusingX(
                            myMullion.x1al,
                            myMullion.y1al,
                            myMullion.x4al,
                            myMullion.y4al,
                            addMullionV.limitStart.radius1BA,
                            addMullionV.limitStart.x1,
                            addMullionV.limitStart.y1,
                            false);
            if (!addMullionV.inMiddle) {
                myMullion.y2 =
                        myMullion.y2a3 =
                                myMullion.y2a =
                                        y2a3 =
                                                arcX
                                                        .getYusingX(
                                                                myMullion.x2,
                                                                myMullion.y2,
                                                                myMullion.x3,
                                                                myMullion.y3,
                                                                addMullionV.limitStart.radius1BA,
                                                                addMullionV.limitStart.x1,
                                                                addMullionV.limitStart.y1,
                                                                false);

                myMullion.y2cl =
                        arcX.getYusingX(
                                myMullion.x2cl,
                                myMullion.y2cl,
                                myMullion.x3cl,
                                myMullion.y3cl,
                                addMullionV.limitStart.radius1BA,
                                addMullionV.limitStart.x1,
                                addMullionV.limitStart.y1,
                                false);
            } else {
                myMullion.y2 =
                        myMullion.y2a3 =
                                myMullion.y2a =
                                        y2a3 =
                                                arcX
                                                        .getYusingX(
                                                                myMullion.x2,
                                                                myMullion.y2,
                                                                myMullion.x3,
                                                                myMullion.y3,
                                                                addMullionV.limitStart2.radius1BA,
                                                                addMullionV.limitStart2.x1,
                                                                addMullionV.limitStart2.y1,
                                                                false);

                myMullion.y2cl =
                        arcX.getYusingX(
                                myMullion.x2cl,
                                myMullion.y2cl,
                                myMullion.x3cl,
                                myMullion.y3cl,
                                addMullionV.limitStart2.radius1,
                                addMullionV.limitStart2.x1,
                                addMullionV.limitStart2.y1,
                                false);
            }
        }
        if (myMullion.endTypeLT == 2) {

            myMullion.centerYs =
                    arcX.getYusingX(
                            myMullion.centerXs,
                            myMullion.centerYs,
                            myMullion.centerXe,
                            myMullion.centerYe,
                            addMullionV.limitStart.radius1BA,
                            addMullionV.limitStart.x1,
                            addMullionV.limitStart.y1,
                            false);

            myMullion.y1 =
                    arcX.getYusingX(
                            myMullion.x1,
                            myMullion.y1,
                            myMullion.x4,
                            myMullion.y4,
                            addMullionV.limitStart.radius1BA,
                            addMullionV.limitStart.x1,
                            addMullionV.limitStart.y1,
                            false);

            myMullion.y1al =
                    arcX.getYusingX(
                            myMullion.x1al,
                            myMullion.y1al,
                            myMullion.x4al,
                            myMullion.y4al,
                            addMullionV.limitStart.radius1BA,
                            addMullionV.limitStart.x1,
                            addMullionV.limitStart.y1,
                            false);

            if (!addMullionV.inMiddle) {

                myMullion.y2 =
                        arcX.getYusingX(
                                myMullion.x2,
                                myMullion.y2,
                                myMullion.x3,
                                myMullion.y3,
                                addMullionV.limitStart.radius1BA,
                                addMullionV.limitStart.x1,
                                addMullionV.limitStart.y1,
                                false);

                myMullion.y2cl =
                        arcX.getYusingX(
                                myMullion.x2cl,
                                myMullion.y2cl,
                                myMullion.x3cl,
                                myMullion.y3cl,
                                addMullionV.limitStart.radius1BA,
                                addMullionV.limitStart.x1,
                                addMullionV.limitStart.y1,
                                false);
            } else {
                myMullion.y2 =
                        arcX.getYusingX(
                                myMullion.x2,
                                myMullion.y2,
                                myMullion.x3,
                                myMullion.y3,
                                addMullionV.limitStart2.radius1BA,
                                addMullionV.limitStart2.x1,
                                addMullionV.limitStart2.y1,
                                false);

                myMullion.y2cl =
                        arcX.getYusingX(
                                myMullion.x2cl,
                                myMullion.y2cl,
                                myMullion.x3cl,
                                myMullion.y3cl,
                                addMullionV.limitStart2.radius1BA,
                                addMullionV.limitStart2.x1,
                                addMullionV.limitStart2.y1,
                                false);
            }

        }
        if (myMullion.endTypeLT == 1) {

            myMullion.centerYs =
                    arcX.getYusingX(
                            myMullion.centerXs,
                            myMullion.centerYs,
                            myMullion.centerXe,
                            myMullion.centerYe,
                            addMullionV.limitStart.radius1
                                    - addMullionV.limitStart.partDimC
                                    - addMullionV.dimTM,
                            addMullionV.limitStart.x1,
                            addMullionV.limitStart.y1,
                            false);

            myMullion.y1 =
                    arcX.getYusingX(
                            myMullion.x1,
                            myMullion.y1,
                            myMullion.x4,
                            myMullion.y4,
                            addMullionV.limitStart.radius1BA,
                            addMullionV.limitStart.x1,
                            addMullionV.limitStart.y1,
                            false);

            myMullion.y1al =
                    arcX.getYusingX(
                            myMullion.x1al,
                            myMullion.y1al,
                            myMullion.x4al,
                            myMullion.y4al,
                            addMullionV.limitStart.radius1A,
                            addMullionV.limitStart.x1,
                            addMullionV.limitStart.y1,
                            false);

            if (!addMullionV.inMiddle) {

                myMullion.y2 =
                        arcX.getYusingX(
                                myMullion.x2,
                                myMullion.y2,
                                myMullion.x3,
                                myMullion.y3,
                                addMullionV.limitStart.radius1BA,
                                addMullionV.limitStart.x1,
                                addMullionV.limitStart.y1,
                                false);

                myMullion.y2cl =
                        arcX.getYusingX(
                                myMullion.x2cl,
                                myMullion.y2cl,
                                myMullion.x3cl,
                                myMullion.y3cl,
                                addMullionV.limitStart.radius1A,
                                addMullionV.limitStart.x1,
                                addMullionV.limitStart.y1,
                                false);
            } else {

                myMullion.y2 =
                        arcX.getYusingX(
                                myMullion.x2,
                                myMullion.y2,
                                myMullion.x3,
                                myMullion.y3,
                                addMullionV.limitStart2.radius1BA,
                                addMullionV.limitStart2.x1,
                                addMullionV.limitStart2.y1,
                                false);

                myMullion.y2cl =
                        arcX.getYusingX(
                                myMullion.x2cl,
                                myMullion.y2cl,
                                myMullion.x3cl,
                                myMullion.y3cl,
                                addMullionV.limitStart2.radius1A,
                                addMullionV.limitStart2.x1,
                                addMullionV.limitStart2.y1,
                                false);
            }
        }
        // }
        return myMullion;
    }

    public Profiles calculateCoordinArchIIB(final Profiles myMullion) {

        setYs = true;
        final EllipseLineIntersections arcX =
                new EllipseLineIntersections();

        if (myMullion.endTypeLT == 3) {

            myMullion.centerYe =
                    arcX.getYusingX(
                            myMullion.centerXs,
                            myMullion.centerYs,
                            myMullion.centerXe,
                            myMullion.centerYe,
                            addMullionV.limitEnd.radius1,
                            addMullionV.limitEnd.x1,
                            addMullionV.limitEnd.y1,
                            true);

            myMullion.y4 =
                    arcX.getYusingX(
                            myMullion.x1,
                            myMullion.y1,
                            myMullion.x4,
                            myMullion.y4,
                            addMullionV.limitEnd.radius1,
                            addMullionV.limitEnd.x1,
                            addMullionV.limitEnd.y1,
                            true);

            myMullion.y4al =
                    arcX.getYusingX(
                            myMullion.x1al,
                            myMullion.y1al,
                            myMullion.x4al,
                            myMullion.y4al,
                            addMullionV.limitEnd.radius1,
                            addMullionV.limitEnd.x1,
                            addMullionV.limitEnd.y1,
                            true);

            myMullion.y3 =
                    arcX.getYusingX(
                            myMullion.x2,
                            myMullion.y2,
                            myMullion.x3,
                            myMullion.y3,
                            addMullionV.limitEnd.radius1,
                            addMullionV.limitEnd.x1,
                            addMullionV.limitEnd.y1,
                            true);

            myMullion.y3cl =
                    arcX.getYusingX(
                            myMullion.x2cl,
                            myMullion.y2cl,
                            myMullion.x3cl,
                            myMullion.y3cl,
                            addMullionV.limitEnd.radius1,
                            addMullionV.limitEnd.x1,
                            addMullionV.limitEnd.y1,
                            true);
        }
        if (myMullion.endTypeLT == 2) {

            myMullion.centerYe =
                    arcX.getYusingX(
                            myMullion.centerXs,
                            myMullion.centerYs,
                            myMullion.centerXe,
                            myMullion.centerYe,
                            addMullionV.limitEnd.radius1BA,
                            addMullionV.limitEnd.x1,
                            addMullionV.limitEnd.y1,
                            true);

            myMullion.y4 =
                    arcX.getYusingX(
                            myMullion.x1,
                            myMullion.y1,
                            myMullion.x4,
                            myMullion.y4,
                            addMullionV.limitEnd.radius1BA,
                            addMullionV.limitEnd.x1,
                            addMullionV.limitEnd.y1,
                            true);

            myMullion.y4al =
                    arcX.getYusingX(
                            myMullion.x1al,
                            myMullion.y1al,
                            myMullion.x4al,
                            myMullion.y4al,
                            addMullionV.limitEnd.radius1BA,
                            addMullionV.limitEnd.x1,
                            addMullionV.limitEnd.y1,
                            true);

            myMullion.y3 =
                    arcX.getYusingX(
                            myMullion.x2,
                            myMullion.y2,
                            myMullion.x3,
                            myMullion.y3,
                            addMullionV.limitEnd.radius1BA,
                            addMullionV.limitEnd.x1,
                            addMullionV.limitEnd.y1,
                            true);

            myMullion.y3cl =
                    arcX.getYusingX(
                            myMullion.x2cl,
                            myMullion.y2cl,
                            myMullion.x3cl,
                            myMullion.y3cl,
                            addMullionV.limitEnd.radius1BA,
                            addMullionV.limitEnd.x1,
                            addMullionV.limitEnd.y1,
                            true);
        }
        if (myMullion.endTypeLT == 1) {

            myMullion.centerYe =
                    arcX.getYusingX(
                            myMullion.centerXs,
                            myMullion.centerYs,
                            myMullion.centerXe,
                            myMullion.centerYe,
                            addMullionV.limitEnd.radius1
                                    - addMullionV.dimTM,
                            addMullionV.limitEnd.x1,
                            addMullionV.limitEnd.y1,
                            true);

            myMullion.y4 =
                    arcX.getYusingX(
                            myMullion.x1,
                            myMullion.y1,
                            myMullion.x4,
                            myMullion.y4,
                            addMullionV.limitEnd.radius1BA,
                            addMullionV.limitEnd.x1,
                            addMullionV.limitEnd.y1,
                            true);

            myMullion.y3 =
                    arcX.getYusingX(
                            myMullion.x2,
                            myMullion.y2,
                            myMullion.x3,
                            myMullion.y3,
                            addMullionV.limitEnd.radius1BA,
                            addMullionV.limitEnd.x1,
                            addMullionV.limitEnd.y1,
                            true);

            myMullion.y4al =
                    arcX.getYusingX(
                            myMullion.x1al,
                            myMullion.y1al,
                            myMullion.x4al,
                            myMullion.y4al,
                            addMullionV.limitEnd.radius1A,
                            addMullionV.limitEnd.x1,
                            addMullionV.limitEnd.y1,
                            true);

            myMullion.y3cl =
                    arcX.getYusingX(
                            myMullion.x2cl,
                            myMullion.y2cl,
                            myMullion.x3cl,
                            myMullion.y3cl,
                            addMullionV.limitEnd.radius1A,
                            addMullionV.limitEnd.x1,
                            addMullionV.limitEnd.y1,
                            true);
        }
        return myMullion;
    }

//
//
// public Profiles getCCoordinatedForMyMullionII(
// final Profiles myMullion)
// {
//
//
// if (addMullionV.newStartingXLBa > //
// addMullionV.myParentBO.startingX
// + addMullionV.myParentBO.dimA1)
// {
//
// addMullionV.baseRT =
// addMullionV.myParentBO.radius1
// - (addMullionV.myParentBO.bX2 -
// addMullionV.newStartingXRT);
//
// addMullionV.baseLB =
// addMullionV.myParentBO.radius1
// - (addMullionV.myParentBO.bX2 -
// addMullionV.newStartingXLB);
//
// addMullionV.baseRTc =
// addMullionV.myParentBO.radius1
// - (addMullionV.myParentBO.bX2 -
// addMullionV.newStartingXRTc);
//
// addMullionV.baseLBa =
// addMullionV.myParentBO.radius1
// - (addMullionV.myParentBO.bX2 -
// addMullionV.newStartingXLBa);
//
// addMullionV.baseCenter =
// addMullionV.myParentBO.radius1
// - (addMullionV.myParentBO.bX2 -
// addMullionV.newStartingXCenter);
//
// if (myMullion.endTypeLT == 3)
// {
//
// addMullionV.newAlpha =
// Math
// .acos(addMullionV.baseRT
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha2 =
// Math
// .acos(addMullionV.baseLB
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha3 =
// Math
// .acos(addMullionV.baseCenter
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaA =
// Math
// .acos(addMullionV.baseLBa
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaC =
// Math
// .acos(addMullionV.baseRTc
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYRT =
// (addMullionV.myParentBO.radius1 * Math
// .sin(addMullionV.newAlpha));
//
// addMullionV.newStartingYLB =
// (Math
// .sin(addMullionV.newAlpha2) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYCenter =
// (Math
// .sin(addMullionV.newAlpha3) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYRTc =
// (addMullionV.myParentBO.radius1 * Math
// .sin(addMullionV.newAlphaC));
//
// addMullionV.newStartingYLBa =
// (Math
// .sin(addMullionV.newAlphaA) *
// addMullionV.myParentBO.radius1);
// }
//
// else if (myMullion.endTypeLT == 2)
// {
//
// addMullionV.baseRT =
// addMullionV.myParentBO.radius1
// - (addMullionV.myParentBO.bX2 -
// addMullionV.newStartingXRT);
//
// addMullionV.baseLB =
// addMullionV.myParentBO.radius1
// - (addMullionV.myParentBO.bX2 -
// addMullionV.newStartingXLB);
//
// addMullionV.baseRTc =
// addMullionV.myParentBO.radius1
// - (addMullionV.myParentBO.bX2 -
// addMullionV.newStartingXRTc);
//
// addMullionV.baseLBa =
// addMullionV.myParentBO.radius1
// - (addMullionV.myParentBO.bX2 -
// addMullionV.newStartingXLBa);
//
// addMullionV.baseCenter =
// addMullionV.myParentBO.radius1
// - (addMullionV.myParentBO.bX2 -
// addMullionV.newStartingXCenter);
//
// addMullionV.newAlphaF =
// Math
// .acos(addMullionV.baseRT
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha2F =
// Math
// .acos(addMullionV.baseLB
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha3F =
// Math
// .acos(addMullionV.baseCenter
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaAF =
// Math
// .acos(addMullionV.baseLBa
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaCF =
// Math
// .acos(addMullionV.baseRTc
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYRT =
// (addMullionV.myParentBO.radius1 * Math
// .sin(addMullionV.newAlphaF));
//
// addMullionV.newStartingYLB =
// (Math
// .sin(addMullionV.newAlpha2F) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYCenter =
// (Math
// .sin(addMullionV.newAlpha3F) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYRTc =
// ((addMullionV.myParentBO.radius1 - addMullionV.dimTA) *
// Math
// .sin(addMullionV.newAlphaCF));
//
// addMullionV.newStartingYLBa =
// (Math
// .sin(addMullionV.newAlphaAF) *
// (addMullionV.myParentBO.radius1 - addMullionV.dimTA));
// }
//
// else
// {
// addMullionV.newAlpha =
// Math
// .acos(addMullionV.baseRT
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha2 =
// Math
// .acos(addMullionV.baseLB
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha3 =
// Math
// .acos(addMullionV.baseCenter
// / (addMullionV.myParentBO.radius1 + addMullionV.dimTM));
//
// addMullionV.newAlphaA =
// Math
// .acos(addMullionV.baseLBa
// / (addMullionV.myParentBO.radius1 - addMullionV.dimTA));
//
// addMullionV.newAlphaC =
// Math
// .acos(addMullionV.baseRTc
// / (addMullionV.myParentBO.radius1 - addMullionV.dimTA));
//
// addMullionV.newStartingYRT =
// (addMullionV.myParentBO.radius1 * Math
// .sin(addMullionV.newAlpha));
//
// addMullionV.newStartingYLB =
// (Math
// .sin(addMullionV.newAlpha2) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYCenter =
// (Math
// .sin(addMullionV.newAlpha3) *
// (addMullionV.myParentBO.radius1 + addMullionV.dimTM));
//
// addMullionV.newStartingYRTc =
// ((addMullionV.myParentBO.radius1 - addMullionV.dimTA) *
// Math
// .sin(addMullionV.newAlphaC));
//
// addMullionV.newStartingYLBa =
// (Math
// .sin(addMullionV.newAlphaA) *
// (addMullionV.myParentBO.radius1 - addMullionV.dimTA));
//
// }
// }
// else if (addMullionV.newStartingXRTc < //
// addMullionV.myParentBO.startingX
// + addMullionV.myParentBO.dimA1)
// {
// addMullionV.baseRT =
// addMullionV.myParentBO.centerPointX
// - addMullionV.newStartingXRT;
//
// addMullionV.baseLB =
// addMullionV.myParentBO.centerPointX
// - addMullionV.newStartingXLB;
//
// addMullionV.baseRTc =
// addMullionV.myParentBO.centerPointX
// - addMullionV.newStartingXRTc;
//
// addMullionV.baseLBa =
// addMullionV.myParentBO.centerPointX
// - addMullionV.newStartingXLBa;
//
// addMullionV.baseCenter =
// addMullionV.myParentBO.centerPointX
// - addMullionV.newStartingXCenter;
// if (myMullion.endTypeLT == 3)
// {
//
// addMullionV.newAlpha =
// Math
// .acos(addMullionV.baseRT
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha2 =
// Math
// .acos(addMullionV.baseLB
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha3 =
// Math
// .acos(addMullionV.baseCenter
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaA =
// Math
// .acos(addMullionV.baseLBa
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaC =
// Math
// .acos(addMullionV.baseRTc
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYRT =
// (addMullionV.myParentBO.radius1 * Math
// .sin(addMullionV.newAlpha));
//
// addMullionV.newStartingYLB =
// (Math
// .sin(addMullionV.newAlpha2) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYCenter =
// (Math
// .sin(addMullionV.newAlpha3) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYRTc =
// (addMullionV.myParentBO.radius1 * Math
// .sin(addMullionV.newAlphaC));
//
// addMullionV.newStartingYLBa =
// (Math
// .sin(addMullionV.newAlphaA) *
// addMullionV.myParentBO.radius1);
// }
//
// else if (myMullion.endTypeLT == 2)
// {
// addMullionV.baseRT =
// addMullionV.myParentBO.centerPointX
// - addMullionV.newStartingXRT;
//
// addMullionV.baseLB =
// addMullionV.myParentBO.centerPointX
// - addMullionV.newStartingXLB;
//
// addMullionV.baseRTc =
// addMullionV.myParentBO.centerPointX
// - addMullionV.newStartingXRTc;
//
// addMullionV.baseLBa =
// addMullionV.myParentBO.centerPointX
// - addMullionV.newStartingXLBa;
//
// addMullionV.baseCenter =
// addMullionV.myParentBO.centerPointX
// - addMullionV.newStartingXCenter;
//
// addMullionV.newAlphaF =
// Math
// .acos(addMullionV.baseRT
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha2F =
// Math
// .acos(addMullionV.baseLB
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha3F =
// Math
// .acos(addMullionV.baseCenter
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaAF =
// Math
// .acos(addMullionV.baseLBa
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaCF =
// Math
// .acos(addMullionV.baseRTc
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYRT =
// (addMullionV.myParentBO.radius1 * Math
// .sin(addMullionV.newAlphaF));
//
// addMullionV.newStartingYLB =
// (Math
// .sin(addMullionV.newAlpha2F) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYCenter =
// (Math
// .sin(addMullionV.newAlpha3F) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYRTc =
// ((addMullionV.myParentBO.radius1 - addMullionV.dimTA) *
// Math
// .sin(addMullionV.newAlphaCF));
//
// addMullionV.newStartingYLBa =
// (Math
// .sin(addMullionV.newAlphaAF) *
// (addMullionV.myParentBO.radius1 - addMullionV.dimTA));
// }
//
// else
// {
// addMullionV.newAlpha =
// Math
// .acos(addMullionV.baseRT
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha2 =
// Math
// .acos(addMullionV.baseLB
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha3 =
// Math
// .acos(addMullionV.baseCenter
// / (addMullionV.myParentBO.radius1 + addMullionV.dimTM));
//
// addMullionV.newAlphaA =
// Math
// .acos(addMullionV.baseLBa
// / (addMullionV.myParentBO.radius1 - addMullionV.dimTA));
//
// addMullionV.newAlphaC =
// Math
// .acos(addMullionV.baseRTc
// / (addMullionV.myParentBO.radius1 - addMullionV.dimTA));
//
// addMullionV.newStartingYRT =
// (addMullionV.myParentBO.radius1 * Math
// .sin(addMullionV.newAlpha));
//
// addMullionV.newStartingYLB =
// (Math
// .sin(addMullionV.newAlpha2) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYCenter =
// (Math
// .sin(addMullionV.newAlpha3) *
// (addMullionV.myParentBO.radius1 + addMullionV.dimTM));
//
// addMullionV.newStartingYRTc =
// ((addMullionV.myParentBO.radius1 - addMullionV.dimTA) *
// Math
// .sin(addMullionV.newAlphaC));
//
// addMullionV.newStartingYLBa =
// (Math
// .sin(addMullionV.newAlphaA) *
// (addMullionV.myParentBO.radius1 - addMullionV.dimTA));
//
// }
// }
// else if (addMullionV.newStartingXCenter == //
// addMullionV.myParentBO.startingX
// + addMullionV.myParentBO.dimA1)
// {
//
// addMullionV.baseRT =
// addMullionV.myParentBO.radius1
// - (addMullionV.myParentBO.bX2 -
// addMullionV.newStartingXRT);
//
// addMullionV.baseRTc =
// addMullionV.myParentBO.radius1
// - (addMullionV.myParentBO.bX2 -
// addMullionV.newStartingXRTc);
//
// addMullionV.baseLB =
// addMullionV.myParentBO.centerPointX
// - addMullionV.newStartingXLB;
//
// addMullionV.baseLBa =
// addMullionV.myParentBO.centerPointX
// - addMullionV.newStartingXLBa;
//
// addMullionV.baseCenter =
// addMullionV.myParentBO.centerPointX
// - addMullionV.newStartingXCenter;
// if (myMullion.endTypeLT == 3)
// {
//
// addMullionV.newAlpha =
// Math
// .acos(addMullionV.baseRT
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaC =
// Math
// .acos(addMullionV.baseRTc
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha2 =
// Math
// .acos(addMullionV.baseLB
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaA =
// Math
// .acos(addMullionV.baseLBa
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha3 =
// Math
// .acos(addMullionV.baseCenter
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYRT =
// (addMullionV.myParentBO.radius1 * Math
// .sin(addMullionV.newAlpha));
//
// addMullionV.newStartingYLB =
// (Math
// .sin(addMullionV.newAlpha2) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYCenter =
// (Math
// .sin(addMullionV.newAlpha3) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYRTc =
// (addMullionV.myParentBO.radius1 * Math
// .sin(addMullionV.newAlphaC));
//
// addMullionV.newStartingYLBa =
// (Math
// .sin(addMullionV.newAlphaA) *
// addMullionV.myParentBO.radius1);
// }
// else if (myMullion.endTypeLT == 2)
// {
//
// addMullionV.baseRT =
// addMullionV.myParentBO.radius1
// - (addMullionV.myParentBO.bX2 -
// addMullionV.newStartingXRT);
//
// addMullionV.baseRTc =
// addMullionV.myParentBO.radius1
// - (addMullionV.myParentBO.bX2 -
// addMullionV.newStartingXRTc);
//
// addMullionV.baseLB =
// addMullionV.myParentBO.centerPointX
// - addMullionV.newStartingXLB;
//
// addMullionV.baseLBa =
// addMullionV.myParentBO.centerPointX
// - addMullionV.newStartingXLBa;
//
// addMullionV.baseCenter =
// addMullionV.myParentBO.centerPointX
// - addMullionV.newStartingXCenter;
//
// addMullionV.newAlphaF =
// Math
// .acos(addMullionV.baseRT
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaCF =
// Math
// .acos(addMullionV.baseRTc
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha2F =
// Math
// .acos(addMullionV.baseLB
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaAF =
// Math
// .acos(addMullionV.baseLBa
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha3F =
// Math
// .acos(addMullionV.baseCenter
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYRT =
// (addMullionV.myParentBO.radius1 * Math
// .sin(addMullionV.newAlphaF));
//
// addMullionV.newStartingYLB =
// (Math
// .sin(addMullionV.newAlpha2F) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYCenter =
// (Math
// .sin(addMullionV.newAlpha3F) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYRTc =
// ((addMullionV.myParentBO.radius1 - addMullionV.dimTA) *
// Math
// .sin(addMullionV.newAlphaCF));
//
// addMullionV.newStartingYLBa =
// (Math
// .sin(addMullionV.newAlphaAF) *
// (addMullionV.myParentBO.radius1 - addMullionV.dimTA));
// }
//
// else
// {
// addMullionV.newAlpha =
// Math
// .acos(addMullionV.baseRT
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaC =
// Math
// .acos(addMullionV.baseRTc
// / (addMullionV.myParentBO.radius1 - addMullionV.dimTA));
//
// addMullionV.newAlpha2 =
// Math
// .acos(addMullionV.baseLB
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaA =
// Math
// .acos(addMullionV.baseLBa
// / (addMullionV.myParentBO.radius1 - addMullionV.dimTA));
//
// addMullionV.newAlpha3 =
// Math
// .acos(addMullionV.baseCenter
// / (addMullionV.myParentBO.radius1 + addMullionV.dimTM));
//
// addMullionV.newStartingYRT =
// (addMullionV.myParentBO.radius1 * Math
// .sin(addMullionV.newAlpha));
//
// addMullionV.newStartingYLB =
// (Math
// .sin(addMullionV.newAlpha2) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYCenter =
// (Math
// .sin(addMullionV.newAlpha3) *
// (addMullionV.myParentBO.radius1 + addMullionV.dimTM));
//
// addMullionV.newStartingYRTc =
// ((addMullionV.myParentBO.radius1 - addMullionV.dimTA) *
// Math
// .sin(addMullionV.newAlphaC));
//
// addMullionV.newStartingYLBa =
// (Math
// .sin(addMullionV.newAlphaA) *
// (addMullionV.myParentBO.radius1 - addMullionV.dimTA));
//
// }
// }
// if (myMullion.endTypeLT != 2)
// {
// myMullion.y1 =
// addMullionV.myParentBO.centerPointY
// - addMullionV.newStartingYLB;
//
// myMullion.y2 =
// addMullionV.myParentBO.centerPointY
// - addMullionV.newStartingYRT;
//
// myMullion.y1al =
// addMullionV.myParentBO.centerPointY
// - addMullionV.newStartingYLBa;
//
// myMullion.y2cl =
// addMullionV.myParentBO.centerPointY
// - addMullionV.newStartingYRTc;
//
// myMullion.centerYs =
// addMullionV.myParentBO.centerPointY
// - addMullionV.newStartingYCenter;
// }
// else if (myMullion.endTypeLT == 2)
// {
//
// myMullion.y1 =
// addMullionV.myParentBO.centerPointY
// - addMullionV.newStartingYLB;
//
// myMullion.y2 =
// addMullionV.myParentBO.centerPointY
// - addMullionV.newStartingYRT;
//
// myMullion.y1al =
// addMullionV.myParentBO.centerPointY
// - addMullionV.newStartingYLBa;
//
// myMullion.y2cl =
// addMullionV.myParentBO.centerPointY
// - addMullionV.newStartingYRTc;
//
// myMullion.centerYs =
// addMullionV.myParentBO.centerPointY
// - addMullionV.newStartingYCenter;
// }
//
// myMullion.length =
// myMullion.centerYe
// - myMullion.centerYs;
// myMullion.newStartingYLB =
// addMullionV.newStartingYLB;
// myMullion.newStartingYRT =
// addMullionV.newStartingYRT;
// myMullion.baseLB = addMullionV.baseLB;
// myMullion.baseRT = addMullionV.baseRT;
//
// myMullion.newStartingYLBa =
// addMullionV.newStartingYLBa;
// myMullion.newStartingYRTc =
// addMullionV.newStartingYRTc;
// myMullion.baseLBa =
// addMullionV.baseLBa;
// myMullion.baseRTc =
// addMullionV.baseRTc;
// return myMullion;
// }
//
//
//
// public Profiles getCCoordinatedForMyMullion(
// final Profiles myMullion)
// {
//
//
// if (addMullionV.newStartingXLBa >
// addMullionV.myParentBO.centerPointX)
// {
//
// addMullionV.baseRT =
// myMullion.x3
// - addMullionV.myParentBO.centerPointX;
//
// addMullionV.baseLB =
// Math
// .abs(addMullionV.baseRT
// - myMullion.thickness);
//
// addMullionV.baseRTc =
// addMullionV.baseRT
// + myMullion.partDimC;
// addMullionV.baseLBa =
// addMullionV.baseLB
// - myMullion.partDimA;
//
// addMullionV.baseCenter =
// addMullionV.baseRT
// - myMullion.thickness
// / 2;
//
// }
// else
// {
// addMullionV.baseRT =
// addMullionV.myParentBO.centerPointX
// - myMullion.x3;
//
// addMullionV.baseLB =
// addMullionV.baseRT
// + myMullion.thickness;
//
// addMullionV.baseRTc =
// addMullionV.baseRT
// - myMullion.partDimC;
// addMullionV.baseLBa =
// addMullionV.baseLB
// + myMullion.partDimA;
//
// addMullionV.baseCenter =
// addMullionV.baseLB
// - myMullion.thickness
// / 2;
// }
//
// addMullionV.newAlphaA =
// Math
// .acos(addMullionV.baseLBa
// / addMullionV.myParentBO.radius1);
//
// if (myMullion.endTypeLT == 3)
// {
// addMullionV.newAlpha =
// Math
// .acos(addMullionV.baseRT
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha2 =
// Math
// .acos(addMullionV.baseLB
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha3 =
// Math
// .acos(addMullionV.baseCenter
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaC =
// Math
// .acos(addMullionV.baseRTc
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaA =
// Math
// .acos(addMullionV.baseLBa
// / addMullionV.myParentBO.radius1);
// addMullionV.newStartingYRT =
// (addMullionV.myParentBO.radius1 * Math
// .sin(addMullionV.newAlpha));
//
// addMullionV.newStartingYLB =
// (Math
// .sin(addMullionV.newAlpha2) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYCenter =
// (Math
// .sin(addMullionV.newAlpha3) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYRTc =
// (addMullionV.myParentBO.radius1 * Math
// .sin(addMullionV.newAlphaC));
//
// addMullionV.newStartingYLBa =
// (Math
// .sin(addMullionV.newAlphaA) *
// addMullionV.myParentBO.radius1);
// }
//
// else if (myMullion.endTypeLT == 2)
// {
// if (addMullionV.newStartingXLBa >
// addMullionV.myParentBO.centerPointX)
// {
//
// addMullionV.baseRT =
// myMullion.x3
// - addMullionV.myParentBO.centerPointX;
//
// addMullionV.baseLB =
// Math
// .abs(addMullionV.baseRT
// - myMullion.thickness);
//
// addMullionV.baseRTc =
// addMullionV.baseRT
// + myMullion.partDimC;
// addMullionV.baseLBa =
// addMullionV.baseLB
// - myMullion.partDimA;
//
// addMullionV.baseCenter =
// addMullionV.baseRT
// - myMullion.thickness
// / 2;
//
// }
// else
// {
// addMullionV.baseRT =
// addMullionV.myParentBO.centerPointX
// - myMullion.x3;
//
// addMullionV.baseLB =
// addMullionV.baseRT
// + myMullion.thickness;
//
// addMullionV.baseRTc =
// addMullionV.baseRT
// - myMullion.partDimC;
// addMullionV.baseLBa =
// addMullionV.baseLB
// + myMullion.partDimA;
//
// addMullionV.baseCenter =
// addMullionV.baseLB
// - myMullion.thickness
// / 2;
// }
//
// addMullionV.newAlphaAF =
// Math
// .acos(addMullionV.baseLBa
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaF =
// Math
// .acos(addMullionV.baseRT
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha2F =
// Math
// .acos(addMullionV.baseLB
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha3F =
// Math
// .acos(addMullionV.baseCenter
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaCF =
// Math
// .acos(addMullionV.baseRTc
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlphaAF =
// Math
// .acos(addMullionV.baseLBa
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYRT =
// (addMullionV.myParentBO.radius1 * Math
// .sin(addMullionV.newAlphaF));
//
// addMullionV.newStartingYLB =
// (Math
// .sin(addMullionV.newAlpha2F) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYCenter =
// (Math
// .sin(addMullionV.newAlpha3F) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYRTc =
// ((addMullionV.myParentBO.radius1 - addMullionV.dimTA) *
// Math
// .sin(addMullionV.newAlphaCF));
//
// addMullionV.newStartingYLBa =
// (Math
// .sin(addMullionV.newAlphaAF) *
// (addMullionV.myParentBO.radius1 - addMullionV.dimTA));
// }
//
// else
// {
// addMullionV.newAlpha =
// Math
// .acos(addMullionV.baseRT
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha2 =
// Math
// .acos(addMullionV.baseLB
// / addMullionV.myParentBO.radius1);
//
// addMullionV.newAlpha3 =
// Math
// .acos(addMullionV.baseCenter
// / (addMullionV.myParentBO.radius1 + addMullionV.dimTM));
//
// addMullionV.newAlphaC =
// Math
// .acos(addMullionV.baseRTc
// / (addMullionV.myParentBO.radius1 - addMullionV.dimTA));
//
// addMullionV.newAlphaA =
// Math
// .acos(addMullionV.baseLBa
// / (addMullionV.myParentBO.radius1 - addMullionV.dimTA));
// addMullionV.newStartingYRT =
// (addMullionV.myParentBO.radius1 * Math
// .sin(addMullionV.newAlpha));
//
// addMullionV.newStartingYLB =
// (Math
// .sin(addMullionV.newAlpha2) *
// addMullionV.myParentBO.radius1);
//
// addMullionV.newStartingYCenter =
// (Math
// .sin(addMullionV.newAlpha3) *
// (addMullionV.myParentBO.radius1 + addMullionV.dimTM));
//
// addMullionV.newStartingYRTc =
// ((addMullionV.myParentBO.radius1 - addMullionV.dimTA) *
// Math
// .sin(addMullionV.newAlphaC));
//
// addMullionV.newStartingYLBa =
// (Math
// .sin(addMullionV.newAlphaA) *
// (addMullionV.myParentBO.radius1 - addMullionV.dimTA));
// }
//
// myMullion.centerYs =
// addMullionV.myParentBO.centerPointY
// - addMullionV.newStartingYCenter;
//
// myMullion.y1 =
// addMullionV.myParentBO.centerPointY
// - addMullionV.newStartingYLB;
//
// myMullion.y2 =
// addMullionV.myParentBO.centerPointY
// - addMullionV.newStartingYRT;
//
// myMullion.y1al =
// addMullionV.myParentBO.centerPointY
// - addMullionV.newStartingYLBa;
//
// myMullion.y2cl =
// addMullionV.myParentBO.centerPointY
// - addMullionV.newStartingYRTc;
//
// myMullion.length =
// myMullion.centerYe
// - myMullion.centerYs;
// myMullion.newStartingYLB =
// addMullionV.newStartingYLB;
// myMullion.newStartingYRT =
// addMullionV.newStartingYRT;
// myMullion.baseLB = addMullionV.baseLB;
// myMullion.baseRT = addMullionV.baseRT;
//
// myMullion.newStartingYLBa =
// addMullionV.newStartingYLBa;
// myMullion.newStartingYRTc =
// addMullionV.newStartingYRTc;
// myMullion.baseLBa =
// addMullionV.baseLBa;
// myMullion.baseRTc =
// addMullionV.baseRTc;
// return myMullion;
// }
//

    public Profiles
    getCCoordinatesForEllipse(final Profiles myMullion) {

        final double myX1 =
                addMullionV.myParentBO.startingX
                        + addMullionV.newColW
                        * addMullionV.iNo
                        + addMullionV.sumOfPrevMullions;
        final double myX2 = myX1 + myMullion.thickness;
        final double myXC = myX1 + myMullion.thickness / 2;

        Object[] xCoordBoc;
        Object[] yCoordBoc;
        final Arc2D.Double arc1c =
                new Arc2D.Double(
                        addMullionV.myParentBO.bkgrdStartX,
                        addMullionV.myParentBO.bkgrdStartY,
                        addMullionV.myParentBO.top1.bkgrdWidthBA,
                        addMullionV.myParentBO.top1.bkgrdHeightBA,
                        addMullionV.myParentBO.startAngle,
                        addMullionV.myParentBO.endAngle,
                        Arc2D.OPEN);
        addMullionV.getPoints(arc1c);
        xCoordBoc = addMullionV.xCoordBc.toArray();
        yCoordBoc = addMullionV.yCoordBc.toArray();
        double myY1 = 0;
        double myY2 = 0;
        double myYC = 0;

        for (int i = xCoordBoc.length; i >= 1; i--) {
            if ((Double) xCoordBoc[i - 1] >= 0) {
                if (myX1 <= (Double) xCoordBoc[i - 1]
                        && myX1 >= (Double) xCoordBoc[i + 1]) {
                    myY1 = (Double) yCoordBoc[i - 1];

                }
                if (myX2 <= (Double) xCoordBoc[i - 1]
                        && myX2 >= (Double) xCoordBoc[i + 1]) {
                    myY2 = (Double) yCoordBoc[i - 1];
                }
                if (myXC <= (Double) xCoordBoc[i - 1]
                        && myXC >= (Double) xCoordBoc[i + 1]) {
                    myYC = (Double) yCoordBoc[i - 1];
                }

            }
        }
        ;

        addMullionV.newStartingYRT =
                addMullionV.myParentBO.centerPointY - myY2;

        addMullionV.newStartingYLB =
                addMullionV.myParentBO.centerPointY - myY1;

        addMullionV.newStartingYRTc =
                addMullionV.myParentBO.centerPointY - myY2;

        addMullionV.newStartingYLBa =
                addMullionV.myParentBO.centerPointY - myY1;

        addMullionV.newStartingYCenter =
                addMullionV.myParentBO.centerPointY - myYC;

        if (addMullionV.myParentBO.startingX
                + addMullionV.newColW
                * addMullionV.iNo
                + addMullionV.sumOfPrevMullions
                + myMullion.thickness > addMullionV.myParentBO.centerPointX) {

            addMullionV.baseRT =
                    addMullionV.newColW
                            * addMullionV.iNo
                            + addMullionV.sumOfPrevMullions
                            + myMullion.thickness
                            - addMullionV.myParentBO.centerPointX;

            addMullionV.baseLB =
                    Math
                            .abs(addMullionV.baseRT
                                    - myMullion.thickness);

            addMullionV.baseRTc =
                    addMullionV.baseRT - myMullion.partDimC;
            addMullionV.baseLBa =
                    addMullionV.baseLB + myMullion.partDimA;

            addMullionV.baseCenter =
                    addMullionV.baseRT - myMullion.thickness / 2;

        } else {
            addMullionV.baseRT =
                    addMullionV.myParentBO.centerPointX
                            - (addMullionV.newColW
                            * addMullionV.iNo
                            + addMullionV.sumOfPrevMullions + myMullion.thickness);

            addMullionV.baseLB =
                    addMullionV.baseRT + myMullion.thickness;

            addMullionV.baseRTc =
                    addMullionV.baseRT - myMullion.partDimC;
            addMullionV.baseLBa =
                    addMullionV.baseLB + myMullion.partDimA;

            addMullionV.baseCenter =
                    addMullionV.baseLB - myMullion.thickness / 2;
        }

        myMullion.centerYs =
                addMullionV.myParentBO.centerPointY
                        - addMullionV.newStartingYCenter;

        myMullion.y1 = myY1;

        myMullion.y2 = myY2;

        myMullion.y1al = myY1;

        myMullion.y2cl = myY2;

        myMullion.length = myMullion.centerYe - myMullion.centerYs;
        myMullion.newStartingYLB = addMullionV.newStartingYLB;
        myMullion.newStartingYRT = addMullionV.newStartingYRT;
        myMullion.baseLB = addMullionV.baseLB;
        myMullion.baseRT = addMullionV.baseRT;

        myMullion.newStartingYLBa = addMullionV.newStartingYLBa;
        myMullion.newStartingYRTc = addMullionV.newStartingYRTc;
        myMullion.baseLBa = addMullionV.baseLBa;
        myMullion.baseRTc = addMullionV.baseRTc;

        addMullionV.xCoordBc = null;
        addMullionV.yCoordBc = null;
        return myMullion;
    }

    private Profiles botCoordsii(final Profiles myMullion) {

        if (addMullionV.limitEnd.partForm == 1) {

            double hypCenter = addMullionV.dimBM;
            if (addMullionV.myThetaBot > 0) {
                hypCenter =
                        addMullionV.dimBM / Math
                                .sin(addMullionV.myThetaBot);
            } else if (addMullionV.thetaOffset > 0) {
                hypCenter =
                        addMullionV.dimTM / Math
                                .sin(addMullionV.thetaOffset);
            }

            if (myMullion.endTypeRB == 3) {

                newYBotRTc = addMullionV.intersectY(
                        //
                        myMullion.x3cl, //
                        addMullionV.newStartingYRTc, //
                        myMullion.x3cl, //
                        newYBotRTc, //

                        addMullionV.limitEndXsBA, //
                        addMullionV.limitEndYsBA, //
                        addMullionV.limitEndXeBA, //
                        addMullionV.limitEndYeBA//
                );

                newYBotLBa = addMullionV.intersectY(
                        //
                        myMullion.x4al, //
                        addMullionV.newStartingYLBa, //
                        myMullion.x4al, //
                        newYBotLBa,
                        addMullionV.limitEndXsBA, //
                        addMullionV.limitEndYsBA, //
                        addMullionV.limitEndXeBA, //
                        addMullionV.limitEndYeBA//
                );

                y3a3 = addMullionV.intersectY(
                        //
                        myMullion.x3cl, //
                        addMullionV.newStartingYRTc, //
                        myMullion.x3cl, //
                        newYBotRTc, //

                        addMullionV.limitEndXsA, //
                        addMullionV.limitEndYsA, //
                        addMullionV.limitEndXeA, //
                        addMullionV.limitEndYeA//
                );

                y4a3 = addMullionV.intersectY(
                        //
                        myMullion.x4al, //
                        addMullionV.newStartingYLBa, //
                        myMullion.x4al, //
                        newYBotLBa,
                        addMullionV.limitEndXsA, //
                        addMullionV.limitEndYsA, //
                        addMullionV.limitEndXeA, //
                        addMullionV.limitEndYeA//
                );

                newYBotCenter = addMullionV.intersectY(
                        //
                        myMullion.centerXe, //
                        addMullionV.newStartingYCenter, //
                        myMullion.centerXe, //
                        newYBotCenter,
                        addMullionV.limitEndXsBA, //
                        addMullionV.limitEndYsBA, //
                        addMullionV.limitEndXeBA, //
                        addMullionV.limitEndYeBA//
                );

                newYBotRT = addMullionV.intersectY(
                        //
                        myMullion.x3, //
                        addMullionV.newStartingYRT, //
                        myMullion.x3, //
                        newYBotRT, //
                        addMullionV.limitEndXsBA, //
                        addMullionV.limitEndYsBA, //
                        addMullionV.limitEndXeBA, //
                        addMullionV.limitEndYeBA//
                );
                newYBotLB = addMullionV.intersectY(
                        //
                        myMullion.x4, //
                        addMullionV.newStartingYLB, //
                        myMullion.x4, //
                        newYBotLB, //
                        addMullionV.limitEndXsBA, //
                        addMullionV.limitEndYsBA, //
                        addMullionV.limitEndXeBA, //
                        addMullionV.limitEndYeBA//
                );
            } else if (myMullion.endTypeRB == 2) {

                newYBotRTc = addMullionV.intersectY(
                        //
                        myMullion.x3cl, //
                        addMullionV.newStartingYRTc, //
                        myMullion.x3cl, //
                        newYBotRTc, //

                        addMullionV.limitEndXsA, //
                        addMullionV.limitEndYsA, //
                        addMullionV.limitEndXeA, //
                        addMullionV.limitEndYeA//
                );

                y3a3 = addMullionV.intersectY(
                        //
                        myMullion.x3cl, //
                        addMullionV.newStartingYRTc, //
                        myMullion.x3cl, //
                        newYBotRTc, //

                        addMullionV.limitEndXsB, //
                        addMullionV.limitEndYsB, //
                        addMullionV.limitEndXeB, //
                        addMullionV.limitEndYeB//
                );

                newYBotLBa = addMullionV.intersectY(
                        //
                        myMullion.x4al, //
                        addMullionV.newStartingYLBa, //
                        myMullion.x4al, //
                        newYBotLBa,
                        addMullionV.limitEndXsA, //
                        addMullionV.limitEndYsA, //
                        addMullionV.limitEndXeA, //
                        addMullionV.limitEndYeA//
                );

                y4a3 = addMullionV.intersectY(
                        //
                        myMullion.x4al, //
                        addMullionV.newStartingYLBa, //
                        myMullion.x4al, //
                        newYBotLBa,
                        addMullionV.limitEndXsB, //
                        addMullionV.limitEndYsB, //
                        addMullionV.limitEndXeB, //
                        addMullionV.limitEndYeB//
                );

                newYBotCenter = addMullionV.intersectY(
                        //
                        myMullion.centerXe, //
                        addMullionV.newStartingYCenter, //
                        myMullion.centerXe, //
                        newYBotCenter,
                        addMullionV.limitEndXsB, //
                        addMullionV.limitEndYsB, //
                        addMullionV.limitEndXeB, //
                        addMullionV.limitEndYeB//
                );

                newYBotRT = addMullionV.intersectY(
                        //
                        myMullion.x3, //
                        addMullionV.newStartingYRT, //
                        myMullion.x3, //
                        newYBotRT, //
                        addMullionV.limitEndXsB, //
                        addMullionV.limitEndYsB, //
                        addMullionV.limitEndXeB, //
                        addMullionV.limitEndYeB//
                );
                newYBotLB = addMullionV.intersectY(
                        //
                        myMullion.x4, //
                        addMullionV.newStartingYLB, //
                        myMullion.x4, //
                        newYBotLB, //
                        addMullionV.limitEndXsB, //
                        addMullionV.limitEndYsB, //
                        addMullionV.limitEndXeB, //
                        addMullionV.limitEndYeB//
                );
            } else {

                newYBotRTc = addMullionV.intersectY(
                        //

                        addMullionV.newStartingXRTc, //
                        addMullionV.newStartingYRTc, //
                        myMullion.x3cl, //
                        newYBotRTc, //
                        addMullionV.limitEndXsA, //
                        addMullionV.limitEndYsA, //
                        addMullionV.limitEndXeA, //
                        addMullionV.limitEndYeA//
                );

                newYBotLBa = addMullionV.intersectY(
                        //
                        //
                        // ((Profiles)
                        // this.addMullionV.myParent.mullionObjectsV[vc]).x4al,
                        // //
                        addMullionV.newStartingXLBa,
                        addMullionV.newStartingYLBa, //
                        myMullion.x4al, //
                        newYBotLBa, //
                        addMullionV.limitEndXsA, //
                        addMullionV.limitEndYsA, //
                        addMullionV.limitEndXeA, //
                        addMullionV.limitEndYeA//
                );

                newYBotCenter = addMullionV.intersectY(
                        //
                        addMullionV.newStartingXCenter, //
                        addMullionV.newStartingYCenter, //
                        myMullion.centerXe, //
                        newYBotCenter, //
                        addMullionV.limitEndXsBA, //
                        addMullionV.limitEndYsBA + hypCenter, //
                        addMullionV.limitEndXeBA, //
                        addMullionV.limitEndYeBA + hypCenter//
                );

                newYBotRT = addMullionV.intersectY(
                        //
                        myMullion.x3cl, //
                        newYBotRTc, //
                        myMullion.centerXe, //
                        newYBotCenter, //
                        // ((Profiles)
                        // this.addMullionV.myParent.mullionObjectsV[vc]).x3,
                        // //
                        addMullionV.newStartingXRT,
                        addMullionV.newStartingYRT, //
                        myMullion.x3, //
                        newYBotRT // //
                );
                newYBotLB = addMullionV.intersectY(
                        //
                        myMullion.x4al, //
                        newYBotLBa, //
                        myMullion.centerXe, //
                        newYBotCenter, //
                        addMullionV.newStartingXLB,
                        addMullionV.newStartingYLB, //
                        myMullion.x4, //
                        newYBotLB //
                );
            }

        }// / top > 1 && Radius =0

        if (addMullionV.limitEnd.partForm == 2) {

            this.calculateCoordinArchIIB(myMullion);
            setYe = true;
        }
        return myMullion;

    }

}
