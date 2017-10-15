package Model;

import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.2
 *          Date: 1/25/14
 *          Time: 1:29 PM
 */
public class SeriesSegmentExec implements Serializable {

    /**
     * Series Identification Id
     */
    private int seriesID;

    /**
     * Supplier Identification Id
     */
    private int supplierID;

    /**
     * Series Supplier Remote
     */
    private boolean remote;

    //**********************************************<Constructor>*******************************************************

    /**
     * Series Segment Constructor
     *
     * @param seriesID,   Series Identification Id
     * @param supplierID, Supplier Identification Id
     * @param remote,     Series Supplier Remote
     */
    public SeriesSegmentExec(int seriesID, int supplierID, boolean remote) {
        this.seriesID = seriesID;
        this.supplierID = supplierID;
        this.remote = remote;
    }

    public int getSeriesID() {
        return seriesID;
    }

    public void setSeriesID(int seriesID) {
        this.seriesID = seriesID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }
}
