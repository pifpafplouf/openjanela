package openjanela.model.entities.partner;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Sherif ElDibani
 * @version 2.0.8
 */
@Entity
@Table(name = "option_definition")
@Cacheable
public class OptionDefinitions implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "type_id", nullable = true)
    private Integer type_id;

    @Column(name = "forced", nullable = true)
    private Boolean forced;

    @Column(name = "print_details", nullable = false)
    private Boolean printDetails;

    @Transient
    private int supplierID;

    @Transient
    private boolean remote;

    /**
     * Option Definitions constructor
     */
    public OptionDefinitions() {
    }

    /**
     * Option Definitions constructor
     *
     * @param id, Integer
     */
    public OptionDefinitions(Integer id) {
        this.id = id;
    }

    /**
     * Option Definitions constructor
     *
     * @param id,          Option Definitions Identification
     * @param description, Description
     */
    public OptionDefinitions(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public OptionDefinitions(Integer id, String description, Integer type_id, Boolean forced, Boolean printDetails) {
        this.id = id;
        this.description = description;
        this.type_id = type_id;
        this.forced = forced;
        this.printDetails = printDetails;
    }

    // ==================================<GETTTER AND SETTERS>=================================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptions() {
        return description;
    }

    public void setOptions(String options) {
        this.description = options;
    }

    public Integer getOptiontypeid() {
        return type_id;
    }

    public void setOptiontypeid(Integer optiontypeid) {
        this.type_id = optiontypeid;
    }

    public Boolean getMustanswer() {
        return forced;
    }

    public void setMustanswer(Boolean mustanswer) {
        this.forced = mustanswer;
    }

    public Boolean getForced() {
        return forced;
    }

    public void setForced(Boolean forced) {
        this.forced = forced;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPrintDetails() {
        return printDetails;
    }

    public void setPrintDetails(Boolean printDetails) {
        this.printDetails = printDetails;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof OptionDefinitions)) {
            return false;
        }
        OptionDefinitions other = (OptionDefinitions) object;
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
