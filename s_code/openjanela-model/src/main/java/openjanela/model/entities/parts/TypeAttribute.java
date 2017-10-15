package openjanela.model.entities.parts;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Copyright (c) 2012, OpenJanela. All rights reserved.
 * User: EMontenegro
 * Date: 08-07-12
 * Time: 11:01 PM
 */
@Entity
@Table(name = "type_attribute")
public class TypeAttribute implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description = "";

    @Column(name = "system_type", nullable = false)
    private int systemType = 500;

    @Column(name = "reporting_level", nullable = false)
    private int level = 1;

    @Column(name = "report_qty", nullable = false)
    private boolean reportqty = false;

    @Transient
    private int supplierId;

    @Transient
    private boolean remote;

    public TypeAttribute() {
    }

    public TypeAttribute(String description, int systemType, int level, boolean reportqty) {
        this.description = description;
        this.systemType = systemType;
        this.level = level;
        this.reportqty = reportqty;
    }

    // ==================================<GETTERS AND SETTERS METHODS>=================================================

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

    public int getSystemType() {

        return systemType;
    }

    public void setSystemType(int systemType) {

        this.systemType = systemType;
    }

    public int getLevel() {

        return level;
    }

    public void setLevel(int level) {

        this.level = level;
    }

    public boolean isReportqty() {

        return reportqty;
    }

    public void setReportqty(boolean reportqty) {

        this.reportqty = reportqty;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public boolean isRemote() {
        return remote;
    }

    public void setRemote(boolean remote) {
        this.remote = remote;
    }

    @Override
    public String toString() {
        return description;
    }
}
