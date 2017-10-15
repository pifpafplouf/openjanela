package openjanela.model.entities.admin;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "type_opening")
@Cacheable
public class TypeOpening implements Serializable {
	
	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "abbrev", nullable = false)
	private String abbrev;

	@Column(name = "picture", nullable = false)
	private boolean picture;

	@Column(name = "outswing", nullable = false)
	private boolean outswing;

	@Column(name = "inswing", nullable = false)
	private boolean inswing;

	@Column(name = "sslider", nullable = false)
	private boolean sslider;

	@Column(name = "dslider", nullable = false)
	private boolean dslider;

	@Column(name = "nslider", nullable = false)
	private boolean nslider;

	@Column(name = "folding", nullable = false)
	private boolean folding;

	@Column(name = "transom", nullable = false)
	private boolean transom;

	@Column(name = "sidelight", nullable = false)
	private boolean sidelight;

	@Column(name = "kickpanel", nullable = false)
	private boolean kickpanel;

	@Column(name = "pocket", nullable = false)
	private boolean pocket;

	@Column(name = "pivot", nullable = false)
	private boolean pivot;

	@Column(name = "louvered", nullable = false)
	private boolean louvered;

	@Column(name = "window", nullable = false)
	private boolean window;

	@Column(name = "door", nullable = false)
	private boolean door;

	@Column(name = "entrance", nullable = false)
	private boolean entrance;

	@Column(name = "standard", nullable = false)
	private boolean standard;

    public TypeOpening() {
    }

    public TypeOpening(Integer id, String description, String abbrev, boolean picture, boolean outswing, boolean inswing,
                       boolean sslider, boolean dslider, boolean nslider, boolean folding, boolean transom, boolean sidelight,
                       boolean kickpanel, boolean pocket, boolean pivot, boolean louvered, boolean window, boolean door,
                       boolean entrance, boolean standard) {
        this.id = id;
        this.description = description;
        this.abbrev = abbrev;
        this.picture = picture;
        this.outswing = outswing;
        this.inswing = inswing;
        this.sslider = sslider;
        this.dslider = dslider;
        this.nslider = nslider;
        this.folding = folding;
        this.transom = transom;
        this.sidelight = sidelight;
        this.kickpanel = kickpanel;
        this.pocket = pocket;
        this.pivot = pivot;
        this.louvered = louvered;
        this.window = window;
        this.door = door;
        this.entrance = entrance;
        this.standard = standard;
    }

    //****************************************<SETTERS & GETTERS>******************************************************

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    public boolean isPicture() {
        return picture;
    }

    public void setPicture(boolean picture) {
        this.picture = picture;
    }

    public boolean isOutswing() {
        return outswing;
    }

    public void setOutswing(boolean outswing) {
        this.outswing = outswing;
    }

    public boolean isInswing() {
        return inswing;
    }

    public void setInswing(boolean inswing) {
        this.inswing = inswing;
    }

    public boolean isSslider() {
        return sslider;
    }

    public void setSslider(boolean sslider) {
        this.sslider = sslider;
    }

    public boolean isDslider() {
        return dslider;
    }

    public void setDslider(boolean dslider) {
        this.dslider = dslider;
    }

    public boolean isNslider() {
        return nslider;
    }

    public void setNslider(boolean nslider) {
        this.nslider = nslider;
    }

    public boolean isFolding() {
        return folding;
    }

    public void setFolding(boolean folding) {
        this.folding = folding;
    }

    public boolean isTransom() {
        return transom;
    }

    public void setTransom(boolean transom) {
        this.transom = transom;
    }

    public boolean isSidelight() {
        return sidelight;
    }

    public void setSidelight(boolean sidelight) {
        this.sidelight = sidelight;
    }

    public boolean isKickpanel() {
        return kickpanel;
    }

    public void setKickpanel(boolean kickpanel) {
        this.kickpanel = kickpanel;
    }

    public boolean isPocket() {
        return pocket;
    }

    public void setPocket(boolean pocket) {
        this.pocket = pocket;
    }

    public boolean isPivot() {
        return pivot;
    }

    public void setPivot(boolean pivot) {
        this.pivot = pivot;
    }

    public boolean isLouvered() {
        return louvered;
    }

    public void setLouvered(boolean louvered) {
        this.louvered = louvered;
    }

    public boolean isWindow() {
        return window;
    }

    public void setWindow(boolean window) {
        this.window = window;
    }

    public boolean isDoor() {
        return door;
    }

    public void setDoor(boolean door) {
        this.door = door;
    }

    public boolean isEntrance() {
        return entrance;
    }

    public void setEntrance(boolean entrance) {
        this.entrance = entrance;
    }

    public boolean isStandard() {
        return standard;
    }

    public void setStandard(boolean standard) {
        this.standard = standard;
    }

    @Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof TypeOpening)) {
			return false;
		}
		TypeOpening other = (TypeOpening) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return this.description + " : " + this.abbrev;
	}
	
}
