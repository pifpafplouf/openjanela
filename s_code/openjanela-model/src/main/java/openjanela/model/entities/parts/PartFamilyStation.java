package openjanela.model.entities.parts;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright (c) 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 10/24/13
 *          Time: 12:53 AM
 */
@Entity
@Table(name = "parts_family_station")
public class PartFamilyStation implements Serializable {

    @EmbeddedId
    private PartFamilyStationPK partFamilyStationPK;

    //********************************************<Getters & Setters>**************************************************

    public PartFamilyStationPK getPartFamilyStationPK() {
        return partFamilyStationPK;
    }

    public void setPartFamilyStationPK(PartFamilyStationPK partFamilyStationPK) {
        this.partFamilyStationPK = partFamilyStationPK;
    }
}
