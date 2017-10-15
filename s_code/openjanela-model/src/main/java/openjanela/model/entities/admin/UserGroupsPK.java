package openjanela.model.entities.admin;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 08-02-13
 *          Time: 11:18 PM
 */
@Embeddable
public class UserGroupsPK implements Serializable {

    @Column(name = "userid", nullable = false)
    private Integer userId;

    @Column(name = "groupid", nullable = false)
    private Integer groupId;

    /**
     * Create User Groups
     */
    public UserGroupsPK() {
    	userId = 0;
    	groupId = 0;
    }

    /**
     * Create User Groups
     *
     * @param userId,  User Identification Id
     * @param groupId, Group Identification Id
     */
    public UserGroupsPK(Integer userId, Integer groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		UserGroupsPK other = (UserGroupsPK) obj;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
