package openjanela.model.entities.partner;


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Sherif
 */
@Embeddable
public class RuleAnswersPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "seriesid")
    private int seriesid;

    @Basic(optional = false)
    @Column(name = "ruleno")
    private int ruleno;

    @Basic(optional = false)
    @Column(name = "answerid")
    private int answerid;

    @Basic(optional = false)
    @Column(name = "segid")
    private int segid;

    public RuleAnswersPK() {

    }

    public RuleAnswersPK(int seriesid, int ruleno, int answerid, int segid) {

        this.seriesid = seriesid;
        this.ruleno = ruleno;
        this.answerid = answerid;
        this.segid = segid;
    }

    public int getSeriesid() {

        return seriesid;
    }

    public void setSeriesid(int seriesid) {

        this.seriesid = seriesid;
    }

    public int getRuleno() {

        return ruleno;
    }

    public void setRuleno(int ruleno) {

        this.ruleno = ruleno;
    }

    public int getAnswerid() {

        return answerid;
    }

    public void setAnswerid(int answerid) {

        this.answerid = answerid;
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
        hash += seriesid;
        hash += ruleno;
        hash += answerid;
        hash += segid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        // TODO: Warning - this method won't work in the case the id fields
        // are not set
        if (!(object instanceof RuleAnswersPK)) {
            return false;
        }
        RuleAnswersPK other = (RuleAnswersPK) object;
        if (this.seriesid != other.seriesid) {
            return false;
        }
        if (this.ruleno != other.ruleno) {
            return false;
        }
        if (this.answerid != other.answerid) {
            return false;
        }
        if (this.segid != other.segid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return "Openjanela_Partner_PersistenceObjects.RuleAnswersPK[ seriesid=" + seriesid + ", ruleno=" + ruleno
                + ", answerid=" + answerid + ", segid=" + segid + " ]";
    }

}
