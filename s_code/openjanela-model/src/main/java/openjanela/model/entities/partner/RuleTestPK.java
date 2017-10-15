package openjanela.model.entities.partner;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Sherif
 */
@Embeddable
public class RuleTestPK implements Serializable {
	
	@Basic(optional = false)
	@Column(name = "ruleno")
	private int ruleno;
	
	@Basic(optional = false)
	@Column(name = "testid")
	private int testid;
	
	@Basic(optional = false)
	@Column(name = "seriesid")
	private int seriesid;
	
	public RuleTestPK() {
	}
	
	public RuleTestPK(int ruleno, int testid, int seriesid) {
		this.ruleno = ruleno;
		this.testid = testid;
		this.seriesid = seriesid;
		
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
	
	public int getSeriesid() {
		
		return seriesid;
	}
	
	public void setSeriesid(int seriesid) {
		
		this.seriesid = seriesid;
	}
	
	
	@Override
	public int hashCode() {
		
		int hash = 0;
		hash += ruleno;
		hash += testid;
		hash += seriesid;

		return hash;
	}
	
	@Override
	public boolean equals(Object object) {
		
		// TODO: Warning - this method won't work in the case the id fields
		// are not set
		if (!(object instanceof RuleTestPK)) {
			return false;
		}
		RuleTestPK other = (RuleTestPK) object;
		if (this.ruleno != other.ruleno) {
			return false;
		}
		if (this.testid != other.testid) {
			return false;
		}
		if (this.seriesid != other.seriesid) {
			return false;
		}

		return true;
	}
	
	@Override
	public String toString() {
		
		return "Openjanela_Partner_PersistenceObjects.RuleTestPK[ ruleno=" + ruleno + ", testid=" + testid + ", seriesid="
					+ seriesid + " ]";
	}
	
}
