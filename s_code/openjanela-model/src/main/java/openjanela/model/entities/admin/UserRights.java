package openjanela.model.entities.admin;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif ElDibani
 * @version 2.0.8
 *          Date: 05-27-13
 *          Time: 10:04 AM
 */

@Entity
@Table(name = "user_rights")
public class UserRights implements Serializable {

    @EmbeddedId
    protected UserRightsPK userRightsPK;

    @Column(name = "moduleid")
    private int moduleId;
    
    @Transient
    private SystemModule systemModule;
    
    @Transient
    private SystemModuleAction systemModuleAction;
    
    public UserRights() {
    	userRightsPK = new UserRightsPK();
    	moduleId = 0;
    }

	public UserRights(UserRightsPK userRightsPK, int moduleId) {
		this.userRightsPK = userRightsPK;
		this.moduleId = moduleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + moduleId;
		result = prime * result
				+ ((systemModule == null) ? 0 : systemModule.hashCode());
		result = prime * result
				+ ((userRightsPK == null) ? 0 : userRightsPK.hashCode());
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
		UserRights other = (UserRights) obj;
		if (moduleId != other.moduleId)
			return false;
		if (systemModule == null) {
			if (other.systemModule != null)
				return false;
		} else if (!systemModule.equals(other.systemModule))
			return false;
		if (userRightsPK == null) {
			if (other.userRightsPK != null)
				return false;
		} else if (!userRightsPK.equals(other.userRightsPK))
			return false;
		return true;
	}

	public UserRightsPK getUserRightsPK() {
		return userRightsPK;
	}

	public void setUserRightsPK(UserRightsPK userRightsPK) {
		this.userRightsPK = userRightsPK;
	}

	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public SystemModule getSystemModule() {
		return systemModule;
	}

	public void setSystemModule(SystemModule systemModule) {
		this.systemModule = systemModule;
	}

	public SystemModuleAction getSystemModuleAction() {
		return systemModuleAction;
	}

	public void setSystemModuleAction(SystemModuleAction systemModuleAction) {
		this.systemModuleAction = systemModuleAction;
	}
    
}
