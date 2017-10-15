package openjanela.model.entities.production;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 06-04-13
 *          Time: 09:07 PM
 */
@Embeddable
public class ProductionLineStationPK implements Serializable {

    @Column(name = "prodlineid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int prodlineid;

    @Column(name = "stationid", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int stationid;

    //*****************************************<Getters & Setters>******************************************************

    public int getProdlineid() {
        return prodlineid;
    }

    public void setProdlineid(int prodlineid) {
        this.prodlineid = prodlineid;
    }


    public int getStationid() {
        return stationid;
    }

    public void setStationid(int stationid) {
        this.stationid = stationid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductionLineStationPK that = (ProductionLineStationPK) o;

        if (prodlineid != that.prodlineid) return false;
        if (stationid != that.stationid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prodlineid;
        result = 31 * result + stationid;
        return result;
    }
}
