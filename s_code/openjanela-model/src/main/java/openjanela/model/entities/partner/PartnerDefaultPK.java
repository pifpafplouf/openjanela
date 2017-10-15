/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package openjanela.model.entities.partner;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Sherif
 */
@Embeddable
public class PartnerDefaultPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "partnerid")
    private int partnerid;

    @Basic(optional = false)
    @Column(name = "defaulttype")
    private int defaulttype;

    @Basic(optional = false)
    @Column(name = "options")
    private int options;

    public PartnerDefaultPK() {
    }

    public PartnerDefaultPK(int partnerid, int defaulttype, int options) {
        this.partnerid = partnerid;
        this.defaulttype = defaulttype;
        this.options = options;
    }

    public int getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(int partnerid) {
        this.partnerid = partnerid;
    }

    public int getDefaulttype() {
        return defaulttype;
    }

    public void setDefaulttype(int defaulttype) {
        this.defaulttype = defaulttype;
    }

    public int getOptions() {
        return options;
    }

    public void setOptions(int options) {
        this.options = options;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += partnerid;
        hash += defaulttype;
        hash += options;
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof PartnerDefaultPK)) {
            return false;
        }
        PartnerDefaultPK other = (PartnerDefaultPK) object;
        if (this.partnerid != other.partnerid) {
            return false;
        }
        if (this.defaulttype != other.defaulttype) {
            return false;
        }
        if (this.options != other.options) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Openjanela_Partner_PersistenceObjects.PartnerDefaultPK[ partnerid=" + partnerid + ", defaulttype=" + defaulttype + ", options=" + options + " ]";
    }

}
