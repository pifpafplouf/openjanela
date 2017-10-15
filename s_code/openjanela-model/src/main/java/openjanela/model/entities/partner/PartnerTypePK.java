package openjanela.model.entities.partner;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: emortiz
 * Date: 07-26-12
 * Time: 11:58 AM
 */
@Embeddable
public class PartnerTypePK implements Serializable {

    /**
     * PROPERTY NAME: Partner Identification Key
     */
    private Integer partnerId;
    /**
     * PROPERTY NAME: Type Partner Identification Key
     */
    private Integer typePartnerId;

    // ==================================<GETTTER AND SETTERS>=================================================

    @Column(name = "partner_id", nullable = false)
    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    @Column(name = "type_id", nullable = false)
    public Integer getTypePartnerId() {
        return typePartnerId;
    }

    public void setTypePartnerId(Integer typePartnerId) {
        this.typePartnerId = typePartnerId;
    }
}
