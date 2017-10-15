package openjanela.model.entities.design;

import java.io.Serializable;

/**
 * Copyright (c) 2011-2014 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 02-25-14
 *          Time: 01:25 AM
 */
public class BillOfMaterialShapeData implements Serializable {

    public int radius1 = 0;
    public int radius1_i = 0;
    public int radius2 = 0;
    public int radius2_i = 0;

    public int minLeg = 0;
    public int minLeg_i = 0;

    public double dimA1 = 0;
    public double dimA2 = 0;
    public double dimA3 = 0;
    public double dimA4 = 0;
    public double dimA5 = 0;
    public double dimA0 = 0;
    public double dimB1 = 0;
    public double dimB2 = 0;
    public double dimB3 = 0;
    public double dimB4 = 0;
    public double dimB5 = 0;
    public double dimB0 = 0;
    public double dimC1 = 0;
    public double dimC2 = 0;
    public double dimC3 = 0;
    public double dimC4 = 0;
    public double dimC5 = 0;
    public double dimC0 = 0;
    public double dimD1 = 0;
    public double dimD2 = 0;
    public double dimD3 = 0;
    public double dimD4 = 0;
    public double dimD5 = 0;
    public double dimD0 = 0;

    public double dimA1_i = 0;
    public double dimA2_i = 0;
    public double dimA3_i = 0;
    public double dimA4_i = 0;
    public double dimA5_i = 0;
    public double dimA0_i = 0;
    public double dimB1_i = 0;
    public double dimB2_i = 0;
    public double dimB3_i = 0;
    public double dimB4_i = 0;
    public double dimB5_i = 0;
    public double dimB0_i = 0;
    public double dimC1_i = 0;
    public double dimC2_i = 0;
    public double dimC3_i = 0;
    public double dimC4_i = 0;
    public double dimC5_i = 0;
    public double dimC0_i = 0;
    public double dimD1_i = 0;
    public double dimD2_i = 0;
    public double dimD3_i = 0;
    public double dimD4_i = 0;
    public double dimD5_i = 0;
    public double dimD0_i = 0;

    /**
     * Build Of Material Shape Data Constructor
     */
    public BillOfMaterialShapeData(int radius1, int radius1_i, int radius2, int radius2_i, int minLeg, int minLeg_i,
                                   double dimA1, double dimA2, double dimA3, double dimA4, double dimA5, double dimA0,
                                   double dimB1, double dimB2, double dimB3, double dimB4, double dimB5, double dimB0,
                                   double dimC1, double dimC2, double dimC3, double dimC4, double dimC5, double dimC0,
                                   double dimD1, double dimD2, double dimD3, double dimD4, double dimD5, double dimD0,
                                   double dimA1_i, double dimA2_i, double dimA3_i, double dimA4_i, double dimA5_i,
                                   double dimA0_i, double dimB1_i, double dimB2_i, double dimB3_i, double dimB4_i,
                                   double dimB5_i, double dimB0_i, double dimC1_i, double dimC2_i, double dimC3_i,
                                   double dimC4_i, double dimC5_i, double dimC0_i, double dimD1_i, double dimD2_i,
                                   double dimD3_i, double dimD4_i, double dimD5_i, double dimD0_i) {
        this.radius1 = radius1;
        this.radius1_i = radius1_i;
        this.radius2 = radius2;
        this.radius2_i = radius2_i;
        this.minLeg = minLeg;
        this.minLeg_i = minLeg_i;
        this.dimA1 = dimA1;
        this.dimA2 = dimA2;
        this.dimA3 = dimA3;
        this.dimA4 = dimA4;
        this.dimA5 = dimA5;
        this.dimA0 = dimA0;
        this.dimB1 = dimB1;
        this.dimB2 = dimB2;
        this.dimB3 = dimB3;
        this.dimB4 = dimB4;
        this.dimB5 = dimB5;
        this.dimB0 = dimB0;
        this.dimC1 = dimC1;
        this.dimC2 = dimC2;
        this.dimC3 = dimC3;
        this.dimC4 = dimC4;
        this.dimC5 = dimC5;
        this.dimC0 = dimC0;
        this.dimD1 = dimD1;
        this.dimD2 = dimD2;
        this.dimD3 = dimD3;
        this.dimD4 = dimD4;
        this.dimD5 = dimD5;
        this.dimD0 = dimD0;
        this.dimA1_i = dimA1_i;
        this.dimA2_i = dimA2_i;
        this.dimA3_i = dimA3_i;
        this.dimA4_i = dimA4_i;
        this.dimA5_i = dimA5_i;
        this.dimA0_i = dimA0_i;
        this.dimB1_i = dimB1_i;
        this.dimB2_i = dimB2_i;
        this.dimB3_i = dimB3_i;
        this.dimB4_i = dimB4_i;
        this.dimB5_i = dimB5_i;
        this.dimB0_i = dimB0_i;
        this.dimC1_i = dimC1_i;
        this.dimC2_i = dimC2_i;
        this.dimC3_i = dimC3_i;
        this.dimC4_i = dimC4_i;
        this.dimC5_i = dimC5_i;
        this.dimC0_i = dimC0_i;
        this.dimD1_i = dimD1_i;
        this.dimD2_i = dimD2_i;
        this.dimD3_i = dimD3_i;
        this.dimD4_i = dimD4_i;
        this.dimD5_i = dimD5_i;
        this.dimD0_i = dimD0_i;
    }

