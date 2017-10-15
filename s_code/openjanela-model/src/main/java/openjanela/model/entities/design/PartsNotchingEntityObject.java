package openjanela.model.entities.design;

import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-30-12
 *          Time: 12:09 AM
 */
public class PartsNotchingEntityObject implements Serializable {

    //Serializable version
    private static final long serialVersionUID = 7614877640035412857L;

    private Integer id;

    private boolean top1p = false;
    private boolean top2p = false;
    private boolean top3p = false;
    private boolean leftp = false;
    private boolean rightp = false;
    private boolean bot1p = false;
    private boolean bot2p = false;
    private boolean bot3p = false;
    private boolean notches = false;
    private boolean notchesLT = false;
    private boolean notchesRB = false;

    private int levelId = 0;
    private int orientation = 0;
    private int rowcol = 0;
    private int pos = 0;
    private int nothchType = 0;

    private double x1 = 0;
    private double y1 = 0;
    private double x2 = 0;
    private double y2 = 0;
    private double x3 = 0;
    private double y3 = 0;
    private double xcenter = 0;
    private double ycenter = 0;
    private double x5 = 0;
    private double y5 = 0;
    private double x6 = 0;
    private double y6 = 0;
    private double x7 = 0;
    private double y7 = 0;

    // ==================================<GETTTER AND SETTERS>=================================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public boolean isTop1p() {
        return top1p;
    }

    public void setTop1p(boolean top1p) {
        this.top1p = top1p;
    }

    public boolean isTop2p() {
        return top2p;
    }

    public void setTop2p(boolean top2p) {
        this.top2p = top2p;
    }

    public boolean isTop3p() {
        return top3p;
    }

    public void setTop3p(boolean top3p) {
        this.top3p = top3p;
    }

    public boolean isLeftp() {
        return leftp;
    }

    public void setLeftp(boolean leftp) {
        this.leftp = leftp;
    }

    public boolean isRightp() {
        return rightp;
    }

    public void setRightp(boolean rightp) {
        this.rightp = rightp;
    }

    public boolean isBot1p() {
        return bot1p;
    }

    public void setBot1p(boolean bot1p) {
        this.bot1p = bot1p;
    }

    public boolean isBot2p() {
        return bot2p;
    }

    public void setBot2p(boolean bot2p) {
        this.bot2p = bot2p;
    }

    public boolean isBot3p() {
        return bot3p;
    }

    public void setBot3p(boolean bot3p) {
        this.bot3p = bot3p;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getRowcol() {
        return rowcol;
    }

    public void setRowcol(int rowcol) {
        this.rowcol = rowcol;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getNothchType() {
        return nothchType;
    }

    public void setNothchType(int nothchType) {
        this.nothchType = nothchType;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }


    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    public double getXcenter() {
        return xcenter;
    }

    public void setXcenter(double xcenter) {
        this.xcenter = xcenter;
    }

    public double getYcenter() {
        return ycenter;
    }

    public void setYcenter(double ycenter) {
        this.ycenter = ycenter;
    }

    public double getX5() {
        return x5;
    }

    public void setX5(double x5) {
        this.x5 = x5;
    }


    public double getY5() {
        return y5;
    }

    public void setY5(double y5) {
        this.y5 = y5;
    }

    public double getX6() {
        return x6;
    }

    public void setX6(double x6) {
        this.x6 = x6;
    }

    public double getY6() {
        return y6;
    }

    public void setY6(double y6) {
        this.y6 = y6;
    }

    public double getX7() {
        return x7;
    }

    public void setX7(double x7) {
        this.x7 = x7;
    }

    public double getY7() {
        return y7;
    }

    public void setY7(double y7) {
        this.y7 = y7;
    }

    public boolean isNotches() {
        return notches;
    }

    public void setNotches(boolean notches) {
        this.notches = notches;
    }

    public boolean isNotchesLT() {
        return notchesLT;
    }

    public void setNotchesLT(boolean notchesLT) {
        this.notchesLT = notchesLT;
    }

    public boolean isNotchesRB() {
        return notchesRB;
    }

    public void setNotchesRB(boolean notchesRB) {
        this.notchesRB = notchesRB;
    }
}
