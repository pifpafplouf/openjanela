package openjanela.model.entities.admin;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Copyright (c) 2011- 2013 OpenJanela LLC. All rights reserved.
 *
 * @author Consultant
 * @version 2.0.8
 *          Date Initial: 03-26-14
 *          Time Initial: 06:39 PM
 */
@Entity
@Table(name = "system_module_action")
public class SystemModuleAction implements Serializable {

	@EmbeddedId
    protected SystemModuleActionPK systemModuleActionPK;

	@Column(name = "description")
    private String description;

	public SystemModuleAction() {
	}

	public SystemModuleAction(SystemModuleActionPK systemModuleActionPK,
			String description) {
		super();
		this.systemModuleActionPK = systemModuleActionPK;
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime
				* result
				+ ((systemModuleActionPK == null) ? 0 : systemModuleActionPK
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemModuleAction other = (SystemModuleAction) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (systemModuleActionPK == null) {
			if (other.systemModuleActionPK != null)
				return false;
		} else if (!systemModuleActionPK.equals(other.systemModuleActionPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return description;
	}

	public SystemModuleActionPK getSystemModuleActionPK() {
		return systemModuleActionPK;
	}

	public void setSystemModuleActionPK(SystemModuleActionPK systemModuleActionPK) {
		this.systemModuleActionPK = systemModuleActionPK;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
