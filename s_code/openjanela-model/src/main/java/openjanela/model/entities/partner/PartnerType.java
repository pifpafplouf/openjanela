package openjanela.model.entities.partner;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 07-26-12
 * Time: 11:56 AM
 */
@Entity
@Table(name = "partner_type")
public class PartnerType implements Serializable {

    /**
     * PROPERTY NAME: Primary key Identification Many To Many Partner and TypePartner
     */
    private PartnerTypePK id;

    public PartnerType() {
    }

    public PartnerType(PartnerTypePK id) {
        this.id = id;
    }

    // ==================================<GETTTER AND SETTERS>=================================================

    @EmbeddedId
    public PartnerTypePK getId() {
        return id;
    }

    public void setId(PartnerTypePK id) {
        this.id = id;
    }
}
