package openjanela.model.entities.admin;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 05-27-13
 *          Time: 10:04 AM
 */
@Entity
@Table(name = "type_process")
@Cacheable
public class TypeProcess implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "in_house", nullable = false)
    private boolean inHouse;

    @Column(name = "provider_id", nullable = false)
    private int providerId;

    @Column(name = "process_lt", nullable = false)
    private int processLt;

    public TypeProcess() {
    }

    public TypeProcess(Integer id, String description, boolean inHouse, int providerId, int processLt) {
        this.id = id;
        this.description = description;
        this.inHouse = inHouse;
        this.providerId = providerId;
        this.processLt = processLt;
    }

    //********************************************<Getters & Setters>***************************************************

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

    public boolean isInHouse() {
        return inHouse;
    }

    public void setInHouse(boolean inHouse) {
        this.inHouse = inHouse;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public int getProcessLt() {
        return processLt;
    }

    public void setProcessLt(int processLt) {
        this.processLt = processLt;
    }
}
