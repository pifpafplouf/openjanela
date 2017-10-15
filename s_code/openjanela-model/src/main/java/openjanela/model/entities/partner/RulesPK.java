package openjanela.model.entities.partner;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Sherif
 */
@Embeddable
public class RulesPK implements Serializable {
	
	@Basic(optional = false)
	@Column(name = "id")
	private int id;
	
	@Basic(optional = false)
	@Column(name = "series_id")
	private int seriesId;
	
	/**
	 * Default Constructor RulesPK
	 */
	public RulesPK() {
	}
	
	/**
	 * RulesPK Constructor
	 *
	 * @param id,       Identification Id
	 * @param seriesId, Series Identification Id
	 * @param segid,    Seg Identification Id
	 */
	public RulesPK(int id, int seriesId, int segid) {
		this.id = id;
		this.seriesId = seriesId;

	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getSeriesId() {
		return seriesId;
	}
	
	public void setSeriesId(int seriesId) {
		this.seriesId = seriesId;
	}
	
	
	@Override
	public int hashCode() {
		
		int hash = 0;
		hash += id;
		hash += seriesId;
		
		return hash;
	}
	
	@Override
	public boolean equals(Object object) {
		
		// TODO: Warning - this method won't work in the case the id fields
		// are not set
		if (!(object instanceof RulesPK)) {
			return false;
		}
		RulesPK other = (RulesPK) object;
		if (this.id != other.id) {
			return false;
		}
		if (this.seriesId != other.seriesId) {
			return false;
		}
		
		return true;
	}
	
	

}
