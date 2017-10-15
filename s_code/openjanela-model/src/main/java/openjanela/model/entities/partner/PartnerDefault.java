package openjanela.model.entities.partner;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author Sherif
 */
@Entity
@Table(name = "partner_default")
@Cacheable
public class PartnerDefault implements Serializable {

    @EmbeddedId
    protected PartnerDefaultPK partnerDefaultPK;

    @Basic(optional = false)
    @Column(name = "answer")
    private int answer;

    public PartnerDefault() {
    }

    public PartnerDefault(PartnerDefaultPK partnerDefaultPK) {
        this.partnerDefaultPK = partnerDefaultPK;
    }

    public PartnerDefault(PartnerDefaultPK partnerDefaultPK, int answer) {
        this.partnerDefaultPK = partnerDefaultPK;
        this.answer = answer;
    }

    public PartnerDefault(int partnerid, int defaulttype, int options) {
        this.partnerDefaultPK = new PartnerDefaultPK(partnerid, defaulttype, options);
    }

    public PartnerDefaultPK getPartnerDefaultPK() {

        return partnerDefaultPK;
    }

    public void setPartnerDefaultPK(PartnerDefaultPK partnerDefaultPK) {

        this.partnerDefaultPK = partnerDefaultPK;
    }

    public int getAnswer() {

        return answer;
    }

    public void setAnswer(int answer) {

        this.answer = answer;
    }

    @Override
    public int hashCode() {

        int hash = 0;
        hash += (partnerDefaultPK != null ? partnerDefaultPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        // TODO: Warning - this method won't work in the case the id fields
        // are not set
        if (!(object instanceof PartnerDefault)) {
            return false;
        }
        PartnerDefault other = (PartnerDefault) object;
        if ((this.partnerDefaultPK == null && other.partnerDefaultPK != null)
                || (this.partnerDefaultPK != null && !this.partnerDefaultPK.equals(other.partnerDefaultPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Openjanela_Partner_PersistenceObjects.PartnerDefault[ partnerDefaultPK=" + partnerDefaultPK + " ]";
    }

}
