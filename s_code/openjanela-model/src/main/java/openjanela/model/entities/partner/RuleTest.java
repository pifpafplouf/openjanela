/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openjanela.model.entities.partner;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * @author Sherif
 */
@Entity
@Table(name = "rule_test")
@Cacheable
public class RuleTest implements Serializable {

    @EmbeddedId
    protected RuleTestPK ruleTestPK;

    @Basic(optional = false)
    @Column(name = "andor")
    public boolean andor;

    @Basic(optional = false)
    @Column(name = "isnot")
    public boolean isnot;

    @Basic(optional = false)
    @Column(name = "type")
    public int type;

    @Basic(optional = false)
    @Column(name = "isrange")
    public boolean isrange;

    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column(name = "value1")
    public Double value1;

    @Column(name = "value1i")
    public Double value1i;

    @Column(name = "value2")
    public Double value2;

    @Column(name = "value2i")
    public Double value2i;

    @Column(name = "next")
    public Integer next;

    @Basic(optional = false)
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    public Date startdate = new Date(System.currentTimeMillis());

    @Basic(optional = false)
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    public Date enddate = new Date(System.currentTimeMillis());

    @Column(name = "description", nullable = false)
    public String description;
    
    /*///---------------------------------
     *    0 = none, 1= start"(" , 2 = end")"
     *///---------------------------------
     
    @Column(name = "startgroup", nullable = false)
    public int startGroup; // 0 = none, 1= start"(" , 2 = end")"

    @Transient
    private int supplierId;

    @Transient
    private boolean remote;

    public RuleTest() {
    }

    public RuleTest(RuleTestPK ruleTestPK, boolean andor, boolean isnot, int type, boolean isrange, Double value1,
                    Double value1i, Double value2, Double value2i, Integer next, 
                    Date startdate, Date enddate, String description, int startg) {
        this.ruleTestPK = ruleTestPK;
        this.andor = andor;
        this.isnot = isnot;
        this.type = type;
        this.isrange = isrange;
        this.value1 = value1;
        this.value1i = value1i;
        this.value2 = value2;
        this.value2i = value2i;
        this.next = next;
        this.startdate = startdate;
        this.enddate = enddate;
        this.description = description;
        this.startGroup = startg;
    }

    //****************************************<Getters & Setters>*******************************************************

    public RuleTestPK getRuleTestPK() {
        return ruleTestPK;
    }

    public void setRuleTestPK(RuleTestPK ruleTestPK) {
        this.ruleTestPK = ruleTestPK;
    }

    public boolean getAndor() {
        return andor;
    }

    public void setAndor(boolean andor) {
        this.andor = andor;
    }

    public boolean getIsnot() {
        return isnot;
    }

    public void setIsnot(boolean isnot) {
        this.isnot = isnot;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean getIsrange() {
        return isrange;
    }

    public void setIsrange(boolean isrange) {
        this.isrange = isrange;
    }

    public Double getValue1() {
        return value1;
    }

    public void setValue1(Double value1) {
        this.value1 = value1;
    }

    public Double getValue1i() {
        return value1i;
    }

    public void setValue1i(Double value1i) {
        this.value1i = value1i;
    }

    public Double getValue2() {
        return value2;
    }

    public void setValue2(Double value2) {
        this.value2 = value2;
    }

    public Double getValue2i() {
        return value2i;
    }

    public void setValue2i(Double value2i) {
        this.value2i = value2i;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStartGroup() {
		return startGroup;
	}

	public void setStartGroup(int startGroup) {
		this.startGroup = startGroup;
	}

	public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    @Override
    public int hashCode() {

        int hash = 0;
        hash += (ruleTestPK != null ? ruleTestPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof RuleTest)) {
            return false;
        }
        RuleTest other = (RuleTest) object;
        if ((this.ruleTestPK == null && other.ruleTestPK != null)
                || (this.ruleTestPK != null && !this.ruleTestPK.equals(other.ruleTestPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Openjanela_Partner_PersistenceObjects.RuleTest[ ruleTestPK=" + ruleTestPK + " ]";
    }

}
