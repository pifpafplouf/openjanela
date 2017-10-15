/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openjanela.model.entities.partner;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Sherif
 */
@Entity
@Table(name = "series_category")
@Cacheable
public class SeriesCategory implements Serializable {
	
	@Id
	@Column(name = "id")
	public int id;
	@Column(name = "description")
	public String description;
	
	@Column(name = "series_type")
	public int series_type;

    public SeriesCategory() {
    }

    public SeriesCategory(int id, String description, int series_type) {
        this.id = id;
        this.description = description;
        this.series_type = series_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSeries_type() {
        return series_type;
    }

    public void setSeries_type(int series_type) {
        this.series_type = series_type;
    }

    @Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SeriesCategory)) {
			return false;
		}
		SeriesCategory other = (SeriesCategory) object;
		if (this.id == other.id)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.description;
	}
	
	
}
