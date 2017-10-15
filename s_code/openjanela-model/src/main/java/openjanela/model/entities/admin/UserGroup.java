/*******************************************************************************
 * Copyright (c) 2009 Sherif El Dibani.
 * All rights reserved. 
 *
 * Contributors:
 *     Sherif El Dibani
 *******************************************************************************/
package openjanela.model.entities.admin;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif ElDibani
 * @author Eddy Montenegro
 * @version 2.0.8
 */
@Entity
@Table(name = "user_group")
@Cacheable
public class UserGroup implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "groupleaderid", nullable = false)
    private Integer groupLeaderId;

    public UserGroup() {
    }

    public UserGroup(Integer id, String description, Integer groupLeaderId) {
        this.id = id;
        this.description = description;
        this.groupLeaderId = groupLeaderId;
    }

    //*******************************************<Getter & Setters>*****************************************************

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

    public Integer getGroupLeaderId() {
        return groupLeaderId;
    }

    public void setGroupLeaderId(Integer groupLeaderId) {
        this.groupLeaderId = groupLeaderId;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
