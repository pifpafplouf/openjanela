package openjanela.model.entities.admin;

import javax.persistence.*;

/**
 * Copyright (c) 2011-2013 OpenJanela LLC. All rights reserved.
 *
 * @author Eddy Montenegro
 * @version 2.0.8
 *          Date: 04-15-13
 *          Time: 09:31 PM
 */
@Entity
@Table(name = "type_default")
@Cacheable
public class TypeDefault {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "sqlopen1", nullable = true)
    private String sqlOpen_1;

    @Column(name = "sqlopen2", nullable = true)
    private String sqlOpen_2;

    @Column(name = "sqlcmb1", nullable = true)
    private String sqlCmb_1;

    @Column(name = "sqlcmb2", nullable = true)
    private String sqlCmb_2;

    public TypeDefault() {
    }

    public TypeDefault(Integer id, String description, String sqlOpen_1, String sqlOpen_2, String sqlCmb_1, String sqlCmb_2) {
        this.id = id;
        this.description = description;
        this.sqlOpen_1 = sqlOpen_1;
        this.sqlOpen_2 = sqlOpen_2;
        this.sqlCmb_1 = sqlCmb_1;
        this.sqlCmb_2 = sqlCmb_2;
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

    public String getSqlOpen_1() {
        return sqlOpen_1;
    }

    public void setSqlOpen_1(String sqlOpen_1) {
        this.sqlOpen_1 = sqlOpen_1;
    }

    public String getSqlOpen_2() {
        return sqlOpen_2;
    }

    public void setSqlOpen_2(String sqlOpen_2) {
        this.sqlOpen_2 = sqlOpen_2;
    }

    public String getSqlCmb_1() {
        return sqlCmb_1;
    }

    public void setSqlCmb_1(String sqlCmb_1) {
        this.sqlCmb_1 = sqlCmb_1;
    }

    public String getSqlCmb_2() {
        return sqlCmb_2;
    }

    public void setSqlCmb_2(String sqlCmb_2) {
        this.sqlCmb_2 = sqlCmb_2;
    }
}