    //***************************************************<Getters & Setters>********************************************

    public int getRadius1() {
        return radius1;
    }

    public void setRadius1(int radius1) {
        this.radius1 = radius1;
    }

    public int getRadius1_i() {
        return radius1_i;
    }

    public void setRadius1_i(int radius1_i) {
        this.radius1_i = radius1_i;
    }

    public int getRadius2() {
        return radius2;
    }

    public void setRadius2(int radius2) {
        this.radius2 = radius2;
    }

    public int getRadius2_i() {
        return radius2_i;
    }

    public void setRadius2_i(int radius2_i) {
        this.radius2_i = radius2_i;
    }

    public int getMinLeg() {
        return minLeg;
    }

    public void setMinLeg(int minLeg) {
        this.minLeg = minLeg;
    }

    public int getMinLeg_i() {
        return minLeg_i;
    }

    public void setMinLeg_i(int minLeg_i) {
        this.minLeg_i = minLeg_i;
    }

    public double getDimA1() {
        return dimA1;
    }

    public void setDimA1(double dimA1) {
        this.dimA1 = dimA1;
    }

    public double getDimA2() {
        return dimA2;
    }

    public void setDimA2(double dimA2) {
        this.dimA2 = dimA2;
    }

    public double getDimA3() {
        return dimA3;
    }

    public void setDimA3(double dimA3) {
        this.dimA3 = dimA3;
    }

    public double getDimA4() {
        return dimA4;
    }

    public void setDimA4(double dimA4) {
        this.dimA4 = dimA4;
    }

    public double getDimA5() {
        return dimA5;
    }

    public void setDimA5(double dimA5) {
        this.dimA5 = dimA5;
    }

    public double getDimA0() {
        return dimA0;
    }

    public void setDimA0(double dimA0) {
        this.dimA0 = dimA0;
    }

    public double getDimB1() {
        return dimB1;
    }

    public void setDimB1(double dimB1) {
        this.dimB1 = dimB1;
    }

    public double getDimB2() {
        return dimB2;
    }

    public void setDimB2(double dimB2) {
        this.dimB2 = dimB2;
    }

    public double getDimB3() {
        return dimB3;
    }

    public void setDimB3(double dimB3) {
        this.dimB3 = dimB3;
    }

    public double getDimB4() {
        return dimB4;
    }

    public void setDimB4(double dimB4) {
        this.dimB4 = dimB4;
    }

    public double getDimB5() {
        return dimB5;
    }

    public void setDimB5(double dimB5) {
        this.dimB5 = dimB5;
    }

    public double getDimB0() {
        return dimB0;
    }

    public void setDimB0(double dimB0) {
        this.dimB0 = dimB0;
    }

    public double getDimC1() {
        return dimC1;
    }

    public void setDimC1(double dimC1) {
        this.dimC1 = dimC1;
    }

    public double getDimC2() {
        return dimC2;
    }

    public void setDimC2(double dimC2) {
        this.dimC2 = dimC2;
    }

    public double getDimC3() {
        return dimC3;
    }

    public void setDimC3(double dimC3) {
        this.dimC3 = dimC3;
    }

    public double getDimC4() {
        return dimC4;
    }

    public void setDimC4(double dimC4) {
        this.dimC4 = dimC4;
    }

    public double getDimC5() {
        return dimC5;
    }

    public void setDimC5(double dimC5) {
        this.dimC5 = dimC5;
    }

    public double getDimC0() {
        return dimC0;
    }

    public void setDimC0(double dimC0) {
        this.dimC0 = dimC0;
    }

    public double getDimD1() {
        return dimD1;
    }

    public void setDimD1(double dimD1) {
        this.dimD1 = dimD1;
    }

    public double getDimD2() {
        return dimD2;
    }

    public void setDimD2(double dimD2) {
        this.dimD2 = dimD2;
    }

    public double getDimD3() {
        return dimD3;
    }

