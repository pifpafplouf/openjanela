package openjanela.model.entities.admin;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif ElDibani
 * @version 2.0.8
 *          Date: 04-15-13
 *          Time: 12:25 PM
 */
@Entity
@Table(name = "system_roles_action")
public class SystemRolesAction implements Serializable {

    protected SystemRolesActionPK systemRolesActionPK;

    public SystemRolesAction() {
    }

    public SystemRolesAction(SystemRolesActionPK systemRolesActionPK) {
        this.systemRolesActionPK = systemRolesActionPK;
    }

    @EmbeddedId
    public SystemRolesActionPK getSystemRolesActionPK() {
        return systemRolesActionPK;
    }

    public void setSystemRolesActionPK(SystemRolesActionPK systemRolesActionPK) {
        this.systemRolesActionPK = systemRolesActionPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (systemRolesActionPK != null ? systemRolesActionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SystemRolesAction)) {
            return false;
        }
        SystemRolesAction other = (SystemRolesAction) object;
        if ((this.systemRolesActionPK == null && other.systemRolesActionPK != null)
                || (this.systemRolesActionPK != null && !this.systemRolesActionPK.equals(other.systemRolesActionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Openjanela_PersistenceObjects.SystemRolesAction[ systemRolesActionPK=" + systemRolesActionPK + " ]";
    }

}
