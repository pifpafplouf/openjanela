package openjanela.model.entities.partner;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Sherif
 */
@Embeddable
public class RuleTestValuePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ruleno")
    private int ruleno;

    @Basic(optional = false)
    @Column(name = "testid")
    private int testid;

    @Basic(optional = false)
    @Column(name = "value")
    private int value;

    @Basic(optional = false)
    @Column(name = "valuei")
    private int valuei;

    @Basic(optional = false)
    @Column(name = "seriesid")
    private int seriesid;

    @Basic(optional = false)
    @Column(name = "segid")
    private int segid;

    public RuleTestValuePK() {

    }

    public RuleTestValuePK(int ruleno, int testid, int value, int valuei, int seriesid, int segid) {

        this.ruleno = ruleno;
        this.testid = testid;
        this.value = value;
        this.valuei = valuei;
        this.seriesid = seriesid;
        this.segid = segid;
    }

    public int getRuleno() {

        return ruleno;
    }

    public void setRuleno(int ruleno) {

        this.ruleno = ruleno;
    }

    public int getTestid() {

        return testid;
    }

    public void setTestid(int testid) {

        this.testid = testid;
    }

    public int getValue() {

        return value;
    }

    public void setValue(int value) {

        this.value = value;
    }

    public int getValuei() {

        return valuei;
    }

    public void setValuei(int valuei) {

        this.valuei = valuei;
    }

    public int getSeriesid() {

        return seriesid;
    }

    public void setSeriesid(int seriesid) {

        this.seriesid = seriesid;
    }

    public int getSegid() {

        return segid;
    }

    public void setSegid(int segid) {

        this.segid = segid;
    }

    @Override
    public int hashCode() {

        int hash = 0;
        hash += ruleno;
        hash += testid;
        hash += value;
        hash += valuei;
        hash += seriesid;
        hash += segid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        // TODO: Warning - this method won't work in the case the id fields
        // are not set
        if (!(object instanceof RuleTestValuePK)) {
            return false;
        }
        RuleTestValuePK other = (RuleTestValuePK) object;
        if (this.ruleno != other.ruleno) {
            return false;
        }
        if (this.testid != other.testid) {
            return false;
        }
        if (this.value != other.value) {
            return false;
        }
        if (this.valuei != other.valuei) {
            return false;
        }
        if (this.seriesid != other.seriesid) {
            return false;
        }
        if (this.segid != other.segid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return "Openjanela_Partner_PersistenceObjects.RuleTestValuePK[ ruleno=" + ruleno + ", testid=" + testid + ", value="
                + value + ", valuei=" + valuei + ", seriesid=" + seriesid + ", segid=" + segid + " ]";
    }

}