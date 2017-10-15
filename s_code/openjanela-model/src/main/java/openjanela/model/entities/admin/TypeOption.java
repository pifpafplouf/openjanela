package openjanela.model.entities.admin;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif ElDibani
 * @version 2.0.8
 *          Date: 04-15-13
 *          Time: 12:25 PM
 */
@Entity
@Table(name = "type_option")
@Cacheable
public class TypeOption implements Serializable {
	
	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "description")
	private String description;

    @Column(name = "wildcard")
	private String wildcard;
	
	public TypeOption() {}
	
	public TypeOption(Integer id) {
		this.id = id;
	}

    public TypeOption(Integer id, String description, String wildcard) {
        this.id = id;
        this.description = description;
        this.wildcard = wildcard;
    }

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
	
	public String getWildcard() {
		return wildcard;
	}
	
	public void setWildcard(String wildcard) {
		this.wildcard = wildcard;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof TypeOption)) {
			return false;
		}
		TypeOption other = (TypeOption) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return this.description;
	}
	
	
}
