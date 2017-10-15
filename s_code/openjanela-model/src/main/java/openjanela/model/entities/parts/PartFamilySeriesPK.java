package openjanela.model.entities.parts;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: EMontenegro
 * Date: 10-31-12
 * Time: 08:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class PartFamilySeriesPK implements Serializable {

    @Column(name = "partfamily", nullable = false)
    private int partfamily = 0;

    @Column(name = "seriesid", nullable = false)
    private int seriesid = 0;

    public PartFamilySeriesPK() {
    }

    public PartFamilySeriesPK(int pf, int sid) {
        this.partfamily = pf;
        this.seriesid = sid;
    }

    public int getPartFamily() {
        return partfamily;
    }

    public void setPartFamily(int pf) {
        this.partfamily = pf;
    }

    public int getSeriesID() {
        return seriesid;
    }

    public void setSeriesID(int sid) {
        this.seriesid = sid;
    }
    
    @Override
	public boolean equals(Object object) {
		
		// TODO: Warning - this method won't work in the case the id fields
		// are not set
		if (!(object instanceof PartFamilySeriesPK)) {
			return false;
		}
		PartFamilySeriesPK other = (PartFamilySeriesPK) object;
		if (this.getPartFamily() == other.getPartFamily() && 
				this.getSeriesID() == other.getSeriesID()) {
			return true;
		}
		return false;
	}
}
