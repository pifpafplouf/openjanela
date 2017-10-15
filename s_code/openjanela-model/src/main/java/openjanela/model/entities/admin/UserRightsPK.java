package openjanela.model.entities.admin;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Sherif
 */
@Embeddable
public class UserRightsPK implements Serializable {

    @Column(name = "userid")
    private int userId;

    @Column(name = "actionid")
    private int actionId;

    public UserRightsPK() {
    	userId = 0;
    	actionId = 0;
    }

    public UserRightsPK(int userId, int actionId) {
        this.userId = userId;
        this.actionId = actionId;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actionId;
		result = prime * result + userId;
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
		UserRightsPK other = (UserRightsPK) obj;
		if (actionId != other.actionId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getActionId() {
		return actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

}
