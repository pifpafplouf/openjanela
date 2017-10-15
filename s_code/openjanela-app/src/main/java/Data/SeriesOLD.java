/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved.
 *
 * Contributors:
 * Sherif El Dibani
 *******************************************************************************/
package Data;


import util.DBIdDescription;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;


public class SeriesOLD {

    public int seriesid = 1;
    public String seriesname = "";
    public String description = "";
    public int clientID = -1;
    public int metricDec = 0;
    public int impDec = 6;
    public int minFrameDimM = 40;
    public int minFrameDimI = 96;
    public double idealgridwidthM = 12;
    public double idealgridheightM = 10;
    public double mingridwM = 6;
    public double mingridhM = 6;
    public double maxgridwM = 30;
    public double maxgridhM = 30;
    public double idealgridwidthI = 12;
    public double idealgridheightI = 10;
    public double mingridwI = 6;
    public double mingridhI = 6;
    public double maxgridwI = 30;
    public double maxgridhI = 30;
    public double roundingM = 0.0;
    public double roundingI = 0.0625;
    public double framedepthM = 8300;
    public double framedepthI = 208;
    public double minFacetWM = 30000;
    public double minFacetWI = 12 * 64d;
    public double minFacetHM = 30000;
    public double minFacetHI = 12 * 64d;
    public double defaulBayCP = 0.5;
    public int defaultleadtime;
    public double fiAdjust;
    public boolean windowON = true;
    public boolean doorON = true;
    public boolean entryON = true;
    public int defaultType = 1;
    public boolean outSON = true;
    public boolean inSON = true;
    public boolean SSON = true;
    public boolean DSON = true;
    public boolean CSON = true;
    public boolean foldON = true;
    public boolean transomON = true;
    public boolean sidelightON = true;
    public int defaultClass = 2;
    public boolean setControlTypeFromAll = false;

    public static Collection retrieveHeaderInfo(int seriesID) throws Exception {
        Collection SeriesVector = new Vector();
        return SeriesVector;

    }

    public String retrieveSereisDescription(int seriesID) throws Exception {

        String seriesDescription = "";
        return seriesDescription;
    }

    public String retrieveFixName(int seriesID) throws Exception {
        String nameforFix = null;
        return nameforFix;

    }

    private static void populateDBIdDescription(Collection all, ResultSet rs) throws Exception {

        while (rs.next()) {
            DBIdDescription obj = null;
            obj =new DBIdDescription(rs.getInt(1), null, rs.getString(2), true);
            all.add(obj);
        }
    }

}