    public void setDimD3(double dimD3) {
        this.dimD3 = dimD3;
    }

    public double getDimD4() {
        return dimD4;
    }

    public void setDimD4(double dimD4) {
        this.dimD4 = dimD4;
    }

    public double getDimD5() {
        return dimD5;
    }

    public void setDimD5(double dimD5) {
        this.dimD5 = dimD5;
    }

    public double getDimD0() {
        return dimD0;
    }

    public void setDimD0(double dimD0) {
        this.dimD0 = dimD0;
    }

    public double getDimA1_i() {
        return dimA1_i;
    }

    public void setDimA1_i(double dimA1_i) {
        this.dimA1_i = dimA1_i;
    }

    public double getDimA2_i() {
        return dimA2_i;
    }

    public void setDimA2_i(double dimA2_i) {
        this.dimA2_i = dimA2_i;
    }

    public double getDimA3_i() {
        return dimA3_i;
    }

    public void setDimA3_i(double dimA3_i) {
        this.dimA3_i = dimA3_i;
    }

    public double getDimA4_i() {
        return dimA4_i;
    }

    public void setDimA4_i(double dimA4_i) {
        this.dimA4_i = dimA4_i;
    }

    public double getDimA5_i() {
        return dimA5_i;
    }

    public void setDimA5_i(double dimA5_i) {
        this.dimA5_i = dimA5_i;
    }

    public double getDimA0_i() {
        return dimA0_i;
    }

    public void setDimA0_i(double dimA0_i) {
        this.dimA0_i = dimA0_i;
    }

    public double getDimB1_i() {
        return dimB1_i;
    }

    public void setDimB1_i(double dimB1_i) {
        this.dimB1_i = dimB1_i;
    }

    public double getDimB2_i() {
        return dimB2_i;
    }

    public void setDimB2_i(double dimB2_i) {
        this.dimB2_i = dimB2_i;
    }

    public double getDimB3_i() {
        return dimB3_i;
    }

    public void setDimB3_i(double dimB3_i) {
        this.dimB3_i = dimB3_i;
    }

    public double getDimB4_i() {
        return dimB4_i;
    }

    public void setDimB4_i(double dimB4_i) {
        this.dimB4_i = dimB4_i;
    }

    public double getDimB5_i() {
        return dimB5_i;
    }

    public void setDimB5_i(double dimB5_i) {
        this.dimB5_i = dimB5_i;
    }

    public double getDimB0_i() {
        return dimB0_i;
    }

    public void setDimB0_i(double dimB0_i) {
        this.dimB0_i = dimB0_i;
    }

    public double getDimC1_i() {
        return dimC1_i;
    }

    public void setDimC1_i(double dimC1_i) {
        this.dimC1_i = dimC1_i;
    }

    public double getDimC2_i() {
        return dimC2_i;
    }

    public void setDimC2_i(double dimC2_i) {
        this.dimC2_i = dimC2_i;
    }

    public double getDimC3_i() {
        return dimC3_i;
    }

    public void setDimC3_i(double dimC3_i) {
        this.dimC3_i = dimC3_i;
    }

    public double getDimC4_i() {
        return dimC4_i;
    }

    public void setDimC4_i(double dimC4_i) {
        this.dimC4_i = dimC4_i;
    }

    public double getDimC5_i() {
        return dimC5_i;
    }

    public void setDimC5_i(double dimC5_i) {
        this.dimC5_i = dimC5_i;
    }

    public double getDimC0_i() {
        return dimC0_i;
    }

    public void setDimC0_i(double dimC0_i) {
        this.dimC0_i = dimC0_i;
    }

    public double getDimD1_i() {
        return dimD1_i;
    }

    public void setDimD1_i(double dimD1_i) {
        this.dimD1_i = dimD1_i;
    }

    public double getDimD2_i() {
        return dimD2_i;
    }

    public void setDimD2_i(double dimD2_i) {
        this.dimD2_i = dimD2_i;
    }

    public double getDimD3_i() {
        return dimD3_i;
    }

    public void setDimD3_i(double dimD3_i) {
        this.dimD3_i = dimD3_i;
    }

    public double getDimD4_i() {
        return dimD4_i;
    }

    public void setDimD4_i(double dimD4_i) {
        this.dimD4_i = dimD4_i;
    }

    public double getDimD5_i() {
        return dimD5_i;
    }

    public void setDimD5_i(double dimD5_i) {
        this.dimD5_i = dimD5_i;
    }

    public double getDimD0_i() {
        return dimD0_i;
    }

    public void setDimD0_i(double dimD0_i) {
        this.dimD0_i = dimD0_i;
    }
}
