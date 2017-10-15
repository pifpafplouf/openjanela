/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 ******************************************************************************/
package Model.ProfileParts;


import java.util.ArrayList;
import java.util.Collection;


public class PartsNotching {

    public int levelID = 0;

    public boolean top1p = false; //

    public boolean top2p = false; //

    public boolean top3p = false; //

    public boolean leftp = false; //

    public boolean rightp = false; //

    public boolean bot1p = false; //

    public boolean bot2p = false; //

    public boolean bot3p = false; //

    public int orientation = 0; // 1 V 2 H

    public int rowcol = 0;

    public int pos = 0; // 1 =top, 2=bot, 3=L, 4=R

    public int nothchType = 0;

    public double x1 = 0;

    public double y1 = 0;

    public double x2 = 0;

    public double y2 = 0;

    public double x3 = 0;

    public double y3 = 0;

    public double xcenter = 0;

    public double ycenter = 0;

    public double x5 = 0;

    public double y5 = 0;

    public double x6 = 0;

    public double y6 = 0;

    public double x7 = 0;

    public double y7 = 0;

    public PartsNotching(
            final int levelID,
            final boolean top1,
            final boolean top2,
            final boolean top3,
            final boolean left,
            final boolean right,
            final boolean bot1,
            final boolean bot2,
            final boolean bot3,
            final int orientation,
            final int rowcol,
            final int pos,
            final int nothchType,
            final double x1,
            final double y1,
            final double x2,
            final double y2,
            final double x3,
            final double y3,
            final double xcenter,
            final double ycenter,
            final double x5,
            final double y5,
            final double x6,
            final double y6,
            final double x7,
            final double y7) {

        this.levelID = levelID;
        this.top1p = top1;
        this.top2p = top2;
        this.top3p = top3;
        this.leftp = left;
        this.rightp = right;
        this.bot1p = bot1;
        this.bot2p = bot2;
        this.bot3p = bot3;
        this.orientation = orientation;

        this.rowcol = rowcol;

        this.pos = pos;

        this.nothchType = nothchType;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.xcenter = xcenter;
        this.ycenter = ycenter;
        this.x5 = x5;
        this.y5 = y5;
        this.x6 = x6;
        this.y6 = y6;
        this.x7 = x7;
        this.y7 = y7;

    }

    public PartsNotching() {

    }

    public Collection getLNotches(final Collection notches) {

        final Collection myNotchesL = new ArrayList();
        final Object[] lts = notches.toArray();
        for (final Object element : lts) {
            if (((PartsNotching) element).pos == 3 && ((PartsNotching) element).orientation == 1) {
                myNotchesL.add(element);
            }
        }

        return myNotchesL;
    }

    public Collection getRNotches(final Collection notches) {

        final Collection myNotchesR = new ArrayList();
        final Object[] lts = notches.toArray();
        for (final Object element : lts) {
            if (((PartsNotching) element).pos == 4
                    && ((PartsNotching) element).orientation == 1) {
                myNotchesR.add(element);
            }
        }

        return myNotchesR;
    }

    public Collection getTNotches(final Collection notches) {

        final Collection myNotchesT = new ArrayList();
        final Object[] lts = notches.toArray();
        for (final Object element : lts) {
            if (((PartsNotching) element).pos == 1 && ((PartsNotching) element).orientation == 2) {
                myNotchesT.add(element);
            }
        }

        return myNotchesT;
    }

    public Collection getBNotches(final Collection notches) {

        final Collection myNotchesB = new ArrayList();
        final Object[] lts = notches.toArray();
        for (final Object element : lts) {
            if (((PartsNotching) element).pos == 2 && ((PartsNotching) element).orientation == 2) {
                myNotchesB.add(element);
            }
        }

        return myNotchesB;
    }

    public PartsNotching cloneNotches(final PartsNotching original) {

        final PartsNotching newNotches = new PartsNotching();
        newNotches.levelID = original.levelID;
        newNotches.top1p = original.top1p;//
        newNotches.top2p = original.top2p;//
        newNotches.top3p = original.top3p;//
        newNotches.leftp = original.leftp;//
        newNotches.rightp = original.rightp;//
        newNotches.bot1p = original.bot1p;//
        newNotches.bot2p = original.bot2p;//
        newNotches.bot3p = original.bot3p;//
        newNotches.orientation = original.orientation; // 1
// V 2 H

        newNotches.rowcol = original.rowcol;

        newNotches.pos = original.pos;// 1 =top, 2
// bot, 3 L 4 R

        newNotches.nothchType = original.nothchType;
        newNotches.x1 = original.x1;
        newNotches.y1 = original.y1;
        newNotches.x2 = original.x2;
        newNotches.y2 = original.y2;
        newNotches.x3 = original.x3;
        newNotches.y3 = original.y3;
        newNotches.xcenter = original.xcenter;
        newNotches.ycenter = original.ycenter;
        newNotches.x5 = original.x5;
        newNotches.y5 = original.y5;
        newNotches.x6 = original.x6;
        newNotches.y6 = original.y6;
        newNotches.x7 = original.x7;
        newNotches.y7 = original.y7;

        return newNotches;
    }

    public PartsNotching resizeNotches(
            final PartsNotching original,
            final double wo,
            final double ho,
            final double w,
            final double h) {

        final PartsNotching newNotches = new PartsNotching();
        newNotches.levelID = original.levelID;
        newNotches.top1p = original.top1p;//
        newNotches.top2p = original.top2p;//
        newNotches.top3p = original.top3p;//
        newNotches.leftp = original.leftp;//
        newNotches.rightp = original.rightp;//
        newNotches.bot1p = original.bot1p;//
        newNotches.bot2p = original.bot2p;//
        newNotches.bot3p = original.bot3p;//
        newNotches.orientation = original.orientation; // 1
// V 2 H

        newNotches.rowcol = original.rowcol;

        newNotches.pos = original.pos;// 1 =top, 2
// bot, 3 L 4 R

        newNotches.nothchType = original.nothchType;
        newNotches.x1 = original.x1;
        newNotches.y1 = original.y1;
        newNotches.x2 = original.x2;
        newNotches.y2 = original.y2;
        newNotches.x3 = original.x3;
        newNotches.y3 = original.y3;
        newNotches.xcenter = original.xcenter;
        newNotches.ycenter = original.ycenter;
        newNotches.x5 = original.x5;
        newNotches.y5 = original.y5;
        newNotches.x6 = original.x6;
        newNotches.y6 = original.y6;
        newNotches.x7 = original.x7;
        newNotches.y7 = original.y7;

        return newNotches;
    }

}
