package openjanela.model.entities.admin;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Sherif
 */
@Embeddable
public class SystemRolesActionPK implements Serializable {

    private int roleid;
    private int actionid;

    // ==================================<GETTTER AND SETTERS>=================================================

    @Column(name = "roleid")
    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Column(name = "actionid")
    public int getActionid() {
        return actionid;
    }

    public void setActionid(int actionid) {
        this.actionid = actionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += roleid;
        hash += actionid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields
        // are not set
        if (!(object instanceof SystemRolesActionPK)) {
            return false;
        }
        SystemRolesActionPK other = (SystemRolesActionPK) object;
        if (this.roleid != other.roleid) {
            return false;
        }
        if (this.actionid != other.actionid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return roleid + " " + actionid;
    }

}

