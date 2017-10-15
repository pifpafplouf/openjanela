package openjanela.model.entities.partner;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Sherif
 */
@Entity
@Table(name = "rule_test_value")
@Cacheable
public class RuleTestValue implements Serializable {

    @EmbeddedId
    protected RuleTestValuePK ruleTestValuePK;

    public RuleTestValue() {
    }

    public RuleTestValue(RuleTestValuePK ruleTestValuePK) {
        this.ruleTestValuePK = ruleTestValuePK;
    }

    public RuleTestValue(int ruleno, int testid, int value, int valuei, int seriesid, int segid) {
        this.ruleTestValuePK = new RuleTestValuePK(ruleno, testid, value, valuei, seriesid, segid);
    }

    public RuleTestValuePK getRuleTestValuePK() {

        return ruleTestValuePK;
    }

    public void setRuleTestValuePK(RuleTestValuePK ruleTestValuePK) {

        this.ruleTestValuePK = ruleTestValuePK;
    }

    @Override
    public int hashCode() {

        int hash = 0;
        hash += (ruleTestValuePK != null ? ruleTestValuePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        // TODO: Warning - this method won't work in the case the id fields
        // are not set
        if (!(object instanceof RuleTestValue)) {
            return false;
        }
        RuleTestValue other = (RuleTestValue) object;
        if ((this.ruleTestValuePK == null && other.ruleTestValuePK != null)
                || (this.ruleTestValuePK != null && !this.ruleTestValuePK.equals(other.ruleTestValuePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Openjanela_Partner_PersistenceObjects.RuleTestValue[ ruleTestValuePK=" + ruleTestValuePK + " ]";
    }

}