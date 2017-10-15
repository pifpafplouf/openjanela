package openjanela.model.entities.admin;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 08-02-13
 *          Time: 11:17 PM
 */
@Entity
@Table(name = "user_groups")
public class UserGroups implements Serializable {

    @EmbeddedId
    private UserGroupsPK userGroupsPK;
    
    @Transient
    private String group;
    
    @Transient
    private boolean selected;
    
    public UserGroups() {
    	userGroupsPK = new UserGroupsPK();
    	group = "";
    	selected = false;
	}

	public UserGroups(UserGroupsPK userGroupsPK) {
		this.userGroupsPK = userGroupsPK;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userGroupsPK == null) ? 0 : userGroupsPK.hashCode());
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
		UserGroups other = (UserGroups) obj;
		if (userGroupsPK == null) {
			if (other.userGroupsPK != null)
				return false;
		} else if (!userGroupsPK.equals(other.userGroupsPK))
			return false;
		return true;
	}

	public UserGroupsPK getUserGroupsPK() {
        return userGroupsPK;
    }

    public void setUserGroupsPK(UserGroupsPK userGroupsPK) {
        this.userGroupsPK = userGroupsPK;
    }

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
