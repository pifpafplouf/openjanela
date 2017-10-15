package Model;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

/**
 * Copyright (c) 2013, OpenJanela. All rights reserved.
 * <p/>
 * This class represents dimensions history for a changes make from visual designers
 * <p/>
 * User: Eddy Montenegro
 * Date: 02-05-13
 * Time: 10:06 AM
 */
public final class DimensionOptions implements Cloneable {

    //Apache log4j
    private static final Logger logger = Logger.getLogger(DimensionOptions.class);

    private double _WIDTH_Pix = 0; //Represent width pixels for design
    private double _HEIGHT_Pix = 0; //Represent height pixels for design

    private int _WIDTH_Metric = 0;  //Represent width metric for design
    private int _HEIGHT_Metric = 0; //Represent height metric for design

    private int _WIDTH_Metric_O = 0;
    private int _HEIGHT_Metric_O = 0;

    private int _WIDTH_Imp = 0; //Represent width imperial for design
    private int _HEIGHT_Imp = 0; //Represent height imperial for design

    private int _WIDTH_Imp_O = 0; //Represent width imperial fraction
    private int _HEIGHT_Imp_O = 0; //Represent height imperial fraction

    private int design_WIDTH_Metric = 0; //Represent design width metric
    private int design_HEIGHT_Metric = 0; //Represent design height metric

    private int design_WIDTH_Metric_O = 0;
    private int design_HEIGHT_Metric_O = 0;

    private int design_WIDTH_Imp = 0; //Represent design width imperial
    private int design_HEIGHT_Imp = 0; //Represent design height imperial

    private double _starting_X = 0; //Represent starting x position for axis x
    private double _starting_Y = 0; //Represent starting y position for axis y

    private BigDecimal _metric_scale = new BigDecimal(0); //Calcultated metric scale
    private BigDecimal _imperial_scale = new BigDecimal(0); //Calculated imperial scale

    private BigDecimal _scale = new BigDecimal(0); //Actual scale unit of measure

    //***************************************************************************************

    public double get_WIDTH_Pix() {
        return _WIDTH_Pix;
    }

    public void set_WIDTH_Pix(double _WIDTH_Pix) {
        this._WIDTH_Pix = _WIDTH_Pix;
    }

    public double get_HEIGHT_Pix() {
        return _HEIGHT_Pix;
    }

    public void set_HEIGHT_Pix(double _HEIGHT_Pix) {
        this._HEIGHT_Pix = _HEIGHT_Pix;
    }

    public int get_WIDTH_Metric() {
        return _WIDTH_Metric;
    }

    public void set_WIDTH_Metric(int _WIDTH_Metric) {
        this._WIDTH_Metric = _WIDTH_Metric;
    }

    public int get_HEIGHT_Metric() {
        return _HEIGHT_Metric;
    }

    public void set_HEIGHT_Metric(int _HEIGHT_Metric) {
        this._HEIGHT_Metric = _HEIGHT_Metric;
    }

    public int get_WIDTH_Metric_O() {
        return _WIDTH_Metric_O;
    }

    public void set_WIDTH_Metric_O(int _WIDTH_Metric_O) {
        this._WIDTH_Metric_O = _WIDTH_Metric_O;
    }

    public int get_HEIGHT_Metric_O() {
        return _HEIGHT_Metric_O;
    }

    public void set_HEIGHT_Metric_O(int _HEIGHT_Metric_O) {
        this._HEIGHT_Metric_O = _HEIGHT_Metric_O;
    }

    public int get_WIDTH_Imp() {
        return _WIDTH_Imp;
    }

    public void set_WIDTH_Imp(int _WIDTH_Imp) {
        this._WIDTH_Imp = _WIDTH_Imp;
    }

    public int get_HEIGHT_Imp() {
        return _HEIGHT_Imp;
    }

    public void set_HEIGHT_Imp(int _HEIGHT_Imp) {
        this._HEIGHT_Imp = _HEIGHT_Imp;
    }

    public int get_WIDTH_Imp_O() {
        return _WIDTH_Imp_O;
    }

    public void set_WIDTH_Imp_O(int _WIDTH_Imp_O) {
        this._WIDTH_Imp_O = _WIDTH_Imp_O;
    }

    public int get_HEIGHT_Imp_O() {
        return _HEIGHT_Imp_O;
    }

    public void set_HEIGHT_Imp_O(int _HEIGHT_Imp_O) {
        this._HEIGHT_Imp_O = _HEIGHT_Imp_O;
    }

    public int getDesign_WIDTH_Metric() {
        return design_WIDTH_Metric;
    }

    public void setDesign_WIDTH_Metric(int design_WIDTH_Metric) {
        this.design_WIDTH_Metric = design_WIDTH_Metric;
    }

    public int getDesign_HEIGHT_Metric() {
        return design_HEIGHT_Metric;
    }

    public void setDesign_HEIGHT_Metric(int design_HEIGHT_Metric) {
        this.design_HEIGHT_Metric = design_HEIGHT_Metric;
    }

    public int getDesign_WIDTH_Metric_O() {
        return design_WIDTH_Metric_O;
    }

    public void setDesign_WIDTH_Metric_O(int design_WIDTH_Metric_O) {
        this.design_WIDTH_Metric_O = design_WIDTH_Metric_O;
    }

    public int getDesign_HEIGHT_Metric_O() {
        return design_HEIGHT_Metric_O;
    }

    public void setDesign_HEIGHT_Metric_O(int design_HEIGHT_Metric_O) {
        this.design_HEIGHT_Metric_O = design_HEIGHT_Metric_O;
    }

    public int getDesign_WIDTH_Imp() {
        return design_WIDTH_Imp;
    }

    public void setDesign_WIDTH_Imp(int design_WIDTH_Imp) {
        this.design_WIDTH_Imp = design_WIDTH_Imp;
    }

    public int getDesign_HEIGHT_Imp() {
        return design_HEIGHT_Imp;
    }

    public void setDesign_HEIGHT_Imp(int design_HEIGHT_Imp) {
        this.design_HEIGHT_Imp = design_HEIGHT_Imp;
    }

    public double get_starting_X() {
        return _starting_X;
    }

    public void set_starting_X(double _starting_X) {
        this._starting_X = _starting_X;
    }

    public double get_starting_Y() {
        return _starting_Y;
    }

    public void set_starting_Y(double _starting_Y) {
        this._starting_Y = _starting_Y;
    }

    public BigDecimal get_metric_scale() {
        return _metric_scale;
    }

    public void set_metric_scale(BigDecimal _metric_scale) {
        this._metric_scale = _metric_scale;
    }

    public BigDecimal get_imperial_scale() {
        return _imperial_scale;
    }

    public void set_imperial_scale(BigDecimal _imperial_scale) {
        this._imperial_scale = _imperial_scale;
    }

    public BigDecimal get_scale() {
        return _scale;
    }

    public void set_scale(BigDecimal _scale) {
        this._scale = _scale;
    }

    public DimensionOptions clone() {

        try {
            return (DimensionOptions) super.clone();
        } catch (CloneNotSupportedException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }
}
