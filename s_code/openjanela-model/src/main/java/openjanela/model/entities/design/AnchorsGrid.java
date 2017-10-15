package openjanela.model.entities.design;

import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-25-12
 *          Time: 01:18 PM
 */
public class AnchorsGrid implements Serializable {

    //Serializable version
    private static final long serialVersionUID = 3942622329819149435L;

    private Integer id;

    private Double anchorV = new Double("0");
    private Double anchorH = new Double("0");

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAnchorV() {
        return anchorV;
    }

    public void setAnchorV(Double anchorV) {
        this.anchorV = anchorV;
    }

    public Double getAnchorH() {
        return anchorH;
    }

    public void setAnchorH(Double anchorH) {
        this.anchorH = anchorH;
    }
}
