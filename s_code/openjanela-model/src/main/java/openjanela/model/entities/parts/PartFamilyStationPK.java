package openjanela.model.entities.parts;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.1.1
 *          Date: 10/24/13
 *          Time: 12:54 AM
 */
@Embeddable
public class PartFamilyStationPK implements Serializable {

    @Column(name = "part_family_id", nullable = false)
    private Integer partFamilyId;

    @Column(name = "station_id", nullable = false)
    private Integer stationId;

    /**
     * Part Family Station PK Constructor
     */
    public PartFamilyStationPK() {
    }

    /**
     * Part Family Station PK Constructor
     *
     * @param partFamilyId, Part Family Identification Id
     * @param stationId,    Station Identification Id
     */
    public PartFamilyStationPK(Integer partFamilyId, Integer stationId) {
        this.partFamilyId = partFamilyId;
        this.stationId = stationId;
    }

    //********************************************<Getters & Setters>***************************************************

    public Integer getPartFamilyId() {
        return partFamilyId;
    }

    public void setPartFamilyId(Integer partFamilyId) {
        this.partFamilyId = partFamilyId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }
}
