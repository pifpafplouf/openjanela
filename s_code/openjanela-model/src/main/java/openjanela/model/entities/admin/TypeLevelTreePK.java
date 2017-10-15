/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package openjanela.model.entities.admin;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Sherif
 */
@Embeddable
public class TypeLevelTreePK implements Serializable {
	@Basic(optional = false)
	@Column(name = "id")
	private int id;
	@Basic(optional = false)
	@Column(name = "level_id")
	private int levelId;
	
	public TypeLevelTreePK() {
	}
	
	public TypeLevelTreePK(int id, int levelId) {
		this.id = id;
		this.levelId = levelId;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getLevelId() {
		return levelId;
	}
	
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += id;
		hash += levelId;
		return hash;
	}
	
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TypeLevelTreePK)) {
			return false;
		}
		TypeLevelTreePK other = (TypeLevelTreePK) object;
		if (this.id != other.id) {
			return false;
		}
		if (this.levelId != other.levelId) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Openjanela_Partner_PersistenceObjects.TypeLevelTreePK[ id=" + id + ", levelId=" + levelId + " ]";
	}
	
}
