/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openjanela.model.entities.partner;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Sherif
 */
@Entity
@Table(name = "rule_answers")
public class RuleAnswers implements Serializable {

    @EmbeddedId
    private RuleAnswersPK ruleAnswersPK;

    public RuleAnswers() {}

    public RuleAnswers(RuleAnswersPK ruleAnswersPK) {
        this.ruleAnswersPK = ruleAnswersPK;
    }

    public RuleAnswers(int seriesid, int ruleno, int answerid, int segid) {
        this.ruleAnswersPK = new RuleAnswersPK(seriesid, ruleno, answerid, segid);
    }

    public RuleAnswersPK getRuleAnswersPK() {
        return ruleAnswersPK;
    }

    public void setRuleAnswersPK(RuleAnswersPK ruleAnswersPK) {
        this.ruleAnswersPK = ruleAnswersPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruleAnswersPK != null ? ruleAnswersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        // TODO: Warning - this method won't work in the case the id fields
        // are not set
        if (!(object instanceof RuleAnswers)) {
            return false;
        }
        RuleAnswers other = (RuleAnswers) object;
        if ((this.ruleAnswersPK == null && other.ruleAnswersPK != null)
                || (this.ruleAnswersPK != null && !this.ruleAnswersPK.equals(other.ruleAnswersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Openjanela_Partner_PersistenceObjects.RuleAnswers[ ruleAnswersPK=" + ruleAnswersPK + " ]";
    }

}
